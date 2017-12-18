public class Part2{
	public static void main(String [] args) {
		Part2 pt = new Part2();
		pt.testSimpleGene();
	}
	public String findSimpleGene(String dna, int startCodon, int stopCodon ){
        dna = dna.toUpperCase();
        if(startCodon == -1) return "";
        while(stopCodon != -1){
            if((stopCodon - startCodon) % 3 == 0)
                return dna.substring(startCodon , stopCodon +1);
            else stopCodon = dna.indexOf("TAA",stopCodon + 3);
        }
        return "";
    }
    public void testSimpleGene(){
        //Test Case 1 for no ATG
        String dna = "GTATAAGTG";
        String gene = findSimpleGene(dna,-1,4);
        System.out.println("DNA string : " + dna + "\nGene : " + gene);
        
        //Test case 2 for no TAA
        dna = "GTATGAAGTGATA";
        gene = findSimpleGene(dna,2,-1);
        System.out.println("DNA string : " + dna + "\nGene : " + gene);
    
        //Test case 3 for have any one either ATG or TAA
        dna = "GTATGATAAGTGATA";
        gene = findSimpleGene(dna,2,4);
        System.out.println("DNA string : " + dna + "\nGene : " + gene); 
    
        //Test case 4 have ATG and TAA and the length of gene string is multiple by 3 
        dna = "GATGTATAAGTGATAATA";
        gene = findSimpleGene(dna,1,6);
        System.out.println("DNA string : " + dna + "\nGene : " + gene);
        
        //Test case have ATG and TAA and the length of gene string is not multiple by 3 
        dna = "GATGTATAGTGATAATA";
        gene = findSimpleGene(dna,1,13);
        System.out.println("DNA string : " + dna + "\nGene : " + gene);
        
    }
}