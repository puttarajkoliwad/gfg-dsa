// Given a number N, print its digits in reverse order of its original order.
//  input: 8976, output: 6798
// Space complexity: O(1), Time complexity: O(D), D => number of digits

class ReverseNumber{
  static int reverseNumber(int num){
    int res = 0;
    // int counter = 0;

    while(num > 0){
      int rem = num%10;
      res = (res * 10) + rem;
      num /= 10;
    }
    
    return res;
  }

  public static void main(String[] args) {
    System.out.println(reverseNumber(8976));
  }
}