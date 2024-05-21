package year2024.month05.day23;
// 스카이라인
import java.io.*;
import java.util.*;

public class BOJ1933 {
	private static class Building implements Comparable<Building> {
		int left;
		int height;
		int right;
		
		Building(int left, int height, int right) {
			this.left = left;
			this.height = height;
			this.right = right;
		}
		
		@Override
		public int compareTo(Building b) {
			if(this.left == b.left) {
				if(this.height == b.height) {
					return this.right - b.right;
				} else {
					return b.height - this.height;
				}
			} else {
				return this.left - b.left;
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
			pq.add(new Building(l, h, r));
		}
		
		br.close();
	}
}
