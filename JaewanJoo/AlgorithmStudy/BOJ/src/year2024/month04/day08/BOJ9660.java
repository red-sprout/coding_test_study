package year2024.month04.day08;

import java.io.*;

public class BOJ9660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		String ans = null;
		
		if(n % 7 == 0 || n % 7 == 2) {
			ans = "CY";
		} else {
			ans = "SK";
		}
		
		System.out.println(ans);
		
		br.close();
	}
}
