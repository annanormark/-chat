import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocket extends Thread {
	MessagePacket messagePack;
	public Socket sock;
	ObjectOutputStream out;
	ObjectInputStream in;

	public ClientSocket(Socket sock) {
		this.sock = sock;
		System.out.println("är detta en loop?2.10");
	}

	public ClientSocket(String ip, int port) {
		// TODO Auto-generated constructor stub
		try {
			System.out.println("är detta en loop?2.12::" + ip + " ::" + port);
			this.sock = new Socket(InetAddress.getByName(ip), port);
			System.out.println("är detta en loop?2.13");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		main.cSocket = this.sock;
		try {
			try {
				in = new ObjectInputStream(sock.getInputStream());
				// out = new ObjectOutputStream(sock.getOutputStream());
				// out.flush();
				// main.sOutputStream = out;
				// main.sOutputStream = new
				// ObjectOutputStream(main.cSocket.getOutputStream());
				pollInputStream();
			} finally {
				// sock.close();
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
			} catch (Exception e) {
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
