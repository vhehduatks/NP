package homework_06;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class NP_homerwork_06_client {
    public static void main(String[] args) {
        try {
            Socket socket =new Socket("localhost",8080);
            BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());
    
            int cnt=0;
            String line=null;
            while((line=in.readLine())!=null){ 
                cnt+=line.length(); 
                System.out.println("char cnt:"+String.format("%-4d", cnt)+":"+line);
                
            }

            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
