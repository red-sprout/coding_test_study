package year2024.month06.day24;
// 택배
import java.io.*;
import java.util.*;

public class BOJ8980 {
	private static int n, c, m;
	static class Delivery implements Comparable<Delivery> {
		int start;
		int end;
		int box;
		
		Delivery(int start, int end, int box) {
			this.start = start;
			this.end = end;
			this.box = box;
		}
		
		@Override
		public int compareTo(Delivery d) {
			if(this.end == d.end) {
				return this.start - d.start;
			} else {
				return this.end - d.end;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		n = Integer.parseInt(info[0]);
		c = Integer.parseInt(info[1]);
		m = Integer.parseInt(br.readLine());
		Delivery[] delivery = new Delivery[m];
		int[] weight = new int[n];
		
		for(int i = 0; i < m; i++) {
			info = br.readLine().split(" ");
			delivery[i] = new Delivery(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]));
		}
		
		for(int i = 0; i < n; i++) {
			weight[i] = c;
		}
		
		Arrays.sort(delivery);
		
		int result = 0;
		for(Delivery d : delivery) {
			int max = Integer.MAX_VALUE;
			for(int j = d.start; j < d.end; j++) {
				max = Math.min(max, weight[j]);
			}
			
			max = Math.min(max, d.box);
			for(int j = d.start; j < d.end; j++) {
				weight[j] -= max;
			}
			result += max;
		}
		
		System.out.println(result);
		br.close();
	}
}
