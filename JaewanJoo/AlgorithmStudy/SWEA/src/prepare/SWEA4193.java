package prepare;
// 수영대회 결승전 ( 완전 탐색 + 구현 )
import java.util.*;

public class SWEA4193 {
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
            int n = sc.nextInt();
            int[][] sea = new int[n][n];
            int[] start = new int[2];
            int[] end = new int[2];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++){
                	sea[i][j] = sc.nextInt();
                }
            }
            start[0] = sc.nextInt();
            start[1] = sc.nextInt();
            end[0] = sc.nextInt();
            end[1] = sc.nextInt();
            sb.append(bfs(sea, start, end, n)).append("\n");
		}
        
        System.out.println(sb.toString());
        sc.close();
	}
    
    public static int bfs(int[][] sea, int[] start, int[] end, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()) {
        	int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int t = now[2];
            if(r == end[0] && c == end[1]) return t;
            for(int i = 0; i < 4; i++) {
            	int row = r + dr[i];
                int col = c + dc[i];
                if(row < 0 || row >= n || col < 0 || col >= n) continue;
                if(visited[row][col] || sea[r][c] == 1) continue;
                if(sea[row][col] == 2 && t % 3 != 2) {
                	q.add(new int[] {r, c, t + 1});
                	continue;
                }
                q.add(new int[] {row, col, t + 1});
                visited[r][c] = true;
            }
        }
        return -1;
    }
}
