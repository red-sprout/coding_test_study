package year2024.month05.day02;
// 레이저 통신
import java.io.*;
import java.util.*;

public class BOJ6087 {
	private static int w, h;
	private static int[][] cnt;
	private static char[][] map;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new char[h][w];
		cnt = new int[h][w];
		
		for(int i = 0; i < h; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(cnt[i], -1);
		}
		
		List<int[]> list = new ArrayList<>();
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map[i][j] == 'C') {
					list.add(new int[] {i, j});
					cnt[i][j] = 0;
				}
			}
		}
		
		bfs(list.get(0));
		
		br.close();
	}
	
	public static void bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				
			}
		}
	}
}
