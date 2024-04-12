package year2024.month04.day15;

import java.io.*;
import java.util.*;

public class BOJ13335 {
	static class Truck {
		int weight;
		int time;
		
		Truck(int weight){
			this.weight = weight;
			this.time = 0;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Truck[] trucks = new Truck[n];
		Queue<Truck> q = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			trucks[i] = new Truck(Integer.parseInt(st.nextToken()));
		}
		
		int idx = 1;
		int time = 1;
		int nowWeight = trucks[0].weight;
		
		trucks[0].time++;
		q.add(trucks[0]);
		
		while(!q.isEmpty()) {
			time++;
			if(q.peek().time >= w) {
				nowWeight -= q.peek().weight;
				q.poll();
			}
			if(idx < trucks.length && nowWeight + trucks[idx].weight <= l) {
				nowWeight += trucks[idx].weight;
				q.add(trucks[idx++]);
			}
			for(int i = 0; i < idx; i++) {
				trucks[i].time++;
			}
		}
		
		System.out.println(time);
		br.close();
	}
}
