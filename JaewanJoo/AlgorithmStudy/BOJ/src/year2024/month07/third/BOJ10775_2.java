package year2024.month07.third;

import java.io.*;
import java.util.*;

public class BOJ10775_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int[] group = new int[G + 1];
		for(int i = 1; i <= G; i++) {
			group[i] = i;
		}
		
		int answer = 0;
		for(int i = 0; i < P; i++) {
			int gate = Integer.parseInt(br.readLine());
			while(gate != group[gate]) gate = group[gate];
			if(gate == 0) break;
			group[gate]--;
			answer++;
		}
		
		System.out.println(answer);
		br.close();
	}
}
