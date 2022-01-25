package concepts.designpatterns.abstractfactory;

public class DeviceClient {
    public static void main(String[] args) {

        Device dell = DeviceTypeFactory.getDeviceType("laptop").getDevice("Dell");
        dell.getDeviceDetails();

    }
}
