// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/print-all-paths-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class FindAllPaths {
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
            int dest = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            adj_list[src].add(new Edge(src, dest, wt));
            adj_list[dest].add(new Edge(dest, src, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        ArrayList<String> paths = new ArrayList<String>();
        boolean[] visited = new boolean[verts];
        findAllPaths(adj_list, src, dest, visited, src+"", paths);
        Collections.sort(paths);
        for(String path : paths){
            System.out.println(path);
        }
    }
    
    public static void findAllPaths(ArrayList<Edge>[] adj_list, int src, int dest, boolean[] visited, String psf, ArrayList<String> paths){
        if(src == dest){
            paths.add(psf);
        }
        visited[src] = true;
        for(Edge edg : adj_list[src]){
            if(!visited[edg.nbr]){
                findAllPaths(adj_list, edg.nbr, dest, visited, psf+edg.nbr, paths);
            }
        }
        visited[src] = false;
    }
}
