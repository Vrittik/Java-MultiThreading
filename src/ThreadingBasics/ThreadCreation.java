package ThreadingBasics;

public class ThreadCreation {
    public static void main(String[]  args)
    {
        Runnable myRunnable = new MyRunnable();
        System.out.println("Start instruction in main executed by thread - " + Thread.currentThread().getName());
        Thread runnableThread = new Thread(myRunnable);
        runnableThread.start();
        MyThread threadExtend = new MyThread();
        threadExtend.start();
        System.out.println("End instruction in main executed by thread - " + Thread.currentThread().getName());
    }
}
