/**
 * Id skill cho save / registry (thứ tự append vào mảng save khi thêm skill mới).
 * Logic từng skill vẫn nằm ở class extends {@link SkillTemplate}.
 */
public final class SkillIds {

   public static final int DASH = 0;
   public static final int AMBUSH = 1;
   /** Skill mới: tăng COUNT và thêm constant. */
   public static final int COUNT = 2;

   private SkillIds() {
   }
}
