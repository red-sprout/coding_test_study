import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		int count = 0;
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if (ch == '(') {
				count++;
				
			} else {
				count--;
				
				if (str.charAt(i - 1) == '(') {//()레이저인 경우
					sum += count;
				} else {//레이저가 아닌데 닫힌 경우
					sum++;
				}
				
			}
		}
		System.out.println(sum);
		br.close();
	}
}
