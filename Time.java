import java.util.*;
import java.net.InetAddress.*;
import java.time.*;
import org.apache.commons.net.ntp.NTPUDPClient.*; 
import org.apache.commons.net.ntp.TimeInfo.*;


public class Time{


    public Date getTime(){
	String TIME_SERVER = "ntp.uu.se";   
	NTPUDPClient timeClient = new NTPUDPClient();
	InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
	TimeInfo timeInfo = timeClient.getTime(inetAddress);
	long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
	Date time = new Date(returnTime);
	return time;

    }


}
