package year2024.month05.day27;
//버블 소트
import java.io.*;
import java.util.*;

public class BOJ1517 {
	private static int n;
	private static long ans;
	private static int[] arr, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		result = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergesort(0, n - 1);
		
		System.out.println(ans);
		br.close();
	}
	
	public static void mergesort(int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergesort(start, mid);
			mergesort(mid + 1, end);
			merge(start, mid, end);
		}
	}
	
	public static void merge(int start, int mid, int end) {
		int left = start;
		int right = mid + 1;
		int idx = start;
		
		while(left <= mid && right <= end) {
			if(arr[left] <= arr[right]) {
				result[idx++] = arr[left++];
			} else {
				result[idx++] = arr[right++];
				ans += mid - left + 1;
			}
		}
		
		if(left > mid) {
			for(int i = right; i <= end; i++) {
				result[idx++] = arr[i];
			}
		} else {
			for(int i = left; i <= mid; i++) {
				result[idx++] = arr[i];
			}
		}
		
		for(int i = start; i <= end; i++) {
			arr[i] = result[i];
		}
	}
}
