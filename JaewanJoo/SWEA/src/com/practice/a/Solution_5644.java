package com.practice.a;

import java.io.*;
import java.util.*;

class Solution_5644 {
	static int[] nowA, nowB;
	static int[] dA, dB;
	static class BC {
		int row;
		int col;
		int cover;
		int perform;
		
		BC(int row, int col, int cover, int perform) {
			this.row = row;
			this.col = col;
			this.cover = cover;
			this.perform = perform;
		}
	}
	static int dr[] = {0, -1, 0, 1, 0};
	static int dc[] = {0, 0, 1, 0, -1};
	static BC[] arr;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			nowA = new int[] {1, 1};
			nowB = new int[] {10, 10};
			
			dA = new int[M];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < M; i++) dA[i] = Integer.parseInt(st.nextToken());
				
			dB = new int[M];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < M; i++) dB[i] = Integer.parseInt(st.nextToken());
			
			arr = new BC[A];
			for(int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				int cover = Integer.parseInt(st.nextToken());
				int perform = Integer.parseInt(st.nextToken());
				arr[i] = new BC(row, col, cover, perform);
			}
			
			int answer = getAmount();
			for(int i = 0; i < M; i++) {
				nowA[0] += dr[dA[i]];
				nowA[1] += dc[dA[i]];
				nowB[0] += dr[dB[i]];
				nowB[1] += dc[dB[i]];
				answer += getAmount();
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static int getAmount() {
		List<Integer> alist = new ArrayList<>();
		List<Integer> blist = new ArrayList<>();
		
		for(int i = 0; i < arr.length; i++) {
			BC bc = arr[i];
			if(bc.cover >= dist(nowA[0], nowA[1], bc.row, bc.col)) alist.add(i);
			if(bc.cover >= dist(nowB[0], nowB[1], bc.row, bc.col)) blist.add(i);
		}
		
		int result = 0;
		if(alist.isEmpty() && blist.isEmpty()) return 0;
		
		if(alist.isEmpty()) {
			for(int idx : blist) result = Math.max(arr[idx].perform, result);
			return result;
		}
		
		if(blist.isEmpty()) {
			for(int idx : alist) result = Math.max(arr[idx].perform, result);
			return result;
		}
		
		for(int ia : alist) {
			for(int ib : blist) {
				int amount = arr[ia].perform + arr[ib].perform;
				if(ia == ib) amount /= 2;
				result = Math.max(amount, result);
			}
		}
		
		return result;
	}
	
	public static int dist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
