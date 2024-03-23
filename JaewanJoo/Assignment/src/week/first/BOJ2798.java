package week.first;

import java.io.*;
import java.util.*;

public class BOJ2798 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] card = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int tmp = 0;
		for(int i = 0; i < n - 2; i++) {
			for(int j = i + 1; j < n - 1; j++) {
				for(int k = j + 1; k < n; k++) {
					tmp = card[i] + card[j] + card[k];
					if(tmp > m) continue;
					if(m - tmp < m - sum) sum = tmp;
				}
			}
		}
		
		System.out.println(sum);
		
		br.close();
	}
}