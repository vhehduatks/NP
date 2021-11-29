package homework_07;
import java.net.*;
import java.io.*;
public class NP_homework_07_server {

	protected DatagramSocket socket;
	public NP_homework_07_server(int port) throws IOException {
		socket = new DatagramSocket(port);
	}
	public void execute () throws IOException {
		while (true) {
			DatagramPacket packet = receive();
			System.out.print("Received message: ");
			System.out.write(packet.getData());
			System.out.println();
			if (Math.random() < .9)
				sendEcho (packet.getAddress (), packet.getPort (), packet.getData (), packet.getLength ());
			else
				System.out.println ("discarded");
		} 
	}
	protected DatagramPacket receive() throws IOException {
		byte buffer[] = new byte[65535];
		DatagramPacket packet = new DatagramPacket (buffer, buffer.length);
		socket.receive (packet);
		return packet;
	}
	protected void sendEcho(InetAddress address, int port, byte data[], int length) throws IOException {
		DatagramPacket packet = new DatagramPacket (data, length, address, port);
		socket.send (packet);
		System.out.print("Sent message: ");
		System.out.write(data);
		System.out.println();
	}


   public static void main (String args[]) throws IOException {
		NP_homework_07_server echo = new NP_homework_07_server(7);
		System.out.println("Echo Server running on port 7 ......");
		echo.execute();
	} 

	

} 
