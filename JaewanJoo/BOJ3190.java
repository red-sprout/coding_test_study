import java.io.*;
import java.util.*;

// [BOJ] 뱀 / 골드 4 / 1시간
// 알고리즘 분류 : 구현 / 자료 구조 / 시뮬레이션 / 덱 / 큐
public class Main {
	static int nowIdx = 0;
	static int n, k, l;
	
	static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static Map<Integer, Character> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			board[row - 1][col - 1] = 1;
		}
		
		l = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		for(int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int seconds = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			map.put(seconds, direction);
		}
		
		int nowRow = 0, nowCol = 0;
		int time = 0;
		board[0][0] = -1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		
		while(true) {
			time++;
			nowRow = nowRow + move[nowIdx][0];
			nowCol = nowCol + move[nowIdx][1];
			if(nowRow < 0 || nowRow >= n || nowCol < 0 || nowCol >= n) break;
			
			if(board[nowRow][nowCol] == -1) break;
			if(board[nowRow][nowCol] == 0) {
				int[] cut = q.poll();
				board[cut[0]][cut[1]] = 0;
			}
			
			q.add(new int[] {nowRow, nowCol});
			board[nowRow][nowCol] = -1;
			
			if(!map.containsKey(time)) continue;
			if(map.get(time) == 'D') {
				nowIdx = (nowIdx + 1) % 4;
			} else {
				nowIdx = (nowIdx + 3) % 4;
			}
		}
		
		System.out.println(time);
		br.close();
	}
}
