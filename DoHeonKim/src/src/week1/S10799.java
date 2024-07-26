package src.week1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> s = new Stack<>();
		
		String str = bf.readLine();

		int result = 0;
		
		for(int i = 0; i < str.length(); i++) { //str 길이만큼 반복
			if(str.charAt(i)=='(') {
				if(s.empty()) { //처음 비어있는 거 방지
					s.push(1); //비어있다면 1넣고
				}else {
					s.push(s.pop()+1); //비어있지 않을 때 꺼내서 +1후 다시 넣음
				}
			}else {
				s.push(s.pop()-1); //닫는 괄호라면 꺼내서 -1하고 다시 넣기

				if(str.charAt(i-1) == '(') { //직전이 열린괄호일때만 레이저판정
					result += s.peek(); //result에 넣고
				} else {
					result++; //직전이 열린괄호가 아니라면 단순이 +1
				}
			}			
		}
		System.out.println(result);
	}
}
