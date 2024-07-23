import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
private static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int pow2n = (int)Math.pow(2, n); //2의 n제곱 (행의 크기)
		cal(pow2n, r, c);
		
		System.out.println(count);
		
		br.close();
	}
	
	private static void cal(int a, int r, int c) {
		if (a == 1) {
			return;
		}
		
		//4개로 나눳을때 왼쪽위
		if (r < a/2 && c < a/2) {
			cal(a/2, r , c);
		}
		//오른쪽 위
		else if (r < a/2 && c >= a/2) {
			count += (a/2) * (a/2); //왼쪽 위 부분 갯수
			cal(a/2, r, c - (a/2));
		}
		//왼쪽 아래
		else if (r >= a/2 && c < a/2) {
			count += (a/2) * (a/2) * 2;
			cal(a/2, r - (a/2), c);
		}
		//오른쪽 아래
		else {
			count += (a/2) * (a/2) * 3;
			cal(a/2, r - (a/2), c - (a/2));
		}
    }	
}
