package com.practice.a1767;

import java.io.*;
import java.util.*;

public class Solution {
	static int cores, wires, N;
	static List<int[]> list;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N]; // 그냥 int[][] 배열도 상관없을 듯
			list = new ArrayList<>();
			
			//이미 연결된 것들은 그냥 무시해주자. - 아 이거 실제로 이렇게 적진 않고 제 사고 회로입니당ㅎ
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 0 || i == 0 || i == N - 1 || j == 0 || j == N - 1) continue;
					// 연결할 코어들은 리스트에 넣어주기 - 위쪽 조건문은 연결할 것들이 아닌 경우 무시하는로직
					list.add(new int[] {i, j});
				}
			}
			
			cores = 0;
			wires = Integer.MAX_VALUE;
			solution(0, 0, 0);
			sb.append(wires).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	// 주의! 코어가 많은 순이 우선 (2개 연결 길이 100이 1개 연결 길이 1보다 나음)
	public static void solution(int cnt, int wire, int core) {
		if(cnt == list.size()) {
			// 모든 코어 다 확인했을 경우 로직 작성 - 우선순위는 무조건 코어 다음 길이
			if(core > cores) {
				cores = core;
				wires = wire;
			} else if(core == cores) {
				wires = Math.min(wire, wires);
			}
			return;
		}
		
		int row = list.get(cnt)[0];
		int col = list.get(cnt)[1];
		
		// 선을 연결한 경우
		for(int d = 0; d < 4; d++) {
			if(check(row, col, d)) {
				int length = paint(row, col, d, 1);
				solution(cnt + 1, wire + length, core + 1);
				paint(row, col, d, 0); //방향 조심하기!
			}
		}
		
		// 선을 연결하지 않은 경우
		solution(cnt + 1, wire, core);
	}
	
	public static boolean check(int row, int col, int d) {
		for(int i = 0; i < N; i++) {
			row += dr[d];
			col += dc[d];
			if(row < 0 || row >= N || col < 0 || col >= N) break; // 범위 밖이면 더 볼 필요 없음
			if(map[row][col] == 1) return false;
		}
		return true;
	}
	
	public static int paint(int row, int col, int d, int value) {
		int length = 0;
		for(int i = 0; i < N; i++) {
			row += dr[d];
			col += dc[d];
			if(row < 0 || row >= N || col < 0 || col >= N) break; // 범위 밖이면 더 볼 필요 없음
			map[row][col] = value; // 아..........ㅋㅋㅋㅋㅋ
			length++;
		}
		return length;
	}
}
