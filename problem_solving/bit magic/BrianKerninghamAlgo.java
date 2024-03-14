// Given an integer N, count the number of set bits in binary representation of N.
// testcases: 11 => 3; 7=>3; 8 => 1; 0 => 0
// Space complexity: O(1), time complexity: O(k), k=> number of set bits

// related to './CountSetBits.java'

class BrianKerninghamAlgo{
  static int brianAndKerninghamAlgo(int n){
    int count = 0;

    // Unset LSBs one by one
    while(n>0){
      n = n&(n-1);
      count++;
    }
    
    return count;
  }
  public static void main(String[] args) {
    System.out.println(brianAndKerninghamAlgo(11));
    System.out.println(brianAndKerninghamAlgo(7));
    System.out.println(brianAndKerninghamAlgo(8));
    System.out.println(brianAndKerninghamAlgo(0));
  }
}