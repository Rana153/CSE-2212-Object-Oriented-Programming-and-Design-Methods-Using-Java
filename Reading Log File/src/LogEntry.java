import java.util.*;

public class LogEntry {
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;

    public LogEntry(String ip, Date time, String req, int status, int bytes){
        ipAddress = ip;
        accessTime = time;
        request = req;
        statusCode = status;
        bytesReturned = bytes;
    }
    public String getIpAddress(){
        return ipAddress;
    }
    public Date getAccessTime() {
        return accessTime;
    }
    public String getRequest() {
        return request;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public int getBytesReturned() {
        return bytesReturned;
    }

    public String toString(){
        return ipAddress + " " + accessTime + " " + request + " " + statusCode + " "
                + bytesReturned;
    }

    public static void main(String args[]){
        LogEntry obj = new LogEntry("192.168.0.109", new Date(), "Try to be a good man", 200, 700);
        System.out.println(obj);
    }
}
