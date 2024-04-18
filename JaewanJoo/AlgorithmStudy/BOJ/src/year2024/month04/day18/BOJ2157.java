package year2024.month04.day18;

import java.io.*;
import java.util.*;

public class BOJ2157 {
	private static int maxScore = 0;
	private static int[] dice = new int[11];
	private static int[] order = new int[11];
	private static Node[] horses = new Node[5];
	private static Node start;
	
	static class Node {
		int score;
		boolean isEnd;
		boolean isExist;
		boolean isBlue;
		Node next;
		Node blueNext;
		
		Node(int score) {
			this.score = score;
			this.isExist = false;
		}
		
		Node add(int score) {
			Node next = new Node(score);
			this.next = next;
			return next;
		}
		
		static Node get(Node start, int score) {
			for(Node n = start; ; n = n.next) {
				if(n == null) return null;
				if(n.score == score) return n;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		init();
		dfs(1);
		System.out.println(maxScore);
		br.close();
	}
	
	public static void dfs(int depth) {
		if(depth >= 11) {
			maxScore = Math.max(maxScore, game());
			return;
		}
		
		for(int i = 1; i <= 4; i++) {
			order[depth] = i;
			dfs(depth + 1);
		}
	}
	
	public static int game() {
		Arrays.fill(horses, start);
		
		
	}
	
	public static void init() {
		start = new Node(0);
		Node n = start;
		
		for(int i = 2; i <= 40; i += 2) {
			n = n.add(i);
		}
		
		Node end = n.add(0);
		end.isEnd = true;
		end.next = end;
		
		Node cross = new Node(25);
		
		n = cross.add(30);
		n = n.add(35);
		n.next = Node.get(start, 40);
		
		n = Node.get(start, 10);
		n = n.blueNext = new Node(13);
		n = n.add(16);
		n = n.add(19);
		n.next = cross;
		
		n = Node.get(start, 20);
		n = n.blueNext = new Node(22);
		n = n.add(24);
		n.next = cross;
		
		n = Node.get(start, 30);
		n = n.blueNext = new Node(28);
		n = n.add(27);
		n = n.add(26);
		n.next = cross;
	}
}
