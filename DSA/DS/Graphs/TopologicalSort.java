// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/compilation-order-official/ojquestion

// Topological sort is a permutation of vertices in such way that for all the edges in the graph the source vertex should come before the nbr vertex in that permutation.

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static class Edge{
        int src;
        int nbr;
        
        public Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static Stack<Integer> s = new Stack<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int verts = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] adj_list = new ArrayList[verts];
        for(int i=0; i<verts; i++){
            adj_list[i] = new ArrayList<Edge>();
        }
        for(int i=0; i<edges; i++){
            String[] parts = br.readLine().split("\s");
            int src = Integer.parseInt(parts[0]);
            int nbr = Integer.parseInt(parts[1]);
            adj_list[src].add(new Edge(src, nbr));
        }
        boolean[] visited = new boolean[verts];

        for(int i=0; i<verts; i++) {
            if(!visited[i]){
                compileDependent(adj_list, i, visited);
            }
        }

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void compileDependent(ArrayList<Edge>[] adj_list, int src, boolean[] visited) {
        if(visited[src]) return;

        visited[src] = true;
        for(Edge e:adj_list[src]){
            if(!visited[e.nbr]){
                compileDependent(adj_list, e.nbr, visited);
            }
        }
        s.push(src);
    }
    
}
