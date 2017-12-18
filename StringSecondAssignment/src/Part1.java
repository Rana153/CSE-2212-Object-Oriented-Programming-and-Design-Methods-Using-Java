public class Part1{
	public static void main(String [] args) {
		Part1 pt = new Part1();
		//pt.testFindAllGene();
		pt.testFindGene();
		//pt.testFindStopCodon();
		pt.testHowMany();
	}
    int findStopCodon(String dna, int startIndex, String stopCodon){
        
        int endIndex = startIndex;
        while(endIndex != -1){
            endIndex = dna.indexOf(stopCodon, endIndex + 1);
            if(endIndex != -1 && (endIndex - startIndex) % 3 == 0){
                return endIndex;
            }
        }
        return dna.length();
    }
    String findGene(String dna){
        
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1)
            return "";
        int index = findStopCodon(dna, startIndex, "TAA");
        if(index == dna.length()){
            index = findStopCodon(dna, startIndex, "TAG");
        }
        if(index == dna.length()){
            return "";
        } 
        else{
            return dna.substring(startIndex, index + 3);
        }
    }
     void findAllGenes(String dna){
        
        String gene = "";
        int count = 1;
        int sInd = 0;
        int index = -1;
        do{
            sInd = dna.indexOf("ATG", index + 1);
            if(sInd == -1){
                break;
            }
            index = findStopCodon(dna, sInd, "TAA");
            if(index == dna.length()){
                index = findStopCodon(dna, sInd, "TAG");
            }
            if(index == dna.length()){
                break;
            }
            gene = dna.substring(sInd, index + 3);
            System.out.println("Gene" + ": " + gene);
        }while(gene != "");
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
     }
    void testFindAllGene(){
        
        String dna = "AGATTAGAATGTAG";
        findAllGenes(dna);
        dna = "GGATGACAATAGACGGTCGGTCCCCATTTACGTTAGCATGACTAAC";
        findAllGenes(dna);
        
    }
    void testFindGene(){
        String dna = "ATACGATATTATACCCGAGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
        
        //no atg
        dna = "ATACGATATTATAACCCGAGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
        
        //no taa
        dna = "ATGACGATATTATACCCGAGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
        
        //multiple by 3
        dna = "ATGACGATAATATAACGGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
        
        //multiple taa
        dna = "ATGAGTAATATAACTAACCGAGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
        
        //multiple tag
        dna = "ATGACGATAGTAACCGAGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
    }
    
    void testFindStopCodon(){
        
        String dna = "ATACGATATTATACCCGAGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
        
        //no atg
        dna = "ATACGATATTATAACCCGAGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
        
        //no taa
        dna = "ATGACGATATTATACCCGAGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
        
        //multiple by 3
        dna = "ATGACGATAATATAACGGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
        
        //multiple taa
        dna = "ATGAGTAATATAACTAACCGAGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
        
        //multiple tag
        dna = "ATGACGATAGTAACCGAGAT";
        System.out.println("DNA: " + dna);
        System.out.println("Gene: " + findGene(dna));
    }
}
