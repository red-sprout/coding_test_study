import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9663 {
	static int n;
	static int count;
	static int[] arr;
	//depth를 행 arr열
	//전부 놔본다는 생각으로
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		count = 0;

		putQueen(0);
		System.out.println(count);
	}

	public static void putQueen(int depth) {
		if (depth == n) {
			count++;
			return;
		}
		for (int i = 0; i < n; i++) {
			arr[depth] = i;

			if (isQueen(depth)) {//조건에 맞으면 내려감
				putQueen(depth + 1);
			}
		}
	}

	public static boolean isQueen(int depth) {
		
		for (int i = 0; i < depth; i++) {
			if (arr[depth] == arr[i]) {//같은열에 이미 있으면 false
				return false;
			} else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {//대각선
				return false;
			}
		}
		return true;
	}
}
