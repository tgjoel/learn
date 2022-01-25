package concepts.abstractsample;

public class AbstractClassExample {
    public static void main(String[] args) {

        Apple apple = new Apple();
        Samsung samsung = new Samsung();
        showFeature(apple);
        showFeature(samsung);

    }

    public static void showFeature(Phone obj) {
        obj.showFeature();
    }
}

/*
 By creating the abstract class phone we only need to

 */


abstract class Phone {
    public abstract void showFeature();
}

class Apple extends Phone {

    @Override
    public void showFeature() {
        System.out.println("Apple configs");
    }
}

class Samsung extends Phone {
    @Override
    public void showFeature() {
        System.out.println("Samsung configs");
    }
}