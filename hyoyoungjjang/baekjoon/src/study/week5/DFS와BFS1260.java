package study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//21:30
public class DFS와BFS1260 {
	
	static StringBuilder sb = new StringBuilder();
	
	static int  N, M, V; 
	// N은 노드의 개수 
	// M은 간선의 개수 부모와 자식의 관계가 형성된 개수
	// V 시작 노드
	
	static boolean[] visited;
	// 방문한 노드를 처리하기 위한 visited
	
	static int[][] iArr;
	//dfs에 사용
	// 간선의 정보들을 담아줄 2차원 배열
	
	static Queue<Integer> q = new LinkedList<>();
	//bfs에 사용
	//bfs는 너비우선 탐색이기에 시작 노드의 자식 노드를 모두 거친다음 다음 노드로 이동
	//방문한 순으로 출력을 위해 Queue사용
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		V = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1]; 
		// 노드의 개수만큼 초기화
		// 노드가 1부터 시작이기때문에 1에 맞춰서 시작하려고 하나 늘려줌 
		
		iArr = new int[N+1][N+1];
		//간선의 크기도 인덱스 0을 제외
		//각각의 노드값과 일치하기 위해 크기를 +1 해준다
		
		for(int i = 0; i < M; i++) {
			// for문 0부터 시작해서 해당 노드의 자식노드중에서 수가 작은 자식부터 탐색
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			iArr[x][y] = 1;
			iArr[y][x] = 1;
			//x노드와 y노드가 부모 자식 관계라는 것을 1로 표현
		}
		
		
		
		dfs(V); // 시작노드를 인자값으로 넘겨주며 dfs 호출
		
		sb.append("\n");
		
		visited = new boolean[N + 1];
		//dfs에서 사용했기때문에 bfs호출 전 다시 초기화
		
		bfs(V); // 시작노드를 인자값으로 넘겨주며 bfs 호출
		
		
		System.out.println(sb);
		br.close();
	}
	
	
	public static void dfs(int node) { // V인 시작 노드를 매개변수로 받아줌
		
		visited[node] = true; // 방문 노드를 true로 변경
		sb.append(node + " "); // 방문 노드 빌더에 더해준다.

		for(int i = 1; i <= N; i++) {
			//현제 노드의 자식들을 i로 판별 부모자식이라면 위에 반복문을 통해 1을 넣어줬고
			//방문하지 않았던 노드라면 visited[i]는 false일 것이다.
			if(iArr[node][i] == 1 && !visited[i]) {
				dfs(i); // 자식노드 방문을 위한 재귀호출
			}
		}
	}
	
	public static void bfs(int node) { // V인 시작노드를 매개병수로 받아줌
		
		q.add(node); //현제 노드를 큐에 삽입
		visited[node] = true; // 방문한 노드는 true
		 
		while(!q.isEmpty()) {
			
			node = q.poll(); // 큐에 처음 삽입한 노드를 빼주고 
			sb.append(node + " "); // 빌더에 더해주준다.
			
			for(int i = 1; i <= N; i++) {
				//현제 노드의 자식노드들을 i로 탐색
				//자식 부모자식 관계이자 방문하지 않았다면 큐에 넣어주고 
				//방문처리
				if(iArr[node][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}	
		}
	}	
} // 23:00
