package year2024.month06.day13;
// 달력
import java.io.*;
import java.util.*;

public class BOJ20207 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] map = new int[366];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for(int j = s; j <= e; j++) {
				map[j]++;
			}
		}
		
		int total = 0;
		int width = 0;
		int max = 0;
		for(int i = 0; i <= 365; i++) {
			if(map[i] == 0) {
				total += width * max;
				width = 0;
				max = 0;
				continue;
			}
			
			width++;
			max = Math.max(max, map[i]);
		}
		
		total += width * max;
		System.out.println(total);
		br.close();
	}
}
