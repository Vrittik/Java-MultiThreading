package ThreadingBasics;

public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("Thread extended instruction run by thread - " + Thread.currentThread().getName());
    }
}
