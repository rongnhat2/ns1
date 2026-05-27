package javax.bluetooth;

public final class LocalDevice {
   private LocalDevice() {
   }

   public static LocalDevice getLocalDevice() {
      return new LocalDevice();
   }

   public String getBluetoothAddress() {
      return null;
   }
}
