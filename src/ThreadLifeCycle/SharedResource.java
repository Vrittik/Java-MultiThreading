package ThreadLifeCycle;

public class SharedResource {
    public boolean isReady = false;

    public synchronized void makeReady()
    {
        isReady = true;
        notify(); // notify and wakes up the thread waiting on this object
        // which previously acquired the lock on this object
    }

    public synchronized void makeReadyAll()
    {
        isReady = true;
        notifyAll(); // notify and wakes up all the thread waiting on this object
        // which previously acquired the lock on this object
    }

    public synchronized void task1(){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("Started executing task 1 by - " + currentThreadName);
        while(!isReady)
        {
            System.out.println(currentThreadName + " is going into waiting state as isReady is false" +
                    " and releasing the monitor lock.");
            try{
                wait();
            }
            catch(Exception e)
            {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(currentThreadName + " Wakes up");
        System.out.println("Completed task1 by - " + currentThreadName);
    }
}
