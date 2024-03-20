// Given an integer N, Flip all the bits in N till its MSB
// Testcases: 23 => 8;
// Time complexity: O(MSBLength), space complexity: O(1)

/*
  It can be done by a simple way, just simply subtract the number from the value obtained when all the bits are equal to 1 .

For example:

       Number : Given Number
       Value  : A number with all bits set in given number.
       Flipped number = Value – Number.

       Example : 
       Number = 23,
       Binary form: 10111;
       After flipping digits number will be: 01000;
       Value: 11111 = 31;
*/

class FlipBits{
  static int getMaxForBitLength(int bitsLength) {
    int val = 0;
    for(int i=0; i<bitsLength; i++){
      val = (val << 1) | 1;
    }
    System.out.println("val = " + val);
    return val;
  }

  static int setAllBitsTillMSB(int num){
    int val = 1;
    while(val < num){
      val <<= 1;
      val |= 1;
    }
    System.out.println("val = " + val);
    return val;
  } 
  
  // static int flipBits(int num, int bitsLength){
  static int flipBits(int num){
    int val = setAllBitsTillMSB(num);
    // int val = getMaxForBitLength(bitsLength);
    return val - num;
  }

  public static void main(String[] args) {
    System.out.println(flipBits(23));
  }
}