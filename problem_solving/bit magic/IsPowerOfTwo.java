// Given an integer N, check if it is a power of two
// Testcases: 0 => true; 1 => true; 2 => true; 3 => false; 4 => true; 7 => false; 8 => true; 12 => false
// Time complexity: O(1), space complexity: O(1)

class IsPowerOfTwo{
  static boolean isPowerOfTwo(int n){
    return (n == 0) || ((n&(n-1))==0);
  }

  public static void main(String[] args) {
    System.out.println(isPowerOfTwo(0));
    System.out.println(isPowerOfTwo(1));
    System.out.println(isPowerOfTwo(2));
    System.out.println(isPowerOfTwo(3));
    System.out.println(isPowerOfTwo(4));
    System.out.println(isPowerOfTwo(7));
    System.out.println(isPowerOfTwo(8));
    System.out.println(isPowerOfTwo(12));
  }
}