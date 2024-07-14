import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1935 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		Stack<Double> s = new Stack<>();
		Double[] arr = new Double[n];
		for (int i = 0; i < n ; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		for (int i = 0; i < str.length(); i++ ) {
			char ch = str.charAt(i);
			
			if ('A' <= ch && ch <= 'Z') {
				s.push(arr[ch - 'A']);
			} else {
				Double a = s.pop();
				Double b = s.pop();
				
				switch (ch) {
				case '+' :
					s.push(b + a);
					break;
				case '-' :
					s.push(b - a);
					break;
				case '*' :
					s.push(b * a);
					break;
				case '/' :
					s.push(b / a);
					break;
				}
			}
		}
		
		System.out.printf("%.2f", s.pop());
		br.close();
	}
}
