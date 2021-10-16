package homework_02;

import java.io.FileWriter;

public class file_writer {
    static void func1() throws Exception{
        String path="homework_02/example/";	
        FileWriter fw = new FileWriter(path+"hangeul.txt");
        String s ="자바의 FileWriter";
        fw.write(s);
        fw.close();
    }
}
