package study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10:00
public class 배열돌리기16926 {
	
	static int[][] array;
	static int n, m, r;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//세로
		 n = Integer.parseInt(st.nextToken());
		
		//가로
		 m = Integer.parseInt(st.nextToken());
		
		//회전 수
		 r = Integer.parseInt(st.nextToken());
				
		//배열 초기화
		array = new int[n][m];
		
		//2차원 배열안에 숫자 모두 넣어줌
		for(int i = 0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < r; i++) { // 회전 수 만큼 반복문
			rotate();
		}
		
		//결과
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(array[i][j] + " ");
			}
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb.toString());
		
	}
	
	//배열 돌리기
	public static void rotate() {
		
		int overlabCount = Math.min(n, m) / 2;
		
		for(int overlab = 0; overlab < overlabCount; overlab++) {
			
			int lr = n - overlab - 1;
			int lc = m - overlab - 1;
					
			int temporary =  array[overlab][overlab]; //맨 첨에 값을 덮어주는 곳이기에 마지막에 넣기위해 빼준다.
			
			//위쪽, 오른쪽, 아래쪽, 왼쪽 <- 이 순서 몰랐다가 계속 겹치는거 생겨서 계속 고침
			//위쪽(맨 왼쪽 - 맨 오른쪽)
			for(int i = overlab; i < lc; i++) {
				array[overlab][i] = array[overlab][i + 1];
			}
			
			//오른쪽(맨 위쪽 - 맨 아래쪽)
			for(int i = overlab; i < lr; i++) {
				array[i][lc] = array[i + 1][lc];
			}
			
			//아래쪽(맨 오른쪽 - 맨 왼쪽쪽)
			for(int i = lc; i > overlab; i--) {
				array[lr][i] = array[lr][i - 1];
			}
			
			//왼쪽(맨 아래쪽 - 맨 위쪽)
			for(int i = lr; i > overlab + 1; i--) {
				array[i][overlab] = array[i - 1][overlab];
			}
			
			array[overlab + 1][overlab] = temporary;		
		}
	}
}
//12:30