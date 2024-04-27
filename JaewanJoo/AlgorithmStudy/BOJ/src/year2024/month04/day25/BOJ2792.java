package year2024.month04.day25;

import java.io.*;
import java.util.*;

public class BOJ2792 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[m];
		
		for(int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int left = 1;
		int right = 1000_000_000;
		while(left <= right) {
			int cnt = 0;
			int mid = (left + right) / 2;
			
			for(int i = 0; i < m; i++) {
				cnt += arr[i] / mid;
				cnt += (arr[i] % mid) != 0 ? 1 : 0;
			}
			
			if(n < cnt) left = mid + 1;
			else right = mid - 1;
		}
		
		System.out.println(left);
		br.close();
	}
}
