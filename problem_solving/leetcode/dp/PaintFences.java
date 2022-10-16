// Problem statement & explanation: https://www.youtube.com/watch?v=ju8vrEAsa3Q&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=25

// Problem link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-fence-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class PaintFences{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int fences = Integer.parseInt(br.readLine());
        int colors = Integer.parseInt(br.readLine());
        int paintable_ways = paintFences(fences, colors);
        System.out.println(paintable_ways);
    }

    public static int paintFences(int fences, int colors){
        int lastTwoSame = colors, lastTwoDiff = colors * (colors - 1);
        int total_ways = lastTwoSame + lastTwoDiff;
        for(int i=2; i<fences; i++){
            lastTwoSame = lastTwoDiff;
            lastTwoDiff = total_ways * (colors - 1);
            total_ways = lastTwoSame + lastTwoDiff;
        }
        return total_ways;
    }
}