package year2024.month04.day11;

import java.io.*;
import java.util.*;

public class BOJ1826 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> station = new HashMap<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			station.put(a, b);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		int dist = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for(int i = 0; i < dist; i++) {
			if(station.get(i) != null) {
				pq.add(station.get(i));
			}
			
			if(fuel == i) {
				if(pq.isEmpty()) {
					System.out.println(-1);
					br.close();
					return;
				} else {
					fuel += pq.remove();
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		br.close();
	}
}
