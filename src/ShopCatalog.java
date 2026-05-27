/**
 * Shop catalog data (moved from {@link a}; names/prices aligned with {@link Item} shop getters).
 * Slot indices and SMS payloads unchanged.
 */
public final class ShopCatalog {

   private ShopCatalog() {
   }

   /** Selection row gradient colors (was {@code a.ku}). */
   public static final int[] ku = new int[]{12281360, 13859359, 15439166, 16693877, 16765346, 16777215, 16765346, 16693877, 15439166, 13859359, 12281360};

   /** Buyable display names per tab/slot (was {@code a.kv}). */
   public static final String[][] kv = new String[][]{{"Bình HP nhỏ", "Bình HP vừa", "Bình HP to", "Bình MP nhỏ", "Bình MP vừa", "Bình MP to"}, {"Kiếm tre", "Thủy linh kiếm", "Hỏa giác kiếm", "Long giao kiếm"}};

   /** Gold price per slot (was {@code a.kx}). */
   public static final int[][] kx = new int[][]{{200, 600, 1500, 200, 600, 1200}, {2000, 12000, 45000, 182000}};

   /** SMS SKU strings appended after {@code "TEAM BUY 009007 "} (was {@code a.kz}). */
   public static final String[][] kz = new String[][]{{"BinhHP_Nho(50)", "BinhHP_Vua(50)", "BinhHP_To(30)", "BinhMP_Nho(50)", "BinhMP_Vua(30)", "BinhMP_To(50)"}, {"KiemTre", "ThuyLinhKiem", "HoaGiacKiem", "LongGiaoKiem"}};

   /** SMS gateway URLs per slot (was {@code a.kA}). */
   public static final String[][] kA = new String[][]{{"sms://8222", "sms://8322", "sms://8322", "sms://8222", "sms://8222", "sms://8222"}, {"sms://8122", "sms://8322", "sms://8422", "sms://8522"}};
}
