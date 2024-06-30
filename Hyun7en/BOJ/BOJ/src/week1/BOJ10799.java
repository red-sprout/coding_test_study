package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
 * (는 먼저 가능(막대기 시작,레이저 시작)
 * () 레이저
 * ) 전에 무조건 다른게 있어야 함(막대기 끝, 레이저 끝)
 */
public class BOJ10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<Character>();
		String data = br.readLine();
		
		int result = 0;
		
		for(int i = 0; i < data.length(); i++) {
			
			if(data.charAt(i) == '('){ // 여는 괄호인 경우
				stack.push('(');
			}else { // 닫는 괄호인 경우	
				stack.pop();
				
				if(data.charAt(i-1) == '(' ) {// 레이저인 경우
					result += stack.size();
				}else { // 레이저 아닌 경우
					result++;
				}
			}
		}
		
		System.out.println(result);
		br.close();
		
		
	}
}
