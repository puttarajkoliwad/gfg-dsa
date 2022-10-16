import java.util.regex.*;
public class DNASequence {
    public static void main(String[] args) {
        String dna = "stuvwxyz";
        String[] genes = {"t", "dd", "twx", "uwyz", "zta"};
        solve(dna, genes);
    }
    public static void solve(String dnaSequence, String[] genes){
        Pattern p = Pattern.compile(dnaSequence);
        for(int i=0; i<genes.length;i++){
            // String reg = "(.*)"+genes[i]+"(.*)";
            if(p.matcher(String.join("*", genes[i].split(""))).matches()){
                System.out.print(genes[i]);
                if(i != genes.length-1){
                    System.out.print(" ");
                }
            }
        }
    }
}
