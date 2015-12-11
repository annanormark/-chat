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
}
