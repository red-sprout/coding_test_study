package year2024.month06.day06;
// 문자열 판별
import java.io.*;
import java.util.*;

public class BOJ16500 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[s.length()];
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		for(int i = s.length() - 1; i >= 0; i--) {
			for(int j = i + 1; j < s.length(); j++) {
				if(dp[j] == 1 && set.contains(s.substring(i, j))) {
					dp[i] = 1;
				}
			}
			
			if(set.contains(s.substring(i))) {
				dp[i] = 1;
			}
		}
		
		System.out.println(dp[0]);
		br.close();
	}
}
