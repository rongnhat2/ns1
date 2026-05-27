/**
 * Tile collision grid and bitmask queries (extracted from {@link a} {@code g}/{@code h}/{@code i}).
 * <p>
 * Flag layout matches map init in {@code a.q()} — do not change values without updating both sites.
 * <ul>
 *   <li>{@link #BLOCKED} — solid ground / blocked tile ({@code 2})</li>
 *   <li>{@link #WALL_RIGHT} / {@link #WALL_LEFT} — vertical wall faces ({@code 4} / {@code 8})</li>
 *   <li>{@link #WATER} — water volume ({@code 64})</li>
 *   <li>{@link #LADDER} — climbable ladder ({@code 512})</li>
 *   <li>{@link #PLATFORM} — one-way platform, runtime toggled ({@code 1024})</li>
 *   <li>{@link #DROP_THROUGH} — drop-through floor marker ({@code 2048})</li>
 *   <li>{@link #STAND_WATER} — shallow / stand-on-water ({@code 4096})</li>
 * </ul>
 * Map bounds for edge checks: {@link #mapPixelWidth()} / {@link #mapPixelHeight()} (was {@code iP}/{@code iQ}).
 */
public final class TileCollision {

   /** Solid ground / blocked — movement uses {@code (flags & 2) == 2}. */
   public static final int BLOCKED = 2;
   /** Right-facing wall segment. */
   public static final int WALL_RIGHT = 4;
   /** Left-facing wall segment. */
   public static final int WALL_LEFT = 8;
   /** Water tile. */
   public static final int WATER = 64;
   /** Ladder tile. */
   public static final int LADDER = 512;
   /** One-way platform (set/cleared during {@code a.S()}). */
   public static final int PLATFORM = 1024;
   /** Drop-through floor (pairs with {@link #PLATFORM} in {@code a.S()}). */
   public static final int DROP_THROUGH = 2048;
   /** Stand-on-water / shallow surface. */
   public static final int STAND_WATER = 4096;
   /** Burrow-capable ground (unchanged alias for callers that still use {@code 8192}). */
   public static final int BURROW_GROUND = 8192;

   private static int tilesWide;
   private static int tilesHigh;
   private static int mapPixelWidth;
   private static int mapPixelHeight;
   private static int tileSize;
   private static int[] flags;

   private TileCollision() {
   }

   /** Bind after map load ({@code a.q()}). {@code flagGrid} is the live {@code iS} array. */
   public static void bind(int tilesW, int tilesH, int mapPxW, int mapPxH, int tileSz, int[] flagGrid) {
      tilesWide = tilesW;
      tilesHigh = tilesH;
      mapPixelWidth = mapPxW;
      mapPixelHeight = mapPxH;
      tileSize = tileSz;
      flags = flagGrid;
   }

   public static void clear() {
      flags = null;
   }

   public static int tilesWide() {
      return tilesWide;
   }

   public static int tilesHigh() {
      return tilesHigh;
   }

   public static int mapPixelWidth() {
      return mapPixelWidth;
   }

   public static int mapPixelHeight() {
      return mapPixelHeight;
   }

   public static int tileSize() {
      return tileSize;
   }

   /** Was {@code a.g(px, py, mask)} — all bits in {@code mask} must be set. */
   public static boolean hasAllFlagsPx(int px, int py, int mask) {
      return (flags[py / tileSize * tilesWide + px / tileSize] & mask) == mask;
   }

   /** Was {@code a.h(tx, ty)} — flags at tile coordinates. */
   public static int getFlagsTile(int tx, int ty) {
      return flags[ty * tilesWide + tx];
   }

   /** Was {@code a.i(px, py)} — flags at pixel coordinates. */
   public static int getFlagsPx(int px, int py) {
      return flags[py / tileSize * tilesWide + px / tileSize];
   }

   /** Was {@code a.h(px, py, _)} — OR {@link #PLATFORM} at pixel cell. */
   public static void setPlatformPx(int px, int py) {
      int idx = py / tileSize * tilesWide + px / tileSize;
      flags[idx] |= PLATFORM;
   }

   /** Was {@code a.j(px, py, _)} — clear {@link #PLATFORM} at pixel cell. */
   public static void clearPlatformPx(int px, int py) {
      int idx = py / tileSize * tilesWide + px / tileSize;
      flags[idx] &= -1025;
   }

   /**
    * Was {@code a.i(_, row, _)} — clears blocked tile at fixed column 24 (map 97 / quest unlock).
    * {@code tileX} and {@code unused} are ignored (legacy signature).
    */
   public static void clearBlockedAtColumn24(int tileX, int row, int unused) {
      flags[row * tilesWide + 24] = 0;
   }

   /** Was {@code a.H(int)} / {@code a.I(int)} — snap coordinate down to tile origin. */
   public static int snapToTileOrigin(int coord) {
      return coord / tileSize * tileSize;
   }
}
