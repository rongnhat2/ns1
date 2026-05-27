/**
 * Khinh công (wall jump): nhảy ban đầu, đẩy trên không, MP — logic giữ nguyên từ {@link a}.
 * <p>
 * Save (frozen, {@code SaveLayout.md}): base + L2 trong fixed block; L3 ở tail.
 * Bậc air 0 vẫn dùng {@code skillLegacyFlagEK} (eK) như bản gốc.
 * </p>
 */
public final class WallJumpSkill extends SkillTemplate {

   /** MP mỗi lần đẩy trên không (không popup — giống {@code a} cũ). */
   public static final int AIR_BOOST_MP_COST = 3;

   /** Vận tốc z nhảy thường (chưa học KC). */
   public static final int JUMP_Z_NORMAL = -8;
   /** Vận tốc z nhảy đã học KC (chưa L3). */
   public static final int JUMP_Z_KC = -10;
   /** Vận tốc z nhảy KC cấp 3. */
   public static final int JUMP_Z_KC_L3 = -12;

   /** Đẩy air bậc 0/1 (eK / L2). */
   public static final int AIR_BOOST_Z_TIER01 = -7;
   /** Đẩy air bậc 2 (L3). */
   public static final int AIR_BOOST_Z_TIER2 = -9;

   private static final WallJumpSkill INSTANCE = new WallJumpSkill();

   private boolean l2Learned;
   private boolean l3Learned;

   private WallJumpSkill() {
      setBaseManaCost(0);
   }

   public static WallJumpSkill getInstance() {
      return INSTANCE;
   }

   public boolean isL2Learned() {
      return l2Learned;
   }

   public void setL2Learned(boolean value) {
      l2Learned = value;
   }

   public boolean isL3Learned() {
      return l3Learned;
   }

   public void setL3Learned(boolean value) {
      l3Learned = value;
   }

   public int getL2SaveFlag() {
      return l2Learned ? 1 : 0;
   }

   public void loadL2SaveFlag(int flag) {
      l2Learned = flag == 1;
   }

   public int getL3SaveFlag() {
      return l3Learned ? 1 : 0;
   }

   public void loadL3SaveFlag(int flag) {
      l3Learned = flag == 1;
   }

   /** Was {@code a.zForInitialJump()}. */
   public int zForInitialJump() {
      if (isLearned()) {
         return l3Learned ? JUMP_Z_KC_L3 : JUMP_Z_KC;
      }
      return JUMP_Z_NORMAL;
   }

   /**
    * Was {@code a.tryAirKhinhCongBoost()}. Gọi từ input nhảy trên không (state 3).
    * @return {@code true} nếu đã đẩy lên
    */
   public boolean tryAirBoost() {
      int tier = a.skillBridgeGetAirComboTier();
      int newZ;
      if (tier == 0 && a.skillBridgeGetLegacyFlagEK()) {
         a.skillBridgeIncrementAirComboTier();
         newZ = AIR_BOOST_Z_TIER01;
      } else if (tier == 1 && l2Learned) {
         a.skillBridgeIncrementAirComboTier();
         newZ = AIR_BOOST_Z_TIER01;
      } else if (tier == 2 && l3Learned) {
         a.skillBridgeIncrementAirComboTier();
         newZ = AIR_BOOST_Z_TIER2;
      } else {
         return false;
      }

      a.skillBridgeSubtractMpSilent(AIR_BOOST_MP_COST);
      a.skillBridgeSetFallZ(newZ);
      a.skillBridgePlayWallJumpAirFx();
      return true;
   }

   /** Passive skill — không kích hoạt qua {@link #tryActivate}. */
   protected boolean canUse(SkillContext ctx) {
      return false;
   }

   protected boolean onActivate(SkillContext ctx) {
      return false;
   }

   protected boolean showNotLearnedMessage() {
      return false;
   }
}
