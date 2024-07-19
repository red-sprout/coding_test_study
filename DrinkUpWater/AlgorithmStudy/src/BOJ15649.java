import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
	private static int[] arr;
	private static boolean[] isUsed;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		isUsed = new boolean[n];
		
		call(n, m, 0);
		
	}
	private static void call (int n, int m, int index) {
		if (index == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!isUsed[i]) {
				arr[index] = i + 1;
				isUsed[i] = true;
				call(n, m, index + 1);
				isUsed[i] = false;
			}
		}
	}
}
