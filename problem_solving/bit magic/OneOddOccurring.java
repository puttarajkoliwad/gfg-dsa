// Given an array of integers with only one element occurring odd number of times, return that odd occuring element
// testcases: {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 8, 9, 7, 6, 6, 6} => 6;
// time complexity: O(N), space complexity: O(1)

class OneOddOccurring{
  static int findOddOccurringElement(int[] arr){
    int res = 0;
    for(int i:arr){
      res ^= i;
    }
    return res;
  }
  
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 8, 9, 7, 6, 6, 6};
    System.out.println(findOddOccurringElement(arr));
  }
}