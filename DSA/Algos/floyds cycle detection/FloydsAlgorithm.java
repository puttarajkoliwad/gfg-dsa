// problem statement: Write a function to test if a given linked list has any cycle in it.
// problem link: https://www.geeksforgeeks.org/floyds-cycle-finding-algorithm/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

class FloydsAlgorithm{
  public static class Node{
    int value;
    int next;

    public Node(int value, int next) {
      this.value = value;
      this.next = next;
    }

    public String toString() {
      return this.value + "->" + this.next + "i";
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] s_nodes = br.readLine().split("\s");
    Node[] node_arr = new Node[n];
    // Node n0 = new Node(2, null);
    // node_arr[0] = node_arr[1] = n0;
    // System.out.println(node_arr[0] == node_arr[1]);
    int last_next = Integer.parseInt(br.readLine());
    for(int i=0; i<n; i++){
      if(i==n-1)
        node_arr[i] = new Node(Integer.parseInt(s_nodes[i]), last_next);
      else
        node_arr[i] = new Node(Integer.parseInt(s_nodes[i]), i+1);

        System.out.print(node_arr[i] + ", ");
    }

    System.out.println();
    boolean hasCycle = false;
    try{
      hasCycle = detectCycle(node_arr);
    }catch(Exception e){
      e.printStackTrace();
    }
    System.out.println("hasCycle?: "+ hasCycle);
  }

  public static boolean detectCycle(Node[] arr){
    int slow = 0;
    int fast = 0;
    while(arr[slow].next != -1 && arr[fast].next != -1){
      slow = arr[slow].next;
      fast = arr[arr[fast].next].next;

      if(slow == fast){
        return true;
      }
    }
    return false;
  }
}
