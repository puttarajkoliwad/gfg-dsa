import java.util.*;
public class Polycarb {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      for(int k=0; k<t; k++) {
        int n = scan.nextInt();
        int x = scan.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int sum = 0;
        for(int i=0; i< n; i++){
            int elem = scan.nextInt();
            // arr[i] = elem;        
            pq.add(elem);
            sum += elem;
        }

        for(int i=0; i< x; i++){
            int top = pq.poll();
            sum -= (2*top);
            // sum += -top;
        }

        // int max = getMaxOpSum(arr, x);
        System.out.println(sum);
      }
      scan.close();
   } 
}
