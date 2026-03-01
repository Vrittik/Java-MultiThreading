package ThreadPoolExecutorDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args)
    {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3, 5, 10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new ThreadCreationFactory(),
                new ExecutionRejectionHandler());
        executor.allowCoreThreadTimeOut(true);

        for(int i = 0; i<8; i++)
        {
            int taskNumber = i+1;
            runTask(executor, taskNumber);
        }

        // Task 1, 2, 3 will be processed by initial 3 threads
        // Task 4, 5 will be put in the queue for processing later
        // Executor will create 2 more threads for task 6, 7
        // Executor will reject task 8 due to limits exhausted for queue size, maximum pool size
        executor.shutdown();
    }

    public static void runTask(ThreadPoolExecutor executor, int taskNumber){
        executor.submit(() ->{
            try{
                Thread.sleep(4000);
            }
            catch (Exception e)
            {
                // handle exception
            }
            System.out.println("Task " + taskNumber + " completed by - " + Thread.currentThread().getName());
        });
    }
}
