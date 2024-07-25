import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	private static int l, c, mo, ja;
	private static char[] str, result;

	public static void main(String[] args) throws IOException {
		
		/*
		 * dfs로 해결 
		 * 하나씩 result 에 담아서 프린트하기전에 조건에 맞는지 확인 후 조건에 맞는것만 출력
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		str = new char[c + 1];
		result = new char[l + 1];
		for (int i = 1; i <= c; i++) {
			str[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(str);
		
		dfs(1, 1);
		br.close();
	}

	private static void dfs(int v, int index) {
		
		//길이가 l일때 탈출 조건확인하여 프린트
		if (index == l + 1) {
			mo = 0;
			ja = 0;
			for (int i = 1; i <= l; i++) {
				if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u' ) {
					mo++;
				} else {
					ja++;
				}
			}
			if (mo > 0 && ja >= 2) {
				printResult();
			}
			return;
		}
		
		for (int i = v; i <= c; i++) {
			result[index] = str[i];
			dfs(i + 1, index + 1);
		}
	}

	private static void printResult() {
		for (int i = 1; i <= l; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
	}
}
