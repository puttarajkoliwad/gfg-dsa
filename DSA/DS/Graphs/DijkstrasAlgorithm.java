// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/shortest-path-in-weights-official/ojquestion

// Dijkstra's algorithm is used to find the shortest path from a source vertex to destination vertex in graphs.
// The time complexity of this algorithm using `min-heap ORmin-priority-queue` is O(V + ElogV) where V = vertices, E = edges. Using normal queue its O(V^2)

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    static class Edge{
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt){
            this.wt = wt;
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        String path;
        int cost;

        public Pair(int vertex, String path, int cost){
            this.vertex = vertex;
            this.path = path;
            this.cost = cost;
        }

        public int compareTo(Pair p){
            return this.cost - p.cost;
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
            int cost = Integer.parseInt(parts[2]);	
            adj_list[src].add(new Edge(src, nbr, cost));
            adj_list[nbr].add(new Edge(nbr, src, cost));
        }
        int source = Integer.parseInt(br.readLine());
        dijkstrasAlgorithm(adj_list, source);
        
        br.close();
    }

    public static void dijkstrasAlgorithm(ArrayList<Edge>[] adj_list, int source){
        int verts = adj_list.length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(source, source+"", 0));
        boolean[] visited = new boolean[verts];
        
        while(!pq.isEmpty()){
            // Remove Mark* Work Add*
            // Remove
            Pair p = pq.poll();

            // Mark *
            if(!visited[p.vertex]){
                visited[p.vertex] = true;
            }else{
                continue;
            }

            // Work
            System.out.println(p.vertex+" via "+p.path+" @ "+p.cost);

            // Add*
            for(Edge e:adj_list[p.vertex]){
                if(!visited[e.nbr]){
                    pq.add(new Pair(e.nbr, p.path+e.nbr, p.cost+e.wt));
                }
            }
        }
    }
    
}
