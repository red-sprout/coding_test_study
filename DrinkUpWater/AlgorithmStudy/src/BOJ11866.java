import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= n ; i++) {
			queue.add(i);
		}
		sb.append("<");
		
		while (!queue.isEmpty()) {
			if (queue.size() == 1) {
				sb.append(queue.poll() + ">");
			} else { //k번째꺼 빼기
				for (int i = 0; i < k - 1; i++) {
					queue.add(queue.poll());
				}
				sb.append(queue.poll() + ", ");
			}
		}
		
		System.out.println(sb);
		
		//시간초과 
//		boolean[] bArr = new boolean[n];
//		int count = 0;
//		
//		sb.append("<");
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < k; j++) {
//				if (count > 6) {
//					count -= 7;
//				}
//				if (!bArr[count]) {
//				} else {
//					j--;
//				}
//				count++;
//			}
//			
//			bArr[count-1] = true;
//			
//			if (i == n-1) {
//				sb.append(count).append(">");
//			} else {
//				sb.append(count).append(", ");
//			}
//		}
//		
//		System.out.println(sb);
	}
}
