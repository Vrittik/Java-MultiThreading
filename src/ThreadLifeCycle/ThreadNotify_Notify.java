package ThreadLifeCycle;

public class ThreadNotify_Notify {
    public static void main(String[] args)
    {
        SharedResource obj = new SharedResource();

        Thread thread1 = new Thread(() -> obj.task1());
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
            obj.makeReady();
        });

        thread1.start();
        thread2.start();
    }
}
