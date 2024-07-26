package BOJ.recursionFunction;

import java.util.Scanner;

public class BOJ1074 {
	public static void main(String[] args) {
		/*
		 * 백준 no.1074 : Z
		 * 2^N x 2^N 크기의 2차원 배열의 좌표(r,c; 행과 열)에 Z 모양으로 도달했을 때의 방문 순서를 구하기
		 * 
		 * 1. 핵심 아이디어: 분할과 정복 알고리즘
		 *  모든 좌표들을 방문할 필요 없음.
		 *  좌표(r,c) 가 어떤 사분면에 위치했는지 특정한 후에 해당 사분면부터 재귀적으로 방문하여 탐색 횟수를 줄일 수 있음
		 *  
		 * 2. 사분면 특정하기(2차원 함수의 사분면의 순서와는 다름)
		 * 	사분면의 한 변의 길이를 기준으로 r,c 값의 크기를 비교하여 특정 가능
		 *  사분면의 한 변의 길이를 halfSide라고 할 때:
		 *  	1). r < halfSide, c < halfSide(이하 h) : 1사분면
		 *  	2). r < h, c >= h : 2사분면
		 *  	3). r >= h, c < h : 3사분면
		 *  	4). r >= h, c >= h : 4사분면
		 *  
		 * 3. 특정한 사분면부터 탐색하기
		 * 	사분면을 특정했을 때
		 * 		1). 1사분면이라면 
		 * 			- 0부터 방문 시작
		 * 		2). 2 ~ 4사분면이라면
		 * 			- 시작 순서 = 이전 사분면까지의 방문 횟수(사분면의 전체크기 * 지나온 사분면의 갯수)
		 */

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		sc.close();
		
		int result = visitOrder(N, r, c);
		
		System.out.println(result);
	}
	
	
	public static int visitOrder(int N, int r, int c) {
		// 특정 사분면을 전부 쪼갠 경우 즉 배열이 1x1인 경우 방문 순서는 0
		if(N == 0) {
			return 0;
		}
		// 사분면의 halfSide == 2^N X 2^N 배열은 2^(N-1)
		int halfSide = (1 << (N-1)); // 비트 연산자(왼쪽 시프트) 사용. 배열의 크기를 절반으로 나눌 때 유용. cf) 1<<(n-1) == 2^(n-1)
		// 한 사분면의 크기
		int ariaSize = halfSide * halfSide;
        // 이후 halfSide 값을 기준으로 r,c 값을 비교하여 해당 좌표가 포함된 사분면 특정
        // 이때 재귀함수 호출
        // 사분면을 또 사분할 해야하기 때문에 square-1
        // 사분할한 사분면에서 r,c 값이 포함된 사분면을 특정해야하기 때문에 
        // r >= halfSide 인 경우 r - halfSide
        // c >= halfSide 인 경우 c - halfSide
		if(r < halfSide && c < halfSide) { //1사분면. 
            return  visitOrder(N - 1, r, c);
		} else if(r < halfSide && c >= halfSide) { // 2사분면
			return ariaSize + visitOrder(N - 1, r, c - halfSide);
		} else if(r >= halfSide && c < halfSide) { // 3사분면
			return 2 * ariaSize + visitOrder(N - 1, r - halfSide, c);
		} else { // 3사분면
			return 3 * ariaSize + visitOrder(N - 1, r - halfSide, c - halfSide);
		}
		
	}
}
