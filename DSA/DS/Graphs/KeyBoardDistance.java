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
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String line = "";
    ArrayList<String> lines = new ArrayList<String>();
    while((line = br.readLine()) != null && !line.isEmpty()){
      // sb.append(" ").append(line);
      lines.add(line);
    }
    // String str_input = sb.toString().replace('|', ' ');
    // System.out.print(str_input);
    String[] keys = new String[lines.size()-1];
    for(int i=0; i<keys.length; i++){
      keys[i] = lines.get(i).replace('|', ' ').trim();
    }
    // String[] raw_input = str_input.trim().split("\\s+");
    // String[] keys = new String[raw_input.length-1];
    // for(int i = 0; i < keys.length; i++){
    //   keys[i] = raw_input[i];
    // }
    // String str = raw_input[keys.length];
    String str = lines.get(keys.length).toLowerCase();
    // System.out.println("str: "+str);
    int longestRow = 0;

    if(str.length() == 1){
      System.out.println("Total distance: 0");
      System.exit(0);
    }

    for(int i = 0; i < keys.length; i++){
      if(longestRow < keys[i].length()){
        longestRow = keys[i].length();
      }
    }

    keyboard = buildKeyBoard(keys, longestRow);
    // System.out.println("keyboard length: " + keyboard.length + ", "+ longestRow);
    // for(int i=0; i<keyboard.length; i++){
    //   for(int j=0; j<keyboard[i].length; j++){
    //     System.out.print(keyboard[i][j] + " ");
    //   }
    //   System.out.println();
    // }
    // System.out.println("last char: "+keyboard[2][9]);

    HashMap<Character, ArrayList<Integer[]>> hm = new HashMap<Character, ArrayList<Integer[]>>();
    for(int i=0; i<keyboard.length; i++){
      for(int j=0; j<keyboard[i].length; j++){
        char c = keyboard[i][j];
        // Integer[] arr = {i, j};
        if(hm.containsKey(c)){
          ArrayList<Integer[]> al = hm.get(c);
          al.add(new Integer[]{i, j});
          hm.put(c, al);
        }else{
          // if(c == 'p') System.out.println("p: "+i+", "+j);
          ArrayList<Integer[]> al = new ArrayList<Integer[]>();
          al.add(new Integer[]{i, j});
          // System.out.println();
          hm.put(c, al);
        }
      }
    }
    // System.out.println("p: " + hm.get('p').get(0)[0] + ", " + hm.get('p').get(0)[1]);
    // for(char c : hm.keySet()){
    //   System.out.println(c +": "+hm.get(c));
    // }

    char c = str.charAt(0);
    if(!hm.containsKey(c)){
      System.out.println("Total distance: -1.0");
      System.exit(0);
    }
    for(int i=0; i<hm.get(c).size(); i++){
      ArrayList<Integer[]> al = hm.get(c);
      int x = al.get(i)[0];
      int y = al.get(i)[1];
      pq.add(new Word(x, y, str.charAt(1), 0, 0));
    }

    double total_distance = Double.MAX_VALUE;

    while(!pq.isEmpty()){
      Word w = pq.poll();
      char next_c = str.charAt(w.currIndexInStr + 1);
      boolean sec_last_char = (w.currIndexInStr == str.length()-2);
      if(!hm.containsKey(next_c)){
        System.out.println("Total distance: -1.0");
        break;
      }
      ArrayList<Integer[]> indices = hm.get(next_c);
      // System.out.println("Indices: " + indices.size());
      for(int i = 0; i < indices.size(); i++){
        int x1 = indices.get(i)[0];
        int y1 = indices.get(i)[1];
        double new_dist = w.distance + calculateDistance(w.x, w.y, x1, y1);
        if(sec_last_char){
          // System.out.println("dist_till_now: "+w.distance);
          // System.out.println("new_dist: "+calculateDistance(w.x, w.y, x1, y1));
          total_distance = Math.min(new_dist, total_distance);
        }
        if(w.currIndexInStr < str.length()-2) pq.add(new Word(x1, y1, next_c, new_dist, w.currIndexInStr + 1));
      }
      // if(sec_last_char){
      //   System.out.println("Total distance: " + Math.round(total_distance * 10.0)/10.0);
      //   break;
      // }
    }  
    System.out.println("Total distance: " + Math.round(total_distance * 10.0)/10.0);
  }

  /**
   * @param x0
   * @param y0
   * @param x1
   * @param y1
   * @return
   */
  public static double calculateDistance(int x0, int y0, int x1, int y1){
    // System.out.println("x1: " + x1 + ", y1: " + y1 + ", x0: " + x0 + ", y0: ");
    // Need to handle the "Direction not changed case!!"
    return Math.sqrt(Math.pow(x1-x0, 2) + Math.pow(y1-y0, 2));
  }

  public static char[][] buildKeyBoard(String[] keys, int longestRow){
    char[][] keyboard = new char[keys.length][longestRow];
    for(int i = 0; i < keys.length; i++){
      // keyboard[i] = keys[i].toCharArray();
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