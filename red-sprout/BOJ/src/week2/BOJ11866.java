package week2;
// 요세푸스 문제 0
import java.io.*;

public class BOJ11866 {
	private static class MyQ {
		int front, back;
		int[] arr;
		
		MyQ() {
			this.arr = new int[1000001];
			this.front = 0;
			this.back = 0;
		}
		
		boolean isEmpty() {
			return front == back;
		}
		
		void offer(int value) {
			arr[back++] = value;
		}
		
		int poll() {
			return arr[front++];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		MyQ q = new MyQ();
		int n = Integer.parseInt(info[0]);
		int k = Integer.parseInt(info[1]);
		
		String[] order = new String[n];
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		int idx = 0;
		while(!q.isEmpty()) {
			for(int i = 1; i < k; i++) {
				q.offer(q.poll());
			}
			order[idx++] = String.valueOf(q.poll());
		}

		System.out.println("<" + String.join(", ", order) + ">");
		
		br.close();
	}
}
