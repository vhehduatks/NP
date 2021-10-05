package homework_01;

import java.io.*;
public class file_copy {
    static void func1(String arg0,String arg1,int buf_size) throws IOException{
        String path="homework_01/example/";
        FileInputStream fis = new FileInputStream(path+arg0);
        FileOutputStream fos = new FileOutputStream(path+arg1);
        byte[] buf = new byte[buf_size];
        int data;
        int total_byte=0;
        while((data=fis.read(buf))>0){
            fos.write(buf,0,data);
            total_byte+=data;
        }
        System.out.println("file_size : "+total_byte);
        fis.close();
        fos.close();
    }

    
    static void func2(String arg0,String arg1,int buf_size) throws IOException{
        String path="homework_01/example/";
        FileInputStream fis = new FileInputStream(path+arg0);
        FileOutputStream fos = new FileOutputStream(path+arg1);
        byte[] buf = new byte[buf_size];
        int data;
        int total_byte=0;
        byte[] arr = new byte[3000000];//3MB
        while((data=fis.read(buf))>0){
            System.arraycopy(buf,0,arr,total_byte,data);
            total_byte+=data;
        }
        fos.write(arr,0,total_byte);
        System.out.println("file_size : "+total_byte);
        fis.close();
        fos.close();
    }

        
}
