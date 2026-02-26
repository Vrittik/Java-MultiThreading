package Locking.SemaphoreLock;

public class SemaphoreLockDemo {
    public static void main(String[] args)
    {
        SharedResource obj = new SharedResource();
        Thread thread1 = new Thread(() -> {
            obj.consume();
        });
        Thread thread2 = new Thread(() -> {
            obj.consume();
        });
        Thread thread3 = new Thread(() -> {
            obj.consume();
        });
        Thread thread4 = new Thread(() -> {
            obj.consume();
        });

        // Since limit is 2, two threads can access the resource block together
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
