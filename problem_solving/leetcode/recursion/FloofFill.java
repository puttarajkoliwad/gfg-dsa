// problem statement: https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/flood-fill-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FloofFill {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split("\s");
        int rows = Integer.parseInt(mn[0]);
        int cols = Integer.parseInt(mn[1]);
        int[][] flood = new int[rows][cols];
        for(int i=0; i<rows; i++){
            String[] srow = br.readLine().split("\s");
            for(int j=0; j<cols; j++){
                flood[i][j] = Integer.parseInt(srow[j]);
            }
        }
        boolean[][] visited = new boolean[rows][cols];
        floodFill(flood, 0, 0, visited, "");
    }

    public static void floodFill(int[][] maze, int crow, int ccol, boolean[][] visited, String track){
        if(crow < 0 || ccol < 0 || crow >= maze.length || ccol >= maze[0].length || visited[crow][ccol] || maze[crow][ccol] == 1){
            return;
        }

        visited[crow][ccol] = true;
        if(crow == maze.length - 1 && ccol == maze[0].length-1 && maze[crow][ccol] == 0) System.out.println(track);

        floodFill(maze, crow-1, ccol, visited, track+"t");
        floodFill(maze, crow, ccol-1, visited, track+"l");
        floodFill(maze, crow+1, ccol, visited, track+"d");
        floodFill(maze, crow, ccol+1, visited, track+"r");
        visited[crow][ccol] = false;
    }
}
