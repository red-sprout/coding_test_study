import java.io.*;
import java.util.*;

public class Main {
	static class Ball {
		int row;
		int col;
		int cnt;
		
		public Ball(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Ball[]> q = new LinkedList<>();
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] board = new char[n][m];
		Ball[] balls = new Ball[2];
		
		int holeRow = -1, holeCol = -1;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int ans = -1;
		
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			for(int j = 0; j < m; j++) {
				char c = row.charAt(j);
				
				if(c == 'R') {
					balls[0] = new Ball(i, j, 0);
					board[i][j] = '.';
				} else if(c == 'B') {
					balls[1] = new Ball(i, j, 0);
					board[i][j] = '.';
				} else if(c == 'O') {
					holeRow = i;
					holeCol = j;
					board[i][j] = '.';
				} else {
					board[i][j] = c;
				}
			}
		}
		
		q.add(balls);
		
		while(!q.isEmpty()) {
			Ball[] now = q.poll();
			Ball nowRed = now[0];
			Ball nowBlue = now[1];
			boolean flag = false;
			
			if(nowRed.cnt >= 10) break;
			
			for(int i = 0; i < 4; i++) {
				boolean isRedOut = false;
				boolean isBlueOut = false;
				
				int nextRedRow = nowRed.row;
				int nextRedCol = nowRed.col;
				int nextBlueRow = nowBlue.row;
				int nextBlueCol = nowBlue.col;
				
				while(board[nextRedRow + dr[i]][nextRedCol + dc[i]] == '.') {
					if(nextRedRow + dr[i] == nextBlueRow && nextRedCol + dc[i] == nowBlue.col) break;
					
					nextRedRow += dr[i];
					nextRedCol += dc[i];
					
					if(nextRedRow == holeRow && nextRedCol == holeCol) isRedOut = true;
				}
				
				while(board[nextBlueRow + dr[i]][nextBlueCol + dc[i]] == '.') {
					if(!isRedOut && nextBlueRow + dr[i] == nextRedRow && nextBlueCol + dc[i] == nextRedCol) break;
					
					nextBlueRow += dr[i];
					nextBlueCol += dc[i];
					
					if(nextBlueRow == holeRow && nextBlueCol == holeCol) isBlueOut = true;
				}
				
				if(!isRedOut && board[nextRedRow + dr[i]][nextRedCol + dc[i]] == '.') {
					while(board[nextRedRow + dr[i]][nextRedCol + dc[i]] == '.') {
						if(nextRedRow + dr[i] == nextBlueRow && nextRedCol + dc[i] == nextBlueCol) break;
						
						nextRedRow += dr[i];
						nextRedCol += dc[i];
						
						if(nextRedRow == holeRow && nextRedCol == holeCol) isRedOut = true;
					}
				}
				
				if(!isBlueOut && board[nextBlueRow + dr[i]][nextBlueCol + dc[i]] == '.') {
					while(board[nextBlueRow + dr[i]][nextBlueCol + dc[i]] == '.') {
						if(!isRedOut && nextBlueRow + dr[i] == nextRedRow && nextBlueCol + dc[i] == nextRedCol) break;
						
						nextBlueRow += dr[i];
						nextBlueCol += dc[i];
						
						if(nextBlueRow == holeRow && nextBlueCol == holeCol) isBlueOut = true;
					}
				}
				
				Ball nextRed = new Ball(nextRedRow, nextRedCol, nowRed.cnt + 1);
				Ball nextBlue = new Ball(nextBlueRow, nextBlueCol, nowBlue.cnt + 1);
				
				if(isRedOut && !isBlueOut) {
					flag = true;
					ans = nextRed.cnt;
					break;
				} else if(isBlueOut) {
					continue;
				}
				
				q.add(new Ball[] {nextRed, nextBlue});
			}
			
			if(flag) break;
		}
		
		System.out.println(ans);
		br.close();
	}
}
