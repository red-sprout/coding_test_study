package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대힙11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//우선순위 큐 
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		//Collections.reverseOrder() -> Comparator 반환 -> compare 메서드 실행 내림차순 
		
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
