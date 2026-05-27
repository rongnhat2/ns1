public final class Item {
    private static final String[] itemName;
    static {
        itemName = new String[] { "Bình HP nhỏ", "Bình HP vừa", "Bình HP to", "Bình MP nhỏ", "Bình MP vừa",
                "Bình MP to", "Ô 7", "Ô 8", "Ô 9", "Ô 10", "Ô 11", "Ô 12" };
    }
    public static String getItemName(int index) {
        return itemName[index];
    }
    public static String[] getAllItemNames() {
        return itemName;
    }

    public static String[][] getAllItemCanByName() {
        return ShopCatalog.kv;
    }

    public static int[][] getAllItemCanByPrice() {
        return ShopCatalog.kx;
    }
}
