package year2024.month08.second;

import java.io.*;
import java.util.*;

public class BOJ17779 {
    static int N, answer;
    static int[][] A;
    static boolean[][] cal;
    static int[] m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        A = new int[N][N];
        cal = new boolean[N][N];
        m = new int[2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        selection();
        System.out.println(answer);
//        one(1, 3, 2, 1);
//        two(1, 3, 2, 1);
//        three(1, 3, 2, 1);
//        four(1, 3, 2, 1);
//        
//        for(int i = 0; i < N; i++) {
//        	for(int j = 0; j < N; j++) {
//        		System.out.print((cal[i][j] ? 1 : 0) + " ");
//        	}
//        	System.out.println();
//        }
        br.close();
    }
    
    public static void selection() {
        for(int d1 = 1; d1 < N; d1++) {
            for(int d2 = 1; d2 < N - d1; d2++) {
                answer = Math.min(answer, movement(d1, d2));
            }
        }
    }
    
    public static int movement(int d1, int d2) {
        int result = Integer.MAX_VALUE;
        for(int r = 0; r < N - d1 - d2; r++) {
            for(int c = d1; c < N - d2; c++) {
                result = Math.min(result, getResult(r, c, d1, d2));
            }
        }
        return result;
    }
    
    public static int getResult(int r, int c, int d1, int d2) {
        m[0] = 0; // 최대값
        m[1] = Integer.MAX_VALUE; // 최소값
        for(int i = 0; i < N; i++) Arrays.fill(cal[i], false);
        one(r, c, d1, d2);
        two(r, c, d1, d2);
        three(r, c, d1, d2);
        four(r, c, d1, d2);
        five(r, c, d1, d2);
        return m[0] - m[1];
    }
    
    public static void one(int r, int c, int d1, int d2) {
        int result = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j <= c; j++) {
                result += A[i][j];
                cal[i][j] = true;
            }
        }
        
        for(int i = r; i < r + d1; i++) {
            for(int j = 0; j < r + c - i; j++) {
                result += A[i][j];
                cal[i][j] = true;
            }
        }
        
        m[0] = Math.max(m[0], result);
        m[1] = Math.min(m[1], result);
    }
    
    public static void two(int r, int c, int d1, int d2) {
        int result = 0;
        for(int i = 0; i < r; i++) {
            for(int j = c + 1; j < N; j++) {
                result += A[i][j];
                cal[i][j] = true;
            }
        }
        
        for(int i = r; i <= r + d2; i++) {
            for(int j = c - r + i + 1; j < N; j++) {
                result += A[i][j];
                cal[i][j] = true;
            }
        }

        m[0] = Math.max(m[0], result);
        m[1] = Math.min(m[1], result);
    }
    
    public static void three(int r, int c, int d1, int d2) {
        int result = 0;
        for(int i = r + d1; i <= r + d1 + d2; i++) {
            for(int j = 0; j < c - d1 + i - r - d1; j++) {
                result += A[i][j];
                cal[i][j] = true;
            }
        }
        
        for(int i = r + d1 + d2 + 1; i < N; i++) {
            for(int j = 0; j < c - d1 + d2; j++) {
                result += A[i][j];
                cal[i][j] = true;
            }
        }
        
        m[0] = Math.max(m[0], result);
        m[1] = Math.min(m[1], result);
    }
    
    public static void four(int r, int c, int d1, int d2) {
        int result = 0;
        for(int i = r + d2 + 1; i <= r + d1 + d2; i++) {
            for(int j = c + r - i + d2 * 2 + 1; j < N; j++) {
                result += A[i][j];
                cal[i][j] = true;
            }
        }

        for(int i = r + d1 + d2 + 1; i < N; i++) {
            for(int j = c - d1 + d2; j < N; j++) {
                result += A[i][j];
                cal[i][j] = true;
            }
        }
        
        m[0] = Math.max(m[0], result);
        m[1] = Math.min(m[1], result);
    }
    
    public static void five(int r, int c, int d1, int d2) {
        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(cal[i][j]) continue;
                result += A[i][j];
            }
        }
        
        m[0] = Math.max(m[0], result);
        m[1] = Math.min(m[1], result);
    }
}
