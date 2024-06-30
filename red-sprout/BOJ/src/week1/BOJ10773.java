package week1;
// 제로
import java.io.*;
import java.util.*;

public class BOJ10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> stack = new LinkedList<>();
		
		int k = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}
		
		int result = 0;
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		
		System.out.println(result);
		br.close();
	}
}
