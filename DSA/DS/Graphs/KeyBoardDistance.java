// problem statement: https://github.com/amilne-mdsol/scala_golf/blob/challenge8_setup/src/main/scala/example/Main.scala


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class KeyBoardDistance{

  public static class Word implements Comparable<Word>{
    int x;
    int y;
    double distance;
    char next;
    int currIndexInStr;

    public Word(int x, int y, char next, double distance, int currIndexInStr){
      this.x = x;
      this.y = y;
      this.distance = distance;
      this.next = next;
      this.currIndexInStr = currIndexInStr;
    }

    public int compareTo(Word w){
      return this.distance > w.distance ? 1 : -1;
    }
  }

  public static char[][] keyboard;
  public static PriorityQueue<Word> pq = new PriorityQueue<Word>();
  public static HashMap<Character, ArrayList<Integer[]>> hm = new HashMap<Character, ArrayList<Integer[]>>();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    ArrayList<String> lines = new ArrayList<String>();
    while((line = br.readLine()) != null && !line.isEmpty()){
      lines.add(line);
    }
    String[] keys = new String[lines.size()-1];
    for(int i=0; i<keys.length; i++){
      keys[i] = lines.get(i).replace('|', ' ').trim();
    }
    String str = lines.get(keys.length).toLowerCase();
    int longestRow = 0;

    if(str.length() == 1){
      System.out.println("0");
      System.exit(0);
    }

    for(int i = 0; i < keys.length; i++){
      if(longestRow < keys[i].length()){
        longestRow = keys[i].length();
      }
    }

    keyboard = buildKeyBoard(keys, longestRow);

    // HashMap<Character, ArrayList<Integer[]>> hm = new HashMap<Character, ArrayList<Integer[]>>();
    for(int i=0; i<keyboard.length; i++){
      for(int j=0; j<keyboard[i].length; j++){
        char c = keyboard[i][j];
        if(hm.containsKey(c)){
          ArrayList<Integer[]> al = hm.get(c);
          al.add(new Integer[]{i, j});
          hm.put(c, al);
        }else{
          ArrayList<Integer[]> al = new ArrayList<Integer[]>();
          al.add(new Integer[]{i, j});
          hm.put(c, al);
        }
      }
    }

    char c = str.charAt(0);
    if(!hm.containsKey(c)){
      System.out.println("-1.0");
      System.exit(0);
    }
    for(int i=0; i<hm.get(c).size(); i++){
      ArrayList<Integer[]> al = hm.get(c);
      int x = al.get(i)[0];
      int y = al.get(i)[1];
      pq.add(new Word(x, y, str.charAt(1), 0, 0));
    }

    double total_distance = Double.MAX_VALUE;

    // while(!pq.isEmpty()){
    //   Word w = pq.poll();
    //   char next_c = str.charAt(w.currIndexInStr + 1);
    //   boolean sec_last_char = (w.currIndexInStr == str.length()-2);
    //   if(!hm.containsKey(next_c)){
    //     System.out.println("-1.0");
    //     break;
    //   }
    //   ArrayList<Integer[]> indices = hm.get(next_c);
    //   for(int i = 0; i < indices.size(); i++){
    //     int x1 = indices.get(i)[0];
    //     int y1 = indices.get(i)[1];
    //     double new_dist = w.distance + calculateDistance(w.x, w.y, x1, y1);
    //     if(sec_last_char){
    //       total_distance = Math.min(new_dist, total_distance);
    //     }
    //     if(w.currIndexInStr < str.length()-2) pq.add(new Word(x1, y1, next_c, new_dist, w.currIndexInStr + 1));
    //   }
    // } 
    total_distance = getTotalDistance(pq, total_distance, str, str.length()); 
    System.out.println(Math.round(total_distance * 10.0)/10.0);
  }

  public static double getTotalDistance(PriorityQueue<Word> pq, double ans, String str, int len){
    if(pq.isEmpty()){
      return ans;
    }else{
      Word w = pq.poll();
      char next_c = str.charAt(w.currIndexInStr + 1);
      boolean sec_last_char = w.currIndexInStr == len-2;
      if(!hm.containsKey(next_c)){
        // System.out.println("-1.0");
        return -1.0;
      }
      ArrayList<Integer[]> indices = hm.get(next_c);
      for(int i = 0; i < indices.size(); i++){
        int x1 = indices.get(i)[0];
        int y1 = indices.get(i)[1];
        double new_dist = w.distance + calculateDistance(w.x, w.y, x1, y1);
        if(sec_last_char){
          ans = Math.min(new_dist, ans);
        }
        if(w.currIndexInStr < len-2) pq.add(new Word(x1, y1, next_c, new_dist, w.currIndexInStr + 1));
      }
      getTotalDistance(pq, ans, str, len);
    }
    return ans;
  }

  public static double calculateDistance(int x0, int y0, int x1, int y1){
    return Math.sqrt(Math.pow(x1-x0, 2) + Math.pow(y1-y0, 2));
  }

  public static char[][] buildKeyBoard(String[] keys, int longestRow){
    char[][] keyboard = new char[keys.length][longestRow];
    for(int i = 0; i < keys.length; i++){
      int len = keys[i].length();
      int j=0;
      for(; j<len; j++){
        keyboard[i][j] = keys[i].charAt(j);
      }
      for(;j<longestRow; j++){
        keyboard[i][j] = '-';
      }
    }
    return keyboard;
  }
}