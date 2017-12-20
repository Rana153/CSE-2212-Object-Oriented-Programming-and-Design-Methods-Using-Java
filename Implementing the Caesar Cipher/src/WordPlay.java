/**
 * Created by rana on 2/10/17.
 */


public class WordPlay {
	public static void main(String [] args){
	    WordPlay wp = new WordPlay();
	    //wp.testIsVowel();
	    //wp.testReplaceVowel();
	    wp.testEmphasize();
	}
    boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;
        return false;
    }
    public void testIsVowel(){
        System.out.println("1 : Test method for isVowel method");
        System.out.println("intput value is : C , d, E, e");
        System.out.println("Output :");
        System.out.println(isVowel('C'));
        System.out.println(isVowel('d'));
        System.out.println(isVowel('E'));
        System.out.println(isVowel('e'));
    }
    public StringBuilder replaceVowel(String parase, char ch) {
    	StringBuilder newParase = new StringBuilder(parase);
    	int l = newParase.length();
    	for(int i = 0; i < l; i++) {
    		char chTmp = newParase.charAt(i);
    		if(isVowel(chTmp)) {
    			newParase.setCharAt(i, ch);
    		}
    	}
    	return newParase;
    }
    
    public void testReplaceVowel() {
    	System.out.println("2 : Test method for replaceVowel method");
        System.out.println("parse string is : Hello World , and replace character is *");
        System.out.println(replaceVowel("Hello World",'*'));
    }
    
    public StringBuilder emphasize(String parase,char ch) {
    	StringBuilder newParase = new StringBuilder(parase);
    	int l = newParase.length();
    	for(int i = 0; i < l; i++) {
    		if(newParase.charAt(i) == ch) {
    			if(i % 2 == 0)
                    newParase.setCharAt(i, '*');
    			else 
    				newParase.setCharAt(i, '+');
    		}
    	}
    	return newParase;
    }
    public void testEmphasize() {
    	System.out.println("3 : Test method for emphasize method");
    	System.out.println("parse string is : dna ctgaaactga , and replace character is a");
        System.out.println(emphasize("Hello World",'a'));
        System.out.println("parse string is : Mary Bella Abracadabra , and replace character is a");
        System.out.println(emphasize("Mary Bella Abracadabra",'a'));
    }
}
