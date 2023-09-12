import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class IsPalindromePossible {
  public static boolean isPalindromePossible(String str){
    Map<Character, Integer> tm = new TreeMap<Character, Integer>();

    for(int i=0; i<str.length(); i++){
      char key = str.charAt(i);
      if(tm.containsKey(key)){
        tm.put(key, tm.get(key) + 1);
      }else{
        tm.put(key, 1);
      }
    }

    int oddCharCount = 0;
    Set<Character> keys = tm.keySet(); // No need of TreeSet for this problem, but still using this because we need SortedSet functionality in 'finding lexicographic anagram(https://www.geeksforgeeks.org/print-palindromic-permutations-given-string-alphabetic-order/)', an extended version of this problem.
    System.out.println(keys);
    // Iterator<Character> i = keys.iterator();
    // while(i.hasNext()){
    //   int charCount = tm.get(i.next());
    //   if(charCount%2 != 0){
    //     oddCharCount++;
    //     if(oddCharCount > 1) return false;
    //   }
    // }

    for(Character c : keys){
      if(tm.get(c)%2 != 0){
        oddCharCount++;
        if(oddCharCount > 1) return false;
      }
    }

    return true;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine().trim();
    System.out.println(isPalindromePossible(str));
  }
}
