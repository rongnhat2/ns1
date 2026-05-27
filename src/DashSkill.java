import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * Kỹ năng dash: double-tap trái/phải, lướt theo hướng.
 * <p>
 * Save (frozen): tail +1 learned, +3 {@link #getLevel()} — xem {@code SaveLayout.md}.
 * </p>
 */
public final class DashSkill extends SkillTemplate implements TickingSkill {

   public static final int STATE_DASH = 25;

   /** Cửa sổ double-tap (ms) — không đổi feel input. */
   public static final int DOUBLE_TAP_MS = 420;
   /** Quãng đường dash (px) — không đổi. */
   public static final int DISTANCE = 112;

   /** Neo vẽ sprite dash (cùng offset thân khi chạy {@code aq[2]}). */
   private static final int SPRITE_ANCHOR_X = -10;
   private static final int SPRITE_ANCHOR_Y = 32;

   private static final DashSkill INSTANCE = new DashSkill();

   private long lastTapMillisLeft = -999999L;
   private long lastTapMillisRight = -999999L;
   private int pixelsRemaining;
   private long startMillis;
   private int pendingDirection;

   private int level = 1;
   /** {@code 0} = công thức {@code 8 + level×6}. */
   private int manaCostOverride;
   private int durationMs = 200;

   private static Image dashSprite;
   private static boolean dashSpriteTried;

   private DashSkill() {
      setBaseManaCost(0);
   }

   public static DashSkill getInstance() {
      return INSTANCE;
   }

   public static boolean isPlayerDashing(int state) {
      return state == STATE_DASH;
   }

   public int getLevel() {
      return level;
   }

   public void setLevel(int value) {
      level = value < 1 ? 1 : value;
      syncDurationToLevel();
   }

   public int getManaCostOverride() {
      return manaCostOverride;
   }

   public void setManaCostOverride(int cost) {
      manaCostOverride = cost;
   }

   public int getDurationMs() {
      return durationMs > 0 ? durationMs : 200;
   }

   /** Cấp cao = dash nhanh hơn (giữ công thức cũ trong {@link a#syncDashDurationToLevel}). */
   public void syncDurationToLevel() {
      int lv = level < 1 ? 1 : level;
      durationMs = lv >= 10 ? 48 : 360 - lv * 32;
   }

   protected boolean showNotLearnedMessage() {
      return false;
   }

   protected int getManaCost(SkillContext ctx) {
      return resolveManaCost();
   }

   /** Cho verify / debug — cùng công thức {@link #getManaCost}. */
   public int resolveManaCost() {
      if (manaCostOverride > 0) {
         return manaCostOverride;
      }
      int lv = level < 1 ? 1 : level;
      return 8 + lv * 6;
   }

   protected boolean canUse(SkillContext ctx) {
      if (!ctx.isGameplay()) {
         return false;
      }
      if (!isOffCooldown()) {
         return false;
      }
      int st = ctx.getPlayerState();
      if (st == STATE_DASH || st == 5 || st == 3) {
         return false;
      }
      if (st != 1 && st != 2 && st != 4) {
         return false;
      }
      if (st == 4 && a.skillBridgeGetFallZ() > 6) {
         return false;
      }
      if (ctx.getPlayerMp() < getManaCost(ctx)) {
         ctx.showMessage("Không đủ MP!");
         return false;
      }
      return a.skillBridgeDashFeetOnGround();
   }

   protected boolean onActivate(SkillContext ctx) {
      int dir = pendingDirection;
      ctx.setPlayerFacing(dir);
      a.skillBridgeSetPlayerState(STATE_DASH);
      pixelsRemaining = DISTANCE;
      startMillis = System.currentTimeMillis();
      a.skillBridgeResetMoveVelocity();
      a.skillBridgeClearInteractHint();
      ctx.requestRepaint();
      a.skillBridgeDashRunFx(dir, ctx.getPlayerX());
      return true;
   }

   protected void onLearned(SkillContext ctx) {
      if (level < 1) {
         level = 1;
      }
      syncDurationToLevel();
   }

   /** Cooldown = đang dash (không kích hoạt lại giữa chừng). */
   public boolean isOffCooldown() {
      return !isActive();
   }

   /**
    * Phím tấn công (5) trong lúc dash: hủy dash, chuyển combat — giống state 3/4.
    * @return {@code true} nếu đã xử lý
    */
   public boolean cancelForCombat(SkillContext ctx) {
      if (!isActive()) {
         return false;
      }
      pixelsRemaining = 0;
      a.skillBridgeSetPlayerState(5);
      a.skillBridgeResetMoveVelocity();
      a.skillBridgeSetCombatAttackPhase();
      ctx.requestRepaint();
      return true;
   }

   /** Bấm phím hướng 4 (trái) hoặc 6 (phải); {@code true} = đã dash, chặn di chuyển thường. */
   public boolean onDirectionKey(int keyCode) {
      if (!isLearned() || !GameSkillContext.INSTANCE.isGameplay()) {
         return false;
      }
      long now = System.currentTimeMillis();
      long last = keyCode == 4 ? lastTapMillisLeft : lastTapMillisRight;
      int dir = keyCode == 4 ? -1 : 1;
      boolean doubleTap = now - last <= (long) DOUBLE_TAP_MS && now - last >= 0L;
      if (keyCode == 4) {
         lastTapMillisLeft = now;
      } else {
         lastTapMillisRight = now;
      }
      if (!doubleTap) {
         return false;
      }
      pendingDirection = dir;
      return tryActivate(GameSkillContext.INSTANCE);
   }

   public void tick(SkillContext ctx) {
      if (!isActive()) {
         return;
      }
      int duration = getDurationMs();
      long elapsed = System.currentTimeMillis() - startMillis;
      if (pixelsRemaining <= 0) {
         endDash(ctx);
         return;
      }
      int movedBefore = DISTANCE - pixelsRemaining;
      int movedTarget = (int) ((long) DISTANCE * elapsed / (long) duration);
      if (movedTarget > DISTANCE) {
         movedTarget = DISTANCE;
      }
      if (elapsed >= (long) duration) {
         movedTarget = DISTANCE;
      }
      int step = movedTarget - movedBefore;
      if (step <= 0) {
         ctx.requestRepaint();
         return;
      }
      if (step > pixelsRemaining) {
         step = pixelsRemaining;
      }
      int facing = ctx.getPlayerFacing();
      int nextX = ctx.getPlayerX() + facing * step;
      if (facing == 1) {
         if (a.skillBridgeWallRight(nextX, ctx.getPlayerY())) {
            ctx.setPlayerPosition(a.skillBridgeSnapXFromWallRight(nextX), ctx.getPlayerY());
            pixelsRemaining = 0;
         } else {
            ctx.setPlayerPosition(nextX, ctx.getPlayerY());
            pixelsRemaining -= step;
         }
      } else {
         if (a.skillBridgeWallLeft(nextX, ctx.getPlayerY())) {
            ctx.setPlayerPosition(a.skillBridgeSnapXFromWallLeft(nextX), ctx.getPlayerY());
            pixelsRemaining = 0;
         } else {
            ctx.setPlayerPosition(nextX, ctx.getPlayerY());
            pixelsRemaining -= step;
         }
      }
      a.skillBridgeDashAfterMove();
      a.skillBridgeDashRunFx(facing, ctx.getPlayerX());
      ctx.requestRepaint();
   }

   private void endDash(SkillContext ctx) {
      if (a.skillBridgeDashFeetOnGround()) {
         a.skillBridgeSetPlayerState(1);
      } else {
         a.skillBridgeSetPlayerState(4);
         a.skillBridgeSetFallZ(1);
         a.skillBridgeSetMoveD(0);
      }
      ctx.requestRepaint();
   }

   public boolean isActive() {
      return a.skillBridgeGetPlayerState() == STATE_DASH;
   }

   /**
    * Vẽ {@code /cp/dash.png} thay animation chạy; lật ngang khi nhìn trái.
    * @return {@code true} nếu đã vẽ (bỏ qua layer nhân vật thường)
    */
   public boolean renderPlayer(SkillContext ctx, Graphics g) {
      if (!isActive() || g == null) {
         return false;
      }
      Image img = ensureDashSprite();
      if (img == null) {
         return false;
      }
      int px = ctx.getPlayerX();
      int py = ctx.getPlayerY();
      int facing = ctx.getPlayerFacing();
      if (facing == 1) {
         g.drawImage(img, px + SPRITE_ANCHOR_X, py - SPRITE_ANCHOR_Y, 0);
      } else {
         g.drawRegion(img, 0, 0, img.getWidth(), img.getHeight(), 2,
            px - SPRITE_ANCHOR_X, py - SPRITE_ANCHOR_Y, 24);
      }
      return true;
   }

   private static Image ensureDashSprite() {
      if (dashSprite != null) {
         return dashSprite;
      }
      if (dashSpriteTried) {
         return null;
      }
      dashSpriteTried = true;
      try {
         dashSprite = Image.createImage("/cp/dash.png");
      } catch (Exception ignored) {
         dashSprite = null;
      }
      return dashSprite;
   }

   /** Đồng bộ từ {@link a#skillDashLevel} sau load RMS. */
   public void syncLevelFromLegacy(int legacyLevel) {
      setLevel(legacyLevel);
   }

   /** Ghi {@link a#skillDashLevel} trước save. */
   public int getLevelForLegacySave() {
      return level < 1 ? 1 : level;
   }
}
