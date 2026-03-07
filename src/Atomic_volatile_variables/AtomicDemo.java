package Atomic_volatile_variables;

import java.util.Random;

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
        // Used CAS (Compare and Set)

        SharedResource_AtomicReference obj2 = new SharedResource_AtomicReference();
        Random rc = new Random();

        Thread th3 = new Thread(() ->{
            for(int i = 0; i<10; i++)
            {
                int age = rc.nextInt(5, 20);
                obj2.setNewUser(new User("Alice" + i, age));
            }
        });

        Thread th4 = new Thread(() ->{
            for(int i = 0; i<10; i++)
            {
                int age = rc.nextInt(25, 38);
                obj2.setNewUser(new User("Bob" + i, age));
            }
        });

        th3.start();
        th4.start();

        // Try 1
        // print user set while starting the threads
        System.out.println("\nTry 1 - started just now");
        obj2.getUser();

        try{
            th1.join();
            th2.join();
        }
        catch (Exception e)
        {

        }

        // Print final user after task completion
        System.out.println("\nTry 3 after waiting for threads to complete execution");
        obj2.getUser();

        // Used CAS (Compare and Set)

    }
}
