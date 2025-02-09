package concepts.executorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorSample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Integer> f1 = new SquareCalculator().calculate(10);

        int count = 0;
        while(!f1.isDone()) {
            if(count == 0) {
                System.out.println();
                System.out.print("Processing");
            }
            if(count%99999999 ==0) {
                System.out.print(".");
            }
            count++;
        }
        System.out.println();
        System.out.println(f1.get());
    }
}

class SquareCalculator {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input) {
        Future<Integer> integerFuture =  executorService.submit(() -> {
            //here we will add the logic
            //make the thread sleep for 1 sec
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input*input;
        });
        executorService.shutdown();
        return integerFuture;
    }
}
