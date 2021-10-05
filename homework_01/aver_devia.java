package homework_01;

import java.io.*;

public class aver_devia {
    static void func1(int num,String file_name) throws IOException{
        String path="homework_01/example/";
        DataOutputStream dos = new DataOutputStream(
            new FileOutputStream(path+file_name)
        );
        for (int i = 0; i < num; i++) {
            double v=Math.random();
            dos.writeDouble(v);
        }
        dos.close();
    }
    static void func2(String file_name) throws IOException{
        String path="homework_01/example/";
        DataInputStream dis = new DataInputStream(
            new FileInputStream(
                new File(path+file_name)
            )
        );
        double average=0;
        int count=0;
        while(true){
            try {
                average+=dis.readDouble(); 
                count++;   
            } catch (Exception e) {
                //TODO: handle exception
                break;
            }   
        }
        dis.close();
        average=average/count;

        DataInputStream dis2 = new DataInputStream(
            new FileInputStream(
                new File(path+file_name)
            )
        );
        double deviation=0;

        while(true){
            try {
                double new_v=dis2.readDouble();
                deviation+=Math.pow((new_v-average), 2); 
            } catch (Exception e) {
                //TODO: handle exception
                break;
            }   
        }
        dis2.close();
        deviation=Math.sqrt(deviation/count);
        System.out.println("average : "+average);
        System.out.println("standard deviation : "+deviation);
    }
}
