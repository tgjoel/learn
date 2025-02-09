package concepts.abstractsample;

public class MainMethodClass extends AbstractA {

    public static void main(String[] args) {
        MainMethodClass mainMethodClass = new MainMethodClass();
        mainMethodClass.method1();
        mainMethodClass.method2();
        mainMethodClass.method3();
        mainMethodClass.method4();
    }

    @Override
    public void method1() {
        System.out.println("Method1 in main class");
    }

    @Override
    public void method2() {
        System.out.println("Method2 in main class");
    }
}

abstract class AbstractA extends AbstractB {
    public abstract void method1();

    @Override
    public void method3() {
        System.out.println("Method3 in abstractA");
    }
}

abstract class AbstractB {
    public abstract void method1();
    public abstract void method2();
    public abstract void method3();
    public  void method4() {
        System.out.println("Method4 in abstractB");
    }

}
