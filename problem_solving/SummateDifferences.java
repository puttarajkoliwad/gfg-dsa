// Find the subset of length 'k' from an array of integers such that the sum of absolute differences b/w each pair of elements in the subset is maximum

// Theory: https://excalidraw.com/#json=MPoSzT8n5rJYe__AlAY2r,HNyzIyGy94x8to3t8QqnTQ

public class SummateDifferences{
  static int[] selectSubset(int[] arr, int k){
    // two pointers can be applies here
    int[] subArr = new int[k];
    Arrays.sort(arr);
    int start=1;
    int end=arr.length - 2;
    int min = subArr[0] = arr[0];
    int max = subArr[1] = arr[arr.length-1];
    int j=2;
    
    while(start <= end && j<k){
      if(arr[start] - min < max - arr[end]){
        subArr[j] = arr[start];
        start++;
      }else{
        subArr[j] = arr[end];
        end--;
      }
      j++;
    }

    return subArr;
  }
  
  public static void main(String args[]) {
    int x=10;
    int y=25;
    int z=x+y;
    
    int[] arr = {1, 5, 2, 3, 9};
    
    int[] res = selectSubset(arr, 2);
    System.out.println(Arrays.toString(res));
  }
}