package year2024.month06.day17;
// 골목 대장 호석 - 기능성
import java.io.*;
import java.util.*;

public class BOJ20168 {
	private static int n, m, a, b, c;
	private static int[][] dist;
	private static final int MAX = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		n = Integer.parseInt(info[0]);
		m = Integer.parseInt(info[1]);
		a = Integer.parseInt(info[2]);
		b = Integer.parseInt(info[3]);
		c = Integer.parseInt(info[4]);
		dist = new int[n + 1][n + 1];
		
		for(int i = 0; i <= n; i++) {
			Arrays.fill(dist[i], MAX);
		}
		
		for(int i = 0; i < m; i++) {
			info = br.readLine().split(" ");
			int v1 = Integer.parseInt(info[0]);
			int v2 = Integer.parseInt(info[1]);
			int w = Integer.parseInt(info[2]);
			dist[v1][v2] = w;
			dist[v2][v1] = w;
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					
				}
			}
		}
		br.close();
	}
}
