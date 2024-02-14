import java.io.*;
import java.util.*;

// [BOJ] 소수의 연속합 / 골드 3 / 30분
// 알고리즘 분류 : 수학 / 정수론 / 두 포인터 / 소수 판정 / 에라토스테네스의 체
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[n + 1];
		
		for(int i = 2; i <= n; i++) {
			arr[i] = true;
		}
		
		int prime = 2;
		list.add(prime);
		while(prime <= n) {
			for(int i = prime * 2; i <= n; i += prime) {
				arr[i] = false;
			}
			for(int i = prime + 1;; i++) {
				if(i > n) {
					prime = i;
					break;
				} else if(arr[i]) {
					prime = i;
					list.add(prime);
					break;
				}
			}
		}
		
		// left 이상 right 미만
		int left = 0;
		int right = 1;
		int length = list.size();
		int sum = 2;
		int cnt = 0;
		
		while(left < right) {
			if(sum == n) {
				cnt += 1;
				if(right < length) {
					sum += list.get(right++);
				} else {
					sum -= list.get(left++);
				}
			} else if(sum > n){
				sum -= list.get(left++);
			} else {
				if(right >= length) break;
				sum += list.get(right++);
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
}
