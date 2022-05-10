// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/iterative-dft-official/ojquestion

// Iterative DFS is nothing but DFS using iteration istead of recursion. When the graph is linear and has lots of vertices, there are chances that we might run into StackOverflowException. In order to prevent this we use Stack class object in heap memory. This way we will still be able to achive DFS but without getting into StackOverflowException.

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS {
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
        int source = Integer.parseInt(br.readLine());
        iterativeDFS(adj_list, source);
        br.close();
    }

    public static void iterativeDFS(ArrayList<Edge>[] adj_list, int source){
        int verts = adj_list.length;
        Stack<Pair> s = new Stack<Pair>();
        s.push(new Pair(source, source+""));
        boolean[] visited = new boolean[verts];

        while(!s.isEmpty()){
            // Remove Mark* Work Add*
            Pair p = s.pop();

            if(visited[p.vertex]) continue;
            else{
                visited[p.vertex] = true;
            }

            System.out.println(p.vertex +"@"+p.path);

            for(Edge e:adj_list[p.vertex]){
                if(!visited[e.nbr]){
                    s.push(new Pair(e.nbr, p.path+e.nbr));
                }
            }
        }
    }
    
}
