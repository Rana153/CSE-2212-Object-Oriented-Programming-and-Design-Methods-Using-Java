import edu.duke.*;
import java.util.*;

public class CharactersInPlay {
    private ArrayList<Integer> myFreqs;
    private ArrayList<String> myWords;
    
    public CharactersInPlay() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    private void update(String person) {
        //person = person.toLowerCase();
        int pos = myWords.indexOf(person);
        if (pos == -1) {
            myWords.add(person);
            myFreqs.add(1);
        }
        else {
            int occure = myFreqs.get(pos);
            myFreqs.set(pos, occure+1);
        }
    }
    
    private void findAllCharacters() {
        FileResource fr = new FileResource();
        for (String line: fr.lines()) {
            int pos = line.indexOf(".");
            if (pos > -1) {
                int isBlank = 0;
                while (isBlank < pos) {
                    if (!line.substring(isBlank, isBlank+1).equals(" ")) break;
                    else isBlank = isBlank + 1;
                }
                String person = line.substring(isBlank, pos);
                update(person);
            }
        }
    }
    
    private int findIndexOfMax() {
        int atPos = myFreqs.get(0);
        int curPos = 0;
        for (int k = 0; k < myFreqs.size(); k++) {
            int newOne = myFreqs.get(k);
            if (newOne > atPos) {
                atPos = newOne;
                curPos = k;
            }
            
        }
        return curPos;
    }
    
    private void charactersWithNumParts(int num1, int num2) {
        for (int i = 0; i < myWords.size(); i++) {
            if (myFreqs.get(i)>=num1 && myFreqs.get(i) <= num2) 
                System.out.println(myWords.get(i) + ": "+ myFreqs.get(i)+ "\t");
        }
    }
    
    public void testfindAllCharacters() {
        findAllCharacters();
        charactersWithNumParts(10, 150);
        int mxOne = findIndexOfMax();
        System.out.println("The word with highest frequency is: "+myWords.get(mxOne)+" with "+myFreqs.get(mxOne));
    }
    public void tester() {
    	testfindAllCharacters();
    }
    public static void main(String [] args)throws Exception {
    	CharactersInPlay cInP = new CharactersInPlay();
    	cInP.tester();
    }
}