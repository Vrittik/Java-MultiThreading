package CompletableFuture;

import Future_Callable.MyThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    public static void main(String[] args)
    {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(4), new MyThreadFactory());
    }
}
