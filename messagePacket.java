import java.util.*;


public class messagePacket{

    private String message;
    private Date timeStamp;
    private String userName;

    public messagePacket(String msg, Date timestmp, String usrnme) {
	this.message = msg;
	this.timeStamp = timestmp;
	this.userName = usrnme;
    }
    
    public String getMmessage(){
	return this.message;
    }

    public String getUser(){
	return this.userName;
    }

    public Date getTimeStamp(){
	return this.timeStamp;
    }
    
}
