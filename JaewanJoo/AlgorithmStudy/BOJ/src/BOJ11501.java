// 주식
import java.io.*;

public class BOJ11501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < test; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			String[] info = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(info[i]);
			}
			
			int value = 0;
			long result = 0;
			for(int i = N - 1; i >= 0; i--) {
				if(arr[i] > value) {
					value = arr[i];
				} else {
					result += value - arr[i];
				}
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
