/**
 * Kỹ năng ám sát (phím 9): teleport sau lưng mục tiêu gần nhất.
 */
public final class AmbushSkill extends SkillTemplate {

   private static final int RANGE = 500;
   private static final int BEHIND_OFFSET = 22;
   private static final int GROUND_Y_BAND = 48;
   private static final int MAP_MOB_Y_BAND = 48;

   private static final AmbushSkill INSTANCE = new AmbushSkill();

   private int pendingTargetX;
   private int pendingTargetY;
   private int pendingFacing;

   private AmbushSkill() {
      setBaseManaCost(40);
   }

   public static AmbushSkill getInstance() {
      return INSTANCE;
   }

   protected boolean showNotLearnedMessage() {
      return true;
   }

   protected String getNotLearnedMessage() {
      return "Chưa học ám sát!";
   }

   protected int getManaCost(SkillContext ctx) {
      return a.getAmSatManaCostPublic();
   }

   protected boolean canUse(SkillContext ctx) {
      if (!ctx.isGameplay()) {
         return false;
      }
      if (!a.skillBridgeCanUseAmbush(ctx.getPlayerState())) {
         return false;
      }
      if (ctx.getPlayerMp() < getManaCost(ctx)) {
         ctx.showMessage("Không đủ MP!");
         return false;
      }
      return true;
   }

   protected boolean beforeSpendMana(SkillContext ctx) {
      int var0 = RANGE + 1;
      int var1 = var0;
      int var2 = 0;
      int var3 = 0;
      int var4 = 1;
      boolean var5 = false;
      int var6;
      int var7;
      int var8 = ctx.getPlayerX();
      int var9 = ctx.getPlayerY();

      for(var6 = 0; var6 < a.skillBridgeProjectileSlots(); ++var6) {
         if (a.skillBridgeProjectileAlive(var6) && inHorizontalRange(var8, a.skillBridgeProjectileX(var6)) && projectileVerticalOk(var9, a.skillBridgeProjectileX(var6), a.skillBridgeProjectileY(var6), a.skillBridgeProjectileFlying(var6))) {
            var7 = a.skillBridgeAbs(var8 - a.skillBridgeProjectileX(var6));
            if (var7 < var1) {
               var1 = var7;
               var2 = a.skillBridgeProjectileX(var6);
               var3 = a.skillBridgeProjectileY(var6);
               var4 = a.skillBridgeProjectileDir(var6) != 0 ? a.skillBridgeProjectileDir(var6) : (var8 < var2 ? 1 : -1);
               var5 = true;
            }
         }
      }

      for(var6 = 0; var6 < a.skillBridgeMapMobSlots(); ++var6) {
         if (a.skillBridgeMapMobState(var6) != 1 && a.skillBridgeMapMobState(var6) != 5 && inHorizontalRange(var8, a.skillBridgeMapMobX(var6)) && mapMobVerticalOk(var9, a.skillBridgeMapMobX(var6), a.skillBridgeMapMobY(var6))) {
            var7 = a.skillBridgeAbs(var8 - a.skillBridgeMapMobX(var6));
            if (var7 < var1) {
               var1 = var7;
               var2 = a.skillBridgeMapMobX(var6);
               var3 = a.skillBridgeMapMobY(var6);
               var4 = a.skillBridgeMapMobFace(var6) != 0 ? a.skillBridgeMapMobFace(var6) : (var8 < var2 ? 1 : -1);
               var5 = true;
            }
         }
      }

      for(var6 = 0; var6 < a.skillBridgeJMobSlots(); ++var6) {
         if (a.skillBridgeJMobState(var6) != 5 && inHorizontalRange(var8, a.skillBridgeJMobX(var6)) && jMobVerticalOk(var9, a.skillBridgeJMobX(var6), a.skillBridgeJMobY(var6))) {
            var7 = a.skillBridgeAbs(var8 - a.skillBridgeJMobX(var6));
            if (var7 < var1) {
               var1 = var7;
               var2 = a.skillBridgeJMobX(var6);
               var3 = a.skillBridgeJMobY(var6);
               var4 = a.skillBridgeJMobFace(var6) != 0 ? a.skillBridgeJMobFace(var6) : (var8 < var2 ? 1 : -1);
               var5 = true;
            }
         }
      }

      if (!var5) {
         ctx.showMessage("Không có mục tiêu!");
         return false;
      }
      pendingTargetX = var2;
      pendingTargetY = var3;
      pendingFacing = var4;
      return true;
   }

   protected boolean onActivate(SkillContext ctx) {
      int var0 = pendingFacing > 0 ? 1 : -1;
      ctx.setPlayerFacing(var0);
      int var1 = pendingTargetX - var0 * BEHIND_OFFSET;
      int var2 = pendingTargetY;
      if (var0 == 1) {
         if (a.skillBridgeWallLeft(var1, var2)) {
            var1 = a.skillBridgeSnapXFromWallLeft(var1);
         }
      } else if (a.skillBridgeWallRight(var1, var2)) {
         var1 = a.skillBridgeSnapXFromWallRight(var1);
      }
      ctx.setPlayerPosition(var1, var2);
      a.skillBridgeSetPlayerState(1);
      a.skillBridgeResetMoveVelocity();
      a.skillBridgeClearInteractHint();
      a.skillBridgePlayAmbushFx(var1, var2, var0);
      ctx.requestRepaint();
      return true;
   }

   private static boolean inHorizontalRange(int var0, int var1) {
      return a.skillBridgeAbs(var0 - var1) <= RANGE;
   }

   private static boolean projectileVerticalOk(int var0, int var1, int var2, boolean var3) {
      if (var3) {
         return true;
      }
      if (!a.skillBridgeTileOnGround(var1, var2)) {
         return true;
      }
      int var4 = a.skillBridgeGetHalfHeight();
      int var5 = var4 > 0 ? var4 << 2 : GROUND_Y_BAND;
      return a.skillBridgeAbs(var0 - var4 - var2) < var5;
   }

   private static boolean mapMobVerticalOk(int var0, int var1, int var2) {
      if (a.skillBridgeAbs(var0 - var2) <= MAP_MOB_Y_BAND) {
         return true;
      }
      return !a.skillBridgeTileOnGround(var1, var2);
   }

   private static boolean jMobVerticalOk(int var0, int var1, int var2) {
      int var3 = var0 - a.skillBridgeGetSpriteH() - 56;
      int var4 = var0 + 48;
      if (var2 >= var3 && var2 <= var4) {
         return true;
      }
      return !a.skillBridgeTileOnGround(var1, var2);
   }
}
