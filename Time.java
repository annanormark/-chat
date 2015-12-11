import java.util.*;

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
