package ThreadPoolExecutorDemo;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutionRejectionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
    {
        System.out.println("Rejected task - " + r.toString());
    }
}
