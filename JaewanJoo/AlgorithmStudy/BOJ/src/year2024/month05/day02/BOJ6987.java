package year2024.month05.day02;
//월드컵
import java.io.*;
import java.util.*;

public class BOJ6987 {
	private static boolean isPossible;
	private static boolean isEnd;
	private static int[][] match;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int idx = 0;
		match = new int[15][2];
		for(int i = 0; i < 6; i++) {
			for(int j = i + 1; j < 6; j++) {
				match[idx][0] = i;
				match[idx][1] = j;
				idx++;
			}
		}
		
		for(int t = 0; t < 4; t++) {
			isPossible = true;
			isEnd = false;
			
			int[][] result = new int[3][6];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 6; i++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				
				result[0][i] = win;
				result[1][i] = draw;
				result[2][i] = lose;
				
				if(win + draw + lose != 5) {
					isPossible = false;
					break;
				}
			}
			
			if(isPossible) dfs(result, 0);
			sb.append(isPossible && isEnd ? 1 : 0).append(" ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	public static void dfs(int[][] result, int cnt) {
		if(isEnd) return;
		if(cnt == 15) {
			isEnd = true;
			return;
		}
		
		int now = match[cnt][0];
		int op = match[cnt][1];
		
		for(int i = 0; i < 3; i++) {
			if(result[i][now] == 0 || result[2 - i][op] == 0) continue;
			result[i][now]--;
			result[2 - i][op]--;
			dfs(result, cnt + 1);
			result[2 - i][op]++;
			result[i][now]++;
		}
	}
}
