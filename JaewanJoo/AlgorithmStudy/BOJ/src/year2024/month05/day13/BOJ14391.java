package year2024.month05.day13;
// 종이 조각 // 백트래킹
import java.io.*;
import java.util.*;

public class BOJ14391 {
	private static int n, m, full, max;
	private static int[][] paper;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		full = (1 << (n * m)) - 1;
		max = 0;
		
		paper = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			for(int j = 0; j < m; j++) {
				paper[i][j] = row.charAt(j) - '0';
			}
		}
		
		dfs(0, 0);
		System.out.println(max);
		br.close();
	}
	
	public static void dfs(int used, int value) {
		if(used == full) {
			max = Math.max(max, value);
			return;
		}
		
		int idx = 0;
		int tmpUsed = used;
		int tmpVal = 0;
		for(int i = 0; i < n * m; i++) {
			if(((1 << i) & used) != 0) continue;
			// row
			idx = i;
			tmpUsed = used;
			tmpVal = 0;
			while(idx < n * m) {
				if(((1 << idx) & tmpUsed) != 0) break;
				tmpVal *= 10;
				tmpUsed = (1 << idx) | tmpUsed;
				tmpVal += paper[idx / m][idx % m];
				idx += m;
			}
			dfs(tmpUsed, value + tmpVal);
			// col
			idx = i;
			tmpUsed = used;
			tmpVal = 0;
			while(i / m == idx / m) {
				if(((1 << idx) & tmpUsed) != 0) break;
				tmpVal *= 10;
				tmpUsed = (1 << idx) | tmpUsed;
				tmpVal += paper[idx / m][idx % m];
				idx += 1;
			}
			dfs(tmpUsed, value + tmpVal);
		}
	}
}
