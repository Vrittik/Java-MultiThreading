package Locking.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args)
    {
        ReentrantLock lock = new ReentrantLock();

        Thread thread1 = new Thread(() ->{
            SharedResource obj = new SharedResource();
            obj.doWork(lock);
        });
        Thread thread2 = new Thread(() ->{
            SharedResource obj = new SharedResource();
            obj.doWork(lock);
        });

        thread1.start();
        thread2.start();
    }
}
