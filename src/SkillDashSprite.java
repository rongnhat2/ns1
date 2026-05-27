import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * Sprite dash / FX lướt — tách khỏi {@link DashSkill} và {@link AmbushSkill} để đổi asset một chỗ.
 * <p>
 * Chỉnh path, neo vẽ, offset ám sát tại các hằng {@code *PATH}, {@code ANCHOR_*}, {@code AMBUSH_*} bên dưới.
 * </p>
 */
public final class SkillDashSprite {

   // --- Assets (đổi tại đây) ---

   /** PNG mặc định hướng phải; trái = lật ngang lúc vẽ. */
   public static final String DASH_IMAGE_PATH = "/cp/dash.png";

   /**
    * PNG FX ám sát; {@code null} hoặc rỗng = dùng {@link #DASH_IMAGE_PATH}.
    * Ví dụ riêng: {@code "/cp/ambush.png"}.
    */
   public static final String AMBUSH_IMAGE_PATH = null;

   /**
    * Neo vẽ tại chân nhân vật ({@code feetX}, {@code feetY}) — cùng offset thân chạy {@code aq[2]}.
    */
   public static final int ANCHOR_X = -10;
   public static final int ANCHOR_Y = 32;

   /**
    * FX ám sát: spawn gọi {@code f(x, y - AMBUSH_SPAWN_Y_ABOVE_FEET)} → chân vẽ tại {@code spawnY + offset}.
    */
   public static final int AMBUSH_SPAWN_Y_ABOVE_FEET = 40;

   /** MIDP: {@code Graphics.TRANS_MIRROR}. */
   public static final int FLIP_TRANSFORM = 2;
   /** MIDP: {@code Graphics.RIGHT | Graphics.BOTTOM}. */
   public static final int FLIP_ANCHOR = 24;

   // --- Runtime cache ---

   private static Image cachedDashImage;
   private static Image cachedAmbushImage;
   private static boolean dashLoadAttempted;
   private static boolean ambushLoadAttempted;

   private SkillDashSprite() {
   }

   /** Sprite dash (lazy load). */
   public static Image getDashImage() {
      if (cachedDashImage != null) {
         return cachedDashImage;
      }
      if (dashLoadAttempted) {
         return null;
      }
      dashLoadAttempted = true;
      cachedDashImage = loadImage(DASH_IMAGE_PATH);
      return cachedDashImage;
   }

   /** Sprite FX ám sát — fallback {@link #DASH_IMAGE_PATH}. */
   public static Image getAmbushImage() {
      if (AMBUSH_IMAGE_PATH != null && AMBUSH_IMAGE_PATH.length() > 0) {
         if (cachedAmbushImage != null) {
            return cachedAmbushImage;
         }
         if (ambushLoadAttempted) {
            return null;
         }
         ambushLoadAttempted = true;
         cachedAmbushImage = loadImage(AMBUSH_IMAGE_PATH);
         return cachedAmbushImage;
      }
      return getDashImage();
   }

   /** Xóa cache — gọi sau khi đổi sprite runtime (vd. swap giới tính). */
   public static void invalidateCache() {
      cachedDashImage = null;
      cachedAmbushImage = null;
      dashLoadAttempted = false;
      ambushLoadAttempted = false;
   }

   /** Vẽ sprite dash tại chân nhân vật. */
   public static boolean drawAtFeet(Graphics g, int feetX, int feetY, int facing) {
      return drawImageAtFeet(g, getDashImage(), feetX, feetY, facing);
   }

   /** FX sau spawn (transition / skill khác gọi {@code f(x,y)}); ám sát dùng {@link #drawAmbushPose}. */
   public static void drawAmbushFx(Graphics g, int spawnX, int spawnY, int facing) {
      drawImageAtFeet(g, getAmbushImage(), spawnX, spawnY + AMBUSH_SPAWN_Y_ABOVE_FEET, facing);
   }

   /** Pose ám sát bám chân nhân vật (giữ tới khi di chuyển / tấn công). */
   public static boolean drawAmbushPose(Graphics g, int feetX, int feetY, int facing) {
      return drawImageAtFeet(g, getAmbushImage(), feetX, feetY, facing);
   }

   private static boolean drawImageAtFeet(Graphics g, Image img, int feetX, int feetY, int facing) {
      if (g == null || img == null) {
         return false;
      }
      if (facing == 1) {
         g.drawImage(img, feetX + ANCHOR_X, feetY - ANCHOR_Y, 0);
      } else {
         g.drawRegion(img, 0, 0, img.getWidth(), img.getHeight(), FLIP_TRANSFORM,
            feetX - ANCHOR_X, feetY - ANCHOR_Y, FLIP_ANCHOR);
      }
      return true;
   }

   private static Image loadImage(String path) {
      try {
         return Image.createImage(path);
      } catch (Exception ignored) {
         return null;
      }
   }
}
