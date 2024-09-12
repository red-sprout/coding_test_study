package com.practice.im;

import java.io.*;
import java.util.*;

public class Solution10761 {
	static int[] pos = {1, 1};
	static Queue<int[]> totalQ = new ArrayDeque<>();
	static Queue<Integer>[] colorQ = new Queue[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 2; i++) colorQ[i] = new ArrayDeque<>();
		
		for(int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			for(int i = 0; i < 2; i++) pos[i] = 1;
			
			for(int i = 0; i < N; i++) {
				char robot = st.nextToken().charAt(0);
				int btn = Integer.parseInt(st.nextToken());
				int idx = robot == 'B' ? 0 : 1;
				totalQ.offer(new int[] {idx, btn});
				colorQ[idx].offer(btn);
			}
			
			int answer = operation();
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static int operation() {
		int answer = 0;
		while(!totalQ.isEmpty()) {
			int[] op = totalQ.poll();
			int idx = op[0];
			int btn = op[1];
			int time = Math.abs(pos[idx] - btn) + 1;
			
			pos[idx] = btn;
			if(colorQ[1 - idx].size() > 0) {						
				if(time >= Math.abs(pos[1 - idx] - colorQ[1 - idx].peek())) {
					pos[1 - idx] = colorQ[1 - idx].peek();
				} else if(pos[1 - idx] > colorQ[1 - idx].peek()) {
					pos[1 - idx] -= time;
				} else {
					pos[1 - idx] += time;
				}
			}
			
			colorQ[idx].poll();
			answer += time;
		}
		return answer;
	}
}
