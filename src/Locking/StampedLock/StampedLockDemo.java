package Locking.StampedLock;

public class StampedLockDemo {
    public static void main(String[] args)
    {
        SharedResource obj = new SharedResource();
        Thread thread1 = new Thread(() -> {
            obj.optimisticRead();
        });

        Thread thread2 = new Thread(() ->{
            obj.write();
        });

        thread1.start();
        thread2.start();

        // if we comment thread2.start() the thread1 will complete
        // otherwise thread1 will perform the rollback as the stamp changes in the 6 seconds
    }
}
