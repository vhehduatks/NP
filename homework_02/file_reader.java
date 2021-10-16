package homework_02;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class file_reader {
    static void func1() throws Exception{
        String path="homework_02/example/";
        
        // FileInputStream fis = new FileInputStream(path+"hangeul.txt");
        // InputStreamReader isr = new InputStreamReader(fis);
        // int input = isr.read();

        FileReader fr = new FileReader(path+"hangeul.txt");
        int input = fr.read();

        while(input != -1) {
            System.out.print((char)input);
            // input = isr.read();
            input=fr.read();
        }
        // isr.close();
    }
    
}
