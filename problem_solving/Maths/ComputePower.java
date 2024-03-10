// Given two integers base and power, find the result of base raised to it's power
// testcases: 2, 3 => 8; 2, 5 => 32; 7, 2 => 49; 3, 3 => 27; 3, 4 => 81

// #bitmagic

class ComputePower{
  // recursive solution, time complexity: O(log(N)), space complexity: O(log(N))
  static int calculatePowerRecursively(int base, int power){
    // Syste
    if(power == 0) return 1;
    int temp = calculatePowerRecursively(base, power/2);
    temp *= temp;
    if(power%2 == 0) return temp;
    else return temp * base;
  }

  // using bit-magic
  /*
    3^10 = 3^8 * 3^2; binary(10) => 1010 i.e. 8 + 2 => 3rd bit and 1st bit are set
    3^19 = 3^16 * 3^2 * 3^1; binary(19) => 10011 i.e. 16 + 2 + 1 => 4th, 1st and 0th bit are set
    
    The logic is to in the binary representation of power, square the actual base at each bit, and then in the end multiply the result of set bits

    space complexity: O(1), time complexity: O(log(power))
  */
  static int calculatePowerUsingBits(int base, int power){
    int result = 1;

    while(power > 0){
      if(power%2 != 0){
        // This is a set bit, so multiply result with the current value of base
        result *= base;
      }
      base *= base; // square the base at every bit
      power /= 2; // reduce the power to find the value (0 OR 1) for next bit
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    System.out.println(calculatePowerRecursively(2,3));
    System.out.println(calculatePowerUsingBits(2,3));
    System.out.println(calculatePowerRecursively(2,5));
    System.out.println(calculatePowerUsingBits(2,5));
    System.out.println(calculatePowerRecursively(7,2));
    System.out.println(calculatePowerUsingBits(7,2));
    System.out.println(calculatePowerRecursively(3,3));
    System.out.println(calculatePowerUsingBits(3,3));
    System.out.println(calculatePowerRecursively(3,4));
    System.out.println(calculatePowerUsingBits(3,4));
  }
}