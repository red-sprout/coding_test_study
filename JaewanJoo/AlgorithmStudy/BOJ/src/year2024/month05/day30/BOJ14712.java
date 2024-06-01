package year2024.month05.day30;
//넴모넴모(Easy)
import java.io.*;
import java.util.*;

public class BOJ14712 {
	private static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int total = 1 << (n * m);
		int ans = 0;
		
		for(int t = 0; t < total; t++) {
			ans += check(t);
		}
		
		System.out.println(ans);
		br.close();
	}
	
	public static int check(int map) {
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < m - 1; j++) {
				int idx = m * i + j;
				if((map & (1 << idx)) != 0
					&& (map & (1 << (idx + 1))) != 0
					&& (map & (1 << (idx + m))) != 0
					&& (map & (1 << (idx + m + 1))) != 0) {
					return 0;
				}
			}
		}
		return 1;
	}
}
