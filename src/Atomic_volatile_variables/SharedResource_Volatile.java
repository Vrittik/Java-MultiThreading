package Atomic_volatile_variables;

public class SharedResource_Volatile {
    volatile int count = 0;
    public int getCount(){
        return this.count;
    }

    public void increment(){
        count++;
    }
}
