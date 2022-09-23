// problem statement: https://leetcode.com/problems/find-the-duplicate-number/
// solution details: https://www.youtube.com/watch?v=wjYnzkAhcNk

// #FAANG_favorite

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class FindDuplicateNumber{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] s_indices = br.readLine().split("\s");
    int[] indices = new int[n+1];
    for(int i=0; i<=n; i++) {
      indices[i] = Integer.parseInt(s_indices[i]);
    }

    int ans = floydsAlgorithm(indices);
    System.out.println(ans);
  }

  public static int floydsAlgorithm(int[] indices){
    int slow=0, fast=0;
    boolean crossed=false;
    int crossPoint= -1;
    while(!crossed){
      slow = indices[slow];
      fast = indices[indices[fast]];
      if(slow==fast){
        crossed = true;
        crossPoint = slow;
      }
    }

    // refer above links for details.
    slow = 0;
    int slow2 = crossPoint;
    while(slow != slow2){
      slow = indices[slow];
      slow2 = indices[slow2];
    }
    
    return slow;
  }
}