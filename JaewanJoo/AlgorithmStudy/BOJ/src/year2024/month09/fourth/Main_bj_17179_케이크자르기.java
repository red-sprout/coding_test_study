package year2024.month09.fourth;

import java.io.*;
import java.util.*;

public class Main_bj_17179_케이크자르기 {
	static int N, M, L, S[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		S = new int[M + 2];
		S[0] = 0;
		for(int i = 1; i <= M; i++) {
			S[i] = Integer.parseInt(br.readLine());
		}
		S[M + 1] = L;
		for(int i = 0; i < N; i++) {
			int Q = Integer.parseInt(br.readLine());
			sb.append(solution(Q)).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	private static int solution(int Q) {
		int left = 0;
		int right = L;
		while(left + 1 < right) {
			int mid = (left + right) / 2;
			if(count(Q, mid)) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return left;
	}
	
	private static boolean count(int Q, int mid) {
		int result = 0;
		int dist = 0;
		for(int i = 1; i <= M + 1; i++) {
			dist += S[i] - S[i - 1];
			if(dist >= mid) {
				result++;
				dist = 0;
			}
			if(result > Q) return true;
		}
		return result > Q;
	}
}
