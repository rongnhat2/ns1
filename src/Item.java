public final class Item {
    private static final String[] itemName;
    private static final String[][] itemCanByName;
    private static final int[][] itemCanByPrice;
    static {
        itemName = new String[] { "Bình HP nhỏ", "Bình HP vừa", "Bình HP to", "Bình MP nhỏ", "Bình MP vừa",
                "Bình MP to", "Ô 7", "Ô 8", "Ô 9", "Ô 10", "Ô 11", "Ô 12" };
        itemCanByName = new String[][]{{"Bình HP nhỏ", "Bình HP vừa", "Bình HP to", "Bình MP nhỏ", "Bình MP vừa", "Bình MP to"}, {"Kiếm tre", "Thủy linh kiếm", "Hỏa giác kiếm", "Long giao kiếm"}};
        itemCanByPrice = new int[][]{{200, 600, 1500, 200, 600, 1200}, {2000, 12000, 45000, 182000}};
    }
    public static String getItemName(int index) {
        return itemName[index];
    }
    public static String[] getAllItemNames() {
        return itemName;
    }

    public static String[][] getAllItemCanByName() {
        return itemCanByName;
    }

    public static int[][] getAllItemCanByPrice() {
        return itemCanByPrice;
    } 
}
