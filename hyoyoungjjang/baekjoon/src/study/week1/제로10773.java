package study.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 제로10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> s = new Stack<>();
	
		int k = Integer.parseInt(br.readLine());	
		
		
		for(int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
		
			if(num == 0) {
				s.pop();
			} else {			
				s.push(num);
				
			}
		}

		int sum = 0;
		for(int i : s) {
			sum += i;
		}
		
		System.out.println(sum);
		br.close();
	}
}
