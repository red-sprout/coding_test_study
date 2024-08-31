package codingTestPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//30분
public class 촌수계산2644 {
   
   //부모 자식 관계
   static int[][] arr;
   
   static boolean[] visited;
   
   static int n, m, x, y, result = 0;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      n = Integer.parseInt(br.readLine());
      
      arr = new int[n+1][n+1];
      
      visited = new boolean[n+1];
      
      st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      
      m = Integer.parseInt(br.readLine());
      
      for(int i = 0; i < m; i++) {
         st = new StringTokenizer(br.readLine());
         int xx = Integer.parseInt(st.nextToken());
         int yy = Integer.parseInt(st.nextToken());
         
         arr[xx][yy] = 1;
         arr[yy][xx] = 1;
      }
      
      dfs(x, 0);
      
      if(result <= 0) {
         System.out.println("-1");
      } else {
         System.out.println(result);
      }
      
   }
   
   public static void dfs(int start, int count) {
      
      if(start == y) {
         result = count;
         return;
      }
      
      visited[start] = true;
      
      for(int i = 1; i <= n; i++ ) {
         if(arr[start][i] == 1 && !visited[i]) {
            dfs(i, count + 1);
         }
      }
   }
}
