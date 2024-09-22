package year2024.month09.third;

import java.io.*;
import java.util.*;

public class Main_bj_2605_줄세우기 {
	static class Node {
		int id;
		Node next;
		Node(int id) {
			this.id = id;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Node head = new Node(0);
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			int pos = i - 1 - Integer.parseInt(st.nextToken());
			Node prev = head;
			Node node = new Node(i);
			for(int j = 0; j < pos; j++) {
				prev = prev.next;
			}
			node.next = prev.next;
			prev.next = node;
		}
		for(Node node = head.next; node != null; node = node.next) {
			sb.append(node.id).append(" ");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
