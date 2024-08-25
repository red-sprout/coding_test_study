package year2024.month08.fifth;

import java.io.*;
import java.util.*;

public class Main_17471 {
	static int N, answer;
	static int[] people;
	static int[][] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N  = Integer.parseInt(br.readLine());
		
		people = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new int[N + 1][];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			graph[i] = new int[size];
			for(int j = 0; j < size; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = Integer.MAX_VALUE;
		selection(1, 0, 0, 0);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		br.close();
	}
	
	public static void selection(int cnt, int visited, int left, int right) {
		if(cnt == N + 1) {
			if(left * right == 0) return;
			if(check(visited)) answer = Math.min(answer, Math.abs(right - left));
			return;
		}
		selection(cnt + 1, visited | 1 << cnt, left + people[cnt], right);
		selection(cnt + 1, visited, left, right + people[cnt]);
	}
	
	public static boolean check(int visited) {
		int start;
		for(start = 1; start <= N; start++) if((visited & (1 << start)) != 0) break;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		int v = 1 << start;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i : graph[now]) {
				if((v & (1 << i)) != 0) continue;
				if((visited & (1 << i)) == 0) continue;
				v |= 1 << i;
				q.offer(i);
			}
		}
		
		for(start = 1; start <= N; start++) if((visited & (1 << start)) == 0) break;
		q.offer(start);
		v |= 1 << start;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i : graph[now]) {
				if((v & (1 << i)) != 0) continue;
				if((visited & (1 << i)) != 0) continue;
				v |= 1 << i;
				q.offer(i);
			}
		}
		
		return Integer.bitCount(v) == N;
	}
}
