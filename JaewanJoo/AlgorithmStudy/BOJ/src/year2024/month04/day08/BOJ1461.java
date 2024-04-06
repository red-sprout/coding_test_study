package year2024.month04.day08;

import java.io.*;
import java.util.*;

public class BOJ1461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int pos = Integer.parseInt(st.nextToken());
			if(pos > 0) plus.add(pos);
			else minus.add(-1 * pos);
		}
		
		int ans = 0;
		boolean isFirst = true;
		boolean isPlus = true;
		
		while(true) {
			int dist = 0;
			if(plus.size() < m && minus.size() < m) break;
			
			if(plus.size() < m) {
				isPlus = false;
				dist += minus.peek();
			} else if(minus.size() < m) {
				isPlus = true;
				dist += plus.peek();
			} else {
				if(plus.peek() > minus.peek()) {
					isPlus = true;
					dist += plus.peek();
				} else {
					isPlus = false;
					dist += minus.peek();
				}
			}
			
			if(isFirst) ans += dist;
			else ans += 2 * dist;
			
			for(int i = 0; i < m; i++) {
				if(isPlus) plus.remove();
				else minus.remove();
			}
			
			isFirst = false;
		}
		
		plus.add(0);
		minus.add(0);
		
		if(isFirst) {
			ans += 2 * Math.min(plus.peek(), minus.peek()) + Math.max(plus.peek(), minus.peek());
		} else {
			ans += 2 * (plus.peek() + minus.peek());
		}
		
		System.out.println(ans);
		br.close();
	}
}
