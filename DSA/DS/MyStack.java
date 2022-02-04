import java.util.*;
import java.io.*;

public class MyStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<Character>();
        String input = "";
        while((input = br.readLine()) != null && !input.isEmpty()) {
            for(int i=0; i<input.length(); i++) {
                if(input.charAt(i) == '{'){
                    s.push('{');
                }else if(input.charAt(i) == '}'){
                    if(s.isEmpty()){
                        System.out.println("error");
                        return;
                    }
                    s.pop();
                }
            }
        }

        if(s.isEmpty()){
            System.out.println("Compiled successfully...");
        }else{
            System.out.println("Error");
        }
    }
}
