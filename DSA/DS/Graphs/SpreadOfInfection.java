// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/infection-spread-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class SpreadOfInfection{
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
        int time;

        public Pair(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int verts = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] adj_list = new ArrayList[verts];
        for(int i=0; i<verts; i++) {
            adj_list[i] = new ArrayList<Edge>();
        }
        for(int i=0; i<edges; i++){
            String[] parts = br.readLine().split("\s");
            int src = Integer.parseInt(parts[0]);
            int nbr = Integer.parseInt(parts[1]);
            adj_list[src].add(new Edge(src, nbr));
            adj_list[nbr].add(new Edge(nbr, src));
        }
        int source = Integer.parseInt(br.readLine());
        int time = Integer.parseInt(br.readLine());
        
        boolean[] visited = new boolean[verts];

        int infected = countInfected(adj_list, source, time, visited);
        System.out.println(infected);
    }

    public static int countInfected(ArrayList<Edge>[] adj_list, int source, int time, boolean[] visited){
        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        int count = time;
        int infected = 0;
        queue.add(new Pair(source, 1));
        while(!queue.isEmpty()){
            // Remove Mark* Work Add*
            Pair p = queue.removeFirst();
            if(p.time > time){
                return infected;
            }
            if(!visited[p.vertex]){
                visited[p.vertex] = true;
                infected++;

                for(Edge e:adj_list[p.vertex]){
                    if(!visited[e.nbr]){
                        queue.add(new Pair(e.nbr, p.time+1));
                    }
                }
            }
        }
        return infected;
    }
}