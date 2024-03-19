// Given a string str, find its power set. A power set contains all the strings that can be formed using those chars in the string
// time complexity: O((2**N)*N), space complexity: O(1)

class PowerSet{
  static void printPowerSet(String str){
    int n = str.length();
    int pSize = 1 << n;
    for(int i=0; i<pSize; i++){
      for(int j=0; j<n; j++){
        if((i&(1<<j)) != 0){
          System.out.print(str.charAt(j));
          // System.out.print(""+ str.charAt(j) + " "+i+" "+j);
          // System.out.print(""+ str.charAt(j) + " "+i+j+" ");
        }
      }
      // System.out.println(i+" "+j);
      System.out.println();
    }
  }
  public static void main(String[] args) {
    String str = "abcd";
    printPowerSet(str);
  }
}