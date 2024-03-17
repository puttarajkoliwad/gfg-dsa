// Given an array of integers, two elements in will be occurring odd number of times. Print those two odd occurring numbers.
/* test cases: 
    {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6} => 7, 8;
    {3, 4, 3, 4, 5, 4, 4, 6, 7, 7} => 5, 6;
    {3, 4, 3, 4, 5, 4, 4, 6, 7, 7, 5, 9} => 6, 9;
*/
// time complexity: O(N), space complexity: O(1)

/* Concept:
The XOR of entire array will be the XOR of those two odd elements, let this X.
- Any set bit in this X will be set in either of two odd elements. (Might also be set in other even occurring elements, but will will cacel each other cause even occurring again :lol)
- So, choose any number with the set bit in X. (be K)
- XOR with

*/

class TwoOddOccurring{
  static void findTwoOddOccurrences(int[] arr){
    int temp = 0, res1 = 0, res2= 0;
    for(int i:arr){
      temp ^= i;
    }
    
    int k = temp&(~(temp-1));
    for(int i:arr){
      if((i&k) == 0){
        res1 ^= i;
      }else{
        res2 ^= i;
      }
    }

    System.out.println(res1 + " " + res2);
  }
  
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6};
    int arr2[]= {3, 4, 3, 4, 5, 4, 4, 6, 7, 7};
    int arr3[]= {3, 4, 3, 4, 5, 4, 4, 6, 7, 7, 5, 9};
    findTwoOddOccurrences(arr);
    findTwoOddOccurrences(arr2);
    findTwoOddOccurrences(arr3);
  }
}