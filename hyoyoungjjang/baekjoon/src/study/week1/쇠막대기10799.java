package study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//2024-06-25 20:50
public class 쇠막대기10799 {
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String[] sArr = br.readLine().split("");
		 
		 Stack<String> stack = new Stack<>();
		 int result = 0;
		 for(int i = 0; i < sArr.length; i++) {
			String s = sArr[i];
			if (s.equals("(")) {
				stack.push(s);	
				continue;
			}
			//이때 s는 ")"
			
			stack.pop();
			if(sArr[i - 1].equals("(")) {
				result += stack.size();
			} else {
				result += 1;
			}
		 }
		 System.out.println(result);
		 br.close();
	 }
}
//2024-06-25 21:50
