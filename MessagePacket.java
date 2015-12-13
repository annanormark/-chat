public class MessagePacket implements java.io.Serializable {

	private String message;
	private String timeStamp;
	private String userName;

	public MessagePacket(String msg, String timestmp, String usrnme) {
		this.message = msg;
		this.timeStamp = timestmp;
		this.userName = usrnme;
	}

	public String getMessage() {
		return this.message;
	}

	public String getUser() {
		return this.userName;
	}

	public String getTimeStamp() {
		return this.timeStamp;
	}

}
