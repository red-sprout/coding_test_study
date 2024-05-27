package year2024.month05.day27;

import java.io.*;
import java.util.*;

public class BOJ16166 {
	private static int n, end; // start = 0
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		// 역 번호 - 방문여부
		Map<Integer, Boolean> visited = new HashMap<>();
		// 호선 - 역
		Map<Integer, Queue<Integer>> inputMap = new HashMap<>();
		// 역 - 연결된 역
		Map<Integer, Queue<Integer>> nextMap = new HashMap<>();
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[k];
			Queue<Integer> list = new LinkedList<>();
			
			for(int j = 0; j < k; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				list.add(arr[j]);
				visited.computeIfAbsent(arr[j], key -> false);
			}
			
			for(int j = 0; j < k - 1; j++) {
				nextMap.computeIfAbsent(arr[j], key -> new LinkedList<>()).offer(arr[j + 1]);
				nextMap.computeIfAbsent(arr[j + 1], key -> new LinkedList<>()).offer(arr[j]);
			}
			
			inputMap.put(k, list);
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		br.close();
	}
}
