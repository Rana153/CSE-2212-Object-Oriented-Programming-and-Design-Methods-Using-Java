public class Part1{
	public static void main(String [] args) {
		Part1 p = new Part1();
		p.testSimpleGene();
	}
	public String findSimpleGene(String dna){
        int startCodon , stopCodon;
        startCodon = dna.indexOf("ATG");
        if(startCodon == -1) return "";
        stopCodon = dna.indexOf("TAA", startCodon + 3);
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
        String gene = findSimpleGene(dna);
        System.out.println("DNA string : " + dna + "\nGene : " + gene);
        
        //Test case 2 for no TAA
        dna = "GTATAAGTGATA";
        gene = findSimpleGene(dna);
        System.out.println("DNA string : " + dna + "\nGene : " + gene);
    
        //Test case 3 for have any one either ATG or TAA
        dna = "GTATGATAAGTGATA";
        gene = findSimpleGene(dna);
        System.out.println("DNA string : " + dna + "\nGene : " + gene); 
    
        //Test case 4 have ATG and TAA and the length of gene string is multiple by 3 
        dna = "GATGTATAAGTGATAATA";
        gene = findSimpleGene(dna);
        System.out.println("DNA string : " + dna + "\nGene : " + gene);
        
        //Test case have ATG and TAA and the length of gene string is not multiple by 3 
        dna = "GATGTATAGTGATAATA";
        gene = findSimpleGene(dna);
        System.out.println("DNA string : " + dna + "\nGene : " + gene);
        
    }
    
}