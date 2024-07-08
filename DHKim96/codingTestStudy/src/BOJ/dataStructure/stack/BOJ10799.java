package BOJ.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10799 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문제의 포인트는 닫는 괄호가 나왔을 때 직전의 괄호가 여는 괄호인지 닫는 괄호인지 확인하여 막대기 조각의 갯수를 구하는 것.
		
		// 여는 괄호가 나오면 일단 데큐에 push
		// 닫는 괄호가 나오면 pop
		// 이때, 직전 괄호가 
		// 1. 여는 괄호라면 레이저이며 이는 곧 데큐의 사이즈(레이저를 지나가는 막대기의 수)만큼의 조각이 생기는 것이기에 result 에 데큐의 사이즈만큼 더해줌.
		// 2. 직전 괄호가 닫는 괄호라면 한 개의 막대기가 끝나는 지점이기 때문에 결과값에 그냥 +1 을 해줌.
		
		// 괄호들을 입력받을 변수 생성
		String brackets = br.readLine();
		
		br.close();
		// 괄호를 넣어줄 데큐 생성
		Deque<Character> deque = new ArrayDeque<>();
		// 조각의 갯수를 넣어줄 변수 생성
		int result = 0;
		
		for(int i = 0; i < brackets.length(); i++) {
			if(brackets.charAt(i) == '(') {
				deque.push('('); 
			} else {
				deque.pop();
				// 레이저일 경우
				if(brackets.charAt(i-1) == '(') result += deque.size();
				// 아닐 경우
				else result ++;
			}
		}		
		System.out.println(result);
	}
	
	
}
