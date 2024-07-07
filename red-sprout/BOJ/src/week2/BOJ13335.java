package week2;
// 트럭
import java.io.*;

public class BOJ13335 {
	private static class MyQueue {
		int front;
		int back;
		int[] arr;
		
		MyQueue(int size) {
			arr = new int[size];
			front = 0;
			back = 0;
		}
		
		boolean isEmpty() {
			return front == back;
		}
		
		int peek() {
			return arr[front];
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
		int n = Integer.parseInt(info[0]);
		int w = Integer.parseInt(info[1]);
		int l = Integer.parseInt(info[2]);
		
		info = br.readLine().split(" ");
		MyQueue q = new MyQueue(n);
		
		int[] weight = new int[n];
		int[] time = new int[n];
		for(int i = 0; i < n; i++) {
			weight[i] = Integer.parseInt(info[i]);
		}
		
		int result = 1;
		int idx = 0;
		int now = weight[idx];
		q.offer(idx++);
		while(!q.isEmpty()) {
			int front = q.peek();
			for(int i = front; i < idx; i++) {
				time[i]++;
			}
			if(time[front] == w) {
				now -= weight[q.poll()];
			}
			if(idx < n && now + weight[idx] <= l) {
				now += weight[idx];
				q.offer(idx++);
			}
			result++;
		}
		
		System.out.println(result);
		br.close();
	}
}
