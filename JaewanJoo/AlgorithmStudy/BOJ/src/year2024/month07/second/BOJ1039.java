package year2024.month07.second;

import java.io.*;
import java.util.*;

public class BOJ1039 {
    private static int result;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);
        result = -1;
        
        System.out.println(getMinSwap(n));
        br.close();
    }
    
    public static int getMinSwap(int n) {
    	char[] initial = String.valueOf(n).toCharArray();
    	List<Character> sorted = new ArrayList<>();
    	for(char c : initial) {
    		sorted.add(c);
    	}
    	Collections.sort(sorted, Collections.reverseOrder());
    	
    	int result = 0;
    	for(int i = 0; i < initial.length; i++) {
    		if(initial[i] != sorted.get(i)) {
    			result++;
    		}
    	}
    	
    	return result;
    }
}