package year2024.month07.fourth;

import java.io.*;
import java.util.*;

public class BOJ1043 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] truth = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine(), " ");
		int cnt = Integer.parseInt(st.nextToken());
		for(int i = 0; i < cnt; i++) {
			truth[Integer.parseInt(br.readLine())] = true;
		}
		
		int answer = 0;
		for(int p = 0; p < M; p++) {
			st = new StringTokenizer(br.readLine(), " ");
			cnt = Integer.parseInt(st.nextToken());
			int[] arr = new int[cnt];
			for(int i = 0; i < cnt; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
	
//	public boolean getParent(int idx, boolean[] truth) {
//		
//	}
}
