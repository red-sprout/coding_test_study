import java.io.*;

// [BOJ] 광고 / 플레티넘 4 / 30분
// 알고리즘 분류 : 문자열 / kmp
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int[] info = maxPrefix(str);
		
		System.out.println(n - info[n - 1]);
		
		br.close();
	}
	
	public static int[] maxPrefix(String str) {
		int size = str.length();
		int[] table = new int[size];
		
		int pre = 0;
		for(int post = 1; post < size; post++) {
			while(pre != 0 && str.charAt(pre) != str.charAt(post)) {
				pre = table[pre - 1];
			}
			if(str.charAt(pre) == str.charAt(post)) {
				table[post] = ++pre;
			}
		}
		
		return table;
	}
}
