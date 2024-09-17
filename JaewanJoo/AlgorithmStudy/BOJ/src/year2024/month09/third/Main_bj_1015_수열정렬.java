package year2024.month09.third;

import java.io.*;
import java.util.*;

public class Main_bj_1015_수열정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] arr = Arrays.copyOf(A, N);
		int[] B = new int[N];
		Arrays.sort(arr);
		Arrays.fill(B, -1);
		for(int i = 0; i < N; i++) {
			int idx = search(arr[i], A, B);
			B[idx] = i;
		}
		for(int i = 0; i < N; i++) {
			sb.append(B[i]).append(" ");
		}
		System.out.println(sb.toString());
		br.close();
	}
	public static int search(int x, int[] A, int[] B) {
		for(int i = 0; i < A.length; i++) {
			if(A[i] == x && B[i] == -1) return i; 
		}
		return -1;
	}
}
