import java.util.*;
import java.net.*;
import java.io.*;

public class main {
	public static MessageLog log = new MessageLog();
	public static ClientSocket cSocket;
	public static FrameDemo fDemo;
	
	public static void main(String[] args) {
		
		int port = 6066;// Integer.parseInt(args[0]);
		try {
			Thread t = new servertest(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		fDemo = new FrameDemo();

	}
}