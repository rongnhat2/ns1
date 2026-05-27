/**
 * Skill cần {@link #tick} mỗi frame (vd. dash đang chạy).
 * Tách khỏi {@link SkillTemplate} vì không phải skill nào cũng có phase dài.
 */
public interface TickingSkill {

   /** Gọi từ game loop khi skill đang active. */
   void tick(SkillContext ctx);

   /** Skill còn đang chạy (chặn input / state khác). */
   boolean isActive();
}
