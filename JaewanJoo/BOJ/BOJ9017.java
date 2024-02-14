import java.io.*;
import java.util.*;

// [BOJ] 크로스 컨트리 / 실버 3 / 40분
// 알고리즘 분류 : 구현
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		int[] cnt = new int[201];
		int[] scoreCnt = new int[201];
		int[] score = new int[201];
		int[] fifth = new int[201];
		
		for(int i = 0; i < test; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] rank = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			init(cnt);
			init(scoreCnt);
			init(score);
			init(fifth);
			
			for(int j = 0; j < n; j++) {
				int nowRank = Integer.parseInt(st.nextToken());
				rank[j] = nowRank;
				cnt[nowRank]++;
			}
			
			int realRank = 0;
			for(int j = 0; j < n; j++) {
				int team = rank[j];
				if(cnt[team] < 6) continue;
				
				realRank++;
				if(scoreCnt[team] > 4) continue;
				
				if(scoreCnt[team] == 4) {
					fifth[team] = realRank;
					scoreCnt[team]++;
				} else {
					score[team] += realRank;
					scoreCnt[team]++;
				}
			}
			
			int min = 0; 
			int minScore = Integer.MAX_VALUE;
			int minFifth = Integer.MAX_VALUE;
			
			for(int j = 1; j <= 200; j++) {
				if(score[j] == 0) continue;
				
				if(minScore == score[j]) {
					if(minFifth > fifth[j]) {
						min = j;
						minFifth  = fifth[j];
					}
				} else if(minScore > score[j]) {
					min = j;
					minScore = score[j];
					minFifth = fifth[j];
				}
			}
			
			// test(cnt);
			// test(scoreCnt);
			// test(score);
			// test(fifth);
			
			System.out.println(min);
		}
		
		br.close();
	}
	
	public static void init(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}
	
	// public static void test(int[] arr) {
	// 	for(int i = 0; i < arr.length; i++) {
	// 		System.out.print(arr[i] + " ");
	// 	}
	// 	System.out.println();
	// }
}
