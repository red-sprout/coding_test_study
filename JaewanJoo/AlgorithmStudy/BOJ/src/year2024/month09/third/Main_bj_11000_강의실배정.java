package year2024.month09.third;

import java.io.*;
import java.util.*;

public class Main_bj_11000_강의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			map.put(s, map.getOrDefault(s, 0) + 1);
			map.put(t, map.getOrDefault(t, 0) - 1);			
		}
		
		int max = 0, cnt = 0; 
		for(int key : map.keySet()) {
			cnt += map.get(key);
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
		br.close();
	}
}
