package year2024.month05.day23;
// 문자열 잘라내기
import java.io.*;
import java.util.*;

public class BOJ2866 {
	private static int r, c;
	private static char[][] strArr;
	private static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		strArr = new char[r][c];
		for(int i = 0; i < r; i++) {
			strArr[i] = br.readLine().toCharArray();
		}
		
		int left = 0;
		int count = 0;
		int right = r;
		while(left <= right) {
			int mid = (left + right) / 2;
			initSet(mid);
			if(set.size() == c) {
				count = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(count);
		br.close();
	}
	
	public static void initSet(int start) {
		set.clear();
		for(int j = 0; j < c; j++) {
			StringBuilder sb = new StringBuilder();
			for(int i = start; i < r; i++) {
				sb.append(strArr[i][j]).append("");
			}
			set.add(sb.toString());
		}
	}
}
