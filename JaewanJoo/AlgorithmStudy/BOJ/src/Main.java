import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n0, n1, n2, n3, n4;
		int cases = 0;
		String ans;
		while((n0 = Integer.parseInt(br.readLine())) != 0) {
			cases++;
			n1 = 3 * n0;
			if(n1 % 2 == 0) {
				ans = "even";
				n2 = n1 / 2;
			} else {
				ans = "odd";
				n2 = (n1 + 1) / 2;
			}
			n3 = 3 * n2;
			n4 = n3 / 9;
			
			sb.append(cases).append(".").append(" ");
			sb.append(ans).append(" ");
			sb.append(n4).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}