package year2024.month10.first;

import java.io.*;
import java.util.*;

public class Main_bj_3985_롤케이크 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[L + 1];
		int expectedNum = 0, expectedLength = 0, realNum = 0, realLength = 0;
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(expectedLength < e - s + 1) {
				expectedNum = i;
				expectedLength = e - s + 1;
			}
			int cnt = 0;
			for(int j = s; j <= e; j++) {
				if(arr[j] > 0) continue;
				arr[j] = i;
				cnt++;
			}
			if(realLength < cnt) {
				realNum = i;
				realLength = cnt;
			}
		}
		System.out.println(expectedNum);
		System.out.println(realNum);
		br.close();
	}
}
