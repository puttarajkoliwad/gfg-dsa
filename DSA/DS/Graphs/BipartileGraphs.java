// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/is-bipartite-official/ojquestion

// A graph is said to be "Bipartile" if it is possible to split the graph in two sets such that no vertices have an edge with the verted of the same set and the two sets are mutually exclusive and exhaustive. i.e., two sets combined should have all the vertices of the graph.

// Every non-cyclic graph is Bipartile
// Every EVEN-cyclic graph is Bipartile.

// Time complexity of this code is O(m*n), m = verts, n = edges

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.HashSet;

public class BipartileGraphs {
    static class Edge{
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair{
        int vertex;
        String path;

        public Pair(int vertex, String path) {
            this.vertex = vertex;
            this.path = path;
        }
    }

    public static HashSet<Integer> oddSet = new HashSet<Integer>();
    public static HashSet<Integer> evenSet = new HashSet<Integer>();
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
            adj_list[nbr].add(new Edge(nbr, src));
        }

        boolean[] visited = new boolean[verts];
        
        boolean oset = false, eset = false;
        for(int i = 0; i <verts; i++){
            evenSet.clear();
            oddSet.clear();
            if(!visited[i]){
                ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
                queue.add(new Pair(i, i+""));
                boolean isBipartile = false;
                while(!queue.isEmpty()) {
                    // Remove Mark* Work Add*
                    Pair p = queue.removeFirst();

                    if(!visited[p.vertex]){
                        visited[p.vertex] = true;
                    }

                    if(eset){
                        if(oddSet.contains(p.vertex)){
                            System.out.println(false);
                            return;
                        }else{
                            evenSet.add(p.vertex);
                        }
                        eset = false;
                    }else{
                        if(evenSet.contains(p.vertex)){
                            System.out.println(false);
                            return;
                        }else{
                            oddSet.add(p.vertex);
                        }
                        eset = true;
                    }

                    for(Edge e: adj_list[p.vertex]){
                        if(!visited[e.nbr]){
                            queue.add(new Pair(e.nbr, p.path+e.nbr));
                        }
                    }
                }
            }
        }

        System.out.println(true);
        
        br.close();
    }
}
