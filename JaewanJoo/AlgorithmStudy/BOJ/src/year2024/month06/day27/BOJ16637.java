package year2024.month06.day27;
// 괄호 추가하기
import java.io.*;
import java.util.*;

public class BOJ16637 {
	private static int max = Integer.MIN_VALUE;
	private static List<Integer> num = new ArrayList<>();
	private static List<Character> oper = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		for(int i = 0; i < n; i++) {
			char c = str.charAt(i);
			switch(c) {
			case '+':
			case '-':
			case '*':
			case '/':
				oper.add(c);
				break;
			default:
				num.add(c - '0');
				break;
			}
		}
		
		dfs(0, num.get(0));
		System.out.println(max);
		br.close();
	}
	
	public static void dfs(int idx, int result) {
		if(idx >= oper.size()) {
			max = Math.max(max, result);
			return;
		}
		
		int res = eval(oper.get(idx), result, num.get(idx + 1));
		dfs(idx + 1, res);
		
		if(idx < oper.size() - 1) {
			res = eval(oper.get(idx + 1), num.get(idx + 1), num.get(idx + 2));
			res = eval(oper.get(idx), result, res);
			dfs(idx + 2, res);
		}
	}
	
	public static int eval(char op, int x, int y) {
		switch(op) {
		case '+':
			return x + y;
		case '-':
			return x - y;
		case '*':
			return x * y;
		case '/':
			return x / y;
		}
		return -1;
	}
}
