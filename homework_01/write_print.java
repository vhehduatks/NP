package homework_01;
import java.io.*;


public class write_print {
    static void func1(String file_name) throws IOException{
        String path="homework_01/example/";
        PrintStream ps = new PrintStream(path+file_name);
        ps.write(65);
        ps.write(97);
        ps.write(49);//char 값으로 입력
        ps.close();
    }

    static void func3(String file_name) throws IOException{
        String path="homework_01/example/";
        FileInputStream fis = new FileInputStream(path+file_name);
        int data;
        int total_data=0;
        byte[] buf=new byte[1024];
        while((data=fis.read(buf))>0){
            System.out.println("data : "+ new String(buf,0,data));
            total_data+=data;
        }
        System.out.println("total_byte : "+total_data);
        fis.close();
    }

    static void func4(String file_name) throws IOException{
        String path="homework_01/example/";
        PrintStream ps = new PrintStream(path+file_name);
        ps.print(65);
        ps.print(97);
        ps.print(49);//그대로 입력
        ps.close();
    }

    static void func6(String file_name) throws IOException{
        String path="homework_01/example/";
        FileInputStream fis = new FileInputStream(path+file_name);
        int count = 0;
        int k = fis.read();
        while(k != -1) {
            System.out.println(("data : "+(char)k));
            count++;
            k = fis.read();
        }
        System.out.println(count + "bytes ");
        fis.close();

    }
    
}