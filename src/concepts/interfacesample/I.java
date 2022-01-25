package concepts.interfacesample;

public interface I {

    default void show() {
        System.out.println("Inside show in interface I");
    }

    static void display() {
        System.out.println("Inside display in interface I");
    }

    void print();

    /*
     we cannot override the methods in the Object class

    default boolean equals(Object o) {
        return true;
    }

     */
}
