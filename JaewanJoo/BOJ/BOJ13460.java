import java.io.*;
import java.util.*;

// [BOJ] 구슬 탈출 / 골드 1 / 2시간
// 알고리즘 분류 : 구현 / 그래프 이론 / 그래프 탐색 / 시뮬레이션 / 너비 우선 탐색
// Refactoring
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
	
	static int holeRow, holeCol;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] board;
	static boolean isNotMoved;
	static boolean[] isOut;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Ball[]> q = new LinkedList<>();
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		isOut = new boolean[2];
		Ball[] balls = new Ball[2];
		
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
				isOut[0] = false;
				isOut[1] = false;
				isNotMoved = true;
				
				int[] nextRedPos = {nowRed.row, nowRed.col};
				int[] nextBluePos = {nowBlue.row, nowBlue.col};
				
				nextRedPos = rolling(i, 0, nextRedPos, nextBluePos);
				nextBluePos = rolling(i, 1, nextBluePos, nextRedPos);
				
				if(!isOut[0] && board[nextRedPos[0] + dr[i]][nextRedPos[1] + dc[i]] == '.') {
					nextRedPos = rolling(i, 0, nextRedPos, nextBluePos);
				}
				
				if(!isOut[1] && board[nextBluePos[0] + dr[i]][nextBluePos[1] + dc[i]] == '.') {
					nextBluePos = rolling(i, 1, nextBluePos, nextRedPos);
				}
				
				if(isNotMoved) continue;
				
				Ball nextRed = new Ball(nextRedPos[0], nextRedPos[1], nowRed.cnt + 1);
				Ball nextBlue = new Ball(nextBluePos[0], nextBluePos[1], nowBlue.cnt + 1);
				
				if(isOut[1]) {
					continue;
				} else if(isOut[0]) {
					flag = true;
					ans = nextRed.cnt;
					break;
				}
				
				q.add(new Ball[] {nextRed, nextBlue});
			}
			
			if(flag) break;
		}
		
		System.out.println(ans);
		br.close();
	}
	
	public static int[] rolling(int i, int rbIdx, int[] ballPos, int[] otherBallPos) {
		int ballRow = ballPos[0], ballCol = ballPos[1];
		int otherBallRow = otherBallPos[0], otherBallCol = otherBallPos[1];
		while(board[ballRow + dr[i]][ballCol + dc[i]] == '.') {
			if(!isOut[1- rbIdx] && ballRow + dr[i] == otherBallRow && ballCol + dc[i] == otherBallCol) break;
			
			isNotMoved = false;
			
			ballRow += dr[i];
			ballCol += dc[i];
			
			if(ballRow == holeRow && ballCol == holeCol) isOut[rbIdx] = true;
		}
		return new int[] {ballRow, ballCol};
	}
}
