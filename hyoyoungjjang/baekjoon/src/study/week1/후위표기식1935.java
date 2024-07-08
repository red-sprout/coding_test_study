package study.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 후위표기식1935 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Double> s = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		Double[] dArr = new Double[n];
		for (int i = 0; i < dArr.length; i++) {
			dArr[i] = Double.parseDouble(br.readLine());
		}
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= 'A' && ch <= 'z') {
				s.push(dArr[ch - 65]);
			} else {
				double res = 0;
				double a = s.pop();
				double b = s.pop();
				if(ch == '+') {
					res = b + a;
					s.push(res);
				} else if (ch == '-') {
					res = b - a;
					s.push(res);
				} else if (ch == '*') {
					res = b * a;
					s.push(res);
				} else if (ch == '/') {
					res = b / a;
					s.push(res);
				}
			}
		}
		System.out.printf("%.2f", s.pop());
		br.close();
	} 
}
