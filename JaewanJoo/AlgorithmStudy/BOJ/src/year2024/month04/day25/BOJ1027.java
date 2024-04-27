package year2024.month04.day25;

import java.io.*;
import java.util.*;

public class BOJ1027 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] buildings = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] up = new int[n];
		int[] down = new int[n];
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				
			}
		}
		
		br.close();
	}
}
