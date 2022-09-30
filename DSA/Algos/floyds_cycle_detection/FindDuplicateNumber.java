// problem statement: https://leetcode.com/problems/find-the-duplicate-number/
// solution details: https://www.youtube.com/watch?v=wjYnzkAhcNk

// #FAANG_favorite

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


  private boolean validateCharRule(String s, long rule_category, long min_length, long max_length, long category_max_length, long category_min_length){
    // whatever you have done

    if(rule_category == 1 && (spl > category_max_length || spl < category_min_length)) return false;
    if(rule_category ==  3 && (alpha > category_max_length || alpha < category_min_length)) return false;
    if(rule_category ==  2 && (num > category_max_length || num < category_min_length)) return false;
    return true;
  }

  if(validateCharRule(s, this.h_host_char_var.h_coppwrl_rule_category,8,20,
    this.h_host_char_var.h_coppwrl_min_char, this.h_host_char_var.h_coppwrl_max_char)){
      // success code
  }else{
    pwdErrorCode(input_area, output_head, output_area, con1, h_copbank_table, h_copbank_table);
		output_head.oh_error_code = 825;
  }
}