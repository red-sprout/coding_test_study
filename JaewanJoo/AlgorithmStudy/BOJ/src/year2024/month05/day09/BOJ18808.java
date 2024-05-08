package year2024.month05.day09;

import java.io.*;
import java.util.*;

public class BOJ18808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<boolean[][]> list = new ArrayList<>();
		for(int a = 0; a < k; a++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			boolean[][] sticker = new boolean[r][c];
			for(int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < c; j++) {
					sticker[i][j] = st.nextToken().charAt(0) == '1';
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			
		}
		
		br.close();
	}
	
	public static boolean[][] rot(boolean[][] now) {
		boolean[][] next = new boolean[now[0].length][now.length];
		for(int i = 0; i < now.length; i++) {
			for(int j = 0; j < now[0].length; j++) {
				next[j][now.length - 1 - i] = now[i][j];
			}
		}
		return next;
	}
}
