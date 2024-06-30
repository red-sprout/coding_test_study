package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//dd

public class BOJ1935 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		Stack<Double> stack = new Stack<>();
		
		double[] dArr = new double[num];
		
		for(int i = 0; i < dArr.length; i++) {
			dArr[i] = Double.parseDouble(br.readLine());
		}
		
		double result = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if('A' <= str.charAt(i) &&  str.charAt(i) <= 'Z') {		
				stack.push(dArr[str.charAt(i)-'A']);
			}else {
				if(!stack.isEmpty()) {
					
					double n1 = stack.pop();
					double n2 = stack.pop();
					
					switch(str.charAt(i)) {
					
					case '+':
						result = n2 + n1;
						stack.push(result);
						break;
						
					case '-':
						result = n2 - n1;
						stack.push(result);
						break;
						
					case '*':
						result = n2 * n1;
						stack.push(result);
						break;
						
					case '/':
						result = n2 / n1;
						stack.push(result);
						break;
					
					}
				}
				
			}
		}
		
		System.out.printf("%.2f",stack.pop());
		
		
		br.close();
	}
		
		
}
	
	
	

