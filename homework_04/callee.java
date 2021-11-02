package homework_04;

public class callee implements Runnable{
    thread_02.Callback callback;
    int[] intarr;

    callee(thread_02.Callback callback,int[] intarr){
        System.out.println("callee 생성자");
        this.callback=callback;
        this.intarr=intarr;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        double aver=0;
        int sum=0;
        for(int i=0;i<intarr.length;i++){
            sum+=intarr[i];
        }
        aver=sum/intarr.length;
        callback.getAver(aver);
        
    }
}
