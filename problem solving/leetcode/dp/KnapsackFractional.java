// Problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/fractional-knapsack-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Arrays;

public class KnapsackFractional{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] vals = new int[n];
        int[] wts = new int[n];
        String[] sVals = br.readLine().split("\s");
        String[] sWts = br.readLine().split("\s");
        for(int i = 0; i < sWts.length; i++) {
            vals[i] = Integer.parseInt(sVals[i]);
            wts[i] = Integer.parseInt(sWts[i]);
        }
        int vol = Integer.parseInt(br.readLine());
        double max_gain = fractionalKnapsack(vals, wts, vol);
        System.out.println("max_gain: "+ max_gain);
    }

    public static double fractionalKnapsack(int[] vals, int[] wts, int vol){
        int n = vals.length;
        // float[] density = new float[n];
        Treasure[] arr = new Treasure[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Treasure(vals[i], wts[i]);
        }
        
        Arrays.sort(arr);
        double gain = 0.0;
        for(int i=0; i<n && vol > 0; i++){
            // System.out.println(arr[i]);
            gain += Math.min(arr[i].volume, vol) * arr[i].density;
            vol -= arr[i].volume;
        }
        
        return gain;
    }
}

class Treasure implements Comparable<Treasure> {
    int value;
    int volume;
    double density;

    public Treasure(int value, int volume) {
        this.value = value;
        this.volume  = volume;
        this.density = ((double)value)/volume;
    }

    public int compareTo(Treasure o){
        return this.density > o.density ? -1:1;
    }

    public String toString(){
        return "val: " + this.value + "; vol: " + this.volume + "; dens: " + this.density;
    }
}