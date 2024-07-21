package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 09:30
//총 n개의 원판이있다. 이때 가장 큰 원판을 1 나머지 원판을 n-1 로 생각한다.
// 결국 모든 n개의 원판은 n - 1이 1번장대에서 2번장대로가고 큰 원판이 1 - 3번장대로
// n - 1이 2-3번 장대로 가야한다.
// 1. n-1개의 원판을 1번장대에서 2번장대로 옮긴다
// 2. 나머지 큰 원판을 1번장대에서 3번장대로 옮긴다.
// 3. n - 1개의 원판을 2 - 3번장대로 옮긴다.
public class 하노이탑이동순서11729 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append((int) (Math.pow(2, n) - 1)).append("\n");
		
		// 1 2 3 은 장대이며 start : 출발지, mid : 이동해야하는 장소, to : 목적지 
 		hanoi(n, 1, 2, 3);
 		
 		br.close();
 		System.out.println(sb);
	}
	
	/*
	 	n : 원판이 개수
	 	start : 출발지 - 1번장대
	 	mid : 목적지로 이동하기 현제 이동해야하는 장소 - 2번장대
	 	to : 목적지 - 3번장대
	 */
	
	public static void hanoi(int n, int start, int mid, int to) {
		
		//이동할 원반의 개수가 1개라면 출력
		if(n == 1) { // 출발해서 도착한곳의 장대 번호를 출력
			sb.append(start + " " + to + "\n");
			return;
		}
		
		// 1. n - 1개를 start에서 mid 지점으로 옮긴다.
		hanoi(n - 1, start, to, mid);
		
		// 2. 가장 큰 원판 으로 start에서 to 지점으로 옮긴다.
		sb.append(start + " " + to + "\n");
		
		// 3. 나머지 n - 1개를 mid에서 to지점으로 옮긴다.
		hanoi(n - 1, mid, start, to);
	}
}
