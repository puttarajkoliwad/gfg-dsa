// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/hamiltonian-official/ojquestion

// Hamiltonian Path: A traversal which covers all the vertices of the graph without visiting any vertex twice.
// Hamiltonial Cycle: A Hamiltonian Path having a direct edge b/w source and destination is called a Hamiltonian Cycle.

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HamiltonianPathAndCycle{
    static class Edge{
        int src; 
        int nbr;

        public Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static ArrayList<String> paths = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int verts = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] adj_list = new ArrayList[verts];
        HashMap<String, Boolean> hmap = new HashMap<String, Boolean>();
        for(int i = 0; i <verts; i++){
            adj_list[i] = new ArrayList<Edge>();
        }
        for(int i=0; i<edges; i++){
            String[] parts = br.readLine().split("\s");
            int src = Integer.parseInt(parts[0]);
            int nbr = Integer.parseInt(parts[1]);
            adj_list[src].add(new Edge(src, nbr));
            adj_list[nbr].add(new Edge(nbr, src));
            if(src == 0){
                hmap.put(src+""+nbr, true);
            }
        }

        boolean[] visited = new boolean[verts];
        int source = Integer.parseInt(br.readLine());
        buildHamiltonianPath(adj_list, source, source+"", visited);
        Collections.sort(paths);

        for(String path : paths) {
            String temp = path.charAt(0)+""+path.charAt(verts-1);
            if(hmap.get(temp) != null) {
                System.out.println(path+"*");
            }else{
                System.out.println(path+".");
            }
        }
    }

    public static void buildHamiltonianPath(ArrayList<Edge>[] adj_list, int src, String psf, boolean[] visited){
        visited[src] = true;
        if(psf.length() == adj_list.length){
            paths.add(psf);
            visited[src] = false;
            return;
        }

        for(Edge e:adj_list[src]) {
            if(!visited[e.nbr]){
                buildHamiltonianPath(adj_list, e.nbr, psf+e.nbr, visited);
            }
        }
        visited[src] = false;
    }
}