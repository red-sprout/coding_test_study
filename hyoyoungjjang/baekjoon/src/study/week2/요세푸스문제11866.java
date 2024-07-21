package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//14:45
public class 요세푸스문제11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		br.close();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
	
		sb.append("<");
		
		while(!q.isEmpty()) {
			for(int i = 0; i < k-1; i++) { // 선입선출이 특징인 큐
				q.add(q.remove()); // k-1만큼 큐에서 빼고 넣어주고 반복.
			}
			
			sb.append(q.remove());
			if(!q.isEmpty()) {	
				sb.append(", ");
			}
		}
		
		sb.append(">");
		System.out.println(sb);
		
	}
}
// 15:35