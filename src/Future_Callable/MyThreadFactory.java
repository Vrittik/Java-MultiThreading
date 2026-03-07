package Future_Callable;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    static int threadNumber = 1;
    public Thread newThread(Runnable r){

        System.out.println("Created new thread - Thread" + threadNumber);
        threadNumber++;
        return new Thread(r);
    }
}
