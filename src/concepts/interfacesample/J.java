package concepts.interfacesample;

public interface J {

   default void show() {
        System.out.println("Inside show in interface J");
    }

    default void show2() {
        System.out.println("Inside show2 in interface J");
    }

    default void run() {
        System.out.println("Inside run in interface J");
    }

    void walk();

    static void display() {
        System.out.println("Inside display in interface J");
    }

    void print();
}
