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



	public int sortLog(MessagePacket msg) {
		int tempIndex = (currentIndex + 19) % 20;

		for (int i = 0; i < 19; i++) {
			System.out.println(messageList[tempIndex] != null);
			if (messageList[tempIndex] != null) {
				System.out.println(msg.getTimeStamp().after(getDate((tempIndex))));
				if(msg.getTimeStamp().after(getDate((tempIndex)))) {
					System.out.println("Ska avbryta");
					break;
				}
				else{
					System.out.println(i);
					messageList[(tempIndex + 1) % 20] = messageList[tempIndex];
					tempIndex = ((tempIndex + 19) % 20);
				}
			}
		}
		return tempIndex;
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
