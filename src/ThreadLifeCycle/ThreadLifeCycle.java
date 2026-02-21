package ThreadLifeCycle;

public class ThreadLifeCycle {
    public static void main(String[] args) {
        TaskDefinition obj = new TaskDefinition();

        Thread thread1 = new Thread(() -> {
            obj.task1();
        });
        Thread thread2 = new Thread(() -> {
            obj.task2();
        });
        Thread thread3 = new Thread(() -> {
            obj.task3();
        });

        thread1.start();
        // Thread 1 acquires lock on obj for 10 seconds and then releases it
        thread2.start();
        // Thread 2 starts executing the code but cannot go inside synchronized block
        // because the lock is still acquired by the thread 1 on obj, once thread1 releases
        // the lock, then only thread2 can acquire it
        thread3.start();
        // No locking required for task3 so executed independently
    }
}
