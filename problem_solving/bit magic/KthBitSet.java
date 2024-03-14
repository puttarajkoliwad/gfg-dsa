class KthBitSet{
  static boolean isKthBitSetLS(int n, int k){
    return ((n >> (k-1))&1) != 0;
  }

  static boolean isKthBitSetRS(int n, int k){
    return((1 <<(k-1))&n) != 0;
  }
  
  public static void main(String[] args) {
    System.out.println(isKthBitSetLS(127, 5));
    System.out.println(isKthBitSetRS(127, 5));
    System.out.println(isKthBitSetLS(128, 5));
    System.out.println(isKthBitSetRS(128, 5));
  }
}