package year2024.month06.day17;
// 골목 대장 호석 - 기능성
import java.io.*;

public class BOJ20168 {
	private static int n, m, a, b, c;
	private static int ans;
	private static boolean[] visited;
	private static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		n = Integer.parseInt(info[0]);
		m = Integer.parseInt(info[1]);
		a = Integer.parseInt(info[2]);
		b = Integer.parseInt(info[3]);
		c = Integer.parseInt(info[4]);
		visited = new boolean[n + 1];
		dist = new int[n + 1][n + 1];
		ans = -1;
		
		for(int i = 0; i < m; i++) {
			info = br.readLine().split(" ");
			int v1 = Integer.parseInt(info[0]);
			int v2 = Integer.parseInt(info[1]);
			int w = Integer.parseInt(info[2]);
			dist[v1][v2] = dist[v2][v1] = w;
		}
		
		visited[a] = true;
		dfs(a, 0, 0);
		
		System.out.println(ans);
		br.close();
	}
	
	public static void dfs(int now, int max, int total) {
		if(total > c) return;
		
		if(now == b) {
			if(ans == -1) ans = max;
			else ans = Math.min(ans, max);
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(visited[i]) continue;
			if(dist[now][i] == 0) continue;
			visited[i] = true;
			dfs(i, Math.max(max, dist[now][i]), total + dist[now][i]);
			visited[i] = false;
		}
	}
}
