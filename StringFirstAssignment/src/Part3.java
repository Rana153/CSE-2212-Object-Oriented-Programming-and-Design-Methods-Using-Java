public class Part3{
    public static void main(String [] args) {
    	Part3 pt = new Part3();
    	pt.testing();
    }
	public boolean twoOccurrences(String stringa, String stringb) {
		int count = 0;
		count = stringb.indexOf(stringa,count);
		if(count == -1) return false;
		count = stringb.indexOf(stringa,count+1);
		if(count == -1) return false;
		return true;
	}
    void  testing() {
    	System.out.println(twoOccurrences("ab", "abbbab"));
    	System.out.println(twoOccurrences("atg", "ctgtatgta"));
    }
}