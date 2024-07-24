package year2024.month07.second;
// 서울의 지하철
import java.io.*;
import java.util.*;

public class BOJ16166 {
	static Map<Integer, Integer> map = new HashMap<>(); // 역 번호 -> idx로 바꾸기
	static List<List<Integer>> lines = new ArrayList<>(11); // 같은 호선, 다른 역
	static List<List<Integer>> stations = new ArrayList<>(101); // 같은 역, 다른 호선
	static boolean[][] visited = new boolean[11][101];
	
	static class Station implements Comparable<Station> {
		int cnt;
		int num;
		int line;
		
		Station(int cnt, int num, int line) {
			this.cnt = cnt;
			this.num = num;
			this.line = line;
		}
		
		@Override
		public int compareTo(Station s) {
			return this.cnt - s.cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 11; i++) lines.add(new ArrayList<>());
		for(int j = 0; j < 101; j++) stations.add(new ArrayList<>());

		int idx = 1;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int line = 1; line <= N; line++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= K; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(!map.containsKey(num)) {
					map.put(num, idx);
					lines.get(line).add(idx);
					stations.get(idx).add(line);
					idx++;
				} else {
					lines.get(line).add(map.get(num));
					stations.get(map.get(num)).add(line);
				}
			}
		}
		int end = Integer.parseInt(br.readLine());
		System.out.println(bfs(end));
		br.close();
	}
	
	public static int bfs(int end) {
		int answer = -1;
		PriorityQueue<Station> pq = new PriorityQueue<>();
		for(int line : stations.get(map.get(0))) pq.offer(new Station(0, map.get(0), line));
		while(!pq.isEmpty()) {
			Station now = pq.poll();
			if(now.num == map.get(end)) {
				answer = now.cnt;
				return answer;
			}
			
			for(int nextNum : lines.get(now.line)) {
				if(visited[now.line][nextNum]) continue;
				visited[now.line][nextNum] = true;
				pq.offer(new Station(now.cnt, nextNum, now.line));
			}
			
			for(int nextLine : stations.get(now.num)) {
				if(visited[nextLine][now.num]) continue;
				visited[nextLine][now.num] = true;
				pq.offer(new Station(now.cnt + 1, now.num, nextLine));
			}
		}
		return answer;
	}
}
