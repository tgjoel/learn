package coding.customImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueueUsingWaitAndNotify {
    public static void main(String[] args) {

        MyBlockingQueueUsingWaitNotifyAll<Integer> obj = new MyBlockingQueueUsingWaitNotifyAll<>(10);

    }
}

class MyBlockingQueueUsingWaitNotifyAll<T> {

    int size;
    Queue<T> queue;

    public MyBlockingQueueUsingWaitNotifyAll(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public synchronized void put(T t) {
        try {
            while(queue.size() == size) {
                wait();
            }
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        queue.add(t);
        if(queue.size() == 1) {
            notifyAll();
        }
    }

    public synchronized T take() {
        try {
             while (queue.isEmpty()) {
                 wait();
             }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T t = queue.remove();
        if(queue.size() == size) {
            notifyAll();
        }
        return t;
    }
}
