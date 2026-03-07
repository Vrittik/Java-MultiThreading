package HitCounterProblem;

import java.util.Random;

public class HitCounterDemo {
    public static void main(String[] args)
    {
        //-------------------------------------------------------------------
        // Hit counter Circular Array
        HitCounter_Circular_Array hcCircularArray = new HitCounter_Circular_Array();
        Thread t1 = new Thread(() ->{
            HitSequence(hcCircularArray);
        });
        t1.start();
        try {
            // Worker thread hits continuously, main threads waits for 10 seconds
            // to check number of hits randomly
            Thread.sleep(3000);
        }
        catch(Exception e)
        {

        }
        System.out.println("HC Circular array count(last 5 mins) at Timestamp 400 = " + hcCircularArray.count(400));
        //-------------------------------------------------------------------

        //-------------------------------------------------------------------
        // Hit counter circular array thread safe
        ThreadSafeHitCounter_Circular_Array hcCircularArrayThreadSafe = new ThreadSafeHitCounter_Circular_Array();
        Thread t2 = new Thread(() ->{
            HitSequence(hcCircularArrayThreadSafe);
        });
        Thread t3 = new Thread(() ->{
            HitSequence(hcCircularArrayThreadSafe);
        });
        Thread t4 = new Thread(() ->{
            HitSequence(hcCircularArrayThreadSafe);
        });

        // Multiple threads started together and now thread safe execution will
        // guarantee correct result
        t2.start();
        t3.start();
        t4.start();
        try {
            // Worker thread hits continuously, main threads waits for 10 seconds
            // to check number of hits randomly
            Thread.sleep(3000);
        }
        catch(Exception e)
        {

        }
        System.out.println("HC Circular array thread safe count(last 5 mins) at Timestamp 400 = " + hcCircularArrayThreadSafe.count(400));
        //-------------------------------------------------------------------

    }


    public static void HitSequence(IHitCounter hitCounter)
    {
        Random rc = new Random();

        for(int s = 0; s<=700; s+= 100) {
            for (int j = 0; j < 100; j++) {
                int k = rc.nextInt(15);
                for (int i = 0; i < k; i++) {
                    hitCounter.hit(s + j);
                }
            }
            try {
                Thread.sleep(1000);
            }
            catch (Exception e)
            {

            }
        }
    }
}
