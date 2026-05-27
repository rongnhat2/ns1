/**
 * {@link SkillContext} mặc định — ủy quyền sang {@link a} qua {@link a#skillBridge}.
 */
public final class GameSkillContext implements SkillContext {

   public static final GameSkillContext INSTANCE = new GameSkillContext();

   private GameSkillContext() {
   }

   public boolean isGameplay() {
      return a.skillBridgeIsGameplay();
   }

   public int getPlayerState() {
      return a.skillBridgeGetPlayerState();
   }

   public int getPlayerX() {
      return a.skillBridgeGetPlayerX();
   }

   public int getPlayerY() {
      return a.skillBridgeGetPlayerY();
   }

   public int getPlayerMp() {
      return a.skillBridgeGetPlayerMp();
   }

   public int getPlayerFacing() {
      return a.skillBridgeGetPlayerFacing();
   }

   public void setPlayerFacing(int facing) {
      a.skillBridgeSetPlayerFacing(facing);
   }

   public void setPlayerPosition(int x, int y) {
      a.skillBridgeSetPlayerPosition(x, y);
   }

   public boolean spendMp(int amount) {
      return a.skillBridgeSpendMp(amount);
   }

   public void showMessage(String message) {
      a.skillBridgeShowMessage(message);
   }

   public void requestRepaint() {
      a.skillBridgeRequestRepaint();
   }
}
