import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageLogTest {

	public static void main(String[] args) {
		
		Date date1 = new Date();
		try {
  		  	Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
		}

		Date date2 = new Date();
		try {
  		  	Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
		}

		Date date3 = new Date();
		try {
  		  	Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
		}
		

		MessagePacket med1 = new MessagePacket("Hej1", date1, "User1");
		MessagePacket med2 = new MessagePacket("Hej2", date2, "User2");
		MessagePacket med3 = new MessagePacket("Hej3", date3, "User3");

		MessageLog log = new MessageLog();

		log.insertMessage(med1);
		log.insertMessage(med3);
		log.insertMessage(med2);

		System.out.println(log.toString());
		System.out.println("Done");
	}

}


