package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z1074 {
	
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int r = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(st.nextToken());
		
		int side = (int) Math.pow(2, n); // 한 변의 길이
		
		find(side, r, c);
		br.close();
		System.out.println(count);
	}
	
	// 무조건 정사각형이기때문에 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 이렇게 
	// 4개의 구역으로 나누어 찾는시간을 단축
	
	public static void find(int side, int r, int c) {
		
		if(side == 1) return; 
		
		if(r < side/2 && c < side/2){// 왼쪽 위 구역
			find(side / 2, r, c);
		} else if (r < side / 2 && c >= side / 2) { // 오른쪽 위 구역
			count += side * side / 4;		
			find(side / 2, r, c - side / 2);		
		} else if (r >= side / 2 && c < side / 2) { // 왼쪽 아래 구역
			count += (side * side / 4) * 2;		
			find(side / 2, r - side / 2, c);		
		} else if (r >= side / 2 && c >= side / 2) { // 오른쪽 아래 구역
			count += (side * side / 4) * 3;
			find(side / 2, r - side / 2, c - side / 2);
		}
		
	}
}
