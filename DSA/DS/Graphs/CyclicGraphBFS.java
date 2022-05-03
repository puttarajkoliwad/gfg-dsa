// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/is-cyclic-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class CyclicGraphBFS {
    static class Edge{
        int src;
        int nbr;

        public Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair{
        int vertex;
        String path;

        public Pair(int vertex, String path){
            this.vertex = vertex;
            this.path = path;
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
            adj_list[src].add(new Edge(src, nbr));
            adj_list[nbr].add(new Edge(nbr, src));
        }
        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        // queue.add(new Pair(0, 0+""));
        boolean[] visited = new boolean[verts];

        for(int i=0; i<verts; i++){
            boolean insideBreak = false;
            if(!visited[i]){
                queue.add(new Pair(i, i+""));
                while(!queue.isEmpty()){
                    // Delete Mark* Work Add*
                    Pair p = queue.removeFirst();

                    if(visited[p.vertex]){
                        System.out.println(true);
                        insideBreak = true;
                        break;
                    }else{
                        visited[p.vertex] = true;
                        for(Edge e:adj_list[p.vertex]){
                            if(!visited[e.nbr]){
                                queue.add(new Pair(e.nbr, p.path+e.nbr));
                            }
                        }
                    }
                }
            }

            if(insideBreak) break;
            if(i==verts-1) System.out.println(false);
        }

    }
    
}
