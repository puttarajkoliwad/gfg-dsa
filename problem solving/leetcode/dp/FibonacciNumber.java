// problem link: https://leetcode.com/problems/fibonacci-number

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class FibonacciNumber{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = fib(n);
        System.out.println(res);
    }

    public static int fib(int n){
        if(n == 0 || n == 1) return n;
        int prev = 0;
        int curr = 1;
        int next = prev + curr;
        int i=1;
        while(i < n){
            i++;
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        return next;
    }
}