package year2024.month10.first;

import java.io.*;
import java.util.*;

public class Main_bj_2564_경비원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		int[][] pos = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int d = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int answer = 0;
		for(int i = 0; i < n; i++) {
			int di = pos[i][0];
			int xi = pos[i][1];
			if(d == 1) {
				if(di == 1) {
					answer += Math.abs(x - xi);
				} else if (di == 2) {
					answer += Math.min(x + xi + col, row - x + row - xi + col);
				} else if (di == 3) {
					answer += x + xi;
				} else {
					answer += row - x + xi;
				}
			} else if (d == 2) {
				if(di == 1) {
					answer += Math.min(x + xi + col, row - x + row - xi + col);
				} else if (di == 2) {
					answer += Math.abs(x - xi);
				} else if (di == 3) {
					answer += x + col - xi;
				} else {
					answer += row - x + col - xi;
				}
			} else if (d == 3) {
				if(di == 1) {
					answer += x + xi;
				} else if (di == 2) {
					answer += col - x + xi;
				} else if (di == 3) {
					answer += Math.abs(x - xi);
				} else {
					answer += Math.min(x + xi + row, col - x + col - xi + row);
				}
			} else {
				if(di == 1) {
					answer += x + row - xi;
				} else if (di == 2) {
					answer += col - x + row - xi;
				} else if (di == 3) {
					answer += Math.min(x + xi + row, col - x + col - xi + row);
				} else {
					answer += Math.abs(x - xi);
				}
			}
		}
		System.out.println(answer);
		br.close();
	}
}
