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
		

		MessagePacket med1 = new MessagePacket("Hej1", date1, "192.168.1.52");
		MessagePacket med2 = new MessagePacket("Hej2", date2, "192.168.1.52");
		MessagePacket med3 = new MessagePacket("Hej3", date3, "192.168.1.52");
		MessagePacket med4 = new MessagePacket("Hej4", date3, "192.168.1.53");

		MessageLog log = new MessageLog();

		log.insertMessage(med1);
		log.insertMessage(med3);
		log.insertMessage(med2);
		log.insertMessage(med4);

		System.out.println(log.toString());
		System.out.println("Done");
	}

}


