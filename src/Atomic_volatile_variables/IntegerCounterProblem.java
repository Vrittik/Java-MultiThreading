package Atomic_volatile_variables;

public class IntegerCounterProblem {
    public static void main(String[] args)
    {
        SharedResource_IntegerCounterProblem obj = new SharedResource_IntegerCounterProblem();
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
        // Final count after the threads have completed their work = 341
        // This is not thread safe counter++, because
        // this involves 3 steps, load counter, increment it by 1 and then assign back
        // all these 3 operations are not atomic
        // it may be possible that 2 thread simultaneously load same counter value before
        // incrementing it, so loss of data can happen, but not guaranteed
    }
}
