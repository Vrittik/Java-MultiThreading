package Locking.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args)
    {
        // ReadWriteLock is an interface
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread thread1 = new Thread(()->{
            SharedResource obj = new SharedResource();
            obj.consume(lock);
            obj.produce(lock);
        });

        Thread thread2 = new Thread(()->{
            SharedResource obj = new SharedResource();
            obj.consume(lock);
            obj.produce(lock);
        });

        thread1.start();
        thread2.start();
    }
}
