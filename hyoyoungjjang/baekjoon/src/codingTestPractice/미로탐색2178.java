package codingTestPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색2178 {
	
	static int[][] Map; // 미로
	
	static int N, M; 
	
	static boolean[][] visited;
	
	static int[] dx = new int[] {-1, 1, 0, 0};//x축 방향 백터
	static int[] dy = new int[] {0, 0, -1, 1};//y축 방향 백터
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0;  j < M; j++) {
				Map[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited = new boolean[N][M];
		visited[0][0] = true; // 0,0부터 시작이기 때문에 true로 변경
		
		bfs(0, 0);
		
		System.out.println(Map[N - 1][M - 1]);
		//최종 도착점 값 출력
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		//bfs는 큐가 핵심, bfs는 특정 노드에서 시작하여 인접한 모든 노드를 탐색 후,
		//그 노드들과 인접한 모든 노드들을 탐색 방식으로 진행되기 때문에 큐가 필요
		
		//현제 위치에서 상화좌우를 모든 검사하며 유효한 방향 노드를 큐에 더해주며
		//미로 탈출의 최단거리가 나올때까지 반복.
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1]; //현제 큐에 담긴 노드의 좌표값
			
			for(int i = 0; i < 4; i ++) {
				//반복문을 돌면서 방향 백터를 활용해 상하좌우를 반복마다 검사.
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
				//인접한노드가 Map의 범위를 벗어난다면 유효하지 않기때문에 현제 반복 건너뛰기
				
				if(visited[nextX][nextY] || Map[nextX][nextY] == 0) continue;
				//인접한 노드가 이미 방문되었거나, 갈수없는 길(0)이라면 현제 반복 건너뛰기 
				
				
				//유효한 길이라면
				q.add(new int[] {nextX, nextY}); //큐에 추가
				Map[nextX][nextY] = Map[nowX][nowY] + 1; //새로운 위치까지의 거리 업데이트
				visited[nextX][nextY] = true; // 방문표시
			}
		}
		
	}
}
