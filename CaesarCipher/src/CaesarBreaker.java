import edu.duke.*;

public class CaesarBreaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        CaesarBreaker cBreak = new CaesarBreaker();
	}

public static class CaesarCipher {

	public String encrypt(String input, int key) {
		StringBuilder encrypt = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftAlpha = alphabet.substring(key) + alphabet.substring(0,key);
		for(int i = 0; i < encrypt.length(); i++){
			char ch = encrypt.charAt(i);
			if( Character.isLowerCase(ch)) {
			    ch = Character.toUpperCase(ch);
			    int ind = alphabet.indexOf(ch);
			   if(ind != -1) {
			        char nch = shiftAlpha.charAt(ind);
			        nch = Character.toLowerCase(nch);
			        encrypt.setCharAt(i, nch);
			   }
			}
			else {
				int index = alphabet.indexOf(ch);
		    	if(index != -1) {
		    		char newCh = shiftAlpha.charAt(index);
		        	encrypt.setCharAt(i, newCh);
		    	}
			}
		}
		return encrypt.toString();
	}
	
	public String encryptTwoKeys(String name, int key1, int key2) {
		
		StringBuilder encry = new StringBuilder(name);
		int l = encry.length();
		for(int i = 0; i < l; i++) {
			 char ch = encry.charAt(i);
	         String chStr = Character.toString(ch);
			 if(i%2 == 0)
				 chStr = encrypt(chStr,key1);
			 else
				 chStr = encrypt(chStr,key2);
		     ch = chStr.charAt(0);
		     encry.setCharAt(i, ch);
		}
	    return encry.toString();
	}
}


}
