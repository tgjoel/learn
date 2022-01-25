package concepts.interfacesample;

public class A extends B implements I, J {

    @Override
    public void print() {
        System.out.println("Inside print in class A");
    }

    @Override
    public void show() {
        I.super.show();
        J.super.show();
        J.super.show2();
    }

//    public static void display() {
//        System.out.println("Display in class A");
//        J.display();
//        I.display();
//    }

    public static void main(String[] args) {
        A a = new A();
        a.run();
        a.print();
        a.show();
        a.show2();
        a.walk();
        J.display(); // ----> cannot call as A.display for static methods
       // a.display(); ERROR
    }

}
