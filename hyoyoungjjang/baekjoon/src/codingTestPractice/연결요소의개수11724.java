package codingTestPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//25분
public class 연결요소의개수11724 {
   
   static int N, M ;
   
   static int[][] arr;
   
   static boolean visited[];
   
   static int result = 0;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      
      M = Integer.parseInt(st.nextToken());
      
      arr = new int[N + 1][N + 1];
      
      visited = new boolean[N + 1];
      
      for(int i = 0; i < M; i++) {
         st = new StringTokenizer(br.readLine());
         
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());
         
         arr[x][y] = 1;
         arr[y][x] = 1;
      }
      
      for(int i = 1; i <= N; i++) {
         if(!visited[i]) {
            result ++;
            dfs(i);
         }
      }
      
      br.close();
      System.out.println(result);
   }
   
   public static void dfs(int node) {
      
      if(visited[node]) {
         return;
      } else {
         visited[node] = true;
         for(int i = 1; i <= N; i ++) {
            if(arr[node][i] == 1) {
               dfs(i);
            }
         }
      }
      
   }
}
