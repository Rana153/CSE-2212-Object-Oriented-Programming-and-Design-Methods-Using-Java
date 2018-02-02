
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class HottestTemperatureInADay {
    public static void main(String [] args) {
    	HottestTemperatureInADay ht = new HottestTemperatureInADay();
    	ht.testHotestTemperature();
    }
    public CSVRecord hotestTempInHour(CSVParser parser){
    	CSVRecord largestRecord = null;
		for(CSVRecord currentRecord : parser) {
			if(largestRecord == null ) {
				largestRecord = currentRecord;
			}
			
			else {
				double largestTemp = Double.parseDouble(largestRecord.get("TemperatureF"));
				double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));
			    if(currentTemp > largestTemp) {
			    	 System.out.println("Time : " + currentRecord.get("TimeEST") + " Temperature : " + currentRecord.get("TemperatureF"));
			    	largestRecord = currentRecord;
			    }
			  
			}
		}
		
		return largestRecord;
	}
    
    public void testHotestTemperature() {
    	FileResource fr = new FileResource("/home/rana/Desktop/weather-2012-01-01.csv");
    	CSVRecord largest = hotestTempInHour(fr.getCSVParser());
        System.out.println("Time : " + largest.get("TimeEST") + " Temperature : " + largest.get("TemperatureF"));
    }
}
