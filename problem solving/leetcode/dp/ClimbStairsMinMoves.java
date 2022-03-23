// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-minimum-moves-official/ojquestion
// solution explanation: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb_stairs_with_minimum_moves/topic


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClimbStairsMinMoves {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] steps = new int[n];
        for(int i = 0; i < n; i++) steps[i] = Integer.parseInt(br.readLine());
        // for(int i = 0; i < steps.length; i++){
        //     System.out.print(steps[i]+" ");
        // }
        System.out.println("=========");
        int ans = climbStairsMinMoves(steps);
        System.out.println(ans);
    }

    public static int climbStairsMinMoves(int[] steps){
        int ans = 0;
        int n = steps.length;
        int[] min_jumps = new int[n+1];
        min_jumps[n] = 1;
        // int per = 0;
        for(int i=n-1; i>=0; i--){
            if(i + steps[i] >= n){
                min_jumps[i] = 1;
                // System.out.println("n i: "+ i + ", steps[i]: "+ steps[i]+ ", jumps[i]: "+min_jumps[i]);
                continue;
            }
            int temp = Integer.MAX_VALUE;
            for(int j=1; j<=steps[i] && i+j <= n; j++){
                // per++;
                // System.out.println("performance: "+per);
                if(min_jumps[i+j] != 0 && min_jumps[i+j] < temp){
                    temp = min_jumps[i+j];   
                }
            }
            if(temp != Integer.MAX_VALUE) min_jumps[i] = temp + 1;
            // System.out.println("c i: "+ i + ", steps[i]: "+ steps[i]+ ", jumps[i]: "+min_jumps[i]);
        }
        ans = min_jumps[0];
        // System.out.println("========");
        // for(int i=0; i<=n; i++){
        //     System.out.print(min_jumps[i]+ " ");
        // }
        return Integer.max(ans, 0);
    }
}
