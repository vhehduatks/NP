package homework_02;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class char_Stream {
    static void func1() throws Exception{
        Writer w = new OutputStreamWriter(System.out);
		PrintWriter pw = new PrintWriter(System.out);
		char[] nation = {'K', 'O', 'R', 'E', 'A', '한', '국' };
        // for (int i = 0; i < nation.length; i++) w.write(nation[i]);
        // pw.print(nation); 
        // w.write(nation, 0, nation.length);
        // pw.println("KOREA한국", 0, 7); //printwriter 객체에 해당 매개변수를 가진 메소드는 존재하지 않는다
        // w.write("KOREA한국");
        
        w.flush();
        pw.flush();
    }
}
