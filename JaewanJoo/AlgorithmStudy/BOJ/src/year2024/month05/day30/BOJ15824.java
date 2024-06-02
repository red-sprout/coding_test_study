package year2024.month05.day30;
// 너 봄에는 캡사이신이 맛있단다
import java.io.*;
import java.util.*;

public class BOJ15824 {
	private static int n;
	private static int[] arr;
	private static long[] pow;
	private static final int CONST = 1_000_000_007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		pow = new long[n + 1];
		long result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		pow[0] = 1;
		for(int i = 1; i <= n; i++) {
			pow[i] = pow[i - 1] * 2 % CONST;
		}
		
		for(int i = 1; i <= n; i++) {
			result = (result + (pow[i - 1] - pow[n - i]) * arr[i]) % CONST;
		}
		
		System.out.println(result);
		
		br.close();
	}
}
