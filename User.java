import java.util.*;

public class User{
    private String Name;
    private String IP;
    private String[] messageLog;
    private String[] userlist;

    public void User(String name, String ip){
	this.Name = name;
	this.IP = ip;
	messagelog = new String[20];
	userlist = new String[20];
    }

    public void setName(String name){

    } //Känner vi att denna skulle behövas istället för att benämna det när man skapar objektet user

    public String getName(){
	return this.Name;
    }

    public String getIP(){
	return this.IP;
    }

    public string[] getMsgLog(){
	return this.messageLog;
    }

    public String[] getUsrList(){
	return this.userList;
    }
}
