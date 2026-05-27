/**
 * Kỹ năng dash: double-tap trái/phải, lướt theo hướng.
 */
public final class DashSkill extends SkillTemplate implements TickingSkill {

   public static final int STATE_DASH = 25;
   private static final int DOUBLE_TAP_MS = 420;
   private static final int DISTANCE = 112;

   private static final DashSkill INSTANCE = new DashSkill();

   private long lastTapMillisLeft = -999999L;
   private long lastTapMillisRight = -999999L;
   private int pixelsRemaining;
   private long startMillis;

   private DashSkill() {
      setBaseManaCost(0);
   }

   public static DashSkill getInstance() {
      return INSTANCE;
   }

   public static boolean isPlayerDashing(int state) {
      return state == STATE_DASH;
   }

   protected boolean showNotLearnedMessage() {
      return false;
   }

   protected int getManaCost(SkillContext ctx) {
      return a.getDashManaCostPublic();
   }

   protected boolean canUse(SkillContext ctx) {
      if (!ctx.isGameplay()) {
         return false;
      }
      int var0 = ctx.getPlayerState();
      if (var0 == STATE_DASH || var0 == 5 || var0 == 3) {
         return false;
      }
      if (var0 != 1 && var0 != 2 && var0 != 4) {
         return false;
      }
      if (var0 == 4 && a.skillBridgeGetFallZ() > 6) {
         return false;
      }
      if (ctx.getPlayerMp() < getManaCost(ctx)) {
         ctx.showMessage("Không đủ MP!");
         return false;
      }
      return a.skillBridgeDashFeetOnGround();
   }

   protected boolean onActivate(SkillContext ctx) {
      int var0 = pendingDirection;
      ctx.setPlayerFacing(var0);
      a.skillBridgeSetPlayerState(STATE_DASH);
      pixelsRemaining = DISTANCE;
      startMillis = System.currentTimeMillis();
      a.skillBridgeResetMoveVelocity();
      a.skillBridgeClearInteractHint();
      ctx.requestRepaint();
      a.skillBridgeDashRunFx(var0, ctx.getPlayerX());
      return true;
   }

   protected void onLearned(SkillContext ctx) {
      a.syncDashDurationToLevel();
   }

   /** Bấm phím hướng 4 (trái) hoặc 6 (phải); {@code true} = đã dash, chặn di chuyển thường. */
   public boolean onDirectionKey(int keyCode) {
      if (!isLearned() || !GameSkillContext.INSTANCE.isGameplay()) {
         return false;
      }
      long var0 = System.currentTimeMillis();
      long var1 = keyCode == 4 ? lastTapMillisLeft : lastTapMillisRight;
      int var2 = keyCode == 4 ? -1 : 1;
      boolean var3 = var0 - var1 <= (long)DOUBLE_TAP_MS && var0 - var1 >= 0L;
      if (keyCode == 4) {
         lastTapMillisLeft = var0;
      } else {
         lastTapMillisRight = var0;
      }
      if (!var3) {
         return false;
      }
      pendingDirection = var2;
      return tryActivate(GameSkillContext.INSTANCE);
   }

   private int pendingDirection;

   public void tick(SkillContext ctx) {
      if (!isActive()) {
         return;
      }
      int var0 = a.dashDurationMs > 0 ? a.dashDurationMs : 200;
      long var1 = System.currentTimeMillis() - startMillis;
      if (pixelsRemaining <= 0) {
         if (a.skillBridgeDashFeetOnGround()) {
            a.skillBridgeSetPlayerState(1);
         } else {
            a.skillBridgeSetPlayerState(4);
            a.skillBridgeSetFallZ(1);
            a.skillBridgeSetMoveD(0);
         }
         ctx.requestRepaint();
         return;
      }
      int var2 = DISTANCE - pixelsRemaining;
      int var3 = (int)((long)DISTANCE * var1 / (long)var0);
      if (var3 > DISTANCE) {
         var3 = DISTANCE;
      }
      if (var1 >= (long)var0) {
         var3 = DISTANCE;
      }
      int var4 = var3 - var2;
      if (var4 <= 0) {
         a.skillBridgeDashAnimTick();
         ctx.requestRepaint();
         return;
      }
      if (var4 > pixelsRemaining) {
         var4 = pixelsRemaining;
      }
      int var5 = ctx.getPlayerFacing();
      int var6 = ctx.getPlayerX() + var5 * var4;
      if (var5 == 1) {
         if (a.skillBridgeWallRight(var6, ctx.getPlayerY())) {
            ctx.setPlayerPosition(a.skillBridgeSnapXFromWallRight(var6), ctx.getPlayerY());
            pixelsRemaining = 0;
         } else {
            ctx.setPlayerPosition(var6, ctx.getPlayerY());
            pixelsRemaining -= var4;
         }
      } else {
         if (a.skillBridgeWallLeft(var6, ctx.getPlayerY())) {
            ctx.setPlayerPosition(a.skillBridgeSnapXFromWallLeft(var6), ctx.getPlayerY());
            pixelsRemaining = 0;
         } else {
            ctx.setPlayerPosition(var6, ctx.getPlayerY());
            pixelsRemaining -= var4;
         }
      }
      a.skillBridgeDashAnimTick();
      a.skillBridgeDashAfterMove();
      a.skillBridgeDashRunFx(var5, ctx.getPlayerX());
      ctx.requestRepaint();
   }

   public boolean isActive() {
      return a.skillBridgeGetPlayerState() == STATE_DASH;
   }
}
