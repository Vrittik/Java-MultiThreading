package Atomic_volatile_variables;

public class AtomicDemo {
    public static void main(String[] args)
    {
        SharedResource_AtomicInteger obj = new SharedResource_AtomicInteger();
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
        // Used CAS (Compare and swap)
    }
}
