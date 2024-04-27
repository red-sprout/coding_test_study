package year2024.month04.day29;
//괄호
import java.io.*;

public class BOJ10422 {
	private static final long CONST = 1_000_000_007l;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test = Integer.parseInt(br.readLine());
		long[][] arr = new long[5001][2];
		arr[2][1] = 1;
		
		for(int i = 4; i <= 5000; i++) {
			if(i % 2 != 0) continue;
			long first = 0;
			for(int j = 2; j <= i - 2; j += 2) {
				first += ((arr[j][0] + arr[j][1]) % CONST) * arr[i - j][1] % CONST;
			}
			arr[i][0] = (first % CONST);
			arr[i][1] = (arr[i - 2][0] + arr[i - 2][1]) % CONST;
		}
		
		for(int i = 0; i < test; i++) {
			int l = Integer.parseInt(br.readLine());
			sb.append((arr[l][0] + arr[l][1]) % CONST).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
