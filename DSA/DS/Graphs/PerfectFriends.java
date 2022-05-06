// problem statement: https://www.youtube.com/watch?v=_q4hA01ZcVQ&list=TLGGlJ_wV8OsqRszMDA0MjAyMg

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
// import graph.Edge;

public class PerfectFriends {

    public static class Edge {
        int src;
        int nbr;
        int wt;
    
        public Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    
        public Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //number of vertices
        int k = Integer.parseInt(br.readLine()); //number of edges

        ArrayList<Edge>[] adj_list = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj_list[i] = new ArrayList<Edge>();
        }
        for(int i=0; i<k; i++){
            String[] parts = br.readLine().split("\s");
            int src = Integer.parseInt(parts[0]);
            int nbr = Integer.parseInt(parts[1]);
            adj_list[src].add(new Edge(src, nbr));
            adj_list[nbr].add(new Edge(nbr, src));
        }

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            if(!visited[i]){
                ArrayList<Integer> comp = new ArrayList<Integer>();
                generateComponent(adj_list, i, comp, visited);
                comps.add(comp);
            }
        }

        int possible_teams = 0;
        for(int i=0; i<comps.size()-1; i++){
            for(int j=i+1; j<comps.size(); j++){
                possible_teams += comps.get(i).size() * comps.get(j).size();
            }
        }
        System.out.println(possible_teams);
    }

    public static void generateComponent(ArrayList<Edge>[] adj_list, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src] = true;
        comp.add(src);
        for(Edge e:adj_list[src]){
            if(!visited[e.nbr]){
                generateComponent(adj_list, e.nbr, comp, visited);
            }
        }
    }
}
