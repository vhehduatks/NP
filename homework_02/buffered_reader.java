package homework_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class buffered_reader {
    static void func1() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("한 줄의 text를 입력하고 Enter, 끝은 CTRL-Z");
		String str = br.readLine();
		while (str != null) {
			System.out.println(str);
			str = br.readLine();
		}
		System.out.println("Program over");
    }
}
