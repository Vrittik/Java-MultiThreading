package ThreadingBasics;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Runnable implemented instruction run by thread - " + Thread.currentThread().getName());
    }
}
