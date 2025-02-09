package concepts.designpatterns.abstractfactory;

public class Dell implements Device {
    @Override
    public void getDeviceDetails() {
        System.out.println("Dell");
    }
}
