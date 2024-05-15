package year2024.month05.day16;
// 흩날리는 시험지 속에서 내 평점이 느껴진거야
import java.io.*;
import java.util.*;

public class BOJ17951 {
	private static int n, k, max;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max += arr[i];
		}
		
		int left = 0;
		int ans = 0;
		int right = max;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(grouping(mid) >= k) {
				ans = mid;
				left = mid + 1;
			}
			else right = mid - 1;
		}
		
		System.out.println(ans);
		br.close();
	}
	
	public static int grouping(int min) {
		int cnt = 0;
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += arr[i];
			if(sum >= min) {
				cnt++;
				sum = 0;
			}
		}
		return cnt;
	}
}
