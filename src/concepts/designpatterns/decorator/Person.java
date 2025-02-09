package concepts.designpatterns.decorator;

public class Person {
    public static void main(String[] args) {

        System.out.println();
        Car basicCar = new BasicCar();
        basicCar.design();

        System.out.println();
        Car passengerCar = new PassengerCar(basicCar);
        passengerCar.design();

        System.out.println();
        Car luxuryCar = new LuxuryCar(basicCar);
        luxuryCar.design();

        System.out.println();
        Car luxuryPassenger = new LuxuryCar(luxuryCar);
        luxuryPassenger.design();

    }
}
