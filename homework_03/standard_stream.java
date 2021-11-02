package homework_03;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class standard_stream {
    static void func1() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(bos);
        
        String line = null;
        byte[] ba=new byte[8024];
        while(!(line = br.readLine()).equals("")){//(line = br.readLine())!=null 조건으로는 while 문을 통과할 수 없음.
            osw.write(line);
        }
        osw.flush();   
        ba=bos.toByteArray();
        System.out.print("byte [] :");
        for (int i=0;i<ba.length;i++){
            System.out.print(ba[i]+" ");
        }
        System.out.println(Arrays.toString(ba));
        System.out.println('\n'+new String(ba));
    }
}
