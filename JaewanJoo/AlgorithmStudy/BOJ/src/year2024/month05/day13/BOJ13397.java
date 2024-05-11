package year2024.month05.day13;
// 구간 나누기2
import java.io.*;
import java.util.*;

public class BOJ13397 {
	private static final int MAX = 10000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = MAX;
		
		while(left < right) {
			int mid = (left + right) / 2;
			int partMin = MAX;
			int partMax = 0;
			int partCnt = 1;
			
			for(int i = 0; i < n; i++) {
				partMin = Math.min(partMin, arr[i]);
				partMax = Math.max(partMax, arr[i]);
				
				if(partMax - partMin > mid) {
					partCnt++;
					partMin = arr[i];
					partMax = arr[i];
				}
			}
			
			if(partCnt > m) left = mid + 1;
			else right = mid;
		}
		
		System.out.println(left);
		br.close();
	}
}
