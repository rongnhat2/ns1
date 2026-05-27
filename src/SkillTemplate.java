import javax.microedition.lcdui.Graphics;

/**
 * Khung chung cho kỹ năng: học / MP / điều kiện map / luồng {@link #tryActivate}.
 * <p>
 * <b>Lifecycle</b> (an toàn, mặc định rỗng — skill cũ không cần đổi):
 * {@link #onLearn} → {@link #onActivate} → tuỳ chọn {@link #onUpdate}, {@link #onRender},
 * {@link #onExpire}; persistence mở rộng: {@link #onSave} / {@link #onLoad}.
 * Bit “đã học” RMS vẫn dùng {@link #getSaveFlag()} / {@link #loadSaveFlag(int)} như legacy.
 * </p>
 * <p>
 * Mỗi skill cụ thể <b>extends</b> lớp này và chỉ override {@link #canUse}, {@link #onActivate}
 * (và tuỳ chọn {@link #getManaCost}, {@link #onLearned}, …).
 * </p>
 * <p>
 * Skill cần cập nhật mỗi frame (dash) có thể implements thêm {@link TickingSkill}.
 * </p>
 *
 * @see GameSkillContext
 */
public abstract class SkillTemplate {

   /** Return value for {@link #onSave} when there is no extra payload. */
   protected static final int[] NO_SKILL_PAYLOAD = null;

   private boolean learned;
   private int baseManaCost;

   public final boolean isLearned() {
      return learned;
   }

   public final void setLearned(boolean value) {
      learned = value;
   }

   /** Gọi từ NPC / nhiệm vụ / cheat sau khi mở khóa skill. */
   public final void learn(SkillContext ctx) {
      learned = true;
      onLearn(ctx);
   }

   /**
    * Sau khi set cờ learned; mặc định gọi {@link #onLearned} để dash/ambush cũ không phải sửa.
    */
   protected void onLearn(SkillContext ctx) {
      onLearned(ctx);
   }

   /** Lưu save dạng 0/1 (giữ tương thích mảng {@code int[]} hiện tại). */
   public int getSaveFlag() {
      return learned ? 1 : 0;
   }

   public void loadSaveFlag(int flag) {
      learned = flag == 1;
   }

   /**
    * Payload bổ sung (charge, cooldown tick, …) — <b>không</b> thay thế {@link #getSaveFlag}.
    * Ghi vào tail save theo {@link SkillIds} khi đã thêm slot; mặc định {@code null}.
    */
   protected int[] onSave() {
      return NO_SKILL_PAYLOAD;
   }

   /** Đọc payload từ {@link #onSave}; {@code null} hoặc rỗng = bỏ qua. */
   protected void onLoad(int[] payload) {
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

   /**
    * Gọi từ game loop khi skill cần frame update (aura, channel, …); mặc định no-op.
    * Skill dash hiện dùng {@link TickingSkill#tick} — có thể gọi {@code onUpdate} bên trong khi migrate.
    *
    * @param deltaMs thời gian ước lượng ms; có thể {@code 0} nếu engine chưa đo
    */
   protected void onUpdate(SkillContext ctx, int deltaMs) {
   }

   /**
    * Vẽ overlay khi skill đang hiển thị; gọi từ {@code paint} gameplay.
    * Chỉ override nếu skill có FX riêng (tránh NPE: kiểm tra {@code g != null} nếu cần).
    */
   protected void onRender(SkillContext ctx, Graphics g) {
   }

   /** Kết thúc hiệu ứng (hết thời gian, cancel, chết mob, …). */
   protected void onExpire(SkillContext ctx) {
   }

   /** Tuỳ chọn: toast, sync level, v.v. — legacy hook; ưu tiên override {@link #onLearn} cho skill mới. */
   protected void onLearned(SkillContext ctx) {
   }

   /** Đọc payload sau {@link #loadSaveFlag(int)} khi registry load save. */
   public final void applyLoadPayload(int[] payload) {
      onLoad(payload);
   }

   /** Ghi payload trước commit save (sau khi đã sync learned qua {@link #getSaveFlag}). */
   public final int[] collectSavePayload() {
      return onSave();
   }
}
