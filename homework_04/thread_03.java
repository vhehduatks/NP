package homework_04;
import java.util.Arrays;

public class thread_03 {

    static void func1() throws Exception{
        double[] randdouble=new double[1000];
        for (int i=0;i<1000;i++){
            randdouble[i]=Math.random();
        }
        Thread t = new Thread(new A(randdouble));
        t.join();
        System.out.println("min val : "+randdouble[0]);
        System.out.println("max val : "+randdouble[999]);
    }

}

class A implements Runnable{
    double[] arr;

    A(double[] arr){
        this.arr=arr;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        Arrays.sort(arr);
    }
    
    public double[] getResult(){
        return arr;
    }
}