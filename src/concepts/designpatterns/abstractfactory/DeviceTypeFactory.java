package concepts.designpatterns.abstractfactory;

public class DeviceTypeFactory {

    public static DeviceType getDeviceType(String str) {
        if(str.equals("laptop")) {
            return new LaptopDeviceFactory();
        } else {
            return new SmartPhoneDeviceFactory();
        }
    }
}
