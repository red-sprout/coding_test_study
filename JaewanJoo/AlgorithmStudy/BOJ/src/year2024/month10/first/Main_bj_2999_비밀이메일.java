package year2024.month10.first;

import java.io.*;

public class Main_bj_2999_비밀이메일 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		int R = N, C = 1;
		int tmp = R;
		while(true) {
			tmp--;
			if(N % tmp != 0) continue;
			if(N / tmp > tmp) break;
			R = tmp;
			C = N / tmp;
		}
		int idx = 0;
		char[][] arr = new char[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(idx++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < C; j++) {
			for(int i = 0; i < R; i++) {
				sb.append(arr[i][j]);
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
