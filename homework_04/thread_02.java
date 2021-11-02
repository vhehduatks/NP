package homework_04;

public class thread_02 {
    interface Callback{
        void getAver(double d);
    }

    static void func1(){
        Callback callback=new Callback() {
            public void getAver(double d) {
                System.out.println("Callback 호출");
                System.out.println("Callback getAver override : "+d);
            };
        };
        int[] Intarr={1,2,3,4,5};
        Thread t = new Thread(new callee(callback,Intarr));
        t.start();
    }

}

