/**
 * Debug utilities for gameplay refactor — inactive unless {@link #DEBUG_REFACTOR} is true.
 * <p>
 * Commands: press {@code *} to arm, enter digits, confirm with {@code #} (does not touch production cheat buffer {@code bw}).
 * <ul>
 *   <li>{@code d1&lt;mapId&gt;#} — teleport map</li>
 *   <li>{@code d2&lt;amount&gt;#} — add experience (default 1000 if omitted)</li>
 *   <li>{@code d3#} — unlock skills + maps</li>
 *   <li>{@code d4&lt;mobType&gt;#} — spawn test mob (0–19)</li>
 *   <li>{@code d5#} — dump player state</li>
 *   <li>{@code d6#} — dump save fields</li>
 *   <li>{@code d7#} — toggle FPS overlay</li>
 *   <li>{@code d8#} — help</li>
 * </ul>
 */
public final class DebugRefactor {

   /** Set {@code true} locally to enable debug; ship with {@code false}. */
   public static final boolean DEBUG_REFACTOR = false;

   private static String cmdBuf = "";
   private static boolean overlayOn = true;
   private static int lastMapId = -1;
   private static long fpsWindowStart;
   private static int fpsFrameCount;
   private static int fpsDisplay;

   private DebugRefactor() {
   }

   public static boolean isActive() {
      return DEBUG_REFACTOR;
   }

   /** @return true if the key event was fully handled (debug submit). */
   public static boolean onKeyPressed(int keyCode) {
      if (!DEBUG_REFACTOR) {
         return false;
      }

      if (keyCode == 35) {
         if (cmdBuf.length() > 0) {
            executeCommand(cmdBuf);
            cmdBuf = "";
         }
         return false;
      }

      if (keyCode == 42) {
         cmdBuf = "d";
         return false;
      }

      if (keyCode >= 48 && keyCode <= 57 && cmdBuf.length() > 0) {
         if (cmdBuf.length() < 24) {
            cmdBuf = cmdBuf + (char) keyCode;
         } else {
            cmdBuf = "";
         }
      }

      return false;
   }

   public static void tick() {
      if (!DEBUG_REFACTOR) {
         return;
      }

      int mapId = a.debugBridgeGetMapId();
      if (mapId != lastMapId) {
         logMapChange(mapId);
         lastMapId = mapId;
      }

      long now = System.currentTimeMillis();
      ++fpsFrameCount;
      if (fpsWindowStart == 0L) {
         fpsWindowStart = now;
      } else if (now - fpsWindowStart >= 1000L) {
         fpsDisplay = fpsFrameCount;
         fpsFrameCount = 0;
         fpsWindowStart = now;
      }
   }

   public static void onMapLoading(int mapId) {
      if (!DEBUG_REFACTOR) {
         return;
      }
      System.err.println("[DBG][MAP] loading id=" + mapId);
   }

   public static void paintOverlay(javax.microedition.lcdui.Graphics g) {
      if (!DEBUG_REFACTOR || !overlayOn || g == null) {
         return;
      }
      if (a.d != 1) {
         return;
      }

      int y = 2;
      int x = 2;
      Midlet.a(g, "DBG fps=" + fpsDisplay, x, y, 0);
      y += 12;
      Midlet.a(g, "map=" + a.debugBridgeGetMapId(), x, y, 0);
      y += 12;
      Midlet.a(g, a.debugBridgeDumpPlayerState(), x, y, 0);
   }

   private static void logMapChange(int mapId) {
      String name;
      try {
         name = map.getMapName(mapId);
      } catch (Exception e) {
         name = "?";
      }
      System.err.println("[DBG][MAP] now id=" + mapId + " (" + name + ")");
   }

   private static void executeCommand(String raw) {
      if (raw == null || raw.length() < 2 || raw.charAt(0) != 'd') {
         return;
      }

      String body = raw.substring(1);
      int op = body.charAt(0) - '0';
      int param = 0;
      if (body.length() > 1) {
         try {
            param = Integer.parseInt(body.substring(1));
         } catch (NumberFormatException e) {
            param = 0;
         }
      }

      switch (op) {
         case 1:
            a.debugBridgeTeleportMap(param);
            break;
         case 2:
            if (param <= 0) {
               param = 1000;
            }
            a.debugBridgeAddExp(param);
            toast("DBG exp +" + param);
            break;
         case 3:
            a.debugBridgeUnlockAllSkills();
            break;
         case 4:
            a.debugBridgeSpawnTestMob(param);
            break;
         case 5:
            logPlayerDump();
            break;
         case 6:
            logSaveDump();
            break;
         case 7:
            overlayOn = !overlayOn;
            toast("DBG overlay " + (overlayOn ? "ON" : "OFF"));
            break;
         case 8:
            toast("d1map d2exp d3skill d4mob d5ply d6save d7hud d8help");
            break;
         default:
            toast("DBG ? d8# help");
      }
   }

   private static void logPlayerDump() {
      String line = a.debugBridgeDumpPlayerState();
      System.err.println("[DBG][PLAYER] " + line);
      toast(line);
   }

   private static void logSaveDump() {
      String line = a.debugBridgeDumpSaveState();
      System.err.println("[DBG][SAVE] " + line);
      toast(line);
   }

   private static void toast(String msg) {
      if (msg != null && msg.length() > 0) {
         a.skillBridgeShowMessage(msg.length() > 80 ? msg.substring(0, 80) : msg);
      }
   }
}
