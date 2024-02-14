import java.io.*;
import java.util.*;

// [BOJ] 다각형의 면적 / 골드 5 / 1시간
// 알고리즘 분류 : 기하학 / 다각형의 넓이
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		long[][] points = new long[n + 1][2];
		long area = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		points[n][0] = points[0][0];
		points[n][1] = points[0][1];
		
		for(int i = 0; i < n; i++) {
			area += (points[i][0] * points[i + 1][1] - points[i][1] * points[i + 1][0]);
		}
		
		System.out.printf("%.1f\n", Math.abs(area / 2.0));
		br.close();
	}
}
