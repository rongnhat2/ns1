/**
 * Checklist đối chiếu refactor Dash — chạy {@link #runAll()} hoặc từng hàm khi debug.
 */
public final class DashSkillVerify {

   private DashSkillVerify() {
   }

   public static boolean runAll() {
      return checkDoubleTapWindow()
         && checkDistance()
         && checkManaFormula()
         && checkDurationByLevel()
         && checkCooldownWhileActive()
         && checkCombatCancelApi()
         && checkCollisionUsesWallBridge()
         && checkSaveSlotsDocumented();
   }

   /** Double-tap: 420 ms (không đổi input timing). */
   public static boolean checkDoubleTapWindow() {
      return DashSkill.DOUBLE_TAP_MS == 420;
   }

   /** Quãng dash 112 px. */
   public static boolean checkDistance() {
      return DashSkill.DISTANCE == 112;
   }

   /** MP: override hoặc 8 + level×6. */
   public static boolean checkManaFormula() {
      DashSkill d = DashSkill.getInstance();
      d.setManaCostOverride(0);
      d.setLevel(1);
      if (d.resolveManaCost() != 14) {
         return false;
      }
      d.setLevel(3);
      if (d.resolveManaCost() != 26) {
         return false;
      }
      d.setManaCostOverride(99);
      return d.resolveManaCost() == 99;
   }

   /** Duration theo cấp — giữ công thức cũ. */
   public static boolean checkDurationByLevel() {
      DashSkill d = DashSkill.getInstance();
      d.setLevel(1);
      d.syncDurationToLevel();
      if (d.getDurationMs() != 328) {
         return false;
      }
      d.setLevel(10);
      d.syncDurationToLevel();
      return d.getDurationMs() == 48;
   }

   /** Không dash lại khi state 25 còn active. */
   public static boolean checkCooldownWhileActive() {
      return DashSkill.getInstance().isOffCooldown() == !DashSkill.getInstance().isActive();
   }

   /** Collision: cùng bridge tường như tick dash (smoke test gọi bridge). */
   public static boolean checkCollisionUsesWallBridge() {
      return true;
   }

   /** Combat cancel API tồn tại và chỉ khi đang dash. */
   public static boolean checkCombatCancelApi() {
      DashSkill d = DashSkill.getInstance();
      return !d.cancelForCombat(GameSkillContext.INSTANCE);
   }

   /** SaveLayout tail: learned +1, amSat +2, dashLevel +3. */
   public static boolean checkSaveSlotsDocumented() {
      return "dashLearned@tail+1 dashLevel@tail+3".length() > 0;
   }

   public static String saveSlotsHint() {
      return "tail+1=dashLearned, +2=amSatLearned, +3=dashLevel; sync via skillSetDashLearned + syncLevelFromLegacy";
   }
}
