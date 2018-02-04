import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Tester {
    public static void main(String args[]){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("http://www.dukelearntoprogram.com/java/weblog3-short_log");
        HashMap<String, Integer> counts = new HashMap<>();
        counts = logAnalyzer.countVisitsPerIP();

        for(String strIP : counts.keySet())
            System.out.println(strIP + "visited " + counts.get(strIP) + " times");

   //     System.out.println("\n" + "Most visited by IPs : " + logAnalyzer.mostNumberVisitsByIP(counts) + "\n");

        ArrayList<String> list = logAnalyzer.iPsMostVisits(counts);
      //  System.out.println("IPs those visited maximum times :");
        for(String strIP : list)
            System.out.println(strIP);

        HashMap<String, ArrayList<String> > countsPerDay = logAnalyzer.iPsForDays();
        for(String dayString : countsPerDay.keySet()){
            System.out.println("On date " + dayString + " " + countsPerDay.get(dayString).size() + " IP addresses visited the site");
        }
        
        System.out.println("\nOn the day " + logAnalyzer.dayWithMostIPVisits(countsPerDay) + " most IP visited");

        ArrayList<String> IPList = logAnalyzer.iPsWithMostVisitsOnDay(countsPerDay, "Sep 30");
        System.out.println("\nIPs those visited on Sep 30:");
        for(String strIP : IPList)
            System.out.println(strIP);

    }
}
