/**
 * Manual / debug verification notes for {@link TileCollision} — physics unchanged, documents
 * which bitmasks movement code relies on (see {@code a} player tick ~4780–6650).
 * <p>
 * Enable dumps via {@link DebugRefactor} {@code d5#} after teleporting with {@code d1&lt;mapId&gt;#}.
 */
public final class TileCollisionVerify {

   private TileCollisionVerify() {
   }

   /**
    * Jump / air state: leaving ground when {@code (getFlagsPx & BLOCKED) != BLOCKED}
    * at feet ({@code a} dash/knockback ~4849, wall jump ~5504).
    */
   public static boolean probeJumpLeavesGround(int px, int py, int halfHeight) {
      int f = TileCollision.getFlagsPx(px, py)
         | TileCollision.getFlagsPx(px, py + halfHeight)
         | TileCollision.getFlagsPx(px, py + 8)
         | TileCollision.getFlagsPx(px, py + 14);
      return (f & TileCollision.BLOCKED) == 0;
   }

   /**
    * Fall / land: {@code hasAllFlagsPx(px, py, BLOCKED)} or snap {@code snapToTileOrigin(py)}
    * when landing ({@code a} states 4/6, water uses {@link TileCollision#WATER} + tile offset).
    */
   public static boolean probeFeetBlocked(int px, int py) {
      return TileCollision.hasAllFlagsPx(px, py, TileCollision.BLOCKED);
   }

   /**
    * Wall block: {@link TileCollision#WALL_RIGHT} at {@code px + halfWidth},
    * {@link TileCollision#WALL_LEFT} at {@code px - halfWidth - 1} ({@code a} ~4813, ~5826).
    */
   public static boolean probeWallRight(int px, int py, int halfWidth, int halfHeight) {
      return TileCollision.hasAllFlagsPx(px + halfWidth, py - halfHeight, TileCollision.WALL_RIGHT);
   }

   public static boolean probeWallLeft(int px, int py, int halfWidth, int halfHeight) {
      return TileCollision.hasAllFlagsPx(px - halfWidth - 1, py - halfHeight, TileCollision.WALL_LEFT);
   }

   /**
    * Map edge: {@code px < 0} or {@code px >= mapPixelWidth() - 24} triggers warp ({@code a} ~6525–6534).
    * Vertical: {@code py >= mapPixelHeight()} ({@code iQ}).
    */
   public static boolean probePastRightEdge(int px) {
      return px >= TileCollision.mapPixelWidth() - 24;
   }

   public static boolean probePastLeftEdge(int px) {
      return px < 0;
   }

   public static boolean probePastBottom(int py) {
      return py >= TileCollision.mapPixelHeight();
   }

   /** Ladder / water / platform spot check for quest maps (tile coords). */
   public static String probeTileSummary(int tileX, int tileY) {
      int f = TileCollision.getFlagsTile(tileX, tileY);
      StringBuilder sb = new StringBuilder();
      sb.append("tile=").append(tileX).append(',').append(tileY).append(" flags=0x")
         .append(Integer.toHexString(f));
      if ((f & TileCollision.BLOCKED) != 0) {
         sb.append(" blocked");
      }
      if ((f & TileCollision.WALL_RIGHT) != 0) {
         sb.append(" wallR");
      }
      if ((f & TileCollision.WALL_LEFT) != 0) {
         sb.append(" wallL");
      }
      if ((f & TileCollision.WATER) != 0) {
         sb.append(" water");
      }
      if ((f & TileCollision.LADDER) != 0) {
         sb.append(" ladder");
      }
      if ((f & TileCollision.PLATFORM) != 0) {
         sb.append(" platform");
      }
      if ((f & TileCollision.STAND_WATER) != 0) {
         sb.append(" standWater");
      }
      return sb.toString();
   }

   public static void logPlayerTileProbe(int px, int py) {
      if (!DebugRefactor.isActive()) {
         return;
      }
      int ts = TileCollision.tileSize();
      if (ts <= 0) {
         System.err.println("[DBG][TILE] grid not bound");
         return;
      }
      int tx = px / ts;
      int ty = py / ts;
      System.err.println("[DBG][TILE] " + probeTileSummary(tx, ty)
         + " edgeL=" + probePastLeftEdge(px)
         + " edgeR=" + probePastRightEdge(px)
         + " edgeB=" + probePastBottom(py));
   }
}
