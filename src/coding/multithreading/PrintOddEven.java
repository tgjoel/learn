package coding.multithreading;

public class PrintOddEven {
    int n;
    int counter = 1;
    char chc = 'A';
    char chs = 'a';

    public void setN(int n) {
        this.n = n;
    }

    public synchronized void printOddNumber() {
        while (counter < n) {
            if (counter % 2 == 0) { // when the counter is even wait, else print the odd number
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            //System.out.println(counter);
            System.out.print(chc++);
            counter++;
            notify();
        }
    }

    public synchronized void printEvenNumber() {
        while (counter < n) {
            if (counter % 2 != 0) { // when the counter is odd wait, else print the odd number
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            //System.out.println(counter);
            System.out.print(chs++);
            counter++;
            notify();
        }
    }

    public static void main(String[] args) {

        PrintOddEven itc = new PrintOddEven();
        itc.setN(52);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                itc.printOddNumber();
               // itc.printCapitalLetter();
            }
        });
        Thread t2 = new Thread(() -> {
            itc.printEvenNumber();
            //itc.printSmallLetter();
        });

        t1.start();
        t2.start();

      //  for (;; System.out.println()) Stream.of("a", "b", "c").parallel().forEachOrdered(System.out::print);
    }
}
