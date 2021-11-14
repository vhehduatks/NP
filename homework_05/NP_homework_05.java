package homework_05;
import java.io.*;
import java.net.Socket;

public class NP_homework_05 {
    public static void main(String[] args) throws IOException {
        Socket socket =new Socket("www.yahoo.com",80);
        BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println("GET / HTTP/1.0");
        out.println();

        int cnt=0;
        String line=null;
        while((line=in.readLine())!=null){
            if (cnt>1000)
                break;   
            System.out.println("char cnt:"+String.format("%-4d", cnt)+":"+line);
            cnt+=line.length();
        }
        in.close();
        out.close();
        socket.close();
    }
}
