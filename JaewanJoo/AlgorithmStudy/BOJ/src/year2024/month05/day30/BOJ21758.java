package year2024.month05.day30;
// 꿀 따기
import java.io.*;
import java.util.*;

public class BOJ21758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] place = new int[n];
		
		for(int i = 0; i < n; i++) {
			place[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}
