package week2;
// 최대 힙
import java.io.*;

public class BOJ11279 {
	private static class MyPQ {
		int[] heap;
		int size;
		
		MyPQ(int n) {
			int h = (int)(Math.log(n) / Math.log(2));
			this.size = 0;
			this.heap = new int[1 << (h + 1)];
		}
		
		void offer(int value) {
			heap[++size] = value;
			int current = size;
			while(current > 1 && heap[current] > heap[current / 2]) {
				int tmp = heap[current / 2];
				heap[current / 2] = heap[current];
				heap[current] = tmp;
				current /= 2;
			}
		}
		
		int poll() {
			if(size == 0) {
				return 0;
			}
			
			int result = heap[1];
			int current = 1;
			heap[1] = heap[size];
			heap[size] = 0;
			size--;
			
			while(current * 2 <= size) {
				int child;
				if(current * 2 + 1 > size) {
					child = current * 2;
				} else {
					child = heap[current * 2] < heap[current * 2 + 1] ? current * 2 + 1 : current * 2;
				}
				
				if(heap[current] > heap[child]) break;
				
				int tmp = heap[child];
				heap[child] = heap[current];
				heap[current] = tmp;
				current = child;
			}
			return result;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		MyPQ pq = new MyPQ(n);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				sb.append(pq.poll()).append("\n");
			} else {
				pq.offer(x);
			}
		}
		
		System.out.print(sb);
		br.close();
	}
}
