package homework_02;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class inputStream_reader {
    static void func1() throws Exception{
        String path="homework_02/example/";	
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path+"hangeul.txt"));
        PrintWriter pw = new PrintWriter(System.out);

        int input = isr.read();
		while (input != -1) {
			pw.print((char) input);
			input = isr.read();
		}
		pw.flush();
		isr.close();
    }
}
