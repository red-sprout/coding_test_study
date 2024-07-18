import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11729 {
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		
		//하노이탑 이동 횟수 2의 n제곱 - 1
		sb.append((int)Math.pow(2, n) - 1).append("\n");
		
		hanoi(1, 2, 3, n);
		
		System.out.println(sb);
	}
	
	public static void hanoi(int a, int b, int c, int n) {
		if (n == 1) {
			printHanoi(a, c);// 이동하는 순서대로 출력
			return;
		} 
		hanoi(a, c, b, n - 1);//a에서 b로 한개 빼고 다 이동
		printHanoi(a, c); // 그 마지막 한개를 이동
		hanoi(b, a, c, n - 1);//b에서 c로 한개 빼고 다 이동
	}
	public static void printHanoi(int a, int c) {
		sb.append(a + " " + c).append("\n");
	}
}
