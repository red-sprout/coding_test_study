package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * ****** Z ******
 * 
 * <문제>
 * 한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 
 * 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
 * N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.
 * N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
 * 
 * <입력>
 * 첫째 줄에 정수 N, r, c가 주어진다.
 * 
 * <출력>
 * r행 c열을 몇 번째로 방문했는지 출력한다.
 * 
 * 분할 정복 / 재귀
 */

public class BOJ1074 {

	private static int N,r,c,result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//첫째 줄(N,r,c)
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());//행
		int c = Integer.parseInt(st.nextToken());//열
		
		zArray(0,0,(int)Math.pow(2, N));
	}
	
	private static void zArray(int nr, int nc, int size) {
		if(size == 1) {
			System.out.println(result);
			return;
		}
		
		int newSize =  size/2;
		
		if(r < nr + newSize && c < nc + newSize) {
			
		}
		
		
	}
	
}
