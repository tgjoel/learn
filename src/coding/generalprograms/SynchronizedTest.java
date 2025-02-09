package coding.generalprograms;

public class SynchronizedTest {

    String name;

    public SynchronizedTest(String name) {
        this.name = name;
    }

    public synchronized void sych() {
        System.out.println(name  + "M1");
        System.out.println(name + "M2");
    }

    public static void main(String[] args) throws InterruptedException {

        SynchronizedTest o1 = new SynchronizedTest("O1");
        SynchronizedTest o2 = new SynchronizedTest("O2");

        Thread t1 = new Thread() {
            @Override
            public void run() {
                o1.sych();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                o2.sych();
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}


