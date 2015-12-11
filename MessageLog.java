import java.util.*;

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
			messageList[currentIndex] = msg;
		}
		else{
		messageList[currentIndex] = msg;
		}
		currentIndex += 1;
	}

	public String getMessage(int x) {
		if (x < 0 || x >= size) {
			return null;
		}
		return this.messageList[x].getMessage();
	}

	public void sortLog() {

	}

	public String toString() {
		String message = "";
		int counter = currentIndex;

		for (int i = 0; i < 20; i++) {
			if (messageList[counter] != null) {
			message = message + getMessage(counter) + "\n";
		}
			counter = (counter + 1) % 20;
			
		}
		return message;
	}
}
