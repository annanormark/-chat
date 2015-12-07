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
		currentIndex += 1;
		messageList[currentIndex] = msg;
	}

	public MessagePacket getMessage(int x) {
		if (x < 0 || x >= size) {
			return null;
		}
		return this.messageList[x];
	}

	public void sortLog() {

	}
}
