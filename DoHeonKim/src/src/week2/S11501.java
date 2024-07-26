package src.week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11501 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int t = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < t ; i++) {
			int n = Integer.parseInt(bf.readLine());
			long arr[] = new long[n];
			
			st = new StringTokenizer(bf.readLine());

			arr = setQ(arr, n, st);

			System.out.println(resultQ(arr, n));
		}
	}
	
	public static long[] setQ(long arr[], int n, StringTokenizer st){
		for(int i = 0; i < n ; i++ ) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		return arr;
	}
	
	public static long resultQ(long arr[], int n) {
		long result = 0;
		long max = 0;
		for(int i = n -1 ; i >= 0 ; i--) {
			if(arr[i] > max) {
				max = arr[i];
			} else {
				result += (max - arr[i]);
			}
		}
		return result;
	}
	
}
