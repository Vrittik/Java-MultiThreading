package HitCounterProblem;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeHitCounter_Circular_Array implements IHitCounter{

    public int WINDOW_SIZE = 300;

    public int[] timeStamp = new int[WINDOW_SIZE];
    public AtomicIntegerArray hits = new AtomicIntegerArray(WINDOW_SIZE);
    public ReentrantLock[] fineGrainReentrantLocks = new ReentrantLock[WINDOW_SIZE];
    public AtomicInteger lastWindowHits = new AtomicInteger(0);

    public ThreadSafeHitCounter_Circular_Array(){
        for(int i = 0; i<WINDOW_SIZE; i++)
        {
            fineGrainReentrantLocks[i] = new ReentrantLock();
        }
    }
    public void hit(int currentTimeStamp){
        int index = currentTimeStamp % WINDOW_SIZE;
        try {
            fineGrainReentrantLocks[index].lock();
            // We need locking as the atomic integer is just responsible for
            // the increment etc. operations. But our code requires updating
            // more than just an atomic value, that's why we need to have
            // locks as well
            // We didn't use global lock as it will make update slower, we
            // use locks per bucket to improve efficiency and reduce contention
            if(timeStamp[index] != currentTimeStamp)
            {
                timeStamp[index] = currentTimeStamp;
                lastWindowHits.addAndGet(-hits.get(index));
                hits.set(index, 1);
            }
            else{
                hits.addAndGet(index, 1);
            }
            lastWindowHits.incrementAndGet();
        }
        finally {
            fineGrainReentrantLocks[index].unlock();
        }

    }

    public int count(int currentTimeStamp)
    {
        return lastWindowHits.get();
    }
}
