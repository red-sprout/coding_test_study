import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 처음 주어진 n m r
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int min = Math.min(n, m) / 2; // 배열 크기에 따라 작아지면서 몇번 돌아야하는지

		// 배열 만들기
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < min; j++) {
				int tmp = arr[j][j]; // 시작값 저장

				// 오른쪽상단 -> 왼쪽상단
				for (int k = j + 1; k < m - j; k++) {
					arr[j][k - 1] = arr[j][k];
				}
				// 오른쪽하단 -> 오른쪽상단
				for (int k = j + 1; k < n - j; k++) {
					arr[k - 1][m - j - 1] = arr[k][m - j - 1];
				}
				// 왼쪽하단 -> 오른쪽하단
				for (int k = m - 2 - j; k >= j; k--) {
					arr[n - 1 - j][k + 1] = arr[n - 1 - j][k];
				}
				// 왼쪽상단 -> 왼쪽하단
				for (int k = n - j - 2; k >= j; k--) {
					arr[k + 1][j] = arr[k][j];
				}
				// 시작값 넣기
				arr[j + 1][j] = tmp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

		br.close();
	}
}
