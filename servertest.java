import java.net.*;
import java.io.*;

public class servertest extends Thread {
	// public static void main(String[] args) {
	// int port = 6066;// Integer.parseInt(args[0]);
	// try {
	// Thread t = new servertest(port);
	// t.start();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	private ServerSocket serverSocket;

	public servertest(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(300000);
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
				server.close();
			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

}