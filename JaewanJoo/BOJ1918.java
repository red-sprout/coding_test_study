import java.io.*;
import java.util.*;

// [BOJ] 후위 표기식 / 골드 2 / 2시간
// 알고리즘 분류 : 자료 구조 / 스택
enum Type {
	MULTI('*', 2),
	DIV('/', 2),
	PLUS('+', 1),
	MINUS('-', 1),
	LEFT('(', 0),
	RIGHT(')', 0);
	
	private char operator;
	private int number;
	
	Type(char operator, int number) {
		this.operator = operator;
		this.number = number;
	}
	
	public static Type getType(char operator) {
		return Arrays.stream(values())
				.filter(x -> x.operator == operator)
				.findAny()
				.orElse(null);
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public static int getPriority(char operator) {
		return getType(operator).getNumber();
	}
}

public class Main {
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			
			if(Type.getType(now) == null) {
				sb.append(now);
			} else if(Type.getPriority(now) > 0) {
				while(!stack.isEmpty() && Type.getPriority(stack.peek()) >= Type.getPriority(now)) {
					sb.append(stack.pop());
				}
				stack.add(now);
			} else if(Type.getType(now).equals(Type.LEFT)) {
				stack.add(now);
			} else {
				while(!stack.isEmpty() && !Type.getType(stack.peek()).equals(Type.LEFT)) {
					sb.append(stack.pop());
				}
				stack.pop();
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
		br.close();
	}
}
