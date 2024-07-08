import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int max = 0;
			long result = 0;
			//답은 부호있는 64bit 정수형으로 표현 가능하다...
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken()); 
			}
			max = arr[arr.length-1];
			for (int j = N - 1; j >= 0; j--) {
				if (max < arr[j]) {
					max = arr[j];
				} else {
					result += max - arr[j];
				}
			}
			System.out.println(result);
		}
	}
}
