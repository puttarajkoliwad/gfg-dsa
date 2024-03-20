// Given a number N, the task is to find the XOR of all numbers from 1 to N
// Testcases: 6 => 7; 7 => 0;
// Time complexity: O(1), space complexity: O(1)

/*
  Examples :

  Input : N = 6
  Output : 7
  // 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6  = 7

  Input : N = 7
  Output : 0
  // 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 = 0
  Solution:
  Find the remainder of N by moduling it with 4.
  If rem = 0, then xor will be same as N.
  If rem = 1, then xor will be 1.
  If rem = 2, then xor will be N+1.
  If rem = 3 ,then xor will be 0.
*/

class XorTillN{
  static int xorTillN(int num){
    switch(num%4){
      case 0: return num;
      case 1: return 1;
      case 2: return num+1;
      case 3: return 0; // putting outside the switch block
    }
    return 0;
  }
  public static void main(String[] args) {
    System.out.println(xorTillN(6));
    System.out.println(xorTillN(7));
  }
}