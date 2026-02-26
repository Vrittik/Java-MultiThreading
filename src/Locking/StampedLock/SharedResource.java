package Locking.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int value = 10;

    StampedLock lock = new StampedLock();

    public void optimisticRead()
    {
        long stamp = lock.tryOptimisticRead();

        System.out.println("Trying optimistic read by thread - " + Thread.currentThread().getName());

        value = 11;
        try{
            Thread.sleep(6000);
        }
        catch (Exception e)
        {

        }
        finally {
            if(lock.validate(stamp))
            {
                System.out.println("Successfully completed Optimistic Read");
            }
            else {
                value = 10; // rollback
                System.out.println("Stamp changed, Performing rollback by - " + Thread.currentThread().getName());
            }
        }
    }

    public void write()
    {
        long stamp = lock.writeLock();

        System.out.println("Write lock acquired by - " + Thread.currentThread().getName());
        value = 9;

        System.out.println(Thread.currentThread().getName() + " Completed write operation");
        // this below operation updates the stamp
        lock.unlockWrite(stamp);
        System.out.println("Write lock released by - " + Thread.currentThread().getName());
    }
}
