// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/friends-pairing-official/ojquestion

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FriendsPairing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int pairWays = friendsPairing(n);
        System.out.println(pairWays);
    }

    public static int friendsPairing(int n){
        int[] friends = new int[n+1];
        friends[1] = 1;
        friends[2] = 2;
        for(int i=3; i<=n; i++){
            friends[i] = friends[i-1] + (i-1)*friends[i-2];
        }
        return friends[n];
    }
}
