package year2024.month09.third;

import java.io.*;
import java.util.*;

public class Main_bj_1039_교환 {
    static int result;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);
        result = -1;
        dfs(n, k);
        
        System.out.println(result);
        br.close();
    }
    
    public static void dfs(int n, int k) {
        if(k == 0) {
            result = Math.max(n, result);
            return;
        }
        
        String str = String.valueOf(n);
        int l = str.length();
        for(int i = 0; i < l - 1; i++) {
            for(int j = i + 1; j < l; j++) {
                int num = swap(str, i, j, l);
                if(num < minValue(l)) continue;
                dfs(num, k - 1);
            }
        }
    }
    
    public static int swap(String str, int i, int j, int l) {
        StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < l; idx++) {
            if(idx == i) {
                sb.append(str.charAt(j));
            } else if(idx == j) {
                sb.append(str.charAt(i));
            } else {
                sb.append(str.charAt(idx));
            }
        }
        return Integer.parseInt(sb.toString());
    }
    
    public static int minValue(int l) {
        int result = 1;
        for(int i = 1; i < l; i++) {
            result *= 10;
        }
        return result;
    }
}
