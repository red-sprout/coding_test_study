package year2024.month05.day23;
// 스카이라인
import java.io.*;
import java.util.*;

public class BOJ1933 {
	private static class Building implements Comparable<Building>{
		int x, h;
		
		Building(int x, int h) {
			this.x = x;
			this.h = h;
		}

		@Override
		public int compareTo(Building b) {
			if(this.x == b.x) {
				return b.h - this.h;
			} else {
				return this.x - b.x;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Building> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			pq.add(new Building(l, h));
			pq.add(new Building(r, -h));
		}
		
		TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		int maxX = 0;
		int maxH = 0;
		map.put(0, 1);
		while(!pq.isEmpty()) {
			Building b = pq.poll();
			// 시작점
			if(b.h > 0) {
				map.put(b.h, map.getOrDefault(b.h, 0) + 1);
			} else {
				int val = map.get(-b.h);
				if(val == 1) {
					map.remove(-b.h);
				} else {
					map.replace(-b.h, val - 1);
				}
			}
			
			int height = map.firstKey();
			if(maxX != b.x && maxH != height) {
				sb.append(b.x).append(" ").append(height).append(" ");
				maxX = b.x;
				maxH = height;
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
