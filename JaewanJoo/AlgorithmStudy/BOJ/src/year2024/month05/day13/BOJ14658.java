package year2024.month05.day13;
// 하늘에서 별똥별이 빗발친다
import java.io.*;
import java.util.*;

public class BOJ14658 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] stars = new int[k][2];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			stars[i][0] = x;
			stars[i][1] = y;
		}
		
		int max = 0;
		for(int[] s1 : stars) {
			for(int[] s2: stars) {
				int cnt = 0;
				for(int[] s : stars) {					
					if(s[0] >= s1[0] && s[0] <= s1[0] + l && s[1] >= s2[1] && s[1] <= s2[1] + l) cnt++;
				}
				max = Math.max(max, cnt);
			}
		}
		
		System.out.println(k - max);
		br.close();
	}
}
