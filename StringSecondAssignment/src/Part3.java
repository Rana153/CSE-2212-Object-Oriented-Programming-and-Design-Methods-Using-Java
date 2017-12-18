
public class Part3 {

	public static void main(String[] args) {
		Part3 pt = new Part3();
		pt.testCountGenes();
	}
	int countGenes(String dna){
        boolean isATG = false;
        boolean isTAA = false;
        int index = 0, count = 0;
        while(true){
            //System.out.println(" + "+index);
           // System.out.println(isATG + " " + isTAA);
            if(isATG && isTAA){
                count++;
                isATG = false;
                isTAA = false;
            }
            if(!isATG){
                index = dna.indexOf("ATG",index);
                if(index == -1) break;
                isATG = true;
            }
            else{
                index = dna.indexOf("TAA",index);
                if(index == -1) break;
                isTAA = true;
            }
        }
        return count;
    }
    void testCountGenes(){
        System.out.println(countGenes("ATGTAAGATGCCCTAAGT"));
        System.out.println(countGenes("ATGTTTTAAAATGTAA"));   
        System.out.println(countGenes("TTTTAAAATGATATTGGTATTATTATATATGGTTTAA"));
    }

}
