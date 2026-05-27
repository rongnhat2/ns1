import java.util.Vector;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStore;

public class Midlet extends MIDlet implements Runnable {
   static boolean lowGfx;
   static a b;
   static Midlet c;
   private static boolean i = true;
   public static int d;
   public static boolean e;
   public static boolean f;
   private static Image[] j;
   private static final int[] k = new int[]{5, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 5, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 6, 5, 5, 5, 5, 5, 5, 5, 5, 7, 5, 5, 5};
   private static int l = 8;
   private static Image m;
   private static final int[] n = new int[]{2, 6, 3, 5, 6, 6, 6, 5, 6, 6, 6, 3, 3, 3, 2, 6, 4, 4, 5, 3, 6, 8, 8, 8, 8, 8, 8, 8, 8, 3, 8, 8, 8, 10, 8, 8, 8, 8, 8, 7, 8, 8, 8, 10, 8, 8, 8, 6, 6, 6, 6, 6, 5, 6, 6, 3, 5, 6, 3, 8, 6, 6, 6, 6, 6, 6, 5, 6, 6, 8, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 3, 3, 3, 3, 3, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
   private static int o = 12;
   private static Image p;
   private static final int[] q = new int[]{3, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 4, 3, 3, 3, 6, 7, 7, 8, 5, 11, 11, 7, 6, 10, 6, 7, 5, 7, 6, 5, 7, 7, 3, 3, 6, 3, 9, 7, 7, 7, 7, 4, 5, 4, 8, 6, 9, 7, 6, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4, 3, 3, 3, 3, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 7, 7, 8, 7, 8, 8, 8, 7, 7, 8, 7, 6, 7, 8, 8, 8, 8, 8, 6, 6, 6, 6, 6, 7, 8, 7, 7, 8, 6, 6, 8, 8, 3, 6, 7, 6, 11, 9, 8, 7, 8, 7, 5, 6, 8, 7, 11, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 6, 6, 6, 6, 6, 6, 7, 6, 6, 6, 6, 5, 5, 5, 6, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 9};
   private static int r = 13;
   public static int g = 0;
   private static Player s;
   private static int t;
   public static boolean h;
   /** true = dừng trước khi đóng emulator để đọc log (tắt khi build release). */
   public static boolean DEBUG_STOP_ON_EXIT = false;
   /** Thời gian chờ (ms) trước notifyDestroyed. */
   public static int DEBUG_STOP_MS = 120000;

   static {
      try {
         j = new Image[3];

         for(int var0 = 0; var0 < 3; ++var0) {
            j[var0] = Image.createImage("/fs" + var0 + ".png");
         }
      } catch (Exception var3) {
      }

      try {
         m = Image.createImage("/fr.png");
      } catch (Exception var2) {
      }

      try {
         p = Image.createImage("/fb.png");
      } catch (Exception var1) {
      }

      t = -1;
   }

   private static void b(int var0) {
      if (var0 != t) {
         try {
            if (s != null) {
               s.stop();
               s.deallocate();
               s = null;
               System.gc();
            }

            (s = Manager.createPlayer("".getClass().getResourceAsStream("/s/" + var0 + ".mid"), "audio/midi")).realize();
            ((VolumeControl)s.getControl("VolumeControl")).setLevel(100);
            s.prefetch();
            s.setLoopCount(1000);
            t = var0;
         } catch (Exception var1) {
            ((Throwable)var1).printStackTrace();
            System.gc();
            h = true;
         }
      }
   }

   public static void a(Graphics var0, String var1, int var2, int var3, int var4) {
      int var5 = var1.length();
      if (var4 == 0) {
         var4 = var2;
      } else if (var4 == 1) {
         var4 = var2 - a(var1);
      } else {
         var4 = var2 - (a(var1) >> 1);
      }

      for(int var6 = 0; var6 < var5; ++var6) {
         if ((var2 = " 0123456789.,:!?()+-*/#$%abcdefghijklmnopqrstuvwxyzáàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(var1.charAt(var6))) == -1) {
            var2 = 0;
         }

         if (var2 > -1) {
            var0.drawRegion(p, 0, var2 * r + 1, q[var2], r - 1, 0, var4, var3, 20);
         }

         var4 += q[var2];
      }

   }

   public static void b(Graphics var0, String var1, int var2, int var3, int var4) {
      int var5 = var1.length();
      var4 = var2 - (c(var1) >> 1);

      for(int var6 = 0; var6 < var5; ++var6) {
         if ((var2 = " 0123456789.,:!?()-'/ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzáàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđĐ".indexOf(var1.charAt(var6))) == -1) {
            var2 = 0;
         }

         if (var2 > -1) {
            var0.drawRegion(m, 0, var2 * o + 1, n[var2], o - 1, 0, var4, var3, 20);
         }

         var4 += n[var2];
      }

   }

   public static void a(Graphics var0, String var1, int var2, int var3, int var4, int var5) {
      int var6 = var1.length();
      if (var5 == 0) {
         var5 = var3;
      } else if (var5 == 1) {
         var5 = var3 - d(var1);
      } else {
         var5 = var3 - (d(var1) >> 1);
      }

      for(int var7 = 0; var7 < var6; ++var7) {
         if ((var3 = "0123456789+-%$:abcdefghijklmnopqrstuvwxyz".indexOf(var1.charAt(var7))) == -1) {
            var3 = 0;
         }

         if (var3 > -1) {
            var0.drawRegion(j[var2], 0, var3 * l, k[var3], l, 0, var5, var4, 20);
         }

         var5 += k[var3] - 1;
      }

   }

   public static int a(String var0) {
      int var2 = 0;

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         int var1;
         if ((var1 = " 0123456789.,:!?()+-*/#$%abcdefghijklmnopqrstuvwxyzáàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(var0.charAt(var3))) == -1) {
            var1 = 0;
         }

         var2 += q[var1];
      }

      return var2;
   }

   private static int c(String var0) {
      int var2 = 0;

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         int var1;
         if ((var1 = " 0123456789.,:!?()-'/ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzáàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđĐ".indexOf(var0.charAt(var3))) == -1) {
            var1 = 0;
         }

         var2 += n[var1];
      }

      return var2;
   }

   private static int d(String var0) {
      int var2 = 0;

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         int var1;
         if ((var1 = "0123456789+-%$:abcdefghijklmnopqrstuvwxyz".indexOf(var0.charAt(var3))) == -1) {
            var1 = 0;
         }

         var2 += k[var1] + 1;
      }

      return var2;
   }

   public static byte[] b(String var0) {
      try {
         RecordStore var3;
         byte[] var1 = (var3 = RecordStore.openRecordStore(var0, false)).getRecord(1);
         var3.closeRecordStore();
         return var1;
      } catch (Exception var2) {
         return null;
      }
   }

   public static int a() {
      byte[] var0;
      return (var0 = b("bg")) == null ? 0 : var0[0];
   }

   public static void a(String var0, byte[] var1) {
      try {
         RecordStore var3;
         if ((var3 = RecordStore.openRecordStore(var0, true)).getNumRecords() > 0) {
            var3.setRecord(1, var1, 0, var1.length);
         } else {
            var3.addRecord(var1, 0, var1.length);
         }

         var3.closeRecordStore();
      } catch (Exception var2) {
      }
   }

   public static void a(boolean var0) {
      byte[] var1;
      (var1 = new byte[1])[0] = 1;
      a("saved", var1);
   }

   public static boolean b() {
      byte[] var0;
      if ((var0 = b("saved")) == null) {
         return false;
      } else {
         return var0[0] == 1;
      }
   }

   public static void a(int var0) {
      byte[] var1;
      (var1 = new byte[1])[0] = (byte)var0;
      a("bg", var1);
   }

   public static String[] a(String var0, int var1) {
      Vector var2 = new Vector();
      int var3;
      if ((var3 = var0.length()) <= 1) {
         return new String[]{var0};
      } else {
         String var4 = "";
         int var5 = 0;
         int var6 = 0;
         int var8;

         while(true) {
            while(a(var4) < var1) {
               var4 = var4 + var0.charAt(var6);
               ++var6;
               if (var0.charAt(var6) == '\n') {
                  break;
               }

               if (var6 >= var3 - 1) {
                  var6 = var3 - 1;
                  break;
               }
            }

            if (var6 != var3 - 1 && var0.charAt(var6 + 1) != ' ') {
               for(var8 = var6; var0.charAt(var6 + 1) != '\n' && (var0.charAt(var6 + 1) != ' ' || var0.charAt(var6) == ' ') && var6 != var5; --var6) {
               }

               if (var6 == var5) {
                  var6 = var8;
               }
            }

            var2.addElement(var0.substring(var5, var6 + 1));
            if (var6 == var3 - 1) {
               break;
            }

            for(var5 = var6 + 1; var5 != var3 - 1 && var0.charAt(var5) == ' '; ++var5) {
            }

            if (var5 == var3 - 1) {
               break;
            }

            var6 = var5;
            var4 = "";
         }

         String[] var9 = new String[var2.size()];

         for(int var7 = 0; var7 < var2.size(); ++var7) {
            var9[var7] = (String)var2.elementAt(var7);
         }

         return var9;
      }
   }

   public static String[] b(String var0, int var1) {
      Vector var2 = new Vector();
      int var3 = var0.length();
      String var4 = "";
      int var5 = 0;
      int var6 = 0;
      int var8;

      while(true) {
         while(c(var4) < var1) {
            var4 = var4 + var0.charAt(var6);
            ++var6;
            if (var6 == var3 - 1) {
               break;
            }
         }

         if (var6 != var3 - 1 && var0.charAt(var6 + 1) != ' ') {
            for(var8 = var6; (var0.charAt(var6 + 1) != ' ' || var0.charAt(var6) == ' ') && var6 != var5; --var6) {
            }

            if (var6 == var5) {
               var6 = var8;
            }
         }

         var2.addElement(var0.substring(var5, var6 + 1));
         if (var6 == var3 - 1) {
            break;
         }

         for(var5 = var6 + 1; var5 != var3 - 1 && var0.charAt(var5) == ' '; ++var5) {
         }

         if (var5 == var3 - 1) {
            break;
         }

         var6 = var5;
         var4 = "";
      }

      String[] var9 = new String[var2.size()];

      for(int var7 = 0; var7 < var2.size(); ++var7) {
         var9[var7] = (String)var2.elementAt(var7);
      }

      return var9;
   }

   public Midlet() {
      System.out.println(a.b("7218"));
      c = this;
      a.s();
      Display.getDisplay(this).setCurrent(b);
   }

   protected void destroyApp(boolean var1) {
      System.err.println("[EXIT] destroyApp unconditional=" + var1);
      if (s != null) {
         try {
            s.stop();
         } catch (MediaException var2) {
         }

         s.deallocate();
      }

   }

   public final void c() {
      this.exit("?");
   }

   public final void exit(String var1) {
      System.err.println("[EXIT] " + var1);
      (new Exception("[EXIT] stack")).printStackTrace();
      if (DEBUG_STOP_ON_EXIT && DEBUG_STOP_MS > 0) {
         try {
            System.err.println("[EXIT] pause " + DEBUG_STOP_MS + "ms (doc console truoc khi emulator dong)");
            Thread.sleep((long)DEBUG_STOP_MS);
         } catch (InterruptedException var2) {
         }
      }

      System.gc();
      ((MIDlet)this).notifyDestroyed();
   }

   protected void pauseApp() {
   }

   public void run() {
      try {
         Thread.sleep(200L);
         Thread.yield();
         a.w = a.a((int)System.currentTimeMillis() % 1000);
         a.R = 30;
         Thread.yield();
         map.m(a.v);
         a.q(a.v);
         a.p(a.v);
         a.o(a.v);
         a.R = 50;
         Thread.yield();
         a.t(a.v);
         a.i();
         a.f(a.v);
         a.g(a.v);
         a.e(a.v);
         a.R = 65;
         Thread.yield();
         a.r(a.v);
         a.R = 70;
         Thread.yield();
         a.h(a.v);
         a.i(a.v);
         a.j(a.v);
         a.k(a.v);
         a.l(a.v);
         a.R = 75;
         a.k();
         a.g();
         a.p();
         a.R = 78;
         Thread.yield();
         a.d(a.v);
         a.c(a.v);
         a.R = 80;
         a.l();
         a.r();
         a.R = 82;
         Thread.yield();
         a.q();
         a.n();
         a.m();
         a.R = 85;
         a.b(a.v);
         a.f();
         a.o();
         a.R = 87;
         a.e();
         a.h();
         a.j();
         a.R = 95;
         Thread.yield();
         a.i = (new int[]{5614318, 18})[g];

         try {
            if (!a.a) {
               if (a.s == null) {
                  a.s = new Image[4];

                  for(int var5 = 0; var5 < 4; ++var5) {
                     a.s[var5] = Image.createImage("/bg" + var5 + g + ".png");
                  }
               }

               if (a.t == null) {
                  a.t = Image.createImage("/cl" + g + ".png");
               }

               if (a.u == null) {
                  a.u = Image.createImage("/sun" + g + ".png");
               }
            }
         } catch (Exception var2) {
         }

         a.b = false;
         if (a.v != 0 && !a.a) {
            a.b = true;
            a.p = a.r - (a.s[0].getHeight() + a.s[1].getHeight() + a.s[2].getHeight()) + 11;
            a.l = (a.k = (a.j = a.r - a.s[0].getHeight()) - a.s[1].getHeight()) - a.s[2].getHeight();
            a.m = a.k - a.s[3].getHeight() - 10;
         }

         int var6;
         if ((var6 = 2 * a.r / 3 - a.k) < 0) {
            var6 = 0;
         }

         if (a.v < 19) {
            a.W[a.v] = true;
         }

         a.p += var6;
         a.j += var6;
         a.k += var6;
         a.l += var6;
         a.m += var6;
         a.g = 3 * a.q / 4;
         a.h = a.p / 3;
         a.e = new int[2];
         a.f = new int[2];
         a.e[0] = a.q / 3;
         a.f[0] = a.p / 2 - 8;
         a.e[1] = 2 * a.q / 3;
         a.f[1] = a.p / 2 + 8;
         a.c = true;
         a.n = "Menu";
         a.o = " ";
         a.T = false;
         a.n(a.v);
         a.R = 100;
         if (i) {
            i = false;
            a.E = 20;
            a.F = 10;
            a.H = 200;
            a.G = 200;
            a.J = 150;
            a.I = 150;
            a.currentQuestIndex = -1;
            a.P = 5;
            a.K = 6;
            a.L = 2;
            a.Q = 8;
            a.A = 4;
            a.y = 1;
            a.z = 1;
            a.B = 0;
            a.D = 0;
            a.C = 0;
            a.characterLevel = 1;
            a.N = 0;
         }

         a.d();
         a.c();
         if (e) {
            a.b();
            e = false;
         } else if (f) {
            a.a();
            f = false;
         }

         switch (a.v) {
            case 0:
            case 1:
            case 2:
               b(1);
               break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
               b(2);
               break;
            case 95:
            case 96:
            case 97:
               b(4);
               break;
            case 99:
               b(0);
               break;
            default:
               b(3);
         }

         if (!h) {
            try {
               s.start();
            } catch (Exception var1) {
               ((Throwable)var1).printStackTrace();
            }
         }
      } catch (Exception var3) {
         ((Throwable)var3).printStackTrace();
         System.gc();
         a.d = 4;
         a.av();
         Midlet.f = false;
         Midlet.e = false;
      }

      while(a.S < 90) {
         Thread.yield();
      }

      a.d = d;
   }

   protected void startApp() {
   }
}
