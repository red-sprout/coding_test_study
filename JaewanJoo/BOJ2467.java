import java.io.*;
import java.util.*;

// [BOJ] 용액 / 골드 5 / 4시간
// 알고리즘 분류 : 이분 탐색 / 두 포인터

// 두 포인터를 사용해서 풀이
// 이분 탐색으로 푸는 솔루션을 시도 -> 실패

public class Main {
	private static int n;
	private static int[] solution;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		solution = new int[n];
		int sum, tmp;
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = n - 1;
		int lower = 0, upper = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}
		
		while(left < right) {
			sum = solution[left] + solution[right];
			tmp = Math.abs(sum);
			if(tmp < min) {
				min = tmp;
				lower = solution[left];
				upper = solution[right];
			}
			
			if(sum > 0) right--;
			else left++;
		}
		
		System.out.println(lower + " " + upper);
		br.close();
	}
}
