package year2024.month04.day04;

import java.io.*;
import java.util.*;

public class BOJ1781 {
	static class Problem implements Comparable<Problem>{
		int deadLine;
		int ramen;

		public Problem(int deadLine, int ramen) {
			this.deadLine = deadLine;
			this.ramen = ramen;
		}

		@Override
		public int compareTo(Problem p) {
			if(this.ramen == p.ramen) {
				return this.deadLine - p.deadLine;
			} else {
				return p.ramen - this.ramen;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Problem[] problem = new Problem[n];
		PriorityQueue<Problem> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int deadLine = Integer.parseInt(st.nextToken());
			int ramen = Integer.parseInt(st.nextToken());
			problem[i] = new Problem(deadLine, ramen);
		}
		
		Arrays.sort(problem, (o1, o2)->(o1.deadLine - o2.deadLine));
		
		for(int i = n; i >= 1; i--) {
			
		}
		
		br.close();
	}
}
