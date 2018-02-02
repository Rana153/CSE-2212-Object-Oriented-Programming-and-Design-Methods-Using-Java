import edu.duke.*;

public class CaesarCipher {

	public static void main(String[] args) {
	    CaesarCipher cc = new CaesarCipher();
//	    cc.testCaesar();
        String encMessage = cc.encryptTwoKeys("First Legion", 23, 17);
	    System.out.println(encMessage);
	    
	}
	public String encrypt(String input, int key) {
		StringBuilder encrypt = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftAlpha = alphabet.substring(key) + alphabet.substring(0,key);
		for(int i = 0; i < encrypt.length(); i++) {
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
	public void testCaesar() {
		int key = 17;
		FileResource fr = new FileResource();
	    String message = fr.asString();
	    String encrypted = encrypt(message,key);
	    System.out.print("key is " + key + "\n" + encrypted);
	    System.out.print("key is " + 23 + "and message First Legion \n encrypted message: " + encrypt("First Legion", 23));
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
