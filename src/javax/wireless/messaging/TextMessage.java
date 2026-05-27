package javax.wireless.messaging;

public interface TextMessage extends Message {
   void setAddress(String var1);

   String getPayloadText();

   void setPayloadText(String var1);
}
