package homework_04;

public class thread_04 {
    static void func1() throws Exception{
        int[] intarr={1,2,3,4,5};
        Average sharedobj=new Average();
        Thread Calc=new calc(sharedobj,intarr);
        Thread Print=new print(sharedobj);

        Calc.start();
        Thread.sleep(1000);
        Print.start();
    }
}

class calc extends Thread{
    Average objaver;
    int[] Arr;
    calc(Average aver,int[] Arr){
        objaver=aver;
        this.Arr=Arr;
    }
    @Override
    public void run() {
        int sum=0;
        double aver;
        for (int i=0;i<Arr.length;i++){
            sum+=Arr[i];
        }
        aver=sum/Arr.length;
        objaver.calc_mathod(aver);
    }
}

class print extends Thread{
    Average objaver;
    print(Average aver){
        objaver=aver;
    }
    @Override
    public void run() {
        objaver.print_mathod();
    }
}

class Average{
    double aver;
    
    public synchronized void calc_mathod(double aver){
        this.aver=aver;
        notify();
        try {
            wait();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public synchronized void print_mathod(){
        System.out.println("Aver : "+aver);
        notify();
        try {
            wait();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}