import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageLogTest {

	public static void main(String[] args) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd h:mm:ss.S");
		String formattedDate = sdf.format(date);

		MessagePacket med1 = new MessagePacket("Hej1", formattedDate, "User1");
		MessagePacket med2 = new MessagePacket("Hej2", formattedDate, "User2");
		MessagePacket med3 = new MessagePacket("Hej3", formattedDate, "User3");

		MessageLog log = new MessageLog();

		log.insertMessage(med1);
		log.insertMessage(med2);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med3);
		log.insertMessage(med1);

		System.out.println(log.toString());
		System.out.println("Done");
	}

}


