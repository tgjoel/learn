package coding.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class PrintOddEvenUsingSemaphore {
    public static void main(String[] args) {
        PrintOddEvenNumbers oddEvenNumbers = new PrintOddEvenNumbers();

        /* >>>>>  one way  >>>>
        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i = i+2) {
                    oddEvenNumbers.printOddNumber(i);
                }
            }
        });
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 50; i = i+2) {
                oddEvenNumbers.printEvenNumber(i);
            }
        });
        oddThread.start();
        evenThread.start();
        */

        //Second way
        PrintOddEvenNumbers poe = new PrintOddEvenNumbers();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Odd(poe));
        executorService.submit(new Even(poe));
        executorService.shutdown();
    }
}

class Odd implements Runnable {
    PrintOddEvenNumbers printOddEvenNumbers;
    public Odd(PrintOddEvenNumbers poe) {
        this.printOddEvenNumbers = poe;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 50; i = i + 2) {
            printOddEvenNumbers.printOddNumber(i);
        }
    }
}

class Even implements Runnable {
    PrintOddEvenNumbers printOddEvenNumbers;
    public Even(PrintOddEvenNumbers poe) {
        this.printOddEvenNumbers = poe;
    }
    @Override
    public void run() {
        for (int i = 2; i <= 50; i = i + 2) {
            printOddEvenNumbers.printEvenNumber(i);
        }
    }
}

class PrintOddEvenNumbers {

    private Semaphore oddSemaphore = new Semaphore(1); // so odd will start first
    private Semaphore evenSemaphore = new Semaphore(0);

    void printOddNumber(int i) {
        try {
            oddSemaphore.acquire();
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }
        System.out.print(i + " ");
        evenSemaphore.release();
    }

    void printEvenNumber(int i) {
        try {
            evenSemaphore.acquire();
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }
        System.out.print(i + " ");
        oddSemaphore.release();
    }
}
