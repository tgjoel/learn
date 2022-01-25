package concepts.designpatterns.decorator;

public class PassengerCar extends Decorator {

    public PassengerCar(Car car) {
        super(car);
    }

    @Override
    public void design() {
        super.design();
        System.out.print(" Passenger Car");
    }
}
