package year2024.month04.day29;
//N으로 만들기
import java.io.*;
import java.util.*;

public class BOJ17255 {
	private static String n;
	private static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = br.readLine();
		for(int i = 0; i < n.length(); i++) {
			String num = String.valueOf(n.charAt(i));
			dfs(i, i, num, num);
		}
		
		System.out.println(set.size());
		br.close();
	}
	
	public static void dfs(int left, int right, String order, String num) {
		if(left == 0 && right == n.length() - 1) {
			set.add(order);
			return;
		}
		
		String now = null;
		if(left > 0) {
			now = n.charAt(left - 1) + num;
			dfs(left - 1, right, order + now, now);
		}
		
		if(right < n.length() - 1) {
			now = num + n.charAt(right + 1);
			dfs(left, right + 1, order + now, now);
		}
	}
}
