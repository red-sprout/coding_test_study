package week2;
// 절대값 힙
import java.io.*;

public class BOJ11286 {
	private static class MyPQ {
		int[] heap;
		int lastNode;
		
		MyPQ(int n) {
			int h = (int)(Math.log(n) / Math.log(2));
			this.lastNode = 0;
			this.heap = new int[1 << (h + 1)];
		}
		
		void offer(int value) {
			heap[++lastNode] = value;
			int current = lastNode;
			
			while(current > 1 && compare(current, current / 2)) {
				  int tmp = heap[current / 2];
				  heap[current / 2] = heap[current];
				  heap[current] = tmp;
				  current /= 2;
			}
		}
		
		int poll() {
			if(lastNode == 0) return 0;
			
			int result = heap[1];
			int current = 1;
			heap[1] = heap[lastNode];
			heap[lastNode] = 0;
			lastNode--;
			
			while(current * 2 <= lastNode) {
				int child;
				if(current * 2 + 1 > lastNode) {
					child = current * 2;
				} else {
					child = compare(current * 2, current * 2 + 1) ? current * 2 : current * 2 + 1;
				}
				
				if(Math.abs(heap[current]) < Math.abs(heap[child])) break;
				
				int tmp = heap[child];
				heap[child] = heap[current];
				heap[current] = tmp;
				current = child;
			}
			
			return result;
		}
		
		boolean compare(int node1, int node2) {
			if(Math.abs(heap[node1]) == Math.abs(heap[node2])) {
				return heap[node1] < heap[node2];
			} else {
				return Math.abs(heap[node1]) < Math.abs(heap[node2]);
			}
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
