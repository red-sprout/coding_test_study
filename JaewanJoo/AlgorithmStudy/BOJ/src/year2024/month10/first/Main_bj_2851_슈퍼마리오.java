package year2024.month10.first;

import java.io.*;

public class Main_bj_2851_슈퍼마리오 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		for(int i = 0; i < 10; i++) {
			if(Math.abs(100 - answer) < Math.abs(100 - answer - arr[i])) break;
			answer += arr[i];
		}
		System.out.println(answer);
		br.close();
	}
}
