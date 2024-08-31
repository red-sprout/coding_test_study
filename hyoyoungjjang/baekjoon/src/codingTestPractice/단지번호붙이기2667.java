package codingTestPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//1시간
public class 단지번호붙이기2667 {
   
   static int[][] Map; //지도
   
   static boolean[][] visited; //방문 단지 표시
   
   static int[] dx = {-1, 1, 0, 0};//상하좌우 방향벡터
   static int[] dy = {0, 0, -1, 1};
   
   static int N;
   
   static int house;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      N = Integer.parseInt(br.readLine());
      
      Map = new int[N][N];
      
      visited = new boolean[N][N];
      
      for(int i = 0; i < N; i++) {
         
         String str = br.readLine();
   
         for(int j = 0; j < str.length(); j++) {
            Map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            
         }
      }
      
      for(int i = 0; i < N; i++) {
         for(int j = 0;  j < N; j++) {
            if(Map[i][j] == 1 && !visited[i][j]) {
               house = 1;
               dfs(i, j);
               pq.add(house);
            }
         }
      }
      
      sb.append(pq.size()).append("\n");
   
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        br.close();
        System.out.println(sb);
   }
   
   public static void dfs(int x, int y) {
      
      visited[x][y] = true;

      for(int i = 0; i < 4; i++) {
         int nextX = x + dx[i];
         int nextY = y + dy[i];
         
         //상하좌우 이동 조건 0보다 크고 7보다 작아야하며 방문한적 없고, Map의 값이 1이여야한다.
         if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N 
               && Map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
            house++;
            dfs(nextX, nextY);
         }   
      }
   }
}

