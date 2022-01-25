package coding.customImplementation;

import java.util.concurrent.LinkedBlockingQueue;

interface MyExecutorService {
    void submit(Runnable r);
}

class MyThreadPool implements MyExecutorService {
    static int capacity;
    static int currentCapacity;
    static LinkedBlockingQueue<Runnable> linkedBlockingQueue; // will not deque if empty also will not enqueue if full. thread safe
    Execution e;

    public MyThreadPool(int capacity) {
        this.capacity = capacity;
        currentCapacity = 0;
        linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        e = new Execution();
    }

    @Override
    public void submit(Runnable r) {
        linkedBlockingQueue.add(r);
        e.executeMyMethod();
    }
}

class Execution implements Runnable {
    void executeMyMethod() {
        if (MyThreadPool.currentCapacity < MyThreadPool.capacity) {
            MyThreadPool.currentCapacity++;
            Thread t = new Thread(new Execution());
            t.start();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (MyThreadPool.linkedBlockingQueue.size() != 0) {
                MyThreadPool.linkedBlockingQueue.poll().run();
            }
        }
    }
}

class MyExecutors {
    int capacity;

    static MyExecutorService myNewFixedThreadPool(int capacity) {
        return new MyThreadPool(capacity);
    }
}

class MyTask implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hi " + Thread.currentThread().getName());
    }
}

public class CustomExecutionService {
    public static void main(String[] args) {
        MyExecutorService service = MyExecutors.myNewFixedThreadPool(4);
        for (int i = 0; i < 20; i++) {
            service.submit(new MyTask());
        }
    }
}
