package Future_Callable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FutureDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(4), new MyThreadFactory());

        Future<?> futureObj = poolExecutor.submit(() -> {
            System.out.println("Running the task");
            try {
                Thread.sleep(4000);
                System.out.println("Task Completed");
            }
            catch(Exception e)
            {

            }
        });

        System.out.println("Is task completed = " + futureObj.isDone());
        System.out.println("Blocking main thread until task completes");
        try {
            futureObj.get();
        }catch (Exception e)
        {

        }
        System.out.println("Is task completed now = " + futureObj.isDone());
        poolExecutor.shutdown();
    }
}
