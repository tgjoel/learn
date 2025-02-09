package concepts.designpatterns.abstractfactory;

public class LaptopDeviceFactory implements DeviceType{

    @Override
    public Device getDevice(String deviceName) {
        switch (deviceName) {
            case "HP": return new HP();
            case "Dell": return new Dell();
        }
        return null;
    }
}
