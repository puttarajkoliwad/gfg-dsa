// problem statement: https://leetcode.com/problems/first-missing-positive/submissions/816865435/
// solution from: Neetcode youtube: youtube.com/watch?v=8g78yfzMlao

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FirstMissingPositive {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] s_arr = br.readLine().split("\s");
    for(int i = 0; i < n; i++){
      arr[i] = Integer.parseInt(s_arr[i]);
    }

    int ans = firstMissingPositive(arr);
    System.out.println(ans);
  }  

  public static int firstMissingPositive(int[] arr){
      int n = arr.length;
      // arr = [2, 1, 3]
      //01) solution lies b/w 1..(N+1)

      //02) -ve values are initially useless for us, eliminate them.
      for(int i=0; i<n; i++){
        if(arr[i] < 0){
          arr[i] = 0;
        }
      }

      // 03) mark/negate the presence of a value.
      /**
       * let i=0:
       * arr[i] - 1 = 2 - 1 = 1
       * negate the value at (arr[arr[i] -1], i.e. 1 here) if not already -ve to indicate 'i+1' is present.
       */
      for(int i=0; i<n; i++) {
        int num = Math.abs(arr[i])-1;

        // work only if num is in bounds, ignore otherwise
        if(num>=0 && num<n){
          // negate if referring index value > 0.
          if(arr[num] > 0){
            arr[num] = -arr[num];
          }else if(arr[num] == 0){
            // negating 0 will be ineffective. So we need to put some other -ve value which doesn't effect solution space(1..N+1). (-(N+1) or more would be ideal because everything after N will be out of bounds and hence ignored).
            arr[num] = -(n+5);
          }
        }
      }

      // return the i+1 if value there is +ve. Because, if i+1 was present, the value would have been negated in previous step.
      for(int i=0; i<n; i++){
        if(arr[i] >= 0){
          return i+1;
        }
      }

      // if nothing is returned above everything in 1..N is present. The next will be N+1, hence return it.
      return n+1;
  }
}
