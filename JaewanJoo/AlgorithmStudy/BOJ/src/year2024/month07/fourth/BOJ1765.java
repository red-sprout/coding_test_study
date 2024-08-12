package year2024.month07.fourth;

import java.io.*;
import java.util.*;

public class BOJ1765 {
	static int[] friend;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] check = new int[n + 1];
		friend = new int[n + 1];
		for(int i = 0; i <= n ; i++) {
			friend[i] = i;
			check[i] = -1;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			if(c == 'F') {
				unionParent(p, q);
			} else {
				if(check[p] == -1) check[p] = 0;
				if(check[q] == -1) check[q] = 0;
				if(check[p] > check[q]) {
					check[q] = check[p] + 1;
				} else {
					check[p] = check[q] + 1;
				}
			}
		}
		
		for(int i = 1; i <= n - 1; i++) {
			for(int j = i + 1; j <= n; j++) {
				if(check[i] == -1 || check[j] == -1) continue;
				if(Math.abs(check[i] - check[j]) == 2) {
					unionParent(i, j);
				}
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = 1; i <= n; i++) {
			set.add(findParent(i));
		}
		
		System.out.println(set.size());
		br.close();
	}
	
	public static int findParent(int x) {
		if(x == friend[x]) return x;
		return friend[x] = findParent(friend[x]);
	}
	
	public static void unionParent(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		if(x > y) friend[x] = y;
		else friend[y] = x;
	}
}
