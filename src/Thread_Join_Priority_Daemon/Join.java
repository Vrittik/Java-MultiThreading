package Thread_Join_Priority_Daemon;

public class Join {
    public static void main(String[] args){
        Thread t1 = new Thread(() -> {
            System.out.println("Thread - " +  Thread.currentThread().getName() + " Started");
            try {
                Thread.sleep(6000);
            }
            catch(Exception e)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread - " + Thread.currentThread().getName() + " has completed its execution");
        });

        t1.start();

        try
        {
            // Will stop until thread 1 has completed its execution before main
            // thread completes its execution
            t1.join();
        }
        catch (Exception e)
        {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread completed the execution");
    }
}
