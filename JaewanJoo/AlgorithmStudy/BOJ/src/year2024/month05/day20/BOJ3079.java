package year2024.month05.day20;
// 입국심사
import java.io.*;
import java.util.*;

public class BOJ3079 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Long[] t = new Long[n];
		
		long max = 0;
		for(int i = 0; i < n; i++) {
			t[i] = Long.parseLong(br.readLine());
			max = Math.max(max, t[i]);
		}
		
		Arrays.sort(t, Collections.reverseOrder());
		
		long left = 0;
		long ans = 0;
		long right = m * max;
		while(left <= right) {
			long mid = (left + right) / 2;
			
			int cnt = m;
			boolean isOver = false;
			for(int i = 0; i < n; i++) {
				cnt -= mid / t[i];
				if(cnt <= 0) {
					isOver = true;
					break;
				}
			}
			
			if(isOver) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(ans);
		br.close();
	}
}
