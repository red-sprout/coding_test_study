import java.io.*;
import java.util.*;

// [BOJ]  사이클 게임 / 골드 4 / 15분
// 알고리즘 분류 : 자료 구조 / 분리 집합
public class Main {
	private static int n, m;
	private static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}

		int x, y;
		boolean flag = false;
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if(isUnion(x, y)) {
				flag = true;
				System.out.println(i);
				break;
			}
			
			unionParent(x, y);
		}
		
		if(!flag) {
			System.out.println(0);
		}
		br.close();
	}
	
	public static int getParent(int x) {
		if(x == parent[x]) return x;
		return parent[x] = getParent(parent[x]);
	}
	
	public static void unionParent(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		if(x > y) parent[x] = y;
		else parent[y] = x;
	}
	
	public static boolean isUnion(int x, int y) {
		return getParent(x) == getParent(y);
	}
}
