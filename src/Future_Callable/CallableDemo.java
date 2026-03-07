package Future_Callable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(4), new MyThreadFactory());

        // Submit accepts callable and runnable both, callable executes and
        // returns something
        // while runnable just executes some task
        // the type of object expected is put inside Future<String> like this
        // will return a string
        Future<String> futureObj = poolExecutor.submit(() -> {
            System.out.println("Running the task");
            return "Data returned from callable";
        });

        try {
            System.out.println("Task completed and returned message - "
                    + futureObj.get());
        }catch (Exception e)
        {

        }
        System.out.println("Is task completed now = " + futureObj.isDone());
        poolExecutor.shutdown();
    }
}
