package concepts.designpatterns.decorator;

public class LuxuryCar extends Decorator {
    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void design() {
        super.design();
        System.out.print(" Luxuary Car");
    }
}
