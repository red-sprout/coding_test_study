import java.io.*;

// [BOJ] 찾기 / 플레티넘 5 / 1시간
// 알고리즘 분류 : 문자열 / kmp
// KMP 알고리즘 기초문제
public class Main {
	private static int count;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String t = br.readLine();
		String p = br.readLine();
		
		count = 0;
		sb = new StringBuilder();
		
		KMP(t, p);
		System.out.println(count);
		System.out.println(sb);
		
		br.close();
	}
	
	public static int[] failureFunction(String pattern) {
		int size = pattern.length();
		int[] table = new int[size];
		
		int pre = 0;
		for(int post = 1; post < size; post++ ) {
			while(pre > 0 && pattern.charAt(pre) != pattern.charAt(post)) {
				pre = table[pre - 1];
			}
			if(pattern.charAt(pre) == pattern.charAt(post)) {
				table[post] = ++pre;
			}
		}
		
		return table;
	}
	
	public static void KMP(String parent, String pattern) {
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int[] table = failureFunction(pattern);
		
		int patternIdx = 0;
		for(int idx = 0; idx < parentSize; idx++) {
			while(patternIdx > 0 && parent.charAt(idx) != pattern.charAt(patternIdx)) {
				patternIdx = table[patternIdx - 1];
			}
			if(parent.charAt(idx) == pattern.charAt(patternIdx)) {
				if(patternIdx == patternSize - 1) {
					count++;
					sb.append(idx - patternSize + 2).append(" ");
					patternIdx = table[patternIdx];
				} else {
					patternIdx++;
				}
			}
		}
	}
}
