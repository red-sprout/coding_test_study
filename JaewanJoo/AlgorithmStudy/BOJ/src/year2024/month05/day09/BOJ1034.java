package year2024.month05.day09;
// 램프
import java.io.*;
import java.util.*;

public class BOJ1034 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			String key = br.readLine();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int k = Integer.parseInt(br.readLine());
		
		int std = 0;
		if(m % 2 == k % 2) {
			std = Math.min(m, k);
		} else if(m >= k) {
			std = k;
		} else {
			std = (m - 1);
		}
		
		int max = 0;
		for(String key : map.keySet()) {
			int tmp = 0;
			for(int i = 0; i < m; i++) {
				tmp = key.charAt(i) == '0' ? tmp + 1 : tmp;
			}
			max = (tmp % 2 == std % 2 && tmp <= std) ? Math.max(map.get(key), max) : max;
		}
		
		System.out.println(max);
		br.close();
	}
}
