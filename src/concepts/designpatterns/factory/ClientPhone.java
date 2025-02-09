package concepts.designpatterns.factory;

public class ClientPhone {
    public static void main(String[] args) {
        //without using factory pattern.
        Phone android = new AndroidPhone();
        Phone apple = new IPhone();
        Phone windows = new WindowsPhone();
        windows.getSpec();


        //by using the factory pattern
        Phone android1 = PhoneFactory.getPhone("google");
        Phone apple1 = PhoneFactory.getPhone("apple");
        Phone windows1 = PhoneFactory.getPhone("microsoft");
        android1.getSpec();
        apple1.getSpec();

    }
}
