package year2024.month04.day15;

import java.io.*;
import java.util.*;

public class BOJ2718 {
	private static List<Integer> total = new ArrayList<>();
	private static List<Integer> part = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			init();
			int n = Integer.parseInt(br.readLine());
			for(int j = 3; j <= n; j++) {
				part.add(j % 2 == 0 ? 3 : 2);
				int tmp = part.get(j);
				for(int k = 1; k < j; k++) {
					tmp += total.get(k) * part.get(j - k);
				}
				total.add(tmp);
			}
			sb.append(total.get(n)).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static void init() {
		total.clear();
		part.clear();
		
		total.add(0);
		total.add(1);
		total.add(5);
		
		part.add(0);
		part.add(1);
		part.add(4);
	}
}
