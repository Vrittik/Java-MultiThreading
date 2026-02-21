package ThreadLifeCycle;

public class TaskDefinition {
    public synchronized void task1(){
        System.out.println("Started Execution of task 1 by - " + Thread.currentThread().getName());
        try
        {
            System.out.println("Executing task 1 by - " + Thread.currentThread().getName());
            Thread.sleep(10000);
        }
        catch (Exception e)
        {
            System.out.println("Something failed while executing task 1");
        }
        System.out.println("Completed Execution of task 1 in 10 seconds by - " + Thread.currentThread().getName());
    }

    public void task2(){
        System.out.println("Started Execution of task 2 before locking by - " + Thread.currentThread().getName());
        synchronized (this)
        {
            System.out.println("Executing task 2 by - " + Thread.currentThread().getName());
        }
        System.out.println("Completed Execution of task 2 by - " + Thread.currentThread().getName());
    }

    public void task3(){
        System.out.println("Completed Execution of task 3 by - " + Thread.currentThread().getName());
    }
}
