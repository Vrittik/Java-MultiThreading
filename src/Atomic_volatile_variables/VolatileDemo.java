package Atomic_volatile_variables;

public class VolatileDemo {
    public static void main(String[] args)
    {
        SharedResource_Volatile obj = new SharedResource_Volatile();
        Thread th1 = new Thread(() ->{
            for(int i = 0; i<200; i++) {
                obj.increment();
            }
        });
        Thread th2 = new Thread(() ->{
            for(int i = 0; i<200; i++) {
                obj.increment();
            }
        });

        th1.start();
        th2.start();

        try{
            th1.join();
            th2.join();
        }
        catch (Exception e)
        {

        }
        int count = obj.getCount();
        System.out.println("Final count after the threads have completed their work = " + count);
        // Directly from memory
        // Final count after the threads have completed their work = 297
        // still after volatile, the issue persists because of non atomic
        // count++ operation
    }
}
