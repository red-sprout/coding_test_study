package study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//06:30
public class 파이프옮기기17070 {
	
	static int N;
	
	static int[][] Map;
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
	
		N = Integer.parseInt(br.readLine());
		
		Map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		
		dfs(0, 1, 0);
		
		System.out.println(result);
	}
	
	//way는 현제 모양
	//way 0 : 가로 -> 가로, 가로 -> 대각선
	//way 1 : 세로 -> 세로, 세로 -> 대각선
	//way 2 : 대각선 -> 가로, 대각선 -> 세로, 대각선 -> 대각선
	
	public static void dfs(int r, int c, int way) { // r,c는 좌표 
		
		if(r == N - 1 && c == N - 1) { // 한쪽끝이 N과 같다
			result++;
			return;
		}
		
		if(way == 0) { // 가로
			
			if(c + 1 < N && Map[r][c + 1] == 0) { // 가로 -> 가로 체크
				dfs(r, c + 1, 0);
			} 
			
			if(c + 1 < N && r + 1 < N && Map[r][c + 1] == 0  // 가로 -> 대각선 체크
					&& Map[r + 1][c] == 0 && Map[r + 1][c + 1] == 0) {
				dfs(r + 1, c + 1, 2);
			}
			
		} else if (way == 1) { // 세로
			
			if(r + 1 < N && Map[r + 1][c] == 0) {// 세로 -> 세로 체크
				dfs(r + 1, c, 1);
			} 
			
			if(c + 1 < N && r + 1 < N && Map[r][c + 1] == 0  // 세로 -> 대각선 체크
					&& Map[r + 1][c] == 0 && Map[r + 1][c + 1] == 0) {
				dfs(r + 1, c + 1, 2);
			}
			
		} else if (way == 2) { //대각선
			
			if(c + 1 < N && Map[r][c + 1] == 0) { // 대각선 -> 가로 체크
				dfs(r, c + 1, 0);
			} 
			
			if(r + 1 < N && Map[r + 1][c] == 0) {// 대각선 -> 세로 체크
				dfs(r + 1, c, 1);
			} 
			
			if(c + 1 < N && r + 1 < N && Map[r][c + 1] == 0  // 대각선 -> 대각선 체크
					&& Map[r + 1][c] == 0 && Map[r + 1][c + 1] == 0) {
				dfs(r + 1, c + 1, 2);
			}
		}	
	}
}
//07:30
