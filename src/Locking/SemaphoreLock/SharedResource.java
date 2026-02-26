package Locking.SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SharedResource {
    Semaphore lock = new Semaphore(2);

    public void consume()
    {
        try {
            lock.acquire();
            System.out.println("Read lock acquired by - " + Thread.currentThread().getName());
            Thread.sleep(3000);
        }
        catch (Exception e){

        }
        finally {
            System.out.println("Read lock released by - " + Thread.currentThread().getName());
            lock.release();
        }
    }
}
