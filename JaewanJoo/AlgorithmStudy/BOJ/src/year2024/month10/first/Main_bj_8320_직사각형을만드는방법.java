package year2024.month10.first;

import java.io.*;

public class Main_bj_8320_직사각형을만드는방법 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int end = (int) Math.sqrt(n);
		int answer = 0;
		for(int i = 1; i <= end; i++) {
			for(int j = i; j <= n; j++) {
				if(i * j > n) break;
				answer++;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
