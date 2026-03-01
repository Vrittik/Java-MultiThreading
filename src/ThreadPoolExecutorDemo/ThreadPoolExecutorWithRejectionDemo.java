package ThreadPoolExecutorDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorWithRejectionDemo {
    public static void main(String[] args)
    {
        // Abort policy
        System.out.println("AbortPolicy Executor");
        ThreadPoolExecutor abortPolicyExeuctor = new ThreadPoolExecutor(
                3, 5, 10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new ThreadCreationFactory(),
                new ThreadPoolExecutor.AbortPolicy()); // Throws Exception

        runTask(abortPolicyExeuctor);
        abortPolicyExeuctor.shutdown();
        System.out.println("\n\n");

        // CallerRunsPolicy
        System.out.println("CallerRunsPolicy Executor");
        ThreadPoolExecutor callerRunsPolicyExecutor = new ThreadPoolExecutor(
                3, 5, 10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new ThreadCreationFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()); // ask the caller to run

        runTask(callerRunsPolicyExecutor);
        callerRunsPolicyExecutor.shutdown();
        System.out.println("\n\n");

        // DiscardOldestPolicy
        System.out.println("discardOldestPolicy Executor");
        ThreadPoolExecutor discardOldestPolicyExecutor = new ThreadPoolExecutor(
                3, 5, 10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new ThreadCreationFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()); // ask the caller to run

        runTask(discardOldestPolicyExecutor);
        discardOldestPolicyExecutor.shutdown();
        System.out.println("\n\n");

        // DiscardPolicy
        System.out.println("discardPolicy Executor");
        ThreadPoolExecutor discardPolicyExecutor = new ThreadPoolExecutor(
                3, 5, 10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new ThreadCreationFactory(),
                new ThreadPoolExecutor.DiscardPolicy()); // ask the caller to run

        runTask(discardPolicyExecutor);
        discardPolicyExecutor.shutdown();
        System.out.println("\n\n");
    }

    public static void runTask(ThreadPoolExecutor executor){
        for(int i = 0; i<8; i++) {
            int taskNumber = i + 1;
            try {
                executor.submit(() -> {
                    try {
                        Thread.sleep(4000);
                    } catch (Exception e) {
                        // handle exception
                    }
                });
            }
            catch (Exception e)
            {
                System.out.println("Exception to run the task - " + taskNumber + " from executor - " + executor.toString());
            }
        }
    }
}
