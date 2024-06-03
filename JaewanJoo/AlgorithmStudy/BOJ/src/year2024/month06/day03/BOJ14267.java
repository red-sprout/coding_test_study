package year2024.month06.day03;
// 회사 문화 1
import java.io.*;
import java.util.*;

public class BOJ14267 {
	private static int n, m;
	private static int[] boss, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		boss = new int[n + 1];
		result = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int b = Integer.parseInt(st.nextToken());
			boss[i] = (i == 1) ? 1 : b;
		}
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			result[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}
