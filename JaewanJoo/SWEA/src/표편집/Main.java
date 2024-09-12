package 표편집;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/표편집.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			int n = Integer.parseInt(br.readLine());
			int k = Integer.parseInt(br.readLine());
			String[] cmd = br.readLine().split(",");
			sb.append(new Solution().solution(n, k, cmd)).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
