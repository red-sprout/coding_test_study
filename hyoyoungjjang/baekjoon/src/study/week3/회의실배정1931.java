package study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 회의실배정1931 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() { 
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
			
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			pq.add(new int[] {a, b});
		}
		
		int result = 0;
		int endTime = 0;
		
		while(!pq.isEmpty()) {
			int[] meeting = pq.poll();
			if(meeting[0] >= endTime) {
				endTime = meeting[1];
				result++;
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
