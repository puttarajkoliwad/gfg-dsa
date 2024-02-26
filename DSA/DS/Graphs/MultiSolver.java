// problem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/mutilsovler-graph-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MultiSolver {
    static String smallest_path;
    static int small_wt = Integer.MAX_VALUE;
    static String lg_path;
    static int lg_wt = Integer.MIN_VALUE;
    static String floor_path;
    static int floor_wt = Integer.MIN_VALUE;
    static String ceil_path;
    static int ceil_wt = Integer.MAX_VALUE; 

    static class Path implements Comparable<Path> {
        String span;
        int cost;
        public Path(String span, int cost){
            this.span = span;
            this.cost = cost;
        }

        public int compareTo(Path p){
            return this.cost - p.cost;
        }
    }
    
    static PriorityQueue<Path> pq = new PriorityQueue<Path>();

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
            int nbr = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            adj_list[src].add(new Edge(src, nbr, wt));
            adj_list[nbr].add(new Edge(nbr, src, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        int base = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[verts];
        multiSolver(adj_list, src, dest, src+"", 0, k, base, visited);

        System.out.println("Smallest Path = " + smallest_path + "@" + small_wt);
        System.out.println("Largest Path = " + lg_path + "@" + lg_wt);
        System.out.println("Just Larger Path than " + base + " = " + ceil_path + "@" + ceil_wt);
        System.out.println("Just Smaller Path than " + base + " = " + floor_path + "@" + floor_wt);
        System.out.println(k + "th largest path = " + pq.peek().span + "@" + pq.peek().cost);
    }

    public static void multiSolver(ArrayList<Edge>[] adj_list, int src, int dest, String psf, int curr_wt, int k, int base, boolean[] visited){
        if(src == dest){
            Path p = new Path(psf, curr_wt);
            if(curr_wt < small_wt){
                smallest_path = psf;
                small_wt = curr_wt;
            }

            if(curr_wt > lg_wt){
                lg_path = psf;
                lg_wt = curr_wt;
            }

            if(curr_wt < base && curr_wt > floor_wt){
                floor_path = psf;
                floor_wt = curr_wt;
            }

            if(curr_wt > base && curr_wt < ceil_wt){
                ceil_path = psf;
                ceil_wt = curr_wt;
            }

            if(pq.size() >= k){
                if(pq.peek().cost < curr_wt){
                    pq.remove();
                    pq.add(p);
                }
            }else{
                pq.add(p);
            }

            return;
        }

        visited[src] = true;
        for(Edge e: adj_list[src]){
            if(!visited[e.nbr]){
                multiSolver(adj_list, e.nbr, dest, psf+e.nbr, curr_wt+e.wt, k, base, visited);
            }
        }
        visited[src] = false;
    }
    
}
