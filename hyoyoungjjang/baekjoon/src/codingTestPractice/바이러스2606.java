package codingTestPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//30분
public class 바이러스2606 {
   
   //바이러스 걸린 컴퓨터 개수
   static int count = 0;
   
   //연결된 쌍들을 정보를 저장해줄 2차원배열
   static int[][] iArr;
   
   //방문 정보 확인을 위한 배열
   static boolean[] visited;
   
   static int a, b;
   
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      a = Integer.parseInt(br.readLine());
      
      //해당 컴퓨터를 인덱스로 그대로 보기위해 + 1
      visited = new boolean[a + 1];
      //연결 정보도 각 인덱스로 보기위함 + 1
      iArr = new int[a + 1][a + 1];
      
      b = Integer.parseInt(br.readLine());
      
      for(int i = 0; i < b; i++) {
         st = new StringTokenizer(br.readLine());
         
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());
         
         //연결된 컴퓨터라는 표시를 1로 표시
         iArr[x][y] = 1;
         iArr[y][x] = 1;
      }
      
      dfs(1); // 처음 바이러스 걸린 컴퓨터 1번 컴퓨터
      
      br.close();
      System.out.println(count - 1); //문제에 1번 컴퓨터를 통해 바이러스 걸린 컴퓨터의 수이기에 1번 컴퓨터 제외
      
   }
   
   public static void dfs(int com) {
      
      visited[com] = true; // 방문처리
      count++; // 바이러스 컬린 컴퓨터 갯수 추가
      
      for(int i = 1; i <= a; i++) {
         //현제 컴퓨터랑 직접 연결되어있는지 확인
         if(iArr[com][i] == 1 && !visited[i]) {
            dfs(i); // 연결되어있다면 연결된 컴퓨터로 재귀 호출
         }
      }
      
   }
}

