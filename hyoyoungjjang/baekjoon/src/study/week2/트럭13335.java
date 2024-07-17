package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭13335 {
	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
	    int w = Integer.parseInt(st.nextToken());
	    int l = Integer.parseInt(st.nextToken());
		int time = 0;
		
		
		Queue<Integer> truck = new LinkedList<>();
		
		Queue<Integer> bridge = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		
		
		for(int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
		
		int weight = 0;
		
		for(int i = 0; i < w; i++) {
			bridge.add(0);
		}
		
		while(!bridge.isEmpty()) {
			time ++;
			weight -= bridge.remove();
			if(!truck.isEmpty()) {
				if(truck.peek() + weight <= l) {
					weight += truck.peek();
					bridge.add(truck.remove());
				} else {
					bridge.add(0);
				}
			}
		}
			
		System.out.println(time);
		br.close();
	}
}
