package BOJ.searchAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
	/*
	 * 백준 no.1260 : DFS와 BFS
	 * 
	 * <문제>
	 * 	- 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램 작성하기
	 * <입력>
	 * 	-  첫째 줄에는
	 * 		정점의 개수 N(1 <= N <= 1,000),
	 * 		간선의 개수(1<= M <= 1,000), 
	 * 		탐색을 시작할 정점의 번호 V
	 * 	- 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호(정점 간 복수 개의 간선 존재 가능, 간선은 양방향)
	 * <출력>
	 * 	- 첫째 줄에는 DFS 수행 결과 출력
	 * 	- 다음 줄에는 BFS 수행 결과 출력
	 * 	- 단, V부터 방문된 점을 순서대로 출력할 것
	 * 
	 * 1. 깊이 우선 탐색(DFS)
	 * 	- 가장 깊은 노드까지 방문한 후에 더 이상 방문할 노드가 없으면
	 * 	  최근 방문한 노드로 돌아온 다음(백트래킹), 해당 노드에서 방문할 노드가 있는지 확인
	 * 	- 스택 자료구조 이용, 재귀함수(시스템 스택)로 구현
	 * 	  스택에 다음에 방문할 인접 노드 push(역순으로 할 것) 후 방문 처리 시 pop
	 * 	  
	 * 	- 탐색 시 최단 경로를 찾는 문제가 아니면 깊이 우선 탐색 우선적으로 고려할 것
	 * 
	 * 2. 너비 우선 탐색(BFS)
	 * 	- 시작 노드부터 인접한 노드를 모두 방문한 후 그 다음 단계의 인접 노드르 방문
	 * 	  즉, 먼저 발견한 노드를 방문
	 * 	- 큐 자료구조 이용
	 * 	  지금 방문하는 노드 push
	 * 	- 최단 경로 찾기, 네트워크 분석 문제 등에 활용
	 * 	  (시작 노드부터 직접 간선으로 연결된 모든 노드를 먼저 방문하기 때문에 최단 경로를 보장함)
	 * 
	 * 
	 * 3. 초기 작업
	 * 	3.1. 인접 리스트(또는 인접배열)로 그래프 표현하기
	 * 	3.2. 방문 배열 초기화하기
	 * 	3.3. 시작 노드를 스택(또는 큐)에 삼입하기
	 * 
	 * 4. 문제 분석
	 * 	- 노드의 갯수 1000개 이하. 따라서 시간복잡도 O(N^2) 이하의 알고리즘 사용 가능
	 * 	
	 * cf) <<Do it! 알고리즘 코딩 테스트 - 자바 편>> p.165
	 */
	// 정점 갯수
	static int N;
	// 간선 갯수
	static int M;
	// 인접 리스트
	static ArrayList<ArrayList<Integer>> listGraph; 
	// 방문 배열
	static boolean[] visited;
	// 결과 저장할 StringBuilder
	static StringBuilder sb;
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 탐색 시작 정점 번호
		int V = Integer.parseInt(st.nextToken());
		
		listGraph = new ArrayList<>();
		// 인접 리스트 초기화
		setListGraph(N);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			put(x,y);
		}
		
		// 사전순 방문 보장
		// 방문할 노드가 복수 개일 경우 번호가 작은 것을 먼저 방문하기 위해 인접 리스트 내 연결 리스트 정렬 작업 필요(안해줘서 틀림)
		for(int i = 1; i < N+1; i++ ) {
			Collections.sort(listGraph.get(i));
		}
		
		sb = new StringBuilder();
	
		// 깊이 우선 탐색 실시
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		
		// 너비 우선 탐색 실시
		// 방문 배열 초기화
		visited = new boolean[N+1];
		bfs(V);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 인접 리스트 초기화
	public static void setListGraph(int N) {
		// [0] 은 사용하지 않기 때문에 ArrayIndexOutOfBoundsException 방지 위해 N+1 크기로 초기화
		for(int i = 0; i < N+1; i++) {
			listGraph.add(new ArrayList<Integer>());
		}
	}
	
	// 그래프 추가. 무방향(양뱡향) 인접 리스트(대칭 구조)
	public static void put(int x, int y) {
		listGraph.get(x).add(y);
		listGraph.get(y).add(x);
	}
	
	public static void dfs(int currNode) {
		// 방문처리
		sb.append(currNode).append(" ");
		visited[currNode] = true;
		// 해당 노드의 인접 노드 중 방문하지 않은 노드만 탐색
		for(int nextNode : listGraph.get(currNode)) {
			if(!visited[nextNode]) {
				dfs(nextNode);
			}
		}
	}
	
	public static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
		// 큐에 시작 노드 삽입
		queue.add(V);
		// 현재 노드 방문 처리
		visited[V] = true;
		// 큐가 비어있을때까지 탐색 진행
		while(!queue.isEmpty()) {
			// 방문한 노드
			int currNode = queue.poll(); 
			sb.append(currNode).append(" ");
			// 인접 노드 중 미방문 노드를 큐에 삽입 및 방문 배열에 기록
			for(int nextNode : listGraph.get(currNode)) {
				if(!visited[nextNode]){
					queue.add(nextNode);
					visited[nextNode] = true;
				}
			}
		}
	}
}
