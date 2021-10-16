package homework_02;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class outputStream_writer {
    static void func1() throws Exception{
        String path="homework_02/example/";	
	    FileOutputStream fos = new FileOutputStream(path+"hangeul.txt");
		OutputStreamWriter w = new OutputStreamWriter(fos,"UTF-8");
        w.write("자바의 OutputStreamWriter 스트림 사용 연습");
        w.close();                                      
    }
}
