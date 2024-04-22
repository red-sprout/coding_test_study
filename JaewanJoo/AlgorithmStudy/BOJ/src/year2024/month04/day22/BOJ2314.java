package year2024.month04.day22;

import java.io.*;
import java.util.*;

public class BOJ2314 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> q = new LinkedList<>();
		
		int start = 0;
		int end = 0;
		
		int idx = 0;
		for(int i = 0; i < 4; i++) {
			String row = br.readLine();
			for(int j = 0; j < 4; j++) {
				if(row.charAt(j) == 'L') {
					start = start | (1 << idx);
				} else {
					start = start | ~(1 << idx);
				}
				idx++;
			}
		}
		
		idx = 0;
		br.readLine();
		for(int i = 0; i < 4; i++) {
			String row = br.readLine();
			for(int j = 0; j < 4; j++) {
				if(row.charAt(j) == 'L') {
					end = end | (1 << idx);
				} else {
					end = end | ~(1 << idx);
				}
				idx++;
			}
		}
		
		q.add(new int[] {start, 0});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i < 16; i++) {
				if(i != 0 && (now[0] & (1 << (i - 1))) != (now[0] & (1 << i))) {
					int next = now[0] ^ (now[0] & (1 << (i - 1)));
					next = next ^ (now[0] & (1 << i));
					q.add(new int[] {next, now[1] + 1});
				}
			}
		}
		
		br.close();
	}
}
