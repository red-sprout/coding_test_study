import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num != 0) {
				s.push(num);
			} else {
				s.pop();
			}
		}
		int size = s.size();
		int sum = 0;
		
		for (int i = 0; i < size; i++) {
			sum += s.pop();
		}
		
		System.out.println(sum);
		
//		처음에 stack안쓰고.. 
//		int n = Integer.parseInt(br.readLine());
//		ArrayList<Integer> list = new ArrayList<>();
//		
//		int index = -1;
//		
//		for (int i = 0; i < n; i++) {
//			int num = Integer.parseInt(br.readLine());
//			
//			if (num != 0) {
//				list.add(num);
//				index++;
//			} else {
//				list.remove(index);
//				index = index - 1;
//			}
//			
//		}
//		
//		int sum = 0;
//		
//		for (int i = 0; i <= index; i++) {
//			sum += list.get(i);
//		}
//		
//		System.out.println(sum);	
		
	}
}