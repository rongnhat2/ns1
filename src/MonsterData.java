/**
 * Static template data for map mobs ({@code jK} type index 0 … {@link #TYPE_COUNT} - 1).
 * Moved from {@link a} fields {@code ak}–{@code ao}; array indices unchanged.
 */
public final class MonsterData {

   public static final int TYPE_COUNT = 20;

   /** Was {@code a.ak} — display name. */
   public static final String[] NAMES = new String[]{
      "Ma một mắt", "ốc sên", "Dơi quỷ", "Quỷ một chân", "Cóc xanh", "Nhện", "Ong bò vẽ", "Bù nhìn rơm",
      "Cá cọp", "Ninja gió", "Cá cọp đỏ", "Ma một mắt", "Rết sa mạc", "Dơi vàng", "Chuột", "Thổ dân",
      "Ong đỏ", "Bò cạp", "Quỷ hoa", "Quỷ tử hoa"
   };

   /** Was {@code a.al} — max HP ({@code ka}/{@code kb} on spawn). */
   public static final int[] HP = new int[]{
      140, 70, 150, 120, 150, 150, 60, 1000, 250, 500, 4000, 500, 600, 1000, 1500, 2000, 1000, 3500, 1500, 5500
   };

   /** Was {@code a.am} — contact / attack damage ({@code kc}). */
   public static final int[] DAMAGE = new int[]{
      15, 10, 30, 25, 25, 25, 5, 10, 20, 40, 30, 40, 130, 30, 40, 100, 60, 160, 120, 200
   };

   /** Was {@code a.an} — death FX / heavy-hit stat ({@code kh}). */
   public static final int[] HIT_STAT = new int[]{
      35, 20, 55, 40, 45, 50, 30, 130, 60, 65, 70, 75, 120, 85, 100, 120, 140, 160, 180, 200
   };

   /** Was {@code a.ao} — EXP granted on kill ({@code u(...)} in {@code L}). */
   public static final int[] EXP_DROP = new int[]{
      20, 10, 50, 25, 30, 40, 15, 50, 60, 70, 80, 100, 120, 130, 160, 180, 170, 210, 190, 220
   };

   /**
    * Sprite file id: {@code /mob/m<id>...png}. Same as type index (was implicit {@code jK}).
    */
   public static final int[] SPRITE_ID = new int[]{
      0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19
   };

   private MonsterData() {
   }

   public static String getName(int type) {
      return NAMES[type];
   }

   public static int getHp(int type) {
      return HP[type];
   }

   public static int getDamage(int type) {
      return DAMAGE[type];
   }

   public static int getHitStat(int type) {
      return HIT_STAT[type];
   }

   public static int getExpDrop(int type) {
      return EXP_DROP[type];
   }

   public static int getSpriteId(int type) {
      return SPRITE_ID[type];
   }
}
