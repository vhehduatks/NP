package homework_06;

import java.net.Socket;
import java.net.SocketException;
import java.io.*;

public class NP_homework_06_client {
    public static void main(String[] args) {
        try {
            Socket socket =new Socket("localhost",8080);
 
			Thread in = new InputThreadc(socket.getInputStream());
			Thread out = new OutputThreadc(socket.getOutputStream());
			in.start();
			out.start();

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}

class OutputThreadc extends Thread{
	private Writer out;
	public OutputThreadc(OutputStream out){
		this.out=new OutputStreamWriter(out);
	}
	public void run() {
		String line;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			line = in.readLine();
			while (!(line.equals("."))) {
				out.write(line + "\r\n");
				out.flush();
				line = in.readLine();
			}
		} catch (IOException ex) {
		}
		try {
			out.close();
		} catch (IOException ex) {
		}
	}
}

class InputThreadc extends Thread {
	InputStream in;
	public InputThreadc(InputStream in) {
		this.in = in;
	}
	public void run() {
		try {
			BufferedReader b = new BufferedReader(new InputStreamReader(in));
			// int i = in.read();
			String terminalout=null;
			while ((terminalout=b.readLine())!=null) {
				System.out.println("server : "+terminalout);
			}
		} catch (SocketException ex) {
			// output thread closed the socket
		} catch (IOException ex) {
			System.err.println(ex);
		}
		try {
			in.close();
		} catch (IOException ex) {
		}
	}
}