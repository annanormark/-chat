import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket implements Runnable {
	MessagePacket messagePack;
	Socket sock;
	// Scanner in;
	Scanner send;
	ObjectOutputStream out;
	ObjectInputStream in;

	public ClientSocket(Socket sock) {
		this.sock = sock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			try {
				in = new ObjectInputStream(sock.getInputStream());
				out = new ObjectOutputStream(sock.getOutputStream());
				out.flush();
				pollInputStream();
			} finally {
				sock.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void pollInputStream() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		while (true) {

			messagePack = (MessagePacket) in.readObject();
			// String msg = in.nextLine();
			String msg = messagePack.getMessage();
		}
	}

	public void SEND(MessagePacket msg) {
		out.println(A_Chat_Client_GUI.UserName + ": " + x);
		OUT.flush();
		A_Chat_Client_GUI.TF_Message.setText("");
	}
}
