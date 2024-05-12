package year2024.month05.day13;

import java.io.*;
import java.util.*;

public class BOJ14391_2 {
	private static int n, m;
	private static int[][] paper;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			for(int j = 0; j < m; j++) {
				paper[i][j] = row.charAt(j) - '0';
			}
		}
		
		int max = 0;
		for(int t = 0; t < (1 << (n * m)); t++) {
			int val = 0;
			for(int i = 0; i < n; i++) {
				int tmpVal = 0;
				for(int j = 0; j < m; j++) {
					int idx = i * m + j;
					if((t & (1 << idx)) == 0) {
						tmpVal *= 10;
						tmpVal += paper[i][j];
					} else {
						val += tmpVal;
						tmpVal = 0;
					}
				}
				val += tmpVal;
			}
			
			for(int j = 0; j < m; j++) {
				int tmpVal = 0;
				for(int i = 0; i < n; i++) {
					int idx = i * m + j;
					if((t & (1 << idx)) != 0) {
						tmpVal *= 10;
						tmpVal += paper[i][j];
					} else {
						val += tmpVal;
						tmpVal = 0;
					}
				}
				val += tmpVal;
			}
			
			max = Math.max(max, val);
		}
		
		System.out.println(max);
		br.close();
	}
}
