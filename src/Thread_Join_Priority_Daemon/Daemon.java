package Thread_Join_Priority_Daemon;

public class Daemon {
    public static void main(String[] args)
    {
        Thread regularThread = new Thread(()->{
            System.out.println("Regular thread started");
            try{
                Thread.sleep(3000);
            }
            catch (Exception e)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println("Regular thread finished execution");
        });
        Thread daemonThread = new Thread(()->{
            System.out.println("Daemon thread started");
            try{
                Thread.sleep(5000);
            }
            catch (Exception e)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println("Daemon thread finished execution");
        });

        daemonThread.setDaemon(true);
        regularThread.start();
        daemonThread.start();

        System.out.println("Main thread finished execution");

        // Daemon thread will stop as soon as thread1 completes, it will not wait for
        // the remaining 2 seconds to complete
    }
}
