package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * ****** 배열 돌리기 1 ******
 * 
 * <문제>
 * 크기가 N×M인 배열이 있을 때, 배열을 돌려보려고 한다. 배열은 다음과 같이 반시계 방향으로 돌려야 한다.
 *  A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ← A[1][5]
 * 	   ↓                                       ↑
 * 	A[2][1]   A[2][2] ← A[2][3] ← A[2][4]   A[2][5]
 * 	   ↓         ↓                   ↑         ↑
 * 	A[3][1]   A[3][2] → A[3][3] → A[3][4]   A[3][5]
 * 	   ↓                                       ↑
 * 	A[4][1] → A[4][2] → A[4][3] → A[4][4] → A[4][5]
 * 	예를 들어, 아래와 같은 배열을 2번 회전시키면 다음과 같이 변하게 된다.
 * 	
 * 	1 2 3 4       2 3 4 8       3 4 8 6
 * 	5 6 7 8       1 7 7 6       2 7 8 2
 * 	9 8 7 6   →   5 6 8 2   →   1 7 6 3
 * 	5 4 3 2       9 5 4 3       5 9 5 4
 * 	 <시작>         <회전1>        <회전2>
 * 	배열과 정수 R이 주어졌을 때, 배열을 R번 회전시킨 결과를 구해보자.
 * 
 * <입력>
 * 첫째 줄에 배열의 크기 N, M과 수행해야 하는 회전의 수 R이 주어진다.
 * 둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.
 * 
 * <출력>
 * 입력으로 주어진 배열을 R번 회전시킨 결과를 출력한다.
 * 
 */
public class BOJ16926 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//첫째 줄
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //배열 크기
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); //회전의 수
		
		int[][] arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<R; i++) {
        	// 가장 큰 사각형부터 안으로 한 번씩 돌리기
			for(int j=0; j< Math.min(N, M)/2; j++) {
				
				int temp = arr[j][j];  //각 사각형의 왼쪽 위 값 저장
				
				// left
				for(int k=j; k<M-j-1; k++) {
					arr[j][k] = arr[j][k+1];
				}
				// up
				for(int k=j; k<N-1-j; k++) {
					arr[k][M-j-1] = arr[k+1][M-j-1];
				}
				// right
				for(int k=M-j-1; k>j; k--) {
					arr[N-1-j][k] = arr[N-1-j][k-1];
				}
				// down
				for(int k=N-j-1; k>j; k--) {
					arr[k][j] = arr[k-1][j];
				}
				arr[j+1][j] = temp;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
		
		
	}

}
