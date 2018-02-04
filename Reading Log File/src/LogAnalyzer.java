
import edu.duke.*;
import jdk.jfr.events.*;


import java.util.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer(){
        records = new ArrayList<>();
    }

    
    public void readFile(String fileName) {
        records.clear();
        if (fileName.startsWith("http")) {
            URLResource url = new URLResource(fileName);
            for (String ln : url.lines())
                records.add(WebLogParser.parseEntry(ln));

        }

        else{
            FileResource fres = new FileResource(fileName);
            for(String ln : fres.lines())
                records.add(WebLogParser.parseEntry(ln));
        }
    }

   
    public void printAll(){
        for(LogEntry logEntry : records)
            System.out.println(logEntry);
    }

   
    public int countUniqueIPs(){
        ArrayList<String> uIP = new ArrayList<>();
        for(LogEntry logEntry : records)
            if(!uIP.contains(logEntry.getIpAddress()))
                uIP.add(logEntry.getIpAddress());
        return uIP.size();
    }

    
    public int countUniqueIPs(ArrayList<LogEntry> list){
        ArrayList<String> uIP = new ArrayList<>();
        for(LogEntry logEntry : list)
            if(!uIP.contains(logEntry.getIpAddress()))
                uIP.add(logEntry.getIpAddress());
        return uIP.size();
    }

    
    public void printAllHigherThanNum(int n){
        for(LogEntry logEntry : records){
            if(logEntry.getStatusCode() > n)
                System.out.println(logEntry);
        }
    }

    
    public void uniqueIPVisitsOnDay(String s){
        String trgMonth = s.substring(0,3);
        String trgDay = s.substring(4,6);

        System.out.println(trgDay + " " + trgMonth);

        for(LogEntry logEntry : records){
            String date = logEntry.getAccessTime().toString();
            String month = date.substring(4,7);
            String day = date.substring(8,10);
            if(day.equals(trgDay) && month.equals(trgMonth))
                System.out.println(logEntry);
        }
    }


    public int countUniqueIPsInRange(int low, int high){
        ArrayList<LogEntry> list = new ArrayList<>();

        for(LogEntry logEntry : records){
            int flat = logEntry.getStatusCode();
            if(flat >= low && flat <= high)
                list.add(logEntry);
        }

        return countUniqueIPs(list);
    }


    public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String, Integer> cntIP = new HashMap<>();

        for(LogEntry logEntry : records){
            String ip = logEntry.getIpAddress();
            if(cntIP.containsKey(ip))
                cntIP.put(ip, cntIP.get(ip) + 1);
            else
                cntIP.put(ip, 1);
        }

        return cntIP;
    }


    public HashMap<String, Integer> countVisitsPerIP(ArrayList<String>IPList){
        HashMap<String, Integer> countsPerIP = new HashMap<>();

        for(String IP : IPList){
            if(countsPerIP.containsKey(IP))
                countsPerIP.put(IP, countsPerIP.get(IP) + 1);
            else
                countsPerIP.put(IP, 1);
        }

        return countsPerIP;
    }


    public int mostNumberVisitsByIP(HashMap<String, Integer> cntIP){
        int mx = 0;
        for(String IP : cntIP.keySet())
            mx = Math.max(mx, cntIP.get(IP));
        return mx;
    }


    public ArrayList<String> iPsMostVisits (HashMap<String, Integer> countsPerIP){
        int maxVisit = mostNumberVisitsByIP(countsPerIP);
        ArrayList<String>list = new ArrayList<>();
        for(String IP : countsPerIP.keySet())
            if(countsPerIP.get(IP) == maxVisit)
                list.add(IP);
        return list;
    }


    public HashMap<String, ArrayList<String> > iPsForDays(){
        HashMap<String, ArrayList<String> >countsPerDay = new HashMap<>();
        String day;

        for(LogEntry logEntry : records){
            String date = logEntry.getAccessTime().toString();
            day = date.substring(4, 10);
            if(!countsPerDay.containsKey(day))
                countsPerDay.put(day, new ArrayList<>());
            countsPerDay.get(day).add(logEntry.getIpAddress());
        }

        return countsPerDay;
    }


    public String dayWithMostIPVisits(HashMap<String, ArrayList<String> > cntDay) {
        String maxDay = "";
        int max = 0;
        for (String day : cntDay.keySet()){
            if (cntDay.get(day).size() > max) {
                max = cntDay.get(day).size();
                maxDay = day;
            }
        }
        return maxDay;
    }


    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String> > countsPerDay, String day){
        HashMap<String, Integer> countsPerIP = countVisitsPerIP(countsPerDay.get(day));
        return iPsMostVisits(countsPerIP);
    }
}
