package year2024.month10.second;

import java.io.*;
import java.util.*;

public class Main_bj_1931_회의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
		int time = 0;
		int answer = 0;
		for(int[] a : arr) {
			if(time <= a[0]) {
				answer++;
				time = a[1];
			}
		}
		System.out.println(answer);
		br.close();
	}
}
