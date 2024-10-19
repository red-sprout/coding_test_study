package year2024.month10.third;

import java.io.*;

public class Main_bj_8741_이진수합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			sb.append('1');
		}
		for(int i = 0; i < k - 1; i++) {
			sb.append('0');
		}
		System.out.println(sb.toString());
		br.close();
	}
}
