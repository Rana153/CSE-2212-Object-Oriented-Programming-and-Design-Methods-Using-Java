import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class HottestTemperatureInManyDays {
	public static void main(String[] args) {
		HottestTemperatureInManyDays ht = new HottestTemperatureInManyDays ();
		ht.testHottestTemperature();
	}
	
	public CSVRecord hottestHourInFile(CSVParser parser) {
		CSVRecord largestSoFar = null;
		for (CSVRecord currentRow : parser) {
			if (largestSoFar == null) {
				largestSoFar = currentRow;
			}
			else {
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				if (currentTemp > largestTemp) {
					largestSoFar = currentRow;
				}
			}
		}
		return largestSoFar;
	}
	public CSVRecord hottestInManyDays() {
		CSVRecord largestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		for(File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
		    if(largestSoFar == null){
		    	largestSoFar = currentRow;
		    }
		    else {
		    	double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
		    	double largestTemp = Double.parseDouble(largestSoFar.get(("TemperatureF")));
		    	if(currentTemp > largestTemp) {
		    		largestSoFar = currentRow;
		    	}
		    }
		}
		return largestSoFar;
	}
	public void testHottestTemperature(){
	    CSVRecord largest = hottestInManyDays();   
	    System.out.println("hottest temperature was " + largest.get("TemperatureF") +
				   " at " + largest.get("DateUTC"));
	}
}
