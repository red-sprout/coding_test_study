package year2024.month04.day25;

import java.io.*;
import java.util.*;

public class BOJ1027 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		long[] building = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			int tmp = 0;
			for(int j = 0; j < n; j++) {
				int x1 = Math.min(i, j);
				int x2 = Math.max(i, j);
				long y1 = building[x1];
				long y2 = building[x2];
				
				boolean isCnt = true;
				for(int k = x1 + 1; k < x2; k++) {
					if((long)(k - x1) * (y2 - y1) - (long)(x2 - x1) * (building[k] - y1) <= 0) {
						isCnt = false;
						break;
					}
				}
				
				if(i != j && isCnt) {
					tmp++;
				}
			}

			cnt = Math.max(cnt, tmp);
		}
		
		System.out.println(cnt);
		br.close();
	}
}
