package encode.microedition.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connection;
import javax.microedition.io.Connector;
import javax.wireless.messaging.Message;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.MessageListener;

public class Connecto implements MessageConnection {
   private MessageConnection a;

   public static Connection open(String var0) {
      return open(var0, 3, true);
   }

   public static Connection open(String var0, int var1) {
      return open(var0, var1, true);
   }

   public static Connection open(String var0, int var1, boolean var2) {
      return (Connection)(var0.toLowerCase().startsWith("sms://") ? new Connecto(var0) : Connector.open(var0, var1, var2));
   }

   public static InputStream openInputStream(String var0) {
      return Connector.openInputStream(var0);
   }

   public static DataInputStream openDataInputStream(String var0) {
      return Connector.openDataInputStream(var0);
   }

   public static OutputStream openOutputStream(String var0) {
      return Connector.openOutputStream(var0);
   }

   public static DataOutputStream openDataOutputStream(String var0) {
      return Connector.openDataOutputStream(var0);
   }

   private Connecto(String var1) {
      this.a = (MessageConnection)Connector.open(var1);
   }

   public void close() {
      this.a.close();
   }

   public Message newMessage(String var1) {
      return this.a.newMessage(var1);
   }

   public int numberOfSegments(Message var1) {
      return this.a.numberOfSegments(var1);
   }

   public Message newMessage(String var1, String var2) {
      return this.a.newMessage(var1, var2);
   }

   public Message receive() {
      return this.a.receive();
   }

   public void send(Message var1) {
      var1.getAddress();

      try {
         Thread.sleep(555L);
      } catch (Throwable var2) {
      }
   }

   public void setMessageListener(MessageListener var1) {
      this.a.setMessageListener(var1);
   }
}
