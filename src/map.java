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

public final class map {
   
    private static final String[] mapName;
    static {
        mapName = new String[]{"Trường Hirosaki", "Khu luyện tập", "Làng Kenshin", "Rừng đào Sakura", "Rừng trúc Ura", "Thác Kitajima", "Cánh đồng Mishima", "Sông Watamaro", "Nghĩa địa Izuko", "Miếu Kojin", "Miếu Kamo", "Miếu Yazaka", "Rừng gỗ Kouji", "Rừng chông Hakata", "Vách đá Ito", "Thung lũng Taira", "Thôn Sanzu", "Lối vào Orochi", "Ngôi đền Orochi"};
    }
    public static String getMapName(int index) {
        return mapName[index];
    }
    public static String[] getAllMapNames() {
        return mapName;
    }
   public static void m(int var0) {
    if (var0 == 94) {
        a.setDx(true);
        a.setFf(24);
        a.setFg(288);
        a.setGn(94);
        a.setGo(12);
        a.setGp(288);
        a.setGA(1);
        a.setGl(false);
        a.setFn(1);
      }

      if (var0 == 0 && a.getCurrentQuestIndex() == 15 && a.isFb()) { 
        a.setGn(-1);
        a.setGl(false);
      }

      if (var0 == 0 && a.getCurrentQuestIndex() == 16 && a.isFc()) {
        a.setFb(true);
        a.setGn(0);
        a.setGl(true);
        a.setFv(true);
        a.setCurrentQuestIndex(-1);
        a.setFf(984);
        a.setFg(408); 
      } else {
         if (var0 == 95 && !a.isEI()) {
            a.setGl(false);
            a.setGo(599);
            a.setGp(264);
            a.setGA(-1);
            a.setGn(95);
         }

      }
   }
}

