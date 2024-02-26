// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/gcc-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConnectedComponents {
    public static class Edge{
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt){
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
        for(int i = 0; i < verts; i++){
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

        ArrayList<ArrayList<Integer>> comps = new ArrayList<ArrayList<Integer>>();
        boolean[] visited = new boolean[verts];
        for(int i=0; i<verts; i++){
            if(!visited[i]){
                ArrayList<Integer> comp = new ArrayList<Integer>();
                getComponents(adj_list, i, comp, visited);
                comps.add(comp);
            }
        }
        System.out.println(comps);
    }

    public static void getComponents(ArrayList<Edge>[] adj_list, int src, ArrayList<Integer> comp, boolean[] visited){
        comp.add(src);
        visited[src] = true;
        for(Edge e: adj_list[src]){
            if(!visited[e.nbr]){
                getComponents(adj_list, e.nbr, comp, visited);
            }
        }
    }
}
