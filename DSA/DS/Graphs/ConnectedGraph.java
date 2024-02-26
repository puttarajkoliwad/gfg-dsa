// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/is-graph-connected-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConnectedGraph {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

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
            int wt = Integer.parseInt(parts[2]);
            adj_list[src].add(new Edge(src, nbr, wt));
            adj_list[nbr].add(new Edge(nbr, src, wt));
        }

        boolean[] visited = new boolean[verts];
        ArrayList<Integer> dfs = new ArrayList<Integer>();
        isGraphConnected(adj_list, 0, dfs, visited);
        if(dfs.size() == verts){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    public static void isGraphConnected(ArrayList<Edge>[] adj_list, int head, ArrayList<Integer> dfs, boolean[] visited){
        if(!visited[head]){
            dfs.add(head);
            visited[head] = true;
            // System.out.println(dfs);
        }
        for(Edge e: adj_list[head]){ 
            if(!visited[e.nbr]){
                isGraphConnected(adj_list, e.nbr, dfs, visited);
            }
        }
    }
    
}
