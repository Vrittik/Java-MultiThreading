package Atomic_volatile_variables;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource_AtomicInteger {
    AtomicInteger count = new AtomicInteger(0);
    public int getCount(){
        return this.count.get();
    }

    public void increment(){
        // atomic is used when compare load and modify is used by multiple threads
        // for lock free concurrency
        count.incrementAndGet();
        // count.addAndGet(10); - to add certain value to the atomic integer
    }
}
