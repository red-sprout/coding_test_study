package year2024.month09.second;

import java.io.*;

public class Main_bj_2810_컵홀더 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int L = 0;
		String seat = br.readLine();
		for(int i = 0; i < N; i++) {
			if(seat.charAt(i) == 'L') L++;
		}
		int res = (N + 1) - L / 2;
		System.out.println(res > N ? N : res);
		br.close();
	}
}
