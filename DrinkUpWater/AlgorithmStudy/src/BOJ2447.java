import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2447 {
	private static String[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		arr = new String[n][n];

		star(0, 0, n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == null) {
					sb.append(" ");
				} else {
					sb.append(arr[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void star(int x, int y, int n) {
		if (n == 1) {
			arr[x][y] = "*";
			return;
		}
		
		int size = n / 3;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(i == 1 && j == 1)) {
					star(x + i * size, y + j * size, size);
				}
			}
		}
	}
}
