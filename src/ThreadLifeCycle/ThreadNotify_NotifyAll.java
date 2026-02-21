package ThreadLifeCycle;

public class ThreadNotify_NotifyAll {
    public static void main(String[] args)
    {
        SharedResource obj = new SharedResource();

        for(int i = 0; i<4; i++)
        {
            Thread thread1 = new Thread(() -> obj.task1(), "Worker - " + (i+1));
            thread1.start();
        }
        Thread thread2 = new Thread(() -> {
            System.out.println("Started new thread - " + Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            }
            catch (Exception e)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println("Updating IsReady as true after 6 seconds by - " + Thread.currentThread().getName());
            obj.makeReadyAll();
        });

        thread2.start();
    }
}
