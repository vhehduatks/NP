package homework_04;

public class thread_01 {
    static void func1(){
        Thread t1=new Thread(new hello_thread(),"HELLO");
        t1.start();
        Thread t2=new Thread(new printrand_thread(),"PRINT");
        t2.start();     
    }
}

class hello_thread implements Runnable{
    public void run() {
        Thread t =Thread.currentThread();
        for(int i=0;i<3;i++)
            System.out.println(t.getName()+" : "+"Hellow Software!!");
    }
}
class printrand_thread implements Runnable{
    public void run() {
        Thread t =Thread.currentThread();
        for (int i=0;i<3;i++)
            System.out.println(t.getName()+" : "+Math.random());
    }
}
