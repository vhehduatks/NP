package homework_07;


import java.io.*;
import java.net.*;

public class NP_homework_07_client {

    private static final int MAXTRIES = 5; // 최대 재전송 시도 횟수
	public static void main(String[] args) throws IOException {
		String server = "localhost";
		InetAddress serverAddress = InetAddress.getByName(server);
		byte[] message = "This is message from client.".getBytes();
		int serverPort = 7;
		DatagramSocket socket = new DatagramSocket();
		socket.setSoTimeout(3000); // 최대 대기시간 (milliseconds)
		// Sending packet
		DatagramPacket sendPacket = new DatagramPacket(message, message.length, serverAddress, serverPort);
		// Receiving packet
		DatagramPacket receivePacket = new DatagramPacket(new byte[message.length], message.length);
		int tries = 0; // 패킷 상실 대비 시도 회수 저장
		boolean receiveOK = false;
		do {
			socket.send(sendPacket); // 에코 문자열을 보낸다
			try {
				socket.receive(receivePacket); // 에코 응답 수신 시도
				if (!receivePacket.getAddress().equals(serverAddress)) // 응답 출처 검사
					throw new IOException("Received packet from an unknown source");
				receiveOK = true;
			} catch (InterruptedIOException e) { // 시간 내 받지 못함
				tries += 1;
				System.out.println("Timed out, " + (MAXTRIES - tries) + " time try...");
			}
		} while ((!receiveOK) && (tries < MAXTRIES));
		if (receiveOK)
			System.out.println("Message received from server: " + new String(receivePacket.getData()));
		else
			System.out.println("No response -- giving up.");
		socket.close();
	}
}