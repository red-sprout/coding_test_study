package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10871 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//첫째 줄
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		//둘째 줄
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			if(arr[i] < X) {
				sb.append(arr[i]).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}
