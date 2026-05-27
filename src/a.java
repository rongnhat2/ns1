import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import javax.bluetooth.LocalDevice;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextBox;
import javax.microedition.rms.RecordStore;

public final class a extends Canvas implements Runnable, CommandListener {
   public static boolean a = true;
   private static int Z = 40;
   private static int[] aa = new int[]{150, 180, 180, 300, 350, 380, 500};
   private static int[] ab = new int[]{20, 30, 40, 100, 80, 120, 200};
   private static int[] ac = new int[]{150, 140, 120, 240, 280, 290, 300};
   private static int[] ad = new int[]{800, 1000, 1200, 3000, 3500, 4000, 6000};
   private static int[][] ae = new int[][]{{-5, -2}, {-2, -4}, {0, -5}, {-6, -6}, {-5, -2}, {-2, -4}, {0, -5}};
   private static int[][] af = new int[][]{{5, 8}, {3, 3}, new int[2], {4, 4}, {5, 8}, {3, 3}, new int[2]};
   private static int[] ag = new int[]{1, -2, 1, 1, 1, -2, 1};
   private static int[] ah = new int[]{3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
   private static int[] ai = new int[]{50, 150, 240, 400, 600, 800, 1000, 1500, 2000, 3000, 5000, 7000, 9000, 12000, 15000, 19000, 26000, 32000, 40000, 50000, 60000, 70000, 80000, 90000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000};
   private static int[] aj = new int[]{20, 20, 20, 20, 30, 30, 30, 40, 40, 50, 60, 70, 80, 80, 90, 90, 100, 120, 130, 150, 160, 170, 180, 190, 200, 210, 220, 250, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300};
   private static int[][][] ap = new int[][][]{{{0, -13, 31}, {0, -7, 8}, {0, -11, 14}}, {{0, -13, 32}, {0, -7, 8}, {0, -11, 15}}, {{1, -11, 31}, {1, -9, 16}, {6, -1000, 0}}, {{2, -11, 32}, {2, -10, 16}, {6, -1000, 0}}, {{1, -11, 31}, {3, -8, 16}, {6, -1000, 0}}, {{2, -10, 32}, {7, -9, 17}, {6, -1000, 0}}, {{1, -10, 31}, {8, -8, 16}, {6, -1000, 0}}, {{0, -8, 35}, {4, -5, 15}, {2, -10, 21}}, {{0, -8, 34}, {5, -6, 13}, {3, -11, 22}}, {{0, -8, 31}, {6, -13, 9}, {4, -10, 18}}, {{1, -8, 30}, {6, -13, 9}, {5, -8, 17}}, {{2, -10, 30}, {6, -13, 9}, {6, -8, 16}}, {{2, -10, 29}, {6, -13, 9}, {7, -11, 17}}, {{3, -11, 33}, {8, -4, 13}, {8, -15, 25}}};
   private static int[][][] aq = new int[][][]{{{0, -10, 32}, {1, -7, 7}, {1, -11, 15}}, {{0, -10, 33}, {1, -7, 7}, {1, -11, 16}}, {{1, -10, 33}, {2, -10, 11}, {2, -9, 16}}, {{1, -10, 32}, {3, -11, 9}, {3, -11, 16}}, {{1, -10, 34}, {4, -9, 9}, {4, -8, 16}}, {{1, -10, 34}, {5, -11, 11}, {5, -10, 17}}, {{1, -10, 33}, {6, -9, 9}, {6, -8, 16}}, {{0, -9, 36}, {7, -5, 15}, {7, -10, 21}}, {{4, -13, 26}, new int[3], new int[3]}, {{5, -13, 25}, new int[3], new int[3]}, {{6, -12, 26}, new int[3], new int[3]}, {{7, -13, 25}, new int[3], new int[3]}, {{0, -9, 35}, {8, -4, 13}, {8, -14, 27}}, {{0, -9, 32}, {9, -11, 9}, {10, -10, 18}}, {{2, -7, 34}, {9, -11, 9}, {11, -8, 16}}, {{2, -8, 33}, {9, -11, 9}, {12, -8, 15}}, {{2, -7, 33}, {9, -11, 9}, {13, -12, 16}}, {{0, -11, 32}, {9, -11, 9}, {14, -15, 19}}, {{2, -9, 33}, {9, -11, 9}, {15, -13, 20}}, {{2, -9, 32}, {9, -11, 9}, {16, -7, 23}}, {{2, -9, 33}, {9, -11, 9}, {17, -11, 19}}, {{3, -12, 34}, {8, -4, 13}, {8, -15, 25}}, {{0, -10, 28}, new int[3], {19, -8, 12}}, {{0, -9, 35}, {8, -4, 13}, {9, -9, 22}}, {{0, -10, 33}, new int[3], new int[3]}, {{9, -4, 24}, new int[3], new int[3]}, {{10, -4, 22}, new int[3], new int[3]}, {{0, -9, 32}, {8, -4, 9}, {10, -10, 18}}, {{2, -7, 34}, {8, -4, 9}, {11, -8, 16}}, {{2, -8, 33}, {8, -4, 9}, {12, -8, 15}}, {{2, -7, 33}, {8, -4, 9}, {13, -12, 16}}, {{0, -11, 32}, {7, -5, 9}, {14, -15, 19}}, {{2, -9, 33}, {7, -5, 9}, {15, -13, 20}}, {{2, -9, 32}, {7, -5, 9}, {16, -7, 23}}, {{2, -9, 33}, {7, -5, 9}, {17, -11, 19}}, {{0, -9, 32}, {2, -10, 11}, {10, -10, 18}}, {{2, -7, 34}, {3, -11, 9}, {11, -8, 16}}, {{2, -8, 33}, {4, -9, 9}, {12, -8, 15}}, {{2, -7, 33}, {5, -11, 11}, {13, -12, 16}}, {{0, -11, 32}, {2, -10, 11}, {14, -15, 19}}, {{2, -9, 33}, {3, -11, 9}, {15, -13, 20}}, {{2, -9, 32}, {4, -9, 9}, {16, -7, 23}}, {{2, -9, 33}, {5, -11, 11}, {17, -11, 19}}, {{1, -8, 38}, new int[3], {18, -8, 21}}, {{1, -8, 39}, new int[3], {18, -8, 22}}, {{1, -10, 43}, new int[3], {18, -11, 26}}};
   private static int[] ar = new int[]{-2, -6, 22, 21, 19, 22, 10, -2, -2, 5, 19};
   private static int[] as = new int[]{9, 22, 25, 17, 26, 37, 36, 49, 50, 52, 36};
   private static int[][] at = new int[][]{{2, 1, 1, 5, 3}, {2, 4, 3}, {2, 3}, {2, 1, 3}, {6, 3}, {2, 7, 3}, {2, 8, 3}, {2, 9, 3}, {2, 3}, {1, 3}, {2, 3}};
   private static int[][] au = new int[][]{{0, 1, 2, 5, 0}, {3, 4, 0}, {6, 0}, {7, 8, 0}, {9, 0}, {10, 11, 0}, {12, 13, 0}, {14, 15, 0}, {16, 0}, {17, 0}, {18, 0}};
   private static int[][] av = new int[][]{{0, 360, 1128, 0, 0}, new int[3], new int[2], {0, 2784, 0}, {1248, 0}, new int[3], new int[3], new int[3], new int[2], new int[2], new int[2]};
   private static int[][] aw = new int[][]{new int[5], new int[3], new int[2], new int[3], {408, 0}, new int[3], new int[3], new int[3], new int[2], new int[2], new int[2]};
   private static int[][] ax = new int[][]{{15, 1, 1, 2, 2, 1, 2, 4, 5, 3}, {6, 15, 1, 2, 1, 2, 1, 2, 1, 2, 4, 5, 3}, {6, 1, 2, 8, 11, 4, 7, 1, 2, 1, 2, 3}, {8, 9, 15, 12, 14, 10, 4, 16, 5, 1, 2, 3}, {7, 17}, {4, 1, 2, 17}, {8, 9, 15, 12, 14, 10, 4, 18, 4, 7, 3}, {1, 2, 4, 5, 3}, {6, 4, 19, 3}, {4, 20, 21, 3}, {4, 3}, {4, 22, 3}, {23, 4, 7, 4, 3}, {23, 25, 4, 7, 24, 26, 3}, {27, 4, 7, 4, 28, 3}, {4, 31, 32, 7, 4, 31, 4, 7, 4, 8, 17, 3}, {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 29, 3}, {4, 30, 3}, {15, 31, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 33, 17, 3}};
   private static int[][] ay = new int[][]{{1, -4, -1, -1, -4, -4, -4, 0, 20000, 0}, {0, 2, -4, -4, -5, -5, -5, -5, -5, -5, 1, 20000, 0}, {0, -5, -5, 0, 0, 2, 0, 55, 55, -4, -4, 0}, {0, 1, 0, 2, 3, 4, 3, 432, 20000, -4, -4, 0}, {0, 4}, {4, 55, 55, 0}, {0, 5, 3, 6, 7, 8, 5, 2, 6, 0, 0}, {-4, -4, 7, 20000, 0}, {0, 8, 0, 0}, {9, 0, 0, 0}, {10, 0}, {11, 0, 0}, {0, 12, 0, 13, 0}, {0, 0, 14, 0, 600, 0, 0}, {0, 15, 0, 16, 0, 0}, {17, 0, 0, 0, 55, 0, 56, 0, 57, 0, 94, 0}, {18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 0, 0}, {54, 0, 0}, {4, 0, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 0, 0, 0}};
   private static int[][] az = new int[][]{{5, 26, 30, 33, 41, 48, 53, 57, 58, 60}, {5, 6, 8, 9, 18, 20, 30, 32, 39, 40, 60, 63, 67}, {5, 6, 7, 13, 14, 19, 21, 34, 35, 60, 79, 80}, {1, 2, 3, 20, 50, 80, 85, 90, 92, 93, 95, 0}, {5, 6}, {10, 12, 13, 50}, {1, 2, 3, 4, 5, 6, 17, 18, 19, 20, 21}, {5, 10, 20, 30, 32}, {5, 10, 15, 20}, {10, 15, 20, 25}, {20, 25}, {10, 12, 14}, {15, 30, 35, 45, 55}, {10, 12, 30, 40, 45, 50, 75}, {15, 30, 35, 45, 53, 55}, {10, 12, 13, 40, 50, 60, 70, 80, 90, 95, 100, 105}, {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47}, {10, 12, 14}, {10, 11, 60, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74}};
   private static int[][] aA = new int[][]{{1344, 288}, {816, 48}, {816, 192}, {744, 192}, {144, 264}, {1440, 96}, {1368, 288}, {1128, 288}, {840, 312}};
   private static int[] aB = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 4, 0, 3, 0, 6, 0, 2, 0, 5, 0, 4, 0, 1, 0, 3, 0, 0, 0, 5, 0, 4, 0, 3, 0, 2, 0, 2, 0, 1, 0, 0, 0, 0, 0, 3, 0, 3, 0, 0, 2, 1, 3, 2, 2};
   private static int[] aC = new int[]{0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 2, 0, 2, 3, 0, 0, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 4, 0, 4, 0, 1, 2, 1, 2, 0, 1, 2, 1, 2, 1, 2};
   private static String[] aD = new String[]{"Chơi mới", "Chơi tiếp", "Chỉ dẫn", "Game khác", "Thoát"};
   private static String[][] aE = new String[][]{{"Rừng trúc đây rồi!", "Hôm nay ta phải hạ được con quái vật đó!", "Nó chắc quanh quẩn đây thôi!"}, {"Bọn quái vật nhãi nhép này làm gì được ta chứ!"}, {"Con quái vật hung hăng kia rồi!", "Ngươi phải đền tội vì những gì gây ra!"}, {"Ninja School 1 crack miễn phí key kích hoạt và sms trong game...", "Upload miễn phí tại wapsite http://giaitri321.pro...", "http://giaitri321.pro là wapsite giải trí miễn phí trên di động.", "Nhớ nhé các bạn. Chúc các bạn vui vẻ...", "Thân! Admin GiaiTri321.Pro...", "Các con biết phải làm gì rồi chứ?", "Đây là lúc các con chứng minh khả năng của mình.. ", "Đi đi. Và hãy cẩn thận đấy !!"}, {"Chết đi, con quái vật hung hăng kia !!!", "Hahahaha!"}, {"Chào mừng ngươi đến với trường đào tạo ninja Hirosaki.", "Ta là Okamesama, hiệu trưởng trường này.", "Tại đây chúng ta sẽ đào tạo các ngươi, trở thành những ninja chuyên nghiệp.", "Giáo viên chủ nhiêm của ngươi là thầy Takanashi", "Hãy đến gặp thầy để nhận bài tập.", "Có vấn đề gì, ngươi có thể hỏi những đồng môn của mình.", "Chúc ngươi sớm đạt được thành công nhé."}, {"Vâng, thưa thầy!"}, {"Con đường hoa đào đây rồi.", "Con bé ấy đâu rồi nhỉ?"}, {"Chào bạn! Bạn có phải là em gái cô Ayumi không?", "Thầy Takanashi bận nên nhờ mình đón bạn giúp.", "Đi theo mình nhé, chúng ta sẽ về trường!"}, {"Tốt lắm, con đã đưa cô bé về an toàn!", "Đây ta có món quà gì giá trị để tặng con..", "Đây là tấm bằng lái xe có chữ ký của ta. Kể từ nay con có thể sử dụng những chiếc xe máy rồi!", "Nhớ phải lái cẩn thận và đội mũ bảo hiểm, nếu không là CSGT phạt đó!"}, {"Thuỷ quái hạ nguồn sông Waramato, con quái trong truyền thuyết !", "Một khi nó chưa bị tiêu diệt, ta sẽ không đi tiếp!"}, {"Chết đi, con quái vật kia!", "Từ nay con sông này sẽ trở lại thanh bình rồi!", "Ta tiếp tục cuộc hành trình thôi!"}, {"Ngươi cũng lặn lội đến tận đây được à, khá đấy!", "Hãy bỏ ngôi trường ấy đi, theo ta lập căn cứ, ngươi sẽ có tất cả.", "Nếu không theo ta, ngươi sẽ hối hận đấy... HaHaHa!"}, {"Không đời nào, tên phản bội kia!"}, {"Ngươi khá lắm! Hãy đợi đấy, ta sẽ nhớ mối thù này!", "Hẹn gặp lại ngươi!!!"}, {"Chúng ta lại gặp nhau rồi!", "Ta cho ngươi một cơ hội lần cuối. hãy theo ta, hoặc là chết!"}, {"Haha. Tên phản bội kia, ta sẽ cho mi biết sức mạnh một ninja thực thụ!"}, {"Cuối cùng thì mi cũng đã phải dền tội!"}, {"Các con hãy cho biết làm cách nào để di chuyển!"}, {"Sử dụng phím mũi tên hoặc phím 2,4,6,8!"}, {"Làm thế nào để tấn công?, Kunio"}, {"Sử dụng phím 5 hoặc phím chọn giữa!"}, {"Làm thế nào để trò chuyện với bạn bè hoặc thầy cô?,Lee"}, {"Đứng gần người đó rồi bấm Giao Tiếp!"}, {"Làm thế nào để biết mình đang ở đâu! Katashi"}, {"Chọn menu/Xem bản đồ!"}, {"Làm thế nào khi hết HP hoặc MP! Toniku"}, {"Chọn menu/Sử dụng Item, chọn một bình HP/MP để sử dụng!"}, {"Uhm..Nếu không còn bình HP/MP nào thì sao? Minori"}, {"Gặp ông bán hàng mua tại trường, ở gần ký túc xá!"}, {"Tốt. Làm thế nào để di chuyển nhanh từ khu vực này đến khu vực khác?"}, {"Mở bản đồ, chọn 1 địa điểm để di chuyển đến!"}, {"Đúng rồi, Làm sao để sử dụng phi tiêu?,Ryuu"}, {"Bấm phím 1 sẽ chuyển sang chế độ phi tiêu.", "Bấm phím 1 lần nữa để quay lại đánh kiếm!"}, {"Tốt. Làm sao để sử dụng khinh công?"}, {"Học khinh công từ cô Ayumi. Bấm phím mũi tên lên hoặc phím 2 nhiều lần!"}, {"Uhm..Làm sao để độn thổ!"}, {"Học độn thổ từ thầy Honda. Bấm và giữ luôn phím xuống hoặc phím 8!"}, {"Khi nào mới có thể lái xe môtô?"}, {"Học lái xe từ thầy Takanashi, được cấp bằng lái", "Sau đó có thể nhảy lên chạy bất kỳ chiếc mô tô nào !"}, {"Làm sao để chạy trên mặt nước? huh ? Sadao"}, {"Học thuật chạy nước/ lặn nước từ thầy Honda! Sau đó có thể chạy trên mặt nước!"}, {"Làm sao để biến hình!"}, {"Bấm phím 7. Sau khi đã học phép biến hình từ thầy Hiroyaki"}, {"Làm sao để tàng hình!"}, {"Bấm phím 3. Sau khi đã học phép tàng hình từ thầy Honda"}, {"Tốt! Cho ta biết ai phát triển game này!"}, {"Nhóm TeaMobile!"}, {"Cụ thể là ai?"}, {"...Con không biết..."}, {"Hmm, có thể tìm thêm nhiều game hay khác ở đâu?"}, {"giaitri321.pro hay www.giaitri321.pro"}, {"Tốt, các con có thể giải tán !"}, {"Chúng con chào thầy !"}, {"Cảm ơn, mi thật tốt bụng. Hẹn gặp lại!", "Quên mất, lúc nãy cô Ayumi dặn ta gặp cô ấy ngay.", "Hihi, gặp lại mi sau!"}, {"Sakura, bạn có sao không!"}, {"Mình không sao, bạn không bị thương chứ!"}, {"Mình cũng không sao! Tên Toniku chắc cũng không chạy xa được đâu , hắn cũng sớm bị bắt thôi!", "Chúng ta về thôi!"}, {"Toniku, ngươi đã biết tội chưa!"}, {"..vâng..con biết...."}, {"Theo nội quy của nhà trường. Ngươi phải rời khỏi ngôi trường này.", "Vĩnh viễn không được trở lại nữa.."}, {"......"}, {"Thưa thầy...", "Toniku vốn là học sinh giỏi của trường..", " Chỉ vì nghe lời xúi giục của bọn xấu nên mới hành động như thế...", "Đây là lần vi phạm đầu tiên, xin nhà trường tha thứ cho bạn ấy..."}, {"......"}, {"Xin các thầy hãy tha thứ cho bạn ấy ạ!"}, {"..thôi được rồi..", "Tội Toniku rất nặng, đáng lẽ ra phải bị đuổi học.", "Con đường để thành một nhẫn giả thật gian lao và chông gai..", "..ngươi phải luyện tập bằng khả năng và sức lực của mình", " sẽ không có con đường nào khác", " ... các con đều biết chữ Nhẫn gồm chữ Đao và chữ Tâm.", "..nếu Tâm không tịnh thì Đao sẽ bổ xuống!", "Các con hãy lấy Toniku mà làm gương ...", "Toniku, ngươi đã quá tham lam...", "..nhưng ta cũng thây nơi con người ngươi có tố chất tiềm tàng!", "Nên ta quyết định tha cho con lần này...", "Sẽ không có lần sau, Toniku, ngươi nhớ đấy!!"}, {"Vâng, con xin cảm ơn thầy!"}, {"Sẵn đây ta muốn nhắc nhở thêm các con..", "Hai tháng nữa là đến kỳ thi kết khoá cho Genin. Các con phải cố gắng tập luyện hơn nữa..", "..Mọi thứ chỉ mới bắt đầu thôi!"}, {"Vâng, chúng con xin nghe!"}};
   private static String[] aF = new String[]{"Trường đạo tạo Ninja Hirosaki, Mùa thu 1937", "2 ngày sau, tại rừng trúc...", "Chỉ dẫn: Dùng phím 5 để tấn công.", "6 tháng trước, tại trường Hirosaki...", "2 ngày sau, tại trường Hirosaki..."};
   private static String[][] aG = new String[][]{{"Chúng ta đi thôi!"}, {"Muốn rủ ta đi chơi à!", "Ta chỉ chơi với những người cùng trình độ thôi.", "Ngươi hãy tập luyện đi, bao giờ khá hơn thì quay lại. Đừng ở đó tán gái nữa!"}, {"Muốn rủ ta cùng đi à?", "OK, nhưng chỉ một lúc thôi nhé, nếu không chị Ayumi mắng ta đó!"}, {"Ta muốn đến miếu Koujin chơi, mi có thể dẫn đường chứ!", "Nếu sợ, mi có thể ở nhà, ta sẽ tự đi. Haha!"}};
   private static int[][][] aH;
   private static int[] aI;
   private static int[] aJ;
   private static int aK;
   private static a aL;
   private static boolean aM;
   private static boolean aN;
   private static int aO;
   private static int aP;
   private static boolean aQ;
   private static boolean aR;
   private static boolean[] aS;
   private static boolean[] aT;
   private static int aU;
   private static int aV;
   private static int aW;
   private static int aX;
   private static int aY;
   public static boolean b;
   public static boolean c;
   private static int aZ;
   private static int ba;
   private static int bb;
   private static int bc;
   private static int bd;
   private static int be;
   public static int d;
   private static boolean bf;
   public static int[] e;
   public static int[] f;
   public static int g;
   public static int h;
   public static int i;
   public static int j;
   public static int k;
   public static int l;
   public static int m;
   public static String n;
   public static String o;
   private static int bg;
   private static int bh;
   private static int bi;
   private static int bj;
   private static int bk;
   private static int bl;
   private static int bm;
   private static int bn;
   private static int bo;
   private static int bp;
   private static int bq;
   private static int br;
   private static int bs;
   private static int bt;
   private static int bu;
   private static int bv;
   private static String bw;
   private static int bx;
   private static int by;
   private static int bz;
   private static int bA;
   private static int bB;
   private static int bC;
   public static int p;
   public static int q;
   public static int r;
   private static int bD;
   private static int bE;
   private static int bF;
   private static int bG;
   private static int bH;
   private static int bI;
   private static int bJ;
   private static int bK;
   private static int bL;
   private static int bM;
   private static int bN;
   private static int[] bO;
   private static int[] bP;
   private static int[] bQ;
   private static int[] bR;
   private static int[] bS;
   private static int[] bT;
   private static int bU;
   private static int[] bV;
   private static int[] bW;
   private static int[] bX;
   private static int[] bY;
   private static int[] bZ;
   private static int[] ca;
   private static int[] cb;
   private static int[] cc;
   private static int[] cd;
   private static int[] ce;
   private static int[] cf;
   private static int[] cg;
   private static int[] ch;
   private static int[] ci;
   private static int[] cj;
   private static int[] ck;
   private static int[] cl;
   private static int[] cm;
   private static boolean cn;
   private static int co;
   private static String cp;
   private static int cq;
   private static int[] cr;
   private static int[] cs;
   private static int[] ct;
   private static int[] cu;
   private static int[] cv;
   private static int[] cw;
   private static int[] cx;
   private static int[] cy;
   private static int[] cz;
   private static int[] cA;
   private static int[] cB;
   private static int[] cC;
   private static int[] cD;
   private static int[] cE;
   private static int[] cF;
   private static int[] cG;
   private static int[] cH;
   private static int[] cI;
   private static int[] cJ;
   private static int[] cK;
   private static int[] cL;
   private static int[] cM;
   private static int cN;
   private static int[] cO;
   private static int[] cP;
   private static int[] cQ;
   private static int[] cR;
   private static int[] cS;
   private static int[] cT;
   private static int[] cU;
   private static int[] cV;
   private static int cW;
   private static int[] cX;
   private static int[] cY;
   private static int[] cZ;
   private static int[] da;
   private static int[] db;
   private static int[] dc;
   private static boolean[] dd;
   private static int de;
   private static int df;
   private static int[] dg;
   private static int[] dh;
   private static int[] di;
   private static int[] dj;
   private static int[] dk;
   private static int[] dl;
   private static int[] dm;
   private static int[] dn;
   private static boolean doFlag;
   private static int dp;
   private static int dq;
   private static int dr;
   private static int ds;
   private static int dt;
   private static boolean[] du;
   private static int dv;
   private static String[][] dw;
   private static boolean dx;
   private static boolean dy;
   private static int dz;
   private static int[] dA;
   private static int[] dB;
   private static int[] dC;
   private static int[] dD;
   private static int[] dE;
   private static int[] dF;
   private static int[] dG;
   private static int[] dH;
   private static int[] dI;
   private static int[] dJ;
   private static int[] dK;
   private static int[] dL;
   private static int[] dM;
   private static int[] dN;
   private static int[] dO;
   private static String[] dP;
   private static int[] dQ;
   private static int[] dR;
   private static int[] dS;
   private static int[] dT;
   private static int[] dU;
   private static int[] dV;
   private static int dW;
   private static int dX;
   private static int dY;
   private static Image[][] dZ;
   private static Image[] ea;
   private static Image eb;
   public static Image[] s;
   private static Image[] ec;
   private static Image ed;
   private static Image[] ee;
   private static Image ef;
   public static Image t;
   public static Image u;
   private static Image[] eg;
   private static Image[] eh;
   private static Image ei;
   private static Image[] ej;
   private static Image[][] ek;
   private static Image[] el;
   private static Image[] em;
   private static Image[] en;
   private static Image[] eo;
   private static Image[] ep;
   private static Image[] eq;
   private static Image[] er;
   private static Image[] es;
   private static Image[][] et;
   private static Image[][] eu;
   private static Image[] ev;
   private static Image[] ew;
   private static Image[] ex;
   private static Image[] ey;
   private static Image[] ez;
   private static Image[] eA;
   private static Image eB;
   private static Image[] eC;
   private static Image[] eD;
   private static Image[] eE;
   public static int v;
   public static int w;
   private static boolean eF;
   private static boolean eG;
   private static boolean eH;
   private static boolean eI;
   /** Cờ: nhân vật đã học phép khinh công (ảnh hưởng bộ hành / dialog nhiệm vụ). */
   private static boolean khinhCong;
   private static boolean eK;
   private static boolean eL;
   private static boolean eM;
   private static boolean eN;
   private static boolean eO;
   private static boolean eP;
   private static boolean eQ;
   private static boolean eR;
   private static boolean eS;
   private static boolean eT;
   private static boolean eU;
   private static boolean eV;
   /** Khinh công cấp 2: đẩy lên lần 2 trên không (C == 1). */
   private static boolean khinhCongCap2;
   /** Khinh công cấp 3: nhảy ban đầu cao hơn + đẩy lên lần 3 trên không (C == 2). */
   private static boolean khinhCongCap3;
   private static boolean eX;
   private static boolean eY;
   private static boolean eZ;
   private static boolean fa;
   private static boolean fb;
   private static boolean fc;
   private static int fd;
   private static int fe;
   public static int x;
   private static int ff;
   private static int fg;
   public static int y;
   public static int z;
   public static int A;
   public static int B;
   private static int fh;
   private static int fi;
   private static int fj;
   private static int fk;
   private static int fl;
   private static int fm;
   private static int fn;
   public static int C;
   public static int D;
   private static int fo;
   public static int E;
   public static int F;
   public static int G;
   public static int H;
   public static int I;
   public static int J;
   public static int K;
   public static int L;
   private static int fp;
   private static int fq;
   private static int fr;
   /** @deprecated logic dash → {@link DashSkill}; giữ field trống để tránh lệch save/layout cũ nếu có tham chiếu. */
   private static long dashLastTapMillisLeft = -999999L;
   private static long dashLastTapMillisRight = -999999L;
   private static int dashPixelsRemaining;
   private static long dashStartMillis;
   /** Thời gian (ms) dash từ A → B. Giảm (vd. 80–150) = cảm giác dịch chuyển tức thời; 1000 = ~1 giây. */
   public static int dashDurationMs = 200;
   /** Đã học kỹ năng dash (đúp trái/phải). */
   public static boolean dashLearned;
   /** Cấp dash (1+); gọi {@link #syncDashDurationToLevel()} sau khi tăng cấp. */
   public static int dashLevel = 1;
   /** MP mỗi lần dash; 0 = tự tính theo {@link #dashLevel} (8 + level×6). */
   public static int dashManaCost = 0;
   /** @deprecated → {@link DashSkill#STATE_DASH} và hằng trong {@link DashSkill}. */
   private static final int PLAYER_STATE_DASH = 25;
   /** Đã học kỹ năng ám sát (phím 9). */
   public static boolean amSatLearned;
   /** MP tiêu hao mỗi lần ám sát. */
   public static int amSatManaCost = 40;
   /** @deprecated → hằng trong {@link AmbushSkill}. */
   private static final int AMSAT_RANGE = 500;
   private static final int AMSAT_BEHIND_OFFSET = 22;
   private static final int AMSAT_GROUND_Y_TOLERANCE = 48;
   private static boolean fs;
   private static int ft;
   private static int fu;
   /** Cấp độ nhân vật (level). */
   public static int characterLevel;
   public static int N;
   private static boolean fv;
   private static boolean fw;
   private static boolean fx;
   private static boolean fy;
   /** Chỉ số nhiệm vụ đang làm (-1 = không có nhiệm vụ active). */
   public static int currentQuestIndex;
   private static int fz;
   private static int fA;
   private static boolean fB;
   private static boolean fC;
   private static int fD;
   private static int fE;
   private static int fF;
   private static int fG;
   private static int fH;
   private static int fI;
   private static int fJ;
   private static int fK;
   private static int fL;
   private static int fM;
   private static int fN;
   private static int fO;
   private static int fP;
   private static int fQ;
   private static int fR;
   private static int fS;
   private static boolean fT;
   private static int fU;
   private static int fV;
   public static int P;
   public static int Q;
   private static boolean fW;
   private static String[] fX;
   private static int fY;
   private static int fZ;
   private static int ga;
   private static boolean gb;
   private static int gc;
   private static int gd;
   private static int ge;
   private static int gf;
   private static int gg;
   private static int gh;
   private static int gi;
   private static int gj;
   private static int gk;
   private static boolean gl;
   private static int gm;
   private static int gn;
   private static int go;
   private static int gp;
   private static int gq;
   private static int gr;
   private static int gs;
   private static int gt;
   private static int gu;
   private static int gv;
   private static int gw;
   private static int gx;
   private static int gy;
   private static int gz;
   private static int gA;
   private static int gB;
   private static int gC;
   private static int gD;
   private static int gE;
   private static int gF;
   private static int gG;
   private static int gH;
   private static int gI;
   private static int gJ;
   private static int gK;
   private static int gL;
   private static int gM;
   private static long gN;
   private static boolean gO;
   private static int gP;
   private static int gQ;
   private static int gR;
   private static int gS;
   private static int gT;
   private static int gU;
   private static int gV;
   private static int gW;
   private static int gX;
   private static int gY;
   private static int gZ;
   private static int ha;
   private static int hb;
   private static int hc;
   private static boolean hd;
   private static boolean he;
   private static boolean hf;
   private static int hg;
   private static int hh;
   private static int hi;
   private static boolean hj;
   private static int hk;
   private static int hl;
   private static int hm;
   private static int hn;
   private static int ho;
   private static int hp;
   private static int hq;
   private static int hr;
   private static int hs;
   private static int ht;
   private static int hu;
   private static int hv;
   private static int hw;
   private static int hx;
   private static int[][] hy;
   private static int[][] hz;
   private static int[][] hA;
   private static int[][] hB;
   private static int[][] hC;
   private static int[][] hD;
   private static int[] hE;
   private static int[] hF;
   private static int[] hG;
   private static int[] hH;
   private static int[] hI;
   private static int[] hJ;
   private static boolean hK;
   private static int hL;
   private static int hM;
   private static int hN;
   private static int hO;
   private static int hP;
   private static int hQ;
   private static int hR;
   private static int hS;
   private static int hT;
   private static int hU;
   private static int hV;
   private static int hW;
   private static int hX;
   private static int hY;
   private static int hZ;
   private static int ia;
   private static int ib;
   private static int ic;
   private static int id;
   private static int ie;
   private static boolean ifFlag;
   private static int ig;
   private static int ih;
   private static int ii;
   private static int ij;
   private static int ik;
   private static int[] il;
   private static int[] im;
   private static int[] in;
   private static int[] io;
   private static int[] ip;
   private static int[] iq;
   private static int ir;
   private static int is;
   private static int[] it;
   private static int[] iu;
   private static int[] iv;
   private static int[] iw;
   private static int[] ix;
   private static int[] iy;
   private static int[] iz;
   private static boolean iA;
   private static int iB;
   private static int iC;
   private static int iD;
   private static int iE;
   private static String[][] iF;
   private static int iG;
   private static int iH;
   private static int iI;
   private static int iJ;
   private static int iK;
   private static int iL;
   private static String iM;
   private static int iN;
   private static int iO;
   private static int iP;
   private static int iQ;
   private static byte[] iR;
   private static int[] iS;
   private static boolean[] iT;
   private static Image iU;
   private static Image iV;
   private static Image iW;
   private static Image[] iX;
   private static int iY;
   private static int[] iZ;
   private static int[] ja;
   private static int[] jb;
   private static int[] jc;
   private static int[] jd;
   private static Image je;
   private static int jf;
   private static int jg;
   private static int jh;
   private static int ji;
   private static int jj;
   private static String[] jk;
   private static int[] jl;
   private static int[] jm;
   private static int[] jn;
   private static int jo;
   private static int jp;
   private static int jq;
   private static int jr;
   private static int js;
   private static int jt;
   private static int ju;
   private static int jv;
   private static int jw;
   private static int jx;
   private static int jy;
   private static int jz;
   private static int jA;
   private static int jB;
   static int R;
   private static int jC;
   static int S;
   private static Image jD;
   private static Image jE;
   private static int jF;
   private static int jG;
   public static boolean T;
   private static Image[][][] jH;
   private static int jI;
   private static int jJ;
   private static int[] jK;
   private static int[] jL;
   private static int[] jM;
   private static int[] jN;
   private static int[] jO;
   private static int[] jP;
   private static int[] jQ;
   private static int[] jR;
   private static int[] jS;
   private static int[] jT;
   private static int[] jU;
   private static int[] jV;
   private static int[] jW;
   private static int[] jX;
   private static int[] jY;
   private static int[] jZ;
   private static int[] ka;
   private static int[] kb;
   private static int[] kc;
   private static int[] kd;
   private static int[] ke;
   private static int[] kf;
   private static int[] kg;
   private static int[] kh;
   private static int[] ki;
   private static boolean[] kj;
   private static int[][] kk;
   private static int[][] kl;
   private static boolean[][] km;
   private static int[] kn;
   private static int[] ko;
   static int U;
   private static int kp;
   private static int kq;
   private static int kr;
   private static int ks;
   private static int kt;
   private static int[] ku;
   private static String[][] kv;
   private static String[][] kw;
   private static int[][] kx;
   private static Image[] ky;
   private static String[][] kz;
   private static String[][] kA;
   private static int kB;
   private static int kC;
   private static int kD;
   private static int kE;
   private static int[] kF;
   private static String[] kG;
   static int[] V;
   private static int[] kH;
   /** 6 ô hàng dưới túi đồ (chưa lưu save). */
   private static int[] kBagExt;
   private static Image[] kI;
   private static int kJ;
   private static int kK;
   private static int kL;
   private static String[] kM;
   private static String[] kN;
   private static int[] kO;
   public static boolean[] W;
   private static int[] kP;
   private static int[] kQ;
   private static int[] kR;
   private static int[] kS;
   private static Image kT;
   private static Image kU;
   private static int kV;
   private static int kW;
   private static int kX;
   private static int kY;
   private static int kZ;
   private static int la;
   private static int lb;
   private static int lc;
   private static int ld;
   private static int le;
   private static int lf;
   private static int lg;
   private static int lh;
   private static int li;
   private static int lj;
   private static String lk;
   private static Image ll;
   private static boolean lm;
   private static int ln;
   public static int X;
   private static int lo;
   private static int lp;
   private static int lq;
   private static String lr;
   private static String ls;
   private static String[] lt;
   private static Image[][] lu;
   private static int lv;
   private static int[] lw;
   private static int[] lx;
   private static int[] ly;
   private static String[][] lz;
   private static String[][] lA;
   private static String[][] lB;
   private static String[][] lC;
   private static String[][] lD;
   private static String[] lE;
   private static int[] lF;
   /** Số lượng / mục tiêu cần đạt để hoàn thành nhiệm vụ (theo {@link #currentQuestIndex}), song hành với {@link #lF}. */
   private static int[] questRequiredAmounts;
   private static int[] lH;
   private static int lI;
   private static int lJ;
   private static int lK;
   private static int lL;
   private static boolean lM;
   private static String[] lN;
   private static String[] lO;
   public static int Y;
   private static int lP;
   private static int lQ;
   private static Font lR;
   private static Font lS;
   private static int lT;
   private String lU = "12345678";
   private int lV;
   private static String lW;
   private static int[] lX;
   private static int lY;
   private int lZ = 0;
   private boolean ma = false;
   private String mb = "";
   private int mc;
   private int md;

   static {
      aH = new int[aq.length][3][3];

      for(int var0 = 0; var0 < aq.length; ++var0) {
         for(int var1 = 0; var1 < 3; ++var1) {
            for(int var2 = 0; var2 < 3; ++var2) {
               aH[var0][var1][var2] = aq[var0][var1][var2];
               if (var1 == 0 && var2 == 0) {
                  switch (aq[var0][var1][var2]) {
                     case 1:
                     case 2:
                        aH[var0][var1][var2] = 1;
                        break;
                     default:
                        aH[var0][var1][var2] = 0;
                  }
               }
            }
         }
      }

      aI = new int[]{-1, 2, 1, -2};
      aJ = new int[]{-3, 2, -1, 1};
      aK = -1;
      aM = true;
      aS = new boolean[14];
      aT = new boolean[14];
      aY = 0;
      bw = "";
      bH = -22;
      bI = 18;
      bJ = -10;
      bK = -19;
      bL = -12;
      bM = -26;
      khinhCong = false;
      eK = false;
      eL = false;
      eM = false;
      eN = false;
      eO = false;
      eP = false;
      eQ = false;
      eR = false;
      eS = false;
      eT = false;
      eU = false;
      eV = false;
      khinhCongCap2 = false;
      khinhCongCap3 = false;
      eX = false;
      eY = false;
      eZ = false;
      fa = false;
      skillSetAmSatLearned(false);
      skillSetDashLearned(false);
      dashLevel = 1;
      syncSkillsFromLegacyFlags();
      fb = false;
      fc = false;
      fv = true;
      fT = false;
      fV = 0;
      fX = new String[]{""};
      ga = 0;
      gc = -1;
      gi = 1;
      gl = false;
      gn = -1;
      hk = 500;
      hl = 60;
      hm = 60;
      hL = 20;
      hM = 60;
      hP = 50;
      ie = 10;
      ik = -1;
      is = -1;
      iA = false;

      try {
         Image.createImage("/attkButton.png");
      } catch (IOException var3) {
      }

      iM = "oplj";
      jf = 24;
      R = 0;
      jC = 0;
      S = 0;
      kn = null;
      ko = new int[]{0, 10, 15, 20};
      ku = new int[]{12281360, 13859359, 15439166, 16693877, 16765346, 16777215, 16765346, 16693877, 15439166, 13859359, 12281360};
      kv = Item.getAllItemCanByName();
      kw = new String[][]{{"2000vnđ / 50 bình", "3000vnđ / 50 bình", "3000vnđ / 30 bình", "2000vnđ / 50 bình", "2000vnđ / 30 bình", "3000vnđ / 50 bình"}, {"2000vnđ", "3000vnđ", "3000vnđ", "5000vnđ"}};
      kx = Item.getAllItemCanByPrice();
      kz = new String[][]{{"BinhHP_Nho(50)", "BinhHP_Vua(50)", "BinhHP_To(30)", "BinhMP_Nho(50)", "BinhMP_Vua(30)", "BinhMP_To(50)"}, {"KiemTre", "ThuyLinhKiem", "HoaGiacKiem", "LongGiaoKiem"}};
      kA = new String[][]{{"sms://8222", "sms://8322", "sms://8322", "sms://8222", "sms://8222", "sms://8222"}, {"sms://8122", "sms://8322", "sms://8422", "sms://8522"}};
      kF = new int[]{12281360, 13859359, 15439166, 16693877, 16765346, 16777215, 16765346, 16693877, 15439166, 13859359, 12281360};
      kG = Item.getAllItemNames();
      V = new int[]{5, 2, 1, 5, 2, 1};
      kH = new int[]{100, 400, 1000, 100, 200, 300};
      kBagExt = new int[]{2, 0, 0, 1, 0, 0};
      kM = new String[]{"Sử dụng item", "Xem bản đồ", "Lưu và thoát", "Nhạc: Bật"};
      kN = map.getAllMapNames();
      kO = new int[]{50, 60, 70, 80, 90, 70, 100, 120, 150, 180, 220, 250, 300, 320, 350, 370, 390, 420, 450};
      W = new boolean[19];
      kP = new int[]{49, 31, 98, 112, 106, 42, 75, 84, 37, 39, 80, 117, 157, 201, 208, 170, 186, 219, 161};
      kQ = new int[]{35, 65, 38, 75, 98, 97, 95, 128, 142, 185, 212, 189, 189, 204, 156, 142, 96, 59, 39};
      kR = new int[]{62, 52, 17, 4, 8, 12, 14, 5, 1, 2, 3, 2, 2, 2, 2, 1, 2, 3, 1};
      kS = new int[]{17, 9, 12, 9, 10, 5, 9, 7, 12, 11, 4, 11, 8, 9, 7, 6, 11, 16, 8};
      lk = "Chuyển đến";
      lz = new String[][]{{"..."}, {"Đây là khu vực luyện tập, cứ yên tâm, nếu bị thương ta sẽ giúp đỡ.", "Đôi khi tập luyện với cái bù nhìn rơm đằng kia cũng mang lại nhiều bất ngờ đấy!"}, {"Thác nước này rất nguy hiểm, ta khuyên ngươi không nên xuống.", "Hãy quay lại đi, nếu có chuyện gì ta không cứu được ngươi đâu."}, {"Khu rừng trước mặt ngươi là nơi sống của bọn dơi quỷ, nhện độc và những sát thủ bị truy nã.", "Dù ngươi tài giỏi đến đâu cũng phải mất mạng khi đi ngang qua đó.", "Một số người có thể qua được bằng cách chạy thật nhanh qua.", "Nếu ngươi tự tin hãy dùng chiếc moto kia và liều một phen xem.", "Chúc ngươi may mắn."}};
      lA = new String[][]{{"Con lại tìm ta có chuyện gì?", "Thầy chủ nhiệm Con là Takanashi, mau đến gặp thầy để nhận bài tập."}, {"Chào cậu bé, ta là Kagome Ayumi, giảng viên cao cấp bộ môn Khí.", "Khí là môn đầu tiên bất kỳ học sinh nào cũng phải học khi bước vào đây.", "Bài học đâu tiên là kỹ năng khinh công. Sau khi học xong con sẽ phi thân cao hơn  gấp đôi bình thường.", "Bây giờ ta phải kiểm tra sơ bộ con. Hãy chạy thẳng về tay trái đến khu luyện tập.", "đến đó giết đủ 10 con ốc sên đá, sau đó quay lại đây!"}, {"Chào con, con đã sẵn sàng luyện tập rồi chứ?", "Hãy đến gặp cô Ayumi để học môn đầu tiên.", "Cô ấy đứng đằng kia, chúc con học tốt nhé!", "à, nếu cô ấy có hỏi gì về ta, hãy nói tốt về ta nhé, ta sẽ thưởng."}, {"Ta già cả rồi, tựa như chiếc lá khô..", "Lại đây, ta sẽ truyền hết võ công cho con...", "Toyotomi,...tình yêu của ta,....em ở nơi nào"}, {"Trình độ nhà ngươi còn quá thấp. Hãy quay lại đây khi đã học xong khinh công."}, {"Ngươi còn chưa dùng shuriken thì làm sao học phép thuật được."}, {"Ta sẽ dạy ngươi dùng shuriken nếu ngươi có đủ khả năng.", "Gần cổng trường có vài cái bù nhìn rơm, hãy đánh gãy 2 cái.", "Nhanh lên, hãy chứng tỏ sức mạnh của mình đi."}, {"Ngươi còn không mau đi đi!"}, {"Ngươi muốn học thuật ư?", "Không như những môn khác, thuật đòi hỏi ngươi phải luyện tập hàng ngày..", "Hơn thế nữa, ngươi phải học theo những quyển bí kíp.", "Ta sẽ dạy cho ngươi môn độn thổ, nếu ngươi có thể tìm được 1 quyển bí kíp từ bọn quỷ một chân", "Bọn chúng thường xuất hiện ở thác nước, bên kia khu luyện tập.", "Đi đi, hãy kiên nhẫn với từng tên , ngươi sẽ tìm thấy thôi!"}, {"Nhanh lên con, cô bé ấy đang đứng chờ ở đường hoa đào đấy!", "Nếu chậm, cô Ayumi sẽ buồn lắm đó!"}, {"Con có thể giúp ta một chuyện được không?", "Cô Ayumi có nhờ ta đón giúp cô em gái. Nhưng đúng vào lúc ta phải họp cùng thầy hiệu trưởng.", "Ta rất tin tưởng ở con, con hãy đến đầu đường hoa đào, đón cô ấy nhé!", "Nhanh lên, ta sẽ thưởng cho con nếu con làm tốt."}, {"Để trở thành 1 ninja giỏi ngươi phải có thể lực tốt.", "Ngươi có biết chữ Nin là Nhẫn không!", "Trong Nhẫn thì có Lực và Tâm..", "..để trở thành ninja thực thụ thì ngươi phải có Tâm và Lực", "....mà ta nói, ngươi có hiểu gì không.", "Hãy giết 20 con ong, rồi quay về gặp ta. Lúc đó ta sẽ giúp ngươi."}, {"Ngươi đã bao giờ vượt sông Watamoro chưa? Đó là một con sông rộng và hung dữ với thuỷ quái và sóng to.", "Ta sẽ giúp ngươi 1 cách vượt sông rất dễ dàng, nhưng ngươi phải làm một việc...", "Trong khu rừng trúc, có 1 con heo rừng thành tinh rất hung hăng..", "Hãy giết nó, mang về đây 1 quyển bí kíp nói về thuật lặn nước, ta sẽ hướng dẫn ngươi luyện.", "Đi đi, và hãy cẩn thận tính mạng nhà ngươi."}, {"Ngươi đã học được kỹ năng chạy nước rồi!", "Nếu ngươi có thể qua bên kia con sông,đến khu nghĩa địa, nhặt quyển bí kíp Ninja biến hình..", "..ta sẽ truyền thụ kỹ năng biến hình cho ngươi.", "Hãy nhớ ngươi phải đối đầu với một con quái vật to lớn bên kia sông đấy!", "Đi đi, chúc ngươi may mắn."}, {"Con biết, ta đang nghiên cứu làm ra 1 thứ thuốc, để chữa trị vết thương...", "Tuy nhiên ta thiếu 1 loại nguyên liệu rất khó kiếm.", "Nếu con có thể tìm giúp ta 15 cánh dơi vàng, ta sẽ có đền đáp xứng đáng.", "Bọn dơi vàng có mặt ở những ngôi đền phía nam. Bọn chúng rất nhanh.", "Tuy thế, ta vẫn tin con có thể mang về cho ta.", "Chúc con may mắn!"}, {"Cô Ayumi nói cho con nghe rồi à...", "Nói ra thật đáng buồn, cũng như bao trường khác, trường ta luôn có những học sinh cá biệt...", "Toniku là một trong số đó, nó đã bỏ trường thành lập băng nhóm...", "Hiện đang tụ tập quậy phá ở 3 ngôi miếu phía nam trường...", "Con là một học sinh tốt, hãy đi tìm bọn chúng bắt về cho ta.", "Làm đi, rồi báo cáo kết quả với ta nhé!"}, {"Cô bé em gái cô Ayumi cũng xinh, y như cô ấy vậy, con có thấy thế không!", "Nếu con có thể vào khu rừng gỗ, đánh gục 20 tên Quỷ khố, ta sẽ mai mối cho, haha!", "Nhưng hãy cẩn thận, bọn quái vật trong khu rừng ấy rất đông và mạnh đấy!"}, {"Hiện tại khả năng con đã rất khá rồi, ta quyết định dạy những kỹ năng cấp cao cho con.", "Đầu tiên là khinh công cấp 2.", "Tuy nhiên, con phải chứng tỏ đã thành thạo khinh công cấp 1 trước...", "Hãy nhảy lên không tung, đánh được 20 đòn trước khi chạm đất!", "Không dễ phải không..."}, {"Shuriken , một trong những vũ khí cơ bản của Ninja, ta sẽ truyền cho ngươi bộ ám khí mới này", "Vẫn như các lần trước, ngươi phải cho ta thấy đã đủ sức học...", "Đến khu rừng chông tre. Nhổ gốc 70 con quỷ hoa đỏ rồi về đây, ta sẽ dạy cho.", "Cẩn thận tính mạng ngươi đấy."}, {"Mấy hôm nay ta nhận thấy con chạy còn rất chậm..", "Một ninja chậm chạp như con không thể làm việc lớn được.", "Hãy đến vách đá Ito, mang về cho ta 50 đuôi bò cạp..", "Ta sẽ dùng độc của chúng, điều chế cho con 1 loại thuốc tăng lực...", "Cẩn thận nọc độc bọn chúng nhé! Hãy dẫn cô bé Sakura đi, nó sẽ giúp con nhiều đấy."}, {"Ta không muốn nói nhiều. Một phần thưởng đặt biệt cho ngươi..", "..nếu ngươi có thể giết được 30 con cá đỏ!"}, {"Đây là kỹ năng cuối cùng của một ninja... kỹ thuật ẩn thân", "Kỹ năng này muốn học cũng không khó, tại một thung lũng phía nam..", "có một quyển bí kíp được giấu từ ngàn năm nay.", "Hãy tìm về, ta sẽ giúp con có được kỹ năng lợi hại này."}, {"Con còn nhớ tên phản đồ Toniku lần trước không!", "Sau khi bị con đánh, hắn đã bỏ chạy đến ngôi miếu phía đông bắc.", "Nó vừa bắt mất cô bé Sakura đi rồi.", "Ta đã sai tất cả đệ tử đi tìm nó, cứu cô bé về!", "Con cũng phải thế nhé! Cô bé ấy đang chờ con đấy!"}};
      lB = new String[][]{{"Thể lực con rất tốt, ta sẽ dạy khinh công cho con...", "Hãy tập trung khí huyết, hít thở nhẹ, người con nhẹ dần, nhẹ dần tựa chiếc lá khô...", "Chúc mừng con! Hãy thử nhảy lên xem kết quả thế nào.", "à, suýt nữa ta quên, lúc nãy thầy Hiroyaki trên tầng 1 gọi con đấy."}, {"Tốt. Đây là cách phóng shuriken, hãy nhớ kỹ:", "Bấm phím 0 để chuyển sang phóng shuriken, bấm lần nữa để đánh kiếm.", "Nếu chăm chỉ tập luyện, phi tiêu sẽ là vũ khí lợi hại nhất của ngươi.", "Thầy Honda có việc cần gặp ngươi. Nhanh lại đó đi!"}, {"Giỏi lắm, đúng là quyển bí kíp này.", "Cứ luyện tập theo quyển bí kíp này: hãy đến khu vực có đất..", "Ngồi thấp xuống và tập trung, ngươi sẽ độn thổ được.", "Hãy luyện tập đi, chú ý MP ngươi sẽ bị giảm khi độn thổ đó.", "Còn chuyện này nữa, vừa nãy ta thấy thầy chủ nhiệm ngươi có vẻ mệt. Ngươi hãy nhanh ghé thăm!"}, {"Ngươi giỏi lắm, ta sẽ đã thông kinh mạch cho...", "úm ba la !! soda cacao cola!", "Ngươi có cảm nhận được luồn chân khí trong người không", "Đi đi, hãy dùng sức mạnh này để bảo vệ dân làng!"}, {"Quyển bí kíp đây rồi, khá lắm cậu bé.", "Ngươi đã có thể lặn nước được rồi. Hãy nhớ, tuy lặn được nhưng thanh trúc dùng để thở rất ngắn...", "Vì thế, đừng lặn sâu quá đó.", "Thầy Hiroyaki tìm ngươi. Hãy mau đến gặp đi."}, {"Ngươi có thể vượt qua con sông ấy ư?", "Ta sẽ giúp ngươi gọi được sức mạnh của dòng tộc mình: Xích Mao", "Bất kỳ khi nào, hãy ấn phím số 7, ngươi sẽ có được sức mạnh từ gốc cội của dòng tộc mình", "hãy thử xem, nhưng ngươi cần cẩn thận, vì thi triển thuật này,ngươi sẽ chóng mệt lắm đấy."}, {"Cảm ơn con nhiều lắm. Đây là phần thưởng cho con, 5000$", "Tuy không bao nhiêu nhưng con có thể dùng nó để mua HP, MP.", "À, trường ta đang có việc lớn đấy!", "Con hãy gặp thầy chủ nhiệm để hỏi xem có giúp được gì hay không!"}, {"Hắn bỏ trốn thoát rồi ư?", "Ta thật đau lòng khi có một đứa học trò như nó!", "Kể từ nay, ta cho phép con tấn công nó, không nương tay, bất kỳ khi nào gặp!"}, {"Ta biết chắc chắn thế nào con cũng giết được bọn quỷ khố hung hăng đó!", "Lúc nãy, ta đã nói chuyện với cô Ayumi rồi.", "Hãy lại bắt chuyện với cô bé ấy đi!"}, {"Tốt lắm. Con đã chứng tỏ được mình.", "Đây là kỹ năng khinh công cấp 2. Con đã có thể nhảy cao hơn trước rồi.", "Tiếp theo, hãy gặp thầy Hiroyaki, ông ta sẽ dạy con những kỹ năng mới!"}, {"Tốt. Đây là kỹ năng shuriken cấp 2.", "Sức tấn công từ shuriken của con đã tăng lên rất nhiều!", "Con phải siêng năng tập luyện mới có thể giữ được sức mạnh này. Nhớ đấy!"}, {"Khá lắm. Đây là phương thuốc chạy nhanh cho con!", "Hãy chạy 1 đoạn ngắn, sau đó tốc độ của con sẽ tăng nhanh..", "Hãy thử xem nào!"}, {"Giỏi. Kể từ nay con sẽ không bao giờ bị chìm dưới nước nữa!", "..đây là kỹ thuật đứng nước bí truyền của ninja. Ta chỉ dạy cho mình con đấy!"}, {"Ngươi có thể tìm được nó ư?", "Tốt lắm, từ nay con có thể sử dụng nó rồi đấy.", "Hãy nhấn phím số 9 để có thể ẩn thân. Kỹ năng này rất lợi hại..", "tuy nhiên nó sẽ tiêu thụ rất nhiều MP của con đấy!"}, {"Các con đều bình an vô sự, rất tốt!", "Những gì đã là quá khứ thì ta cho qua, nhưng hãy nhớ và không tái phạm", "Nào, ta cho các con nghỉ, điện thoại cũng có lúc phải nghì ngơi chứ, hehe. Nay , ta chúc mừng các con đã hoàn thành khóa học ninja sơ cấp: các con không còn là Chunin nữa !", "Nay ta tuyên bố thăng cấp cho các con là Genin !"}};
      lC = new String[][]{{"Nhanh lên, hãy sang khu luyện tập và giết 10 con ốc sên."}, {"Hãy đánh sập 2 bù nhìn rơm gần cổng trường. Nhanh lên!"}, {"Bọn quỷ một chân có mặt ở thác nước, bên kia khu luyện tập, mau giết chúng để tìm quyển bí kíp!"}, {"Hãy trở lại khi ngươi đã giết đủ 20 con ong."}, {"Con heo rừng rất nguy hiểm. Nhưng ta tin ngươi có thể giết được nó và cầm về cho ta quyển bí kíp. Đi đi!"}, {"Hãy đến khu nghĩa địa bên kia sông! Mang về quyển bí kíp. Nhanh lên!"}, {"Nhanh lên, hãy giết 15 con dơi vàng ở những ngôi miếu phía nam!"}, {"Hãy tìm tên Toniku, hắn trốn ở những ngôi miếu phía nam.", "Tìm gặp hắn quay lại báo cáo với ta nhé!"}, {"Hãy giết 20 con quỷ khố ở khu rừng gỗ!", "Xong việc ta sẽ giúp con cưa con bé em gái cô giáo Ayumi!"}, {"Để ta dạy kinh công cấp 2 cho con, con phải chứng tỏ được khả năng hiện tại.", "Hãy nhảy lên cao và chém được ít nhất 20 phát khi chưa chạm đất!", "Khá khó, nhưng ta tin con sẽ khẳng định được mình!"}, {"Hãy đến rừng chông tre. Giết 70 quỷ hoa đỏ rồi về đây, ta cho ngươi shuriken cấp 2!"}, {"Con hãy đến vách đá Ito, giết 50 con bò cạp, mang đuôi về cho ta!"}, {"Ta không muốn nói nhiều. Một phần thưởng đặt biệt cho ngươi..", "..nếu ngươi có thể giết được 30 con cá đỏ!"}, {"Để học kỹ năng ẩn thân, hãy đi tìm 1 quyển bí kíp...", "Cất giấu tại 1 thung lũng phía đông."}, {"Nhanh lên, cô bé ấy đã bị bắt từ mấy hôm rồi!"}};
      lD = new String[][]{{"Ta đang bận, Con hãy đi tập luyện đi."}, {"Các ngươi phải cố gắng tập luyện để trở thành những Ninja tốt"}, {"Hằng ngày ngươi phải siêng năng tập thể lực, đó là nền tảng cho mọi hoạt động."}, {"Cô Ayumi xinh thật. Con có thấy thế không?"}, {"Ngươi biết không....à..à...mà ta định nói gì với ngươi nhỉ."}, {"Ta không còn gì để dạy con nữa...", "Nhưng con phải cố gắng tập luyện hàng ngày. Biết không!"}, {"Con cần phải để mắt tới cô bé Sakura nhé..", "Con bé ấy quậy lắm đấy!"}, {"Dù sau này có đi đâu, ngươi cũng phải trở thành 1 ninja tốt nhé!"}, {"Ta không còn gì để dạy con nữa!", "Hãy rèn luyện sức khỏe hàng ngày, biết không!"}, {"..à.. ừ.. ngươi muốn học phép à..", ".. để ta nghĩ ra thêm vài phép mới..", "..trước mắt hãy học những kỹ năng cũ đã nhé..."}};
      lE = new String[]{"Ngươi không có đủ vàng.", "Hãy hoàn thành nhiệm vụ được giao rồi quay lại gặp ta!"};
      lF = new int[]{1, 7, 100, 100, 6, 100, 100, 13, 100, 15, 100, 100, 18, 17, 10, 100, 100, 100};
      questRequiredAmounts = new int[]{2, 2, 0, 0, 20, 0, 0, 15, 0, 20, 0, 0, 70, 50, 30, 0, 0, 0};
      lH = new int[]{7, 6, 6, 5, 2, 4};
      lI = -1;
      lN = new String[]{"1. Tiep tuc", "2. Kich hoat", "3. Nhap ma kich hoat"};
      lO = new String[]{"1. Kich hoat", "2. Nhap ma kich hoat"};
      lR = Font.getFont(0, 0, 0);
      lS = Font.getFont(0, 1, 0);
      lT = lR.getHeight() + 6;
      lX = new int[9];
      lY = 10;

      for(int var4 = 0; var4 < 9; ++var4) {
         lX[var4] = (var4 << 1) + 1;
         int[] var7 = lX;
         var7[var4] += aW;
      }

   }

   public static void a() {
      int[] var1 = new int[500];
      int var2 = 0;
      if (gN > 0L) {
         gM += (int)((System.currentTimeMillis() - gN) / 1000L);
      }

      gN = System.currentTimeMillis();
      ++var2;
      var1[0] = gM;
      ++var2;
      var1[1] = v;
      ++var2;
      var1[2] = w;
      ++var2;
      var1[3] = eF ? 1 : 0;
      ++var2;
      var1[4] = de;
      ++var2;
      var1[5] = dx ? 1 : 0;
      ++var2;
      var1[6] = eG ? 1 : 0;
      ++var2;
      var1[7] = eH ? 1 : 0;
      ++var2;
      var1[8] = eI ? 1 : 0;
      ++var2;
      var1[9] = gl ? 1 : 0;
      ++var2;
      var1[10] = gm;
      ++var2;
      var1[11] = gn;
      ++var2;
      var1[12] = ik;
      ++var2;
      var1[13] = x;
      ++var2;
      var1[14] = eX ? 1 : 0;

      for(int var0 = 0; var0 < W.length; ++var0) {
         var1[var2++] = W[var0] ? 1 : 0;
      }

      for(int var4 = 0; var4 < V.length; ++var4) {
         var1[var2++] = V[var4];
      }

      var1[var2++] = khinhCong ? 1 : 0;
      var1[var2++] = eK ? 1 : 0;
      var1[var2++] = eL ? 1 : 0;
      var1[var2++] = eM ? 1 : 0;
      var1[var2++] = eN ? 1 : 0;
      var1[var2++] = eO ? 1 : 0;
      var1[var2++] = eP ? 1 : 0;
      var1[var2++] = eQ ? 1 : 0;
      var1[var2++] = eR ? 1 : 0;
      var1[var2++] = eS ? 1 : 0;
      var1[var2++] = eT ? 1 : 0;
      var1[var2++] = eU ? 1 : 0;
      var1[var2++] = eV ? 1 : 0;
      var1[var2++] = khinhCongCap2 ? 1 : 0;
      var1[var2++] = eY ? 1 : 0;
      var1[var2++] = eZ ? 1 : 0;
      var1[var2++] = fa ? 1 : 0;
      var1[var2++] = fb ? 1 : 0;
      var1[var2++] = fc ? 1 : 0;
      var1[var2++] = fd;
      var1[var2++] = fe;
      var1[var2++] = ff;
      var1[var2++] = fg;
      var1[var2++] = y;
      var1[var2++] = z;
      var1[var2++] = A;
      var1[var2++] = B;
      var1[var2++] = fh;
      var1[var2++] = fi;
      var1[var2++] = fj;
      var1[var2++] = fk;
      var1[var2++] = fl;
      var1[var2++] = fm;
      var1[var2++] = fn;
      var1[var2++] = C;
      var1[var2++] = D;
      var1[var2++] = fo;
      var1[var2++] = E;
      var1[var2++] = F;
      var1[var2++] = G;
      var1[var2++] = H;
      var1[var2++] = I;
      var1[var2++] = J;
      var1[var2++] = K;
      var1[var2++] = L;
      var1[var2++] = fp;
      var1[var2++] = fq;
      var1[var2++] = fr;
      var1[var2++] = ft;
      var1[var2++] = fu;
      var1[var2++] = characterLevel;
      var1[var2++] = N;
      var1[var2++] = fv ? 1 : 0;
      var1[var2++] = fw ? 1 : 0;
      var1[var2++] = fx ? 1 : 0;
      var1[var2++] = fy ? 1 : 0;
      var1[var2++] = currentQuestIndex;
      var1[var2++] = fz;
      var1[var2++] = fA;
      var1[var2++] = fB ? 1 : 0;
      var1[var2++] = fD;
      var1[var2++] = fE;
      var1[var2++] = fF;
      var1[var2++] = ih;
      var1[var2++] = ii;
      var1[var2++] = fG;
      var1[var2++] = fH;
      var1[var2++] = fI;
      var1[var2++] = fJ;
      var1[var2++] = fK;
      var1[var2++] = fL;
      var1[var2++] = fM;
      var1[var2++] = fN;
      var1[var2++] = fO;
      var1[var2++] = fP;
      var1[var2++] = fQ;
      var1[var2++] = fR;
      var1[var2++] = fS;
      var1[var2++] = ifFlag ? 1 : 0;
      var1[var2++] = ie;
      var1[var2++] = ig;
      var1[var2++] = gc;
      var1[var2++] = gd;
      var1[var2++] = ge;
      var1[var2++] = gf;
      var1[var2++] = gg;
      var1[var2++] = gh;
      var1[var2++] = gi;
      var1[var2++] = gj;
      var1[var2++] = gk;
      var1[var2++] = go;
      var1[var2++] = gp;
      var1[var2++] = gq;
      var1[var2++] = gr;
      var1[var2++] = gs;
      var1[var2++] = gt;
      var1[var2++] = gu;
      var1[var2++] = gv;
      var1[var2++] = gw;
      var1[var2++] = gx;
      var1[var2++] = gy;
      var1[var2++] = gz;
      var1[var2++] = gA;
      var1[var2++] = gB;
      var1[var2++] = gC;
      var1[var2++] = gD;
      var1[var2++] = gE;
      var1[var2++] = gF;
      var1[var2++] = gG;
      var1[var2++] = gH;
      var1[var2++] = gI;
      var1[var2++] = gJ;
      var1[var2++] = gK;
      var1[var2++] = ha;
      var1[var2++] = hh;
      var1[var2++] = hn;
      var1[var2++] = hN;
      var1[var2++] = hs;
      var1[var2++] = ij;
      if (ij > 0) {
         for(int var5 = 0; var5 < ip.length; ++var5) {
            var1[var2++] = ip[var5];
         }

         for(int var6 = 0; var6 < in.length; ++var6) {
            var1[var2++] = in[var6];
         }

         for(int var7 = 0; var7 < io.length; ++var7) {
            var1[var2++] = io[var7];
         }

         for(int var8 = 0; var8 < iq.length; ++var8) {
            var1[var2++] = iq[var8];
         }

         for(int var9 = 0; var9 < il.length; ++var9) {
            var1[var2++] = il[var9];
         }

         for(int var10 = 0; var10 < im.length; ++var10) {
            var1[var2++] = im[var10];
         }
      }

      var1[var2++] = ir;
      if (ir > 0) {
         var1[var2++] = is;
         if (iv != null) {
            for(int var11 = 0; var11 < iv.length; ++var11) {
               var1[var2++] = iv[var11];
            }
         }

         if (iz != null) {
            for(int var12 = 0; var12 < iz.length; ++var12) {
               var1[var2++] = iz[var12];
            }
         }

         if (iy != null) {
            for(int var13 = 0; var13 < iy.length; ++var13) {
               var1[var2++] = iy[var13];
            }
         }

         if (iw != null) {
            for(int var14 = 0; var14 < iw.length; ++var14) {
               var1[var2++] = iw[var14];
            }
         }

         if (ix != null) {
            for(int var15 = 0; var15 < ix.length; ++var15) {
               var1[var2++] = ix[var15];
            }
         }

         if (it != null) {
            for(int var16 = 0; var16 < it.length; ++var16) {
               var1[var2++] = it[var16];
            }
         }

         if (iu != null) {
            for(int var17 = 0; var17 < iu.length; ++var17) {
               var1[var2++] = iu[var17];
            }
         }
      }

      var1[var2++] = khinhCongCap3 ? 1 : 0;
      var1[var2++] = dashLearned ? 1 : 0;
      var1[var2++] = amSatLearned ? 1 : 0;
      var1[var2++] = dashLevel;
      int[] var18 = var1;
      int var19;
      byte[] var156 = new byte[(var19 = var1.length) << 2];

      for(int var3 = 0; var3 < var19; ++var3) {
         var156[var3 << 2] = (byte)(var18[var3] >> 24);
         var156[(var3 << 2) + 1] = (byte)(var18[var3] >>> 16);
         var156[(var3 << 2) + 2] = (byte)(var18[var3] >>> 8);
         var156[(var3 << 2) + 3] = (byte)var18[var3];
      }

      Midlet.a("ninjasave", var156);
      Midlet.a(true);
   }

   private static boolean mapIdValid(int var0) {
      if (var0 >= 0 && var0 <= 18) {
         return true;
      } else {
         return var0 == 94 || var0 == 95 || var0 == 96 || var0 == 97 || var0 == 99 || var0 == 101;
      }
   }

   private static int fixMapId(int var0) {
      if (mapIdValid(var0)) {
         return var0;
      } else {
         System.err.println("[MAP] invalid map id " + var0 + " in save -> 0");
         return 0;
      }
   }

   public static void b() {
      int[] var0 = a(Midlet.b("ninjasave"));
      int var2 = 0;
      ++var2;
      gM = var0[0];
      ++var2;
      v = fixMapId(var0[1]);
      ++var2;
      w = var0[2];
      ++var2;
      eF = var0[3] == 1;
      ++var2;
      de = var0[4];
      ++var2;
      dx = var0[5] == 1;
      ++var2;
      eG = var0[6] == 1;
      ++var2;
      eH = var0[7] == 1;
      ++var2;
      eI = var0[8] == 1;
      ++var2;
      gl = var0[9] == 1;
      ++var2;
      gm = var0[10];
      ++var2;
      gn = var0[11];
      ++var2;
      ik = var0[12];
      ++var2;
      x = var0[13];
      ++var2;
      eX = var0[14] == 1;

      for(int var1 = 0; var1 < W.length; ++var1) {
         W[var1] = var0[var2++] == 1;
      }

      for(int var7 = 0; var7 < V.length; ++var7) {
         V[var7] = var0[var2++];
      }

      khinhCong = var0[var2++] == 1;
      eK = var0[var2++] == 1;
      eL = var0[var2++] == 1;
      eM = var0[var2++] == 1;
      eN = var0[var2++] == 1;
      eO = var0[var2++] == 1;
      eP = var0[var2++] == 1;
      eQ = var0[var2++] == 1;
      eR = var0[var2++] == 1;
      eS = var0[var2++] == 1;
      eT = var0[var2++] == 1;
      eU = var0[var2++] == 1;
      eV = var0[var2++] == 1;
      khinhCongCap2 = var0[var2++] == 1;
      eY = var0[var2++] == 1;
      eZ = var0[var2++] == 1;
      fa = var0[var2++] == 1;
      fb = var0[var2++] == 1;
      fc = var0[var2++] == 1;
      fd = var0[var2++];
      fe = var0[var2++];
      ff = var0[var2++];
      fg = var0[var2++];
      y = var0[var2++];
      z = var0[var2++];
      A = var0[var2++];
      B = var0[var2++];
      fh = var0[var2++];
      fi = var0[var2++];
      fj = var0[var2++];
      fk = var0[var2++];
      fl = var0[var2++];
      fm = var0[var2++];
      fn = var0[var2++];
      C = var0[var2++];
      D = var0[var2++];
      fo = var0[var2++];
      E = var0[var2++];
      F = var0[var2++];
      G = var0[var2++];
      H = var0[var2++];
      I = var0[var2++];
      J = var0[var2++];
      K = var0[var2++];
      L = var0[var2++];
      fp = var0[var2++];
      fq = var0[var2++];
      fr = var0[var2++];
      ft = var0[var2++];
      fu = var0[var2++];
      characterLevel = var0[var2++];
      N = var0[var2++];
      fv = var0[var2++] == 1;
      fw = var0[var2++] == 1;
      fx = var0[var2++] == 1;
      fy = var0[var2++] == 1;
      currentQuestIndex = var0[var2++];
      fz = var0[var2++];
      fA = var0[var2++];
      fB = var0[var2++] == 1;
      fD = var0[var2++];
      fE = var0[var2++];
      fF = var0[var2++];
      ih = var0[var2++];
      ii = var0[var2++];
      fG = var0[var2++];
      fH = var0[var2++];
      fI = var0[var2++];
      fJ = var0[var2++];
      fK = var0[var2++];
      fL = var0[var2++];
      fM = var0[var2++];
      fN = var0[var2++];
      fO = var0[var2++];
      fP = var0[var2++];
      fQ = var0[var2++];
      fR = var0[var2++];
      fS = var0[var2++];
      ifFlag = var0[var2++] == 1;
      ie = var0[var2++];
      ig = var0[var2++];
      gc = var0[var2++];
      gd = var0[var2++];
      ge = var0[var2++];
      gf = var0[var2++];
      gg = var0[var2++];
      gh = var0[var2++];
      gi = var0[var2++];
      gj = var0[var2++];
      gk = var0[var2++];
      go = var0[var2++];
      gp = var0[var2++];
      gq = var0[var2++];
      gr = var0[var2++];
      gs = var0[var2++];
      gt = var0[var2++];
      gu = var0[var2++];
      gv = var0[var2++];
      gw = var0[var2++];
      gx = var0[var2++];
      gy = var0[var2++];
      gz = var0[var2++];
      gA = var0[var2++];
      gB = var0[var2++];
      gC = var0[var2++];
      gD = var0[var2++];
      gE = var0[var2++];
      gF = var0[var2++];
      gG = var0[var2++];
      gH = var0[var2++];
      gI = var0[var2++];
      gJ = var0[var2++];
      gK = var0[var2++];
      if ((ha = var0[var2++]) <= 0) {
         ha = hb;
      }

      hh = var0[var2++];
      hn = var0[var2++];
      hN = var0[var2++];
      hs = var0[var2++];
      int var275 = var2++;
      int var10000 = var0[var275];
      var275 = var0[var275];
      if (var10000 > 0) {
         try {
            for(int var8 = 0; var8 < ip.length; ++var8) {
               ++var2;
            }

            for(int var9 = 0; var9 < in.length; ++var9) {
               ++var2;
            }

            for(int var10 = 0; var10 < io.length; ++var10) {
               ++var2;
            }

            for(int var11 = 0; var11 < iq.length; ++var11) {
               ++var2;
            }

            for(int var12 = 0; var12 < il.length; ++var12) {
               ++var2;
            }

            for(int var13 = 0; var13 < im.length; ++var13) {
               ++var2;
            }
         } catch (Exception var6) {
         }
      }

      if ((ir = var0[var2++]) > 0) {
         ensureIrNpcArraysSized();
         is = var0[var2++];

         try {
            for(int var14 = 0; var14 < iv.length; ++var14) {
               iv[var14] = var0[var2++];
            }

            for(int var15 = 0; var15 < iz.length; ++var15) {
               iz[var15] = var0[var2++];
            }

            for(int var16 = 0; var16 < iy.length; ++var16) {
               iy[var16] = var0[var2++];
            }

            for(int var17 = 0; var17 < iw.length; ++var17) {
               iw[var17] = var0[var2++];
            }

            for(int var18 = 0; var18 < ix.length; ++var18) {
               ix[var18] = var0[var2++];
            }

            for(int var19 = 0; var19 < it.length; ++var19) {
               it[var19] = var0[var2++];
            }

            for(int var20 = 0; var20 < iu.length; ++var20) {
               iu[var20] = var0[var2++];
            }
         } catch (Exception var5) {
         }
      }

      if (var0.length > var2) {
         khinhCongCap3 = var0[var2++] == 1;
      } else {
         khinhCongCap3 = false;
      }

      if (var0.length > var2) {
         skillSetDashLearned(var0[var2++] == 1);
      } else {
         skillSetDashLearned(false);
      }

      if (var0.length > var2) {
         skillSetAmSatLearned(var0[var2++] == 1);
      } else {
         skillSetAmSatLearned(false);
      }

      if (var0.length > var2) {
         dashLevel = var0[var2++];
         syncDashDurationToLevel();
      } else {
         dashLevel = 1;
      }

      syncSkillsFromLegacyFlags();

      if (fy) {
         if (eq == null) {
            eq = new Image[4];

            try {
               eq[0] = Image.createImage("/cp/ch0x.png");
               eq[1] = Image.createImage("/cp/ch1x.png");
            } catch (Exception var4) {
            }

            eq[2] = eq[1];
            eq[3] = eq[0];
         }

         for(int var21 = 0; var21 < 4; ++var21) {
            Image var3 = ep[var21];
            ep[var21] = eq[var21];
            eq[var21] = var3;
         }
      }

   }

   private static int[] a(byte[] var0) {
      int var1;
      int[] var3 = new int[(var1 = var0.length) >> 2];

      for(int var2 = 0; var2 < var3.length; ++var2) {
         var3[var2] = (var0[var2 << 2] << 24) + ((var0[(var2 << 2) + 1] & 255) << 16) + ((var0[(var2 << 2) + 2] & 255) << 8) + (var0[(var2 << 2) + 3] & 255);
      }

      return var3;
   }

   public static final int a(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   /** Vận tốc z khi bắt đầu nhảy: cấp 3 > đã học KC > thường. */
   private static int zForInitialJump() {
      if (khinhCong) {
         return khinhCongCap3 ? -12 : -10;
      } else {
         return -8;
      }
   }

   /** Đẩy lên trên không theo bậc khinh công (C 0→1→2). */
   private static boolean tryAirKhinhCongBoost() {
      if (C == 0 && eK) {
         ++C;
         z = -7;
      } else if (C == 1 && khinhCongCap2) {
         ++C;
         z = -7;
      } else if (C == 2 && khinhCongCap3) {
         ++C;
         z = -9;
      } else {
         return false;
      }

      if ((I -= 3) < 0) {
         I = 0;
      }

      c = true;
      e(-1, ff - -8, fg);
      e(1, ff - 8, fg);
      g(ff, fg);
      return true;
   }

   /** MP tiêu hao mỗi lần dash (theo {@link #dashManaCost} hoặc {@link #dashLevel}). */
   static int getDashManaCostPublic() {
      return getDashManaCost();
   }

   private static int getDashManaCost() {
      if (dashManaCost > 0) {
         return dashManaCost;
      }
      int var0 = dashLevel < 1 ? 1 : dashLevel;
      return 8 + var0 * 6;
   }

   /** Trừ MP (I/J — thanh trắng); G/H là HP (thanh đỏ). Popup dùng fs1 (không dùng fs0 đỏ như trừ HP). */
   private static boolean spendMp(int var0) {
      if (I < var0) {
         return false;
      }
      I -= var0;
      if (I < 0) {
         I = 0;
      }
      c = true;
      a("-" + var0, 0, ff, fg - fi, 0, -2);
      return true;
   }

   // --- Skill bridge (SkillContext / SkillTemplate) — skill con gọi qua GameSkillContext ---

   static boolean skillBridgeIsGameplay() {
      return d == 1 && !fT && !iA;
   }

   static int skillBridgeGetPlayerState() {
      return A;
   }

   static int skillBridgeGetPlayerX() {
      return ff;
   }

   static int skillBridgeGetPlayerY() {
      return fg;
   }

   static int skillBridgeGetPlayerMp() {
      return I;
   }

   static int skillBridgeGetPlayerFacing() {
      return fn;
   }

   static void skillBridgeSetPlayerFacing(int var0) {
      fn = var0;
   }

   static void skillBridgeSetPlayerPosition(int var0, int var1) {
      ff = var0;
      fg = var1;
   }

   static boolean skillBridgeSpendMp(int var0) {
      return spendMp(var0);
   }

   static void skillBridgeShowMessage(String var0) {
      c(var0);
   }

   static void skillBridgeRequestRepaint() {
      c = true;
   }

   /** Trạng thái cho phép ám sát (đứng / chạy / rơi; không dash / state đặc biệt). */
   static boolean skillBridgeCanUseAmbush(int var0) {
      if (var0 == DashSkill.STATE_DASH || var0 == 5 || var0 == 3) {
         return false;
      }
      return var0 == 1 || var0 == 2 || var0 == 4;
   }

   static void syncSkillsFromLegacyFlags() {
      DashSkill.getInstance().setLearned(dashLearned);
      AmbushSkill.getInstance().setLearned(amSatLearned);
      AmbushSkill.getInstance().setBaseManaCost(amSatManaCost > 0 ? amSatManaCost : 40);
   }

   static void skillSetDashLearned(boolean var0) {
      dashLearned = var0;
      DashSkill.getInstance().setLearned(var0);
   }

   static void skillSetAmSatLearned(boolean var0) {
      amSatLearned = var0;
      AmbushSkill.getInstance().setLearned(var0);
   }

   static int getAmSatManaCostPublic() {
      return amSatManaCost > 0 ? amSatManaCost : 40;
   }

   static int skillBridgeAbs(int var0) {
      return a(var0);
   }

   static int skillBridgeGetFallZ() {
      return z;
   }

   static void skillBridgeSetPlayerState(int var0) {
      A = var0;
   }

   static void skillBridgeResetMoveVelocity() {
      y = 0;
      z = 0;
      C = 0;
      D = 0;
   }

   static void skillBridgeClearInteractHint() {
      fE = -1;
      fF = -1;
      o = " ";
   }

   static int skillBridgeGetHalfWidth() {
      return fj;
   }

   static int skillBridgeGetHalfHeight() {
      return fk;
   }

   static int skillBridgeGetSpriteH() {
      return fi;
   }

   static boolean skillBridgeWallLeft(int var0, int var1) {
      return g(var0 - fj - 1, var1 - fk, 8);
   }

   static boolean skillBridgeWallRight(int var0, int var1) {
      return g(var0 + fj, var1 - fk, 4);
   }

   static int skillBridgeSnapXFromWallLeft(int var0) {
      return I(var0 - fj - 1) + jf + fj;
   }

   static int skillBridgeSnapXFromWallRight(int var0) {
      return I(var0 + fj) - fj;
   }

   static boolean skillBridgeDashFeetOnGround() {
      return ((i(ff, fg) | i(ff, fg + fk) | i(ff, fg + 8) | i(ff, fg + 14)) & 2) != 0;
   }

   static boolean skillBridgeTileOnGround(int var0, int var1) {
      return ((i(var0, var1) | i(var0, var1 + fk) | i(var0, var1 + 8)) & 2) != 0;
   }

   static void skillBridgePlayAmbushFx(int var0, int var1, int var2) {
      f(var0, var1 - 40);
      e(var2, var0 - (var2 << 3), var1);
      S();
      x();
   }

   static void skillBridgeDashRunFx(int var0, int var1) {
      e(var0, var1 - (var0 << 3), fg);
   }

   static void skillBridgeDashAnimTick() {
      B = (C >> 1) + 2;
      if (++C >= 10) {
         C = 0;
      }
   }

   static int skillBridgeProjectileSlots() {
      return cW;
   }

   static boolean skillBridgeProjectileAlive(int var0) {
      return cZ[var0] != -1;
   }

   static int skillBridgeProjectileX(int var0) {
      return cX[var0];
   }

   static int skillBridgeProjectileY(int var0) {
      return cY[var0];
   }

   static int skillBridgeProjectileDir(int var0) {
      return db[var0];
   }

   static boolean skillBridgeProjectileFlying(int var0) {
      return dd[var0];
   }

   static int skillBridgeMapMobSlots() {
      return cq;
   }

   static int skillBridgeMapMobState(int var0) {
      return cF[var0];
   }

   static int skillBridgeMapMobX(int var0) {
      return cv[var0];
   }

   static int skillBridgeMapMobY(int var0) {
      return cw[var0];
   }

   static int skillBridgeMapMobFace(int var0) {
      return cI[var0];
   }

   static int skillBridgeJMobSlots() {
      return jI;
   }

   static int skillBridgeJMobState(int var0) {
      return jQ[var0];
   }

   static int skillBridgeJMobX(int var0) {
      return jL[var0];
   }

   static int skillBridgeJMobY(int var0) {
      return jM[var0];
   }

   static int skillBridgeJMobFace(int var0) {
      return jZ[var0];
   }

   static void skillBridgeSetFallZ(int var0) {
      z = var0;
   }

   static void skillBridgeSetMoveD(int var0) {
      D = var0;
   }

   static void skillBridgeDashAfterMove() {
      x();
      S();
   }

   /** Cập nhật {@link #dashDurationMs} theo {@link #dashLevel} (cấp cao = dash nhanh hơn). */
   public static void syncDashDurationToLevel() {
      int var0 = dashLevel < 1 ? 1 : dashLevel;
      dashDurationMs = var0 >= 10 ? 48 : 360 - var0 * 32;
   }

   /** Học kỹ năng dash (gọi từ NPC / nhiệm vụ). */
   public static void learnDashSkill() {
      skillSetDashLearned(true);
      if (dashLevel < 1) {
         dashLevel = 1;
      }
      syncDashDurationToLevel();
      c("đã học kỹ năng lướt (dash)!");
   }

   /*
    * LEGACY skill trong a.java (đã chuyển sang DashSkill / AmbushSkill) — giữ log đối chiếu.
    * Dash: tryStartPlayerDash, onDashDirectionKey, updatePlayerDash, canPlayerDash, dashPlayerFeetTouchGroundMask
    * Ám sát: tryAmSatSkill, amSatEntityOnGround, amSatProjectileVerticalOk, amSatMapMobVerticalOk, amSatJMobVerticalOk
    */

   // --- Debug refactor bridge (no-op unless DebugRefactor.DEBUG_REFACTOR) ---

   static int debugBridgeGetMapId() {
      return v;
   }

   static void debugBridgeTeleportMap(int var0) {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return;
      }
      if (!mapIdValid(var0)) {
         System.err.println("[DBG] invalid map id " + var0);
         return;
      }
      A();
      Midlet.f = true;
      x(var0);
      skillBridgeShowMessage("DBG map -> " + var0);
   }

   static void debugBridgeUnlockAllSkills() {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return;
      }
      khinhCong = true;
      eK = true;
      eL = true;
      eM = true;
      eN = true;
      eO = true;
      eP = true;
      eQ = true;
      eR = true;
      eS = true;
      eT = true;
      eU = true;
      eV = true;
      khinhCongCap2 = true;
      khinhCongCap3 = true;
      eY = true;
      eZ = true;
      fa = true;
      skillSetAmSatLearned(true);
      skillSetDashLearned(true);
      syncDashDurationToLevel();
      for (int var1 = 0; var1 < W.length; ++var1) {
         W[var1] = true;
      }
      skillBridgeShowMessage("DBG unlock skills+maps");
   }

   static void debugBridgeAddExp(int var0) {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return;
      }
      u(var0);
   }

   static void debugBridgeSpawnTestMob(int var0) {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return;
      }
      if (var0 < 0 || var0 >= MonsterData.NAMES.length) {
         var0 = 0;
      }
      int var2;
      for (var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }
      if (var2 >= jI) {
         skillBridgeShowMessage("DBG mob slots full");
         return;
      }
      ki[var2] = 0;
      jK[var2] = var0;
      jL[var2] = ff + (fn >= 0 ? 48 : -48);
      jM[var2] = fg;
      ke[var2] = 25;
      kf[var2] = 10;
      jN[var2] = 27;
      jO[var2] = 15;
      jZ[var2] = fn != 0 ? fn : -1;
      jQ[var2] = 2;
      jV[var2] = var2 * 7;
      ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
      kc[var2] = MonsterData.DAMAGE[jK[var2]];
      kh[var2] = MonsterData.HIT_STAT[jK[var2]];
      kd[var2] = 0;
      skillBridgeShowMessage("DBG spawn " + MonsterData.getName(var0));
   }

   static String debugBridgeDumpPlayerState() {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return "";
      }
      String var0;
      try {
         var0 = map.getMapName(v);
      } catch (Exception var1) {
         var0 = "?";
      }
      return "map=" + v + "(" + var0 + ") xy=" + ff + "," + fg + " st=" + A
         + " lv=" + characterLevel + " exp=" + N + "/" + ai[characterLevel - 1]
         + " HP=" + G + "/" + H + " MP=" + I + "/" + J
         + " dash=" + dashLearned + " L" + dashLevel + " amsat=" + amSatLearned
         + " quest=" + currentQuestIndex;
   }

   static String debugBridgeDumpSaveState() {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return "";
      }
      return "save map=" + v + " money=" + de + " xy=" + ff + "," + fg
         + " lv=" + characterLevel + " exp=" + N + " gl=" + (gl ? 1 : 0)
         + " gn=" + gn + " dash=" + (dashLearned ? 1 : 0)
         + " amsat=" + (amSatLearned ? 1 : 0) + " dashLv=" + dashLevel;
   }

   private static void a(int var0, int var1, int var2, int var3, int var4) {
      int var5;
      for(var5 = 0; var5 < df && di[var5] != 0; ++var5) {
      }

      if (var5 != df) {
         dg[var5] = var0;
         dh[var5] = var1;
         dj[var5] = var2;
         dk[var5] = var3;
         di[var5] = 1;
         dm[var5] = var4;
         if (var4 < 160) {
            dn[var5] = 0;
         } else if (var4 < 600) {
            dn[var5] = 1;
         } else {
            dn[var5] = 2;
         }
      }
   }

   private static void a(int var0, int var1, int var2, int var3, int var4, int var5) {
      for(var3 = 0; var3 < cN && cR[var3] != 0; ++var3) {
      }

      if (var3 != cN) {
         cP[var3] = var0;
         cQ[var3] = var1;
         cS[var3] = var2;
         cT[var3] = -5;
         cR[var3] = 1;
         cV[var3] = var4;
         cO[var3] = var5;
         if (var4 < 100) {
            cU[var3] = 0;
         } else if (var4 < 200) {
            cU[var3] = 1;
         } else {
            cU[var3] = 2;
         }
      }
   }

   private static void u(int var0) {
      if ((N += var0) > ai[characterLevel - 1]) {
         N = 0;
         if (Midlet.lowGfx && characterLevel == 6) {
            s(6);
            a("Xin đăng ký để có thể lên cấp 7!");
            d = 7;
            return;
         }

         ++characterLevel;
         E += ah[characterLevel - 2];
         F += 2;
         G = H += aj[characterLevel - 2];
         I = J;
         a("level-up", 2, ff, fg - fi, 0, -2);
         s(6);
         a("Chúc mừng! Bạn đạt được cấp " + characterLevel + '\n' + "HP: " + H + '\n' + "Sức đánh: " + (E + (E >> 2) * (x + 1)));
         d = 7;
      } else {
         a("+" + var0, 2, ff, fg - fi, 0, -2);
      }

      c = true;
   }

   private static void u() {
      if (currentQuestIndex == 11 && z != 0) {
         ++fD;
         if (currentQuestIndex >= 20) {
            c("Thành công 20 hit!");
         } else {
            c("Hit: " + fD);
         }
      }

      int var0;
      var0 = (var0 = E + w % (E >> 1)) + (var0 >> 1) * x;
      if (fy) {
         var0 <<= 1;
      }

      if (fe == 1) {
         a(ff + (fn << 3), fg - 12, (fn << 3) + y, z << 1, false);
      } else {
         if (z > 0 && y == 0) {
            z = -2;
         }

         int var1 = z();
         fs = false;
         if (var1 != -1) {
            fs = true;
            k(var1, var0, -fn);
            f(jL[var1], jM[var1] - (jN[var1] >> 1), fn);
            a("-" + var0, 0, jL[var1], jM[var1] - jN[var1], 0, -2);
            if (z > 0) {
               z = -6;
            }

            Q();
         }

         for(int var3 = 0; var3 < ir; ++var3) {
            if (a(fg - fk - iu[var3]) < 20 && a(ff + (fn << 4) - it[var3]) < 24) {
               iv[var3] = 2;
               iw[var3] = fn << 3;
               f(it[var3], iu[var3] - 12, fn);
               Q();
               break;
            }
         }

         if (gO && a(fg - gR) < 30 && a(ff + (fn << 4) - gQ) < 40) {
            if (!c(var0, -fn)) {
               f(ff + (gQ - ff >> 1), fg - 12, fn);
               a("-" + var0, 0, gQ, gR - gX, 0, -2);
            }

            Q();
         }

         for(int var4 = 0; var4 < cq; ++var4) {
            if (a(fg - cw[var4]) <= 12 && a(ff + (fn << 4) - cv[var4]) < 24) {
               a(var4, var0, -fn);
               f(cv[var4], cw[var4] - 15, fn);
               a("-" + var0, 0, cv[var4], cw[var4] - 28, 0, -2);
               Q();
               break;
            }
         }

         if (hK && a(fg - (hR - 40)) < 30 && a(ff + (fn << 4) - hQ) < 40) {
            if ((hN -= var0) <= 0) {
               hN = 0;
               ic = 0;
               id = 0;
               hY = 1;
               a(hQ, hR, 4, -10, 600);
               a(hQ, hR, -4, -17, 600);
               a(hQ, hR, -3, -18, 600);
               a(hQ, hR, 4, -19, 600);
               a(hQ, hR, 0, -10, 600);
               boolean var10000 = false;
            } else {
               id = 50;
               boolean var5 = false;
            }

            f(ff + (hQ - ff >> 1), fg - 12, fn);
            a("-" + var0, 0, hQ, hR - hM, 0, -2);
            Q();
         }

         if (hd) {
            if (a(fg - dB[0]) < 5 && a(ff + (fn << 4) - dA[0]) < 30) {
               d(var0, fn);
            }

            Q();
         }

         if (hj) {
            if (a(fg - (hr - 30)) < 30 && a(ff + (fn << 4) - hq) < 30) {
               if ((hn -= var0) <= 0) {
                  hn = 0;
                  hw = 0;
                  hp = 0;
                  hs = 6;
                  a(hq, hr, 4, -10, 500);
                  a(hq, hr, -4, -17, 500);
                  a(hq, hr, -3, -18, 500);
                  a(hq, hr, 4, -19, 500);
                  a(hq, hr, 0, -10, 500);
                  boolean var6 = false;
               } else {
                  hp = 50;
                  f(hq, hr - 47, fn);
                  a("-" + var0, 0, hq, hr - 55, 0, -2);
                  boolean var7 = false;
               }
            }

            Q();
         }

      }
   }

   private static void v() {
      for(int var0 = 0; var0 < ir; ++var0) {
         if (iv[var0] != 4 && a(ff - it[var0]) < 20 && iu[var0] > fg && iu[var0] - 24 <= fg) {
            y = 0;
            z = 0;
            fg = iu[var0] - 24;
            A = 1;
            fd = -1;
            is = var0;
            if (iv[var0] == 11) {
               g(it[var0], iu[var0] - 10);
               int[] var10000 = iu;
               var10000[var0] += 4;
               var10000 = ix;
               var10000[var0] += 4;
               return;
            }
            break;
         }
      }

   }

   private static void w() {
      for(int var0 = 0; var0 < ir; ++var0) {
         if (a(ff - it[var0]) < 20 && a(iu[var0] - fg) < 4) {
            y = 0;
            if (ff < it[var0]) {
               ff = it[var0] - 20;
            } else {
               ff = it[var0] + 20;
            }

            if (iv[var0] != 4) {
               iv[var0] = 2;
               iw[var0] = -fn << 1;
               return;
            }
         }
      }

   }

   private static void v(int var0) {
      if (a(fg - cw[var0]) <= 24 && a(cv[var0] + (cI[var0] << 3) - ff) < 25 && (cE[var0] == 6 || cE[var0] == 2 || cE[var0] == 3)) {
         cH[var0] = cG[var0] = 0;
         cF[var0] = 4;
      }

   }

   private static void w(int var0) {
      if (!fx) {
         if (a(cv[var0] - ff) < 100 && a(cw[var0] - fg) < 20) {
            switch (cE[var0]) {
               case 0:
               case 1:
               case 4:
               case 5:
                  cI[var0] = cv[var0] < ff ? 1 : -1;
                  cH[var0] = cG[var0] = 0;
                  cF[var0] = 4;
                  break;
               case 2:
               case 3:
               case 6:
                  cH[var0] = ff;
                  if (cv[var0] < ff) {
                     int[] var10000 = cH;
                     var10000[var0] -= 10;
                  } else {
                     int[] var1 = cH;
                     var1[var0] += 10;
                  }

                  cI[var0] = cH[var0] < ff ? 1 : -1;
                  cF[var0] = 7;
                  cz[var0] = cI[var0] << 3;
                  if (cH[var0] < cL[var0]) {
                     cH[var0] = cL[var0];
                  }

                  if (cH[var0] > cM[var0]) {
                     cH[var0] = cM[var0];
                     return;
                  }
            }
         }

      }
   }

   private static void x() {
      for(int var0 = 0; var0 < ir; ++var0) {
         if (a(ff - it[var0]) < 20 && iu[var0] == fg) {
            y = 0;
            if (ff < it[var0]) {
               ff = it[var0] - 20;
            } else {
               ff = it[var0] + 20;
            }

            if (iv[var0] != 4) {
               iv[var0] = 2;
               iw[var0] = fn << 2;
               return;
            }
         }
      }

   }

   static void c() {
      for(int var0 = 0; var0 < 14; ++var0) {
         aS[var0] = false;
      }

   }

   static void d() {
      for(int var0 = 0; var0 < 14; ++var0) {
         aT[var0] = false;
      }

   }

   private static void y() {
      switch (iE) {
         case 3:
            currentQuestIndex = 0;
            fD = 0;
            c("NV: Giết 2 ốc sên");
            break;
         case 4:
            khinhCong = true;
            khinhCongCap2 = true;
            khinhCongCap3 = true;
            skillSetAmSatLearned(true);
            skillSetDashLearned(true);
            eK = true;
            if (dashLevel < 1) {
               dashLevel = 1;
            }
            syncDashDurationToLevel();
            currentQuestIndex = -1;
            fD = 0;
            c("đã học khinh công, dash và sức công nhân đôi!");
            break;
         case 5:
            currentQuestIndex = 1;
            fD = 0;
            c("NV: đánh ngã 2 bù nhìn");
            break;
         case 6:
            eL = true;
            khinhCongCap3 = true;
            currentQuestIndex = -1;
            fD = 0;
            c("đã học ném phi tiêu");
         case 7:
         default:
            break;
         case 8:
            c((String)null);
            break;
         case 9:
            currentQuestIndex = 2;
            fz = 103;
            fA = 2;
            fB = false;
            c("NV: Tìm bí kíp");
            break;
         case 10:
            eM = true;
            currentQuestIndex = -1;
            fz = 0;
            fA = 0;
            fB = false;
            c("đã học thuật độn thổ");
            break;
         case 11:
            currentQuestIndex = 3;
            gn = 3;
            go = 2808;
            gp = 216;
            gA = -1;
            gs = 1;
            gq = 5;
            break;
         // Trường hợp 12 trong một cấu trúc switch-case, thực hiện các hành động sau:
         // 1. Đánh dấu đã học/nhận được một kỹ năng hoặc trạng thái nào đó bằng cách đặt eO = true.
         // 2. Tăng gấp đôi sức mạnh tấn công (biến E) bằng cách dịch trái 1 bit (E <<= 1, tương đương nhân đôi E).
         // 3. Gán biến currentQuestIndex = -1, có thể để kết thúc nhiệm vụ hiện tại hoặc reset trạng thái nhiệm vụ.
         // 4. Đặt fz = 0 và fA = 0, có thể là reset các bộ đếm liên quan nhiệm vụ.
         // 5. Đặt fB = false, có thể để đánh dấu trạng thái chưa hoàn thành hoặc reset lại cờ kiểm tra nào đó.
         // 6. Gọi phương thức c("sức công nhân đôi!"), có thể là để thông báo cho người chơi về trạng thái mới: "sức công nhân đôi!".
         case 12:
            eO = true;
            E = E * 2;
            currentQuestIndex = -1;
            fz = 0;
            fA = 0;
            fB = false;
            c("sức công nhân đôi!");
            break;
         case 13:
            currentQuestIndex = 4;
            fD = 0;
            c("NV: giết 20 con ong");
            break;
         case 14:
            currentQuestIndex = 5;
            fB = false;
            fD = 0;
            fA = 10;
            c("NV: giết heo rừng");
            break;
         case 15:
            currentQuestIndex = -1;
            eP = true;
            eQ = true;
            c("đã học chạy nước.");
            break;
         case 16:
            currentQuestIndex = 6;
            fB = false;
            fA = 10;
            c("NV: vượt sông");
            break;
         case 17:
            currentQuestIndex = -1;
            eR = true;
            c("đã học biến hình.");
            break;
         case 18:
            currentQuestIndex = 7;
            fD = 0;
            c("NV: giết 15 dơi vàng");
            break;
         case 19:
            eS = true;
            de += 5000;
            c = true;
            currentQuestIndex = -1;
            fz = 0;
            fA = 0;
            fB = false;
            c("Nhận được tiền 5000$");
            break;
         case 20:
            currentQuestIndex = 15;
            fD = 0;
            fB = false;
            c("NV: tìm bí kíp");
            break;
         case 21:
            fa = true;
            currentQuestIndex = -1;
            fD = 0;
            fB = false;
            c("đã có thể ẩn thân");
            break;
         case 22:
            currentQuestIndex = 8;
            c("NV: tìm đánh Toniku");
            break;
         case 23:
            currentQuestIndex = -1;
            eT = true;
            c("Hoàn thành nhiệm vụ.");
            break;
         case 24:
            currentQuestIndex = 9;
            fD = 0;
            c("NV: giết 20 thổ dân");
            break;
         case 25:
            eU = true;
            currentQuestIndex = -1;
            fz = 0;
            fA = 0;
            fB = false;
            c("đến gặp cô bé!");
            break;
         case 26:
            currentQuestIndex = 10;
            fD = 0;
            gl = true;
            c("NV: dẫn cô bé đi chơi");
            break;
         case 27:
            currentQuestIndex = -1;
            khinhCongCap2 = true;
            fD = 0;
            c("Học khinh công cấp 2");
            break;
         case 28:
            currentQuestIndex = 11;
            fD = 0;
            c("NV: 20 hit trên không");
            break;
         case 29:
            eX = true;
            F <<= 2;
            currentQuestIndex = -1;
            fD = 0;
            c("đã học phi tiêu cấp 2");

            for(int var0 = 0; var0 < 2; ++var0) {
               try {
                  el[var0] = Image.createImage("/c/pt" + (var0 + 2) + ".png");
               } catch (IOException var1) {
               }
            }
            break;
         case 30:
            currentQuestIndex = 12;
            fD = 0;
            c("NV: đánh 70 quỷ hoa đỏ");
            break;
         case 31:
            eY = true;
            currentQuestIndex = -1;
            fD = 0;
            c("đã có thể chạy nhanh");
            break;
         case 32:
            currentQuestIndex = 13;
            fD = 0;
            c("NV: Giết 50 bò cạp");
            break;
         case 33:
            eZ = true;
            currentQuestIndex = -1;
            fD = 0;
            c("đã có thể đứng nước");
            break;
         case 34:
            currentQuestIndex = 14;
            fD = 0;
            c("NV: Giết 30 cá đỏ");
            break;
         case 35:
            currentQuestIndex = -1;
            fD = 0;
            fB = false;
            break;
         case 36:
            currentQuestIndex = 16;
            fD = 0;
            fB = false;
            c("NV: cứu Sakura");
            break;
         case 37:
            khinhCongCap3 = true;
            currentQuestIndex = -1;
            fD = 0;
            c("đã học khinh công cấp 3");
      }

      if (lI >= 0) {
         a(lI, lJ, lK, lL);
         lI = -1;
      }

   }

   private static int z() {
      int var0 = fn > 0 ? ff - 20 : ff - 40;
      int var1 = fn > 0 ? ff + 40 : ff + 20;
      int var2 = fg - fi - 15;
      int var3 = fg + 5;

      for(int var4 = 0; var4 < jI; ++var4) {
         if (jQ[var4] != 5 && jL[var4] >= var0 && jL[var4] <= var1 && jM[var4] >= var2 && jM[var4] <= var3) {
            return var4;
         }
      }

      return -1;
   }

   private static void A() {
      lu = null;
      System.gc();
      ec = null;
      ef = null;
      ew = null;
      System.gc();
      ey = null;
      System.gc();
      jH = null;
      System.gc();
      B();
      et = null;
      ej = null;
      dZ = null;
      System.gc();
   }

   private static void B() {
      ev = null;
      eu = null;
      System.gc();
   }

   private static void C() {
      if (gl) {
         if (fg <= gp - 24 && g(go, gp - 1, 2)) {
            gs = 3;
            gq = 0;
            gr = -7;
            return;
         }

         if (fg <= gp - 24 && g(go, gp - 25, 2)) {
            gs = 3;
            gq = 0;
            gr = -10;
            return;
         }

         if (go >= fP - 24 && go <= fP + q + 24) {
            if (gp < fQ - 30 || gp > fQ + r + 30) {
               gA = ff + (fn << 5) > go ? 1 : -1;
               int var2 = ff;
               int var6 = fg > gp ? fQ - 20 : fQ + r;
               go = var2;
               gp = var6;
               gs = 3;
               gq = gA << 2;
               gr = -4;
               return;
            }

            if (a(ff + (fn << 5) - go) <= (A == 5 ? 10 : 60)) {
               gs = 1;
            } else if (fg >= gp) {
               if (fg > gp) {
                  if (g(go + gA * gu, gp, 2)) {
                     gA = ff > go ? 1 : -1;
                     gs = 2;
                     gq = gA * P;
                     return;
                  }

                  if (g(go + gA * 48, gp + 24, 2)) {
                     gs = 3;
                     gq = gA * 7;
                     gr = -5;
                     return;
                  }

                  for(int var5 = 1; var5 <= 5 && gp + var5 * 24 < iQ && !g(go + gA * 24, gp + var5 * 24, 64); ++var5) {
                     if (g(go + gA * 24, gp + var5 * 24, 2)) {
                        gs = 3;
                        gq = gA << 2;
                        gr = -4;
                        return;
                     }

                     if (g(go + gA * 48, gp + var5 * 24, 2)) {
                        gs = 3;
                        gq = gA * 6;
                        gr = -4;
                        return;
                     }
                  }

                  if (g(go + gA * 24, gp - 24, 2)) {
                     gs = 3;
                     gq = gA * 5;
                     gr = -7;
                     return;
                  }

                  if (g(go + gA * 48, gp - 24, 2)) {
                     gs = 3;
                     gq = gA * 6;
                     gr = -8;
                     return;
                  }

                  if (g(go + gA * 24, gp - 48, 2)) {
                     gs = 3;
                     gq = gA * 5;
                     gr = -11;
                     return;
                  }
               } else if (g(go + gA * gu, gp, 2)) {
                  gA = ff + (fn << 5) > go ? 1 : -1;
                  gs = 2;
                  gq = gA * P;
                  return;
               }
            } else {
               if (g(go + gA * 48, gp - 24, 2)) {
                  gs = 3;
                  gq = gA * 5;
                  gr = -8;
                  return;
               }

               for(int var3 = 1; var3 <= 3; ++var3) {
                  if (g(go + gA * 24, gp - var3 * 24, 2)) {
                     gs = 3;
                     gq = gA * 6;
                     gr = -5 - var3 * 3;
                     return;
                  }
               }

               if (!g(go + gA * 48, gp - 2, 64)) {
                  if (gp + 24 >= iQ || g(go + gA * 48, gp + 24, 2)) {
                     gs = 3;
                     gq = gA * 7;
                     gr = -4;
                     return;
                  }

                  for(int var4 = 1; var4 <= 5; ++var4) {
                     if (gp + var4 * 24 >= iQ || g(go + gA * 24, gp + var4 * 24, 64)) {
                        return;
                     }

                     if (g(go + gA * 48, gp + var4 * 24, 2)) {
                        gs = 3;
                        gq = gA * 6;
                        gr = -4;
                        return;
                     }

                     if (g(go + gA * 24, gp + var4 * 24, 2)) {
                        gs = 3;
                        gq = gA << 2;
                        gr = -4;
                        return;
                     }
                  }

                  return;
               }
            }
         } else {
            gA = ff + (fn << 5) > go ? 1 : -1;
            int var0 = ff > go ? fP - 24 : fP + q + 24;
            int var1 = fg - 20;
            if (!g(var0, var1, 8192)) {
               go = var0;
               gp = var1;
               gs = 4;
               gq = 4;
               gr = 3;
               return;
            }

            if (g(go + gA * gu, gp, 2)) {
               gA = ff > go ? 1 : -1;
               gs = 2;
               gq = gA * 12;
               return;
            }
         }
      }

   }

   private static void a(int var0, int var1) {
      G -= var0;
      fd = -1;
      c = true;
      is = -1;
      if (G <= 0) {
         G = 0;
         z = -7;
         y = var1 << 2;
         A = 6;
         ik = -1;
      } else if (ik == -1 && A != 23) {
         y = var1 << 2;
         z = -2;
         C = 0;
         D = 0;
         A = 7;
      }

      f(ff, fg - 12, -fn);
      a("-" + var0, 0, ff, fg - fi, 0, -2);
   }

   private static void b(int var0, int var1) {
      ih = -1;
      gq = var1 << 2;
      gr = -2;
      gB = 0;
      gC = 0;
      gs = 7;
      f(go, gp - 12, -gA);
      a("-" + var0, 0, go, gp - gv, 0, -2);
   }

   private static boolean a(int var0, int var1, int var2) {
      int[] var10000 = cs;
      var10000[var0] -= var1;
      if (cF[var0] != 1 && cF[var0] != 5) {
         if (cs[var0] <= 0) {
            cs[var0] = 0;
            cI[var0] = var2;
            cz[var0] = 0;
            cA[var0] = 0;
            cB[var0] = -(var2 << 3);
            cC[var0] = -6;
            cG[var0] = 0;
            cr[var0] = 0;
            cF[var0] = 1;
            u(ac[cE[var0]]);
            a(cv[var0], cw[var0], -(cI[var0] << 2), -4, aa[cE[var0]] + w % 10);
            if (w % 20 > 5) {
               a(cv[var0], cw[var0], -(cI[var0] << 3), -5, ab[cE[var0]] << 2, (w + 1) % 2);
            }

            return true;
         } else {
            cG[var0] = 0;
            cI[var0] = var2;
            cr[var0] = 100;
            cF[var0] = 6;
            return false;
         }
      } else {
         return true;
      }
   }

   private static boolean c(int var0, int var1) {
      if (gT == 1 || gT == 2) {
         if ((ha -= var0) <= 0) {
            ha = 0;
            gY = -5;
            gS = -(var1 << 3);
            hc = 0;
            gT = 6;
            a(gQ, gR, 4, -6, 50);
            a(gQ, gR, -5, -7, 50);
            a(gQ, gR, -4, -8, 50);
            a(gQ, gR, 5, -9, 50);
            a(gQ, gR, 0, -10, 50);
            if (currentQuestIndex == 5) {
               e(gQ, gR);
            }

            return true;
         }

         gY = 0;
         gU = var1;
         gT = 7;
         hc = 10;
         gV = 0;
         if (var0 <= F) {
            gZ = 0;
         } else {
            gZ = 2 + w % 5;
         }
      }

      return false;
   }

   private static void d(int var0, int var1) {
      hh -= var0;
      dJ[0] = -1;
      if (hh <= 0) {
         hh = 0;
      } else {
         dC[0] = var1 << 2;
         dD[0] = -2;
         dF[0] = 0;
         dG[0] = 0;
         dE[0] = 7;
         f(dA[0], dB[0] - 12, fn);
         a("-" + var0, 0, dA[0], dB[0] - 32, 0, -2);
      }
   }

   public static final void b(int var0) {
      bN = 0;
      if (var0 == 0) {
         bN = 0;
      } else {
         if (dZ == null) {
            dZ = new Image[4][2];

            for(int var3 = 0; var3 < 4; ++var3) {
               for(int var1 = 0; var1 < 2; ++var1) {
                  try {
                     dZ[var3][var1] = Image.createImage("/c/ar" + var3 + var1 + ".png");
                  } catch (IOException var2) {
                  }
               }
            }
         }

         bN = 10;
         bO = new int[10];
         bP = new int[bN];
         bQ = new int[bN];
         bR = new int[bN];
         bS = new int[bN];
         bT = new int[bN];

         for(int var4 = 0; var4 < bN; ++var4) {
            bQ[var4] = -1;
         }

      }
   }

   public static void e() {
      if (ea == null) {
         ea = new Image[4];

         for(int var0 = 0; var0 < 4; ++var0) {
            try {
               ea[var0] = Image.createImage("/u/arr" + var0 + ".png");
            } catch (Exception var1) {
            }
         }
      }

   }

   public static void f() {
      bU = 8;
      bV = new int[8];
      bW = new int[bU];
      bX = new int[bU];
      bY = new int[bU];
      bZ = new int[bU];
      ca = new int[bU];

      try {
         eb = Image.createImage("/e/b.png");
      } catch (Exception var0) {
      }
   }

   public static final void c(int var0) {
      ij = 0;
      int var1 = ik == -1 ? 0 : 1;
      if ((var0 == 0 || var0 == 1 || var0 == 7 || var0 == 5 || var0 == 18 || var0 >= 94) && var1 == 1) {
         ij = 1;
         D();
         b(0, ff, fg);
         ik = 0;
         in[ik] = fn;
      }

      if (var0 == 2) {
         d(var1, 18, 12);
      }

      if (var0 == 3) {
         d(var1, 2, 9);
      }

      if (var0 == 4) {
         d(var1, 3, 6);
      }

      if (var0 == 6) {
         d(var1, 12, 9);
      }

      if (var0 == 8) {
         d(var1, 3, 12);
      }

      if (var0 == 9) {
         d(var1, 2, 11);
      }

      if (var0 == 10) {
         d(var1, 3, 12);
      }

      if (var0 == 11) {
         d(var1, 5, 6);
      }

      if (var0 == 12) {
         d(var1, 4, 8);
      }

      if (var0 == 13) {
         d(var1, 16, 11);
      }

      if (var0 == 14) {
         d(var1, 18, 7);
      }

      if (var0 == 15) {
         d(var1, 1, 11);
      }

      if (var0 == 16) {
         d(var1, 7, 11);
      }

      if (var0 == 17) {
         d(var1, 14, 12);
      }

   }

   private static void D() {
      if (ec == null) {
         ec = new Image[3];

         try {
            for(int var0 = 0; var0 < 3; ++var0) {
               ec[var0] = Image.createImage("/c/v" + var0 + ".png");
            }
         } catch (Exception var1) {
         }
      }

      il = new int[ij];
      im = new int[ij];
      in = new int[ij];
      io = new int[ij];
      ip = new int[ij];
      iq = new int[ij];
   }

   private static void b(int var0, int var1, int var2) {
      il[var0] = var1 * jf + 12;
      im[var0] = var2 * jf;
      io[var0] = 0;
      in[var0] = 1;
   }

   public static void g() {
      try {
         ed = Image.createImage("/i/bk.png");
      } catch (Exception var0) {
      }
   }

   public static final void d(int var0) {
      ir = 0;
      if (var0 == 1) {
         ir = 2;
         E();
         c(0, 21, 9);
         c(1, 13, 8);
      }

      if (var0 == 11) {
         ir = 2;
         E();
         c(0, 33, 7);
         c(1, 44, 10);
      }

      if (var0 == 5) {
         ir = 2;
         E();
         c(0, 5, 46);
         c(1, 15, 46);
      }

      if (var0 == 97) {
         ir = 4;
         E();
         c(0, 3, 6);
         c(1, 7, 4);
         c(2, 12, 3);
         c(3, 22, 6);
      }

   }

   private static void E() {
      if (ef == null) {
         try {
            ef = Image.createImage("/i/b.png");
         } catch (Exception var0) {
         }
      }

      it = new int[ir];
      iu = new int[ir];
      iv = new int[ir];
      iw = new int[ir];
      ix = new int[ir];
      iy = new int[ir];
      iz = new int[ir];
   }

   /** Ensure NPC arrays sized for {@link #ir} (save-load can set ir without calling map init). */
   private static void ensureIrNpcArraysSized() {
      if (ir <= 0) {
         return;
      }

      if (it == null || iu == null || iv == null || iw == null || ix == null || iy == null || iz == null
         || it.length != ir || iu.length != ir || iv.length != ir || iw.length != ir || ix.length != ir
         || iy.length != ir || iz.length != ir) {
         E();
      }
   }

   private static void c(int var0, int var1, int var2) {
      it[var0] = var1 * jf + 12;
      iu[var0] = var2 * jf + 24;
      iv[var0] = 1;
   }

   public static final void h() {
      q = aU;
      if (aV >= 208) {
         bf = true;
         bj = 50;
         r = aV - bj;
         bi = q;
         bg = 0;
         bh = r + 1;
      } else {
         bj = 16;
         r = aV - bj;
         bf = false;
         bj = 0;
         bi = q;
         bg = 0;
         bh = r + 1;
         br = (bp = q / 3) + 29;
         bs = bp + 50;
      }

      if ((bu = aV / 6) < 48) {
         bu = 48;
      }

      bD = q >> 1;
      bE = r >> 1;
      bF = 3 * r / 4;
      bG = q / 6;
      bz = q / jf + 2;
      bA = r / jf + 2;
      if (q % 24 != 0) {
         ++bz;
      }

      fR = (iN - 1) * jf - q;
      fS = (iO - 1) * jf - r;
      fP = fJ = ff - bD + bG * fn;
      fQ = fK = fg - bF;
      if (fP < 0) {
         fP = 0;
      }

      if (fP > fR) {
         fP = fR;
      }

      if (fQ < 0) {
         fQ = 0;
      }

      if (fQ > fS) {
         fQ = fS;
      }

      if ((bx = fP / jf - 1) < 0) {
         bx = 0;
      }

      by = fQ / jf;
      bB = bx + bz;
      bC = by + bA;
      if (by < 0) {
         by = 0;
      }

      if (bC > iO - 1) {
         bC = iO - 1;
      }

   }

   public static final void i() {
      fd = -1;
      if (ee == null) {
         try {
            ee = new Image[20];

            for(int var0 = 0; var0 < 20; ++var0) {
               ee[var0] = Image.createImage("/cp/cb" + var0 + ".png");
            }

            ep = new Image[11];

            for(int var2 = 0; var2 < 11; ++var2) {
               ep[var2] = Image.createImage("/cp/ch" + var2 + ".png");
            }

            er = new Image[10];

            for(int var3 = 0; var3 < 10; ++var3) {
               er[var3] = Image.createImage("/cp/cl" + var3 + ".png");
            }
         } catch (Exception var1) {
         }
      }

      F();
      fh = 22;
      fi = 32;
      fj = fh >> 1;
      fk = fi >> 1;
      fl = fh >> 2;
      fm = fi >> 2;
      fE = -1;
   }

   private static void F() {
      eC = new Image[11];
      System.gc();

      for(int var0 = 0; var0 < 11; ++var0) {
         try {
            eC[var0] = Image.createImage("/c/w" + var0 + "t" + x + ".png");
         } catch (Exception var3) {
            try {
               eC[var0] = Image.createImage("/c/w" + var0 + "t0.png");
            } catch (IOException var2) {
               ((Throwable)var2).printStackTrace();
            }
         }
      }

   }

   public static void j() {
      G();
      if (bf) {
         try {
            if (eg == null) {
               eg = new Image[2];

               for(int var0 = 0; var0 < 2; ++var0) {
                  eg[var0] = Image.createImage("/u/c" + var0 + ".png");
               }
            }

            bk = eg[0].getWidth();
            bl = eg[1].getWidth();
            bm = q - bk - bl + 1;
            bn = 78;
            bo = bh + 7;
            bp = q - 134;
            bq = q - 84;
            bt = 5;
         } catch (IOException var1) {
         }
      }
   }

   private static void G() {
      try {
         if (ei == null) {
            ei = Image.createImage("/u/co.png");
         }

         (eD = new Image[2])[1] = Image.createImage("/u/wpt1.png");
         if (x == 0) {
            eD[0] = Image.createImage("/u/wpt0.png");
         } else {
            eD[0] = Image.createImage("/u/wpt" + (x + 1) + ".png");
         }
      } catch (Exception var0) {
      }
   }

   public static void k() {
      df = 5;
      if (eh == null) {
         try {
            eh = new Image[3];

            for(int var0 = 0; var0 < 3; ++var0) {
               eh[var0] = Image.createImage("/i/dm" + var0 + ".png");
            }
         } catch (Exception var1) {
         }
      }

      dg = new int[df];
      dh = new int[df];
      di = new int[df];
      dj = new int[df];
      dk = new int[df];
      dl = new int[df];
      dn = new int[df];
      dm = new int[df];
   }

   public static void e(int var0) {
      doFlag = false;
      if (var0 == 0) {
         if (ej == null) {
            ej = new Image[2];

            for(int var2 = 0; var2 < 2; ++var2) {
               try {
                  ej[var2] = Image.createImage("/npc/d" + var2 + ".png");
               } catch (Exception var1) {
               }
            }
         }

         doFlag = true;
         dp = 348;
         dq = 408;
         dr = 1;
         ds = 252;
         dt = 708;
      }

   }

   public static final void l() {
      if (!a) {
         if (ek == null) {
            ek = new Image[2][5];

            for(int var0 = 0; var0 < 2; ++var0) {
               for(int var1 = 0; var1 < 5; ++var1) {
                  try {
                     ek[var0][var1] = Image.createImage("/e/d" + var0 + var1 + ".png");
                  } catch (IOException var2) {
                  }
               }
            }
         }

         ck = new int[2];
         cl = new int[2];
         (cm = new int[2])[0] = cm[1] = -1;
      }
   }

   public static final void m() {
      if (el == null) {
         el = new Image[2];

         for(int var0 = 0; var0 < 2; ++var0) {
            try {
               if (eX) {
                  el[var0] = Image.createImage("/c/pt" + (var0 + 2) + ".png");
               } else {
                  el[var0] = Image.createImage("/c/pt" + var0 + ".png");
               }
            } catch (IOException var1) {
            }
         }
      }

      cW = 10;
      cX = new int[10];
      cY = new int[cW];
      cZ = new int[cW];
      da = new int[cW];
      db = new int[cW];
      dd = new boolean[cW];
      dc = new int[cW];

      for(int var2 = 0; var2 < cW; ++var2) {
         cZ[var2] = -1;
      }

   }

   public static final void n() {
      dQ = new int[5];
      dR = new int[5];
      dS = new int[5];
      dT = new int[5];
      dU = new int[5];
      dV = new int[5];
      dP = new String[5];

      for(int var0 = 0; var0 < 5; ++var0) {
         dU[var0] = -1;
      }

   }

   private static void x(int var0) {
      d = 2;
      v = var0;
      Midlet.d = 1;
      DebugRefactor.onMapLoading(var0);
      aw();
      (new Thread(Midlet.c)).start();
   }

   public static final void f(int var0) {
      if (gl) {
         gn = var0;
      }

      if (gn == var0) {
         ih = -1;
         if (em == null) {
            try {
               em = new Image[8];

               for(int var2 = 0; var2 < 8; ++var2) {
                  em[var2] = Image.createImage("/cp/gb" + var2 + ".png");
               }

               en = new Image[3];

               for(int var3 = 0; var3 < 3; ++var3) {
                  en[var3] = Image.createImage("/cp/gh" + var3 + ".png");
               }

               eo = new Image[9];

               for(int var4 = 0; var4 < 9; ++var4) {
                  eo[var4] = Image.createImage("/cp/gl" + var4 + ".png");
               }
            } catch (Exception var1) {
            }
         }

         gu = 22;
         gv = 32;
         gw = gu >> 1;
         gx = gv >> 1;
         gy = gu >> 2;
         gz = gv >> 2;
         if (gl) {
            go = ff - fn * 10;
            gp = fg;
            gA = fn;
            gs = 4;
         }

      }
   }

   public static void o() {
      if (es == null) {
         es = new Image[2];

         for(int var0 = 0; var0 < 2; ++var0) {
            try {
               es[var0] = Image.createImage("/e/l" + var0 + ".png");
            } catch (IOException var1) {
            }
         }
      }

   }

   public static void g(int var0) {
      dv = 0;
      dy = false;
      if (var0 == 0) {
         dv = 7;
         H();
         a(0, 0, 14, 17, 130, 11, 22, new String[]{"Chào, cậu là ai thế, mình chưa từng gặp bạn thì phải?", "Nói cậu nghe nhé, thầy cô trường này khó tính lắm đó.", "Cẩn thận với ông thầy Hiroyaki nhé. Đừng chọc giận ổng."});
         a(1, 1, 24, 17, 160, 15, 30, new String[]{"Mình là MinhXP, lớp trưởng lớp kiếm thuật.", "Kiếm là vũ khí lợi hại nhất của một ninja đấy bạn biết không?", "Khu vực luyện tập nằm ở bên trái. Hãy sang đấy tập luyện nhiều hơn nữa."});
         if (eR) {
            a(2, 6, 17, 12, 200, 7, 29, new String[]{"Thằng bên kia là sát thủ giả mạo.", "Ta đây mới là ninja sát thủ thứ thiệt đây!"});
         } else {
            a(2, 2, 17, 12, 200, 7, 29, new String[]{"Chào, tao tên là Tonic, mày là thằng nào?", "Nhìn lão hiệu trưởng kìa, lão có một hũ rượu trông hấp dẫn quá!", "Nếu muốn rủ tao đi nhậu thì ok, còn không thì biến đi.", "À, nếu mày có thấy con chó của tao thì báo tao 1 tiếng nhé."});
         }

         a(3, 3, 48, 17, 200, 44, 63, new String[]{"Hi, mình là Craze, trông bạn có vẻ hơi buồn thì phải?", "Bạn có thấy chán khi tối ngày quanh quẩn trong trường không?", "Đi về phía tay phải bạn sẽ đến được ngôi làng, ra đó để tìm niềm vui đi!"});
         a(4, 4, 46, 12, 200, 40, 54, new String[]{"Thằng nhà quê kia, mày mau kiếm tiền đóng thuế thân cho tao.", "Tao cho mày 2 ngày, nếu không đưa tao 1000$ thì mày ăn chém đó."});
         a(5, 5, 38, 17, 200, 34, 49, new String[]{"Xin chào, bạn là học sinh mới phải không?", "Nhìn thầy hiệu trưởng kìa, thầy vốn là một ninja sát thủ đấy.", "Thầy đã bỏ nghề sát thủ lâu rồi, nhưng tài năng vẫn còn đó", "Chúng ta có tập luyện cả đời cũng không bằng thầy đâu."});
         a(6, 6, 58, 12, 200, 46, 60, new String[]{"Đừng hỏi ta là ai...", "Ta chỉ là một ninja sát thủ thôi, ngươi biết thế là được rồi.", "Biến đi cho ta luyện tập."});
         y(7);
      }

      if (var0 == 1) {
         dv = 3;
         H();
         a(0, 5, 35, 9, 40, 33, 36, new String[]{"Bạn có thể nhảy lên cây cầu này nếu đã học xong khinh công từ cô Ayumi xinh đẹp."});
         if (eR) {
            a(1, 6, 25, 10, 40, 22, 28, new String[]{"Ta đây là một ninja sát thủ!", "Ha ha ha!"});
         } else {
            a(1, 2, 25, 10, 40, 22, 28, new String[]{"Mày đã học khinh công rồi hả?", "À, mày có thấy con chó của tao chạy đâu đâu không?"});
         }

         a(2, 1, 6, 9, 40, 2, 10, new String[]{"Bên kia là một thác nước rất lớn đấy.", "Nó không thuộc phạm vi trường chúng ta nữa nên có rất nhiều quái vật hung dữ.", "Nghe nói có một con quái vật rất to đấy, tốt hơn ngươi đừng qua làm gì!"});
         y(7);
      }

      if (var0 == 2) {
         dv = 7;
         H();
         a(0, 3, 16, 12, 60, 14, 21, new String[]{"Cậu nhìn thấy chiếc xe máy kia không?", "Phải có bằng lái từ thầy chủ nhiệm bạn mới có thể chạy được."});
         a(1, 4, 8, 12, 50, 2, 15, new String[]{"Thằng nhà quê kia, mày đi đâu đấy?"});
         if (eR) {
            a(2, 6, 29, 13, 200, 27, 40, new String[]{"Ninja sát thủ là ta - Thiên hạ vô địch!"});
         } else {
            a(2, 2, 29, 13, 200, 27, 40, new String[]{"Mày có thấy con chó của tao ở đâu không?"});
         }

         a(3, 5, 46, 13, 200, 41, 49, new String[]{"Nếu bạn muốn lên kia thì phải học khinh công từ cô Ayumi đã."});
         a(4, 1, 46, 11, 200, 43, 53, new String[]{"Cậu có thấy ở đây ai cũng tài giỏi không?", "Hãy cố gắng tập luyện hơn nữa nhé"});
         a(5, 0, 54, 11, 200, 50, 58, new String[]{"Ra ngoài rừng hoa đào có rất nhiều điều thú vị đấy.", "Bạn nên ra thử một lần để biết."});
         a(6, 6, 34, 13, 200, 28, 48, new String[]{"Đừng hỏi ta là ai...", "Ta chỉ là một ninja sát thủ thôi, ngươi biết thế là được rồi.", "Biến đi cho ta luyện tập."});
         y(7);
      }

      if (var0 == 99 || var0 == 101) {
         dv = 7;
         H();
         String[] var1 = new String[]{"Này, cậu đi tìm con heo đó trước đi. Tớ đi theo bọc lót cho!"};
         a(0, 0, 8, 13, 0, 0, 1000, var1);
         a(1, 1, 5, 13, 0, 0, 1000, var1);
         a(2, 6, 6, 13, 0, 0, 1000, var1);
         a(3, 2, 7, 13, 0, 0, 1000, var1);
         a(4, 4, 6, 13, 0, 0, 1000, var1);
         a(5, 5, 5, 13, 0, 0, 1000, var1);
         a(6, 3, 8, 13, 0, 0, 1000, var1);
         y(7);
      }

      if (var0 == 94) {
         dv = 7;
         H();
         String[] var2 = new String[]{"Chúc mừng, sắp được ra trường rồi nhé!"};
         a(0, 0, 5, 12, 0, 0, 1000, var2);
         a(1, 1, 5, 12, 0, 0, 1000, var2);
         a(2, 6, 6, 12, 0, 0, 1000, var2);
         a(3, 7, 3, 12, 0, 0, 1000, var2);
         a(4, 4, 6, 12, 0, 0, 1000, var2);
         a(5, 5, 5, 12, 0, 0, 1000, var2);
         a(6, 3, 8, 12, 0, 0, 1000, var2);
         y(8);
      }

   }

   private static void H() {
      dA = new int[dv];
      dB = new int[dv];
      dC = new int[dv];
      dD = new int[dv];
      dE = new int[dv];
      dF = new int[dv];
      dK = new int[dv];
      dG = new int[dv];
      dH = new int[dv];
      dI = new int[dv];
      dJ = new int[dv];
      dL = new int[dv];
      dM = new int[dv];
      dN = new int[dv];
      dO = new int[dv];
      dw = new String[dv][];
   }

   private static void y(int var0) {
      if (et == null) {
         et = new Image[var0][2];

         for(int var1 = 0; var1 < var0; ++var1) {
            for(int var2 = 0; var2 < 2; ++var2) {
               try {
                  et[var1][var2] = Image.createImage("/cp/f" + var1 + "h" + var2 + ".png");
               } catch (Exception var3) {
               }
            }
         }
      }

   }

   private static void a(int var0, int var1, int var2, int var3, int var4, int var5, int var6, String[] var7) {
      dA[var0] = var2 * 24 + (var0 << 2);
      dB[var0] = var3 * 24;
      dC[var0] = 0;
      dD[var0] = 0;
      dE[var0] = 1;
      dK[var0] = -1;
      dF[var0] = 0;
      dG[var0] = (var0 + 1) * 20 + var0;
      dH[var0] = 0;
      dI[var0] = var1;
      dJ[var0] = -1;
      dM[var0] = -1;
      dN[var0] = var5 * 24 + 12;
      dO[var0] = var6 * 24 + 12;
      dL[var0] = var4;
      dw[var0] = var7;
   }

   private static void I() {
      d = 2;
      aw();
      Midlet.d = 3;
      v = 99;

      try {
         eB = Image.createImage("/u/tt.png");
      } catch (Exception var1) {
      }

      bd = aV - 30;
      be = aV;
      aZ = 30;
      ba = aV - 50;
      bb = bc = aZ + ba >> 1;
      if (Midlet.b()) {
         aY = 1;
      }

      String var0;
      if ((var0 = System.getProperty("microedition.platform")).endsWith("JAVASDK") || var0.endsWith("wtk")) {
         Midlet.lowGfx = true;
         Y(1);
         lM = true;
      }

      (new Thread(Midlet.c)).start();
   }

   public static void h(int var0) {
      cq = 0;
      if (var0 == 9) {
         cq = 6;
         du = new boolean[]{false, false, true, false, false, false, false};
         J();
         b(0, 10, 12, 9, 12, 2);
         b(1, 7, 8, 6, 8, 2);
         b(2, 30, 8, 27, 33, 2);
         b(3, 29, 12, 27, 33, 2);
         b(4, 45, 5, 42, 50, 2);
         b(5, 64, 9, 62, 66, 2);
      }

      if (var0 == 10) {
         cq = 12;
         du = new boolean[]{true, false, true, false, false, false, false};
         J();
         b(0, 5, 8, 4, 6, 2);
         b(1, 6, 12, 5, 9, 0);
         b(2, 16, 12, 9, 21, 2);
         b(3, 28, 15, 26, 29, 0);
         b(4, 25, 15, 22, 27, 2);
         b(5, 16, 25, 14, 17, 0);
         b(6, 4, 29, 2, 6, 0);
         b(7, 8, 38, 2, 28, 2);
         b(8, 14, 38, 2, 28, 2);
         b(9, 20, 38, 2, 28, 2);
         b(10, 31, 30, 28, 37, 2);
         b(11, 33, 30, 28, 37, 0);
      }

      if (var0 == 11) {
         cq = 8;
         du = new boolean[]{true, true, true, false, false, false, false};
         J();
         b(0, 6, 11, 3, 7, 1);
         b(1, 19, 12, 18, 20, 0);
         b(2, 33, 8, 28, 36, 2);
         b(3, 53, 11, 53, 54, 1);
         b(5, 54, 11, 53, 54, 0);
         b(4, 68, 12, 62, 79, 2);
         b(6, 71, 12, 70, 72, 0);
         b(7, 72, 8, 70, 73, 1);
      }

      if (var0 == 16) {
         cq = 4;
         du = new boolean[]{false, false, false, true, false, false, false};
         J();
         b(0, 5, 11, 3, 10, 3);
         b(1, 26, 12, 24, 29, 3);
         b(2, 47, 10, 30, 55, 3);
         b(3, 60, 11, 56, 64, 3);
      }

      if (var0 == 17) {
         cq = 8;
         du = new boolean[]{false, false, false, true, true, false, false};
         J();
         b(0, 11, 8, 9, 13, 3);
         b(1, 20, 6, 18, 21, 4);
         b(2, 20, 11, 18, 21, 3);
         b(3, 26, 3, 24, 29, 3);
         b(4, 26, 8, 24, 29, 4);
         b(5, 26, 13, 24, 29, 4);
         b(6, 33, 6, 32, 35, 3);
         b(7, 33, 10, 32, 35, 4);
      }

      if (var0 == 18) {
         cq = 8;
         du = new boolean[]{false, false, false, false, true, true, true};
         J();
         b(0, 2, 8, 1, 4, 5);
         b(1, 2, 12, 1, 5, 6);
         b(2, 18, 12, 12, 23, 6);
         b(3, 18, 8, 15, 21, 5);
         b(4, 42, 9, 38, 45, 4);
         b(5, 42, 13, 34, 67, 6);
         b(6, 62, 13, 34, 67, 6);
         b(7, 60, 9, 57, 64, 4);
      }

   }

   private static void J() {
      boolean var0 = false;
      if (ev == null) {
         try {
            ev = new Image[4];

            for(int var3 = 0; var3 < 4; ++var3) {
               ev[var3] = Image.createImage("/mob/x" + var3 + ".png");
            }

            eu = new Image[7][2];

            for(int var4 = 0; var4 < 7; ++var4) {
               if (du[var4]) {
                  for(int var1 = 0; var1 < 2; ++var1) {
                     eu[var4][var1] = Image.createImage("/mob/y" + var4 + var1 + ".png");
                  }
               }
            }
         } catch (Exception var2) {
         }
      }

      ct = new int[cq];
      cu = new int[cq];
      cv = new int[cq];
      cw = new int[cq];
      cx = new int[cq];
      cy = new int[cq];
      cE = new int[cq];
      cF = new int[cq];
      cG = new int[cq];
      cH = new int[cq];
      cI = new int[cq];
      cJ = new int[cq];
      cK = new int[cq];
      cD = new int[cq];
      cL = new int[cq];
      cM = new int[cq];
      cz = new int[cq];
      cA = new int[cq];
      cB = new int[cq];
      cC = new int[cq];
      cs = new int[cq];
      cr = new int[cq];
   }

   private static void b(int var0, int var1, int var2, int var3, int var4, int var5) {
      ct[var0] = var1 * 24 + 12;
      cu[var0] = var2 * 24;
      cv[var0] = ct[var0];
      cw[var0] = cu[var0];
      cx[var0] = cv[var0];
      cy[var0] = cw[var0] - 9;
      cE[var0] = var5;
      cF[var0] = 3;
      cG[var0] = var0 << 1;
      cH[var0] = 0;
      cI[var0] = 1;
      cJ[var0] = 0;
      cK[var0] = 0;
      cD[var0] = 0;
      cL[var0] = var3 * 24 + 12;
      cM[var0] = var4 * 24 + 12;
      cs[var0] = ad[cE[var0]];
   }

   public static void i(int var0) {
      hb = 1200;
      ha = 1200;
      gP = 30;
      gO = false;
      if (var0 == 4) {
         gO = true;
         if (ew == null) {
            ew = new Image[5];

            for(int var1 = 0; var1 < 5; ++var1) {
               try {
                  ew[var1] = Image.createImage("/mob/b0" + var1 + ".png");
               } catch (Exception var3) {
               }
            }
         }

         gW = ew[0].getWidth();
         gX = ew[0].getHeight();
         gQ = 55 * jf + 12;
         gR = 13 * jf;
         gT = 1;
         gU = -1;
         gV = 0;
      }

      if (var0 == 5) {
         gO = true;
         if (ew == null) {
            ew = new Image[5];

            for(int var4 = 0; var4 < 5; ++var4) {
               try {
                  ew[var4] = Image.createImage("/mob/b0" + var4 + ".png");
               } catch (Exception var2) {
               }
            }
         }

         gW = ew[0].getWidth();
         gX = ew[0].getHeight();
         gQ = 8 * jf + 12;
         gR = 56 * jf;
         gT = 1;
         gU = -1;
         gV = 0;
      }

   }

   public static void p() {
      cN = 5;
      if (ex == null) {
         try {
            (ex = new Image[2])[0] = Image.createImage("/i/pt0.png");
            ex[1] = Image.createImage("/i/pt1.png");
            ex[2] = Image.createImage("/i/dm1.png");
         } catch (Exception var0) {
         }
      }

      cP = new int[cN];
      cQ = new int[cN];
      cR = new int[cN];
      cS = new int[cN];
      cT = new int[cN];
      cU = new int[cN];
      cV = new int[cN];
      cO = new int[cN];
   }

   public static void j(int var0) {
      hK = false;
      if (var0 == 97 && !eG) {
         hK = true;
         ey = new Image[4];

         for(int var2 = 0; var2 < 4; ++var2) {
            try {
               ey[var2] = Image.createImage("/mob/b1" + var2 + ".png");
            } catch (IOException var1) {
            }
         }

         hQ = 168;
         hR = 226;
         ia = 144;
         ib = 480;
         hY = 2;
         hZ = -1;
         hO = 8000;
         hN = 8000;
      }

   }

   public static final void q() {
      if (ez == null) {
         ez = new Image[3];

         for(int var0 = 0; var0 < 3; ++var0) {
            try {
               ez[var0] = Image.createImage("/e/sp" + var0 + ".png");
            } catch (IOException var1) {
            }
         }
      }

      cb = new int[2];
      cc = new int[2];
      cd = new int[2];
      ce = new int[2];
      cf = new int[2];
      cd[0] = cd[1] = -1;
   }

   public static void k(int var0) {
      hj = false;
      if (var0 == 95 && !eI) {
         hj = true;
         eA = new Image[6];

         try {
            eA[0] = Image.createImage("/mob/b20.png");
            eA[1] = Image.createImage("/mob/b21.png");
            eA[2] = Image.createImage("/mob/b22.png");
            eA[3] = eA[1];
            eA[4] = Image.createImage("/mob/b23.png");
            eA[5] = Image.createImage("/cp/f2h0.png");
         } catch (IOException var1) {
         }

         hq = 192;
         hr = 264;
         hu = 120;
         hv = 504;
         hs = 0;
         ht = -1;
         ho = 90000;
         hn = 90000;
         hE = new int[6];
         hF = new int[6];
         hI = new int[6];
         hJ = new int[6];
         hG = new int[]{20, 10, 0, -10, -16, 2};
         hH = new int[]{-16, 0, -12, 0, -18, -42};
         hy = new int[][]{new int[6], {0, 0, 1, 0, 1, 1}};
         hz = new int[][]{new int[6], {1, 0, 1, 0, 2, 1}};
         hA = new int[][]{{6, -1, 1, 1, 5, 1}, {14, -1, 2, 1, 12, 2}};
         hB = new int[][]{{1, 0, 0, 0, 1, 0}, {2, 0, 1, 0, 2, 1}};
         hC = new int[][]{{-3, 3, 0, -3, 3, 0}, new int[6], {3, -3, 0, 3, -3, 0}};
         hD = new int[][]{{-1, -2, 1, 0, 1, 1}, new int[6], {1, 0, 1, -2, -1, 1}};
      }

   }

   public static void l(int var0) {
      hd = false;
      if (var0 == 96 && !eH) {
         hd = true;
         dv = 1;
         H();
         a(0, 2, 5, 11, 200, 4, 22, (String[])null);
         y(3);
         hi = 15000;
         hh = 15000;
         hg = 120;
         dv = 0;
         dE[0] = 0;
         dK[0] = 1;
      }

   }

   // public static void m(int var0) {
   //    if (var0 == 94) {
   //       dx = true;
   //       ff = 24;
   //       fg = 288;
   //       gn = 94;
   //       go = 12;
   //       gp = 288;
   //       gA = 1;
   //       gl = false;
   //       fn = 1;
   //    }

   //    if (var0 == 0 && currentQuestIndex == 15 && fB) {
   //       gn = -1;
   //       gl = false;
   //    }

   //    if (var0 == 0 && currentQuestIndex == 16 && fc) {
   //       fb = true;
   //       gn = 0;
   //       gl = true;
   //       fv = true;
   //       currentQuestIndex = -1;
   //       ff = 984;
   //       fg = 408;
   //    } else {
   //       if (var0 == 95 && !eI) {
   //          gl = false;
   //          go = 599;
   //          gp = 264;
   //          gA = -1;
   //          gn = 95;
   //       }

   //    }
   // }
   
   public static void setCurrentQuestIndex(int value) {
      currentQuestIndex = value;
   }

   public static int getCurrentQuestIndex() {
      return currentQuestIndex;
   }
   public static boolean isFv() {
      return fv;
   }

   public static void setFv(boolean value) {
      fv = value;
   }
   public static boolean isEI() {
      return eI;
   }

   public static void setEI(boolean value) {
      eI = value;
   }
   public static boolean isFc() {
      return fc;
   }

   public static void setFc(boolean value) {
      fc = value;
   }

   public static boolean isFb() {
      return fb;
   }

   public static void setFb(boolean value) {
      fb = value;
   }

   public static boolean isDx() {
      return dx;
   }

   public static void setDx(boolean value) {
      dx = value;
   }
   public static int getFf() {
      return ff;
   }

   public static void setFf(int value) {
      ff = value;
   }

   public static int getFg() {
      return fg;
   }

   public static void setFg(int value) {
      fg = value;
   }

   public static int getGn() {
      return gn;
   }

   public static void setGn(int value) {
      gn = value;
   }

   public static int getGo() {
      return go;
   }

   public static void setGo(int value) {
      go = value;
   }

   public static int getGp() {
      return gp;
   }

   public static void setGp(int value) {
      gp = value;
   }

   public static int getGA() {
      return gA;
   }

   public static void setGA(int value) {
      gA = value;
   }

   public static boolean isGl() {
      return gl;
   }

   public static void setGl(boolean value) {
      gl = value;
   }

   public static int getFn() {
      return fn;
   }

   public static void setFn(int value) {
      fn = value;
   }

   public static void n(int var0) {
      ifFlag = false;
      fT = false;
      fI = 0;
      if (var0 == 15 && currentQuestIndex == 15) {
         e(216, 432);
      }

      if (var0 == 8 && currentQuestIndex == 6) {
         e(72, 240);
      }

      if (var0 == 4 && eF) {
         T = true;
         khinhCong = true;
         eR = true;
         eQ = true;
         skillSetAmSatLearned(true);
         skillSetDashLearned(true);
         syncDashDurationToLevel();
         H = 1000;
         G = 1000;
         J = 2000;
         I = 2000;
         E = 25;
         A = 4;
         hb = 500;
         ha = 500;
         D(0);
      } else if (var0 == 99) {
         eF = true;
         dx = true;
         ff = 108;
         fg = 312;
         fn = -1;
         D(1);
      } else if (var0 == 94) {
         D(10);
      } else if (var0 == 0 && eF) {
         T = false;
         khinhCong = false;
         eQ = false;
         eR = false;
         skillSetDashLearned(false);
         skillSetAmSatLearned(false);
         dashLevel = 1;
         syncSkillsFromLegacyFlags();
         fy = false;
         G = 200;
         H = 200;
         I = 200;
         J = 200;
         hb = 1000;
         ha = 1000;
         N = 0;
         characterLevel = 1;
         E = 20;
         ff = 864;
         fg = 336;

         for(int var1 = 0; var1 < 19; ++var1) {
            W[var1] = false;
         }

         W[0] = true;
         fn = -1;
         dx = false;
         dy = false;
         D(2);
         eF = false;
      } else if (var0 == 3 && currentQuestIndex == 3 && !gl) {
         D(3);
      } else if (var0 == 0 && currentQuestIndex == 3 && gl) {
         D(4);
      } else if (var0 == 97 && !eG) {
         D(5);
      } else if (var0 == 96 && !eH) {
         D(6);
      } else if (var0 == 95 && !eI) {
         D(7);
      } else if (var0 == 101) {
         D(8);
         fQ = fK = 336 - r;
         fJ = 24;
         fP = 24;
      } else if (var0 == 9 && currentQuestIndex == 10) {
         D(9);
      }

      if (var0 == 97 && eG) {
         for(int var2 = 0; var2 <= 6; ++var2) {
            i(24, var2, 0);
         }
      }

      if (var0 == 96 && eH) {
         for(int var3 = 0; var3 <= 11; ++var3) {
            i(24, var3, 0);
         }
      }

   }

   public static final void r() {
      if (!a) {
         eE = new Image[3];

         for(int var0 = 0; var0 < 3; ++var0) {
            try {
               eE[var0] = Image.createImage("/e/w" + var0 + ".png");
            } catch (IOException var1) {
            }
         }

         cg = new int[2];
         ch = new int[2];
         ci = new int[2];
         cj = new int[2];
         ci[0] = ci[1] = -1;
      }
   }

   private static void z(int var0) {
      if (dB[0] == fg && a(dA[0] + (dK[0] << 5) - ff) < 25) {
         a(hg, dK[0]);
      }

   }

   private static void A(int var0) {
      int var1;
      int var6;
      label29: {
         var1 = E;
         var6 = dM[var0];
         int var4 = -dK[var0];
         int var2 = var6;
         if (jQ[var2] == 2 || jQ[var2] == 3 || jQ[var2] == 4) {
            int[] var5 = ka;
            var5[var2] -= var1;
            if (ka[var2] <= 0) {
               ka[var2] = 0;
               jV[var2] = -5;
               jW[var2] = -(var4 << 3);
               jX[var2] = 0;
               jP[var2] = 0;
               jQ[var2] = 1;
               var6 = 1;
               break label29;
            }

            jV[var2] = 0;
            jZ[var2] = var4;
            jQ[var2] = 6;
            jY[var2] = 3;
         }

         var6 = 0;
      }

      if (var6 == 0) {
         f(jL[dM[var0]], jM[dM[var0]] - (jN[dM[var0]] >> 1), jZ[dM[var0]]);
         a("-" + var1, 0, jL[dM[var0]], jM[dM[var0]] - jN[dM[var0]], 0, -2);
      }

   }

   private static void B(int var0) {
      for(int var1 = 0; var1 < jI; ++var1) {
         if (jQ[var1] != 5 && jM[var1] == dB[var0] && a(dA[var0] + (dK[var0] << 3) - jL[var1]) < 20) {
            if (jL[var1] < dA[var0]) {
               dK[var0] = -1;
            } else {
               dK[var0] = 1;
            }

            dE[var0] = 5;
            dF[var0] = dG[var0] = 0;
            dM[var0] = var1;
         }
      }

   }

   private static void K() {
      if (iJ < iF[iD].length) {
         iJ = iF[iD].length;
         iI = 0;
      } else {
         ++iD;
         iJ = 0;
         iI = 0;
      }
   }

   private static void a(Graphics var0) {
      if (b && !a) {
         var0.setColor(i);
         var0.fillRect(0, 0, q, p);

         for(int var2 = -((fP >> 1) % 24); var2 < q; var2 += 24) {
            var0.drawImage(s[0], var2, j, 0);
         }

         for(int var3 = -((fP >> 2) % 24); var3 < q; var3 += 24) {
            var0.drawImage(s[1], var3, k, 0);
         }

         for(int var4 = -((fP >> 4) % 64); var4 < q; var4 += 64) {
            var0.drawImage(s[3], var4, m, 0);
         }

         var0.drawImage(u, g, h, 3);

         for(int var5 = 0; var5 < 2; ++var5) {
            var0.drawImage(t, e[var5], f[var5], 3);
         }

         for(int var6 = -((fP >> 3) % 192); var6 < q; var6 += 192) {
            var0.drawImage(s[2], var6, l, 0);
         }

      } else {
         var0.setColor(i);
         var0.fillRect(0, 0, q, r);
         if (!a) {
            var0.drawImage(u, g, h, 3);

            for(int var1 = 0; var1 < 2; ++var1) {
               var0.drawImage(t, e[var1], f[var1], 3);
            }

         }
      }
   }

   private static void b(Graphics var0) {
      if (fx) {
         if (w % 20 > 2) {
            B = 25;
         } else {
            B = 26;
         }
      }

      if (fn == 1) {
         var0.drawImage(ep[aq[B][0][0]], ff + aq[B][0][1], fg - aq[B][0][2], 0);
         var0.drawImage(er[aq[B][1][0]], ff + aq[B][1][1], fg - aq[B][1][2], 0);
         var0.drawImage(ee[aq[B][2][0]], ff + aq[B][2][1], fg - aq[B][2][2], 0);
         if (fd != -1) {
            var0.drawImage(eC[fd], ff - ar[fd], fg - as[fd], 0);
            return;
         }
      } else {
         var0.drawRegion(ep[aq[B][0][0]], 0, 0, ep[aq[B][0][0]].getWidth(), ep[aq[B][0][0]].getHeight(), 2, ff - aq[B][0][1], fg - aq[B][0][2], 24);
         var0.drawRegion(er[aq[B][1][0]], 0, 0, er[aq[B][1][0]].getWidth(), er[aq[B][1][0]].getHeight(), 2, ff - aq[B][1][1], fg - aq[B][1][2], 24);
         var0.drawRegion(ee[aq[B][2][0]], 0, 0, ee[aq[B][2][0]].getWidth(), ee[aq[B][2][0]].getHeight(), 2, ff - aq[B][2][1], fg - aq[B][2][2], 24);
         if (fd != -1) {
            var0.drawRegion(eC[fd], 0, 0, eC[fd].getWidth(), eC[fd].getHeight(), 2, ff + ar[fd], fg - as[fd], 24);
         }
      }

   }

   private static void c(Graphics var0) {
      if (!bf) {
         var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
         var0.drawImage(ep[0], 0, 2, 0);
         var0.setColor(0);
         var0.drawRect(23, 2, bp + 1, 4);
         var0.drawRect(23, 8, bp + 1, 4);
         var0.drawRect(23, 14, bp + 1, 3);
         var0.setColor(16711680);
         int var1 = G * bp / H;
         var0.fillRect(24, 3, var1, 3);
         var0.setColor(5570560);
         var0.fillRect(var1 + 24, 3, bp - var1, 3);
         var0.setColor(255);
         var1 = I * bp / J;
         var0.fillRect(24, 9, var1, 3);
         var0.setColor(5570560);
         var0.fillRect(var1 + 24, 9, bp - var1, 3);
         var0.setColor(7274435);
         var1 = N * bp / ai[characterLevel - 1];
         var0.fillRect(24, 15, var1, 2);
         var0.setColor(19506);
         var0.fillRect(var1 + 24, 15, bp - var1, 2);
         Midlet.a(var0, "lv:" + characterLevel, 2, br, 7, 0);
         Midlet.a(var0, de + "$", 1, bs, 7, 0);
      }
   }

   private static void d(Graphics var0) {
      c = false;
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setClip(-1, bh - 1, bi + 2, 100);
      var0.setColor(0);
      if (!bf) {
         var0.fillRect(0, bh, bi, 15);
         Midlet.a(var0, n, 3, bh + 3, 0);
         Midlet.a(var0, o, bi - 3, bh + 3, 1);
      } else {
         var0.fillRect(0, bh + 33, bi, 15);
         Midlet.a(var0, n, 3, bh + 36, 0);
         Midlet.a(var0, o, bi - 3, bh + 36, 1);
         var0.setColor(4352);
         var0.fillRect(bk, bh, bm, 1);
         var0.fillRect(bk, bh + 35, bm, 1);
         var0.fillRect(bk, bh + 33, bm, 1);
         var0.fillRect(bk, bh + 30, bm, 1);
         var0.fillRect(bk, bh + 28, bm, 1);
         var0.fillRect(bk, bh + 26, bm, 1);
         var0.fillRect(bk, bh + 12, bm, 1);
         var0.fillRect(bk, bh + 24, bm, 1);
         var0.fillRect(bk, bh + 18, bm, 1);
         var0.fillRect(bk, bh + 16, bm, 1);
         var0.fillRect(bk, bh + 2, bm, 1);
         var0.fillRect(bk, bh + 4, bm, 1);
         var0.fillRect(bk, bh + 6, bm, 1);
         var0.fillRect(bk, bh + 14, bm, 1);
         var0.setColor(15649843);
         var0.fillRect(bk, bh + 1, bm, 1);
         var0.fillRect(bk, bh + 5, bm, 1);
         var0.fillRect(bk, bh + 17, bm, 1);
         var0.fillRect(bk, bh + 34, bm, 1);
         var0.fillRect(bk, bh + 29, bm, 1);
         var0.setColor(16767871);
         var0.fillRect(bk, bh + 3, bm, 1);
         var0.fillRect(bk, bh + 15, bm, 1);
         var0.fillRect(bk, bh + 27, bm, 1);
         var0.setColor(3355443);
         var0.fillRect(bk, bh + 7, bm, 5);
         var0.fillRect(bk, bh + 19, bm, 5);
         var0.fillRect(bk, bh + 31, bm, 2);
         var0.setColor(12281361);
         var0.fillRect(bk, bh + 25, bm, 1);
         var0.fillRect(bk, bh + 13, bm, 1);
         var0.drawImage(eg[0], 0, bh, 0);
         var0.drawImage(eg[1], 0 + bi, bh, 24);
         int var1 = G * bp / H;
         var0.setColor(7798784);
         var0.fillRect(bn, bo, var1, 2);
         var0.setColor(13369344);
         var0.fillRect(bn, bo + 1, var1, 4);
         var1 = I * bp / J;
         var0.setColor(119);
         var0.fillRect(bn, bo + 12, var1, 2);
         var0.setColor(204);
         var0.fillRect(bn, bo + 14, var1, bt - 2);
         Midlet.a(var0, "" + de, 1, bi - 18, bh + 6, 2);
         var1 = N * bq / ai[characterLevel - 1];
         var0.setColor(94373);
         var0.fillRect(31, bh + 31, var1, 1);
         var0.setColor(65535);
         var0.fillRect(31, bh + 32, var1, 1);
         Midlet.a(var0, "" + characterLevel, 2, 26, bh + 11, 2);
         var0.drawImage(eD[fe], 43, bh + 16, 3);
         Midlet.a(var0, "" + (V[0] + V[1] + V[2]), 2, bi - 29, bh + 19, 2);
         Midlet.a(var0, "" + (V[3] + V[4] + V[5]), 2, bi - 9, bh + 19, 2);
      }
   }

   private static void e(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setClip(-1, -1, aU + 2, aV + 2);
      var0.setColor(0);
      var0.fillRect(0, 0, q, bv);
      if (bf) {
         var0.fillRect(0, aV - bv + 1, q, bv);
      } else {
         var0.fillRect(0, aV - 13, aU, 13);
      }

      if (fW) {
         for(int var1 = 0; var1 < fX.length; ++var1) {
            Midlet.a(var0, fX[var1], bD, fY + (var1 << 4), 2);
         }
      }

   }

   private static void f(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setClip(-1, -1, aU + 2, aV + 2);
      iB = iF[iD].length;
      int var1 = iH - fQ - (iB << 4);
      boolean var2 = true;
      if (var1 < 10) {
         var2 = false;
         var1 = 10;
      }

      var0.setColor(16777215);
      if (a) {
         var0.fillRect(iL, var1 - 5, iK, (iB << 4) + 7);
      } else {
         var0.fillRoundRect(iL, var1 - 5, iK, (iB << 4) + 7, 10, 10);
      }

      var0.setColor(17408);
      if (a) {
         var0.drawRect(iL - 1, var1 - 5, iK + 1, (iB << 4) + 7);
      } else {
         var0.drawRoundRect(iL - 1, var1 - 5, iK + 1, (iB << 4) + 7, 10, 10);
      }

      for(int var3 = 0; var3 < iJ; ++var3) {
         Midlet.b(var0, iF[iD][var3], iL + (iK >> 1), var1 + (var3 << 4), 2);
      }

      if (iJ < iF[iD].length) {
         Midlet.b(var0, iF[iD][iJ].substring(0, iI), iL + (iK >> 1), var1 + (iJ << 4), 2);
      }

      var0.setColor(0);
      var0.fillRect(0, bh + 33, bi, 15);
      if (var2 && iG > fP + 10 && iG < fP + q - 10) {
         var0.drawImage(ei, iG - fP, iH - fQ + 2, 17);
      }

      if (w % 10 < 8) {
         Midlet.a(var0, "Tiếp tục", bD, aV - 13, 2);
      }

   }

   private static void g(Graphics var0) {
      for(int var1 = 0; var1 < dv; ++var1) {
         if (dA[var1] + fj >= fP && dA[var1] - fj <= fP + q && dB[var1] >= fQ && dB[var1] - fi <= fQ + r) {
            if (dK[var1] == 1) {
               var0.drawImage(et[dI[var1]][aH[dH[var1]][0][0]], dA[var1] + aH[dH[var1]][0][1], dB[var1] - aH[dH[var1]][0][2], 0);
               var0.drawImage(er[aH[dH[var1]][1][0]], dA[var1] + aH[dH[var1]][1][1], dB[var1] - aH[dH[var1]][1][2], 0);
               var0.drawImage(ee[aH[dH[var1]][2][0]], dA[var1] + aH[dH[var1]][2][1], dB[var1] - aH[dH[var1]][2][2], 0);
               if (dJ[var1] != -1) {
                  var0.drawImage(eC[dJ[var1]], dA[var1] - ar[dJ[var1]], dB[var1] - as[dJ[var1]], 0);
               }
            } else {
               var0.drawRegion(et[dI[var1]][aH[dH[var1]][0][0]], 0, 0, et[dI[var1]][aH[dH[var1]][0][0]].getWidth(), et[dI[var1]][aH[dH[var1]][0][0]].getHeight(), 2, dA[var1] - aH[dH[var1]][0][1], dB[var1] - aH[dH[var1]][0][2], 24);
               var0.drawRegion(er[aH[dH[var1]][1][0]], 0, 0, er[aH[dH[var1]][1][0]].getWidth(), er[aH[dH[var1]][1][0]].getHeight(), 2, dA[var1] - aH[dH[var1]][1][1], dB[var1] - aH[dH[var1]][1][2], 24);
               var0.drawRegion(ee[aH[dH[var1]][2][0]], 0, 0, ee[aH[dH[var1]][2][0]].getWidth(), ee[aH[dH[var1]][2][0]].getHeight(), 2, dA[var1] - aH[dH[var1]][2][1], dB[var1] - aH[dH[var1]][2][2], 24);
               if (dJ[var1] != -1) {
                  var0.drawRegion(eC[dJ[var1]], 0, 0, eC[dJ[var1]].getWidth(), eC[dJ[var1]].getHeight(), 2, dA[var1] + ar[dJ[var1]], dB[var1] - as[dJ[var1]], 24);
               }
            }
         }
      }

   }

   private static void h(Graphics var0) {
      var0.setClip(-1, -1, aU + 2, aV + 1);
      a(var0);
      var0.translate(-fP, -fQ);
      if (a) {
         j(var0);
      } else {
         k(var0);
      }

      i(var0);
      g(var0);
      b(var0);
      r(var0);
      l(var0);
      e(var0);
      if (iA) {
         f(var0);
      }

   }

   private static void L() {
      if (!fx && A != 14 && a(fg - gR) < 30 && a(ff - gQ) < 200) {
         gT = 5;
         gU = gQ < ff ? 1 : -1;
         gZ = ff + (gU << 5);
         gS = gU * 6;
         if (ha < hb >> 1) {
            gS = gU << 3;
         }
      }

   }

   private static void d(int var0, int var1, int var2) {
      ij = var0 + 1;
      D();
      b(0, var1, var2);
      if (var0 == 1) {
         b(1, ff, fg);
         ik = 1;
         in[ik] = fn;
      }

   }

   private static void b(int var0, int var1, int var2, int var3, int var4) {
      int var5 = -1;

      for(int var6 = 0; var6 < bN; ++var6) {
         if (bQ[var6] == -1) {
            var5 = var6;
            break;
         }
      }

      if (var5 != -1) {
         bQ[var5] = 1;
         bO[var5] = var0;
         bP[var5] = var1;
         bR[var5] = var2;
         bS[var5] = var3;
         bT[var5] = var4;
      }
   }

   private static void a(int var0, int var1, int var2, int var3) {
      gc = var0;
      gd = var1;
      ge = var2;
      gk = var3;
   }

   private static void c(int var0, int var1, int var2, int var3, int var4) {
      int var5 = -1;

      for(int var6 = 0; var6 < bU; ++var6) {
         if (bX[var6] == 0) {
            var5 = var6;
            break;
         }
      }

      if (var5 != -1) {
         bX[var5] = 1;
         bV[var5] = var0;
         bW[var5] = var1;
         bY[var5] = var2;
         bZ[var5] = var3;
         ca[var5] = var4;
      }
   }

   private static void e(int var0, int var1) {
      fG = var0;
      fH = var1;
      fI = 1;
   }

   private static void C(int var0) {
      ga = 0;
      fU = var0;
      fV = 0;
      fT = true;
      gb = false;
      c();
      d();
   }

   private static void a(String[] var0, int var1, int var2, int var3) {
      iE = var1;
      iG = var2;
      iH = var3;
      iC = var0.length;
      iD = 0;
      iF = new String[iC][];
      if ((iK = q >> 1) < 120) {
         iK = 120;
      }

      for(int var4 = 0; var4 < iC; ++var4) {
         iF[var4] = Midlet.b(var0[var4], iK - 20);
      }

      if ((iL = iG - (iK >> 1) - fP) < 2) {
         iL = 2;
      }

      if (iL + iK > q - 2) {
         iL = q - 2 - iK;
      }

      iA = true;
      iI = 0;
      iJ = 0;
   }

   private static boolean e(int var0, int var1, int var2) {
      if (a) {
         return false;
      } else {
         var0 = var0 == 1 ? 0 : 1;
         if (cm[var0] != -1) {
            return false;
         } else {
            cm[var0] = 0;
            ck[var0] = var1;
            cl[var0] = var2;
            return true;
         }
      }
   }

   private static void a(int var0, int var1, int var2, int var3, boolean var4) {
      int var5 = -1;

      for(int var6 = 0; var6 < cW; ++var6) {
         if (cZ[var6] == -1) {
            var5 = var6;
            break;
         }
      }

      if (var5 != -1) {
         cZ[var5] = 1;
         cX[var5] = var0;
         cY[var5] = var1;
         db[var5] = var2;
         dc[var5] = var3;
         dd[var5] = var4;
      }
   }

   private static void a(String var0, int var1, int var2, int var3, int var4, int var5) {
      var4 = -1;

      for(int var6 = 0; var6 < 5; ++var6) {
         if (dU[var6] == -1) {
            var4 = var6;
            break;
         }
      }

      if (var4 != -1) {
         dP[var4] = var0;
         dQ[var4] = var2;
         dR[var4] = var3;
         dS[var4] = 0;
         dT[var4] = var5;
         dU[var4] = 0;
         dV[var4] = var1;
      }
   }

   private static void f(int var0, int var1) {
      dY = 1;
      dW = var0;
      dX = var1;
   }

   private static void c(String var0) {
      cp = var0;
      co = 0;
      cn = true;
   }

   private static boolean f(int var0, int var1, int var2) {
      int var3 = cd[0] == -1 ? 0 : 1;
      if (cd[var3] != -1) {
         return false;
      } else {
         cd[var3] = 0;
         cf[var3] = var2;
         cb[var3] = var0;
         cc[var3] = var1;
         return true;
      }
   }

   private static void D(int var0) {
      ig = 0;
      ie = var0;
      ifFlag = true;
   }

   private static boolean g(int var0, int var1) {
      if (a) {
         return false;
      } else {
         int var2 = ci[0] == -1 ? 0 : 1;
         if (ci[var2] != -1) {
            return false;
         } else {
            ci[var2] = 0;
            cg[var2] = var0;
            ch[var2] = var1;
            return true;
         }
      }
   }

   private static void M() {
      for(int var0 = 0; var0 < bN; ++var0) {
         if (bQ[var0] == 1) {
            int[] var10000 = bO;
            var10000[var0] += bR[var0];
            if (bO[var0] >= fP && bO[var0] <= fP + q && bP[var0] >= fQ && bP[var0] <= fQ + r) {
               if (a(ff - bO[var0]) < fj && a(fg - fk - bP[var0]) < fk) {
                  if (A == 5 && fe == 0 && bT[var0] < 3) {
                     bR[var0] = -bR[var0];
                     var10000 = bO;
                     var10000[var0] += bR[var0];
                     return;
                  }

                  a(bS[var0], bO[var0] < ff ? 1 : -1);
                  bQ[var0] = -1;
                  return;
               }
            } else {
               bQ[var0] = -1;
            }
         }
      }

   }

   private static void N() {
      if (gc >= 0) {
         if (gd > fP + 10 && gd < fP + q - 10 && ge > fQ + 10 && ge < fQ + r - 10) {
            gf = 2;
            gg = gd;
            gh = ge + gj;
         } else if (a(ff - gd) > a(fg - ge)) {
            if (ff > gd) {
               gf = 1;
               gg = fP + 20 + gj;
            } else {
               gf = 0;
               gg = fP + q - 20 + gj;
            }

            if ((gh = ge + 24) < fQ + 10) {
               gh = fQ + 10;
            }

            if (gh > fQ + r - 10) {
               gh = fQ + r - 10;
            }
         } else if (fg > ge) {
            gf = 3;
            gg = ff;
            gh = fQ + 20 + gj;
         } else {
            gf = 2;
            gg = ff;
            gh = fQ + r - 20 + gj;
         }

         if ((gj += gi) == 5 || gj == -5) {
            gi = -gi;
         }
      }

   }

   private static void O() {
      for(int var0 = 0; var0 < bU; ++var0) {
         if (bX[var0] != 0) {
            int[] var10000 = bV;
            var10000[var0] += bY[var0];
            var10000 = bW;
            var10000[var0] += bZ[var0];
            int var10002 = bZ[var0]++;
            if (bW[var0] > fQ + r) {
               bX[var0] = 0;
            }

            if (a(ff - bV[var0]) < fj && a(fg - fk - bW[var0]) < fk) {
               a(ca[var0], bV[var0] < ff ? 1 : -1);
               bX[var0] = -1;
               return;
            }
         }
      }

   }

   private static void P() {
      if (fI != 0) {
         if (fI == 1) {
            if (a(fg - (fi >> 1) - (fH - 7)) < 10 && a(ff - fG) < 10) {
               fI = 2;
               fB = true;
               c("đã lấy được bí kíp");
               return;
            }
         } else {
            ++fI;
            fH -= 3;
            if (fI > 40) {
               fI = 0;
            }
         }

      }
   }

   private static void Q() {
      if (fy) {
         aK = 0;
      }

   }

   private static void R() {
      if (fv) {
         fJ = ff - bD + bG * fn;
         fK = fg - bF;
      }

      label788:
      switch (A) {
         case 1:
            if (++C > 30) {
               C = 0;
            }

            if (C % 15 < 5) {
               B = 0;
            } else {
               B = 1;
            }

            S();

            for(int var5 = 0; var5 < dv; ++var5) {
               if (dE[var5] == 1 && fg == dB[var5] && a(ff - dA[var5]) < 30 && fF == -1) {
                  o = "Trò chuyện";
                  c = true;
                  fF = var5;
                  break;
               }
            }

            if (gn == v && gs == 1 && fg == gp && a(ff - go) < 30) {
               o = "Nói chuyện";
               c = true;
               fC = true;
            }

            for(int var6 = 0; var6 < lv; ++var6) {
               if (fg == lx[var6] && a(ff - lw[var6]) < 30 && fE == -1) {
                  o = "Giao tiếp";
                  c = true;
                  fE = var6;
                  break label788;
               }
            }
            break;
         case 2:
            if (++C >= 10) {
               C = 0;
               fp = 0;
               if (eY) {
                  fp = fn << 1;
               }
            }

            B = (C >> 1) + 2;
            if (fn == 1) {
               if (g(ff + fj, fg - fk, 4)) {
                  y = 0;
                  ff = I(ff + fj) - fj;
               }
            } else if (g(ff - fj - 1, fg - fk, 8)) {
               y = 0;
               ff = I(ff - fj - 1) + jf + fj;
            }

            if ((i(ff, fg - 1) & 64) == 64) {
               ff += y >> 1;
            } else {
               ff += y;
            }

            if (y > 0) {
               --y;
            } else if (y < 0) {
               ++y;
            } else {
               A = 1;
               fp = 0;
            }

            if (is != -1) {
               if (a(ff - it[is]) >= 20) {
                  is = -1;
                  if (g(ff, fg, 2)) {
                     A = 1;
                  } else {
                     A = 4;
                     z = 2;
                     y = 3 * fn;
                     D = 0;
                  }
               }
            } else if ((i(ff, fg) & 2) != 2) {
               A = 4;
               y = 3 * fn;
               D = 0;
            }

            x();
            e(fn, ff - (fn << 3), fg);
            S();
            break;
         case 3:
            ff += y;
            if ((fg += z) < 0) {
               fg = 0;
               z = -1;
            }

            if (C == 0) {
               B = 7;
            } else {
               B = 23;
            }

            ++z;
            if (khinhCong && !fy) {
               if (z == -3) {
                  B = 8;
               } else if (z == -2) {
                  B = 9;
               } else if (z == -1) {
                  B = 10;
               } else if (z == 0) {
                  B = 11;
               }
            }

            if (z == 0) {
               A = 4;
               C = 0;
               D = khinhCong ? 1 : 0;
               z = 1;
               c = true;
            }

            if (fo < 0) {
               ++fo;
            }

            if (fn == 1) {
               if ((i(ff + fj, fg) & 4) == 4) {
                  ff = I(ff + fj) - fj;
                  y = 0;
               }
            } else if ((i(ff - fj, fg) & 8) == 8) {
               ff = I(ff + 24 - fj) + fj;
               y = 0;
            }
            break;
         case 4:
            fd = -1;
            ff += y;
            fg += z;
            if (z < 18) {
               ++z;
            }

            if (y > 0) {
               --y;
            }

            B = 7;
            if (fg >= iQ) {
               A = 6;
               G = 0;
            } else if (fg + 4 >= iQ) {
               A = 6;
               G = 0;
            } else if (z > 4 && (i(ff, fg + 3) & 2) == 2) {
               if (z > 12) {
                  A = 8;
               } else {
                  A = 1;
               }

               z = 0;
               y = 0;
               D = 0;
               C = 0;
               fg = I(fg + 3);
               e(-1, ff - -8, fg);
               e(1, ff - 8, fg);
               if (eN) {
                  for(int var4 = 0; var4 < ij; ++var4) {
                     if (fg == im[var4] && a(ff - il[var4]) < 16) {
                        ff = il[var4];
                        A = 18;
                        ik = var4;
                        in[var4] = fn;
                        io[var4] = 0;
                     }
                  }
               }

               if (currentQuestIndex == 11 && fD < 20) {
                  fD = 0;
                  c("Hit: " + fD);
               }
            } else {
               if (g(ff, fg, 64) && fg % jf > 8) {
                  g(ff, H(fg) + 8);
                  fg = H(fg) + 8;
                  A = 11;
                  y = fn << 1;
                  z >>= 2;
                  fg = H(fg) + 12;
                  if (I == 0 || !eQ) {
                     A = 12;
                  }
               }

               if (g(ff, fg, 4096)) {
                  A = 12;
               }

               if (D == 1 && !fy) {
                  if (z == 3) {
                     B = 11;
                  } else if (z == 2) {
                     B = 8;
                  } else if (z == 1) {
                     B = 9;
                  } else if (z == 0) {
                     B = 10;
                  }
               } else {
                  B = 23;
               }

               if (z > 6) {
                  B = 12;
               }

               if (fo < 0) {
                  ++fo;
               }

               if (fn == 1) {
                  if ((i(ff + fj, fg) & 4) == 4) {
                     ff = I(ff + fj) - fj;
                     y = 0;
                  }
               } else if ((i(ff - fj, fg) & 8) == 8) {
                  ff = I(ff + 24 - fj) + fj;
                  y = 0;
               }

               v();
               if (gO && z >= 4 && a(ff - gQ) < 30 && a(fg - (gR - 25)) < 5) {
                  z = -(z >> 1);
                  y = fn << 3;
                  C = 0;
               }
            }
            break;
         case 5:
            ++C;
            if (fn == 1) {
               if ((i(ff + fj, fg - fk) & 4) == 4) {
                  y = 0;
               }
            } else if ((i(ff - fj, fg - fk) & 8) == 8) {
               y = 0;
            }

            ff += y;
            if ((fg += z) < 0) {
               z = 0;
               fg = 0;
            }

            if (z == 0) {
               if (is == -1 && (i(ff, fg) & 2) != 2) {
                  A = 4;
                  fd = -1;
                  y = (P >> 1) * fn;
                  D = 0;
                  C = 0;
               }

               if (is != -1 && a(ff - it[is]) >= 20) {
                  is = -1;
                  if (g(ff, fg, 2)) {
                     A = 1;
                  } else {
                     A = 4;
                     z = 2;
                     y = 3 * fn;
                     fd = -1;
                     D = 0;
                  }
               }
            } else if (z < 0) {
               if (++z == 0) {
                  z = 1;
               }
            } else {
               if (z < 20 && C % 5 == 0) {
                  ++z;
               }

               if (z > 3) {
                  z = 3;
               }

               if (z > 2 && (i(ff, fg + 3) & 2) == 2) {
                  z = 0;
                  y = 0;
                  fg = I(fg + 3);
                  if (currentQuestIndex == 11 && fD < 20) {
                     fD = 0;
                     c("Hit: " + fD);
                  }
               }

               if (g(ff, fg, 64) && fg % jf > 8) {
                  g(ff, H(fg) + 8);
                  A = 11;
                  y = fn << 1;
                  z >>= 2;
                  fg = H(fg) + 12;
                  fd = -1;
                  if (I == 0 || !eQ) {
                     A = 12;
                  }
                  break;
               }

               if (g(ff, fg, 4096)) {
                  A = 12;
                  fd = -1;
                  break;
               }

               v();
            }

            if (y > 0) {
               --y;
            } else if (y < 0) {
               ++y;
            }

            if (y != 0) {
               x();
            }

            label728:
            switch (fu) {
               case 0:
                  switch (C) {
                     case 1:
                     case 2:
                     case 3:
                        fd = -1;
                        B = 13;
                        break label728;
                     case 4:
                        fd = 0;
                        B = 14;
                        break label728;
                     case 5:
                        fd = 1;
                        B = 15;
                        break label728;
                     case 6:
                        fd = 1;
                        B = 15;
                        u();
                        break label728;
                     case 7:
                        fd = 2;
                        B = 16;
                        break label728;
                     case 8:
                        fd = 2;
                        B = 16;
                        if (fw) {
                           fw = false;
                           fu = 2;
                        } else {
                           fu = 1;
                        }

                        C = 1;
                     default:
                        break label728;
                  }
               case 1:
                  switch (C) {
                     case 1:
                        fd = 1;
                        B = 15;
                        break label728;
                     case 2:
                        fd = 1;
                        B = 15;
                        fu = 10;
                     default:
                        break label728;
                  }
               case 2:
                  switch (C) {
                     case 1:
                     case 2:
                     case 3:
                        fd = 3;
                        B = 17;
                        break label728;
                     case 4:
                        fd = 4;
                        B = 18;
                        break label728;
                     case 5:
                        fd = 5;
                        B = 19;
                        break label728;
                     case 6:
                        fd = 6;
                        B = 20;
                        u();
                        break label728;
                     case 7:
                        fd = 6;
                        B = 20;
                        if (fw && ft < 2) {
                           if (z == 0 && fs) {
                              C = 0;
                              fw = false;
                              fu = 9;
                           } else {
                              fw = false;
                              fu = 3;
                              ++ft;
                           }
                        } else {
                           fu = 10;
                        }

                        C = 1;
                     default:
                        break label728;
                  }
               case 3:
                  switch (C) {
                     case 1:
                        fd = 1;
                        B = 15;
                        break;
                     case 2:
                        fd = 1;
                        B = 15;
                        break;
                     case 3:
                        fd = 2;
                        B = 16;
                        break;
                     case 4:
                        fd = 2;
                        B = 16;
                        if (fw) {
                           fw = false;
                           fu = 2;
                        } else {
                           fu = 1;
                        }

                        C = 1;
                  }
               case 4:
               case 5:
               case 6:
               case 7:
               case 8:
               default:
                  break;
               case 9:
                  switch (C) {
                     case 1:
                     case 2:
                     case 3:
                        fd = -1;
                        B = 13;
                        break label728;
                     case 4:
                        fd = 0;
                        B = 14;
                        break label728;
                     case 5:
                     case 6:
                        fd = 9;
                        B = 15;
                        int var3 = z();
                        fs = false;
                        if (var3 != -1) {
                           fs = true;
                           f(jL[var3], jM[var3] - (jN[var3] >> 1), fn);
                           jQ[var3] = 9;
                           jV[var3] = -8;
                           Q();
                        }
                        break label728;
                     case 7:
                     case 8:
                        fd = 10;
                        B = 16;
                        break label728;
                     case 9:
                        fd = -1;
                        B = 16;
                        if (fs) {
                           A = 3;
                           y = 0;
                           z = -8;
                        } else {
                           C = 0;
                           D = 0;
                           fu = 10;
                        }
                     default:
                        break label728;
                  }
               case 10:
                  switch (C) {
                     case 1:
                        fd = 2;
                        B = 16;
                        break;
                     case 2:
                        fd = 0;
                        B = 14;
                        break;
                     case 3:
                     case 4:
                        B = 13;
                        fd = -1;
                        break;
                     case 5:
                        B = 13;
                        fd = -1;
                        if (z != 0) {
                           A = 4;
                        } else {
                           A = 1;
                        }

                        ft = 0;
                        D = 0;
                  }
            }

            if (fe == 1) {
               fd = -1;
            }

            if (A == 5) {
               if (z != 0) {
                  B += 14;
               } else if (y != 0) {
                  B += 22;
               }
            }
            break;
         case 6:
            ff += y;
            if (y > 1) {
               --y;
            }

            if (y < -1) {
               ++y;
            }

            ++z;
            fg += z;
            B = 21;
            if (fg >= iQ || fg > fQ + r + fi || g(ff, fg - fi, 4096)) {
               ff = fq;
               fg = fr;
               A = 4;
               G = H / 3;
               I = J / 3;
               z = 0;
               y = 0;
               D = 0;
               C = 0;
               N >>= 1;
               c = true;
               if (hd) {
                  hh = hi;
               }

               if (hj) {
                  hn = ho;
               }

               aI();
               s(5);
               d = 7;
            }
            break;
         case 7:
            if ((i(ff + fj, fg - fk) & 4) == 4) {
               y = -y;
            }

            if ((i(ff - fj, fg - fk) & 8) == 8) {
               y = -y;
            }

            ff += y;
            fg += z;
            B = 21;
            if (y > 1) {
               --y;
            }

            if (y < -1) {
               ++y;
            }

            if (++z > 0) {
               z = 0;
            }

            if (++C >= 7) {
               A = 4;
               fo = -20;
               D = 0;
               C = 0;
               z = 0;
            }

            w();
            break;
         case 8:
            B = 22;
            if (C < 5) {
               ++C;
            } else if (!aS[8]) {
               A = 1;
            }

            if (++D > 6 && g(ff + fj, fg + 2, 8192) && g(ff - fj, fg + 2, 8192) && eM & I > 0) {
               A = 13;
            }
         case 9:
         case 10:
         case 22:
         default:
            break;
         case 11:
            U();
            break;
         case 12:
            fg += z;
            if (z < 20 && w % 2 == 0) {
               ++z;
            }

            B = 7;
            if (fg >= iQ) {
               G = 0;
               A = 6;
               fd = -1;
            } else if (g(ff, fg, 2)) {
               fg = H(fg);
               if (g(ff, fg - 2, 64)) {
                  A = 1;
                  z = 0;
                  y = 0;
                  D = 0;
                  C = 0;
               } else if (eP) {
                  A = 17;
                  z = 0;
                  y = 0;
                  D = 0;
                  C = 0;
               } else {
                  A = 6;
               }

               fg = I(fg);
            } else if (g(ff, fg - fi - 5, 4096)) {
               G = 0;
               A = 6;
               fd = -1;
            }
            break;
         case 13:
            B = 24;
            fg += 28;
            A = 14;
            break;
         case 14:
            if (w % 20 > 2) {
               B = 25;
            } else {
               B = 26;
            }

            if (w % 8 == 0) {
               if (--I <= 0) {
                  I = 0;
                  A = 15;
               }

               c = true;
            }
            break;
         case 15:
            fg -= 10;
            z = -10;
            A = 3;
            break;
         case 16:
            if (++C >= 20) {
               C = 0;
            }

            if ((B = (C >> 2) + 2) % 2 == 0) {
               fd = 7;
            } else {
               fd = 8;
            }

            if (fn == 1) {
               if (g(ff + fj, fg - fk, 4)) {
                  y = 0;
                  ff = I(ff + fj) - fj;
               }
            } else if (g(ff - fj - 1, fg - fk, 8)) {
               y = 0;
               ff = I(ff - fj - 1) + jf + fj;
            }

            ff += y;
            if (y > 0) {
               --y;
            } else if (y < 0) {
               ++y;
            } else {
               A = 17;
            }

            if ((i(ff, fg) & 2) != 2) {
               A = 12;
               y = fn << 2;
               D = 0;
            }
            break;
         case 17:
            if (++C > 30) {
               C = 0;
            }

            if (C % 15 < 5) {
               B = 0;
               fd = 7;
            } else {
               B = 1;
               fd = 8;
            }
            break;
         case 18:
            if (w % 8 > 3) {
               B = 43;
            } else {
               B = 44;
               e(fn, ff - (fn << 4), fg - 5);
            }

            C = 0;
            break;
         case 19:
            if (w % 8 > 3) {
               B = 43;
            } else {
               B = 44;
               e(fn, ff - (fn << 4), fg - 5);
            }

            if (C > 0) {
               --C;
               B = 45;
            }

            if (fn == 1) {
               if (g(ff + fj, fg - fk, 4)) {
                  y = 0;
                  ff = I(ff + fj) - fj;
               }
            } else if (g(ff - fj - 1, fg - fk, 8)) {
               y = 0;
               ff = I(ff - fj - 1) + jf + fj;
            }

            if ((i(ff, fg - 1) & 64) == 64) {
               ff += y >> 1;
            } else {
               ff += y;
            }

            il[ik] = ff;
            im[ik] = fg;
            if (y > 0) {
               --y;
            } else if (y < 0) {
               ++y;
            } else {
               A = 18;
               fp = 0;
            }

            if (is != -1) {
               if (a(ff - it[is]) >= 20) {
                  is = -1;
                  if (g(ff, fg, 2)) {
                     A = 18;
                  } else {
                     A = 20;
                     z = 2;
                     y = 3 * fn;
                     D = 0;
                  }
               }
            } else if ((i(ff, fg) & 2) != 2) {
               A = 20;
               y = 3 * fn;
               D = 0;
            }

            e(fn, ff - (fn << 3), fg);
            S();
            int var0;
            if ((var0 = z()) != -1 && (jQ[var0] == 2 || jQ[var0] == 3)) {
               k(var0, 2, -fn);
               f(jL[var0], jM[var0] - (jN[var0] >> 1), fn);
               a("-2", 0, jL[var0], jM[var0] - jN[var0], 0, -2);
            }
            break;
         case 20:
            try {
               if (fn == 1) {
                  if ((i(ff + fj, fg - fk) & 4) == 4) {
                     y = 0;
                  }
               } else if ((i(ff - fj, fg - fk) & 8) == 8) {
                  y = 0;
               }

               fd = -1;
               ff += y;
               fg += z;
               if (z < 20) {
                  ++z;
               }

               if (y > 0) {
                  --y;
               }

               if (w % 8 > 3) {
                  B = 43;
               } else {
                  B = 44;
                  e(fn, ff - (fn << 4), fg - 5);
               }

               if (z > 4 && (i(ff, fg) & 2) == 2) {
                  if (z < 8) {
                     A = 18;
                     z = 0;
                     y = 0;
                     D = 0;
                     C = 0;
                     fg = I(fg);
                  } else {
                     A = 21;
                     z = -(z / 3);
                     fg = I(fg);
                  }
               }

               if (g(ff, fg, 64) && fg % jf > 8) {
                  g(ff, H(fg) + 8);
               }

               il[ik] = ff;
               im[ik] = fg;
               if (g(ff, fg, 4096)) {
                  ip[ik] = 1;
                  ik = -1;
                  A = 12;
               }
            } catch (Exception var2) {
            }

            if (fo < 0) {
               ++fo;
            }
            break;
         case 21:
            if (fn == 1) {
               if ((i(ff + fj, fg - fk) & 4) == 4) {
                  y = 0;
               }
            } else if ((i(ff - fj, fg - fk) & 8) == 8) {
               y = 0;
            }

            ff += y;
            fg += z;
            il[ik] = ff;
            im[ik] = fg;
            if (y > 0) {
               --y;
            }

            if (++z == 0) {
               A = 20;
               C = 0;
               D = khinhCong ? 1 : 0;
               z = 1;
               c = true;
            }

            if (fo < 0) {
               ++fo;
            }

            if (w % 8 > 3) {
               B = 43;
            } else {
               B = 44;
               e(fn, ff - (fn << 4), fg - 5);
            }

            if (C > 0) {
               --C;
               B = 45;
            }
            break;
         case 25:
            DashSkill.getInstance().tick(GameSkillContext.INSTANCE);
            break;
         case 23:
            T();
      }

      if (w % 3 == 0) {
         if (fx) {
            if (--I <= 0) {
               I = 0;
               fx = false;
            }

            c = true;
         }

         if (fy) {
            if (--I <= 0) {
               I = 0;
               fy = false;

               for(int var1 = 0; var1 < 4; ++var1) {
                  Image var7 = ep[var1];
                  ep[var1] = eq[var1];
                  eq[var1] = var7;
               }
            }

            c = true;
         }
      }

   }

   private static final void S() {
      if (!a) {
         if (g(ff, fg + 1, 2048)) {
            h(ff, fg + 1, 1024);
            h(ff, fg - 2, 1024);
         }

         if (g(ff - jf, fg + 1, 1024)) {
            j(ff - jf, fg + 1, 1024);
            j(ff - jf, fg - 2, 1024);
         }

         if (g(ff + jf, fg + 1, 1024)) {
            j(ff + jf, fg + 1, 1024);
            j(ff + jf, fg - 2, 1024);
         }

      }
   }

   private static void T() {
      if (++C == 1) {
         f(ff, fg - 40);
         aK = 0;
         if (eq == null) {
            eq = new Image[4];

            try {
               eq[0] = Image.createImage("/cp/ch0x.png");
               eq[1] = Image.createImage("/cp/ch1x.png");
            } catch (Exception var2) {
            }

            eq[2] = eq[1];
            eq[3] = eq[0];
         }
      } else if (C >= 30) {
         A = 1;
         C = 0;
         if (I == 0) {
            return;
         }

         for(int var1 = 0; var1 < 4; ++var1) {
            Image var0 = ep[var1];
            ep[var1] = eq[var1];
            eq[var1] = var0;
         }

         fy = !fy;
      } else if (C <= 10) {
         if (C % 5 == 0) {
            for(int var6 = 0; var6 < 4; ++var6) {
               Image var3 = ep[var6];
               ep[var6] = eq[var6];
               eq[var6] = var3;
            }
         }
      } else if (C < 20) {
         if (C % 3 == 0) {
            for(int var7 = 0; var7 < 4; ++var7) {
               Image var4 = ep[var7];
               ep[var7] = eq[var7];
               eq[var7] = var4;
            }
         }
      } else if (C < 30 && C % 2 == 0) {
         for(int var8 = 0; var8 < 4; ++var8) {
            Image var5 = ep[var8];
            ep[var8] = eq[var8];
            eq[var8] = var5;
         }
      }

      if (C % 2 > 0) {
         B = 0;
      } else {
         B = 1;
      }
   }

   private static void U() {
      if (++C >= 5) {
         C = 0;
         fp = 0;
      }

      B = C + 2;
      if (fn == 1) {
         if (g(ff + fj, fg - 1, 4)) {
            y = 0;
            ff = I(ff + fj) - fj;
         }
      } else if (g(ff - fj - 1, fg - 1, 8)) {
         y = 0;
         ff = I(ff - fj - 1) + jf + fj;
      }

      ff += y;
      if (y > 0) {
         --y;
      } else if (y < 0) {
         ++y;
      } else if (!eZ) {
         A = 12;
         fp = 0;
      } else {
         A = 3;
         z = -8;
         D = 0;
         C = 0;
      }

      if (w % 8 == 0) {
         if ((I -= 3) <= 0) {
            I = 0;
            y = 0;
            A = 12;
         }

         c = true;
      }

      for(int var0 = 0; var0 < ir; ++var0) {
         if (a(ff - it[var0]) < 20 && iu[var0] > fg && iu[var0] - 24 < fg) {
            y = 0;
            if (ff < it[var0]) {
               ff = it[var0] - 20;
            } else {
               ff = it[var0] + 20;
            }

            A = 12;
            break;
         }
      }

      g(ff, fg);
      e(fn, ff - (fn << 3), fg);
   }

   private static boolean V() {
      if (!fT) {
         if (bv > 1) {
            bv >>= 1;
            c = true;
         }

         return false;
      } else {
         if (gb) {
            if (aT[5]) {
               d();
               K();
               if (iD == iC) {
                  iA = false;
                  gb = false;
                  y();
               }
            }
         } else {
            if (bv < bu) {
               bv += (bu - bv >> 1) + 1;
            }

            if (fW) {
               if (fY < fZ) {
                  fY += 2;
               } else {
                  fY = fZ;
               }
            }

            if (++ga >= az[fU][fV]) {
               ga = az[fU][fV];
               switch (ax[fU][fV]) {
                  case 1:
                     F(ay[fU][fV]);
                     ++fV;
                     break;
                  case 2:
                     G(ay[fU][fV]);
                     ++fV;
                     break;
                  case 3:
                     fT = false;
                     c = true;
                     ++fV;
                     break;
                  case 4:
                     if (A == 1) {
                        fW = false;
                        int var3 = 0;
                        int var1 = 0;
                        switch (aC[ay[fU][fV]]) {
                           case 0:
                              var3 = ff;
                              var1 = fg;
                              break;
                           case 1:
                              var3 = lw[aB[ay[fU][fV]]];
                              var1 = lx[aB[ay[fU][fV]]];
                              break;
                           case 2:
                              var3 = dA[aB[ay[fU][fV]]];
                              var1 = dB[aB[ay[fU][fV]]];
                              break;
                           case 3:
                           case 4:
                              var3 = go;
                              var1 = gp;
                        }

                        var1 -= 40;
                        a(aE[ay[fU][fV]], -1, var3, var1);
                        ++fV;
                        gb = true;
                     }
                     break;
                  case 5:
                     a(v, ay[fU][fV], fg - 50, -1);
                     ++fV;
                     break;
                  case 6:
                     gc = -1;
                     ++fV;
                     break;
                  case 7:
                     fv = true;
                     ++fV;
                     break;
                  case 8:
                     fv = false;
                     ++fV;
                     break;
                  case 9:
                     fP = aA[ay[fU][fV]][0] - bD;
                     fQ = aA[ay[fU][fV]][1] - bE;
                     if (fP < 0) {
                        fP = 0;
                     }

                     if (fP > fR) {
                        fP = fR;
                     }

                     if (fQ < 0) {
                        fQ = 0;
                     }

                     if (fQ > fS) {
                        fQ = fS;
                     }

                     fJ = fP;
                     fK = fQ;
                     ++fV;
                     break;
                  case 10:
                     fJ = aA[ay[fU][fV]][0] - bD;
                     fK = aA[ay[fU][fV]][1] - bE;
                     if (fJ < 0) {
                        fJ = 0;
                     }

                     if (fJ > fR) {
                        fJ = fR;
                     }

                     if (fK < 0) {
                        fK = 0;
                     }

                     if (fK > fS) {
                        fK = fS;
                     }

                     ++fV;
                     break;
                  case 11:
                     fJ = gQ - bD;
                     fK = gR - bE;
                     if (fJ < 0) {
                        fJ = 0;
                     }

                     if (fJ > fR) {
                        fJ = fR;
                     }

                     if (fK < 0) {
                        fK = 0;
                     }

                     if (fK > fS) {
                        fK = fS;
                     }

                     ++fV;
                     break;
                  case 12:
                     fK = fQ += 2;
                     if (fQ > aA[ay[fU][fV]][1] - bE) {
                        ++fV;
                     }
                  case 13:
                  default:
                     break;
                  case 14:
                     fJ = fP -= 2;
                     if (fP < aA[ay[fU][fV]][0] - bD) {
                        ++fV;
                     }
                     break;
                  case 15:
                     fW = true;
                     fX = Midlet.a(aF[ay[fU][fV]], q - 40);
                     if ((fZ = (bu >> 1) - (fX.length << 3)) < 3) {
                        fZ = 2;
                     }

                     fY = -fX.length << 3;
                     ++fV;
                     break;
                  case 16:
                     dy = true;
                     dz = ay[fU][fV];
                     ++fV;
                     break;
                  case 17:
                     fq = ff = jv;
                     fr = fg = jw;
                     A();
                     Midlet.f = true;
                     x(ay[fU][fV]);
                     return true;
                  case 18:
                     V(ay[fU][fV]);
                     ++fV;
                     break;
                  case 19:
                     gl = true;
                     ++fV;
                     break;
                  case 20:
                     gl = false;
                     gn = 0;
                     go = 1080;
                     gp = 408;
                     ++fV;
                     break;
                  case 21:
                     currentQuestIndex = -1;
                     eN = true;
                     c("nhận bằng lái môtô");
                     a(0, lw[4], lx[4] - 40, 4);
                     ++fV;
                     break;
                  case 22:
                     for(int var2 = 0; var2 <= 6; ++var2) {
                        i(24, var2, 0);
                     }

                     eG = true;
                     ++fV;
                     break;
                  case 23:
                     fv = false;
                     fJ = dA[ay[fU][fV]] - bD;
                     fK = dB[ay[fU][fV]] - bE;
                     if (fJ < 0) {
                        fJ = 0;
                     }

                     if (fJ > fR) {
                        fJ = fR;
                     }

                     if (fK < 0) {
                        fK = 0;
                     }

                     if (fK > fS) {
                        fK = fS;
                     }

                     ++fV;
                     break;
                  case 24:
                     dy = true;
                     dz = ay[fU][fV];
                     ++fV;
                     break;
                  case 25:
                     hf = true;
                     ++fV;
                     break;
                  case 26:
                     for(int var0 = 0; var0 <= 10; ++var0) {
                        i(24, var0, 0);
                     }

                     eH = true;
                     ++fV;
                     break;
                  case 27:
                     fv = false;
                     fJ = hq - bD;
                     fK = hr - bE;
                     if (fJ < 0) {
                        fJ = 0;
                     }

                     if (fJ > fR) {
                        fJ = fR;
                     }

                     if (fK < 0) {
                        fK = 0;
                     }

                     if (fK > fS) {
                        fK = fS;
                     }

                     ++fV;
                     break;
                  case 28:
                     hs = 1;
                     ++fV;
                     break;
                  case 29:
                     d();
                     c();
                     iU = null;
                     iV = null;
                     iW = null;
                     iX = null;
                     iR = null;
                     iS = null;
                     System.gc();
                     lu = null;
                     System.gc();
                     ec = null;
                     ef = null;
                     eh = null;
                     ew = null;
                     System.gc();
                     ey = null;
                     System.gc();
                     jH = null;
                     System.gc();
                     B();
                     et = null;
                     ej = null;
                     dZ = null;
                     ek = null;
                     el = null;
                     es = null;
                     ez = null;
                     eE = null;
                     ea = null;
                     System.gc();
                     er = null;
                     ee = null;
                     ep = null;
                     eq = null;
                     eC = null;
                     System.gc();
                     I();
                     return true;
                  case 30:
                     currentQuestIndex = -1;
                     eU = false;
                     eV = true;
                     gn = 0;
                     go = 648;
                     gp = 288;
                     gl = false;
                     c("gặp cô Ayumi");
                     a(0, 1032, 368, 4);
                     ++fV;
                     break;
                  case 31:
                     fv = false;
                     fJ = go - bD;
                     fK = gp - bE;
                     if (fJ < 0) {
                        fJ = 0;
                     }

                     if (fJ > fR) {
                        fJ = fR;
                     }

                     if (fK < 0) {
                        fK = 0;
                     }

                     if (fK > fS) {
                        fK = fS;
                     }

                     ++fV;
                     break;
                  case 32:
                     gl = true;
                     gs = 2;
                     gq = -5;
                     gA = -1;
                     gL = 8;
                     ++fV;
                     break;
                  case 33:
                     fc = true;
                     gl = true;
                     ++fV;
               }
            }
         }

         aS[5] = false;
         aT[5] = false;
         return false;
      }
   }

   private static void W() {
      for(int var0 = 0; var0 < df; ++var0) {
         if (di[var0] != 0) {
            if (a(fg - (fi >> 1) - (dh[var0] - 7)) < 10 && a(ff - dg[var0]) < 10) {
               de += dm[var0];
               c = true;
               di[var0] = 301;
               a("+" + dm[var0], 1, dg[var0], dh[var0] - 15, 0, -1);
            }

            int[] var10000 = dg;
            var10000[var0] += dj[var0];
            var10000 = dh;
            var10000[var0] += dk[var0];
            if (dj[var0] > 1) {
               int var10002 = dj[var0]--;
            }

            if (dj[var0] < -1) {
               int var2 = dj[var0]++;
            }

            if (dk[var0] < 20) {
               int var3 = dk[var0]++;
            }

            int var4 = di[var0]++;
            if (di[var0] > 200) {
               di[var0] = 0;
            }

            if (di[var0] % 20 > 18) {
               dl[var0] = 0;
            } else if (di[var0] % 20 > 16) {
               dl[var0] = 1;
            } else {
               dl[var0] = 2;
            }

            if (dh[var0] >= 0 && dh[var0] < iQ && dg[var0] < iP && dg[var0] >= 0) {
               if (dk[var0] > 2 && (i(dg[var0], dh[var0]) & 2) == 2) {
                  dh[var0] = H(dh[var0]);
                  if (dk[var0] > 2) {
                     dk[var0] = -(dk[var0] >> 1);
                  } else {
                     dj[var0] = 0;
                     dk[var0] = 0;
                  }
               }
            } else {
               di[var0] = 0;
            }
         }
      }

   }

   private static void X() {
      if (iA && iJ < iF[iD].length && ++iI >= iF[iD][iJ].length()) {
         iI = 0;
         ++iJ;
      }

   }

   private static void Y() {
      if (w % 2 == 0 && ((dp += dr) > dt || dp < ds)) {
         dr = -dr;
         dp += dr;
      }

   }

   private static void Z() {
      for(int var0 = 0; var0 < cW; ++var0) {
         if (cZ[var0] != 1) {
            if (cZ[var0] > 1) {
               int var12 = cZ[var0]++;
               if (cZ[var0] >= 10) {
                  cZ[var0] = 1;
                  dc[var0] = 12;
                  db[var0] = 0;
               }
            }
         } else {
            int[] var10000 = cX;
            var10000[var0] += db[var0];
            var10000 = cY;
            var10000[var0] += dc[var0];
            if (cX[var0] >= fP && cX[var0] <= fP + q && cY[var0] >= fQ && cY[var0] <= fQ + r) {
               if (db[var0] > 0 && (i(cX[var0], cY[var0]) & 4) == 4) {
                  cZ[var0] = 2;
                  cX[var0] = I(cX[var0]);
               } else if (db[var0] < 0 && (i(cX[var0], cY[var0]) & 8) == 8) {
                  cZ[var0] = 2;
                  cX[var0] = I(cX[var0]) + jf;
               }

               int var10002 = da[var0]++;
               if (da[var0] > 1) {
                  da[var0] = 0;
               }

               if (db[var0] != 0) {
                  for(int var1 = 0; var1 < jI; ++var1) {
                     if (jQ[var1] != 5 && jQ[var1] != 1 && a(jL[var1] - cX[var0]) < jO[var1] && a(jM[var1] - (jN[var1] >> 1) - cY[var0]) < jN[var1]) {
                        int var2;
                        boolean var9;
                        label205: {
                           var2 = dd[var0] ? F << 1 : F;
                           if (jQ[var1] == 2 || jQ[var1] == 3 || jQ[var1] == 4) {
                              if (jK[var1] == 9 && db[var0] * jZ[var1] < 0) {
                                 jQ[var1] = 4;
                                 jV[var1] = 4;
                                 db[var0] = -db[var0];
                                 dc[var0] = -dc[var0];
                                 var10000 = cX;
                                 var10000[var0] += db[var0];
                                 var10000 = cY;
                                 var10000[var0] += dc[var0];
                                 var9 = true;
                                 break label205;
                              }

                              var10000 = ka;
                              var10000[var1] -= var2;
                              if (ka[var1] <= 0) {
                                 ka[var1] = 0;
                                 jV[var1] = -5;
                                 jW[var1] = db[var0];
                                 jX[var1] = 0;
                                 jP[var1] = 0;
                                 jQ[var1] = 1;
                                 L(var1);
                                 var9 = true;
                                 break label205;
                              }

                              jV[var1] = 0;
                              jZ[var1] = db[var0] < 0 ? 1 : -1;
                              jQ[var1] = 6;
                              jY[var1] = 3;
                              cZ[var0] = -1;
                           }

                           var9 = false;
                        }

                        if (!var9) {
                           f(jL[var1], jM[var1] - (jN[var1] >> 1), jZ[var1]);
                           a("-" + var2, 0, jL[var1], jM[var1] - jN[var1], 0, -2);
                        }
                        break;
                     }
                  }

                  for(int var6 = 0; var6 < cq; ++var6) {
                     if (cF[var6] != 5 && cF[var6] != 1 && a(cv[var6] - cX[var0]) < 20 && a(cw[var6] - 15 - cY[var0]) < 20) {
                        if (dd[var0]) {
                           a(var6, F << 1, cI[var0]);
                           f(cv[var6], cw[var6] - 15, cI[var6]);
                           a("-" + (F << 1), 0, cv[var6], cw[var6] - 32, 0, -2);
                           cZ[var0] = -1;
                        } else {
                           cF[var6] = 4;
                           cG[var6] = 0;
                           cH[var6] = 0;
                           cI[var6] = db[var0] > 0 ? -1 : 1;
                           db[var0] = -db[var0];
                        }
                        break;
                     }
                  }

                  if (!dd[var0] && a(ff - cX[var0]) < fj && a(fg - fk - cY[var0]) < fk) {
                     if (A == 5 && fe == 0) {
                        db[var0] = -db[var0];
                        dc[var0] = -3;
                        return;
                     }

                     a(F, -fn);
                     cZ[var0] = -1;
                     return;
                  }

                  if (gO && a(gQ - cX[var0]) < gW >> 1 && a(gR - (gX >> 1) - cY[var0]) < gX >> 1) {
                     c(F, -gU);
                     f(cX[var0], cY[var0], gU);
                     a("-" + F, 0, gQ, gR - gX, 0, -2);
                     cZ[var0] = -1;
                  }

                  if (hK && a(hQ - cX[var0]) < hP >> 1 && a(hR - (hM >> 1) - cY[var0]) < hM >> 1) {
                     db[var0] = -db[var0];
                     dc[var0] = -1;
                  }

                  if (hd && a(dA[0] - cX[var0]) < 12 && a(dB[0] - 16 - cY[var0]) < 32) {
                     if (dE[0] == 5 && db[var0] * dK[0] < 0) {
                        db[var0] = -db[var0];
                     } else if (dE[0] == 1 && db[var0] * dK[0] < 0) {
                        db[var0] = -db[var0];
                        dF[0] = dG[0] = 0;
                        dE[0] = 5;
                     } else {
                        d(F, -dK[0]);
                        cZ[var0] = -1;
                     }
                  }
               }
            } else {
               cZ[var0] = -1;
            }
         }
      }

   }

   private static void aa() {
      if (aN) {
         aN = false;
         c();
         if (fT) {
            aT[5] = true;
         } else if (aO > aU - 40 && aP < 40) {
            aT[5] = true;
         } else if (aP > aV - 30) {
            if (aO < aW) {
               aT[12] = true;
            } else {
               aT[13] = true;
            }
         } else if (aP <= fg - fQ + 24 && aP >= fg - fQ - 80 && aO <= ff - fP + 48 && aO >= ff - fP - 48) {
            fn = ff - fP < aO ? 1 : -1;
            aT[5] = true;
         } else if (d == 1 && !fT && aP <= fg - fQ + 24 && aP >= fg - fQ - 80) {
            if (aO < ff - fP - 20) {
               DashSkill.getInstance().onDirectionKey(4);
            } else if (aO > ff - fP + 20) {
               DashSkill.getInstance().onDirectionKey(6);
            }
         }
      }

      if (aQ && !fT && (aO <= aU - 40 || aP >= 40) && aP <= aV - 30) {
         if (aP > fg - fQ + 24) {
            aS[8] = true;
         } else if (aP < fg - fQ - 80) {
            aS[2] = true;
         } else if (aO > ff - fP + 48) {
            aS[6] = true;
         } else if (aO < ff - fP - 48) {
            aS[4] = true;
         }
      }

      if (++w == 10000) {
         w = 0;
      }

      if (ff < 0) {
         if (jp != -1) {
            A();
            fq = ff = jt - 1;
            fr = fg = ju;
            Midlet.f = true;
            x(jp);
            return;
         }
      } else if (ff >= iP - 24) {
         if (jq != -1) {
            if (!fa && jq == 95) {
               s(6);
               a("Khu vực phía trước rất nguy hiểm! Chỉ những người có thể ẩn thân có thể vào!");
               ff = iP - 60;
               A = 4;
               d = 7;
               return;
            }

            A();
            if (jr != -1 && fg > jB) {
               fq = ff = jx;
               fr = fg = jy;
               Midlet.f = true;
               x(jr);
               return;
            }

            fq = ff = jv;
            fr = fg = jw;
            Midlet.f = true;
            x(jq);
            return;
         }
      } else if (fg + z >= iQ && A != 6 && js != -1) {
         A();
         fq = ff = jz;
         fr = fg = jA;
         Midlet.f = true;
         x(js);
         A = 4;
         return;
      }

      aq();
      X();
      if (!V()) {
         if (!a) {
            for(int var0 = 0; var0 < 2; ++var0) {
               if (w % (var0 + 2 << 3) == 0) {
                  int var10002 = e[var0]++;
                  if (e[var0] > q + (t.getWidth() >> 1)) {
                     e[var0] = -(t.getWidth() >> 1);
                  }
               }
            }
         }

         if (iA) {
            if (aT[5]) {
               d();
               K();
               if (iD == iC) {
                  iA = false;
                  y();
               }
            }

            c = true;
         } else {
            label1126: {
               if (aT[12]) {
                  aD();
                  d = 5;
                  c();
                  d();
               } else if (aT[0]) {
                  if (fe == 0) {
                     if (eL) {
                        fe = 1;
                     }
                  } else {
                     fe = 0;
                  }

                  c = true;
                  aT[0] = false;
               } else if (aT[6]) {
                  fp = 2;
                  aT[6] = false;
               } else if (aT[4]) {
                  fp = -2;
                  aT[4] = false;
               } else {
                  if (aT[9]) {
                     aT[9] = false;
                     if (AmbushSkill.getInstance().tryActivate(GameSkillContext.INSTANCE)) {
                        break label1126;
                     }
                     if (fa) {
                        fx = !fx;
                     }

                     break label1126;
                  }

                  if (aT[7]) {
                     if (A == 1 && eR) {
                        A = 23;
                        C = 0;
                     }

                     aT[7] = false;
                  } else if (aT[10]) {
                     aT[10] = false;
                     if (G < H) {
                        for(int var4 = 0; var4 < 3; ++var4) {
                           if (V[var4] > 0) {
                              int var26 = V[var4]--;
                              if ((G += kH[var4]) > H) {
                                 G = H;
                              }

                              c = true;
                              break;
                           }
                        }
                     }
                  } else if (aT[11]) {
                     aT[11] = false;
                     if (I < J) {
                        for(int var5 = 3; var5 < 6; ++var5) {
                           if (V[var5] > 0) {
                              int var27 = V[var5]--;
                              if ((I += kH[var5]) > J) {
                                 I = J;
                              }

                              c = true;
                              break;
                           }
                        }
                     }
                  }
               }

               if (A == 1) {
                  if (aT[13]) {
                     d();
                     if (o.equals("Giao tiếp")) {
                        int var6 = fE;
                        switch (ly[var6]) {
                           case 0:
                              if (fc) {
                                 a(lD[7], -1, lw[var6], lx[var6] - 40);
                              } else if (!khinhCong) {
                                 V(2);
                                 a(lA[0], -1, lw[var6], lx[var6] - 40);
                              } else {
                                 if (fa && !fb) {
                                    if (currentQuestIndex == 16) {
                                       if (eI) {
                                          a(lB[14], 35, lw[var6], lx[var6] - 40);
                                       } else {
                                          a(lC[14], -1, lw[var6], lx[var6] - 40);
                                       }
                                    } else if (currentQuestIndex == -1) {
                                       a(lA[22], 36, lw[var6], lx[var6] - 40);
                                    } else {
                                       a(lE, 1, lw[var6], lx[var6] - 40);
                                    }
                                    break;
                                 }

                                 a(lD[1], -1, lw[var6], lx[var6] - 40);
                              }
                              break;
                           case 1:
                              if (fc) {
                                 a(lD[5], -1, lw[var6], lx[var6] - 40);
                              } else if (!khinhCong) {
                                 if (currentQuestIndex == 0) {
                                    if (fD < questRequiredAmounts[0]) {
                                       a(lC[0], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       boolean var2 = true;
                                       var2 = true;
                                       var2 = true;
                                       var2 = false;
                                       lI = 0;
                                       lL = 4;
                                       lJ = 1044;
                                       lK = 240;
                                       a(lB[0], 4, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (currentQuestIndex == -1) {
                                    a(lA[1], 3, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else if (!eS && eR) {
                                 if (characterLevel < 10) {
                                    a(new String[]{"Hãy quay lại gặp ta khi con đạt cấp độ 10"}, -1, lw[var6], lx[var6] - 40);
                                 } else if (currentQuestIndex == 7) {
                                    if (fD < questRequiredAmounts[7]) {
                                       a(lC[6], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       V(2);
                                       a(lB[6], 19, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (currentQuestIndex == -1) {
                                    a(lA[14], 18, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else if (eV && !khinhCongCap2) {
                                 if (characterLevel < 12) {
                                    a(new String[]{"Hãy quay lại gặp ta khi con đạt cấp độ 12"}, -1, lw[var6], lx[var6] - 40);
                                 } else if (currentQuestIndex == 11) {
                                    if (fD < 20) {
                                       a(lC[9], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       V(4);
                                       a(lB[9], 27, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (currentQuestIndex == -1) {
                                    a(lA[17], 28, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else {
                                 if (!eY && eX) {
                                    if (characterLevel < 15) {
                                       a(new String[]{"Hãy quay lại gặp ta khi con đạt cấp độ 15"}, -1, lw[var6], lx[var6] - 40);
                                    } else if (currentQuestIndex == 13) {
                                       if (fD < questRequiredAmounts[13]) {
                                          a(lC[11], -1, lw[var6], lx[var6] - 40);
                                       } else {
                                          V(3);
                                          a(lB[11], 31, lw[var6], lx[var6] - 40);
                                       }
                                    } else if (currentQuestIndex == -1) {
                                       a(lA[19], 32, lw[var6], lx[var6] - 40);
                                    } else {
                                       a(lE, 1, lw[var6], lx[var6] - 40);
                                    }
                                    break;
                                 }

                                 a(lD[0], -1, lw[var6], lx[var6] - 40);
                              }
                              break;
                           case 2:
                              if (fc) {
                                 a(lD[9], -1, lw[var6], lx[var6] - 40);
                              } else if (!khinhCong) {
                                 V(1);
                                 a(lA[2], -1, lw[var6], lx[var6] - 40);
                              } else if (eM && !eN) {
                                 if (currentQuestIndex == 3) {
                                    a(lA[9], -1, lw[var6], lx[var6] - 40);
                                 } else if (currentQuestIndex == -1) {
                                    a(lA[10], 11, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else if (eS && !eT) {
                                 if (currentQuestIndex == 8) {
                                    if (eH) {
                                       V(2);
                                       a(lB[7], 23, lw[var6], lx[var6] - 40);
                                    } else {
                                       a(lC[7], -1, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (currentQuestIndex == -1) {
                                    a(lA[15], 22, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else {
                                 if (eT && !eU) {
                                    if (currentQuestIndex == 9) {
                                       if (fD < questRequiredAmounts[9]) {
                                          a(lC[8], -1, lw[var6], lx[var6] - 40);
                                       } else {
                                          V(3);
                                          a(lB[8], 25, lw[var6], lx[var6] - 40);
                                       }
                                    } else if (currentQuestIndex == -1) {
                                       a(lA[16], 24, lw[var6], lx[var6] - 40);
                                    } else {
                                       a(lE, 1, lw[var6], lx[var6] - 40);
                                    }
                                    break;
                                 }

                                 a(lD[3], -1, lw[var6], lx[var6] - 40);
                              }
                              break;
                           case 3:
                              if (fc) {
                                 a(lD[9], -1, lw[var6], lx[var6] - 40);
                              } else {
                                 if (khinhCong && eL) {
                                    if (!eM) {
                                       if (currentQuestIndex == 2) {
                                          if (!fB) {
                                             a(lC[2], -1, lw[var6], lx[var6] - 40);
                                          } else {
                                             V(2);
                                             a(lB[2], 10, lw[var6], lx[var6] - 40);
                                          }
                                       } else if (currentQuestIndex == -1) {
                                          a(lA[8], 9, lw[var6], lx[var6] - 40);
                                       } else {
                                          a(lE, 1, lw[var6], lx[var6] - 40);
                                       }
                                       break;
                                    }

                                    if (!eP && eO) {
                                       if (currentQuestIndex == 5) {
                                          if (!fB) {
                                             a(lC[4], -1, lw[var6], lx[var6] - 40);
                                          } else {
                                             V(4);
                                             a(lB[4], 15, lw[var6], lx[var6] - 40);
                                          }
                                       } else if (currentQuestIndex == -1) {
                                          a(lA[12], 14, lw[var6], lx[var6] - 40);
                                       } else {
                                          a(lE, 1, lw[var6], lx[var6] - 40);
                                       }
                                       break;
                                    }

                                    if (!eZ && eY) {
                                       if (characterLevel < 16) {
                                          a(new String[]{"Hãy quay lại gặp ta khi con đạt cấp độ 16"}, -1, lw[var6], lx[var6] - 40);
                                       } else if (currentQuestIndex == 14) {
                                          if (fD < questRequiredAmounts[14]) {
                                             a(lC[12], -1, lw[var6], lx[var6] - 40);
                                          } else {
                                             V(3);
                                             a(lB[12], 33, lw[var6], lx[var6] - 40);
                                          }
                                       } else if (currentQuestIndex == -1) {
                                          a(lA[20], 34, lw[var6], lx[var6] - 40);
                                       } else {
                                          a(lE, 1, lw[var6], lx[var6] - 40);
                                       }
                                       break;
                                    }

                                    if (!fa && eZ) {
                                       if (currentQuestIndex == 15) {
                                          if (!fB) {
                                             a(lC[13], -1, lw[var6], lx[var6] - 40);
                                          } else {
                                             V(0);
                                             a(lB[13], 21, lw[var6], lx[var6] - 40);
                                          }
                                       } else if (currentQuestIndex == -1) {
                                          a(lA[21], 20, lw[var6], lx[var6] - 40);
                                       } else {
                                          a(lE, 1, lw[var6], lx[var6] - 40);
                                       }
                                       break;
                                    }

                                    a(lD[4], -1, lw[var6], lx[var6] - 40);
                                    break;
                                 }

                                 a(lA[5], -1, lw[var6], lx[var6] - 40);
                              }
                              break;
                           case 4:
                              if (fc) {
                                 a(lD[8], -1, lw[var6], lx[var6] - 40);
                              } else if (v == 99) {
                                 a(lA[7], -1, lw[var6], lx[var6] - 40);
                              } else if (!khinhCong) {
                                 a(lA[4], -1, lw[var6], lx[var6] - 40);
                              } else if (!eL) {
                                 if (currentQuestIndex == 1) {
                                    if (fD < questRequiredAmounts[1]) {
                                       a(lC[3], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       V(3);
                                       a(lB[1], 6, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (currentQuestIndex == -1) {
                                    a(lA[6], 5, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else if (eN && !eO) {
                                 if (currentQuestIndex == 4) {
                                    if (fD < questRequiredAmounts[4]) {
                                       a(lC[3], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       V(3);
                                       a(lB[3], 12, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (currentQuestIndex == -1) {
                                    a(lA[11], 13, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else if (eP && !eR) {
                                 if (characterLevel < 8) {
                                    a(new String[]{"Hãy quay lại gặp ta khi con đạt cấp độ 8"}, -1, lw[var6], lx[var6] - 40);
                                 } else if (currentQuestIndex == 6) {
                                    if (!fB) {
                                       a(lC[5], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       V(1);
                                       a(lB[5], 17, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (currentQuestIndex == -1) {
                                    a(lA[13], 16, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else {
                                 if (!eX && khinhCongCap2) {
                                    if (currentQuestIndex == 12) {
                                       if (fD < questRequiredAmounts[12]) {
                                          a(lC[10], -1, lw[var6], lx[var6] - 40);
                                       } else {
                                          V(1);
                                          a(lB[10], 29, lw[var6], lx[var6] - 40);
                                       }
                                    } else if (currentQuestIndex == -1) {
                                       a(lA[18], 30, lw[var6], lx[var6] - 40);
                                    } else {
                                       a(lE, 1, lw[var6], lx[var6] - 40);
                                    }
                                    break;
                                 }

                                 a(lD[2], -1, lw[var6], lx[var6] - 40);
                              }
                              break;
                           case 5:
                              if (v == 0) {
                                 if (var6 == 5) {
                                    a(lz[0], -1, lw[var6], lx[var6] - 40);
                                 }

                                 if (var6 == 6) {
                                    aA();
                                    d = 9;
                                    kt = 0;
                                 }
                              }

                              if (v == 2 && var6 == 0) {
                                 aA();
                                 d = 9;
                                 kt = 1;
                              }

                              if (v == 1 && var6 == 0) {
                                 a(lz[1], -1, lw[var6], lx[var6] - 40);
                              }

                              if (v == 5 && var6 == 0) {
                                 a(lz[2], -1, lw[var6], lx[var6] - 40);
                              }

                              if (v == 6 && var6 == 0) {
                                 a(lz[3], -1, lw[var6], lx[var6] - 40);
                              }
                        }

                        if (v == gc && var6 == gk) {
                           gc = -1;
                        }
                     } else if (o.equals("Trò chuyện")) {
                        d();
                        dK[fF] = -fn;
                        a(dw[fF], 0, dA[fF], dB[fF] - 44);
                     } else if (o.equals("Nói chuyện") && fC) {
                        if (gl) {
                           a(aG[0], 0, go, gp - 44);
                        } else if (eV) {
                           a(aG[2], 0, go, gp - 44);
                           gl = true;
                        } else if (eU) {
                           a(aG[3], 26, go, gp - 44);
                           eU = false;
                        } else {
                           a(aG[1], 0, go, gp - 44);
                        }
                     }
                  } else {
                     label1097: {
                        if (aS[2]) {
                           if (eN) {
                              for(int var7 = 0; var7 < ij; ++var7) {
                                 if (fg == im[var7] && a(ff - il[var7]) < 20) {
                                    ff = il[var7];
                                    A = 18;
                                    c();
                                    ik = var7;
                                    in[var7] = fn;
                                    io[var7] = 0;
                                    break label1097;
                                 }
                              }
                           }

                           z = zForInitialJump();
                           A = 3;
                           is = -1;
                           C = 0;
                           fE = -1;
                           fF = -1;
                           o = " ";
                           c = true;
                        } else if (aS[4]) {
                           if (fn == 1) {
                              fn = -1;
                           } else {
                              A = 2;
                              y = -P;
                           }

                           fE = -1;
                           fF = -1;
                           o = " ";
                           c = true;
                        } else if (aS[6]) {
                           if (fn == -1) {
                              fn = 1;
                           } else {
                              A = 2;
                              y = P;
                           }

                           fF = -1;
                           fE = -1;
                           o = " ";
                           c = true;
                        } else if (aS[8]) {
                           C = 0;
                           D = 0;
                           A = 8;
                        } else if (aS[1]) {
                           z = zForInitialJump();
                           fn = -1;
                           y = -4;
                           A = 3;
                           is = -1;
                           C = 0;
                           fE = -1;
                           fF = -1;
                           o = " ";
                           c = true;
                        } else if (aS[3]) {
                           z = zForInitialJump();

                           fn = 1;
                           y = 4;
                           A = 3;
                           is = -1;
                           C = 0;
                           fE = -1;
                           fF = -1;
                           o = " ";
                           c = true;
                        }

                        if (aT[5]) {
                           A = 5;
                           fu = 0;
                           C = 0;
                           z = 0;
                           aT[5] = false;
                           fE = -1;
                           fF = -1;
                           o = " ";
                           c = true;
                        }
                     }
                  }
               } else if (A == 2) {
                  if (aS[2]) {
                     is = -1;
                     z = zForInitialJump();
                     A = 3;
                     C = 0;
                  } else if (aS[4]) {
                     if (fn == 1) {
                        fn = -1;
                     } else {
                        y = -P + fp;
                     }
                  } else if (aS[6]) {
                     if (fn == -1) {
                        fn = 1;
                     } else {
                        y = P + fp;
                     }
                  }

                  if (aT[5]) {
                     A = 5;
                     fu = 0;
                     C = 0;
                     z = 0;
                     aT[5] = false;
                  }
               } else if (A == 11) {
                  if (aS[2]) {
                     z = zForInitialJump();
                     A = 3;
                     C = 0;
                  } else if (aS[4]) {
                     if (fn == 1) {
                        fn = -1;
                     } else {
                        y = -K + fp;
                     }
                  } else if (aS[6]) {
                     if (fn == -1) {
                        fn = 1;
                     } else {
                        y = K + fp;
                     }
                  }
               } else if (A == 3) {
                  if (aS[4]) {
                     if (fn == 1) {
                        fn = -1;
                     } else {
                        y = -P;
                     }
                  } else if (aS[6]) {
                     if (fn == -1) {
                        fn = 1;
                     } else {
                        y = P;
                     }
                  }

                  if (aT[5]) {
                     A = 5;
                     fu = 0;
                     C = 0;
                     aT[5] = false;
                  }

                  if (aS[2] && I > 0 && z > -4) {
                     tryAirKhinhCongBoost();
                  }
               } else if (A == 4) {
                  if (aS[4]) {
                     if (fn == 1) {
                        fn = -1;
                     } else {
                        y = -P;
                     }
                  } else if (aS[6]) {
                     if (fn == -1) {
                        fn = 1;
                     } else {
                        y = P;
                     }
                  }

                  if (aT[5] && z > 4) {
                     A = 5;
                     C = 0;
                     fu = 0;
                     aT[5] = false;
                  }
               } else if (A == 5) {
                  if (aS[4]) {
                     if (fn == 1) {
                        fn = -1;
                     } else {
                        y = -P + 2;
                     }
                  } else if (aS[6]) {
                     if (fn == -1) {
                        fn = 1;
                     } else {
                        y = P - 2;
                     }
                  }

                  if (aT[5]) {
                     fw = true;
                     aT[5] = false;
                  }
               } else if (A == 18) {
                  if (aS[2]) {
                     z = -10;
                     A = 21;
                     C = 10;
                     is = -1;
                  } else if (aS[4]) {
                     if (fn == 1) {
                        fn = -1;
                        in[ik] = -1;
                     } else {
                        C = 1;
                        A = 19;
                        C = 10;
                        y = -Q;
                     }
                  } else if (aS[6]) {
                     if (fn == -1) {
                        fn = 1;
                        in[ik] = 1;
                     } else {
                        A = 19;
                        C = 10;
                        y = Q;
                     }
                  } else if (aS[8]) {
                     A = 1;
                     ik = -1;
                  }
               } else if (A == 19) {
                  if (aS[2]) {
                     z = -10;
                     A = 21;
                     is = -1;
                     C = 10;
                  } else if (aS[4]) {
                     if (fn == 1) {
                        fn = -1;
                        in[ik] = -1;
                     } else {
                        y = -Q;
                     }
                  } else if (aS[6]) {
                     if (fn == -1) {
                        fn = 1;
                        in[ik] = 1;
                     } else {
                        y = Q;
                     }
                  }
               } else if (A == 21) {
                  if (aS[4]) {
                     if (fn == 1) {
                        fn = -1;
                        in[ik] = -1;
                     } else {
                        y = -Q;
                     }
                  } else if (aS[6]) {
                     if (fn == -1) {
                        fn = 1;
                        in[ik] = 1;
                     } else {
                        y = Q;
                     }
                  }
               } else if (A == 20) {
                  if (aS[4]) {
                     if (fn == 1) {
                        fn = -1;
                        in[ik] = -1;
                     } else {
                        y = -Q;
                     }
                  } else if (aS[6]) {
                     if (fn == -1) {
                        fn = 1;
                        in[ik] = 1;
                     } else {
                        y = Q;
                     }
                  }
               } else if (A == 17) {
                  if (aS[2]) {
                     z = zForInitialJump();
                     A = 3;
                     fd = -1;
                     C = 0;
                  } else if (aS[4]) {
                     if (fn == 1) {
                        fn = -1;
                     } else {
                        A = 16;
                        y = -L;
                     }
                  } else if (aS[6]) {
                     if (fn == -1) {
                        fn = 1;
                     } else {
                        A = 16;
                        y = L;
                     }
                  }
               } else if (A == 16) {
                  if (aS[2]) {
                     z = zForInitialJump();
                     A = 3;
                     fd = -1;
                     C = 0;
                  } else if (aS[4]) {
                     if (fn == 1) {
                        fn = -1;
                     } else {
                        y = -L;
                     }
                  } else if (aS[6]) {
                     if (fn == -1) {
                        fn = 1;
                     } else {
                        y = L;
                     }
                  }
               } else if (A == 12) {
                  if (aS[2] && eQ) {
                     z = -10;
                     A = 3;
                     fd = -1;
                     C = 0;
                  }
               } else if (A == 14) {
                  if (aS[4]) {
                     fn = -1;
                  } else if (aS[6]) {
                     fn = 1;
                  } else if (aS[2]) {
                     A = 15;
                  }
               }
            }
         }

         if (fP != fJ || fQ != fK) {
            fL = fJ - fP << 2;
            fM = fK - fQ << 2;
            fN += fL;
            fP += fN >> 4;
            fN &= 15;
            fO += fM;
            fQ += fO >> 4;
            fO &= 15;
            if (fP < 0) {
               fP = 0;
            }

            if (fP > fR) {
               fP = fR;
            }

            if (fQ < 0) {
               fQ = 0;
            }

            if (fQ > fS) {
               fQ = fS;
            }
         }

         if (aK >= 0) {
            fP += aI[aK];
            fQ += aJ[aK];
            if (++aK == 4) {
               aK = -1;
            }

            if (fP < 0) {
               fP = 0;
            }

            if (fP > fR) {
               fP = fR;
            }

            if (fQ < 0) {
               fQ = 0;
            }

            if (fQ > fS) {
               fQ = fS;
            }
         }

         if ((bx = fP / jf - 1) < 0) {
            bx = 0;
         }

         by = fQ / jf;
         bB = bx + bz;
         bC = by + bA;
         if (by < 0) {
            by = 0;
         }

         if (bC > iO - 1) {
            bC = iO - 1;
         }

         if (iv == null && ir > 0) { ensureIrNpcArraysSized(); }
         for(int var8 = 0; iv != null && var8 < ir; ++var8) {
            switch (iv[var8]) {
               case 2:
                  int[] var20 = it;
                  var20[var8] += iw[var8];
                  if (iw[var8] > 0) {
                     int var29 = iw[var8]--;
                  } else if (iw[var8] < 0) {
                     int var30 = iw[var8]++;
                  } else {
                     iv[var8] = 1;
                  }

                  if (!g(it[var8] - 12, iu[var8] + 1, 2) && !g(it[var8] + 12, iu[var8] + 1, 2)) {
                     iv[var8] = 4;
                     ix[var8] = 2;
                  }

                  if (g(it[var8] + 12, iu[var8] - 2, 4) || g(it[var8] - 12, iu[var8] - 2, 8)) {
                     it[var8] = I(it[var8]) + 12;
                  }
                  break;
               case 4:
                  int[] var19 = iu;
                  var19[var8] += ix[var8];
                  if (ix[var8] < 20) {
                     int var28 = ix[var8]++;
                  }

                  if (!g(it[var8] + 12, iu[var8], 2) && !g(it[var8] - 12, iu[var8], 2)) {
                     if (g(it[var8], iu[var8] - jf, 64)) {
                        iu[var8] = H(iu[var8]) + 1;
                        g(it[var8], iu[var8] - 13);
                        g(it[var8] + 1, iu[var8] - 10);
                        ix[var8] = 1;
                        iy[var8] = -1;
                        iz[var8] = 1;
                        iv[var8] = 11;
                     }
                  } else {
                     iu[var8] = H(iu[var8]);
                     ix[var8] = 0;
                     iv[var8] = 1;
                  }
                  break;
               case 11:
                  if (w % 2 == 0) {
                     int[] var10000 = iu;
                     var10000[var8] += iy[var8];
                     var10000 = ix;
                     var10000[var8] += iy[var8];
                     if (ix[var8] >= 1) {
                        iy[var8] = -1;
                     }

                     if (ix[var8] <= -1) {
                        iy[var8] = 1;
                     }

                     var10000 = it;
                     var10000[var8] += iz[var8];
                     if (var8 == is) {
                        fg = iu[is] - 24;
                        ff += iz[var8];
                     }

                     if (g(it[var8] + 12, iu[var8], 4) || g(it[var8] - 12, iu[var8], 8)) {
                        iz[var8] = -iz[var8];
                     }
                  }
            }
         }

         for(int var9 = 0; var9 < ij; ++var9) {
            if (var9 == ik) {
               if (C > 1) {
                  io[var9] = 2;
               } else if (w % 8 > 3) {
                  io[var9] = 1;
               } else {
                  io[var9] = 0;
               }
            }

            if (ip[var9] == 1) {
               int[] var21 = im;
               var21[var9] += iq[var9];
               if (iq[var9] < 20) {
                  int var31 = iq[var9]++;
               }

               if (im[var9] >= iQ || g(il[var9], im[var9], 2)) {
                  iq[var9] = 0;
                  ip[var9] = 0;
                  im[var9] = H(im[var9]);
               }
            }
         }

         for(int var10 = 0; var10 < 5; ++var10) {
            if (dU[var10] != -1) {
               int[] var22 = dU;
               var22[var10] += a(dT[var10]);
               if (dU[var10] > 30) {
                  dU[var10] = -1;
               }

               var22 = dQ;
               var22[var10] += dS[var10];
               var22 = dR;
               var22[var10] += dT[var10];
            }
         }

         if (!a) {
            for(int var11 = 0; var11 < 2; ++var11) {
               if (ci[var11] != -1) {
                  int var32 = ch[var11]--;
                  if (w % 2 == 0) {
                     var32 = ci[var11]++;
                     if (ci[var11] > 2) {
                        ci[var11] = -1;
                     } else {
                        cj[var11] = ci[var11];
                     }
                  }
               }
            }
         }

         if (!a) {
            for(int var12 = 0; var12 < 2; ++var12) {
               if (cm[var12] != -1) {
                  int var34 = cm[var12]++;
                  if (cm[var12] >= 5) {
                     cm[var12] = -1;
                  }

                  if (var12 == 0) {
                     var34 = ck[var12]--;
                  } else {
                     var34 = ck[var12]++;
                  }

                  var34 = cl[var12]--;
               }
            }
         }

         for(int var13 = 0; var13 < 2; ++var13) {
            if (cd[var13] != -1) {
               int var38 = cd[var13]++;
               int[] var25 = cb;
               var25[var13] += cf[var13] << 2;
               var38 = cc[var13]--;
               if (cd[var13] >= 6) {
                  cd[var13] = -1;
               } else {
                  ce[var13] = (cd[var13] >> 1) % 3;
               }
            }
         }

         Z();
         M();
         if (dY > 0 && ++dY > 30) {
            dY = 0;
         }

         O();
         N();
         R();
         if (gn == v) {
            try {
               switch (gs) {
                  case 1:
                     ag();
                     break;
                  case 2:
                     af();
                     break;
                  case 3:
                     ae();
                     break;
                  case 4:
                     ac();
                     break;
                  case 5:
                     ab();
                  case 6:
                  default:
                     break;
                  case 7:
                     ad();
               }
            } catch (Exception var3) {
               go = ff;
               gp = fg;
               gq = 0;
               gr = 0;
               gs = 4;
            }
         }

         ah();
         Y();
         ax();
         aj();
         al();
         an();
         ao();
         ap();
         W();
         am();
         P();
         if (cn) {
            ak();
         }

      }
   }

   private static void ab() {
      label79:
      switch (++gB) {
         case 1:
         case 2:
         case 3:
            ih = -1;
            gt = 9;
            break;
         case 4:
         case 5:
            ih = 0;
            gt = 10;
            break;
         case 6:
            ih = 1;
            gt = 11;
            if (ii == 1) {
               int var0 = gA << 3;
               int var1 = fg - gp >> 3;
               a(go + (gA << 3), gp - 12, var0, var1 + (var0 - 8), true);
            } else {
               int var6 = E << 1;
               int var7 = gA > 0 ? go - 20 : go - 40;
               int var2 = gA > 0 ? go + 40 : go + 20;
               int var3 = gp - gv - 15;
               int var4 = gp + 5;
               int var5 = 0;

               int var10000;
               while(true) {
                  if (var5 >= jI) {
                     var10000 = -1;
                     break;
                  }

                  if (jQ[var5] != 5 && jL[var5] >= var7 && jL[var5] <= var2 && jM[var5] >= var3 && jM[var5] <= var4) {
                     var10000 = var5;
                     break;
                  }

                  ++var5;
               }

               var7 = var10000;
               if (var10000 != -1) {
                  k(var7, var6, -gA);
                  f(jL[var7], jM[var7] - (jN[var7] >> 1), gA);
                  a("-" + var6, 0, jL[var7], jM[var7] - jN[var7], 0, -2);
               }

               if (gO && a(gp - gR) < 30 && a(go + (gA << 4) - gQ) < 40 && !c(var6, -gA)) {
                  f(go + (gQ - go >> 1), gp - 12, gA);
                  a("-" + var6, 0, gQ, gR - gX, 0, -2);
               }

               for(int var9 = 0; var9 < cq; ++var9) {
                  if (gp == cw[var9] && a(go + (gA << 4) - cv[var9]) < 24) {
                     a(var9, var6, -gA);
                     f(cv[var9], cw[var9] - 15, gA);
                     a("-" + var6, 0, cv[var9], cw[var9] - 28, 0, -2);
                     break label79;
                  }
               }
            }
            break;
         case 7:
            ih = 2;
            gt = 11;
            break;
         case 8:
            ih = -1;
            gt = 12;
            break;
         case 9:
            ih = -1;
            gt = 9;
            gs = 1;
            gB = 0;
            gC = 0;
      }

      if (ii == 1) {
         ih = -1;
      }

   }

   private static void ac() {
      if (gA == 1) {
         if ((i(go + gu, gp) & 4) == 4) {
            gq = 0;
         }
      } else if ((i(go - gu, gp) & 8) == 8) {
         gq = 0;
      }

      ih = -1;
      if ((go += gq) < 0) {
         go = 0;
      }

      if (go >= iP) {
         go = iP - 1;
      }

      gp += gr;
      if (gr < 18) {
         ++gr;
      }

      if (gr > 5) {
         gq = 0;
      }

      if (gq > 1) {
         --gq;
      }

      gt = 8;
      if (gp >= iQ) {
         gp = iQ - 1;
         gs = 3;
         gr = -20;
      }

      if (gr > 4 && (i(go, gp) & 2) == 2) {
         gs = 1;
         gr = 0;
         gq = 0;
         gC = 0;
         gB = 0;
         gp = I(gp);
         e(-1, go - -8, gp);
         e(1, go - 8, gp);
      }

      if (g(go, gp, 64) && g(go, gp + 24, 4096) && gp % jf > 8) {
         g(go, H(gp) + 8);
         gs = 3;
         gq = (gA = ff > go ? 1 : -1) << 2;
         gr = -11;
      }

      if (gr > 6) {
         gt = 6;
      }

      if (gD < 0) {
         ++gD;
      }

   }

   private static void ad() {
      if ((i(go + gw, gp - gx) & 4) == 4) {
         gq = -gq;
      }

      if ((i(go - gw, gp - gx) & 8) == 8) {
         gq = -gq;
      }

      go += gq;
      gp += gr;
      gt = 7;
      if (gq > 1) {
         --gq;
      }

      if (gq < -1) {
         ++gq;
      }

      if (++gr > 0) {
         gr = 0;
      }

      if (++gB >= 7) {
         gs = 4;
         gD = -20;
         gC = 0;
         gB = 0;
         gr = 1;
      }

   }

   private static void ae() {
      if (gq == 0) {
         gq = gA << 2;
      }

      if (gA == 1) {
         if ((i(go + gw, gp - gx) & 4) == 4) {
            gq = 0;
         }
      } else if ((i(go - gw, gp - gx) & 8) == 8) {
         gq = 0;
      }

      if (fg < 0) {
         fg = 0;
         z = -1;
      }

      if ((go += gq) < 0) {
         go = 0;
      }

      if (go >= iP) {
         go = iP - 1;
      }

      gp += gr;
      if (gB == 0) {
         gt = 7;
      } else {
         gt = 8;
      }

      if (gq > 1) {
         --gq;
      }

      if (++gr == 0) {
         gs = 4;
         gB = 0;
         gC = 0;
         gr = 1;
      }

      if (gD < 0) {
         ++gD;
      }

   }

   private static void af() {
      if (++gB >= 10) {
         gB = 0;
      }

      gt = (gB >> 1) + 2;
      if (gA == 1) {
         if (g(go + gw, gp - gx, 4)) {
            gq = 0;
            go = I(go + gw) - gw;
         }
      } else if (g(go - gw - 1, gp - gx, 8)) {
         gq = 0;
         go = I(go - gw - 1) + jf + gw;
      }

      if ((go += gq) < 0) {
         go = 0;
      }

      if (go >= iP) {
         go = iP - 1;
      }

      if (is != -1) {
         if (a(go - it[is]) >= 20) {
            is = -1;
            if (g(go, gp, 2)) {
               gs = 1;
            } else {
               gs = 4;
               gr = 2;
               gq = 3 * gA;
               gC = 0;
            }
         }
      } else if ((i(go + gA * gu, gp) & 2) != 2) {
         gs = 1;
         gt = 0;
         gq = 0;
         gB = 0;
         gC = 0;
      }

      e(gA, go - (gA << 3), gp);
      if (gL > 0) {
         --gL;
      } else {
         C();
      }
   }

   private static void ag() {
      if (++gB > 30) {
         gB = 0;
      }

      if (gB % 15 < 5) {
         gt = 0;
      } else {
         gt = 1;
      }

      if (gl && w % 6 == 0) {
         int var0 = 0;

         label69:
         while(true) {
            if (var0 >= jI) {
               for(int var1 = 0; var1 < cq; ++var1) {
                  if (cF[var1] != 5 && cw[var1] == gp && a(cv[var1] - go) < 40) {
                     gA = cv[var1] > go ? 1 : -1;
                     gs = 5;
                     ii = 0;
                     gB = 0;
                     gC = 0;
                     break label69;
                  }
               }

               if (a(ff - go) > 25 && fg != gp && A == 5) {
                  gA = ff > go ? 1 : -1;
                  gs = 5;
                  ii = 1;
                  gB = 0;
                  gC = 0;
               }
               break;
            }

            if (jQ[var0] != 5 && a(jM[var0] - gp) < 20 && a(jL[var0] - go) < 40) {
               gA = jL[var0] > go ? 1 : -1;
               gs = 5;
               ii = 0;
               gB = 0;
               gC = 0;
               break;
            }

            ++var0;
         }
      }

      if (w % 15 == 0) {
         C();
      }

   }

   private static void ah() {
      for(int var0 = 0; var0 < dv; ++var0) {
         switch (dE[var0]) {
            case 1:
               int var6 = dF[var0]++;
               if (dF[var0] > 30) {
                  dF[var0] = 0;
               }

               if (dF[var0] % (var0 + 18) < var0 + 6) {
                  dH[var0] = 0;
               } else {
                  dH[var0] = 1;
               }

               if (dy) {
                  dG[var0] = dz;
                  dK[var0] = dz > dA[var0] ? 1 : -1;
                  dC[var0] = dK[var0] << 2;
                  dC[var0] = dK[var0] > 0 ? dC[var0] + var0 % 2 : dC[var0] - var0 % 2;
                  dE[var0] = 2;
               } else if (!dx) {
                  var6 = dG[var0]++;
                  if (dG[var0] > (dL[var0] + dA[var0]) % 20 + (dL[var0] >> 1)) {
                     if (iA && fF == var0) {
                        break;
                     }

                     dG[var0] = 0;
                     int var2;
                     if ((var2 = (w + dL[var0]) % 120 - 60) > 0) {
                        var2 += dL[var0];
                     } else {
                        var2 -= dL[var0];
                     }

                     dG[var0] = dA[var0] + var2;
                     dK[var0] = var2 > 0 ? 1 : -1;
                     dC[var0] = dK[var0] << 2;
                     dE[var0] = 2;
                     if (fF == var0) {
                        fF = -1;
                        o = " ";
                        c = true;
                     }
                  }

                  if (w % 10 == 1) {
                     B(var0);
                  }
               }
               break;
            case 2:
               int var5 = dF[var0]++;
               if (dF[var0] >= 10) {
                  dF[var0] = 0;
               }

               dH[var0] = (dF[var0] >> 1) + 2;
               int[] var10000 = dA;
               var10000[var0] += dC[var0];
               if (dA[var0] <= dO[var0] && dA[var0] >= dN[var0] && a(dA[var0] - dG[var0]) >= 8) {
                  if (w % 10 == 0) {
                     B(var0);
                  }
               } else {
                  dF[var0] = dG[var0] = 0;
                  var10000 = dA;
                  var10000[var0] -= dC[var0];
                  dC[var0] = 0;
                  dE[var0] = 1;
               }
            case 3:
            case 4:
            default:
               break;
            case 5:
               int var10002 = dF[var0]++;
               switch (dG[var0]) {
                  case 0:
                     switch (dF[var0]) {
                        case 1:
                        case 2:
                        case 3:
                           dJ[var0] = -1;
                           dH[var0] = 13;
                           continue;
                        case 4:
                           dJ[var0] = 0;
                           dH[var0] = 14;
                           continue;
                        case 5:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           continue;
                        case 6:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           A(var0);
                           continue;
                        case 7:
                           dJ[var0] = 2;
                           dH[var0] = 16;
                           continue;
                        case 8:
                           dJ[var0] = 2;
                           dH[var0] = 16;
                           dG[var0] = 2;
                           dF[var0] = 1;
                        default:
                           continue;
                     }
                  case 1:
                     switch (dF[var0]) {
                        case 1:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           continue;
                        case 2:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           dG[var0] = 10;
                        default:
                           continue;
                     }
                  case 2:
                     switch (dF[var0]) {
                        case 1:
                        case 2:
                        case 3:
                           dJ[var0] = 3;
                           dH[var0] = 17;
                           continue;
                        case 4:
                           dJ[var0] = 4;
                           dH[var0] = 18;
                           continue;
                        case 5:
                           dJ[var0] = 5;
                           dH[var0] = 19;
                           continue;
                        case 6:
                           dJ[var0] = 6;
                           dH[var0] = 20;
                           A(var0);
                           continue;
                        case 7:
                           dJ[var0] = 6;
                           dH[var0] = 20;
                           dG[var0] = 3;
                           dF[var0] = 1;
                        default:
                           continue;
                     }
                  case 3:
                     switch (dF[var0]) {
                        case 1:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           break;
                        case 2:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           break;
                        case 3:
                           dJ[var0] = 2;
                           dH[var0] = 16;
                           break;
                        case 4:
                           dJ[var0] = 2;
                           dH[var0] = 16;
                           dG[var0] = 1;
                           dF[var0] = 1;
                     }
                  case 4:
                  case 5:
                  case 6:
                  case 7:
                  case 8:
                  case 9:
                  default:
                     break;
                  case 10:
                     switch (dF[var0]) {
                        case 1:
                           dJ[var0] = 2;
                           dH[var0] = 16;
                           break;
                        case 2:
                           dJ[var0] = 0;
                           dH[var0] = 14;
                           break;
                        case 3:
                        case 4:
                           dH[var0] = 13;
                           dJ[var0] = -1;
                           break;
                        case 5:
                           dH[var0] = 13;
                           dJ[var0] = -1;
                           dE[var0] = 1;
                           dG[var0] = 120;
                           dF[var0] = 0;
                     }
               }
         }
      }

   }

   private static void ai() {
      if (aN) {
         aN = false;
         aT[5] = true;
      }

      if (++w == 10000) {
         w = 0;
      }

      aq();
      if (!V()) {
         ah();
         R();
         X();
      }
   }

   private static void aj() {
      for(int var0 = 0; var0 < cq; ++var0) {
         if (cr[var0] > 0) {
            int var10002 = cr[var0]--;
         }

         label144:
         switch (cF[var0]) {
            case 1:
               cK[var0] = 1;
               int var14 = cG[var0]++;
               int[] var6 = cv;
               var6[var0] += cz[var0];
               var6 = cw;
               var6[var0] += cA[var0];
               var6 = cx;
               var6[var0] += cB[var0];
               var6 = cy;
               var6[var0] += cC[var0];
               if (cG[var0] > 14) {
                  if (cz[var0] > 1) {
                     var14 = cz[var0]--;
                  } else if (cz[var0] < -1) {
                     var14 = cz[var0]++;
                  }

                  var14 = cA[var0]++;
               }

               if (cB[var0] > 1) {
                  var14 = cB[var0]--;
               } else if (cB[var0] < -1) {
                  var14 = cB[var0]++;
               }

               var14 = cC[var0]++;
               if (cw[var0] <= fQ + r + 32 && cw[var0] < iQ) {
                  continue;
               }

               cG[var0] = 0;
               cH[var0] = 0;
               cF[var0] = 5;
               break;
            case 2:
               if (w % 12 > 7) {
                  cD[var0] = 1;
                  cJ[var0] = 1;
                  if (w % 12 < 10) {
                     if (a(cv[var0] - cH[var0]) < 4) {
                        cG[var0] = cH[var0] = 0;
                        cF[var0] = 3;
                        break;
                     }

                     int[] var5 = cv;
                     var5[var0] += cz[var0];
                  }

                  w(var0);
               } else {
                  cJ[var0] = 0;
                  cD[var0] = 0;
               }
               break;
            case 3:
               if ((w + var0) % 10 > 5) {
                  cD[var0] = 1;
               } else {
                  cD[var0] = 0;
               }

               int var13 = cG[var0]++;
               cJ[var0] = 0;
               cK[var0] = 0;
               if (cG[var0] > 50) {
                  int var1;
                  if ((var1 = (w - var0) % (var0 + 80) - 40) > 0) {
                     var1 += 20;
                  } else {
                     var1 -= 20;
                  }

                  cH[var0] = cv[var0] + var1;
                  cI[var0] = var1 > 0 ? 1 : -1;
                  if (w % 4 > 1) {
                     cF[var0] = 2;
                     cz[var0] = cI[var0] << 1;
                  } else {
                     cF[var0] = 7;
                     cz[var0] = cI[var0] << 2;
                  }

                  if (cH[var0] < cL[var0]) {
                     cH[var0] = cL[var0];
                  }

                  if (cH[var0] > cM[var0]) {
                     cH[var0] = cM[var0];
                  }
               }

               if (w % 30 == 28) {
                  w(var0);
                  v(var0);
               }
               break;
            case 4:
               int var12 = cG[var0]++;
               if (cG[var0] < 3) {
                  cD[var0] = 0;
                  cJ[var0] = 0;
                  cK[var0] = 0;
               } else if (cG[var0] < 14) {
                  cD[var0] = 1;
                  cJ[var0] = 1;
                  cK[var0] = 1;
               } else {
                  cF[var0] = 3;
                  cG[var0] = 1;
               }

               if (cG[var0] == 3) {
                  switch (cE[var0]) {
                     case 0:
                     case 4:
                        b(cv[var0] + (cI[var0] << 3), cw[var0] - 15, cI[var0] * 12, ab[cE[var0]], 0);
                        break label144;
                     case 1:
                     case 5:
                        b(cv[var0] + (cI[var0] << 3), cw[var0] - 15, cI[var0] << 3, ab[cE[var0]], 1);
                        break label144;
                     case 2:
                     case 3:
                     case 6:
                        if (a(fg - cw[var0]) < 5 && a(ff - cv[var0]) < 30) {
                           a(ab[cE[var0]], cI[var0]);
                        }
                  }
               }
               break;
            case 5:
               int var11 = cG[var0]++;
               if (cG[var0] > 550 + var0 * 5) {
                  cv[var0] = ct[var0];
                  cw[var0] = cu[var0];
                  cG[var0] = 0;
                  cF[var0] = 3;
                  cs[var0] = ad[cE[var0]];
               }
               break;
            case 6:
               if ((w + var0) % 10 > 5) {
                  cD[var0] = 1;
               } else {
                  cD[var0] = 0;
               }

               cJ[var0] = 0;
               cK[var0] = 0;
               int var10 = cG[var0]++;
               if (cG[var0] >= 5) {
                  cH[var0] = ff;
                  if (cv[var0] < ff) {
                     int[] var3 = cH;
                     var3[var0] -= 80;
                  } else {
                     int[] var4 = cH;
                     var4[var0] += 80;
                  }

                  cG[var0] = 0;
                  cI[var0] = cH[var0] < ff ? -1 : 1;
                  cF[var0] = 7;
                  cz[var0] = cI[var0] << 3;
                  if (cH[var0] < cL[var0]) {
                     cH[var0] = cL[var0];
                  }

                  if (cH[var0] > cM[var0]) {
                     cH[var0] = cM[var0];
                  }
               }
               break;
            case 7:
               if (a(cv[var0] - cH[var0]) < 12) {
                  cG[var0] = cH[var0] = 0;
                  cF[var0] = 3;
                  v(var0);
               } else {
                  int[] var10000 = cv;
                  var10000[var0] += cz[var0];
                  if (w % 2 == 1) {
                     cD[var0] = 1;
                     cJ[var0] = 3;
                  } else {
                     cJ[var0] = 2;
                     cD[var0] = 0;
                  }
               }
         }

         cx[var0] = cv[var0];
         cy[var0] = cw[var0] - 9 + cD[var0] + af[cE[var0]][cK[var0]];
      }

   }

   private static void ak() {
      if (++co >= 150) {
         cn = false;
      }

   }

   private static void al() {
      if (gO) {
         if (hc > 0) {
            --hc;
         }

         switch (gT) {
            case 1:
               if (gY > 0) {
                  --gY;
               } else {
                  int var0;
                  if ((var0 = w % 80 - 40) > 0) {
                     var0 += 20;
                  } else {
                     var0 -= 20;
                  }

                  gZ = gQ + var0;
                  gS = (gU = var0 > 0 ? 1 : -1) << 2;
                  if (ha < hb >> 1) {
                     gS = gU << 3;
                  }

                  gT = 2;
                  if (w % 5 == 0) {
                     L();
                  }
               }

               gV = 0;
               if (w % 10 == 6) {
                  e(-gU, gQ + gU * 28, gR - 5);
                  return;
               }
               break;
            case 2:
               if (w % 8 == 0) {
                  L();
               }

               if (!g(gQ + (gU << 4), gR + 1, 2)) {
                  gT = 1;
                  gY = 0;
                  return;
               }

               if (a(gQ - gZ) < 8) {
                  gT = 1;
                  gY = 20;
               }

               if (w % 2 == 0) {
                  gQ += gS;
                  gV = 0;
                  return;
               }

               gV = 1;
               return;
            case 3:
            case 4:
            default:
               break;
            case 5:
               if (!g(gQ + (gU << 4), gR + 1, 2)) {
                  gT = 1;
                  gY = 0;
                  return;
               }

               if (a(gQ - gZ) < 4) {
                  gT = 1;
                  gY = 35;
               }

               if (a(fg - gR) < 18 && a(gQ + (gU << 4) - ff) < 10) {
                  a(gP, gU);
                  gT = 1;
                  gY = 45;
                  if (ha < hb >> 1) {
                     gY = 18;
                  }
               }

               gQ += gS;
               gV = w % 3;
               return;
            case 6:
               gR += gY;
               ++gY;
               gQ += gS;
               if (gS > 1) {
                  --gS;
               }

               if (gS < -1) {
                  ++gS;
               }

               if (gR > fQ + r + gX || gR >= iQ + gX) {
                  gY = 0;
                  gT = 22;
                  return;
               }
               break;
            case 7:
               gQ -= gU;
               gV = 2;
               if (++gY == 4) {
                  gT = 1;
                  if ((gY = gZ) > 0 && ha < hb >> 1) {
                     gY = 5;
                     return;
                  }
               }
         }

      }
   }

   private static void am() {
      for(int var0 = 0; var0 < cN; ++var0) {
         if (cR[var0] != 0) {
            if (a(fg - (fi >> 1) - (cQ[var0] - 7)) < 10 && a(ff - cP[var0]) < 10) {
               if (cO[var0] == 0) {
                  if ((G += cV[var0]) > H) {
                     G = H;
                  }

                  a("+" + cV[var0], 0, cP[var0], cQ[var0] - 15, 0, -1);
               } else {
                  if ((I += cV[var0]) > J) {
                     I = J;
                  }

                  a("+" + cV[var0], 2, cP[var0], cQ[var0] - 15, 0, -1);
               }

               c = true;
               cR[var0] = 301;
            }

            int[] var10000 = cP;
            var10000[var0] += cS[var0];
            var10000 = cQ;
            var10000[var0] += cT[var0];
            if (cS[var0] > 1) {
               int var10002 = cS[var0]--;
            }

            if (cS[var0] < -1) {
               int var2 = cS[var0]++;
            }

            if (cT[var0] < 20) {
               int var3 = cT[var0]++;
            }

            int var4 = cR[var0]++;
            if (cR[var0] > 200) {
               cR[var0] = 0;
            }

            if (cQ[var0] < iQ && cQ[var0] >= 0 && cP[var0] < iP && cP[var0] >= 0) {
               if (cT[var0] > 2 && (i(cP[var0], cQ[var0]) & 2) == 2) {
                  cQ[var0] = H(cQ[var0]);
                  if (cT[var0] > 2) {
                     cT[var0] = -(cT[var0] >> 1);
                  } else {
                     cS[var0] = 0;
                     cT[var0] = 0;
                  }
               }
            } else {
               cR[var0] = 0;
            }
         }
      }

   }

   private static void an() {
      if (hK) {
         int var0 = w % 10;
         if (id > 0) {
            --id;
         }

         switch (hY) {
            case 1:
               ++ic;
               hR += 2;
               ++bK;
               ++bL;
               ++bM;
               if (ic > 50) {
                  hY = 5;
               }
               break;
            case 2:
               if (hN < hO >> 1) {
                  hQ += hZ << 2;
               } else {
                  hQ += hZ << 1;
               }

               if (hQ < ia) {
                  hZ = 1;
               }

               if (hQ > ib) {
                  hZ = -1;
               }

               if (ic > 0) {
                  --ic;
               }

               if (ic == 0 && a(ff - (hQ - 40)) < 30) {
                  ic = 0;
                  hY = 4;
                  hZ = hQ < ff ? 1 : -1;
               }

               if (w % 122 == 0) {
                  c(hQ, hR - 45, -1, -12, hL);
                  c(hQ, hR - 50, 0, -15, hL);
                  c(hQ, hR - 45, 1, -12, hL);
               } else if (w % 200 == 0) {
                  hY = 7;
                  ic = 0;
               }
            case 3:
            case 5:
            case 6:
            default:
               break;
            case 4:
               if (ic == 110) {
                  hY = 2;
                  ic = 30;
               } else if (ic < 35) {
                  --hR;
               } else if (ic >= 75) {
                  ++hR;
                  if (var0 == 5) {
                     c(hQ, hR - 45, -2, -10, hL);
                  } else if (var0 == 7 && hN < hO >> 1) {
                     c(hQ, hR - 50, 0, -11, hL);
                  } else if (var0 == 9) {
                     c(hQ, hR - 45, 2, -10, hL);
                  }
               }

               if (ic > 20 && ic < 50 && var0 == 0) {
                  b(hQ + hZ * 20, hR - 29, hZ << 3, hL, 2);
               }

               if (ic > 45 && ic < 50) {
                  bJ += hZ;
               } else if (ic > 50 && ic < 55) {
                  bJ -= hZ;
               }

               ++ic;
               break;
            case 7:
               if (++ic == 50) {
                  hY = 2;
                  ic = 1;
               } else if (ic == 30) {
                  if ((hQ = ff + (fn << 6)) > ib) {
                     hQ = ib - 30;
                  }

                  if (hQ < ia) {
                     hQ = ia + 30;
                  }

                  hZ = hQ < ff ? 1 : -1;
               } else if (ic < 10) {
                  hR += 10;
               } else if (ic > 40) {
                  hR -= 10;
               }
         }

         if (var0 < 4) {
            --hR;
         } else if (var0 < 8) {
            ++hR;
         }

         if (var0 > 4) {
            --bK;
            ++bL;
         } else {
            ++bK;
            --bL;
         }

         if (hZ == -1) {
            hS = hQ + bH;
            hW = hR + bK;
            hV = hQ + bI;
            hX = hR + bL;
            hT = hQ + bJ;
            hU = hR + bM;
         } else {
            hS = hQ - bH;
            hW = hR + bK;
            hV = hQ - bI;
            hX = hR + bL;
            hT = hQ - bJ;
            hU = hR + bM;
         }
      }
   }

   private static void ao() {
      if (hj) {
         int var0 = w % 10;
         int var1 = a(ff - hq);
         int var2 = a(fg - hr);
         switch (hs) {
            case 0:
               if (var0 < 7) {
                  hI = hy[0];
                  hJ = hz[0];
               } else {
                  hI = hy[1];
                  hJ = hz[1];
               }
               break;
            case 1:
               if (var0 < 7) {
                  hI = hy[0];
                  hJ = hz[0];
               } else {
                  hI = hy[1];
                  hJ = hz[1];
               }

               if (var1 > 90 && var1 < 100 && var0 < 2) {
                  ht = hq < ff ? 1 : -1;
                  hs = 23;
                  hw = 0;
               } else if ((var1 > 120 && var1 < 150 || fg < hr && var1 > 40) && var0 < 2) {
                  ht = hq < ff ? 1 : -1;
                  hw = 0;
                  hs = 8;
               } else if (var1 < 40 && var0 == 1) {
                  ht = hq < ff ? 1 : -1;
                  hw = 0;
                  hs = 5;
               } else if (var1 > 40 && var1 < 100 && var0 < 3) {
                  ht = hq < ff ? 1 : -1;
                  hw = 0;
                  if ((hx = ff) > hv) {
                     hx = hv;
                  } else if (hx < hu) {
                     hx = hu;
                  }

                  hs = 24;
               } else if (var1 > 80 && var0 == 2) {
                  hw = 0;
                  hs = 2;
                  if ((hx = ff) > hv) {
                     hx = hv;
                  } else if (hx < hu) {
                     hx = hu;
                  }
               }
               break;
            case 2:
               if ((var2 = ++hw % 6 >> 1) == 3) {
                  aK = 0;
               }

               hI = hC[var2];
               hJ = hD[var2];
               if ((hq += ht << 2) > hx && ht > 0 || hq < hx && ht < 0 || hq > hv || hq < hu || hw > 100) {
                  hw = 0;
                  hs = 1;
               }

               if (var1 > 50 && var1 < 100 && var0 == 1) {
                  ht = hq < ff ? 1 : -1;
                  hs = 23;
                  hw = 0;
               }
               break;
            case 5:
               if (++hw < 2) {
                  hI = hy[0];
                  hJ = hz[0];
               } else if (hw < 2) {
                  hI = hA[0];
                  hJ = hB[0];
               } else if (hw < 12) {
                  hI = hA[1];
                  hJ = hB[1];
               } else if (hw < 14) {
                  hI = hA[0];
                  hJ = hB[0];
               } else if (hw == 14) {
                  hw = 0;
                  hs = 1;
               }

               if (hw == 3 && var1 < 40 && var2 < 10) {
                  a(hk, ht);
               }
               break;
            case 6:
               ++hw;

               for(int var5 = 0; var5 < hH.length; ++var5) {
                  int[] var10000 = hH;
                  var10000[var5] += a(var5 - 3) + 2;
                  var10000 = hG;
                  var10000[var5] += var5 - 3 << 1;
               }

               if (hw >= 50) {
                  hs = 22;
               }
               break;
            case 8:
               if (++hw < 2) {
                  hI = hy[0];
                  hJ = hz[0];
               } else if (hw < 2) {
                  hI = hA[0];
                  hJ = hB[0];
               } else if (hw < 12) {
                  hI = hA[1];
                  hJ = hB[1];
               } else if (hw < 14) {
                  hI = hA[0];
                  hJ = hB[0];
               } else if (hw == 14) {
                  hw = 0;
                  hs = 1;
               }

               if (hw % 5 == 0) {
                  a(hq + (ht << 3), hr - 20, ht << 3, -var0 + 2, false);
               }
               break;
            case 23:
               var0 = ++hw % 4 >> 1;
               hI = hA[var0];
               hJ = hB[var0];
               if (hw > 20 && hw % 10 == 0) {
                  b(hq + (ht << 3), hr - 24, ht << 3, hk, 3);
               }

               if (hw == 100) {
                  ht = hq < ff ? 1 : -1;
                  hw = 0;
                  if ((hx = ff) > hv) {
                     hx = hv;
                  } else if (hx < hu) {
                     hx = hu;
                  }

                  hs = 24;
               }
               break;
            case 24:
               var0 = ++hw % 6 >> 1;
               hI = hC[var0];
               hJ = hD[var0];
               if ((hq += ht << 3) > hx && ht > 0 || hq < hx && ht < 0 || hq > hv || hq < hu || hw > 100) {
                  hw = 0;
                  hs = 5;
               }
         }

         for(int var7 = 0; var7 < 6; ++var7) {
            if (ht == 1) {
               hE[var7] = hq + hG[var7] + hI[var7];
            } else {
               hE[var7] = hq - hG[var7] - hI[var7];
            }

            hF[var7] = hr + hH[var7] + hJ[var7];
         }

      }
   }

   private static void ap() {
      if (hd) {
         int var0 = w % 50;
         int var1 = a(dA[0] - ff);
         switch (dE[0]) {
            case 0:
               int var17 = dF[0]++;
               if (dF[0] > 30) {
                  dF[0] = 0;
               }

               if (dF[0] % 18 < 6) {
                  dH[0] = 0;
               } else {
                  dH[0] = 1;
               }

               if (dy) {
                  he = false;
                  dG[0] = dz;
                  dK[0] = dz > dA[0] ? 1 : -1;
                  dC[0] = dK[0] << 2;
                  dC[0] = dK[0] > 0 ? dC[0] : dC[0];
                  dE[0] = 2;
                  return;
               }

               if (var1 >= 40 || A != 5) {
                  return;
               }

               he = true;
               dE[0] = 3;
               dK[0] = -fn;
               if (var0 > 35) {
                  dC[0] = fn * 5;
                  dD[0] = -9;
               } else {
                  dC[0] = -fn * 6;
                  dD[0] = -9;
               }

               if (dA[0] < dN[0] + 40) {
                  dC[0] = 10;
                  dK[0] = -1;
               } else if (dA[0] > dO[0] - 40) {
                  dC[0] = -10;
                  dK[0] = 1;
               }
               break;
            case 1:
               int var16 = dF[0]++;
               if (dF[0] > 30) {
                  dF[0] = 0;
               }

               if (dF[0] % 18 < 6) {
                  dH[0] = 0;
               } else {
                  dH[0] = 1;
               }

               if (hf) {
                  dE[0] = 0;
                  dF[0] = dG[0] = 0;
               }

               if (var1 < 40 && A == 5 && fn != dK[0]) {
                  dE[0] = 3;
                  dK[0] = -fn;
                  if (var0 > 35) {
                     dC[0] = fn * 5;
                     dD[0] = -9;
                  } else {
                     dC[0] = -fn * 6;
                     dD[0] = -9;
                  }

                  if (dA[0] < dN[0] + 40) {
                     dC[0] = 10;
                     dK[0] = -1;
                  } else if (dA[0] > dO[0] - 40) {
                     dC[0] = -10;
                     dK[0] = 1;
                  }

                  dF[0] = dG[0] = 0;
                  return;
               }

               if (var1 < 40 && var0 < 10) {
                  dK[0] = ff > dA[0] ? 1 : -1;
                  dE[0] = 5;
                  dF[0] = dG[0] = dM[0] = 0;
                  return;
               }

               if (var1 < 100 && var1 > 40 && var0 < 1) {
                  dK[0] = ff > dA[0] ? 1 : -1;
                  dE[0] = 24;
                  dF[0] = dG[0] = dM[0] = 0;
                  dC[0] = (a(dA[0] - ff) >> 3) * dK[0];
                  return;
               }

               if (var1 > 100 && var1 < 160 && var0 < 30) {
                  dK[0] = ff > dA[0] ? 1 : -1;
                  dE[0] = 8;
                  dF[0] = dG[0] = dM[0] = 0;
                  return;
               }

               if (var1 >= 20 && var0 != 42) {
                  if (var1 > 160) {
                     dK[0] = ff > dA[0] ? 1 : -1;
                     dG[0] = dA[0] + (dK[0] << 7);
                     if (dG[0] < dN[0]) {
                        dG[0] = dN[0];
                     } else if (dG[0] > dO[0]) {
                        dG[0] = dO[0];
                     }

                     dF[0] = 0;
                     dE[0] = 2;
                     dC[0] = dK[0] << 2;
                     return;
                  }

                  return;
               }

               dK[0] = -fn;
               dG[0] = dA[0] + (dK[0] << 6);
               if (dG[0] < dN[0] || dG[0] > dO[0]) {
                  dK[0] = -dK[0];
                  dG[0] = dA[0] + (dK[0] << 6);
               }

               dF[0] = 0;
               dE[0] = 2;
               dC[0] = dK[0] << 3;
               return;
            case 2:
               int var15 = dF[0]++;
               if (dF[0] >= 10) {
                  dF[0] = 0;
               }

               dH[0] = (dF[0] >> 1) + 2;
               int[] var6 = dA;
               var6[0] += dC[0];
               if (dy || (dK[0] <= 0 || dA[0] <= dG[0]) && (dK[0] >= 0 || dA[0] >= dG[0])) {
                  return;
               }

               dK[0] = ff > dA[0] ? 1 : -1;
               dG[0] = dF[0] = 0;
               dE[0] = 1;
               return;
            case 3:
            case 7:
               int[] var4 = dA;
               var4[0] += dC[0];
               if (dA[0] < dN[0]) {
                  dA[0] = dN[0];
               }

               if (dA[0] > dO[0]) {
                  dA[0] = dO[0];
               }

               var4 = dB;
               var4[0] += dD[0];
               dH[0] = 23;
               if (dC[0] > 0) {
                  int var13 = dC[0]--;
               }

               int var14 = dD[0]++;
               if (dD[0] == 0) {
                  dE[0] = 4;
                  dF[0] = 0;
                  dD[0] = 1;
                  return;
               }

               return;
            case 4:
               int[] var2 = dA;
               var2[0] += dC[0];
               if (dA[0] < dN[0]) {
                  dA[0] = dN[0];
               }

               if (dA[0] > dO[0]) {
                  dA[0] = dO[0];
               }

               var2 = dB;
               var2[0] += dD[0];
               dH[0] = 7;
               if (dD[0] < 18) {
                  int var11 = dD[0]++;
               }

               if (dC[0] > 0) {
                  int var12 = dC[0]--;
               }

               dH[0] = 7;
               if (dB[0] >= iQ) {
                  dE[0] = 6;
                  return;
               }

               if ((i(dA[0], dB[0]) & 2) == 2) {
                  dE[0] = 1;
                  dF[0] = dG[0] = 0;
                  dC[0] = dD[0] = 0;
                  dB[0] = I(dB[0]);
                  e(-1, dA[0] - -8, dB[0]);
                  e(1, dA[0] - 8, dB[0]);
                  if (a(dA[0] - ff) < 40 && var0 < 25) {
                     dK[0] = ff > dA[0] ? 1 : -1;
                     dE[0] = 5;
                     dF[0] = dG[0] = dM[0] = 0;
                  }

                  if (var1 < 40) {
                     dK[0] = fn;
                     dG[0] = dA[0] + dK[0] * 110;
                     if (dG[0] < dN[0] || dG[0] > dO[0]) {
                        dK[0] = -dK[0];
                        dG[0] = dA[0] + (dK[0] << 6);
                     }

                     dF[0] = 0;
                     dE[0] = 2;
                     dC[0] = dK[0] * 10;
                     return;
                  }
               }

               return;
            case 5:
               int var10 = dF[0]++;
               switch (dG[0]) {
                  case 0:
                     switch (dF[0]) {
                        case 1:
                        case 2:
                        case 3:
                           dJ[0] = -1;
                           dH[0] = 13;
                           return;
                        case 4:
                           dJ[0] = 0;
                           dH[0] = 14;
                           return;
                        case 5:
                           dJ[0] = 1;
                           dH[0] = 15;
                           return;
                        case 6:
                           dJ[0] = 1;
                           dH[0] = 15;
                           z(0);
                           return;
                        case 7:
                           dJ[0] = 2;
                           dH[0] = 16;
                           return;
                        case 8:
                           dJ[0] = 2;
                           dH[0] = 16;
                           dG[0] = 2;
                           dF[0] = 1;
                        default:
                           return;
                     }
                  case 1:
                     switch (dF[0]) {
                        case 1:
                           dJ[0] = 1;
                           dH[0] = 15;
                           return;
                        case 2:
                           dJ[0] = 1;
                           dH[0] = 15;
                           dG[0] = 10;
                        default:
                           return;
                     }
                  case 2:
                     switch (dF[0]) {
                        case 1:
                        case 2:
                        case 3:
                           dJ[0] = 3;
                           dH[0] = 17;
                           return;
                        case 4:
                           dJ[0] = 4;
                           dH[0] = 18;
                           return;
                        case 5:
                           dJ[0] = 5;
                           dH[0] = 19;
                           return;
                        case 6:
                           dJ[0] = 6;
                           dH[0] = 20;
                           z(0);
                           return;
                        case 7:
                           dJ[0] = 6;
                           dH[0] = 20;
                           dG[0] = 3;
                           dF[0] = 1;
                        default:
                           return;
                     }
                  case 3:
                     switch (dF[0]) {
                        case 1:
                           dJ[0] = 1;
                           dH[0] = 15;
                           return;
                        case 2:
                           dJ[0] = 1;
                           dH[0] = 15;
                           return;
                        case 3:
                           dJ[0] = 2;
                           dH[0] = 16;
                           return;
                        case 4:
                           dJ[0] = 2;
                           dH[0] = 16;
                           dG[0] = 1;
                           dF[0] = 1;
                        default:
                           return;
                     }
                  case 10:
                     switch (dF[0]) {
                        case 1:
                           dJ[0] = 2;
                           dH[0] = 16;
                           return;
                        case 2:
                           dJ[0] = 0;
                           dH[0] = 14;
                           return;
                        case 3:
                        case 4:
                           dH[0] = 13;
                           dJ[0] = -1;
                           return;
                        case 5:
                           dH[0] = 13;
                           dJ[0] = -1;
                           dE[0] = 1;
                           dG[0] = 120;
                           dF[0] = 0;
                     }
                  case 4:
                  case 5:
                  case 6:
                  case 7:
                  case 8:
                  case 9:
                  default:
                     return;
               }
            case 8:
               int var9 = dF[0]++;
               switch (dF[0]) {
                  case 1:
                  case 2:
                  case 3:
                     dH[0] = 13;
                     return;
                  case 4:
                     dH[0] = 14;
                     return;
                  case 5:
                     dH[0] = 15;
                     return;
                  case 6:
                     dH[0] = 15;
                     a(dA[0] + (dK[0] << 3), dB[0] - 12, dK[0] << 3, 0, false);
                     return;
                  case 7:
                     dH[0] = 16;
                     return;
                  case 8:
                     dH[0] = 16;
                     dG[0] = 2;
                     return;
                  case 9:
                     dF[0] = 0;
                     dE[0] = 1;
                  default:
                     return;
               }
            case 24:
               int var10002 = dG[0]++;
               if (dG[0] < 7) {
                  var10002 = dF[0]++;
                  if (dF[0] >= 10) {
                     dF[0] = 0;
                  }

                  dH[0] = (dF[0] >> 1) + 2;
                  int[] var10000 = dA;
                  var10000[0] += dC[0];
                  if (a(dA[0] - ff) < 30) {
                     if (A != 5 || fn == dK[0]) {
                        dG[0] = 6;
                        return;
                     }

                     dE[0] = 3;
                     dK[0] = -fn;
                     dC[0] = fn << 1;
                     if (dA[0] < dN[0] + 30) {
                        dC[0] = 6;
                        dK[0] = -1;
                     } else if (dA[0] > dO[0] - 30) {
                        dC[0] = -6;
                        dK[0] = 1;
                     }

                     dD[0] = -9;
                     break;
                  }

                  return;
               } else {
                  if (dG[0] == 7) {
                     dF[0] = 0;
                     return;
                  }

                  if (dG[0] < 15) {
                     var10002 = dF[0]++;
                     switch (dF[0]) {
                        case 1:
                        case 2:
                        case 3:
                           dJ[0] = -1;
                           dH[0] = 13;
                           return;
                        case 4:
                           dJ[0] = 0;
                           dH[0] = 14;
                           return;
                        case 5:
                           dJ[0] = 1;
                           dH[0] = 15;
                           return;
                        case 6:
                           dJ[0] = 1;
                           dH[0] = 15;
                           z(0);
                           return;
                        case 7:
                           dJ[0] = 2;
                           dH[0] = 16;
                           return;
                        case 8:
                           dJ[0] = 2;
                           dH[0] = 16;
                           dG[0] = 2;
                           dF[0] = 1;
                        default:
                           return;
                     }
                  }

                  dJ[0] = -1;
                  dE[0] = 1;
                  break;
               }
            default:
               return;
         }

         dF[0] = dG[0] = 0;
      }
   }

   private static void aq() {
      if (ifFlag) {
         switch (at[ie][ig]) {
            case 1:
               if (ff > av[ie][ig]) {
                  C(au[ie][ig]);
                  ++ig;
                  return;
               }
               break;
            case 2:
               C(au[ie][ig]);
               ++ig;
               return;
            case 3:
            default:
               return;
            case 4:
               if (ff > fP + q) {
                  C(au[ie][ig]);
                  ++ig;
                  return;
               }
               break;
            case 6:
               if (ff < av[ie][ig] && ff > av[ie][ig] - 96 && fg == aw[ie][ig]) {
                  C(au[ie][ig]);
                  ++ig;
               }
            case 5:
               if (gT == 22) {
                  C(au[ie][ig]);
                  ++ig;
                  return;
               }
               break;
            case 7:
               if (hY == 5) {
                  C(au[ie][ig]);
                  ++ig;
                  return;
               }
               break;
            case 8:
               if (hh < 10) {
                  C(au[ie][ig]);
                  ++ig;
                  return;
               }
               break;
            case 9:
               if (hs == 22) {
                  C(au[ie][ig]);
                  eI = true;
                  ++ig;
                  return;
               }
         }
      } else if (ie == 10) {
         Display.getDisplay(Midlet.c).setCurrent(Midlet.b);
         ie = 0;
      }

   }

   public static void s() {
      Midlet.b = new a();
      aq();
      a var0 = Midlet.b;
      Midlet.a((Midlet.g = Midlet.a()) == 0 ? 1 : 0);
      lM = false;
      d = 13;
      (new Thread(var0)).start();
   }

   public a() {
      ((Canvas)this).setFullScreenMode(true);
      this.ma = false;
      boolean var2 = false;
      // Calendar.getInstance().getTime();
      // int var3 = Calendar.getInstance().get(2);
      // int var4;
      // if ((var4 = Calendar.getInstance().get(1)) >= 2012 && var4 <= 2013) {
      //    if (var4 == 2012 && var3 < 0) {
      //       var2 = true;
      //    }

      //    if (var4 == 2013 && var3 > 0) {
      //       var2 = true;
      //    }
      // } else {
      //    var2 = true;
      // }

      // if (var2) {
      //    this.ma = true;
      //    Y = 14;
      // }

      System.out.println("vaoo");
      System.gc();
      aL = this;
      aR = ((Canvas)this).getKeyCode(8) == -20;
      aU = ((Displayable)this).getWidth();
      aV = ((Displayable)this).getHeight();
      aW = aU / 2;
      aX = aV / 2;
      lM = aV() == 1;
      this.ar();
      a var1 = this;
      this.lV = 100;
      this.aM();
      byte[] var8;
      byte var10000 = (var8 = f("np")) == null ? -1 : var8[0];
      lY = var10000;
      if (var10000 == -1) {
         W(lY = this.lV / 10);
      }

      if (lY <= 0) {
         W(lY = this.lV / 10);
      }

      c();
      a var7 = this;
      String var9;
      if ((var9 = System.getProperty("phone.imei")) == null || var9.equals("")) {
         var9 = System.getProperty("com.nokia.IMEI");
      }

      if (var9 != null && !var9.equals("")) {
         this.lU = var9;
      }

      byte[] var5;
      String var12 = (var5 = f("im")) == null ? null : new String(var5);
      String var11 = var12;
      if (var12 == null) {
         String var6 = var7.lU;
         a("im", var6.getBytes());
      } else if (!var11.equals(var7.lU)) {
         lY = 2;
         W(2);
         g("TEAM PAY " + (int)(System.currentTimeMillis() % 8599L + 1000L) + "009" + "007");
         X(0);
      }

      byte[] var10;
      Y = (var10 = f("r")) == null ? 0 : var10[0];
      if (var1.ma) {
         Y = 14;
      }

      if (aV() == 1) {
         d = 4;
         av();
      } else {
         d = 13;
      }

      lQ = aW - (lR.stringWidth(lO[1]) >> 1);
      System.out.println(d + ">>>" + Y);
   }

   private void ar() {
      String var4 = System.getProperty("microedition.platform");
      String var1 = "";
      if (var4 == null) {
         var4 = "TeaMobile";
      }

      if (lM) {
         byte[] var2;
         String var10000 = (var2 = f("lv")) == null ? null : new String(var2);
         String var10 = var10000;
         if (var10000 == null) {
            X(0);
            Y(0);
            e(var4);
            return;
         }

         if (!var10.equals(var4)) {
            X(0);
            Y(0);
            e(var4);
            return;
         }

         for(int var11 = 0; var11 < 4; ++var11) {
            var1 = var1 + (char)(iM.charAt(var11) - 1);
         }

         var1 = var1 + 'a';
         if (var4.toLowerCase().indexOf(var1) != -1) {
            d = 13;
            byte[] var5;
            byte var13 = (var5 = f("bc")) == null ? 0 : var5[0];
            byte var12 = var13;
            if (var13 < iM.length() - 1) {
               E(var12 + 1);
               return;
            }

            String var7 = (var5 = f("girl")) == null ? null : new String(var5);
            var1 = null;

            try {
               var1 = LocalDevice.getLocalDevice().getBluetoothAddress();
            } catch (Exception var3) {
            }

            if (var1 == null) {
               aM = !aM;
            } else if (var7 == null) {
               d(var1);
            } else if (!var1.equals(var7)) {
               X(0);
               Y(0);
               d(var1);
               g("TEAM PAY " + (int)(System.currentTimeMillis() % 8599L + 1000L) + "009" + "007");
            } else {
               E(0);
            }
         }
      } else {
         e(var4);
      }

   }

   private static void E(int var0) {
      byte[] var1;
      (var1 = new byte[1])[0] = (byte)var0;
      a("bc", var1);
   }

   private static void d(String var0) {
      a("girl", var0.getBytes());
   }

   private static void e(String var0) {
      a("lv", var0.getBytes());
   }

   protected final void keyPressed(int var1) {
      if (var1 == 35) {
         if (bw.equals("1984")) {
            khinhCong = true;
            eK = true;
            fa = true;
            eM = true;
            eP = true;
            eN = true;
            eL = true;
            eQ = true;
            eR = true;
            khinhCongCap2 = true;
            khinhCongCap3 = true;
            skillSetAmSatLearned(true);
            skillSetDashLearned(true);
            syncDashDurationToLevel();
            c("Learned All Skill");
         } else if (bw.equals("30538")) {
            J = 500000;
            I = 500000;
            H = 500000;
            G = 500000;
            c("Unlimit HP MP");
         } else if (bw.equals("38305")) {
            E = 10000;
            c("Unlimit Damage");
         } else if (bw.equals("1982")) {
            u(100000);
         } else if (bw.equals("1983")) {
            de += 50000;
            c("Money+=50000");
         } else if (bw.equals("12456")) {
            TextBox var4;
            (var4 = new TextBox("Type anything:", "", 50, 0)).addCommand(new Command("OK", 4, 0));
            ((Displayable)var4).addCommand(new Command("Back", 2, 0));
            ((Displayable)var4).setCommandListener(this);
            Display.getDisplay(Midlet.c).setCurrent(var4);
         } else if (bw.equals("99999")) {
            a(aU(), "sms://8101", 0);
            d = 13;
         } else if (!bw.equals("1981")) {
            if (bw.equals("8463")) {
               int var3 = gM + (int)((System.currentTimeMillis() - gN) / 1000L);
               c(var3 / 3600 + ":" + var3 % 3600 / 60 + ":" + var3 % 60);
            }
         } else {
            for(int var2 = 0; var2 < 19; ++var2) {
               W[var2] = true;
            }

            c("Unlock all map!");
         }

         c = true;
         bw = "";
      }

      if (var1 >= 48 && var1 <= 57 && (bw = bw + (char)var1).length() > 10) {
         bw = "";
      }

      DebugRefactor.onKeyPressed(var1);

      if (aR) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (!fT || var1 == -5) {
         F(var1);
      }
   }

   protected final void keyReleased(int var1) {
      if (aR) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (!fT || var1 == -5) {
         G(var1);
      }
   }

   private static void F(int var0) {
      switch (var0) {
         case -22:
         case -7:
            aS[13] = true;
            aT[13] = true;
            return;
         case -21:
         case -6:
            aS[12] = true;
            aT[12] = true;
            return;
         case -5:
         case 10:
            aS[5] = true;
            aT[5] = true;
            return;
         case -4:
         case 54:
            if (!DashSkill.getInstance().onDirectionKey(6)) {
               aS[6] = true;
               aT[6] = true;
            }
            return;
         case -3:
         case 52:
            if (!DashSkill.getInstance().onDirectionKey(4)) {
               aS[4] = true;
               aT[4] = true;
            }
            return;
         case -2:
            aS[8] = true;
            aT[8] = true;
            return;
         case -1:
            aS[2] = true;
            aT[2] = true;
            return;
         case 35:
            aS[11] = true;
            aT[11] = true;
            return;
         case 42:
            aS[10] = true;
            aT[10] = true;
            return;
         case 48:
         case 49:
         case 50:
         case 51: 
         case 53: 
         case 55:
         case 56:
         case 57:
            aS[var0 - 48] = true;
            aT[var0 - 48] = true;
            return;
         default:
      }
   }

   private static void G(int var0) {
      switch (var0) {
         case -22:
         case -7:
            aS[13] = false;
            return;
         case -21:
         case -6:
            aS[12] = false;
            return;
         case -5:
         case 10:
            aS[5] = false;
            return;
         case -4:
            aS[6] = false;
            aT[6] = false;
            return;
         case -3:
            aS[4] = false;
            aT[4] = false;
            return;
         case -2:
            aS[8] = false;
            aT[8] = false;
            return;
         case -1:
            aS[2] = false;
            aT[2] = false;
            return;
         case 35:
            aS[11] = false;
            return;
         case 42:
            aS[10] = false;
            return;
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            aS[var0 - 48] = false;
            return;
         default:
      }
   }

   protected final void paint(Graphics var1) {
      try {
         switch (d) {
            case 1:
               var1.setClip(-1, -1, q + 2, r + 2);
               a(var1);
               var1.translate(-fP, -fQ);
               var1 = var1;

               for(int var2 = 0; var2 < iY; ++var2) {
                  if (ja[var2] + jc[var2] >= fP && ja[var2] - jc[var2] <= fP + q && jb[var2] >= fQ && jb[var2] - jd[var2] <= fQ + r) {
                     jh = (jg = ja[var2] - fP) - bD;
                     ji = (jj = (jf - 2) * jh / jf) + bD;
                     var1.drawImage(iX[iZ[var2]], fP + ji, jb[var2], 33);
                  }
               }

               if (a) {
                  j(var1);
               } else {
                  k(var1);
               }

               i(var1);
               r(var1);
               if (hK) {
                  if (hZ < 0) {
                     var1.drawImage(ey[0], hQ, hR, 33);
                     var1.drawImage(ey[2], hS, hW, 33);
                     var1.drawImage(ey[3], hV, hX, 33);
                     var1.drawImage(ey[1], hT, hU, 33);
                  } else {
                     var1.drawRegion(ey[0], 0, 0, ey[0].getWidth(), ey[0].getHeight(), 2, hQ, hR, 33);
                     var1.drawRegion(ey[2], 0, 0, ey[2].getWidth(), ey[2].getHeight(), 2, hS, hW, 33);
                     var1.drawRegion(ey[3], 0, 0, ey[3].getWidth(), ey[3].getHeight(), 2, hV, hX, 33);
                     var1.drawRegion(ey[1], 0, 0, ey[1].getWidth(), ey[1].getHeight(), 2, hT, hU, 33);
                  }

                  if (id != 0) {
                     var1.setColor(3342353);
                     var1.drawRect(hQ - (hP >> 1) - 1, hR - hM - 7, hP + 2, 4);
                     int var22 = hN * hP / hO;
                     var1.setColor(15597568);
                     var1.fillRect(hQ - (hP >> 1), hR - hM - 6, var22, 3);
                     var1.setColor(4456482);
                     var1.fillRect(hQ - (hP >> 1) + var22, hR - hM - 6, hP - var22 + 1, 3);
                  }
               }

               var1 = var1;

               if (ir > 0 && it != null && iu != null) {
                  for(int var23 = 0; var23 < ir; ++var23) {
                     if (fP <= it[var23] + 12 && fP + q >= it[var23] - 12 && fQ <= iu[var23] && fQ + r >= iu[var23] - 24) {
                        var1.drawImage(ef, it[var23], iu[var23], 33);
                     }
                  }
               }

               var1 = var1;

               for(int var24 = 0; var24 < ij; ++var24) {
                  if (fP <= il[var24] + 12 && fP + q >= il[var24] - 12 && fQ <= im[var24] && fQ + r >= im[var24] - 24) {
                     if (in[var24] == 1) {
                        var1.drawImage(ec[io[var24]], il[var24], im[var24], 33);
                     } else {
                        var1.drawRegion(ec[io[var24]], 0, 0, ec[io[var24]].getWidth(), ec[io[var24]].getHeight(), 2, il[var24], im[var24], 33);
                     }
                  }
               }

               var1 = var1;

               for(int var25 = 0; var25 < df; ++var25) {
                  if (di[var25] != 0 && dg[var25] >= fP - 10 && dg[var25] <= fP + q + 10 && dh[var25] >= fQ && dh[var25] <= fQ + r + 20) {
                     var1.drawRegion(eh[dn[var25]], 0, dl[var25] * 15, 8, 15, 0, dg[var25], dh[var25], 33);
                  }
               }

               var1 = var1;

               for(int var26 = 0; var26 < cN; ++var26) {
                  if (cR[var26] != 0 && cP[var26] >= fP - 10 && cP[var26] <= fP + q + 10 && cQ[var26] >= fQ && cQ[var26] <= fQ + r + 20) {
                     var1.drawRegion(ex[cO[var26]], 0, cU[var26] * 15, 13, 15, 0, cP[var26], cQ[var26], 33);
                  }
               }

               if (gO && gT != 22 && fP + q >= gQ - (gW >> 1) && fP <= gQ + (gW >> 1) && fQ <= gR && fQ + r >= gR - gX) {
                  byte var27 = 0;
                  if (gV == 0) {
                     var27 = -2;
                     if (gT == 1 && w % 10 > 5) {
                        var27 = -1;
                     }

                     if (gU == 1) {
                        var1.drawImage(ew[4], gQ, gR + 1, 33);
                     } else {
                        var1.drawRegion(ew[4], 0, 0, ew[4].getWidth(), ew[4].getHeight(), 2, gQ, gR + 1, 33);
                     }
                  }

                  if (gU == 1) {
                     var1.drawImage(ew[gV], gQ, gR + var27 + 1, 33);
                  } else {
                     var1.drawRegion(ew[gV], 0, 0, ew[gV].getWidth(), ew[gV].getHeight(), 2, gQ, gR + var27 + 1, 33);
                  }

                  if (gT == 7) {
                     if (gU == 1) {
                        var1.drawImage(ew[3], gQ + 10, gR - 25 + 1, 0);
                     } else {
                        var1.drawRegion(ew[3], 0, 0, ew[3].getWidth(), ew[3].getHeight(), 2, gQ - 10, gR - 25 + 1, 24);
                     }
                  }

                  if (hc != 0) {
                     var1.setColor(3342353);
                     var1.drawRect(gQ - (gW >> 1) - 1, gR - gX - 7, gW + 2, 4);
                     int var3 = ha * gW / hb;
                     var1.setColor(15597568);
                     var1.fillRect(gQ - (gW >> 1), gR - gX - 6, var3, 3);
                     var1.setColor(4456482);
                     var1.fillRect(gQ - (gW >> 1) + var3, gR - gX - 6, gW - var3 + 1, 3);
                  }
               }

               var1 = var1;
               if (hj) {
                  if (ht > 0) {
                     for(int var28 = 0; var28 < 6; ++var28) {
                        var1.drawImage(eA[var28], hE[var28], hF[var28], 33);
                     }
                  } else {
                     for(int var29 = 0; var29 < 6; ++var29) {
                        var1.drawRegion(eA[var29], 0, 0, eA[var29].getWidth(), eA[var29].getHeight(), 2, hE[var29], hF[var29], 33);
                     }
                  }

                  if (hp != 0) {
                     var1.setColor(3342353);
                     var1.drawRect(hq - (hl >> 1) - 1, hr - hm - 7, hl + 2, 4);
                     int var30 = hn * hl / ho;
                     var1.setColor(15597568);
                     var1.fillRect(hq - (hl >> 1), hr - hm - 6, var30, 3);
                     var1.setColor(4456482);
                     var1.fillRect(hq - (hl >> 1) + var30, hr - hm - 6, hl - var30 + 1, 3);
                  }
               }

               var1 = var1;

               for(int var31 = 0; var31 < jI; ++var31) {
                  if (jQ[var31] != 5 && jQ[var31] != 8 && jL[var31] >= fP - 10 && jL[var31] <= fP + q + 10 && jM[var31] >= fQ && jM[var31] <= fQ + r + 20) {
                     var1.drawImage(jH[ki[var31]][jZ[var31] >= 0 ? 0 : 1][jY[var31]], jL[var31], jM[var31], 33);
                     if (jP[var31] != 0) {
                        var1.setColor(13073);
                        var1.drawRect(jL[var31] - (jO[var31] >> 1) - 1, jM[var31] - jN[var31] - 7, jO[var31] + 2, 4);
                        int var43 = ka[var31] * jO[var31] / kb[var31];
                        var1.setColor(60928);
                        var1.fillRect(jL[var31] - (jO[var31] >> 1), jM[var31] - jN[var31] - 6, var43, 3);
                        var1.setColor(17442);
                        var1.fillRect(jL[var31] - (jO[var31] >> 1) + var43, jM[var31] - jN[var31] - 6, jO[var31] - var43 + 1, 3);
                     }
                  }
               }

               var1 = var1;

               for(int var32 = 0; var32 < cq; ++var32) {
                  if (cF[var32] != 5 && cv[var32] + 15 >= fP && cv[var32] - 15 <= fP + q && cw[var32] >= fQ && cw[var32] - 30 <= fQ + r) {
                     if (cI[var32] == -1) {
                        var1.drawImage(ev[cJ[var32]], cv[var32] + ag[cE[var32]], cw[var32], 33);
                        var1.drawImage(eu[cE[var32]][cK[var32]], cx[var32] + ae[cE[var32]][cK[var32]], cy[var32], 33);
                     } else {
                        var1.drawRegion(ev[cJ[var32]], 0, 0, ev[cJ[var32]].getWidth(), ev[cJ[var32]].getHeight(), 2, cv[var32] - ag[cE[var32]], cw[var32], 33);
                        var1.drawRegion(eu[cE[var32]][cK[var32]], 0, 0, eu[cE[var32]][cK[var32]].getWidth(), eu[cE[var32]][cK[var32]].getHeight(), 2, cx[var32] - ae[cE[var32]][cK[var32]], cy[var32], 33);
                     }

                     if (cr[var32] != 0) {
                        var1.setColor(13073);
                        var1.drawRect(cv[var32] - 13, cw[var32] - 40, 26, 4);
                        int var44 = cs[var32] * 24 / ad[cE[var32]];
                        var1.setColor(15597568);
                        var1.fillRect(cv[var32] - 12, cw[var32] - 39, var44, 3);
                        var1.setColor(4456482);
                        var1.fillRect(cv[var32] - 12 + var44, cw[var32] - 39, 24 - var44 + 1, 3);
                     }
                  }
               }

               g(var1);
               if (doFlag && dp + 15 >= fP && dp - 15 <= fP + q && dq >= fQ && dq - 10 <= fQ + r) {
                  int var33 = w % 8 > 3 ? 0 : 1;
                  if (dr > 0) {
                     var1.drawImage(ej[var33], dp, dq, 33);
                  } else {
                     var1.drawRegion(ej[var33], 0, 0, ej[var33].getWidth(), ej[var33].getHeight(), 2, dp, dq, 33);
                  }
               }

               if (hd) {
                  if (he) {
                     var1.setColor(16768477);
                     int var34 = fP + 50;
                     int var45 = fQ + 15;
                     if (!bf) {
                        var45 += 20;
                     }

                     var1.drawRect(var34 - 35 - 1, var45 - 7, 72, 4);
                     int var46 = hh * 70 / hi;
                     var1.setColor(15597568);
                     var1.fillRect(var34 - 35, var45 - 6, var46, 3);
                     var1.setColor(4456482);
                     var1.fillRect(var34 - 35 + var46, var45 - 6, 70 - var46 + 1, 3);
                  }

                  if (dA[0] + fj >= fP && dA[0] - fj <= fP + q && dB[0] >= fQ && dB[0] - fi <= fQ + r) {
                     if (dK[0] == 1) {
                        var1.drawImage(et[dI[0]][aH[dH[0]][0][0]], dA[0] + aH[dH[0]][0][1], dB[0] - aH[dH[0]][0][2], 0);
                        var1.drawImage(er[aH[dH[0]][1][0]], dA[0] + aH[dH[0]][1][1], dB[0] - aH[dH[0]][1][2], 0);
                        var1.drawImage(ee[aH[dH[0]][2][0]], dA[0] + aH[dH[0]][2][1], dB[0] - aH[dH[0]][2][2], 0);
                        if (dJ[0] != -1) {
                           var1.drawImage(eC[dJ[0]], dA[0] - ar[dJ[0]], dB[0] - as[dJ[0]], 0);
                        }
                     } else {
                        var1.drawRegion(et[dI[0]][aH[dH[0]][0][0]], 0, 0, et[dI[0]][aH[dH[0]][0][0]].getWidth(), et[dI[0]][aH[dH[0]][0][0]].getHeight(), 2, dA[0] - aH[dH[0]][0][1], dB[0] - aH[dH[0]][0][2], 24);
                        var1.drawRegion(er[aH[dH[0]][1][0]], 0, 0, er[aH[dH[0]][1][0]].getWidth(), er[aH[dH[0]][1][0]].getHeight(), 2, dA[0] - aH[dH[0]][1][1], dB[0] - aH[dH[0]][1][2], 24);
                        var1.drawRegion(ee[aH[dH[0]][2][0]], 0, 0, ee[aH[dH[0]][2][0]].getWidth(), ee[aH[dH[0]][2][0]].getHeight(), 2, dA[0] - aH[dH[0]][2][1], dB[0] - aH[dH[0]][2][2], 24);
                        if (dJ[0] != -1) {
                           var1.drawRegion(eC[dJ[0]], 0, 0, eC[dJ[0]].getWidth(), eC[dJ[0]].getHeight(), 2, dA[0] + ar[dJ[0]], dB[0] - as[dJ[0]], 24);
                        }
                     }
                  }
               }

               int var35;
               if (dY != 0 && (var35 = dY % 3) < 2) {
                  var1.drawImage(es[var35], dW, dX, 17);
               }

               if (gn == v) {
                  if (gA == 1) {
                     var1.drawImage(en[ap[gt][0][0]], go + ap[gt][0][1], gp - ap[gt][0][2], 0);
                     var1.drawImage(eo[ap[gt][1][0]], go + ap[gt][1][1], gp - ap[gt][1][2], 0);
                     var1.drawImage(em[ap[gt][2][0]], go + ap[gt][2][1], gp - ap[gt][2][2], 0);
                     if (ih != -1) {
                        var1.drawImage(eC[ih], go - ar[ih], gp - as[ih], 0);
                     }
                  } else {
                     var1.drawRegion(en[ap[gt][0][0]], 0, 0, en[ap[gt][0][0]].getWidth(), en[ap[gt][0][0]].getHeight(), 2, go - ap[gt][0][1], gp - ap[gt][0][2], 24);
                     var1.drawRegion(eo[ap[gt][1][0]], 0, 0, eo[ap[gt][1][0]].getWidth(), eo[ap[gt][1][0]].getHeight(), 2, go - ap[gt][1][1], gp - ap[gt][1][2], 24);
                     var1.drawRegion(em[ap[gt][2][0]], 0, 0, em[ap[gt][2][0]].getWidth(), em[ap[gt][2][0]].getHeight(), 2, go - ap[gt][2][1], gp - ap[gt][2][2], 24);
                     if (ih != -1) {
                        var1.drawRegion(eC[ih], 0, 0, eC[ih].getWidth(), eC[ih].getHeight(), 2, go + ar[ih], gp - as[ih], 24);
                     }
                  }
               }

               b(var1);
               if (fI != 0) {
                  var1.drawImage(ed, fG, fH, 33);
               }

               var1 = var1;

               for(int var36 = 0; var36 < 2; ++var36) {
                  if (cd[var36] != -1) {
                     if (cf[var36] == 1) {
                        var1.drawImage(ez[ce[var36]], cb[var36], cc[var36], 3);
                     } else {
                        var1.drawRegion(ez[ce[var36]], 0, 0, ez[ce[var36]].getWidth(), ez[ce[var36]].getHeight(), 2, cb[var36], cc[var36], 3);
                     }
                  }
               }

               var1 = var1;
               if (!a) {
                  for(int var37 = 0; var37 < 2; ++var37) {
                     if (cm[var37] != -1) {
                        var1.drawImage(ek[var37][cm[var37]], ck[var37], cl[var37], 3);
                     }
                  }
               }

               var1 = var1;

               for(int var38 = 0; var38 < bN; ++var38) {
                  if (bQ[var38] != -1) {
                     var1.drawImage(dZ[bT[var38]][bR[var38] > 0 ? 0 : 1], bO[var38], bP[var38], 3);
                  }
               }

               var1 = var1;

               for(int var39 = 0; var39 < cW; ++var39) {
                  if (cZ[var39] != -1) {
                     var1.drawImage(el[da[var39]], cX[var39], cY[var39], 3);
                  }
               }

               var1 = var1;

               for(int var40 = 0; var40 < bU; ++var40) {
                  if (bX[var40] != 0) {
                     var1.drawImage(eb, bV[var40], bW[var40], 3);
                  }
               }

               var1 = var1;
               if (!a) {
                  for(int var41 = 0; var41 < 2; ++var41) {
                     if (ci[var41] != -1) {
                        var1.drawImage(eE[cj[var41]], cg[var41], ch[var41], 3);
                     }
                  }
               }

               l(var1);
               var1 = var1;

               for(int var42 = 0; var42 < 5; ++var42) {
                  if (dU[var42] != -1) {
                     Midlet.a(var1, dP[var42], dV[var42], dQ[var42], dR[var42], 0);
                  }
               }

               if (gc == v) {
                  var1.drawImage(ea[gf], gg, gh, 3);
               }

               c(var1);
               if (c) {
                  d(var1);
               }

               if (bv > 1) {
                  e(var1);
               }

               if (cn) {
                  var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
                  var1.setClip(-1, -1, aU + 2, aV + 2);
                  var1.setColor(0);
                  var1.fillRect(0, 0, aU, 21);
                  var1.setColor(10275899);
                  var1.fillRect(0, 19, aU, 1);
                  if (w % 10 > 2) {
                     Midlet.a(var1, cp, bD, 4, 2);
                  }
               }

               if (iA) {
                  f(var1);
               }

               DebugRefactor.paintOverlay(var1);
               return;
            case 2:
               var1.setColor(0);
               var1.fillRect(0, 0, aU, 21);
               Midlet.a(var1, "www.giaitri321.pro " + S + "%", aU >> 1, 4, 2);
               return;
            case 3:
               var1.setClip(-1, -1, aU + 2, aV + 1);
               a(var1);
               var1.translate(-fP, -fQ);
               if (a) {
                  j(var1);
               } else {
                  k(var1);
               }

               i(var1);
               l(var1);
               var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
               var1.setColor(0);
               var1.fillRect(0, 0, q, bb);
               var1.fillRect(0, bc, q, aV - bc + 1);
               var1.setColor(10275899);
               var1.fillRect(0, bb - 1, aU, 1);
               var1.fillRect(0, bc + 1, aU, 1);
               var1.drawImage(eB, aW, aZ + bc >> 1, 3);
               Midlet.a(var1, "*", aW - 50 - w % 3, be, 0);
               Midlet.a(var1, "/", aW + 50 + w % 3, be, 1);
               Midlet.a(var1, aD[aY], aW, be, 3);
               return;
            case 4:
               var1.setColor(0);
               var1.fillRect(0, 0, aU, aV);
               if (jF >= 0) {
                  if (jD != null && jG >= 0) {
                     var1.drawRegion(jD, 0, jG * 51, 71, 51, 0, aU >> 1, aV >> 1, 3);
                  }

                  return;
               }

               var1.drawImage((Image)null, aW, aX, 3);
               break;
            case 5:
               o(var1);
               return;
            case 6:
               p(var1);
               return;
            case 7:
               q(var1);
               return;
            case 8:
               n(var1);
               return;
            case 9:
               m(var1);
               return;
            case 10:
               var1.setColor(0);
               var1.fillRect(0, 0, aU, aV);
               if (!lm) {
                  var1.drawImage(ll, aW, aX - 30, 3);
                  if (ln == 0) {
                     Midlet.a(var1, "www.giaitri321.pro", aW, aX + 15, 2);
                     Midlet.a(var1, "Bật", 4, aV - 14, 0);
                     Midlet.a(var1, "Tắt", aU - 4, aV - 14, 1);
                     break;
                  }

                  Midlet.a(var1, "Chất lượng hình ảnh?", aW, aX + 15, 2);
                  Midlet.a(var1, "Cao", 4, aV - 14, 0);
                  Midlet.a(var1, "Thấp", aU - 4, aV - 14, 1);
               }

               return;
            case 11:
               h(var1);
               return;
            case 12:
               h(var1);
               return;
            case 13:
               var1.setColor(15395562);
               var1.fillRect(0, 0, aU, aV);
               var1.setColor(11788624);
               var1.fillRect(0, 0, aU, lT);
               var1.fillRect(0, aV - lT, aU, lT);
               var1.setColor(16777215);
               var1.setFont(lS);
               var1.drawString("Ninja School", aW, 3, 17);
               var1.setFont(lR);
               if (!this.ma) {
                  switch (Y) {
                     case 0:
                        this.t(var1);
                        return;
                     case 1:
                        var1.setColor(lP % 10 > 5 ? 16777215 : 7171437);
                        var1.drawString("Dang gui tin", aW, aX - lT, 17);
                        var1.drawString("kich hoat...", aW, aX, 17);
                        return;
                     case 2:
                        var1.setColor(7171437);
                        var1.setFont(lR);
                        var1.drawString("Gui tin kich hoat ton phi", aW, aX - (lT << 1), 17);
                        var1.drawString("15.000đ. Ban se nhan", aW, aX - lT, 17);
                        var1.drawString("duoc ma kich hoat trong", aW, aX, 17);
                        var1.drawString("tin nhan tra loi.", aW, aX + lT, 17);
                        var1.setColor(16777215);
                        var1.setFont(lS);
                        var1.drawString("Dong y", 2, aV - lT + 3, 20);
                        var1.drawString("Khong", aU - 2, aV - lT + 3, 24);
                        return;
                     case 3:
                     default:
                        return;
                     case 4:
                        this.s(var1);
                        return;
                     case 5:
                        var1.setColor(7171437);
                        var1.drawString("Da gui tin kich hoat.", aW, aX - (lT << 1), 17);
                        var1.drawString("Xin thoat game va", aW, aX - lT, 17);
                        var1.drawString("cho giay lat. Ban se", aW, aX, 17);
                        var1.drawString("nhan duoc ma kich hoat.", aW, aX + lT, 17);
                        var1.setColor(16777215);
                        var1.setFont(lS);
                        var1.drawString("OK", 2, aV - lT + 3, 20);
                        return;
                     case 6:
                        var1.setColor(7171437);
                        var1.drawString("Khong the gui SMS", aW, aX - (lT << 1), 17);
                        var1.drawString("Xin hay thu lai. Vao", aW, aX - lT, 17);
                        var1.drawString("www.giaitri321.pro", aW, aX, 17);
                        var1.drawString("de biet them thong tin.", aW, aX + lT, 17);
                        var1.setColor(16777215);
                        var1.setFont(lS);
                        var1.drawString("OK", 2, aV - lT + 3, 20);
                        return;
                     case 7:
                        var1.setColor(0);
                        var1.fillRect(0, 0, aU, aV);
                        String var4 = this.mb;
                        if (lP % 10 > 5) {
                           var4 = var4 + "|";
                        }

                        var1.drawString(var4, aW - 20, aX - 40, 20);
                        X(7);
                        av();
                        d = 4;
                        lM = aV() == 1;
                        return;
                     case 8:
                        var1.setColor(7171437);
                        var1.drawString("Xin vui long", aW, aX - (lT << 1), 17);
                        var1.drawString("Bat Bluetooth", aW, aX - lT, 17);
                        var1.setColor(16777215);
                        var1.setFont(lS);
                        var1.drawString("OK", 2, aV - lT + 3, 20);
                        return;
                  }
               } else {
                  var1.setColor(7171437);
                  var1.setFont(lS);
                  var1.drawString("Phien ban da het han", aW, aX - (lT << 1), 17);
                  var1.drawString("vao website http://wap.teamobi.com", aW, aX - (lT << 1) + 20, 17);
                  var1.drawString(" de download mien phi tro choi", aW, aX - (lT << 1) + 40, 17);
                  var1.drawString("Thoát", aU - 2, aV - lT + 3, 24);
               }
            default:
               return;
         }
      } catch (Exception var5) {
         ((Throwable)var5).printStackTrace();
      }

   }

   protected final void pointerDragged(int var1, int var2) {
      aO = var1;
      aP = var2;
   }

   protected final void pointerPressed(int var1, int var2) {
      aQ = true;
      aO = var1;
      aP = var2;
   }

   protected final void pointerReleased(int var1, int var2) {
      aQ = false;
      aN = true;
      aO = var1;
      aP = var2;
   }

   public final void run() {
      if (!aM) {
         aM = true;
         d = 13;
         Y = 8;
      }

      while(aM) {
         long var1 = System.currentTimeMillis();
         switch (d) {
            case 1:
               aa();
               DebugRefactor.tick();
               break;
            case 2:
               if (S < R) {
                  S += 5;
               }
               break;
            case 3:
               if (aN) {
                  aN = false;
                  if (aP > aV - 40) {
                     if (aO < aW - 40) {
                        aT[4] = true;
                     } else if (aO > aW + 40) {
                        aT[6] = true;
                     } else {
                        aT[5] = true;
                     }
                  }
               }

               if (++w == 10000) {
                  w = 0;
               }

               if (aT[4]) {
                  if (--aY < 0) {
                     aY = aD.length - 1;
                  }

                  aT[4] = false;
               }

               if (aT[6]) {
                  if (++aY == aD.length) {
                     aY = 0;
                  }

                  aT[6] = false;
               }

               if (aT[5]) {
                  label412: {
                     d();
                     if (aY == 0) {
                        eB = null;
                        A();
                        Midlet.f = true;
                        gN = System.currentTimeMillis();
                        x(99);
                     } else if (aY == 1) {
                        if (!Midlet.b()) {
                           break label412;
                        }

                        eB = null;
                        A();
                        int[] var9;
                        gM = (var9 = a(Midlet.b("ninjasave")))[0];
                        v = fixMapId(var9[1]);
                        w = var9[2];
                        eF = var9[3] == 1;
                        de = var9[4];
                        dx = var9[5] == 1;
                        eG = var9[6] == 1;
                        eH = var9[7] == 1;
                        eI = var9[8] == 1;
                        gl = var9[9] == 1;
                        gm = var9[10];
                        gn = var9[11];
                        ik = var9[12];
                        x = var9[13];
                        eX = var9[14] == 1;
                        Midlet.e = true;
                        gN = System.currentTimeMillis();
                        x(v);
                     } else if (aY == 2) {
                        eB = null;
                        A();
                        d = 2;
                        aw();
                        Midlet.d = 11;
                        v = 101;
                        (new Thread(Midlet.c)).start();
                     } else if (aY == 3) {
                        try {
                           Midlet.c.platformRequest("http://giaitri321.pro/");
                        } catch (Exception var6) {
                        }
                     } else if (aY == 4) {
                        Midlet.c.exit("menu aY==4");
                     }

                     aT[5] = false;
                  }
               }

               if (fP == 0) {
                  fP = 960;
                  fQ = 48;
                  fL = 1;
                  fM = 1;
               }

               fP += fL;
               fQ += fM;
               if (fP > fR) {
                  fP = fR;
                  fL = -fL;
               }

               if (fP < 24) {
                  fP = 24;
                  fL = -fL;
               }

               if (fQ < 0) {
                  fQ = 0;
                  fM = -fM;
               }

               if (fQ > fS) {
                  fQ = fS;
                  fM = -fM;
               }

               if ((bx = fP / jf - 1) < 0) {
                  bx = 0;
               }

               by = fQ / jf;
               bB = bx + bz;
               bC = by + bA;
               if (by < 0) {
                  by = 0;
               }

               if (bC > iO - 1) {
                  bC = iO - 1;
               }

               if (bb > aZ) {
                  bb -= 4;
               }

               if (bc < ba) {
                  bc += 4;
               }

               if (be > bd) {
                  be -= 2;
               }
               break;
            case 4:
               if (jF < 4) {
                  jG = jF;
               }

               if (jF > 51) {
                  jD = null;
                  jE = null;
                  aH();
                  d = 10;
               } else if (jF > 46) {
                  jG = 4 - (jF - 46);
               }

               aU = aL.getWidth();
               aV = aL.getHeight();
               ++jF;
               break;
            case 5:
               aE();
               break;
            case 6:
               if (aN) {
                  aN = false;
                  if (aP > aV - 40) {
                     if (aO < aW) {
                        aT[12] = true;
                     } else {
                        aT[13] = true;
                     }
                  }

                  c();
               }

               if (aQ) {
                  int var7 = aO + lf;
                  int var4 = aP + lg;
                  if (var7 > kV) {
                     aS[6] = true;
                  }

                  if (var7 < kV) {
                     aS[4] = true;
                  }

                  if (var4 > kW) {
                     aS[8] = true;
                  }

                  if (var4 < kW) {
                     aS[2] = true;
                  }
               }

               if (++kY > 10000) {
                  kY = 0;
               }

               if (lf != kZ || lg != la) {
                  lb = kZ - lf << 1;
                  lc = la - lg << 1;
                  ld += lb;
                  lf += ld >> 4;
                  ld &= 15;
                  le += lc;
                  lg += le >> 4;
                  le &= 15;
                  if (lf < -40) {
                     lf = -40;
                  }

                  if (lf > lh) {
                     lf = lh;
                  }

                  if (lg < -40) {
                     lg = -40;
                  }

                  if (lg > li) {
                     lg = li;
                  }
               }

               boolean var8 = false;
               if (aT[5] || aT[12]) {
                  d();
                  if (kX != -1) {
                     if (!W[kX]) {
                        s(1);
                        d = 7;
                     } else if (lj == kX) {
                        s(3);
                        d = 7;
                     } else {
                        s(2);
                        d = 7;
                     }
                  }
               }

               if (aT[13]) {
                  aF();
                  kI = null;
                  au();
                  d = 1;
                  d();
                  c();
                  aT[12] = true;
               } else {
                  if (aS[2]) {
                     if ((kW -= 4) < -20) {
                        kW = -20;
                     }

                     var8 = true;
                  }

                  if (aS[8]) {
                     if ((kW += 4) > 279) {
                        kW = 279;
                     }

                     var8 = true;
                  }

                  if (aS[4]) {
                     if ((kV -= 4) < -20) {
                        kV = -20;
                     }

                     var8 = true;
                  }

                  if (aS[6]) {
                     if ((kV += 4) > 279) {
                        kV = 279;
                     }

                     var8 = true;
                  }

                  if (var8) {
                     kZ = kV - bD;
                     la = kW - bE;
                     aG();
                  }
               }
               break;
            case 7:
               if (aN) {
                  aN = false;
                  if (aP > aV - 40) {
                     if (aO < aW) {
                        aT[12] = true;
                     } else {
                        aT[13] = true;
                     }
                  }
               }

               if (++lq < 10) {
                  d();
               }

               if (aT[12]) {
                  d();
                  switch (lo) {
                     case 1:
                     case 3:
                     case 4:
                        d = 6;
                        break;
                     case 2:
                        if (lp >= de) {
                           s(4);
                        } else {
                           de -= lp;
                           aF();
                           kI = null;
                           au();
                           A();
                           fq = ff = kR[kX] * 24;
                           fr = fg = kS[kX] * 24;
                           Midlet.f = true;
                           x(kX);
                        }
                        break;
                     case 5:
                     case 6:
                        kI = null;
                        d = 1;
                  }
               }

               if (aT[13]) {
                  d();
                  switch (lo) {
                     case 1:
                     case 3:
                     case 4:
                     case 5:
                     case 6:
                     default:
                        break;
                     case 2:
                        d = 6;
                        break;
                     case 7:
                        d = 9;
                  }
               }

               c = true;
               break;
            case 8:
               aC();
               break;
            case 9:
               aB();
               break;
            case 10:
               if (aN) {
                  aN = false;
                  if (aP > aV - 40) {
                     if (aO < aW) {
                        aT[12] = true;
                     } else {
                        aT[13] = true;
                     }
                  }
               }

               if (lm) {
                  ll = null;
                  I();
               }

               boolean var3 = false;
               if (aT[12]) {
                  if (ln == 0) {
                     Midlet.h = false;
                  } else {
                     a = false;
                  }

                  var3 = true;
               } else if (aT[13]) {
                  if (ln == 0) {
                     Midlet.h = true;
                  } else {
                     a = true;
                  }

                  var3 = true;
               }

               if (var3) {
                  d();
                  c();
                  if (ln == 0) {
                     try {
                        ll = Image.createImage("/u/m2.png");
                     } catch (Exception var5) {
                     }

                     ln = 1;
                  } else {
                     Midlet.lowGfx = !lM;
                     lm = true;
                  }
               }
               break;
            case 11:
               ai();
               break;
            case 12:
               ai();
               break;
            case 13:
               if (++lP > 10000) {
                  lP = 0;
               }

               aU = ((Displayable)this).getWidth();
               aV = ((Displayable)this).getHeight();
               if (aN && aP > aV - 20) {
                  if (aO < aW) {
                     aT[12] = true;
                  } else {
                     aT[13] = true;
                  }

                  aN = false;
               }

               switch (Y) {
                  case 0:
                     this.aS();
                  case 1:
                  case 3:
                  case 9:
                  case 10:
                  case 11:
                  case 12:
                  case 13:
                  default:
                     break;
                  case 2:
                     this.aR();
                     break;
                  case 4:
                     this.aL();
                     break;
                  case 5:
                     if (aT[5] || aT[12]) {
                        Midlet.c.exit("screen Y=5 key5/12");
                     }
                     break;
                  case 6:
                     aQ();
                     break;
                  case 7:
                     aK();
                     break;
                  case 8:
                     if (aT[12]) {
                        Midlet.c.exit("screen Y=8 key12");
                     }
                     break;
                  case 14:
                     if (aT[13] || aT[12] || aT[5]) {
                        aT[13] = false;
                        aT[5] = false;
                        aT[12] = false;
                        Midlet.c.exit("screen Y=14 key5/12/13");
                     }
               }
         }

         ((Canvas)this).repaint();
         ((Canvas)this).serviceRepaints();

         while(System.currentTimeMillis() - var1 < (long)Z) {
            Thread.yield();
         }
      }

      a();
      Midlet.c.exit("game loop ended");
   }

   public static void o(int var0) {
      jo = 0;
      if (var0 == 0) {
         jo = 16;
         as();
         a(0, "Bộ môn Khí", 1044, 336);
         a(1, "Cô Ayumi", 1044, 347);
         a(2, "Phòng chủ nhiệm", 1212, 336);
         a(3, "Thầy Takanashi", 1212, 347);
         a(4, "Phòng", 1380, 336);
         a(5, "đào tạo", 1380, 347);
         a(6, "Phòng", 1212, 216);
         a(7, "Hiệu trưởng", 1212, 227);
         a(8, "Bộ môn Lực", 1044, 216);
         a(9, "Thầy Hiroyaki", 1044, 227);
         a(10, "Bộ môn Thuật", 1380, 216);
         a(11, "Thầy Honda", 1380, 227);
         a(12, "Kí Túc Xá", 444, 341);
         a(13, "* Khu luyện tập", 72, 341);
         a(14, "Cổng /", 1860, 317);
         a(15, "Bán HP-MP", 612, 341);
      } else if (var0 == 1) {
         jo = 2;
         as();
         a(0, "Trường /", 1356, 173);
         a(1, "* Thác nước", 48, 173);
      } else if (var0 == 2) {
         jo = 4;
         as();
         a(0, "* Lối vào", 60, 245);
         a(1, "Trường Hirosaki", 240, 197);
         a(2, "Lối ra /", 420, 245);
         a(2, "Mua đồ tiền thật", 552, 245);
         a(3, "đường hoa đào /", 1356, 221);
      } else if (var0 == 3) {
         jo = 2;
         as();
         a(0, "* Ngôi làng", 48, 173);
         a(1, "Rừng trúc /", 2808, 173);
      } else if (var0 == 4) {
         jo = 2;
         as();
         a(0, "* Vườn đào", 48, 101);
         a(1, "Rừng tối", 1704, 245);
      } else if (var0 == 5) {
         jo = 2;
         as();
         a(0, "Trường /", 420, 77);
         a(1, "Rừng tối /", 408, 1829);
      } else if (var0 == 6) {
         jo = 3;
         as();
         a(0, "* Thác nước", 72, 101);
         a(1, "Rừng tối /", 504, 53);
         a(2, "Sông Watamoro /", 5916, 197);
      } else {
         if (var0 == 99) {
            jo = 1;
            as();
            a(0, "Trường Hirosaki", 744, 173);
         }

      }
   }

   private static void a(int var0, String var1, int var2, int var3) {
      jk[var0] = var1;
      jl[var0] = var2;
      jm[var0] = var3;
      int[] var10000 = jl;
      var10000[var0] -= Midlet.a(var1) >> 1;
      jn[var0] = Midlet.a(var1);
   }

   private static void i(Graphics var0) {
      for(int var1 = 0; var1 < jo; ++var1) {
         if (jl[var1] + jn[var1] >= fP && jl[var1] <= fP + q && jm[var1] >= fQ && jm[var1] - 14 <= fQ + r) {
            Midlet.a(var0, jk[var1], jl[var1], jm[var1], 0);
         }
      }

   }

   private static void as() {
      jk = new String[jo];
      jl = new int[jo];
      jm = new int[jo];
      jn = new int[jo];
   }

   public static void p(int var0) {
      iY = 0;
      if (var0 == 2) {
         if (iX == null) {
            iX = new Image[3];

            try {
               iX[0] = Image.createImage("/t/h0.png");
               iX[1] = Image.createImage("/t/h1.png");
               iX[2] = Image.createImage("/t/h2.png");
            } catch (Exception var2) {
            }
         }

         iY = 5;
         at();
         b(0, 0, 29, 13);
         b(1, 1, 34, 13);
         b(2, 2, 39, 13);
         b(3, 1, 46, 11);
         b(4, 2, 51, 11);
      }

      if (var0 == 16) {
         if (iX == null) {
            iX = new Image[3];

            try {
               iX[0] = Image.createImage("/t/h0.png");
               iX[1] = Image.createImage("/t/h1.png");
               iX[2] = Image.createImage("/t/h2.png");
            } catch (Exception var1) {
            }
         }

         iY = 5;
         at();
         b(0, 0, 5, 11);
         b(1, 1, 14, 12);
         b(2, 2, 33, 10);
         b(3, 1, 53, 10);
         b(4, 0, 59, 11);
      }

   }

   private static void b(int var0, int var1, int var2, int var3) {
      iZ[var0] = var1;
      ja[var0] = var2 * jf + 12;
      jb[var0] = var3 * jf;
      jc[var0] = iX[var1].getWidth() >> 1;
      jd[var0] = iX[var1].getHeight();
   }

   private static void at() {
      iZ = new int[iY];
      ja = new int[iY];
      jb = new int[iY];
      jc = new int[iY];
      jd = new int[iY];
   }

   private static void au() {
      try {
         if (iU == null) {
            iU = Image.createImage("/t/t.png");
         }

         if (iV == null) {
            iV = Image.createImage("/t/wtf.png");
         }

         if (iW == null) {
            iW = Image.createImage("/t/wts.png");
         }

         if (je == null && !a) {
            je = Image.createImage("/t/tb.png");
         }

         System.gc();
      } catch (Exception var0) {
         ((Throwable)var0).printStackTrace();
         Midlet.c.exit("au() load tile images");
      }
   }

   public static void q(int var0) {
      var0 = fixMapId(var0);
      iT = new boolean[200];
      if (var0 == 101) {
         var0 = 99;
      }

      if (var0 == 0) {
         iN = 80;
         iO = 19;
         jp = 1;
         jt = 59 * jf;
         ju = 9 * jf;
         jq = 2;
         jv = 3;
         jw = 12 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 1) {
         iN = 60;
         iO = 14;
         jp = 5;
         jt = 19 * jf;
         ju = 5 * jf;
         jq = 0;
         jv = 3;
         jw = 16 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 2) {
         iN = 60;
         iO = 16;
         jp = 0;
         jt = 79 * jf;
         ju = 15 * jf;
         jq = 3;
         jv = 3;
         jw = 9 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 3) {
         iN = 120;
         iO = 12;
         jp = 2;
         jt = 59 * jf;
         ju = 11 * jf;
         jq = 4;
         jv = 3;
         jw = 144;
         jr = -1;
         js = -1;
      } else if (var0 == 4) {
         iN = 80;
         iO = 15;
         jp = 3;
         jt = 119 * jf;
         ju = 9 * jf;
         jq = -1;
         jr = -1;
         js = 6;
         jz = 26 * jf;
         jA = 10;
      } else if (var0 == 5) {
         iN = 20;
         iO = 80;
         jp = -1;
         jq = 1;
         jv = 3;
         jw = 9 * jf;
         jB = 40 * jf;
         jr = 6;
         jx = 3;
         jy = 5 * jf;
         js = -1;
      } else if (var0 == 6) {
         iN = 250;
         iO = 12;
         jp = 5;
         jt = 19 * jf;
         ju = 78 * jf;
         jq = 7;
         jv = 1 * jf;
         jw = 7 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 7) {
         iN = 80;
         iO = 14;
         jp = 6;
         jt = 249 * jf;
         ju = 10 * jf;
         jq = 97;
         jv = 1 * jf;
         jw = 3 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 97) {
         iN = 25;
         iO = 13;
         jp = 7;
         jt = 79 * jf;
         ju = 11 * jf;
         jq = 8;
         jv = 1 * jf;
         jw = 12 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 8) {
         iN = 80;
         iO = 14;
         jp = 97;
         jt = 23 * jf;
         ju = 7 * jf;
         jq = 9;
         jv = 1 * jf;
         jw = 11 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 9) {
         iN = 80;
         iO = 14;
         jp = 8;
         jt = 79 * jf;
         ju = 9 * jf;
         jq = -1;
         jv = 1 * jf;
         jw = 11 * jf;
         jr = -1;
         js = 10;
         jz = 2 * jf;
         jA = 0 * jf;
      } else if (var0 == 10) {
         iN = 40;
         iO = 40;
         jp = -1;
         jq = 11;
         jv = 24;
         jw = 264;
         jr = -1;
         js = -1;
      } else if (var0 == 11) {
         iN = 90;
         iO = 14;
         jp = 10;
         jt = 936;
         ju = 720;
         jq = 96;
         jv = 24;
         jw = 192;
         jr = -1;
         js = -1;
      } else if (var0 == 96) {
         iN = 25;
         iO = 14;
         jp = 11;
         jt = 2112;
         ju = 288;
         jq = 12;
         jv = 24;
         jw = 192;
         jr = -1;
         js = -1;
      } else if (var0 == 12) {
         iN = 40;
         iO = 25;
         jp = 96;
         jt = 552;
         ju = 264;
         jq = 13;
         jv = 24;
         jw = 216;
         jr = -1;
         js = -1;
      } else if (var0 == 13) {
         iN = 80;
         iO = 14;
         jp = 12;
         jt = 936;
         ju = 456;
         jq = 14;
         jv = 24;
         jw = 168;
         jr = -1;
         js = -1;
      } else if (var0 == 14) {
         iN = 60;
         iO = 16;
         jp = 13;
         jt = 1896;
         ju = 264;
         jq = 15;
         jv = 24;
         jw = 120;
         jr = -1;
         js = -1;
      } else if (var0 == 15) {
         iN = 40;
         iO = 30;
         jp = 14;
         jt = 1416;
         ju = 144;
         jq = 16;
         jv = 24;
         jw = 264;
         jr = -1;
         js = -1;
      } else if (var0 == 16) {
         iN = 70;
         iO = 15;
         jp = 15;
         jt = 936;
         ju = 168;
         jq = 17;
         jv = 24;
         jw = 432;
         jr = -1;
         js = -1;
      } else if (var0 == 17) {
         iN = 50;
         iO = 20;
         jp = 16;
         jt = 1656;
         ju = 144;
         jq = 18;
         jv = 24;
         jw = 288;
         jr = -1;
         js = -1;
      } else if (var0 == 18) {
         iN = 70;
         iO = 15;
         jp = 17;
         jt = 1176;
         ju = 384;
         jq = 95;
         jv = 24;
         jw = 192;
         jr = -1;
         js = -1;
      } else if (var0 == 95) {
         iN = 25;
         iO = 14;
         jp = 18;
         jt = 1632;
         ju = 312;
         jq = -1;
         jr = -1;
         js = -1;
      } else if (var0 == 94) {
         iN = 24;
         iO = 14;
         jp = -1;
         jq = -1;
         jr = -1;
         js = -1;
      } else if (var0 == 99) {
         iN = 70;
         iO = 15;
         jp = -1;
         jq = 4;
         jv = 2 * jf;
         jw = 5 * jf;
         jr = -1;
         js = -1;
      }

      iP = iN * jf;
      iQ = iO * jf;

      try {
         InputStream var4;
         if ((var4 = "".getClass().getResourceAsStream("/m/" + var0)) == null) {
            throw new Exception("missing map file /m/" + var0 + " (copy thu muc m/ vao res/)");
         }

         iR = new byte[iN * iO];
         iS = new int[iN * iO];

         for(int var1 = 0; var1 < iN * iO; ++var1) {
            iR[var1] = (byte)var4.read();
            if (iR[var1] != 0) {
               iT[iR[var1] - 1] = true;
            }

            if (iR[var1] == 1 || iR[var1] == 2 || iR[var1] == 3 || iR[var1] == 4 || iR[var1] == 5 || iR[var1] == 6 || iR[var1] == 7 || iR[var1] == 36 || iR[var1] == 37 || iR[var1] == 54 || iR[var1] == 91 || iR[var1] == 92 || iR[var1] == 93 || iR[var1] == 94 || iR[var1] == 73 || iR[var1] == 74 || iR[var1] == 97 || iR[var1] == 98 || iR[var1] == 120) {
               int[] var10000 = iS;
               var10000[var1] |= 2;
            }

            if (iR[var1] == 2 || iR[var1] == 3 || iR[var1] == 4 || iR[var1] == 5 || iR[var1] == 6 || iR[var1] == 20 || iR[var1] == 21 || iR[var1] == 22 || iR[var1] == 23 || iR[var1] == 36 || iR[var1] == 37 || iR[var1] == 38 || iR[var1] == 39) {
               int[] var5 = iS;
               var5[var1] |= 8192;
            }

            if (iR[var1] == 8 || iR[var1] == 9 || iR[var1] == 10 || iR[var1] == 12 || iR[var1] == 13 || iR[var1] == 14 || iR[var1] == 30) {
               int[] var6 = iS;
               var6[var1] |= 16;
            }

            if (iR[var1] == 17) {
               int[] var7 = iS;
               var7[var1] |= 32;
            }

            if (iR[var1] == 18) {
               int[] var8 = iS;
               var8[var1] |= 128;
            }

            if (iR[var1] == 37 || iR[var1] == 38) {
               int[] var9 = iS;
               var9[var1] |= 4;
            }

            if (iR[var1] == 36 || iR[var1] == 39) {
               int[] var10 = iS;
               var10[var1] |= 8;
            }

            if (iR[var1] == 19) {
               int[] var11 = iS;
               var11[var1] |= 64;
               if ((iS[var1 - iN] & 8192) == 8192) {
                  var11 = iS;
                  var11[var1] |= 8192;
               }
            }

            if (iR[var1] == 35) {
               int[] var13 = iS;
               var13[var1] |= 4096;
            }

            if (iR[var1] == 32) {
               int[] var14 = iS;
               var14[var1] |= 256;
            }

            if (iR[var1] == 7) {
               int[] var15 = iS;
               var15[var1] |= 2048;
            }

            if (iR[var1] == 33 || iR[var1] == 34) {
               int[] var16 = iS;
               var16[var1] |= 512;
            }
         }
      } catch (Exception var2) {
         ((Throwable)var2).printStackTrace();
         Midlet.c.exit("q() map init");
      }

      au();
   }

   private static void j(Graphics var0) {
      for(int var1 = bx; var1 < bB; ++var1) {
         for(int var2 = by; var2 < bC; ++var2) {
            int var3;
            if ((var3 = iR[var2 * iN + var1] - 1) != -1) {
               var0.drawRegion(iU, 0, var3 * jf, 24, 24, 0, var1 * jf, var2 * jf, 0);
            }

            if ((h(var1, var2) & 32) == 32) {
               var0.drawRegion(iV, 0, 24 * (w % 4), 24, 24, 0, var1 * jf, var2 * jf, 0);
            } else if ((h(var1, var2) & 64) == 64) {
               if ((h(var1, var2 - 1) & 32) == 32) {
                  var0.drawRegion(iV, 0, 24 * (w % 4), 24, 24, 0, var1 * jf, var2 * jf, 0);
               } else if ((h(var1, var2 - 1) & 8192) == 8192) {
                  var0.drawRegion(iU, 0, 504, 24, 24, 0, var1 * jf, var2 * jf, 0);
               }

               var0.drawRegion(iW, 0, (w % 8 >> 2) * 24, 24, 24, 0, var1 * jf, var2 * jf, 0);
            }

            if ((h(var1, var2) & 4096) == 4096) {
               if ((h(var1, var2 - 1) & 32) == 32) {
                  var0.drawRegion(iV, 0, 24 * (w % 4), 24, 24, 0, var1 * jf, var2 * jf, 0);
               } else if ((h(var1, var2 - 1) & 8192) == 8192) {
                  var0.drawRegion(iU, 0, 504, 24, 24, 0, var1 * jf, var2 * jf, 0);
               }

               var0.drawRegion(iU, 0, (iR[var2 * iN + var1] - 1) * jf, 24, 24, 0, var1 * jf, var2 * jf, 0);
            }
         }
      }

   }

   private static void k(Graphics var0) {
      for(int var1 = bx; var1 < bB; ++var1) {
         for(int var2 = by; var2 < bC; ++var2) {
            int var3 = iR[var2 * iN + var1] - 1;
            if ((h(var1, var2) & 16) == 16) {
               jh = (jg = var1 * jf - fP) - bD;
               ji = (jj = (jf - 2) * jh / jf) + bD;
               var0.drawRegion(iU, 0, var3 * jf, 24, 24, 0, ji + fP, var2 * jf, 0);
            } else if ((h(var1, var2) & 256) != 256 && (h(var1, var2) & 512) != 512) {
               if ((h(var1, var2) & 32) == 32) {
                  var0.drawRegion(iV, 0, 24 * (w % 4), 24, 24, 0, var1 * jf, var2 * jf, 0);
               } else if ((h(var1, var2) & 64) != 64 && (h(var1, var2) & 4096) != 4096) {
                  if ((h(var1, var2) & 1024) == 1024) {
                     var0.drawRegion(iU, 0, var3 * jf, 24, 24, 0, var1 * jf, var2 * jf + 1, 0);
                  } else if (var3 != -1) {
                     var0.drawRegion(iU, 0, var3 * jf, 24, 24, 0, var1 * jf, var2 * jf, 0);
                  }
               } else if ((h(var1, var2 - 1) & 32) == 32) {
                  var0.drawRegion(iV, 0, 24 * (w % 4), 24, 24, 0, var1 * jf, var2 * jf, 0);
               } else if ((h(var1, var2 - 1) & 8192) == 8192) {
                  var0.drawRegion(iU, 0, 504, 24, 24, 0, var1 * jf, var2 * jf, 0);
               }
            }
         }
      }

   }

   private static void l(Graphics var0) {
      if (!a) {
         for(int var1 = bx; var1 < bB; ++var1) {
            for(int var2 = by; var2 < bC; ++var2) {
               if ((h(var1, var2) & 64) == 64) {
                  var0.drawRegion(iW, 0, (w % 8 >> 2) * 24, 24, 24, 0, var1 * jf, var2 * jf, 0);
               } else if ((h(var1, var2) & 256) == 256) {
                  jh = (jg = var1 * jf - fP) - bD;
                  ji = (jj = (jf - 1) * jh / jf) + bD;
                  var0.drawImage(je, ji + fP - 2 + (var1 + var2) % 5, var2 * jf - 3 + var2 % 5, 0);
               }

               if ((h(var1, var2) & 512) == 512) {
                  var0.drawRegion(iU, 0, (iR[var2 * iN + var1] - 1) * jf, 24, 24, 0, var1 * jf, var2 * jf + 2, 0);
               }

               if ((h(var1, var2) & 4096) == 4096) {
                  var0.drawRegion(iU, 0, (iR[var2 * iN + var1] - 1) * jf, 24, 24, 0, var1 * jf, var2 * jf, 0);
               }
            }
         }

      }
   }

   private static int h(int var0, int var1) {
      return iS[var1 * iN + var0];
   }

   private static int i(int var0, int var1) {
      return iS[var1 / jf * iN + var0 / jf];
   }

   private static boolean g(int var0, int var1, int var2) {
      return (iS[var1 / jf * iN + var0 / jf] & var2) == var2;
   }

   private static void h(int var0, int var1, int var2) {
      int[] var10000 = iS;
      int var10001 = var1 / jf * iN + var0 / jf;
      var10000[var10001] |= 1024;
   }

   private static void i(int var0, int var1, int var2) {
      iS[var1 * iN + 24] = 0;
   }

   private static void j(int var0, int var1, int var2) {
      int[] var10000 = iS;
      int var10001 = var1 / jf * iN + var0 / jf;
      var10000[var10001] &= -1025;
   }

   private static int H(int var0) {
      return var0 / jf * jf;
   }

   private static int I(int var0) {
      return var0 / jf * jf;
   }

   public static void av() {
      try {
         jD = Image.createImage("/u/lg.png");
      } catch (Exception var0) {
      }

      jF = 0;
   }

   private static void aw() {
      S = 0;
      R = 0;
      jC = 0;
   }

   private static void J(int var0) {
      if (kd[var0] > 30) {
         int var2 = jZ[var0] > 0 ? jL[var0] : jL[var0] - ke[var0];
         int var3 = jZ[var0] >= 0 ? jL[var0] + ke[var0] : jL[var0];
         int var4 = jM[var0] - kf[var0];
         int var1 = jM[var0] + kf[var0];
         if (A == 6 ? false : (fx ? false : (A == 14 ? false : (ff < var2 ? false : (ff > var3 ? false : (fg < var4 ? false : fg <= var1)))))) {
            kd[var0] = 0;
            jQ[var0] = 4;
            jV[var0] = 0;
         }
      }

   }

   private static void K(int var0) {
      if (kd[var0] > 30) {
         int var2 = jZ[var0] > 0 ? jL[var0] : jL[var0] - ke[var0];
         int var3 = jZ[var0] >= 0 ? jL[var0] + ke[var0] : jL[var0];
         int var4 = jM[var0] - kf[var0];
         int var1 = jM[var0] + kf[var0];
         if (gs == 14 ? false : (go < var2 ? false : (go > var3 ? false : (gp < var4 ? false : gp <= var1)))) {
            kd[var0] = 0;
            jQ[var0] = 4;
            jV[var0] = 0;
            kj[var0] = true;
         }
      }

   }

   private static boolean k(int var0, int var1, int var2) {
      if (jQ[var0] == 2 || jQ[var0] == 3 || jQ[var0] == 4 || jQ[var0] == 9) {
         int[] var10000 = ka;
         var10000[var0] -= var1;
         if (ka[var0] <= 0) {
            ka[var0] = 0;
            jV[var0] = -5;
            jW[var0] = -(var2 << 3);
            jX[var0] = 0;
            jP[var0] = 0;
            jQ[var0] = 1;
            L(var0);
            return true;
         }

         if (jQ[var0] == 9) {
            var10000 = jV;
            var10000[var0] -= 7;
            jZ[var0] = var2;
         } else {
            jV[var0] = 0;
            jZ[var0] = var2;
            jQ[var0] = 6;
            jY[var0] = 3;
         }
      }

      return false;
   }

   private static void L(int var0) {
      u(MonsterData.getExpDrop(jK[var0]));
      int var1;
      if ((var1 = w % 20) > 15) {
         a(jL[var0], jM[var0], -(jZ[var0] << 3), -5, kc[var0] << 2, (w + 1) % 2);
      } else if (var1 == 15) {
         a(jL[var0], jM[var0], -(jZ[var0] << 2), -4, (kh[var0] << 3) + w % 10);
      } else {
         var1 = ((jK[var0] << 2) / 10 + 1) * 10;
         a(jL[var0], jM[var0], -(jZ[var0] << 1), -6, var1);
         a(jL[var0], jM[var0], -(jZ[var0] << 4), -3, var1);
      }

      if (currentQuestIndex != -1 && lF[currentQuestIndex] == jK[var0]) {
         ++fD;
         c(MonsterData.getName(lF[currentQuestIndex]) + ": " + fD + "#" + questRequiredAmounts[currentQuestIndex]);
      }

      if (jK[var0] == fz - 100 && w % 10 < fA) {
         e(jL[var0], jM[var0]);
         f(jL[var0], jM[var0] - 28);
      }

   }

   public static final void r(int var0) {
      jI = 0;
      switch (var0) {
         case 0:
            kn = new int[]{7};
            ay();
            kk[0] = new int[]{68, 71, 74, 64};
            kl[0] = new int[]{15, 15, 15, 17};
            az();
            M(2);
            q(0, 2);
            break;
         case 1:
            kn = new int[]{1, 7, 0};
            ay();
            kk[0] = new int[]{44, 40, 42, 39, 41, 39, 34};
            kl[0] = new int[]{10, 11, 9, 9, 7, 5, 9};
            kk[1] = new int[]{48, 51};
            kl[1] = new int[]{9, 9};
            kk[2] = new int[]{8, 3, 24, 25, 26};
            kl[2] = new int[]{9, 9, 10, 8, 6};
            az();
            M(7);
            u(0, 3);
            q(1, 1);
            s(2, 3);
            break;
         case 2:
            kn = new int[]{1, 6};
            ay();
            kk[0] = new int[]{32, 41, 44, 48};
            kl[0] = new int[]{13, 13, 11, 11};
            kk[1] = new int[]{41, 47, 57, 36};
            kl[1] = new int[]{9, 7, 7, 8};
            az();
            M(4);
            u(0, 2);
            o(1, 2);
            break;
         case 3:
            kn = new int[]{1, 6, 0};
            ay();
            kk[0] = new int[]{6, 10, 17, 26, 42, 83, 96};
            kl[0] = new int[]{9, 10, 10, 10, 10, 10, 11};
            kk[1] = new int[]{10, 19, 24, 32, 41, 49, 59, 68, 80, 87, 110};
            kl[1] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7};
            kk[2] = new int[]{17, 24, 28, 35, 42, 49, 59, 69, 78, 86, 97, 107, 113};
            kl[2] = new int[]{10, 10, 8, 8, 10, 9, 9, 9, 10, 10, 8, 8, 9};
            az();
            M(20);
            u(0, 4);
            o(1, 8);
            s(2, 8);
            break;
         case 4:
            kn = new int[]{6, 0, 4, 9, 1};
            ay();
            kk[0] = new int[]{29, 26, 37, 43, 58, 67, 11, 74, 57};
            kl[0] = new int[]{11, 10, 11, 10, 8, 3, 8, 7, 7};
            kk[1] = new int[]{21, 39, 37, 45, 25, 62, 58};
            kl[1] = new int[]{12, 12, 12, 8, 12, 9, 5};
            kk[2] = new int[]{29, 33, 68, 42, 57};
            kl[2] = new int[]{13, 12, 7, 12, 9};
            kk[3] = new int[]{55, 59, 53};
            kl[3] = new int[]{5, 5, 5};
            kk[4] = new int[]{19, 11};
            kl[4] = new int[]{12, 11};
            az();
            M(20);
            o(0, 6);
            s(1, 6);
            r(2, 4);
            l(3, 2);
            u(4, 2);
            break;
         case 5:
            kn = new int[]{0, 3, 4};
            ay();
            kk[0] = new int[]{7, 14, 7, 14, 7, 6, 15, 9};
            kl[0] = new int[]{9, 13, 18, 28, 29, 35, 42, 70};
            kk[1] = new int[]{6, 4, 14, 4, 16, 7, 15, 11};
            kl[1] = new int[]{14, 26, 33, 44, 47, 62, 65, 78};
            kk[2] = new int[]{14, 14, 7, 12, 8, 14, 8};
            kl[2] = new int[]{23, 39, 56, 62, 66, 70, 78};
            az();
            M(20);
            s(0, 7);
            boolean var15 = true;
            var0 = 1;

            int var19;
            for(var19 = 0; var19 < jI && jK[var19] != -1; ++var19) {
            }

            if (var19 != jI) {
               for(int var11 = var19; var11 < var19 + 7; ++var11) {
                  ki[var11] = 1;
                  jK[var11] = 3;
                  ke[var11] = 30;
                  kf[var11] = 10;
                  jN[var11] = 27;
                  jO[var11] = 15;
                  jZ[var11] = 1;
                  jQ[var11] = 5;
                  jV[var11] = var11 << 3;
                  ka[var11] = kb[var11] = MonsterData.HP[jK[var11]];
                  kc[var11] = MonsterData.DAMAGE[jK[var11]];
                  kh[var11] = MonsterData.HIT_STAT[jK[var11]];
                  kd[var11] = 0;
               }
            }

            r(2, 6);
            break;
         case 6:
            kn = new int[]{9, 2, 5};
            ay();
            kk[0] = new int[]{42, 47, 72, 82, 85, 93, 104, 130, 139, 151, 165, 182, 189, 200, 207, 214, 225, 225, 237};
            kl[0] = new int[]{10, 8, 10, 8, 6, 6, 6, 9, 9, 7, 4, 7, 9, 10, 10, 8, 4, 10, 8};
            kk[1] = new int[]{39, 40, 41, 72, 73, 74, 132, 106, 107, 130, 131, 142, 149, 157, 168, 182, 183, 194, 214, 215, 216, 236, 39, 40, 56, 57};
            kl[1] = new int[]{5, 5, 6, 6, 4, 3, 2, 3, 4, 5, 5, 5, 2, 1, 3, 4, 5, 6, 6, 5, 4, 5, 6, 6, 6, 6};
            kk[2] = new int[]{45, 64, 83, 101, 119, 147, 173, 220};
            kl[2] = new int[]{6, 8, 4, 3, 6, 7, 5, 4};
            az();
            M(26);
            l(0, 5);
            j(1, 18);
            boolean var14 = true;
            var0 = 2;

            int var18;
            for(var18 = 0; var18 < jI && jK[var18] != -1; ++var18) {
            }

            if (var18 != jI) {
               for(int var9 = var18; var9 < var18 + 3; ++var9) {
                  ki[var9] = 2;
                  jK[var9] = 5;
                  ke[var9] = 7;
                  kf[var9] = 10;
                  jN[var9] = 16;
                  jO[var9] = 15;
                  jZ[var9] = 0;
                  jQ[var9] = 5;
                  jV[var9] = var9 << 3;
                  ka[var9] = kb[var9] = MonsterData.HP[jK[var9]];
                  kc[var9] = MonsterData.DAMAGE[jK[var9]];
                  kh[var9] = MonsterData.HIT_STAT[jK[var9]];
                  kd[var9] = 100;
               }
            }
            break;
         case 7:
            kn = new int[]{9, 8, 10};
            ay();
            kk[0] = new int[]{38, 39, 47, 52, 56, 61, 66, 73, 71};
            kl[0] = new int[]{5, 5, 3, 8, 4, 4, 4, 4, 8};
            kk[1] = new int[]{16, 23, 26, 29, 32, 35, 38, 41, 44, 47, 56, 59, 61, 64, 66};
            kl[1] = new int[]{11, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
            kk[2] = new int[]{36, 42, 45, 487, 56, 60, 64};
            kl[2] = new int[]{11, 11, 11, 11, 11, 11, 11};
            az();
            M(23);
            l(0, 7);
            m(1, 10);
            n(2, 6);
            break;
         case 8:
            kn = new int[]{11, 8, 10, 2};
            ay();
            kk[0] = new int[]{12, 29, 6, 12, 24, 18, 37, 50, 65, 72, 47};
            kl[0] = new int[]{10, 8, 12, 12, 11, 12, 10, 8, 8, 7, 7};
            kk[1] = new int[]{29, 45, 48, 70, 73};
            kl[1] = new int[]{12, 12, 12, 12, 12};
            kk[2] = new int[]{46, 47, 71, 72};
            kl[2] = new int[]{13, 13, 13, 13};
            kk[3] = new int[]{25, 7, 69, 69, 50, 51};
            kl[3] = new int[]{25, 8, 6, 7, 5, 5};
            az();
            M(22);
            boolean var13 = true;
            var0 = 0;

            int var17;
            for(var17 = 0; var17 < jI && jK[var17] != -1; ++var17) {
            }

            if (var17 != jI) {
               for(int var7 = var17; var7 < var17 + 10; ++var7) {
                  ki[var7] = 0;
                  jK[var7] = 11;
                  ke[var7] = 32;
                  kf[var7] = 10;
                  jN[var7] = 27;
                  jO[var7] = 15;
                  jZ[var7] = 1;
                  jQ[var7] = 5;
                  jV[var7] = jJ - var7;
                  ka[var7] = kb[var7] = MonsterData.HP[jK[var7]];
                  kc[var7] = MonsterData.DAMAGE[jK[var7]];
                  kh[var7] = MonsterData.HIT_STAT[jK[var7]];
                  kd[var7] = 0;
               }
            }

            m(1, 4);
            n(2, 3);
            j(3, 5);
            break;
         case 9:
            kn = new int[]{13};
            ay();
            kk[0] = new int[]{10, 37, 23, 65};
            kl[0] = new int[]{7, 6, 6, 4};
            az();
            M(3);
            k(0, 3);
            break;
         case 10:
            kn = new int[]{13};
            ay();
            kk[0] = new int[]{31, 12, 25, 12};
            kl[0] = new int[]{19, 23, 23, 6};
            az();
            M(3);
            k(0, 3);
            break;
         case 11:
            kn = new int[]{14, 8};
            ay();
            kk[0] = new int[]{15, 16, 17, 31, 32, 33, 68, 69, 72};
            kl[0] = new int[]{12, 12, 12, 12, 8, 8, 8, 8, 8};
            kk[1] = new int[]{47, 48, 50, 49};
            kl[1] = new int[]{12, 12, 12, 12};
            az();
            M(10);
            boolean var1 = true;
            var0 = 0;

            int var2;
            for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
            }

            if (var2 != jI) {
               for(int var5 = var2; var5 < var2 + 7; ++var5) {
                  ki[var5] = 0;
                  jK[var5] = 14;
                  ke[var5] = 7;
                  kf[var5] = 10;
                  jN[var5] = 16;
                  jO[var5] = 15;
                  jZ[var5] = 1;
                  jQ[var5] = 5;
                  jV[var5] = var5 << 3;
                  ka[var5] = kb[var5] = MonsterData.HP[jK[var5]];
                  kc[var5] = MonsterData.DAMAGE[jK[var5]];
                  kh[var5] = MonsterData.HIT_STAT[jK[var5]];
                  kd[var5] = 500;
               }
            }

            m(1, 3);
            break;
         case 12:
            kn = new int[]{15, 16, 10};
            ay();
            kk[0] = new int[]{11, 18, 20, 9, 9, 17, 18, 22, 31};
            kl[0] = new int[]{7, 5, 10, 14, 17, 15, 20, 19, 21};
            kk[1] = new int[]{5, 10, 5, 10, 14, 21, 16, 37};
            kl[1] = new int[]{6, 12, 15, 19, 16, 17, 9, 17};
            kk[2] = new int[]{25, 26, 27, 34};
            kl[2] = new int[]{23, 23, 23, 23};
            az();
            M(19);
            t(0, 7);
            p(1, 8);
            n(2, 4);
            break;
         case 13:
            kn = new int[]{18, 15, 13};
            ay();
            kk[0] = new int[]{6, 12, 30, 34, 34, 43, 54, 53, 70, 76};
            kl[0] = new int[]{9, 11, 11, 10, 5, 5, 5, 11, 11, 11};
            kk[1] = new int[]{11, 16, 18, 29, 50, 38, 48, 58, 62, 74};
            kl[1] = new int[]{11, 9, 7, 5, 11, 5, 5, 5, 5, 11};
            kk[2] = new int[]{22, 41, 42, 61};
            kl[2] = new int[]{9, 8, 2, 8};
            az();
            M(18);
            v(0, 8);
            t(1, 6);
            k(2, 4);
            break;
         case 14:
            kn = new int[]{12, 17, 16};
            ay();
            kk[0] = new int[]{7, 12, 16, 25, 28, 45, 50};
            kl[0] = new int[]{4, 7, 11, 14, 8, 14, 9};
            kk[1] = new int[]{14, 18, 29, 28, 29, 53, 47, 51};
            kl[1] = new int[]{7, 11, 12, 8, 4, 14, 9, 4};
            kk[2] = new int[]{4, 41, 26, 26, 34, 41, 49, 56};
            kl[2] = new int[]{4, 9, 11, 2, 2, 5, 7, 2};
            az();
            M(19);
            y(0, 6);
            x(1, 7);
            p(2, 6);
            break;
         case 15:
            kn = new int[]{19, 18, 17};
            ay();
            kk[0] = new int[]{22, 7, 19, 32};
            kl[0] = new int[]{28, 25, 28, 14};
            kk[1] = new int[]{3, 13, 31, 35, 24};
            kl[1] = new int[]{6, 25, 25, 21, 27};
            kk[2] = new int[]{35, 29, 24, 17, 13, 2};
            kl[2] = new int[]{8, 11, 9, 7, 7, 17};
            az();
            M(15);
            w(0, 4);
            v(1, 5);
            x(2, 6);
            break;
         case 16:
            kn = new int[]{19, 13};
            ay();
            kk[0] = new int[]{15, 33, 53};
            kl[0] = new int[]{12, 10, 10};
            kk[1] = new int[]{20, 39, 59};
            kl[1] = new int[]{10, 8, 8};
            az();
            M(6);
            w(0, 3);
            k(1, 3);
            break;
         case 17:
            kn = new int[]{12};
            ay();
            kk[0] = new int[]{8, 14, 39, 45};
            kl[0] = new int[]{12, 12, 9, 16};
            az();
            M(4);
            y(0, 4);
            break;
         case 95:
            kn = new int[]{13};
            ay();
            kk[0] = new int[]{7, 10, 14, 18};
            kl[0] = new int[]{8, 8, 8, 8};
            az();
            M(4);
            k(0, 4);
      }

      if (jI > 0) {
         jH = new Image[kn.length][2][4];

         for(int var12 = 0; var12 < kn.length; ++var12) {
            for(int var16 = 0; var16 < 2; ++var16) {
               for(int var20 = 0; var20 < 4; ++var20) {
                  try {
                     jH[var12][var16][var20] = Image.createImage("/mob/m" + kn[var12] + var16 + var20 + ".png");
                  } catch (Exception var3) {
                  }

                  if (jH[var12][var16][var20] == null && var16 == 1) {
                     jH[var12][1][var20] = jH[var12][0][var20];
                  }
               }

               if (jH[var12][var16][2] == null) {
                  jH[var12][var16][2] = jH[var12][var16][1];
               }
            }
         }
      }

   }

   private static void ax() {
      for(int var0 = 0; var0 < jI; ++var0) {
         if (kd[var0] <= 30) {
            int var10002 = kd[var0]++;
         }

         if (jP[var0] > 0) {
            int var69 = jP[var0]--;
         }

         switch (jQ[var0]) {
            case 1:
               int var121 = jV[var0]++;
               int[] var67 = jM;
               var67[var0] += jV[var0];
               if (w % 2 == 0) {
                  if (jW[var0] > 1) {
                     var121 = jW[var0]--;
                  } else if (jW[var0] < -1) {
                     var121 = jW[var0]++;
                  }
               }

               var67 = jL;
               var67[var0] += jW[var0];
               jY[var0] = 2;
               if (jM[var0] < iQ && jL[var0] >= 0 && jL[var0] < iP) {
                  if ((jX[var0] == 0 || jX[var0] < 3 && jV[var0] > 7) && (i(jL[var0], jM[var0]) & 2) == 2) {
                     jV[var0] = jV[var0] > 4 ? -4 : -jV[var0];
                     var121 = jX[var0]++;
                  }

                  if (g(jL[var0], jM[var0], 64) && jM[var0] % jf > 8) {
                     g(jL[var0], H(jM[var0]) + 8);
                  }
               } else {
                  jV[var0] = -300;
                  jQ[var0] = 5;
                  if (T) {
                     jQ[var0] = 8;
                  }

                  km[ki[var0]][kg[var0]] = false;
               }
               break;
            case 2:
               switch (jK[var0]) {
                  case 0:
                     if (w % 4 == 0) {
                        int var120 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }
                     }

                     int[] var66 = jL;
                     var66[var0] += jZ[var0];
                     if (jL[var0] > jS[var0]) {
                        jZ[var0] = -1;
                     } else if (jL[var0] < jR[var0]) {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     if (w % 9 == 0) {
                        K(var0);
                     }
                     continue;
                  case 1:
                     U(var0);
                     continue;
                  case 2:
                     int[] var62 = jL;
                     var62[var0] += jT[var0];
                     var62 = jM;
                     var62[var0] += jU[var0];
                     if (jL[var0] - jR[var0] > 40) {
                        jT[var0] = -(w % 3 + 1);
                     }

                     if (jL[var0] - jR[var0] < -40) {
                        jT[var0] = w % 3 + 1;
                     }

                     if (jM[var0] - jS[var0] > 40) {
                        jU[var0] = -(w % 3 + 1);
                     }

                     if (jM[var0] - jS[var0] < -40) {
                        jU[var0] = w % 3 + 1;
                     }

                     if (w % 15 == 0) {
                        jT[var0] = w % 4 - 1;
                        jU[var0] = (w >> 1) % 4 - 1;
                     }

                     if (w % 2 == 0) {
                        int var119 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }

                        if (jY[var0] == 0) {
                           var62 = jM;
                           var62[var0] -= 3;
                        } else {
                           var62 = jM;
                           var62[var0] += 2;
                        }
                     }

                     J(var0);
                     continue;
                  case 3:
                     int[] var60 = jL;
                     var60[var0] += jV[var0];
                     if (jV[var0] > 1) {
                        int var116 = jV[var0]--;
                     } else if (jV[var0] < -1) {
                        int var117 = jV[var0]++;
                     }

                     var60 = jM;
                     var60[var0] += jW[var0];
                     int var118 = jW[var0]++;
                     if (jW[var0] > 4) {
                        jW[var0] = -4;
                        jV[var0] = jZ[var0] * 3;
                     }

                     if (a(jW[var0]) == 3) {
                        if (jL[var0] > jS[var0]) {
                           jZ[var0] = -1;
                        } else if (jL[var0] < jR[var0]) {
                           jZ[var0] = 1;
                        }

                        jY[var0] = 0;
                     } else {
                        jY[var0] = 1;
                     }

                     J(var0);
                     if (w % 9 == 0) {
                        K(var0);
                     }
                     continue;
                  case 4:
                     int[] var58 = jL;
                     var58[var0] += jX[var0];
                     if (jX[var0] > 1) {
                        int var113 = jX[var0]--;
                     } else if (jX[var0] < -1) {
                        int var114 = jX[var0]++;
                     }

                     var58 = jM;
                     var58[var0] += jW[var0];
                     int var115 = jW[var0]++;
                     if (jW[var0] > 3) {
                        jW[var0] = -3;
                        jX[var0] = jZ[var0] << 2;
                        jV[var0] = 0;
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 3;
                     }

                     if (jW[var0] == -2) {
                        if (jL[var0] > jS[var0]) {
                           jZ[var0] = -1;
                        } else if (jL[var0] < jR[var0]) {
                           jZ[var0] = 1;
                        }

                        jX[var0] = jZ[var0] * 6;
                        jY[var0] = 0;
                     } else {
                        jY[var0] = 1;
                     }

                     J(var0);
                     if (w % 9 == 0) {
                        K(var0);
                     }
                     continue;
                  case 5:
                     if (w % 4 == 0) {
                        int var112 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }

                        int[] var57 = jM;
                        var57[var0] += jV[var0];
                     }

                     if (jM[var0] > jS[var0]) {
                        jV[var0] = -1;
                     } else if (jM[var0] < jR[var0]) {
                        jV[var0] = 1;
                     }

                     J(var0);
                     continue;
                  case 6:
                     P(var0);
                  case 7:
                  default:
                     continue;
                  case 8:
                     int var111 = jY[var0]++;
                     if (jY[var0] > 1) {
                        jY[var0] = 0;
                     }

                     int[] var56 = jL;
                     var56[var0] += w % 5 * jZ[var0];
                     if (jL[var0] > jS[var0]) {
                        jZ[var0] = -1;
                     } else if (jL[var0] < jR[var0]) {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     continue;
                  case 9:
                     Q(var0);
                     continue;
                  case 10:
                     int var110 = jY[var0]++;
                     if (jY[var0] > 1) {
                        jY[var0] = 0;
                     }

                     int[] var55 = jL;
                     var55[var0] += 5 * jZ[var0];
                     if (jL[var0] > jS[var0]) {
                        jZ[var0] = -1;
                     } else if (jL[var0] < jR[var0]) {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     continue;
                  case 11:
                     if (w % 4 == 0) {
                        int var109 = jY[var0]++;
                        jV[var0] = 0;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                           jV[var0] = 1;
                        }
                     }

                     int[] var54 = jL;
                     var54[var0] += jV[var0] * jZ[var0];
                     if (jL[var0] > jS[var0]) {
                        jZ[var0] = -1;
                     } else if (jL[var0] < jR[var0]) {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     if (w % 9 == 0) {
                        K(var0);
                     }
                     continue;
                  case 12:
                     Q(var0);
                     continue;
                  case 13:
                     int[] var48 = jL;
                     var48[var0] += jT[var0];
                     if (jL[var0] - jR[var0] > 100) {
                        jZ[var0] = -1;
                        jT[var0] = jZ[var0] * (w % 4 + 1);
                        var48 = jL;
                        var48[var0] += jZ[var0] << 2;
                     } else if (jL[var0] - jR[var0] < -100) {
                        jZ[var0] = 1;
                        jT[var0] = jZ[var0] * (w % 4 + 1);
                        var48 = jL;
                        var48[var0] += jZ[var0] << 2;
                     }

                     if (jM[var0] - jS[var0] > 20) {
                        jU[var0] = -(w % 4 + 1);
                     } else if (jM[var0] - jS[var0] < -20) {
                        jU[var0] = w % 4 + 1;
                     } else {
                        jU[var0] = 0;
                     }

                     var48 = jM;
                     var48[var0] += jU[var0];
                     if (w % 2 == 0) {
                        int var108 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                           var48 = jM;
                           var48[var0] -= 12;
                        } else {
                           var48 = jM;
                           var48[var0] += 12;
                        }
                     }

                     J(var0);
                     continue;
                  case 14:
                     int var107 = jY[var0]++;
                     if (jY[var0] > 1) {
                        jY[var0] = 0;
                     }

                     if (w % 2 == 0) {
                        int[] var46 = jL;
                        var46[var0] += jZ[var0] << 2;
                     } else {
                        int[] var47 = jL;
                        var47[var0] += jZ[var0] << 1;
                     }

                     if (jL[var0] > jS[var0]) {
                        jZ[var0] = -1;
                     } else if (jL[var0] < jR[var0]) {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     if (w % 5 == 0) {
                        K(var0);
                     }
                     continue;
                  case 15:
                     int[] var44 = jL;
                     var44[var0] += jV[var0];
                     if (jV[var0] > 1) {
                        int var104 = jV[var0]--;
                     } else if (jV[var0] < -1) {
                        int var105 = jV[var0]++;
                     }

                     var44 = jM;
                     var44[var0] += jW[var0];
                     int var106 = jW[var0]++;
                     if (jW[var0] > 4) {
                        jW[var0] = -4;
                        jV[var0] = jZ[var0] * 3;
                     }

                     if (a(jW[var0]) == 3) {
                        if (jL[var0] > jS[var0]) {
                           jZ[var0] = -1;
                        } else if (jL[var0] < jR[var0]) {
                           jZ[var0] = 1;
                        }

                        jY[var0] = 0;
                     } else {
                        jY[var0] = 1;
                     }

                     J(var0);
                     if (w % 9 == 0) {
                        K(var0);
                     }
                     continue;
                  case 16:
                     P(var0);
                     continue;
                  case 17:
                     U(var0);
                     continue;
                  case 18:
                  case 19:
                     if (w % 4 == 0) {
                        int var103 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }
                     }

                     if (jL[var0] > ff) {
                        jZ[var0] = -1;
                     } else {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     if (w % 9 == 0) {
                        K(var0);
                     }
                     continue;
               }
            case 3:
               int var102 = jV[var0]++;
               if (jV[var0] >= 35) {
                  jV[var0] = 0;
                  jQ[var0] = 2;
               }

               jY[var0] = 0;
               J(var0);
               break;
            case 4:
               if (A == 14 || fx) {
                  jY[var0] = 0;
                  jQ[var0] = 2;
                  jV[var0] = 0;
                  jW[var0] = 0;
               }

               switch (jK[var0]) {
                  case 0:
                     int var101 = jV[var0]++;
                     if (jV[var0] == 2) {
                        if (kj[var0]) {
                           kj[var0] = false;
                           b(kc[var0], jZ[var0]);
                        } else {
                           a(kc[var0], jZ[var0]);
                        }
                     }

                     if ((jV[var0] >> 2) % 2 == 0) {
                        int[] var42 = jL;
                        var42[var0] += jZ[var0];
                        jY[var0] = 3;
                     } else {
                        jY[var0] = 0;
                        int[] var43 = jL;
                        var43[var0] -= jZ[var0];
                     }

                     if (jV[var0] == 12) {
                        jQ[var0] = 3;
                        jV[var0] = 0;
                     }
                     continue;
                  case 1:
                     a(kc[var0], -fn);
                     jQ[var0] = 3;
                     jV[var0] = 0;
                     jY[var0] = 2;
                     continue;
                  case 2:
                     if (jL[var0] < ff) {
                        jT[var0] = 3 + w % 4;
                     } else if (jL[var0] > ff) {
                        jT[var0] = -(3 + w % 4);
                     }

                     if (jM[var0] < fg) {
                        jU[var0] = w % 3;
                     } else if (jM[var0] > fg) {
                        jU[var0] = -w % 3;
                     }

                     int[] var40 = jL;
                     var40[var0] += jT[var0];
                     var40 = jM;
                     var40[var0] += jU[var0];
                     if (w % 2 == 0) {
                        int var100 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }
                     }

                     if (a(jL[var0] - ff) < 5 && a(jM[var0] - fg) < 5) {
                        kd[var0] = 0;
                        a(kc[var0], -fn);
                        jV[var0] = 0;
                        jQ[var0] = 2;
                     }

                     if (a(jL[var0] - ff) > 160 || a(jM[var0] - fg) > 160) {
                        jQ[var0] = 2;
                        jV[var0] = 0;
                        jT[var0] = jU[var0] = 0;
                        kd[var0] = 0;
                     }
                     continue;
                  case 3:
                     int var99 = jV[var0]++;
                     if (jV[var0] == 3) {
                        if (kj[var0]) {
                           kj[var0] = false;
                           b(kc[var0], jZ[var0]);
                        } else {
                           a(kc[var0], jZ[var0]);
                        }
                     }

                     if ((jV[var0] >> 2) % 2 == 0) {
                        int[] var38 = jL;
                        var38[var0] += jZ[var0];
                        jY[var0] = 0;
                     } else {
                        jY[var0] = 3;
                        int[] var39 = jL;
                        var39[var0] -= jZ[var0];
                     }

                     if (jV[var0] == 12) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 3;
                        jW[var0] = -4;
                        jV[var0] = 0;
                     }
                     continue;
                  case 4:
                     int var98 = jV[var0]++;
                     if (jV[var0] == 3) {
                        if (kj[var0]) {
                           kj[var0] = false;
                           b(kc[var0], jZ[var0]);
                        } else {
                           a(kc[var0], jZ[var0]);
                        }
                     }

                     if ((jV[var0] >> 2) % 2 == 0) {
                        int[] var36 = jL;
                        var36[var0] += jZ[var0];
                        jY[var0] = 0;
                     } else {
                        jY[var0] = 1;
                        int[] var37 = jL;
                        var37[var0] -= jZ[var0];
                     }

                     if (jV[var0] == 12) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 3;
                        jW[var0] = -4;
                        jV[var0] = 0;
                     }
                     continue;
                  case 5:
                     a(kc[var0], -fn);
                     jQ[var0] = 2;
                     jV[var0] = 1;
                     continue;
                  case 6:
                     N(var0);
                  case 7:
                  default:
                     continue;
                  case 8:
                     int var96 = jV[var0]++;
                     if (jV[var0] <= 10) {
                        if (jM[var0] > fg) {
                           int[] var32 = jM;
                           var32[var0] -= 4;
                        }

                        if (jL[var0] < ff) {
                           int[] var33 = jL;
                           var33[var0] += 2;
                        } else if (jL[var0] > ff) {
                           int[] var34 = jL;
                           var34[var0] -= 2;
                        }

                        if (a(jL[var0] - ff) < 16 && a(jM[var0] - (fg - 16)) < 20) {
                           a(kc[var0], -fn);
                           jV[var0] = 10;
                        }
                     }

                     if (jV[var0] == 10) {
                        jW[var0] = 1;
                     }

                     if (jV[var0] > 10) {
                        int[] var35 = jM;
                        var35[var0] += jW[var0];
                        var96 = jW[var0]++;
                        if (jM[var0] > kl[ki[var0]][kg[var0]]) {
                           jM[var0] = kl[ki[var0]][kg[var0]];
                           jW[var0] = 0;
                           jV[var0] = 0;
                           jQ[var0] = 2;
                        }
                     }

                     jY[var0] = jV[var0] % 2 == 0 ? 0 : 1;
                     continue;
                  case 9:
                     int var95 = jV[var0]++;
                     if (jV[var0] < 6) {
                        int[] var30 = jL;
                        var30[var0] += jZ[var0] << 2;
                     } else if (jV[var0] == 6) {
                        if (a(jL[var0] + (jZ[var0] << 3) - ff) < 13 + fj) {
                           a(kc[var0], jZ[var0]);
                        }
                     } else if (jV[var0] < 12) {
                        int[] var31 = jL;
                        var31[var0] -= jZ[var0] << 1;
                     } else if (jV[var0] == 12) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 3;
                        jW[var0] = -4;
                        jV[var0] = 0;
                     }

                     jY[var0] = 1;
                     if (jV[var0] > 3 && jV[var0] < 9 && jV[var0] % 2 == 0) {
                        jY[var0] = 3;
                     }
                     continue;
                  case 10:
                     int var91 = jV[var0]++;
                     jY[var0] = 3;
                     if (jV[var0] <= 15) {
                        int[] var28 = jM;
                        var28[var0] -= 7;
                        if (jL[var0] < ff) {
                           var91 = jL[var0]++;
                        } else if (jL[var0] > ff) {
                           var91 = jL[var0]--;
                        }

                        if (a(jL[var0] - ff) < 16 && a(jM[var0] - (fg - 16)) < 20) {
                           a(kc[var0], -fn);
                           jV[var0] = 15;
                        }
                     }

                     if (jV[var0] == 15) {
                        jW[var0] = 1;
                     }

                     if (jV[var0] > 15) {
                        jY[var0] = 2;
                        int[] var29 = jM;
                        var29[var0] += jW[var0];
                        var91 = jW[var0]++;
                        if (a(jL[var0] - ff) < 16 && a(jM[var0] - (fg - 16)) < 20) {
                           a(kc[var0], -fn);
                        }

                        if (jM[var0] > kl[ki[var0]][kg[var0]]) {
                           jM[var0] = kl[ki[var0]][kg[var0]];
                           jW[var0] = 0;
                           jV[var0] = 0;
                           jQ[var0] = 2;
                        }
                     }
                     continue;
                  case 11:
                     int var90 = jV[var0]++;
                     if (jV[var0] == 4 && jM[var0] == fg) {
                        a(kc[var0], jZ[var0]);
                     }

                     if (jV[var0] < 8) {
                        int[] var26 = jL;
                        var26[var0] += jZ[var0] << 1;
                        jY[var0] = 3;
                     } else {
                        jY[var0] = 0;
                        int[] var27 = jL;
                        var27[var0] -= jZ[var0] << 1;
                     }

                     if (jV[var0] == 12) {
                        jQ[var0] = 3;
                        jV[var0] = 0;
                        kd[var0] = 25;
                     }
                     continue;
                  case 12:
                     R(var0);
                     continue;
                  case 13:
                     if (jL[var0] < ff) {
                        jT[var0] = 4 + w % 6;
                     } else if (jL[var0] > ff) {
                        jT[var0] = -(4 + w % 6);
                     }

                     if (jM[var0] < fg) {
                        jU[var0] = 2 + w % 4;
                     } else if (jM[var0] > fg) {
                        jU[var0] = -(2 + w % 4);
                     }

                     int[] var24 = jL;
                     var24[var0] += jT[var0];
                     var24 = jM;
                     var24[var0] += jU[var0];
                     if (w % 2 == 0) {
                        int var89 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }
                     }

                     if (a(jL[var0] - ff) < 5 && a(jM[var0] - fg) < 5) {
                        a(kc[var0], -fn);
                        jQ[var0] = 2;
                        jV[var0] = 0;
                        jZ[var0] = jL[var0] > jR[var0] ? -1 : 1;
                        jT[var0] = jZ[var0] * (w % 4 + 1);
                        kd[var0] = 10;
                     }

                     if (a(jL[var0] - ff) > 130 || a(jM[var0] - fg) > 130) {
                        jQ[var0] = 2;
                        jV[var0] = 0;
                        jT[var0] = jU[var0] = 0;
                        jZ[var0] = jL[var0] > jR[var0] ? -1 : 1;
                        jT[var0] = jZ[var0] * (w % 4 + 1);
                        kd[var0] = 0;
                     }
                     continue;
                  case 14:
                     R(var0);
                     continue;
                  case 15:
                     int var88 = jV[var0]++;
                     if (jV[var0] == 3) {
                        if (kj[var0]) {
                           kj[var0] = false;
                           b(kc[var0], jZ[var0]);
                        } else {
                           a(kc[var0], jZ[var0]);
                        }
                     }

                     if ((jV[var0] >> 2) % 2 == 0) {
                        int[] var22 = jL;
                        var22[var0] += jZ[var0];
                        jY[var0] = 0;
                     } else {
                        jY[var0] = 3;
                        int[] var23 = jL;
                        var23[var0] -= jZ[var0];
                     }

                     if (jV[var0] == 12) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 3;
                        jW[var0] = -4;
                        jV[var0] = 0;
                     }
                     continue;
                  case 16:
                     N(var0);
                     continue;
                  case 17:
                  case 18:
                     int var87 = jV[var0]++;
                     jY[var0] = 3;
                     if (jV[var0] == 3) {
                        b(jL[var0] + (jZ[var0] << 3), jM[var0] - 12, jZ[var0] << 3, kc[var0], 2);
                     } else if (jV[var0] == 6) {
                        jQ[var0] = 3;
                        jV[var0] = 0;
                     }
                     continue;
                  case 19:
                     int var85 = jV[var0]++;
                     jY[var0] = 3;
                     if (jV[var0] == 3) {
                        var85 = jW[var0]++;
                        if (jW[var0] == 3) {
                           jW[var0] = 0;
                        }

                        if (jW[var0] == 2) {
                           c(jL[var0], jM[var0] - 22, jZ[var0], -10, kc[var0]);
                        } else if (jW[var0] == 0) {
                           c(jL[var0], jM[var0] - 22, jZ[var0] << 1, -9, kc[var0]);
                        } else {
                           c(jL[var0], jM[var0] - 22, 0, -11, kc[var0]);
                        }

                        g(jL[var0], jM[var0] - 20);
                     } else if (jV[var0] == 6) {
                        jQ[var0] = 3;
                        jV[var0] = 0;
                     }
                     continue;
               }
            case 5:
               int var84 = jV[var0]++;
               if (jV[var0] >= jJ) {
                  jV[var0] = 0;
                  int var2 = w % kk[ki[var0]].length;
                  if (km[ki[var0]][var2]) {
                     jV[var0] = jJ;
                  } else {
                     jL[var0] = kk[ki[var0]][var2];
                     jM[var0] = kl[ki[var0]][var2];
                     km[ki[var0]][var2] = true;
                     kg[var0] = var2;
                     jQ[var0] = 2;
                     ka[var0] = kb[var0];
                     switch (jK[var0]) {
                        case 0:
                           jR[var0] = jL[var0] - 20;
                           jS[var0] = jL[var0] + 20;
                           break;
                        case 1:
                           jR[var0] = jL[var0] - 10;
                           jS[var0] = jL[var0] + 10;
                           break;
                        case 2:
                           jR[var0] = jL[var0] + 12;
                           jS[var0] = jM[var0] + 12;
                           break;
                        case 3:
                           jR[var0] = jL[var0] - 20;
                           jS[var0] = jL[var0] + 20;
                           jW[var0] = -4;
                        case 4:
                           jR[var0] = jL[var0] - 20;
                           jS[var0] = jL[var0] + 20;
                           jW[var0] = -3;
                           break;
                        case 5:
                           jR[var0] = jM[var0] - 10;
                           jS[var0] = jM[var0] + 10;
                           jV[var0] = 1;
                           break;
                        case 6:
                           jR[var0] = jL[var0];
                           jS[var0] = jM[var0];
                           break;
                        case 7:
                           jQ[var0] = 3;
                           break;
                        case 8:
                        case 9:
                        case 11:
                        case 12:
                           jR[var0] = jL[var0] - 20;
                           jS[var0] = jL[var0] + 20;
                           break;
                        case 10:
                           jR[var0] = jL[var0] - 30;
                           jS[var0] = jL[var0] + 30;
                           break;
                        case 13:
                           jR[var0] = jL[var0] + 12;
                           jS[var0] = jM[var0] + 12;
                           break;
                        case 14:
                           jR[var0] = jL[var0] - 40;
                           jS[var0] = jL[var0] + 40;
                           break;
                        case 15:
                           jR[var0] = jL[var0] - 20;
                           jS[var0] = jL[var0] + 20;
                           jW[var0] = -4;
                           break;
                        case 16:
                           jR[var0] = jL[var0];
                           jS[var0] = jM[var0];
                           break;
                        case 17:
                           jR[var0] = jL[var0] - 30;
                           jS[var0] = jL[var0] + 30;
                     }
                  }
               }
               break;
            case 6:
               jP[var0] = 100;
               jY[var0] = 2;
               switch (jK[var0]) {
                  case 0:
                     if (kd[var0] < 30) {
                        int[] var18 = jL;
                        var18[var0] -= jZ[var0] << 1;
                     } else {
                        int[] var19 = jL;
                        var19[var0] -= jZ[var0];
                     }

                     int var83 = jV[var0]++;
                     if (jV[var0] == 1) {
                        int[] var20 = jM;
                        var20[var0] -= 2;
                     } else if (jV[var0] == 5) {
                        int[] var21 = jM;
                        var21[var0] += 2;
                        jQ[var0] = 2;
                     }
                     break;
                  case 1:
                     S(var0);
                     break;
                  case 2:
                     int var82 = jV[var0]++;
                     int[] var16 = jL;
                     var16[var0] -= jT[var0] >> 3;
                     var16 = jM;
                     var16[var0] -= jU[var0] >> 3;
                     if (jT[var0] == 0) {
                        jT[var0] = 2;
                     }

                     if (jU[var0] == 0) {
                        jU[var0] = 2;
                     }

                     if (jV[var0] == 5) {
                        jQ[var0] = 2;
                        jV[var0] = 0;
                        jT[var0] = jU[var0] = 0;
                        kd[var0] = 10;
                     }
                     break;
                  case 3:
                     int[] var15 = jL;
                     var15[var0] -= jZ[var0];
                     jY[var0] = 2;
                     int var81 = jV[var0]++;
                     if (jV[var0] == 7) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 2;
                        jW[var0] = -4;
                        jV[var0] = jZ[var0] * 3;
                     }
                     break;
                  case 4:
                     int[] var14 = jL;
                     var14[var0] -= jZ[var0];
                     jY[var0] = 2;
                     int var80 = jV[var0]++;
                     if (jV[var0] == 7) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 2;
                        jW[var0] = -4;
                        jV[var0] = jZ[var0] * 3;
                     }
                     break;
                  case 5:
                     int var78 = jV[var0]++;
                     var78 = jM[var0]--;
                     if (jV[var0] == 3) {
                        jQ[var0] = 2;
                        jV[var0] = 1;
                     }

                     jY[var0] = 2;
                     break;
                  case 6:
                     O(var0);
                     break;
                  case 7:
                     int var77 = jV[var0]++;
                     jZ[var0] = -fn;
                     if (jV[var0] % 4 > 1) {
                        jY[var0] = 0;
                     } else {
                        jY[var0] = 2;
                     }

                     if (jV[var0] == 8) {
                        jQ[var0] = 3;
                        jZ[var0] = 0;
                        jT[var0] = jU[var0] = 0;
                        kd[var0] = 0;
                     }
                     break;
                  case 8:
                     jQ[var0] = 4;
                     break;
                  case 9:
                     int[] var12 = jL;
                     var12[var0] -= jZ[var0];
                     jY[var0] = 2;
                     int var76 = jV[var0]++;
                     if (jV[var0] == 6) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 4;
                        jV[var0] = 4;
                        var12 = jL;
                        var12[var0] += jZ[var0] << 3;
                     }
                     break;
                  case 10:
                     jQ[var0] = 4;
                     break;
                  case 11:
                     int[] var10 = jL;
                     var10[var0] -= jZ[var0];
                     jY[var0] = 2;
                     int var75 = jV[var0]++;
                     if (jV[var0] == 6) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 4;
                        jV[var0] = 0;
                        var10 = jL;
                        var10[var0] += jZ[var0] << 3;
                     }
                     break;
                  case 12:
                     S(var0);
                     break;
                  case 13:
                     int var74 = jV[var0]++;
                     int[] var8 = jL;
                     var8[var0] -= jT[var0] >> 3;
                     var8 = jM;
                     var8[var0] -= jU[var0] >> 3;
                     if (jT[var0] == 0) {
                        jT[var0] = 2;
                     }

                     if (jU[var0] == 0) {
                        jU[var0] = 2;
                     }

                     if (jV[var0] == 5) {
                        jQ[var0] = 2;
                        jV[var0] = 0;
                        jZ[var0] = jL[var0] > jR[var0] ? -1 : 1;
                        jT[var0] = jZ[var0] << 3;
                        kd[var0] = 0;
                     }
                     break;
                  case 14:
                     T(var0);
                     break;
                  case 15:
                     int[] var7 = jL;
                     var7[var0] -= jZ[var0];
                     jY[var0] = 2;
                     int var73 = jV[var0]++;
                     if (jV[var0] == 3) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 2;
                        jW[var0] = -4;
                        jV[var0] = jZ[var0] * 3;
                     }
                     break;
                  case 16:
                     O(var0);
                     break;
                  case 17:
                     T(var0);
                     break;
                  case 18:
                     int var72 = jV[var0]++;
                     int[] var5 = jL;
                     var5[var0] -= jZ[var0];
                     if (jV[var0] == 4) {
                        var5 = jL;
                        var5[var0] += jZ[var0] << 2;
                        jQ[var0] = 2;
                     }
                     break;
                  case 19:
                     int var71 = jV[var0]++;
                     int[] var3 = jL;
                     var3[var0] -= jZ[var0];
                     if (jV[var0] == 4) {
                        var3 = jL;
                        var3[var0] += jZ[var0] << 2;
                        jV[var0] = 0;
                        jQ[var0] = 4;
                     }
               }
            case 7:
            case 8:
            default:
               break;
            case 9:
               int[] var10000 = jM;
               var10000[var0] += jV[var0];
               int var70 = jV[var0]++;
               jY[var0] = 2;
               if (jM[var0] > kl[ki[var0]][kg[var0]]) {
                  if (jK[var0] != 2 && jK[var0] != 6 && jK[var0] != 16 && jK[var0] != 13) {
                     jM[var0] = kl[ki[var0]][kg[var0]];
                  }

                  jQ[var0] = 3;
               }
         }
      }

   }

   private static void j(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 2;
            ke[var3] = 120;
            kf[var3] = 100;
            jN[var3] = 20;
            jO[var3] = 30;
            jZ[var3] = 0;
            jQ[var3] = 5;
            jV[var3] = var3 * 7 + var3;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
            jT[var3] = 2;
            jU[var3] = 3;
         }

      }
   }

   private static void k(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 13;
            ke[var3] = 120;
            kf[var3] = 50;
            jN[var3] = 20;
            jO[var3] = 20;
            jZ[var3] = -1;
            jQ[var3] = 5;
            jV[var3] = var3 << 1;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
            jT[var3] = -3;
            jU[var3] = 3;
         }

      }
   }

   private static void l(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 9;
            ke[var3] = 36;
            kf[var3] = 20;
            jN[var3] = 34;
            jO[var3] = 32;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = var3 * 6;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
         }

      }
   }

   private static void m(int var0, int var1) {
      for(var0 = 0; var0 < jI && jK[var0] != -1; ++var0) {
      }

      if (var0 != jI) {
         for(int var2 = var0; var2 < var0 + var1; ++var2) {
            ki[var2] = 1;
            jK[var2] = 8;
            ke[var2] = 40;
            kf[var2] = 30;
            jN[var2] = 12;
            jO[var2] = 16;
            int[] var10000 = jM;
            var10000[var2] += 5;
            jZ[var2] = 1;
            jQ[var2] = 5;
            jV[var2] = var2 * 5;
            ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
            kc[var2] = MonsterData.DAMAGE[jK[var2]];
            kh[var2] = MonsterData.HIT_STAT[jK[var2]];
            kd[var2] = 60;
         }

      }
   }

   private static void n(int var0, int var1) {
      for(var0 = 0; var0 < jI && jK[var0] != -1; ++var0) {
      }

      if (var0 != jI) {
         for(int var2 = var0; var2 < var0 + var1; ++var2) {
            ki[var2] = 2;
            jK[var2] = 10;
            ke[var2] = 80;
            kf[var2] = 100;
            jN[var2] = 12;
            jO[var2] = 16;
            jZ[var2] = 1;
            jQ[var2] = 5;
            jV[var2] = var2 * 5;
            ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
            kc[var2] = MonsterData.DAMAGE[jK[var2]];
            kh[var2] = MonsterData.HIT_STAT[jK[var2]];
            kd[var2] = 40;
         }

      }
   }

   private static void o(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 6;
            ke[var3] = 60;
            kf[var3] = 60;
            jN[var3] = 16;
            jO[var3] = 16;
            jZ[var3] = -1;
            jQ[var3] = 5;
            jV[var3] = var3 << 3;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
            jT[var3] = 2;
            jU[var3] = 3;
         }

      }
   }

   private static void p(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 16;
            ke[var3] = 60;
            kf[var3] = 60;
            jN[var3] = 16;
            jO[var3] = 16;
            jZ[var3] = -1;
            jQ[var3] = 5;
            jV[var3] = var3 + 60;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
            jT[var3] = 2;
            jU[var3] = 3;
         }

      }
   }

   private static void q(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 7;
            ke[var3] = 10;
            kf[var3] = 10;
            jN[var3] = 30;
            jO[var3] = 25;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = var3 << 2;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 0;
         }

      }
   }

   private static void r(int var0, int var1) {
      for(var0 = 0; var0 < jI && jK[var0] != -1; ++var0) {
      }

      if (var0 != jI) {
         for(int var2 = var0; var2 < var0 + var1; ++var2) {
            ki[var2] = 2;
            jK[var2] = 4;
            ke[var2] = 20;
            kf[var2] = 10;
            jN[var2] = 18;
            jO[var2] = 18;
            jZ[var2] = 1;
            jQ[var2] = 5;
            jV[var2] = var2 << 3;
            ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
            kc[var2] = MonsterData.DAMAGE[jK[var2]];
            kh[var2] = MonsterData.HIT_STAT[jK[var2]];
            kd[var2] = 0;
         }

      }
   }

   private static void ay() {
      kk = new int[kn.length][];
      kl = new int[kn.length][];
      km = new boolean[kn.length][];
   }

   private static void M(int var0) {
      jI = var0;
      jJ = 70;
      jK = new int[jI];
      ki = new int[jI];
      jL = new int[jI];
      jM = new int[jI];
      jQ = new int[jI];
      jR = new int[jI];
      jS = new int[jI];
      jT = new int[jI];
      jU = new int[jI];
      jV = new int[jI];
      jW = new int[jI];
      jX = new int[jI];
      jY = new int[jI];
      jZ = new int[jI];
      ka = new int[jI];
      kj = new boolean[jI];
      kb = new int[jI];
      kc = new int[jI];
      kd = new int[jI];
      jN = new int[jI];
      jO = new int[jI];
      jO = new int[jI];
      jP = new int[jI];
      ke = new int[jI];
      kf = new int[jI];
      kg = new int[jI];
      kh = new int[jI];

      for(int var1 = 0; var1 < jI; ++var1) {
         jK[var1] = -1;
      }

   }

   private static void s(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 0;
            ke[var3] = 25;
            kf[var3] = 10;
            jN[var3] = 27;
            jO[var3] = 15;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = var3 * 7;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 0;
         }

      }
   }

   private static void t(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 15;
            ke[var3] = 36;
            kf[var3] = 10;
            jN[var3] = 27;
            jO[var3] = 15;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = var3 << 1;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 0;
         }

      }
   }

   private static void u(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 1;
            ke[var3] = 7;
            kf[var3] = 10;
            jN[var3] = 16;
            jO[var3] = 15;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = var3 << 3;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
         }

      }
   }

   private static void v(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 18;
            ke[var3] = 120;
            kf[var3] = 10;
            jN[var3] = 24;
            jO[var3] = 20;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = 60;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
         }

      }
   }

   private static void w(int var0, int var1) {
      for(var0 = 0; var0 < jI && jK[var0] != -1; ++var0) {
      }

      if (var0 != jI) {
         for(int var2 = var0; var2 < var0 + var1; ++var2) {
            ki[var2] = 0;
            jK[var2] = 19;
            ke[var2] = 60;
            kf[var2] = 30;
            jN[var2] = 24;
            jO[var2] = 20;
            jZ[var2] = 1;
            jQ[var2] = 5;
            jV[var2] = 62;
            ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
            kc[var2] = MonsterData.DAMAGE[jK[var2]];
            kh[var2] = MonsterData.HIT_STAT[jK[var2]];
            kd[var2] = 70;
         }

      }
   }

   private static void x(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 17;
            ke[var3] = 60;
            kf[var3] = 10;
            jN[var3] = 22;
            jO[var3] = 22;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = 50 + (var3 << 1);
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 500;
         }

      }
   }

   private static void y(int var0, int var1) {
      for(var0 = 0; var0 < jI && jK[var0] != -1; ++var0) {
      }

      if (var0 != jI) {
         for(int var2 = var0; var2 < var0 + var1; ++var2) {
            ki[var2] = 0;
            jK[var2] = 12;
            ke[var2] = 24;
            kf[var2] = 10;
            jN[var2] = 16;
            jO[var2] = 22;
            jZ[var2] = 1;
            jQ[var2] = 5;
            jV[var2] = 70;
            ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
            kc[var2] = MonsterData.DAMAGE[jK[var2]];
            kh[var2] = MonsterData.HIT_STAT[jK[var2]];
            kd[var2] = 500;
         }

      }
   }

   private static void az() {
      for(int var0 = 0; var0 < kn.length; ++var0) {
         km[var0] = new boolean[kk[var0].length];
      }

      for(int var2 = 0; var2 < kk.length; ++var2) {
         for(int var1 = 0; var1 < kk[var2].length; ++var1) {
            kk[var2][var1] = kk[var2][var1] * jf + 12;
            kl[var2][var1] *= jf;
            if (var2 == 8) {
               int[] var10000 = kl[var2];
               var10000[var1] -= 12;
            }
         }
      }

   }

   private static void N(int var0) {
      if (jL[var0] < ff) {
         jT[var0] = w % 3 + 3;
         jZ[var0] = 1;
      } else if (jL[var0] > ff) {
         jT[var0] = -w % 3 - 3;
         jZ[var0] = -1;
      }

      if (jM[var0] < fg) {
         jU[var0] = w % 3 + 3;
      } else if (jM[var0] > fg) {
         jU[var0] = -w % 3 - 3;
      }

      int[] var10000 = jL;
      var10000[var0] += jT[var0];
      var10000 = jM;
      var10000[var0] += jU[var0];
      int var10002 = jY[var0]++;
      if (jY[var0] > 1) {
         jY[var0] = 0;
      }

      if (a(jL[var0] - ff) < 10 && a(jM[var0] - fg) < 10) {
         kd[var0] = 0;
         if (kj[var0]) {
            kj[var0] = false;
            b(kc[var0], jZ[var0]);
         } else {
            a(kc[var0], jZ[var0]);
         }

         jV[var0] = 0;
         jQ[var0] = 2;
      }

      if (a(jL[var0] - ff) > 160 || a(jM[var0] - fg) > 160) {
         jQ[var0] = 2;
         jV[var0] = 0;
         jT[var0] = jU[var0] = 0;
         kd[var0] = 0;
      }

   }

   private static void O(int var0) {
      int var10002 = jV[var0]++;
      int[] var10000 = jL;
      var10000[var0] -= jT[var0];
      var10000 = jM;
      var10000[var0] -= jU[var0];
      if (jT[var0] == 0) {
         jT[var0] = 2;
      }

      if (jU[var0] == 0) {
         jU[var0] = 2;
      }

      if (jV[var0] == 5) {
         jQ[var0] = 2;
         jV[var0] = 0;
         jT[var0] = jU[var0] = 0;
         kd[var0] = 0;
      }

   }

   private static void P(int var0) {
      int[] var10000 = jL;
      var10000[var0] += jT[var0];
      var10000 = jM;
      var10000[var0] += jU[var0];
      if (jL[var0] - jR[var0] > 40) {
         jT[var0] = -(w % 2 + 1);
      }

      if (jL[var0] - jR[var0] < -40) {
         jT[var0] = w % 2 + 1;
      }

      if (jM[var0] - jS[var0] > 40) {
         jU[var0] = -(w % 2 + 1);
      }

      if (jM[var0] - jS[var0] < -40) {
         jU[var0] = w % 2 + 1;
      }

      if (w % 15 == 0) {
         jT[var0] = w % 3 - 1;
         jU[var0] = (w >> 1) % 3 - 1;
      }

      int var10002 = jY[var0]++;
      if (jY[var0] > 1) {
         jY[var0] = 0;
      }

      J(var0);
      if (w % 5 == 0) {
         K(var0);
      }

   }

   private static void Q(int var0) {
      if (w % 4 == 1) {
         int var10002 = jY[var0]++;
         if (jY[var0] > 1) {
            jY[var0] = 0;
         }

         int[] var10000 = jL;
         var10000[var0] += jZ[var0] << 1;
         if (jL[var0] > jS[var0]) {
            jZ[var0] = -1;
         } else if (jL[var0] < jR[var0]) {
            jZ[var0] = 1;
         }
      }

      J(var0);
   }

   private static void R(int var0) {
      a(kc[var0], -fn);
      jQ[var0] = 2;
      jV[var0] = 0;
      jY[var0] = 2;
   }

   private static void S(int var0) {
      int var10002 = jV[var0]++;
      int[] var10000 = jL;
      var10000[var0] -= jZ[var0];
      if (jV[var0] == 5) {
         jQ[var0] = 2;
      }

   }

   private static void T(int var0) {
      int var10002 = jV[var0]++;
      int[] var10000 = jL;
      var10000[var0] -= jZ[var0];
      if (jV[var0] == 3) {
         jQ[var0] = 2;
      }

   }

   private static void U(int var0) {
      if (w % 4 == 0) {
         int var10002 = jY[var0]++;
         if (jY[var0] > 1) {
            jY[var0] = 0;
         }

         int[] var10000 = jL;
         var10000[var0] += jZ[var0];
      }

      if (jL[var0] > jS[var0]) {
         jZ[var0] = -1;
      } else if (jL[var0] < jR[var0]) {
         jZ[var0] = 1;
      }

      J(var0);
      if (w % 5 == 0) {
         K(var0);
      }

   }

   private static void aA() {
      U = bE - 40;
      kp = bD - 50;
      iU = null;
      ky = new Image[4];

      try {
         ky[0] = Image.createImage("/u/wpt0.png");
         ky[1] = Image.createImage("/u/wpt2.png");
         ky[2] = Image.createImage("/u/wpt3.png");
         ky[3] = Image.createImage("/u/wpt4.png");
      } catch (Exception var3) {
      }

      if (kI == null) {
         kI = new Image[4];

         for(int var0 = 0; var0 < 4; ++var0) {
            try {
               kI[var0] = Image.createImage("/u/bd" + var0 + ".png");
            } catch (IOException var2) {
               ((Throwable)var2).printStackTrace();
            }
         }
      }

      System.gc();
   }

   private static void m(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      d(var0);
      c(var0);
      var0.setClip(0, 0, aU, aV);
      var0.setColor(0);
      var0.fillRect(bD - 64, U - 19, 129, 102);
      var0.fillRect(0, aV - 13, aU, 13);
      Midlet.a(var0, "Mua", 3, aV - 13, 0);
      Midlet.a(var0, "Quay lại", aU - 3, aV - 13, 1);
      var0.setColor(12281361);
      var0.drawRect(bD - 63, U - 18, 126, 99);
      var0.setColor(6562304);
      var0.fillRect(bD - 61, U - 16, 123, 97);
      if (kt == 0) {
         Midlet.a(var0, "Tiền: " + de + "$", bD, U - 8, 2);
      } else {
         Midlet.a(var0, kv[ks][kq], bD, U - 8, 2);
      }

      for(int var1 = 0; var1 < 3; ++var1) {
         var0.setColor(0);
         var0.fillRect(kp - 10 + var1 * 20, U + 10, 19, 20);
         var0.fillRect(kp + 50 + var1 * 20, U + 10, 19, 20);
         var0.setColor(4856064);
         var0.drawRect(kp - 10 + var1 * 20, U + 10, 20, 20);
         var0.drawRect(kp + 50 + var1 * 20, U + 10, 20, 20);
         var0.drawRegion(ex[0], 0, var1 * 15, 13, 15, 0, kp + var1 * 20, U + 20, 3);
         var0.drawRegion(ex[1], 0, var1 * 15, 13, 15, 0, kp + 60 + var1 * 20, U + 20, 3);
      }

      for(int var2 = 0; var2 < 4; ++var2) {
         var0.setColor(0);
         var0.fillRect(kp + 10 + var2 * 20, U + 32, 19, 20);
         var0.setColor(4856064);
         var0.drawRect(kp + 10 + var2 * 20, U + 32, 18, 20);
         var0.drawImage(ky[var2], kp + 20 + var2 * 20, U + 42, 3);
      }

      var0.setColor(ku[kr]);
      if (ks == 0) {
         var0.drawRect(kp - 10 + kq * 20, U + 10, 19, 20);
      } else {
         var0.drawRect(kp + 10 + kq * 20, U + 32, 19, 20);
      }

      if (kt == 0) {
         Midlet.a(var0, kv[ks][kq] + "-" + kx[ks][kq] + "$", bD, U + 58, 2);
      } else {
         Midlet.a(var0, kw[ks][kq], bD, U + 58, 2);
      }

      var0.drawImage(kI[0], bD - 64, U - 19, 20);
      var0.drawImage(kI[1], bD + 65, U - 19, 24);
      var0.drawImage(kI[2], bD - 64, U + 83, 36);
      var0.drawImage(kI[3], bD + 65, U + 83, 40);
   }

   private static void aB() {
      if (aN) {
         aN = false;
         if (aP > aV - 40) {
            if (aO < aW) {
               aT[12] = true;
            } else {
               aT[13] = true;
            }
         }

         if (aP > U && aP < U + 32) {
            ks = 0;
            kq = 0;

            for(int var1 = 0; var1 < 6; ++var1) {
               if (aO > kp - 10 + var1 * 20 && aO < kp - 10 + var1 * 20 + 20) {
                  kq = var1;
               }
            }
         } else if (aP < U + 60) {
            ks = 1;
            kq = 0;

            for(int var0 = 0; var0 < 4; ++var0) {
               if (aO > kp + 10 + var0 * 20 && aO < kp + 10 + var0 * 20 + 20) {
                  kq = var0;
               }
            }
         }
      }

      if (kr > 0) {
         --kr;
      }

      if (aT[5] || aT[12]) {
         d();
         if (ks == 0) {
            if (kt == 0) {
               if (kq < 3) {
                  if (V[0] + V[1] + V[2] > 99) {
                     return;
                  }
               } else if (V[3] + V[4] + V[5] > 99) {
                  return;
               }

               if (de >= kx[ks][kq]) {
                  int var10002 = V[kq]++;
                  de -= kx[ks][kq];
               }
            } else {
               a("TEAM BUY 009007 " + kz[ks][kq], kA[ks][kq], kq + 1);
            }
         } else {
            if (x >= kq) {
               s(7);
               a("Không cần thiết phải mua vũ khí này vì vũ khí đang sử dụng mạnh hơn!");
               X = U;
               d = 7;
               return;
            }

            if (characterLevel < ko[kq]) {
               s(7);
               a("Bạn phải đạt cấp độ " + ko[kq] + " mới có thể mua vũ khí này!");
               X = U;
               d = 7;
               return;
            }

            if (kt == 0) {
               if (de >= kx[ks][kq]) {
                  de -= kx[ks][kq];
                  x = kq;
                  t();
                  return;
               }

               s(7);
               a("Không có đủ tiền: " + kx[ks][kq] + "$. Bạn chỉ có: " + de + "$. Hãy đi tìm thêm.");
               X = U;
               d = 7;
               return;
            }

            a("TEAM BUY 009007 " + kz[ks][kq], kA[ks][kq], kq + 6);
         }
      }

      if (aT[13]) {
         kI = null;
         ky = null;
         System.gc();
         au();
         d();
         c();
         d = 1;
         c = true;
      } else {
         if (aT[2]) {
            d();
            if (ks == 1) {
               ks = 0;
               ++kq;
            }
         }

         if (aT[8]) {
            d();
            if (ks == 0) {
               ks = 1;
               if (--kq < 0) {
                  kq = 0;
               }

               if (kq > 3) {
                  kq = 3;
               }
            }
         }

         if (aT[4]) {
            d();
            if (--kq < 0) {
               if (ks == 0) {
                  kq = 5;
               } else {
                  kq = 3;
               }
            }
         }

         if (aT[6]) {
            d();
            ++kq;
            if (ks == 0 && kq == 6) {
               kq = 0;
            }

            if (ks == 1 && kq == 4) {
               kq = 0;
            }
         }

      }
   }

   /**
    * Phương thức vẽ giao diện danh sách sử dụng item.
    * @param var0 Graphics: đối tượng để vẽ lên màn hình.
    */
   private static int invQtyAt(int var0) {
      return var0 < 6 ? V[var0] : kBagExt[var0 - 6];
   }

   private static void invUseAt(int var0) {
      if (var0 < 6) {
         V[var0]--;
      } else {
         kBagExt[var0 - 6]--;
      }
   }

   private static void n(Graphics var0) {
      final int invSlots = 12;
      final int invRowH = 22;
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      d(var0);
      c(var0);
      var0.setClip(0, 0, aU, aV);
      var0.setColor(0);
      var0.fillRect(bD - 64, kB - 19, 129, 124);
      var0.fillRect(0, aV - 13, aU, 13);
      Midlet.a(var0, "Sử dụng", 3, aV - 13, 0);
      Midlet.a(var0, "Quay lại", aU - 3, aV - 13, 1);
      var0.setColor(12281361);
      var0.drawRect(bD - 63, kB - 18, 126, 121);
      var0.setColor(6562304);
      var0.fillRect(bD - 61, kB - 16, 123, 119);
      Midlet.a(var0, "Sử dụng Item", bD, kB - 8, 2);

      for(int var2 = 0; var2 < 2; ++var2) {
         int var3 = kB + 10 + var2 * invRowH;
         int var4 = var3 + 10;

         for(int var1 = 0; var1 < 3; ++var1) {
            int var5 = kC - 10 + var1 * 20;
            int var6 = kC + 50 + var1 * 20;
            int var7 = var2 * 6 + var1;
            int var8 = var7 + 3;
            var0.setColor(0);
            var0.fillRect(var5, var3, 19, 20);
            var0.fillRect(var6, var3, 19, 20);
            var0.setColor(4856064);
            var0.drawRect(var5, var3, 20, 20);
            var0.drawRect(var6, var3, 20, 20);
            if (var7 < invSlots && invQtyAt(var7) > 0 && ex != null) {
               var0.drawRegion(ex[0], 0, (var7 % 3) * 15, 13, 15, 0, var5 + 10, var4, 3);
            }

            if (var8 < invSlots && invQtyAt(var8) > 0 && ex != null && ex.length > 1) {
               var0.drawRegion(ex[1], 0, (var8 % 3) * 15, 13, 15, 0, var6 + 10, var4, 3);
            }
         }
      } 

      if (kD >= 0 && kD < invSlots) {
         int var9 = kD / 6;
         int var10 = kD % 6;
         var0.setColor(kF[kE]);
         var0.drawRect(kC - 10 + var10 * 20, kB + 10 + var9 * invRowH, 20, 20);
 

         Midlet.a(var0, kG[kD], bD, kB + 58, 2);
         Midlet.a(var0, "Số lượng: " + invQtyAt(kD), bD, kB + 73, 2);
         Midlet.a(var0, "Tấn công: " + E, bD, kB + 88, 2);
      }

      var0.drawImage(kI[0], bD - 64, kB - 19, 20);
      var0.drawImage(kI[1], bD + 65, kB - 19, 24);
      var0.drawImage(kI[2], bD - 64, kB + 105, 36);
      var0.drawImage(kI[3], bD + 65, kB + 105, 40);
   }

   private static void aC() {
      if (aN) {
         aN = false;
         if (aP > aV - 40) {
            if (aO < aW) {
               aT[12] = true;
            } else {
               aT[13] = true;
            }
         }

         if (aP > kB - 20 && aP < kB + 76) {
            for(int var0 = 0; var0 < 12; ++var0) {
               int var1 = var0 / 6;
               int var2 = var0 % 6;
               int var3 = kC - 10 + var2 * 20;
               int var4 = kB + 10 + var1 * 22;
               if (aO > var3 && aO < var3 + 20 && aP > var4 && aP < var4 + 20) {
                  kD = var0;
               }
            }
         }
      }

      if (kE > 0) {
         --kE;
      }

      if (aT[5] || aT[12]) {
         if (kD >= 0 && kD < 12 && invQtyAt(kD) > 0) {
            invUseAt(kD);
            kE = kF.length - 1;
            if (kD % 6 <= 2) {
               if (G < H) {
                  G += kH[kD % 6];
               }

               if (G > H) {
                  G = H;
               }
            } else {
               if (I < J) {
                  I += kH[kD % 6];
               }

               if (I > J) {
                  I = J;
               }
            }
         }

         d();
      }

      if (aT[13]) {
         d();
         c();
         d = 5;
      } else {
         if (aT[4]) {
            d();
            if (--kD < 0) {
               kD = 11;
            }
         }

         if (aT[6]) {
            d();
            if (++kD == 12) {
               kD = 0;
            }
         }

      }
   }

   private static void aD() {
      kJ = bE - 40;
      iU = null;
      if (kI == null) {
         kI = new Image[4];

         for(int var0 = 0; var0 < 4; ++var0) {
            try {
               kI[var0] = Image.createImage("/u/bd" + var0 + ".png");
            } catch (IOException var2) {
               ((Throwable)var2).printStackTrace();
            }
         }
      }

   }

   private static void o(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setColor(0);
      var0.fillRect(bD - 64, kJ - 19, 129, 102);
      var0.fillRect(0, aV - 13, aU, 13);
      Midlet.a(var0, "Chọn", 3, aV - 13, 0);
      Midlet.a(var0, "Quay lại", aU - 3, aV - 13, 1);
      var0.setColor(12281361);
      var0.drawRect(bD - 63, kJ - 18, 126, 99);
      var0.setColor(6562304);
      var0.fillRect(bD - 61, kJ - 16, 123, 97);

      for(int var1 = 0; var1 < 4; ++var1) {
         Midlet.a(var0, kM[var1], aW - 30, kJ + var1 * 18, 0);
      }

      var0.drawImage(eD[0], aW - 55 + kL % 2, kJ + kK * 18 - kL % 2, 0);
      var0.drawImage(kI[0], bD - 64, kJ - 19, 20);
      var0.drawImage(kI[1], bD + 65, kJ - 19, 24);
      var0.drawImage(kI[2], bD - 64, kJ + 83, 36);
      var0.drawImage(kI[3], bD + 65, kJ + 83, 40);
   }

   private static void aE() {
      if (aN) {
         aN = false;
         if (aP > aV - 40) {
            if (aO < aW) {
               aT[12] = true;
            } else {
               aT[13] = true;
            }
         }

         for(int var0 = 0; var0 < 4; ++var0) {
            if (aP > kJ + var0 * 18 - 4 && aP < kJ + var0 * 18 + 14) {
               kK = var0;
            }
         }
      }

      if (++kL > 10000) {
         kL = 0;
      }

      boolean var5 = false;
      if (aT[13]) {
         var5 = true;
         kI = null;
         au();
         d = 1;
         c = true;
      } else if (!aT[5] && !aT[12]) {
         if (aT[8]) {
            var5 = true;
            if (++kK > 3) {
               kK = 0;
            }
         } else if (aT[2]) {
            var5 = true;
            if (--kK < 0) {
               kK = 3;
            }
         } else if (aT[4]) {
            var5 = true;
         } else if (aT[6]) {
            var5 = true;
         }
      } else {
         var5 = true;
         if (kK == 0) {
            kB = bE - 40;
            kC = bD - 50;
            if (kI == null) {
               kI = new Image[4];

               for(int var1 = 0; var1 < 4; ++var1) {
                  try {
                     kI[var1] = Image.createImage("/u/bd" + var1 + ".png");
                  } catch (IOException var4) {
                     ((Throwable)var4).printStackTrace();
                  }
               }
            }

            d = 8;
         }

         if (kK == 1) {
            lh = 280 - q;
            li = 280 - r;
            kX = 0;

            try {
               kT = Image.createImage("/wm.png");
               kU = Image.createImage("/u/x.png");
            } catch (Exception var3) {
            }

            lj = v;
            if (v == 99) {
               lj = 0;
            }

            if (v == 97) {
               lj = 7;
            }

            if (v == 96) {
               lj = 11;
            }

            if (v == 95) {
               lj = 18;
            }

            kV = kP[lj];
            kW = kQ[lj];
            aG();
            kZ = kV - bD;
            la = kW - bE;
            if (lf < -40) {
               lf = -40;
            }

            if (lf > lh) {
               lf = lh;
            }

            if (lg < -40) {
               lg = -40;
            }

            if (lg > li) {
               lg = li;
            }

            d = 6;
         }

         if (kK == 2) {
            if (A != 1) {
               kI = null;
               au();
               aI();
               s(5);
               a("Bạn chỉ có thể lưu và thoát khi nhân vật đang đứng yên.");
               X = bE - 40;
               d = 7;
            } else {
               aM = false;
            }
         }
      }

      if (var5) {
         d();
      }

   }

   private static void aF() {
      kT = null;
      kU = null;
      System.gc();
   }

   private static void p(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setColor(0);
      var0.fillRect(0, 0, q, r);
      var0.fillRect(0, aV - 13, aU, 13);
      Midlet.a(var0, lk, 3, aV - 13, 0);
      Midlet.a(var0, "Quay lại", aU - 3, aV - 13, 1);
      var0.setClip(0, 0, q, r);
      var0.translate(-lf, -lg);
      var0.drawImage(kT, 0, 0, 0);

      for(int var1 = 0; var1 < 19; ++var1) {
         if (var1 == lj) {
            var0.drawImage(ep[0], kP[var1] + 10, kQ[var1], 3);
         }

         if (W[var1] && (var1 != kX || kY % 10 > 5)) {
            var0.drawImage(kU, kP[var1], kQ[var1], 3);
         }
      }

      var0.drawImage(eD[0], kV, kW, 24);
      if (kX != -1) {
         var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
         var0.setColor(6562304);
         var0.fillRect(aW - 60, r - 35, 120, 33);
         var0.setColor(12281361);
         var0.drawRect(aW - 59, r - 34, 117, 30);
         Midlet.a(var0, kN[kX], aW, r - 25, 2);
         var0.drawImage(kI[0], aW - 60, r - 35, 20);
         var0.drawImage(kI[1], aW + 60, r - 35, 24);
         var0.drawImage(kI[2], aW - 60, r - 2, 36);
         var0.drawImage(kI[3], aW + 60, r - 2, 40);
      }

   }

   private static void aG() {
      kX = -1;
      lk = "";

      for(int var0 = 0; var0 < 19; ++var0) {
         if (a(kV - kP[var0]) < 8 && a(kW - kQ[var0]) < 8) {
            kX = var0;
            lk = "Chuyển đến";
            return;
         }
      }

   }

   private static void aH() {
      try {
         ll = Image.createImage("/u/m.png");
      } catch (Exception var0) {
      }
   }

   public static void a(String var0) {
      lt = Midlet.a(var0, 100);
      X = bE - lt.length * 9;
   }

   public static void s(int var0) {
      aI();
      lo = var0;
      if (var0 == 1) {
         a("Không thể chuyển. Vì bạn chưa từng đi bộ đến đây!");
         lr = "OK";
         ls = "";
      } else if (var0 == 3) {
         a("Không cần phải chuyển vì bạn đang ở vị trí này!");
         lr = "OK";
         ls = "";
      } else if (var0 != 2) {
         if (var0 == 4) {
            a("Bạn không có đủ tiền!");
            lr = "OK";
            ls = "";
         } else if (var0 == 5) {
            a("Bạn đã bị trọng thương! Mất một số điểm kinh nghiệm!");
            lr = "OK";
            ls = "";
         } else if (var0 == 6) {
            a("Level up!");
            lr = "OK";
            ls = "";
         } else {
            if (var0 == 7) {
               a("Buy OK!");
               lr = "";
               ls = "OK";
            }

         }
      } else {
         var0 = lj < kX ? lj : kX;
         int var1 = lj > kX ? lj : kX;
         int var2 = 0;

         for(int var4 = var0; var4 <= var1; ++var4) {
            var2 += kO[var4];
         }

         int var5;
         lp = var5 = (var2 << 1) / 3;
         a("Chuyển đến đây phải trả " + var5 + "$. Bạn có " + de + "$. Chuyển?");
         lr = "Chuyển";
         ls = "Không";
      }
   }

   private static void aI() {
      lq = 0;
      if (kI == null) {
         kI = new Image[4];

         for(int var0 = 0; var0 < 4; ++var0) {
            try {
               kI[var0] = Image.createImage("/u/bd" + var0 + ".png");
            } catch (IOException var2) {
               ((Throwable)var2).printStackTrace();
            }
         }
      }

   }

   private static void q(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setColor(0);
      var0.fillRect(bD - 64, X - 19, 129, 102);
      var0.fillRect(0, aV - 13, aU, 13);
      Midlet.a(var0, lr, 3, aV - 13, 0);
      Midlet.a(var0, ls, aU - 3, aV - 13, 1);
      var0.setColor(12281361);
      var0.drawRect(bD - 63, X - 18, 126, 99);
      var0.setColor(6562304);
      var0.fillRect(bD - 61, X - 16, 123, 97);

      for(int var1 = 0; var1 < lt.length; ++var1) {
         Midlet.a(var0, lt[var1], aW, X + var1 * 18, 2);
      }

      var0.drawImage(kI[0], bD - 64, X - 19, 20);
      var0.drawImage(kI[1], bD + 65, X - 19, 24);
      var0.drawImage(kI[2], bD - 64, X + 83, 36);
      var0.drawImage(kI[3], bD + 65, X + 83, 40);
   }

   private static void V(int var0) {
      lI = v;
      lL = var0;
      lJ = lw[var0];
      lK = lx[var0] - 44;
   }

   public static void t(int var0) {
      lv = 0;
      if (var0 == 0) {
         lu = new Image[6][2];

         try {
            lu[0][0] = Image.createImage("/npc/00.png");
            lu[0][1] = Image.createImage("/npc/01.png");
            lu[1][0] = Image.createImage("/npc/10.png");
            lu[1][1] = Image.createImage("/npc/11.png");
            lu[2][0] = Image.createImage("/npc/20.png");
            lu[2][1] = Image.createImage("/npc/21.png");
            lu[3][0] = Image.createImage("/npc/30.png");
            lu[3][1] = Image.createImage("/npc/31.png");
            lu[4][0] = Image.createImage("/npc/40.png");
            lu[4][1] = Image.createImage("/npc/41.png");
            lu[5][0] = Image.createImage("/npc/50.png");
            lu[5][1] = Image.createImage("/npc/51.png");
         } catch (Exception var7) {
         }

         lv = 7;
         aJ();
         c(0, 0, 34, 13);
         c(1, 1, 43, 17);
         c(2, 2, 50, 17);
         c(3, 3, 57, 12);
         c(4, 4, 43, 12);
         c(5, 5, 77, 15);
         c(6, 5, 25, 17);
      }

      if (var0 == 1) {
         lu = new Image[6][2];

         try {
            lu[5][0] = Image.createImage("/npc/50.png");
            lu[5][1] = Image.createImage("/npc/51.png");
         } catch (Exception var6) {
         }

         lv = 1;
         aJ();
         c(0, 5, 54, 9);
      }

      if (var0 == 2) {
         lu = new Image[6][2];

         try {
            lu[5][0] = Image.createImage("/npc/50.png");
            lu[5][1] = Image.createImage("/npc/51.png");
         } catch (Exception var5) {
         }

         lv = 1;
         aJ();
         c(0, 5, 23, 12);
      }

      if (var0 == 5) {
         lu = new Image[6][2];

         try {
            lu[5][0] = Image.createImage("/npc/50.png");
            lu[5][1] = Image.createImage("/npc/51.png");
         } catch (Exception var4) {
         }

         lv = 1;
         aJ();
         c(0, 5, 12, 5);
      }

      if (var0 == 6) {
         lu = new Image[6][2];

         try {
            lu[5][0] = Image.createImage("/npc/50.png");
            lu[5][1] = Image.createImage("/npc/51.png");
         } catch (Exception var3) {
         }

         lv = 1;
         aJ();
         c(0, 5, 14, 9);
      }

      if (var0 == 99 || var0 == 101) {
         lu = new Image[6][2];

         try {
            lu[4][0] = Image.createImage("/npc/40.png");
            lu[4][1] = Image.createImage("/npc/41.png");
         } catch (Exception var2) {
         }

         lv = 1;
         aJ();
         c(0, 4, 3, 12);
      }

      if (var0 == 94) {
         lu = new Image[6][2];

         try {
            lu[0][0] = Image.createImage("/npc/00.png");
            lu[0][1] = Image.createImage("/npc/01.png");
            lu[4][0] = Image.createImage("/npc/40.png");
            lu[4][1] = Image.createImage("/npc/41.png");
            lu[2][0] = Image.createImage("/npc/20.png");
            lu[2][1] = Image.createImage("/npc/21.png");
         } catch (Exception var1) {
         }

         lv = 3;
         aJ();
         c(0, 4, 2, 10);
         c(1, 0, 3, 10);
         c(2, 2, 4, 10);
      }

   }

   private static void c(int var0, int var1, int var2, int var3) {
      ly[var0] = var1;
      lw[var0] = var2 * jf + 12;
      lx[var0] = var3 * jf;
   }

   private static void aJ() {
      lw = new int[lv];
      lx = new int[lv];
      ly = new int[lv];
   }

   private static void r(Graphics var0) {
      for(int var1 = 0; var1 < lv; ++var1) {
         if (lw[var1] + 10 >= fP && lw[var1] - 10 <= fP + q && lx[var1] >= fQ && lx[var1] - 32 <= fQ + r) {
            var0.drawImage(lu[ly[var1]][1], lw[var1], lx[var1], 33);
            var0.drawImage(lu[ly[var1]][0], lw[var1], lx[var1] - lH[ly[var1]] + (w % (15 + ly[var1]) > 4 ? 0 : 1), 33);
         }
      }

   }

   private static void aK() {
      if (aT[12]) {
         Midlet.c.exit("aK key12");
      }

      Y(1);
      int var10002 = lX[0]++;
   }

   private void aL() {
      if (aT[2]) {
         --this.md;
         if (this.md < 0) {
            this.md = 1;
         }

         d();
      }

      if (aT[8]) {
         ++this.md;
         if (this.md > 1) {
            this.md = 0;
         }

         d();
      }

      if (aT[4]) {
         --this.mc;
         if (this.mc < 0) {
            this.mc = 4;
         }

         d();
      }

      if (aT[6]) {
         ++this.mc;
         if (this.mc > 4) {
            this.mc = 0;
         }

         d();
      }

      if (aT[5]) {
         this.aP();
         d();
      }

      if (aT[12]) {
         int var1 = "TEAM".length() + 5;
         lX[5] = Integer.parseInt(lW.substring(var1++, var1));
         lX[6] = Integer.parseInt(lW.substring(var1++, var1));
         lX[7] = Integer.parseInt(lW.substring(var1++, var1));
         lX[8] = Integer.parseInt(lW.substring(var1++, var1));
         a var8 = this;
         if (this.mb.length() < 4) {
            Y = 0;
         } else {
            lX[1] = Integer.parseInt(this.mb.substring(0, 1));
            lX[2] = Integer.parseInt(this.mb.substring(1, 2));
            lX[3] = Integer.parseInt(this.mb.substring(2, 3));
            lX[4] = Integer.parseInt(this.mb.substring(3, 4));
            lX[8] = (lX[8] + lX[7]) % 10;
            lX[7] = (lX[7] + lX[6]) % 10;
            lX[6] = (lX[6] + lX[5]) % 10;
            lX[5] = (lX[5] + lX[8]) % 10;

            for(int var2 = 1; var2 < 8; ++var2) {
               if (lX[var2 - 1] != lX[var2]) {
                  var8.aN();
               } else if (lX[var2] != lX[var2] + 1) {
                  var8.aO();
               } else {
                  d();
                  var8.aR();
                  var8.aO();
                  aK();
                  d();
               }
            }
         }

         d();
      }

      if (aT[13]) {
         this.aM();
         d();
      }

      if (aN) {
         for(int var9 = 0; var9 < 2; ++var9) {
            for(int var10 = 0; var10 < 5; ++var10) {
               if (aO > var10 * 20 + aW - 50 && aO < var10 * 20 + aW - 50 + 20 && aP > var9 * 25 + aX && aP < var9 * 25 + aX + 25) {
                  this.mc = var10;
                  this.md = var9;
                  this.aP();
                  aN = false;
               }
            }
         }
      }

   }

   private void aM() {
      if (this.mb.length() != 0) {
         this.mb = this.mb.substring(0, this.mb.length() - 1);
      }

   }

   private void aN() {
      d();
      Y = 0;
      aQ();
      d();
   }

   private void aO() {
      d();
      this.aR();
      Y = 4;
      this.aN();
      d();
   }

   private void aP() {
      if (this.mb.length() < 4) {
         this.mb = this.mb + (this.md * 5 + this.mc);
      }

   }

   private static void aQ() {
      if (aT[5] || aT[12]) {
         d();
         Y = 0;
      }

   }

   private void aR() {
      if (aT[5] || aT[12]) {
         String var1;
         if ((var1 = aU()) == null || var1.equals("")) {
            g(var1 = "TEAM PAY " + (System.currentTimeMillis() % 8000L + 1000L) + "009" + "007");
         }

         Y = 1;
         a(var1, "sms://8722", 0);
         d();
      }

      if (aT[13]) {
         Y = 0;
         d();
      }

   }

   private void aS() {
      if (aT[2]) {
         --this.lZ;
         if (this.lZ < 0) {
            this.lZ = lY == 0 ? 1 : 2;
         }

         d();
      }

      if (aT[8]) {
         ++this.lZ;
         if (this.lZ > (lY == 0 ? 1 : 2)) {
            this.lZ = 0;
         }

         d();
      }

      if (aT[5] || aT[12]) {
         this.aT();
         d();
      }

      if (aT[13]) {
         Midlet.c.exit("settings aT key13");
         }

      if (aN) {
         for(int var1 = 0; var1 < (lY == 0 ? 2 : 3); ++var1) {
            if (aP > aX - 5 + var1 * lT && aP < aX - 5 + var1 * lT + lT) {
               if (this.lZ != var1) {
                  this.lZ = var1;
               } else {
                  this.aT();
               }

               aN = false;
               return;
            }
         }
      }

   }

   private void aT() {
      if (this.lZ == 0 && lY > 0) {
         W(--lY);
         d = 4;
         av();
         System.gc();
      }

      if (this.lZ == 1 && lY > 0 || this.lZ == 0 && lY == 0) {
         Y = 2;
      }

      if (this.lZ == 2 && lY > 0 || this.lZ == 1 && lY == 0) {
         lW = aU();
         Y = 4;
      }

   }

   private void s(Graphics var1) {
      var1.setColor(7171437);
      var1.drawString("Nhap ma kich hoat:", aW, aX - 60, 17);
      var1.setColor(11788624);
      var1.fillRect(this.mc * 20 + aW - 50, this.md * 25 + aX, 18, 23);
      int var2 = 0;

      for(int var3 = 0; var3 < 2; ++var3) {
         for(int var4 = 0; var4 < 5; ++var4) {
            var1.setColor(11788624);
            var1.drawRect(var4 * 20 + aW - 50, var3 * 25 + aX, 18, 23);
            var1.setColor(var4 == this.mc && var3 == this.md ? 16777215 : 7171437);
            var1.drawString(String.valueOf(var2), var4 * 20 + aW - 50 + 10, var3 * 25 + aX + 3, 17);
            ++var2;
         }
      }

      String var5 = this.mb;
      if (lP % 10 > 5) {
         var5 = var5 + "|";
      }

      var1.setColor(7171437);
      var1.drawString(var5, aW - 20, aX - 40, 20);
      var1.setColor(16777215);
      var1.setFont(lS);
      var1.drawString("OK", 2, aV - lT + 3, 20);
      var1.drawString("Xoa", aU - 2, aV - lT + 3, 24);
   }

   private void t(Graphics var1) {
      var1.setColor(7171437);
      var1.setColor(11788624);
      var1.drawRect(3, aX - 8 + this.lZ * lT, aU - 6, lT);
      var1.drawRect(4, aX - 8 + this.lZ * lT + 1, aU - 8, lT - 2);
      var1.setColor(208472);
      if (lY > 0) {
         var1.setFont(lS);
         var1.drawString("..:TEA MOBILE:..", aW, aX - (lT << 1), 17);
         var1.setFont(lR);

         for(int var2 = 0; var2 < 3; ++var2) {
            var1.setColor(7171437);
            var1.drawString(lN[var2], lQ, aX - 5 + var2 * lT, 20);
         }
      } else {
         var1.drawString("Da het han dung thu", aW, aX - (lT << 1), 17);
         var1.drawString("Moi ban kich hoat.", aW, aX - lT, 17);

         for(int var3 = 0; var3 < 2; ++var3) {
            var1.setColor(7171437);
            var1.drawString(lO[var3], lQ, aX - 5 + var3 * lT, 20);
         }
      }

      var1.setColor(16777215);
      var1.setFont(lS);
      var1.drawString("Chon", 2, aV - lT + 3, 20);
      var1.drawString("Thoat", aU - 2, aV - lT + 3, 24);
   }

   private static void a(String var0, String var1, int var2) {
      (new Thread(new b(var1, var0, var2))).start();
   }

   public static void t() {
      F();
      G();
      s(7);
      a("Xin chúc mừng. Bạn đã có vũ khí mới: " + kv[ks][kq] + "!");
      X = U;
      d = 7;
   }

   private static byte[] f(String var0) {
      var0 = "NINJASCHOOL" + var0;

      try {
         RecordStore var4;
         byte[] var1 = (var4 = RecordStore.openRecordStore(var0, false)).getRecord(1);
         var4.closeRecordStore();
         return var1;
      } catch (Exception var2) {
         return null;
      }
   }

   private static void a(String var0, byte[] var1) {
      var0 = "NINJASCHOOL" + var0;

      try {
         RecordStore var4;
         if ((var4 = RecordStore.openRecordStore(var0, true)).getNumRecords() > 0) {
            var4.setRecord(1, var1, 0, var1.length);
         } else {
            var4.addRecord(var1, 0, var1.length);
         }

         var4.closeRecordStore();
      } catch (Exception var2) {
      }
   }

   private static void g(String var0) {
      a("xxx", var0.getBytes());
   }

   private static String aU() {
      byte[] var0;
      return (var0 = f("xxx")) == null ? null : new String(var0);
   }

   private static void W(int var0) {
      byte[] var1;
      (var1 = new byte[1])[0] = (byte)var0;
      a("np", var1);
   }

   private static void X(int var0) {
      byte[] var1;
      (var1 = new byte[1])[0] = (byte)var0;
      a("r", var1);
   }

   private static void Y(int var0) {
      byte[] var1;
      (var1 = new byte[1])[0] = (byte)var0;
      a("g", var1);
   }

   private static int aV() {
      byte[] var0;
      return (var0 = f("g")) == null ? 0 : var0[0];
   }

   public static String b(String var0) {
      int var1 = Integer.parseInt(var0.substring(0, 1));
      int var2 = Integer.parseInt(var0.substring(1, 2));
      int var3 = Integer.parseInt(var0.substring(2, 3));
      int var4 = (Integer.parseInt(var0.substring(3, 4)) + var3) % 10;
      var3 = (var3 + var2) % 10;
      var2 = (var2 + var1) % 10;
      var1 = (var1 + var4) % 10;
      return "" + var1 + var2 + var3 + var4;
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getLabel().equals("OK")) {
         a(aU() + " >> " + ((TextBox)var2).getString(), "sms://+84914710711", 0);
      }

      Display.getDisplay(Midlet.c).setCurrent(this);
      ((Canvas)this).setFullScreenMode(true);
   }
}
