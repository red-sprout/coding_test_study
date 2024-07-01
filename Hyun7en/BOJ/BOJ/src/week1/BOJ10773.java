package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0 ; i < k; i++) {
			
			int a = Integer.parseInt(br.readLine());
			if(a != 0) {
				stack.push(a);
			}else {
				stack.pop();
			}
			
		}
		
		int result = 0;
		
		while(!stack.isEmpty()) {
			result +=stack.pop();
		}
		
		System.out.println(result);
		
		br.close();
	}

}
