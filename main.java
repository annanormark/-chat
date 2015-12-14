import java.util.*;
import java.net.*;
import java.io.*;

public class main {
	public static MessageLog log = new MessageLog();
	public static Socket cSocket;
	public static FrameDemo fDemo;
	public static Thread cThread;
	public static Thread sThread;
	public static ObjectOutputStream sOutputStream;

	
	public static void main(String[] args) {
		
		int port = 6066;// Integer.parseInt(args[0]);
		try {
			sThread = new servertest(port);
			sThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		fDemo = new FrameDemo();

	}
}