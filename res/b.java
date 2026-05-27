import encode.microedition.io.Connecto;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

final class b implements Runnable {
   private final String a;
   private final String b;
   private final int c;

   b(String var1, String var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void run() {
      try {
         Object var1 = null;
         TextMessage var2;
         MessageConnection var4;
         (var2 = (TextMessage)(var4 = (MessageConnection)Connecto.open(this.a)).newMessage("text")).setAddress(this.a);
         var2.setPayloadText(this.b);
         var4.send(var2);
         a.d();
         switch (this.c) {
            case 0:
               a.Y = 5;
               return;
            case 1:
               int[] var9 = a.V;
               var9[0] += 50;
               return;
            case 2:
               int[] var8 = a.V;
               var8[1] += 50;
               return;
            case 3:
               int[] var7 = a.V;
               var7[2] += 30;
               return;
            case 4:
               int[] var6 = a.V;
               var6[3] += 50;
               return;
            case 5:
               int[] var5 = a.V;
               var5[4] += 30;
               return;
            case 6:
               int[] var10000 = a.V;
               var10000[5] += 50;
               return;
            case 7:
               a.x = 1;
               a.a();
               a.t();
               return;
            case 8:
               a.x = 2;
               a.a();
               a.t();
               return;
            case 9:
               a.x = 3;
               a.a();
               a.t();
               return;
            default:
         }
      } catch (Exception var3) {
         switch (this.c) {
            case 0:
               a.Y = 6;
               return;
            default:
               a.s(7);
               a.a("Không thể mua. Xin hãy thử lại sau.");
               a.X = a.U;
               a.d = 7;
         }
      }
   }
}
