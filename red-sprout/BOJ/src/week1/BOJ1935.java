package week1;
// 후위 표기식2
import java.io.*;
import java.util.*;

public class BOJ1935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Double> stack = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		double[] arr = new double[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch(c) {
			case '+':
			case '-':
			case '*':
			case '/':
				double b = stack.pop();
				double a = stack.pop();
				stack.push(eval(a, b, c));
				break;
			default:
				stack.push(arr[c - 'A']);
			}
		}
		
		System.out.printf("%.2f\n", stack.pop());
		br.close();
	}
		
	public static double eval(double a, double b, char c) {
		switch(c) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		}
		return -1;
	}
}
