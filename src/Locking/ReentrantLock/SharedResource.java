package Locking.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    public void doWork(ReentrantLock lock)
    {
        lock.lock();
        System.out.println("Lock acquired by - " + Thread.currentThread().getName());
        try{
            Thread.sleep(4000);
        }
        catch (Exception e)
        {

        }
        finally {
            System.out.println("Lock released by - " + Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
