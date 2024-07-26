package year2024.month07.second;
// 야구
import java.io.*;
import java.util.*;

public class BOJ17281 {
	private static int n, result;
	private static int[] order;
	private static int[][] playerStat;
	private static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		result = 0;
		order = new int[9];
		playerStat = new int[n][9];
		visited = new boolean[9];
		
		StringTokenizer st = null;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				playerStat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0] = true;
		order[3] = 0;
		dfs(0);
		System.out.println(result);
		br.close();
	}
	
	public static void dfs(int cnt) {
		if(cnt == 9) {
			int score = play();
			result = Math.max(result, score);
			return;
		}
		
		if(cnt == 3) {
			dfs(cnt + 1);
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			order[cnt] = i;
			dfs(cnt + 1);
			visited[i] = false;
		}
	}

	private static int play() {
		int idx = 0;
		int score = 0;
		for(int i = 0; i < n; i++) {
			int outCnt = 0;
			boolean[] base = new boolean[4];
			while(outCnt < 3) {
				int hit = playerStat[i][order[idx]];
				switch(hit) {
				case 0:
					outCnt++;
					break;
				case 1:
					if(base[3]) {
						score++;
						base[3] = false;
					}
					if(base[2]) {
						base[3] = true;
						base[2] = false;
					}
					if(base[1]) {
						base[2] = true;
						base[1] = false;
					}
					base[1] = true;
					break;
				case 2:
					if(base[3]) {
						score++;
						base[3] = false;
					}
					if(base[2]) {
						score++;
						base[2] = false;
					}
					if(base[1]) {
						base[3] = true;
						base[1] = false;
					}
					base[2] = true;
					break;
				case 3:
					if(base[3]) {
						score++;
						base[3] = false;
					}
					if(base[2]) {
						score++;
						base[2] = false;
					}
					if(base[1]) {
						score++;
						base[1] = false;
					}
					base[3] = true;
					break;
				case 4:
					if(base[3]) {
						score++;
						base[3] = false;
					}
					if(base[2]) {
						score++;
						base[2] = false;
					}
					if(base[1]) {
						score++;
						base[1] = false;
					}
					score++;
					break;
				}
				idx = (idx + 1) % 9;
			}
		}
		
		return score;
	}
}
