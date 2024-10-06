package year2024.month10.second;

import java.io.*;
import java.util.*;

public class Main_bj_1202_보석도둑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> germ = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
		PriorityQueue<Integer> bag = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			germ.offer(new int[] {m, v});
		}
		bag.offer(0);
		for(int i = 0; i < K; i++) {
			bag.offer(Integer.parseInt(br.readLine()));
		}
		int answer = 0;
		while(true) {
			Deque<int[]> stack = new ArrayDeque<>();
			int now = bag.poll();
			if(now == 0) break;
			int next = bag.peek();
			while(!germ.isEmpty()) {
				int[] cur = germ.poll();
				int m = cur[0];
				int v = cur[1];
				if(next < m && m <= now) {
					answer += v;
					break;
				}
				stack.offerLast(cur);
			}
			while(!stack.isEmpty()) {
				germ.offer(stack.pollLast());
			}
		}
		System.out.println(answer);
		br.close();
	}
}
