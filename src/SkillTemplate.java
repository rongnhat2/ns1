/**
 * Khung chung cho kỹ năng: học / MP / điều kiện map / luồng {@link #tryActivate}.
 * <p>
 * Mỗi skill cụ thể <b>extends</b> lớp này và chỉ override {@link #canUse}, {@link #onActivate}
 * (và tuỳ chọn {@link #getManaCost}, {@link #onLearned}, thông báo chưa học…).
 * Không gộp logic dash, ám sát, v.v. vào đây.
 * </p>
 * <p>
 * Skill cần cập nhật mỗi frame (dash) có thể implements thêm {@link TickingSkill}.
 * </p>
 *
 * @see GameSkillContext
 */
public abstract class SkillTemplate {

   private boolean learned;
   private int baseManaCost;

   public final boolean isLearned() {
      return learned;
   }

   public final void setLearned(boolean value) {
      learned = value;
   }

   /** Gọi từ NPC / nhiệm vụ / cheat sau khi mở khóa skill. */
   public void learn(SkillContext ctx) {
      learned = true;
      onLearned(ctx);
   }

   /** Lưu save dạng 0/1 (giữ tương thích mảng {@code int[]} hiện tại). */
   public int getSaveFlag() {
      return learned ? 1 : 0;
   }

   public void loadSaveFlag(int flag) {
      learned = flag == 1;
   }

   /** MP cố định; skill con override {@link #getManaCost} nếu cần công thức (vd. theo level). */
   public void setBaseManaCost(int cost) {
      baseManaCost = cost;
   }

   public int getBaseManaCost() {
      return baseManaCost;
   }

   /**
    * Luồng chuẩn — <b>không override</b>.
    * @return {@code true} nếu skill đã kích hoạt thành công
    */
   public final boolean tryActivate(SkillContext ctx) {
      if (!learned) {
         return handleNotLearned(ctx);
      }
      if (!canUse(ctx)) {
         return false;
      }
      if (!beforeSpendMana(ctx)) {
         return false;
      }
      int cost = getManaCost(ctx);
      if (cost > 0) {
         if (ctx.getPlayerMp() < cost) {
            ctx.showMessage("Không đủ MP!");
            return false;
         }
         if (!ctx.spendMp(cost)) {
            ctx.showMessage("Không đủ MP!");
            return false;
         }
      }
      return onActivate(ctx);
   }

   /** {@code false} = im lặng khi chưa học (vd. dash); {@code true} = hiện {@link #getNotLearnedMessage()}. */
   protected boolean showNotLearnedMessage() {
      return true;
   }

   protected String getNotLearnedMessage() {
      return "Chưa học kỹ năng!";
   }

   protected boolean handleNotLearned(SkillContext ctx) {
      if (showNotLearnedMessage()) {
         ctx.showMessage(getNotLearnedMessage());
      }
      return false;
   }

   /** MP tiêu hao lần kích hoạt; {@code 0} = không trừ MP. */
   protected int getManaCost(SkillContext ctx) {
      return baseManaCost > 0 ? baseManaCost : 0;
   }

   /**
    * Gọi sau {@link #canUse}, trước khi trừ MP (vd. ám sát: tìm mục tiêu trước).
    * @return {@code false} để hủy — chưa trừ MP
    */
   protected boolean beforeSpendMana(SkillContext ctx) {
      return true;
   }

   /** Điều kiện riêng (trạng thái, đất, mục tiêu…) — skill con implement. */
   protected abstract boolean canUse(SkillContext ctx);

   /** Hiệu ứng skill sau khi đã trừ MP — skill con implement. */
   protected abstract boolean onActivate(SkillContext ctx);

   /** Tuỳ chọn: toast, sync level, v.v. */
   protected void onLearned(SkillContext ctx) {
   }
}
