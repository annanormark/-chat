import java.util.*;

public class User {
	private String name;
	private String ip;
	private MessageLog messageLog;
	private User[] userList;

	public User(String name, String ip) {
		this.name = name;
		this.ip = ip;
		messageLog = new MessageLog();
		userList = new User[20];
		
	}

	public void setName(String name) {
		this.name = name;
	} // Känner vi att denna skulle behövas istället för att benämna det när man
		// skapar objektet user

	public String getName() {
		return this.name;
	}

	public String getIP() {
		return this.ip;
	}

	public MessageLog getMsgLog() {
		return this.messageLog;
	}

	public User[] getUsrList() {
		return this.userList;
	}
    public void setMsgLog(MessageLog m){
	this.messageLog = m;
    }

    public void sendMsg(String msg){

    }

    public String getMsg(){

    }

    public static void socketConnect(String ip) {
	String serverName = ip;
	int port = 6066;// Integer.parseInt(args[1]);
	try {
	    System.out.println("Connecting to " + serverName + " on port " + port);
	    Socket client = new Socket(serverName, port);
	    System.out.println("Just connected to " + client.getRemoteSocketAddress());
	    OutputStream outToServer = client.getOutputStream();
	    DataOutputStream out = new DataOutputStream(outToServer);
	    out.writeUTF("Hello from " + client.getLocalSocketAddress());
	    InputStream inFromServer = client.getInputStream();
	    DataInputStream in = new DataInputStream(inFromServer);
	    System.out.println("Server says " + in.readUTF());
	    client.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}§
