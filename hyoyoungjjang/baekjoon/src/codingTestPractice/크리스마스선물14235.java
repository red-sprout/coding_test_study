package codingTestPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크리스마스선물14235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		//내림차순
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			if(st.nextToken().equals("0")) {
				if(pq.isEmpty()) {
					System.out.println("-1");
				} else {
					System.out.println(pq.poll());
				}
				continue;
			} 
			
			while(st.hasMoreTokens()) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		br.close();
	}
}
