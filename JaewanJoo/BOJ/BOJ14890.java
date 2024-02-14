import java.io.*;
import java.util.*;

// [BOJ] 경사로 / 골드 3 / 2시간
// 알고리즘 분류 : 구현
public class Main {
	private static int n, l;
	private static int cnt;
	private static int[][] map;
	
	private static int before;
	private static int tmpLength;
	private static boolean isAscending;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		cnt = 2 * n;
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean result = false;
		int now;
		
		for(int row = 0; row < n; row++) {
			isAscending = true;
			tmpLength = 1;
			before = map[row][0];
			for(int col = 1; col < n; col++) {
				now = map[row][col];
				result = checkPath(now);
				if(!result) break;
			}
			
			if(result && !isAscending && tmpLength < l) {
				cnt--;
			}
		}
		
		for(int col = 0; col < n; col++) {
			isAscending = true;
			tmpLength = 1;
			before = map[0][col];
			for(int row = 1; row < n; row++) {
				now = map[row][col];
				result = checkPath(now);
				if(!result) break;
			}
			
			if(result && !isAscending && tmpLength < l) {
				cnt--;
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
	
	public static boolean checkPath(int now) {
		if(Math.abs(before - now) > 1) {
			cnt--;
			return false;
		} else if(before > now) {
			if(!isAscending && tmpLength < l) {
				cnt--;
				return false;
			}
			before = now;
			tmpLength = 1;
			isAscending = false;
		} else if(before < now) {
			if(isAscending) {
				if(tmpLength < l) {
					cnt--;
					return false;
				}
			} else if(tmpLength < 2 * l) {
				cnt--;
				return false;
			}
			before = now;
			tmpLength = 1;
			isAscending = true;
		} else {
			tmpLength++;
		}
		return true;
	}
}
