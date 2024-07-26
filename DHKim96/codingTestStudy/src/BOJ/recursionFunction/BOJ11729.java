package BOJ.recursionFunction;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ11729 {
	// 백준 no.11729 : 하노이 탑 이동 순서
	
	/*
	 * 지피티 선생님께서 말씀해주신 재귀함수 잘 구현하기
	 * 
	 * 1. 재귀함수의 기본 구조 이해하기
	 * 	재귀 함수는 기본적으로 두 가지 부분으로 구성
	 * 	- 기본 경우(Base Case)
	 * 		: 재귀 호출을 멈추는 조건. 문제를 더 이상 쪼갤 수 없을 때의 상황을 처리
	 * 	- 재귀 단계(Recursive Step)
	 * 		: 문제를 작은 부분으로 나누고 그 부분을 재귀적으로 해결하는 부분
	 * 2. 문제를 재귀적으로 정의하기
	 * 	 - 큰 문제를 동일한 형태의 더 작은 문제로 나누는 방법 찾기
	 * 3. 작은 문제부터 해결하기
	 * 4. 재귀 호출 시 필요한 매개변수 결정하기
	 * 	- 필요한 매개변수는 최소화
	 * 	- 매개변수가 어떻게 변화하는지 파악
	 * 5. 꼬리 재귀(Tail Recursion) 고려
	 * 	- 꼬리 재귀는 재귀 호출이 함수의 마지막 작업인 경우를 의미
	 * 6. 재귀 깊이 제한 고려
	 * 	- 재귀 함수는 스택 사용하기에 너무 깊어지면 스택 오버플로우 발생
	 * 	- 따라서 이 경우 반복문 사용하거나 꼬리 재귀 최적화할 것
	 *  => 피보나치 수열, 팩토리얼, 하노이의 탑, 이진 탐색, 퀵정렬, 병합정렬, 이진 트리 순회, 조합 생성 등  
	 */
	
	/*
	 * 위 노하우를 본 문제에 적용하자
	 * 1. 기본 경우
	 * 		: 한 개의 원판을 첫번쪠 기둥에서 3번째 기둥으로 직접 옮김
	 * 2. 재귀 단계
	 * 		: N 개의 원판을 첫 번째 기둥에서 세 번째 기둥으로 옮기는 방법
	 * 			1. N-1 개의 원판을 첫 번째 기둥에서 두 번째 기둥으로 옮김(세 번째 기둥으로 보조 기둥으로 사용)
	 * 			2. 제일 큰 원판을 첫 번쩨 기둥에서 세 번째 기둥으로 직접 옮김
	 * 			3. N-1 개의 원판을 두 번째 기둥에서 세 번째 기둥으로 옮김(첫 번째 기둥을 보조 기둥으로 사용)
	 */
	
	// 옮긴 횟수
	static int k;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		k = 0;
		
		hanoi(N, 1, 3, 2, sb);
		System.out.println(k);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	/**
     * 하노이의 탑 이동 순서를 계산하는 재귀 함수
     * @param N 옮길 원판의 개수
     * @param from 원판이 있는 출발 기둥
     * @param to 원판을 옮길 목적지 기둥
     * @param via 보조 기둥(임시로 머무르는 기둥)
     * @param sb 결과를 저장할 StringBuilder
     */
	public static void hanoi(int N, int from, int to, int via, StringBuilder sb) {
		++k;
		if(N == 1) { // 기본 경우(1번째에서 3번째로)
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		// 재귀 단계
		// N-1개 원판을 첫 번째 기둥에서 두 번째 기둥으로(세 번쪠 기둥이 보조 기둥)
		hanoi(N-1, from, via, to, sb);
		// 가장 큰 원판을 첫 번째 기둥에서 세 번째 기둥으로
		sb.append(from).append(" ").append(to).append("\n");
		// N-1개 원판을 두 번쪠 기둥에서 세 번째 기둥으로(첫 번째 기둥이 보조 기둥)
		hanoi(N-1, via, to, from, sb);
	}
	
	/*
	  hanoi(4, 1, 3, 2)
		├─ hanoi(3, 1, 2, 3)
		│  ├─ hanoi(2, 1, 3, 2)
		│  │  ├─ hanoi(1, 1, 2, 3)
		│  │  ├─ move 1 -> 3
		│  │  └─ hanoi(1, 2, 3, 1)
		│  ├─ move 1 -> 2
		│  └─ hanoi(2, 3, 2, 1)
		│     ├─ hanoi(1, 3, 1, 2)
		│     ├─ move 3 -> 2
		│     └─ hanoi(1, 1, 2, 3)
		├─ move 1 -> 3
		└─ hanoi(3, 2, 3, 1)
		   ├─ hanoi(2, 2, 1, 3)
		   │  ├─ hanoi(1, 2, 3, 1)
		   │  ├─ move 2 -> 1
		   │  └─ hanoi(1, 3, 1, 2)
		   ├─ move 2 -> 3
		   └─ hanoi(2, 1, 3, 2)
		      ├─ hanoi(1, 1, 2, 3)
		      ├─ move 1 -> 3
		      └─ hanoi(1, 2, 3, 1)

	 */
	
}
