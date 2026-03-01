package ThreadPoolExecutorDemo;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCreationFactory implements ThreadFactory {

    public AtomicInteger threadNumber = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r)
    {
        String threadName = "Thread - " + threadNumber;
        System.out.println("Creating new thread - " + threadName);
        Thread th = new Thread(r, threadName);
        threadNumber.incrementAndGet();
        return th;
    }
}
