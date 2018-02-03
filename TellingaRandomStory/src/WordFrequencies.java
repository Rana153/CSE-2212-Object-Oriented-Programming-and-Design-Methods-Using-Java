import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequencies {
	
    private ArrayList < String > myWords; 
    private ArrayList < Integer > myFreqs;
    private int maxIndex;
    WordFrequencies(){
    	 myWords = new ArrayList < String > ();
    	 myFreqs = new ArrayList < Integer > ();
         maxIndex = -1;
    }   
    
    void findUnique() throws FileNotFoundException {
    	myWords.clear();
    	myFreqs.clear();
    	
        File file = new File("C:\\Users\\Tyro\\Desktop\\MostFrequentWordAssignmentOutput.txt");
        Scanner sc = new Scanner(file);
        
        int i = 0;
        
        while(sc.hasNext()) {
        	String word = sc.next().toLowerCase();
            int index;
        	if(myWords.contains(word)) {
            	index = myWords.indexOf(word);
            	myFreqs.set(index, (myFreqs.get(index) + 1));
            	//System.out.println("String : " + word+ " index[" + index + "] value : "+ myFreqs.get(index) );
        	}
            else {
            	myWords.add(word);
                index = myWords.indexOf(word);
                myFreqs.add(1);
            }
        }
        
    }
    
    int findIndexOfMax() {
    	return maxIndex;
    }
    
    void tester() {
    	System.out.println(myWords.get(findIndexOfMax()) + " is " + myFreqs.get(maxIndex) + " times");
    }
    
    void test() throws FileNotFoundException {
    	findUnique();
    	int sizeOfWords, sizeOfFreqs , mx = -1, index = -1;
    	sizeOfWords = myWords.size();
    	sizeOfFreqs = myFreqs.size();
    	
        System.out.print("Number Unique Words : ");
        if(sizeOfWords == sizeOfFreqs) {
        	System.out.println(sizeOfWords);
        	
        	for(int i = 0; i < sizeOfWords; i++) {
        		String word = myWords.get(i);
        		int value = myFreqs.get(i);
        		if(value > mx) {
        			mx = value;
        			index = i;
        		}
        		
        		System.out.println(value + " " + word);
        	
        	}
        	
        }
        maxIndex = index;
    }
    
    public static void main(String args[]) throws FileNotFoundException {
    	WordFrequencies y = new WordFrequencies();	
        y.test();
        y.tester();
    }
	
}
