// 고냥이
package year2024.month06.day13;

import java.io.*;

public class BOJ16472 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		int[] used = new int[26];
		String str = br.readLine();
		
		int start = 0;
		int end = 0;
		int count = 1;
		used[str.charAt(end) - 'a']++;
		while(end < str.length() - 1) {
			end++;
			if(used[str.charAt(end) - 'a']++ == 0) count++;
			while(count > n && start < end) {
				if(--used[str.charAt(start++) - 'a'] == 0) count--;
			}
			ans = Math.max(ans, end - start + 1);
		}
		
		System.out.println(ans);
		br.close();
	}
}
