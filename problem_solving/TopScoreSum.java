public class TopScoreSum {

    public static void main(String[] args) {
       
    }

    public int marathon(int input1, int input2, int[] input3){
        int sum = 0;
        Arrays.sort(input3);
        for(int i=input1-input2; i<input1; i++){
            sum+= input3[i];
        }
        return sum;
    }
    
}
