package week1;
// 쇠막대기
import java.io.*;
import java.util.*;

public class BOJ10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> stack = new LinkedList<>();
		char[] status = br.readLine().toCharArray();
		
		int before = 0;
		int result = 0;
		for(char c : status) {
			if(c == '(') {
				stack.push(c);
			} else {
				stack.pop();
				if(before == stack.size()) {
					result += before;
				} else if(before > stack.size()){
					result += 1;
				} else {
					result += stack.size();
				}
				before = stack.size();
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
