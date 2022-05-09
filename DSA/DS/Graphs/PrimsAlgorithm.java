// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/minimum-wire-to-connect-all-pcs-official/ojquestion

// Prim's Algorithm is used to find Minimum Spanning Tree(MST) in the graph. MST is a 
// - subgraph that has all the vertices of the parent graph
// - has no cycles and
// - is a connected graph

// Difference b/w Djkstra's algorithm and Prim's algorithm is that Djikstra's might not cover all the vertices. It just focuses on finding shortes path b/w any 2 nodes. But, Prim's will cover all the vertices allowing us to visit all the nodes with min cost.

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Edge{
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair>{
        int vertex;
        int parent;
        int cost;

        public Pair(int vertex, int parent, int cost){
            this.vertex = vertex;
            this.parent = parent;
            this.cost = cost;
        }

        public int compareTo(Pair o){
            return this.cost - o.cost;
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

        primsAlgorithm(adj_list);
    }

    public static void primsAlgorithm(ArrayList<Edge>[] adj_list){
        int verts = adj_list.length;
        boolean[] visited = new boolean[verts];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(0, -1, 0));
        while(!pq.isEmpty()){
            // Delete Mark* Work Add*
            Pair p = pq.remove();

            if(!visited[p.vertex]){
                visited[p.vertex] = true;
            }else{
                continue;
            }

            if(p.parent != -1){
                System.out.println("["+p.vertex+"-"+p.parent+"@"+p.cost+"]");
            }

            for(Edge e:adj_list[p.vertex]){
                if(!visited[e.nbr]){
                    pq.add(new Pair(e.nbr, p.vertex, e.wt));
                }
            }
        }
    }
    
}
