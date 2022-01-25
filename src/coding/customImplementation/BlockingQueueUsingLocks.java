package coding.customImplementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueUsingLocks {

    public static void main(String[] args) {
        MyBlockingQueue<Integer> q = new MyBlockingQueue<>(10);
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                q.put(i);
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(q.take());
            }
        });
        producer.start();
        consumer.start();
    }
}

class MyBlockingQueue<T> {
    int size;
    Queue<T> queue;
    ReentrantLock reentrantLock = new ReentrantLock(true);
    Condition fullCondition = reentrantLock.newCondition();
    Condition emptyCondition = reentrantLock.newCondition();

    public MyBlockingQueue(int size) {
        this.size = size;
        this.queue = new LinkedList<>(); // can use array/arrayList as well. but then we need to maintain the head and tail indexes as well
    }

    public void put(T t) {
        reentrantLock.lock();
        try {
            while (queue.size() == size) {   //queue is full should not add the elements to the queue.
                /* used WHILE LOOP instead of IF CONDITION, to avoid the issue
                now suppose two threads trying to put the object, and the queue was full. as it checks the condition to be true
                both thread goes to wait state.
                now when object is removed from the queue, and signals both the thread, only one will able to acquire and then
                starts the execution and push new object. when it releases the lock the other thread tries, but it will get error as
                the only empty space is acquired again by the other thread. so if condition fails this scenario.
                Hence while loop condition is added as it would be checked before exiting the loop
                * */
                fullCondition.await();
            }
            queue.add(t);
            System.out.println("Producing - " + t);
            emptyCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
           reentrantLock.unlock(); // should always be kept in the finally block so it will be executed everytime
        }
    }

    public T take() {
        reentrantLock.lock();
        T t = null;
        try {
            while (queue.isEmpty()) {
                emptyCondition.await();
            }
            t = queue.remove();
            System.out.println("Consuming - " + t);
            fullCondition.signalAll();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return t;
    }
}
