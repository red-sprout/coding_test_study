package year2024.month06.day27;
// 책 나눠주기
import java.io.*;
import java.util.*;

public class BOJ9576 {
	private static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < test; t++) {
			String[] info = br.readLine().split(" ");
			n = Integer.parseInt(info[0]);
			m = Integer.parseInt(info[1]);
			
			boolean[] visited = new boolean[n + 1];
			int[][] ranges = new int[m][2];
			
			for(int i = 0; i < m; i++) {
				info = br.readLine().split(" ");
				int a = Integer.parseInt(info[0]);
				int b = Integer.parseInt(info[1]);
				ranges[i][0] = a;
				ranges[i][1] = b;
			}
			
			Arrays.sort(ranges, (o1, o2) -> {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			});
			
			int cnt = 0;
			for(int i = 0; i < m; i++) {
				int a = ranges[i][0];
				int b = ranges[i][1];
				for(int j = a; j <= b; j++) {
					if(!visited[j]) {
						visited[j] = true;
						cnt++;
						break;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
