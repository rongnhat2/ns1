/**
 * Checklist đối chiếu refactor Khinh Công — chạy thủ công trên emulator.
 * Hằng số physics: {@link WallJumpSkill#JUMP_Z_NORMAL} … {@link WallJumpSkill#AIR_BOOST_MP_COST}.
 */
public final class WallJumpSkillVerify {

   private WallJumpSkillVerify() {
   }

   /** Chưa học: z = -8; học KC: -10; KC L3: -12. */
   public static boolean checkJumpHeights() {
      WallJumpSkill w = WallJumpSkill.getInstance();
      w.setLearned(false);
      w.setL3Learned(false);
      if (w.zForInitialJump() != WallJumpSkill.JUMP_Z_NORMAL) {
         return false;
      }
      w.setLearned(true);
      if (w.zForInitialJump() != WallJumpSkill.JUMP_Z_KC) {
         return false;
      }
      w.setL3Learned(true);
      return w.zForInitialJump() == WallJumpSkill.JUMP_Z_KC_L3;
   }

   /** Mỗi air boost trừ đúng 3 MP (không popup). */
   public static int airBoostMpCost() {
      return WallJumpSkill.AIR_BOOST_MP_COST;
   }

   /** SaveLayout idx 40/53 + tail L3 — so sánh trước/sau save Continue. */
   public static String saveSlotsHint() {
      return "base=skillWallJumpLearned@40, L2@53, L3=tail+0; airComboTier@74";
   }
}
