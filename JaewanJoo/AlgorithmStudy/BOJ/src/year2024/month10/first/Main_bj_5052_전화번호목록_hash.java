package year2024.month10.first;

import java.io.*;
import java.util.*;

public class Main_bj_5052_전화번호목록_hash {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			int n = Integer.parseInt(br.readLine());
			boolean answer = true;
			Set<String> set = new HashSet<>();
			for(int i = 0; i < n; i++) {
				set.add(br.readLine());
			}
			for(String phone : set) {
				for(int j = 0; j < phone.length(); j++) {
					if(set.contains(phone.substring(0, j))) {
						answer = false;
						break;
					}
				}
			}
			sb.append(answer ? "YES" : "NO").append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
