package codingTestPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		//우선순위 큐 기본적으로 오름차순
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(que.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(que.poll());
				}
			} else {
				que.add(num);
			}
		}
		
		br.close();
		
	}
}
