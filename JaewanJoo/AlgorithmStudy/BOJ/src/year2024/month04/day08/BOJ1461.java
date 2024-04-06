package year2024.month04.day08;

import java.io.*;
import java.util.*;

public class BOJ1461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> plus = new PriorityQueue<>();
		PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int pos = Integer.parseInt(st.nextToken());
			if(pos > 0) {
				plus.add(pos);
			} else {
				minus.add(pos);
			}
		}
		
		int ans = 0;
		while(true) {
			int now = 0;
			int nextPlus = 0;
			int nextMinus = 0;
			
			for(int i = 0; i < m; i++) {
				if(plus.isEmpty() && minus.isEmpty()) break;
				
				if(plus.isEmpty()) {
					if(minus.size() <= m) {
						
						break;
					}
					nextMinus = minus.remove();
					continue;
				}
				
				if(minus.isEmpty()) {
					if(plus.size() <= m) {
						break;
					}
					nextPlus = plus.remove();
					continue;
				}
			
				if(now > 0) {
					if(Math.abs(plus.peek() - now) > Math.abs(minus.peek())) {
						nextMinus = minus.remove();
						now = nextMinus;
					} else {
						nextPlus = plus.remove();
						now = nextPlus;
					}
				} else {
					if(Math.abs(minus.peek() - now) > Math.abs(plus.peek())) {
						nextPlus = plus.remove();
						now = nextPlus;
					} else {
						nextMinus = minus.remove();
						now = nextMinus;
					}
				}
			}
			
			ans += 2 * (nextPlus - nextMinus);
			if(plus.isEmpty() && minus.isEmpty()) {
				ans -= Math.max(nextMinus, nextPlus);
				break;
			}
		}
		
		System.out.println(ans);
		br.close();
	}
}
