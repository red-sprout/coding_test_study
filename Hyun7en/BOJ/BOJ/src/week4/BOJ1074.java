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
 * 분할 정복 / 재귀.
 */

public class BOJ1074 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//첫째 줄(N,r,c)
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());//행
		int c = Integer.parseInt(st.nextToken());//열
		
		int size = (int)Math.pow(2, N);
		
		br.close();
		System.out.println(zArray(r,c,size));
		
		
	}
	
	private static int zArray(int r, int c, int size) {
		int result = 0;
        int row = r;
        int col = c;

        for (int i = size / 2; i > 0; i /= 2) {
            // 각 사분면에 대해 값을 더해줌
            if (row < i && col < i) {
                // 1사분면
            } else if (row < i && col >= i) {
                // 2사분면
                result += i * i;
                col -= i;
            } else if (row >= i && col < i) {
                // 3사분면
                result += 2 * i * i;
                row -= i;
            } else {
                // 4사분면
                result += 3 * i * i;
                row -= i;
                col -= i;
            }
        }

        return result;
		
	}
	
}
