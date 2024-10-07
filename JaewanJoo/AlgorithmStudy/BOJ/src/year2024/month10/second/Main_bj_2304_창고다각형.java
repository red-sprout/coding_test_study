package year2024.month10.second;

import java.io.*;
import java.util.*;

public class Main_bj_2304_창고다각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1002];
		int idx = 0;
		int max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			if(H > max) {
				idx = L;
				max = H;
			}
			arr[L] = H;
		}
		int left = 0;
		int right = 1001;
		int answer = 0;
		int lmax = 0;
		int rmax = 0;
		while(left < idx || idx < right) {
			if(left < idx) {
				lmax = Math.max(lmax, arr[left]);
				answer += lmax;
				left++;
			}
			if(idx < right) {
				rmax = Math.max(rmax, arr[right]);
				answer += rmax;
				right--;
			}
		}
		System.out.println(answer + max);
		br.close();
	}
}
