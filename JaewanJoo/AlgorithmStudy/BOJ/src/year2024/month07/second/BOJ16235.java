package year2024.month07.second;
// 나무 재테크
import java.io.*;
import java.util.*;

public class BOJ16235 {
	private static int n, m, k;
	private static int[][] A, feed;
	private static List<Tree> forest;
	private static Queue<Tree> q;
	
	private static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	private static class Tree implements Comparable<Tree>{
		int row;
		int col;
		int age;
		boolean isDead;
		
		Tree(int row, int col, int age) {
			this.row = row;
			this.col = col;
			this.age = age;
			this.isDead = false;
		}
		
		@Override
		public int compareTo(Tree t) {
			return this.age - t.age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		n = Integer.parseInt(info[0]);
		m = Integer.parseInt(info[1]);
		k = Integer.parseInt(info[2]);
		
		A = new int[n][n];
		feed = new int[n][n];
		forest = new ArrayList<>();
		q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			info = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				feed[i][j] = 5;
				A[i][j] = Integer.parseInt(info[j]);
			}
		}
		
		for(int i = 0; i < m; i++) {
			info = br.readLine().split(" ");
			int row = Integer.parseInt(info[0]) - 1;
			int col = Integer.parseInt(info[1]) - 1;
			int age = Integer.parseInt(info[2]);
			forest.add(new Tree(row, col, age));
		}
		
		Collections.sort(forest);
		
		for(int i = 0; i < k; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		int size = 0;
		for(Tree t : forest) {
			if(!t.isDead) size++;
		}
		
		System.out.println(size);
		br.close();
	}
	
	public static void spring() {
		for(Tree t : forest) {
			if(t.isDead) continue;
			if(feed[t.row][t.col] < t.age) {
				t.isDead = true;
				q.add(t);
			} else {
				feed[t.row][t.col] -= t.age;
				t.age++;
			}
		}
	}
	
	public static void summer() {
		while(!q.isEmpty()) {
			Tree t = q.poll();
			feed[t.row][t.col] += t.age / 2;
		}
	}
	
	public static void fall() {
		List<Tree> list = new ArrayList<>();
		for(Tree t : forest) {
			if(t.isDead || t.age % 5 != 0) continue;
			for(int i = 0; i < 8; i++) {
				int nr = t.row + dr[i];
				int nc = t.col + dc[i];
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				list.add(new Tree(nr, nc, 1));
			}
		}
		
		for(Tree t : forest) {
			if(t.isDead) continue;
			list.add(t);
		}
		
		forest = list;
	}
	
	public static void winter() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				feed[i][j] += A[i][j];
			}
		}
	}
}
