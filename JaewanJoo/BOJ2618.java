import java.io.*;
import java.util.*;

// [BOJ] 경찰차 / 플레티넘 4 / 
// 알고리즘 분류 : 
public class Main {
	private static StringBuilder sb;
	private static int[][] work;
	private static int[][] dp;
	private static int cost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int w = Integer.parseInt(br.readLine());
		
		work = new int[w + 1][2];
		dp = new int[w + 1][w + 1];
		int distance = 0;
		
		for(int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			work[i][0] = Integer.parseInt(st.nextToken());
			work[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		br.close();
	}
}
