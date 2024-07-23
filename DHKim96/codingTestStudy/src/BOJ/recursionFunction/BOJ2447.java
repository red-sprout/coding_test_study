package BOJ.recursionFunction;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ2447 {
	/*
	 * 백준 NO.2447 : 별 찍기-10
	 * N = 3^k(1<= k < 8)
	 * 크기 N 의 패턴은 N x N 정사각형 모양
	 * N > 3 일때, 크기 N의 패턴 = 공백으로 채워진 가운데의 (N/3)x(N/3) 정사각형 크기 N/3 패턴으로 둘러싼 형태
	 * N번째 줄까지의 별 출력하기
	 * 
	 * 핵심 아이디어: 분할과 정복
	 * 크게 보면 5번째 칸은 공백
	 * 나머지는 모두 패턴 존재
	 * 
	 * 크기 N의 패턴은 크기 N/3 패턴으로 쪼개고 해당 패턴은 3x3 격자로 배치하는 것
	 * 
	 */
	
	// 별을 담을 2차원 배열 생성
		static char[][] stars;
		
		public static void main(String[] args) throws IOException {
			
			Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			
			stars = new char[N][N];
			
			// 배열에 일단 전부 공백으로 채워주기(안해줘서 틀림)
			fillBlank(N);
			
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			fillStars(N,0,0);
			
			bw.write(buildStars(N));
			bw.flush();
			bw.close();
			sc.close();
		}
		
		public static void fillBlank(int N) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					stars[i][j] = ' ';
				}
			}
		}
		
		// 패턴의 크기와 시작 좌표를 받아 2차원 배열에 별 찍는 메소드
		public static void fillStars(int N, int x, int y) {
			//  N == 1 일 경우 가장 작은 패턴인 별 하나 찍기
			if(N == 1) {
				stars[x][y] = '*';
				return;
			}
			// N > 3일 경우 N/3 패턴을 3x3 격자 형태로 배치
			/*
			 * N = 9 일때 시작 좌표는
			 * (0,0) (0,3) (0,6)
			 * (3,0) (3,3) (3,6)
			 * (6,0) (6,3) (6,6)
			 *
			 */
			int newSize = N / 3;
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					// 중앙 격자는 공백 처리
					if(i == 1 && j == 1) {
						continue;
					}
					/*
					 * 시작 좌표 구하기
					 * N = 27 일때 
					 * newSize = 9,
					 * 시작 좌표는
					 * (0,0) (0,9) (0,18)
					 * (9,0) (9,9) (9,18)
					 * (18,0) (18,9) (18,18)
					 * 
					 * 이를 작은 패턴으로 재귀적 분할할 경우
					 * 예컨대 N = 9, 시작 좌표가 (9,9) 일 때
					 * newSize = 3, 
					 * 시작 좌표는
					 * (9,9)(9,12)(9,15)
					 * (12,9)(12,12)(12,15)
					 * (15,9)(15,12)(15,15)
					 * 
					 * 즉 시작 좌표는 x + i * newSize, y + j * newSize
					 */
					fillStars(newSize, x + i * newSize, y + j * newSize);
				}
			}
		}
		
		// 결과 채우기
		public static String buildStars(int N) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(stars[i][j]);
				}
				sb.append("\n");
			}
			return sb.toString();
		}
		
		
}
