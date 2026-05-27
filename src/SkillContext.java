/**
 * Cầu nối trạng thái game cho skill — skill không đọc trực tiếp hàng trăm biến trong {@link a}.
 * Triển khai mặc định: {@link GameSkillContext}.
 */
public interface SkillContext {

   /** Đang chơi map bình thường, không khóa input / menu che gameplay. */
   boolean isGameplay();

   /** Trạng thái animation nhân vật ({@code A} trong {@link a}). */
   int getPlayerState();

   int getPlayerX();

   int getPlayerY();

   int getPlayerMp();

   /** Hướng nhìn: {@code 1} phải, {@code -1} trái. */
   int getPlayerFacing();

   void setPlayerFacing(int facing);

   void setPlayerPosition(int x, int y);

   /** Trừ MP + popup; {@code false} nếu không đủ. */
   boolean spendMp(int amount);

   /** Toast / dòng chữ tạm trên màn hình. */
   void showMessage(String message);

   /** Đánh dấu cần vẽ lại frame. */
   void requestRepaint();
}
