import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket extends Thread {
	MessagePacket messagePack;
	public Socket sock;
	// Scanner in;
	Scanner send;
	ObjectOutputStream out;
	ObjectInputStream in;

	public ClientSocket(Socket sock) {
		this.sock = sock;
	}

	public ClientSocket(String ip, int port) {
		// TODO Auto-generated constructor stub
		try {
			this.sock = new Socket(ip, port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			try {
				in = new ObjectInputStream(sock.getInputStream());
				out = new ObjectOutputStream(sock.getOutputStream());
//				out.flush();
				pollInputStream();
			} finally {
				sock.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void pollInputStream() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				messagePack = (MessagePacket) in.readObject();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// String msg = messagePack.getMessage();
			main.log.insertMessage(messagePack);
		}
	}

	public void send(MessagePacket msg) {
		try {
			out.writeObject(msg);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		main.log.insertMessage(msg);
	}
}
