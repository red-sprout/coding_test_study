package year2024.month04.day04;

import java.io.*;
import java.util.*;

public class BOJ15961 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] sushi = new int[n]; //idx 번째 스시 종류
		int[] eat = new int[d + 1]; //idx류 스시의 스시 갯수
		
		eat[c]++;
		for(int i = 0; i < n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int maxCnt = 0;
		int cnt = 1;
		for(int i = 0; i < k; i++) {
			if(eat[sushi[i]] == 0) {
				cnt++;
			}
			eat[sushi[i]]++;
		}
		
		int idx = 0;
		for(int i = k; i < n; i++) {
			if(sushi[idx] != c) eat[sushi[idx]]--;
			if(eat[sushi[idx]] == 0) cnt--;
			if(eat[sushi[i]] == 0) cnt++;
			eat[sushi[i]]++;
			maxCnt = Math.max(maxCnt, cnt);
			idx++;
		}
		
		for(int i = 0; i < k; i++) {
			if(sushi[idx] != c) eat[sushi[idx]]--;
			if(eat[sushi[idx]] == 0) cnt--;
			if(eat[sushi[i]] == 0) cnt++;
			maxCnt = Math.max(maxCnt, cnt);
			idx++;
		}
		
		System.out.println(maxCnt);
		br.close();
	}
}
