package study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//14:23
public class 숨바꼭질1697 {
	
	static final int MAX = 100001;
	
	static int[] visited = new int[MAX];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		br.close();
		
		
		
		System.out.println(bfs(N, K));
		
	}
	
	public static int bfs(int N, int K) {
		
		if(N == K) { // 맨 처음 들어왔을때부터 N과K가 같다면 0반환 이거 안해줬다가 틀렸다.
			return 0; 
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 1; //방문 처리 및 시작 시간을 1로 설정
		
		while(!q.isEmpty()) {
			int nowN = q.poll();
			
			//다음 위치로 갈 노드들
			int[] nextNs = new int[] {nowN - 1, nowN + 1, nowN * 2};
			
			for(int nextN : nextNs) {
				
				if(nextN == K) return visited[nowN];// 현제 위치의 시간이 곧 최저시간
				
				if(nextN >= 0 && nextN < MAX && visited[nextN] == 0) {
					q.add(nextN);
					visited[nextN] = visited[nowN] + 1;
				}
			}
			
		}
		
		return 0; //여기까지는 오지 않지만, 컴파일 에러 때문에 의미없는 0추가
	}
}
//15:07
