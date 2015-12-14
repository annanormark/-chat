import java.util.*;
import java.util.Date;

public class MessageLog {
	private MessagePacket[] messageList;
	private int currentIndex;
	private int size = 20;

	public MessageLog() {
		messageList = new MessagePacket[size];
		currentIndex = 0;
	}

	public void insertMessage(MessagePacket msg) {
		if (currentIndex + 1 >= size) {
			currentIndex = 0;
			messageList[sortLog(msg)] = msg;
		}
		else{
			messageList[sortLog(msg)] = msg;
		}
		currentIndex += 1;
		main.fDemo.logWindow.setText("");
		System.out.println(msg.getMessage() + " this.messagefield.tostring v");
		main.fDemo.logWindow.setText(this.toString());
		System.out.println("after set text");
	}

	public String getMessage(int x) {
		if (x < 0 || x >= size) {
			return null;
		}
		return this.messageList[x].getMessage();
	}

	public String getUser(int x) {
		if (x < 0 || x >= size) {
			return null;
		}
		return this.messageList[x].getUser();
	}

	public Date getDate(int x) {
		if (x < 0 || x >= size) {
			return null;
		}
		return this.messageList[x].getTimeStamp();
	}

	public boolean nameComp(MessagePacket p1, MessagePacket p2) {
		String stringP1 = p1.getUser();
		String stringP2 = p2.getUser();

		stringP1 = stringP1.replace(".", "");
		stringP2 = stringP2.replace(".", "");

		int intP1 = Integer.parseInt(stringP1);
		int intP2 = Integer.parseInt(stringP2);

		if(intP1 > intP2){
			return true;
		}
		else{
			return false;
		}
	}



	public int sortLog(MessagePacket msg) {
		int tempIndex = (currentIndex + 19) % 20;

		for (int i = 0; i < 19; i++) {
			if (messageList[tempIndex] != null) {
				if(msg.getTimeStamp().after(getDate((tempIndex))) || (msg.getTimeStamp().equals(getDate((tempIndex))) && nameComp(msg, messageList[tempIndex]))) {
					break;
				}
				else{
					messageList[(tempIndex + 1) % 20] = messageList[tempIndex];
					tempIndex = ((tempIndex + 19) % 20);
				}
			}
		}
		return (tempIndex + 1) % 20;
	}

	public String toString() {
		String message = "";
		int counter = currentIndex;

		for (int i = 0; i < 20; i++) {
			if (messageList[counter] != null) {
			message = message + getUser(counter) + ": " + getMessage(counter) + "\n";
		}
			counter = (counter + 1) % 20;
			
		}
		return message;
	}
}
