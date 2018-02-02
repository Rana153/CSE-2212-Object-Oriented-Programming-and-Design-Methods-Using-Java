import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.util.Arrays;

public class BabysBirthday{
	public static void main(String[] args){
		BabysBirthday bb = new BabysBirthday();
//		FileResource  f = new FileResource();
	
		//	bb.totalBirth(f);
	 
		//   bb.testGetRank();

		//	bb.testGetName();
		
		// bb.whatIsNameInYear("Isabella", 2012, 2014,"F");
		// int x ;
		//x = bb.​yearOfHighestRank("Mason","M");
		double avaregeRank = bb.getAverageRank("Mason","M");
	}
	
	public void totalBirth(FileResource fr){
		System.out.println("Part : 1 totalBirth Test Method");
		int numberOfGirl = 0, numberOfBoyes = 0;
		for(CSVRecord rec : fr.getCSVParser(false)){
			if(rec.get(1).matches("M")) {
				numberOfBoyes += Integer.parseInt(rec.get(2));
			}
			else { 
				numberOfGirl += Integer.parseInt(rec.get(2));
			}
		}
	    System.out.println("Number of Boys : " + numberOfBoyes + "\nNumber of Girls : " + numberOfGirl);
	    System.out.println("Total Number : " + (numberOfGirl + numberOfBoyes));
	}
	
	public int getRank(int year, String name, String gender) {
		int finalRank , numOfBirth = -1; 
	    String fName = "/home/rana/Desktop/yob"+ String.valueOf(year) +"short.csv";
	  //  System.out.println(fName);
	    FileResource  fr = new FileResource(fName);
	    for(CSVRecord rec : fr.getCSVParser(false)){
	    	if(rec.get(0).equals(name) && rec.get(1).equals(gender)) {
	    		numOfBirth = Integer.parseInt(rec.get(2)); 
	    	}
	    }
	    if(numOfBirth == -1) return -1;
	    int count = 1;
	    for(CSVRecord rec : fr.getCSVParser(false)){
	    	if((Integer.parseInt(rec.get(2)) > numOfBirth) && rec.get(1).equals(gender)) {
	    		count++;
	    	}
	    }
	    
	    return count;
	}
	public void testGetRank() {
		System.out.println("\nPart : 2 getRank Test Method");
		int a;
		System.out.println("getRank method test using differnt parameterr:");
		a = getRank(2012,"Mason","F");
	    System.out.println(a);
	    a = getRank(2012,"Mason","M");
	    System.out.println(a);
	    System.out.println();
	}
	
	public String getName(int year, int rank, String gender) {
		System.out.println("\nPart : 3 getName Test Method");
	    int[] numberCount;
		numberCount = new int [1000000];
	    String fName = "/home/rana/Desktop/yob"+ String.valueOf(year) +"short.csv";	
		FileResource  fr = new FileResource(fName);
	    int i = 0;
		for(CSVRecord rec : fr.getCSVParser(false)){
	    	if(rec.get(1).equals(gender)) { 
	    	    numberCount[i] = Integer.parseInt(rec.get(2));
	    	    i++;
	    	}
	    }
		if( i < rank) return "NO NAME";
	    Arrays.sort(numberCount, 0 , i);
	    String numberInRank = String.valueOf(numberCount[rank-1]); 
	    String name = "";
	    for(CSVRecord rec : fr.getCSVParser(false)){
	    	if(rec.get(1).equals(gender) && rec.get(2).equals(numberInRank)) { 
	    	     name = rec.get(0);
	    	}
	    }
	    
	    return name;
	}
	
	public void testGetName() {
		System.out.println("getName method test using different parameter");
		String countryName = getName(2012,3,"F");
		System.out.println(countryName);
		countryName = getName(2012,6,"F");
		System.out.println(countryName);
	}
	
	public void whatIsNameInYear(String name, int year,int newYear, String gender){
		int inYearRank = getRank(year,name,gender);
		String inNewYearName = getName(newYear, inYearRank,gender);
		System.out.println("\nPart : 4 whatIsNameInYear Test Method");
		System.out.println(name+" born in "+year+" would be "+inNewYearName+" if she was born in "+newYear);
	}
	
    public int yearOfHighestRank(String name, String gender) {
    	int finalYear = 0 ;
    	int finalRank = -1;

        System.out.println("\\nPart : 4 whatIsNameInYear Test Method");
    	System.out.println("Three input file are : yob2012short.csv, yob2013short.csv, yob2014short.csv");
        int tmpRank = getRank(2012,name,gender);
        if(tmpRank < finalRank && tmpRank != -1){
        	finalRank = tmpRank;
        	finalYear = 2012;
        }
        tmpRank = getRank(2013,name,gender);
        if(tmpRank < finalRank && tmpRank != -1) {
        	finalRank = tmpRank;
        	finalYear = 2013;
        }
        tmpRank = getRank(2014,name,gender);
        if(tmpRank < finalRank && tmpRank != -1) {
        	finalRank = tmpRank;
        	finalYear = 2014;
        }
        System.out.println("Highest rank in year : "+ finalYear);
        
    	return finalYear;
    } 
	
    public double getAverageRank(String name, String gender) {
        System.out.println("\\\\nPart : 5 getAverageRank Method");
        System.out.println("String Name : " + name + " and Gender : " + gender);
        System.out.println("Avarege Rank from three input file (yob2012short.csv, yob2013short.csv, yob2014short.csv) is");
        int a = getRank(2012,name,gender);
        int b = getRank(2013,name,gender);
        int c = getRank(2014,name,gender);
        if(a == -1) a = 0;
        if(b == -1) b = 0;
        if(c == -1) c = 0;
        double rank = (a + b + c) / 3.0;
        System.out.println(rank);
        
        System.out.println();
        if(rank != 0.0 ) return rank;
        else return -1.0;
	}
}