package prepare;
// 파핑파핑 지뢰찾기
import java.io.*;
import java.util.*;

public class SWEA1868 {
    private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    private static Queue<int[]> q = new LinkedList<>();
     
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int n = Integer.parseInt(br.readLine());
            char[][] table = new char[n][n];
            boolean[][] visited = new boolean[n][n];
             
            for(int i = 0; i < n; i++) {             
                table[i] = br.readLine().toCharArray();
            }
             
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j] || table[i][j] == '*') continue;
                    if(isPropagation(n, i, j, table, visited)) {                        
                        bfs(n, i, j, table, visited);
                        cnt++;
                    }
                }
            }
             
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j] || table[i][j] == '*') continue;
                    cnt++;
                }
            }
             
            sb.append(cnt).append("\n");
        }
         
        System.out.print(sb.toString());
        br.close();
    }
     
    public static void bfs(int n, int row, int col, char[][] table, boolean[][] visited) {
        q.clear();
        q.add(new int[] {row, col});
        visited[row][col] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(isPropagation(n, now[0], now[1], table, visited)) {
                for(int i = 0; i < 8; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];
                    if(nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
     
    public static boolean isPropagation(int n, int row, int col, char[][] table, boolean[][] visited) {
        for(int i = 0; i < 8; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
            if(table[nr][nc] == '*') return false;
        }
        return true;
    }
}
