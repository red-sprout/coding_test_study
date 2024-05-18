package year2024.month05.day20;
// 보석 도둑
import java.io.*;
import java.util.*;

public class BOJ1202 {
	private static class Gem implements Comparable<Gem> {
		int mass;
		int value;
		
		Gem(int mass, int value) {
			this.mass = mass;
			this.value = value;
		}

		@Override
		public int compareTo(Gem g) {
			if(this.mass == g.mass) {
				return g.value - this.value;
			} else {
				return this.mass - g.mass;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Gem[] gems = new Gem[n];
		int[] bags = new int[k];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int mass = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			gems[i] = new Gem(mass, value);
		}
		
		for(int i = 0; i < k; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(gems);
		Arrays.sort(bags);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		long result = 0;
		int p = 0;
		for(int i = 0; i < k; i++) {
			while(p < n) {
				if(bags[i] < gems[p].mass) break;
				pq.add(gems[p++].value);
			}
			
			if(!pq.isEmpty()) result += pq.poll();
		}
		
		System.out.println(result);
		br.close();
	}
}
