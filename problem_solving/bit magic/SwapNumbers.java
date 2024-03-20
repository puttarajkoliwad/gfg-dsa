// Given two integers a and b, swap their values WITHOUT using any extra variable.
// Test cases: 12, 13 => 13, 12
// time complexity: O(1), space complexity: O(1)

class SwapNumbers{
  static void swapNumbers(int a, int b){
    System.out.println("Before swapping: a=" +a + ", b=" +b);
    a ^=b;
    b ^=a;
    a ^=b;
    System.out.println("After swapping: a=" +a + ", b=" +b);
  }

  public static void main(String[] args) {
    int a = 12, b = 13;
    swapNumbers(a, b); // a and b are primitive hence this is 'call by value', the values would be swapped in swapNumbers method only. Not here.
  }
}