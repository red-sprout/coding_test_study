package BOJ.recursionFunction;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ15649 {
	/*
	 * 백준 no.15649 : N과 M(1)
	 * 
	 * 1부터 N까지의 자연수 중 중복 없이 M개를 고른 수열을 사전 순으로 증가하는 순서(≈오름차순)로 출력하기(단, 1 <= M <= N <= 8 )
	 * 
	 * 1. 순열의 개념
	 * 	- 서로 다른 n개의 원소 중 r개를 뽑아 나열하는 방법의 수
	 * 	- n x (n-1) x ... x (n-(r-1))
	 * 	cf) 일렬로 나열하는 경우의 수는 팩토리얼
	 * 
	 * 2. 조합의 개념
	 * 	- 서로 다른 n개 원소에서 r개를 뽑는 방법의 수.
	 * 	- 순열과는 달리 "배열에 상관없이" 추출
	 * 	- 예를 들어 A B C 중 2개 추출할 때
	 *    순열은 AB,AC,BA,BC,CA,CB
	 * 	  조합은 AB,AC,BC 임
	 * 	- nCr =  nPr/r! = n! / r! * (n-r)!
	 * 
	 * 3. 백트래킹(Backtracking)
	 * 	- 재귀를 이용해 가능한 모든 경우의 수를 탐색하는 방법
	 * 	- 특히 순열, 조합 문제 해결 시 많이 사용
	 * 	3.1.기본 개념
	 * 		3.1.1. 상태 공간 트리(State Space Tree)
	 * 				- 문제 해결 과정의 중간 상태들을 모두 노드로 구현한 트리
	 * 				- 가능한 모든 상태를 트리 구조로 나타냄	
	 * 		3.1.2. 가지 치기(Pruning)
	 * 				- 불필요한 경로(=최적해가 존재할 가능성이 없는 부분)를 미리 차단하여 탐색 시간을 줄임
	 * 				- 오답인 노드를 마주할 시 더 이상 해당 노드의 자식노드는 진행하지 않음(브루트포스와의 차이)
	 * 	
	 * 4. 방문 배열(Visited Array)
	 * 	- 현재 숫자가 선택되었는지 여부 기록
	 *  
	 */
	// 자연수와 길이값 담는 객체
	static int N, M;
	// 방문 배열 선언
	static boolean[] visited;
	// 수열 담는 배열
	static int[] result;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// 자연수 N
		N = sc.nextInt();
		// 길이 M
		M = sc.nextInt();
		// 방문 배열 생성(방문 배열 인덱스 중 첫 번째 인덱스는 사용하지 않기에 길이는 N+1)
		visited = new boolean[N+1];
		// 결과값 담는 배열 생성
		result = new int[M];
		
		sb = new StringBuilder();
		
		backTrack(0);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		sc.close();
	}
	
	/*
	 * 기본 경우 : N까지의 수 중 M개의 숫자를 모두 선택했을 경우(본 문제가 M개의 숫자를 고른 "수열"을 구하는 문제이기에)
	 * 재귀 단계 : N까지의 수 중 아직 선택되지 않은 수 선택
	 * 	1. M개의 숫자 중 하나 선택
	 * 	2. 선택된 숫자 추적 위해 방문 배열 사용해 중복 선택 방지
	 * 	3. 선택된 숫자를 배열에 저장
	 * 	4. 다시 나머지 숫자들로 다시 M-1 개의 숫자 선택
	 */
	
	public static void backTrack(int depth) {
		// 기본 경우
		if(depth == M) {
			for(int i : result) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		// 재귀 단계
		for(int i = 1; i <= N; i++) {
			// 선택되지 않은 숫자 중 하나 선택
			if(!visited[i]) {
				// 배열에 저장
				result[depth] = i;
				// 다음 재귀 단계에서 방문하지 않도록 방문 처리
				visited[i] = true;
				// 재귀 함수 호출
				backTrack(depth + 1);
				// 호출 끝난 뒤(M개를 다 골랐을 때) 방문 상태 복구
				visited[i] = false;
			}
		}
		/*
		 * 방문 배열을 비트마스킹 기법으로 구현 가능
		 * 비트마스킹 기법 : 정수의 이진수 표현을 자료구조로 사용하는 기법 cf) https://travelbeeee.tistory.com/451
		 */
	}
}
