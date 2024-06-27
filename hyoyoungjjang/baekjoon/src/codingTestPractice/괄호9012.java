package codingTestPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 괄호9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < t; i++) {
			String str = br.readLine();
			
			Stack<Integer> stack = new Stack<>();
			
			String result = "YES";
			
			for(int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				
				if(ch == '(') {
					stack.push(1);
				} else if(ch == ')') {
					if(stack.isEmpty()) {
						result = "NO";
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if(!stack.isEmpty()) {
				result = "NO";
			}
			
			bw.write(result + "\n");
			
		
		}
		
		bw.flush();
		bw.close();
	}
}

