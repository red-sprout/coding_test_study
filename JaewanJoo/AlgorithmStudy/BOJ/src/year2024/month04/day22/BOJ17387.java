package year2024.month04.day22;

import java.io.*;
import java.util.*;

public class BOJ17387 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] l1 = new int[4];
		int[] l2 = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			l1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			l2[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		if(isSeperate(l1, l2)) {
			result = 0;
		}
		
		System.out.println(result);
		br.close();
	}
	
	public static boolean isSeperate(int[] l1, int[] l2) {
		int xmaxl1 = Math.max(l1[0], l1[2]);
		int xmaxl2 = Math.max(l2[0], l2[2]);
		int ymaxl1 = Math.max(l1[1], l1[3]);
		int ymaxl2 = Math.max(l2[1], l2[3]);
		
		int xminl1 = Math.min(l1[0], l1[2]);
		int xminl2 = Math.min(l2[0], l2[2]);
		int yminl1 = Math.min(l1[1], l1[3]);
		int yminl2 = Math.min(l2[1], l2[3]);
		
		if(xmaxl1 < xminl2) return true;
		if(xmaxl2 < xminl1) return true;
		if(ymaxl1 < yminl2) return true;
		if(ymaxl2 < yminl1) return true;
		
		return false;
	}
}
