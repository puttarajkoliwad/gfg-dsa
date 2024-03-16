// Given a 32 bit integer N, count the number of set bits in binary representation of N.
// testcases: 11 => 3; 7=>3; 8 => 1; 0 => 0
// Space complexity: O(1), time complexity: O(1)

// prerequisites: './BrianKerninghamAlgo.java'

class CountSetBits{
  static int[] lookUp = new int[256];

  // build lookup table
  static {
    lookUp[0] = 0;
    for(int i=1; i<256; i++){
      lookUp[i] = lookUp[i&(i-1)] + 1;
    }
  }

  static int optimizedBrianAndKerninghamAlgo(int n){
    return lookUp[n&255] + lookUp[(n>>8)&255] + lookUp[(n>>16)&255] + lookUp[n>>24];
  }
  
  public static void main(String[] args) {
    System.out.println(optimizedBrianAndKerninghamAlgo(11));
    System.out.println(optimizedBrianAndKerninghamAlgo(7));
    System.out.println(optimizedBrianAndKerninghamAlgo(8));
    System.out.println(optimizedBrianAndKerninghamAlgo(0));
    System.out.println(optimizedBrianAndKerninghamAlgo(1000));
  }
}