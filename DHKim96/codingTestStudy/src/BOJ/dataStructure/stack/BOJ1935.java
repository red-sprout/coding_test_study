package BOJ.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
public class BOJ1935 {
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
//			피연산자의 갯수
			int k = Integer.parseInt(br.readLine());
			
//			후위표기식
			String postfix = br.readLine();
			
			// 피연산자들에 대응하는 값을 넣기 위한 배열
			Double[] doubleArr = new Double[k];
			// 배열에 입력
			for(int i = 0; i < doubleArr.length; i++) {
				doubleArr[i] = Double.parseDouble(br.readLine());
			}
			br.close();
			// 후위표기식을 대입하기 위한 임의의 char형 변수 선언
			char ch = 'a';
			int j = 0;
			// 후위표기식을 계산하기 위한 스택 변수 선언
//			Stack<Double> stack = new Stack<>();
			//  Double-Ended Queue 도 사용 가능. 현재 자바에서는 여러 이유로 스택을 대신하여 데큐의 사용을 권장하고 있음.
			ArrayDeque<Double> deque = new ArrayDeque<>();
			// 후위표기식을 하나씩 쪼갬
			for(int i = 0; i < postfix.length(); i++) {
				ch = postfix.charAt(i);
				// 피연산자일 경우 대응되는 숫자로 치환해 스택에 push
				if(ch >= 'A' && ch <= 'Z') {
					// A, B, C ... 는 순서대로 doubleArr[0], doubleArr[1], doubleArr[2] ... 으로 치환되므로
					deque.push(doubleArr[ch-'A']);
				} else { // 연산자일 경우 스택에 넣었던 피연산자 2개를 꺼낸 뒤 연산 결과를 push
					double d1 = deque.pop();
					double d2 = deque.pop();
					double d3 = 0.0;
					
					switch(ch) {
					case '+':
						d3 = d2 + d1;
						break;
					case '-':
						d3 = d2 - d1;
						break;
					case '*':
						d3 = d2 * d1;
						break;
					case '/':
						d3 = d2 / d1;
						break;
					}
					
					deque.push(d3);
				}
			}
			System.out.printf("%.2f", deque.pollLast());
		}
		
		
	}

