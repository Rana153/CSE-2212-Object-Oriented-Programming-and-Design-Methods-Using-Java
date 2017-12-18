public class Part2{
	public static void main(String [] args) {
		Part2 pt = new Part2();
	    pt.testHowMany();
	}
	int howMany(String stringa, String stringb){
        int count = 1;
        int index = 0;
        index = stringb.indexOf(stringa,0);
       // System.out.println("index" + index);
        if(index == -1) return -1;
        while(true){
            index = stringb.indexOf(stringa,(index + stringa.length()));
           // System.out.println("index" + index);
            if(index == -1) break;
            else count++;
        }
       return count; 
    }
    void testHowMany(){
        System.out.println(howMany("GAA","ATGAACGAATTGAATC"));      
        System.out.println(howMany("AA","ATAAAA"));
        System.out.println(howMany("Z","ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"));
    }
}