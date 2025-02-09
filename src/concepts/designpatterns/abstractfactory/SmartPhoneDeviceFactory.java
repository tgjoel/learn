package concepts.designpatterns.abstractfactory;

public class SmartPhoneDeviceFactory implements DeviceType {
    @Override
    public Device getDevice(String deviceName) {
        switch (deviceName) {
            case "Samsung": return new Samsung();
            case "Onplus": return new Oneplus();
        }
        return null;
    }
}
