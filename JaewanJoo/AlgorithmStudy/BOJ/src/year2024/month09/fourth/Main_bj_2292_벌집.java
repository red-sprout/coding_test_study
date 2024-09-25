package year2024.month09.fourth;

import java.io.*;

public class Main_bj_2292_벌집 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		while(f(answer++) < N) {}
		
		System.out.println(answer);
		br.close();
	}
	
	public static long f(int x) {
		return 3 * x * (x + 1) + 1;
	}
}
