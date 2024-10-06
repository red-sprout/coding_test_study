package year2024.month10.second;

import java.io.*;
import java.util.*;

public class Main_bj_1253_좋다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[] check = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;
			while(left < right) {
				if(left == i) {
					left++;
					continue;
				}
				if(right == i) {
					right--;
					continue;
				}
				int sum = arr[left] + arr[right];
				if(sum == arr[i]) {
					check[i] = true;
					break;
				}
				if(sum > arr[i]) {
					right--;
				} else {
					left++;
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			if(check[i]) answer++;
		}
		System.out.println(answer);
		br.close();
	}
}
