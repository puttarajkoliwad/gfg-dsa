// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/has-path-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HasPath {
    static class Edge{
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr =  nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] adj_list = new ArrayList[vertices];

        for(int i=0; i<vertices; i++){
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
        
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vertices];
        boolean has_path = hasPath(adj_list, src, dest, visited);
        System.out.println(has_path);
        br.close();
    }

    public static boolean hasPath(ArrayList<Edge>[] adj_list, int src, int dest, boolean[] visited) {
        if(src == dest) return true;
        visited[src] = true;
        for(Edge edg : adj_list[src]){
            if(!visited[edg.nbr]){
                boolean has_path = hasPath(adj_list, edg.nbr, dest, visited);
                if(has_path) return true;
            }
        }
        return false;
    }

}
