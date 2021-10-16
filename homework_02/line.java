package homework_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class line {
    static void func1() throws Exception{
        String path="homework_02/example/";	
        FileReader fr = new FileReader(path+"hangeul.txt");
        BufferedReader reader = new BufferedReader(fr);
        FileWriter fw = new FileWriter(path+"line.txt");
        PrintWriter writer=new PrintWriter(new BufferedWriter(fw));
        
        String s = reader.readLine();
		int lineNo = 0;
		while (s != null) {
			lineNo++;
			writer.println(lineNo + ": " + s);
			s = reader.readLine();
		}
		// w.close(); //writer가 닫혀야 버퍼에 있는 string 이 flush 되면서 문서에 적히는데 w는 이미 선언된 writer가 아니므로 잘못된 코드
        writer.close();
    }
    
}
