import edu.duke.*;
import org.apache.commons.csv.*;

public class ParsingExportData {

	public static void main(String[] args) {
		ParsingExportData pED = new ParsingExportData();
        pED.testCountryInfo();
        FileResource fr = new FileResource();
        pED.listExportsTwoPorducts(fr.getCSVParser(),"gold","diamonds");
        int numberOfCountry = pED.numberOfExports(fr.getCSVParser(), "gold");
	    System.out.println("\n4 no assignment : " + numberOfCountry + " Country Export " + "gold");
	    System.out.println("\n5 no assignment :");
	    pED.bigExporters(fr.getCSVParser(), "$400,000,000");
	}
	
	public void tester() {
		FileResource fr = new FileResource();
		System.out.println("Country \t\t\texport element \t\t\tValue");
		CSVParser par = fr.getCSVParser();
		for(CSVRecord rec : par){
			System.out.println(rec.get("Country") + "\t" + rec.get("Exports") + "\t" + rec.get("Value (dollars)"));
		}
	}
	
	public String countryInfo(String country, CSVParser parser) {
	    for(CSVRecord rec : parser) {
	    	if(rec.get("Country").equals("Germany")) 
	    		return rec.get("Country") + ":"+rec.get("Exports") + " : " + rec.get("Value (dollars)");
	    }
	    return "NOT FOUND";
	}
	
    public void testCountryInfo() {
    	FileResource fr = new FileResource();
    	CSVParser parser = fr.getCSVParser();
        String result = countryInfo("Germany",parser);
        System.out.println(result);
        result = countryInfo("Germany",parser);
        System.out.println(result);
    }
    
    public void listExportsTwoPorducts(CSVParser parser,String exportItem1, String exportItem2){
    	System.out.println(exportItem1 + " and " + exportItem2 + " Exported country is :");
    	for(CSVRecord rec : parser) {
    		if( rec.get("Exports").indexOf(exportItem1) !=-1 && rec.get("Exports").indexOf(exportItem1) !=-1)
    	        System.out.println(rec.get("Country"));
    	}
    }
    
    public int numberOfExports(CSVParser parser,String item){
    	int count = 0;
    	for(CSVRecord rec : parser){
    		if(rec.get("Exports").indexOf(item) != -1)
    			count++;
    	}
        return count;
    }
    public Long convertInToNumber(String str) {
    	String tmpAmount = "";
    	for(int i=0; i< str.length();i++) {
    	    String dig = str.substring(i,i+1); 
    	    switch(dig) {
    	        case "0":
    	        case "1":
    	        case "2":
    	        case "3":
    	        case "4":
    	        case "5":
    	        case "6":
    	        case "7":
    	        case "8":
    	        case "9":
    	        case ".":
    	            tmpAmount += dig;
    	        	break;
    	        default:
    	            break;
    	    }
    	}
        return Long.parseLong(tmpAmount);
    }
    public void bigExporters(CSVParser parser, String amount) {
    	Long tmpAmount = convertInToNumber(amount);
    	for(CSVRecord rec : parser){
    		Long tmp = convertInToNumber(rec.get("Value (dollars)")); 
    	    if(tmp >= tmpAmount) {
    	    	System.out.println(rec.get("Country") + " " + rec.get("Value (dollars)"));
    	    }
    	}
    }
}