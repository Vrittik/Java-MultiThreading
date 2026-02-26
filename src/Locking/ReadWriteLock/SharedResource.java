package Locking.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    public void consume(ReadWriteLock lock)
    {
        lock.readLock().lock();
        System.out.println("Read lock acquired by - " + Thread.currentThread().getName());
        try{
            Thread.sleep(4000);
        }
        catch (Exception e){

        }
        finally {
            System.out.println("Read lock released by - " + Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public void produce(ReadWriteLock lock)
    {
        lock.writeLock().lock();
        System.out.println("Write lock acquired by - " + Thread.currentThread().getName());
        try{
            Thread.sleep(4000);
        }
        catch (Exception e){

        }
        finally {
            System.out.println("Write lock released by - " + Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }
}
