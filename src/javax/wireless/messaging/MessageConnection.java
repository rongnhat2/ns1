package javax.wireless.messaging;

import java.io.IOException;

public interface MessageConnection {
   void close();

   Message newMessage(String var1);

   int numberOfSegments(Message var1);

   Message newMessage(String var1, String var2);

   Message receive() throws IOException;

   void send(Message var1) throws IOException;

   void setMessageListener(MessageListener var1);
}
