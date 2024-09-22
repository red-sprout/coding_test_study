package year2024.month09.third;

import java.io.*;
import java.util.*;

public class Main_bj_1302_베스트셀러 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> map = new TreeMap<>();
		for(int i = 0; i < N; i++) {
			String key = br.readLine();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int max = 0;
		String answer = null;
		for(String key : map.keySet()) {
			if(max < map.get(key)) {
				max = map.get(key);
				answer = key;
			}
		}
		
		System.out.println(answer);
		br.close();
	}
}
