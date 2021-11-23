package homework_06;
import java.net.*;
import java.io.*;
public class NP_homework_06_server {
    public static void main(String[] args) {
		int port;
		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception ex) {
			port = 0;
		}
		try {
			ServerSocket server = new ServerSocket(port, 1);
			System.out.println("Listening for connections on port " + server.getLocalPort());
			while (true) {
				Socket connection = server.accept();
				try {
					System.out.println("Connection established with " + connection);
					Thread input = new InputThread(connection.getInputStream());
					input.start();
					Thread output = new OutputThread(connection.getOutputStream());
					output.start();
					// wait for output and input to finish 
					try {
						input.join();
						output.join();
					} catch (InterruptedException ex) {
					}
				} catch (IOException ex) {
					System.err.println(ex);
				} finally {
					try {
						if (connection != null)
							connection.close();
					} catch (IOException ex) {
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

class InputThread extends Thread {
	InputStream in;
	public InputThread(InputStream in) {
		this.in = in;
	}
	public void run() {
		try {
			int i = in.read();
			while (i != -1) {
				System.out.write(i);
				i = in.read();
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

class OutputThread extends Thread {
	private Writer out;
	public OutputThread(OutputStream out) {
		this.out = new OutputStreamWriter(out);
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
    
