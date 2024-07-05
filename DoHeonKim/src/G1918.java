import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G1918 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> s = new Stack<>();
		
		String str = bf.readLine();
		String result = "" ;
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i)=='*' || str.charAt(i)=='/' || str.charAt(i)=='+' || str.charAt(i)=='-') {
				 while (!s.isEmpty() && priority(s.peek()) >= priority(str.charAt(i))) {
                     result+=s.pop();
                 }
				s.push(str.charAt(i));
				
			}else if(str.charAt(i)=='(') {
				s.push(str.charAt(i));
			}else if(str.charAt(i)==')'){
				while(!s.empty() && s.peek() != '(') {
					result+=s.pop();
				}
				s.pop();
			}else {
				result+=str.charAt(i);
			}
		}
		
		//마지막 검사
		while(!s.empty()) {
			result+=s.pop();
		}
			
		System.out.println(result);

	}
	
    public static int priority(char operator){

        if(operator=='(' || operator==')'){
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }

}
