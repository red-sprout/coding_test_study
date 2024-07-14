import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		boolean[][] bArr = new boolean[100][100];
		
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			for (int j = a; j < a + 10; j++) {
				for (int z = b; z < b + 10; z++) {
					if (!bArr[j][z]) {
						bArr[j][z] = true;
						count++;
					}
					
				}
			}
		}
		
		System.out.println(count);
	}
}
