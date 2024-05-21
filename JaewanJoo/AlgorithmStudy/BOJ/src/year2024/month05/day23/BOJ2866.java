package year2024.month05.day23;

import java.io.*;
import java.util.*;

class Node {
	Map<Character, Node> children = new HashMap<>();
	boolean isEnd = false;
}

class Trie {
	Node root = new Node();
	
	public void insert(String key) {
		Node node = this.root;
		for(int i = 0; i < key.length(); i++) {
			node = node.children.computeIfAbsent(key.charAt(i), k -> new Node());
		}
		node.isEnd = true;
	}
	
	public boolean search(String key) {
		Node node = this.root;
		for(int i = 0; i < key.length(); i++) {
			if(!node.children.containsKey(key.charAt(i))) return false;
		}
		return node.isEnd;
	}
	
	public void delete() { 
		Map<Character, Node> map = new HashMap<>();
		for(char c : this.root.children.keySet()) {
			map.put(c, this.root.children.get(c));
		}
		this.root.children = map;
	}
}

public class BOJ2866 {
	private static int strCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		Trie trie = new Trie();
		for(int i = 0; i < r; i++) {
			trie.insert(br.readLine());
		}
		
		int cnt = 0;
		boolean isOver = false;
		while(cnt < r - 1) {
			strCnt = 0;
			dfs(trie.root);
			isOver = (strCnt != r);
			if(isOver) break;
			trie.delete();
			cnt++;
		}
		
		System.out.println(cnt);
		br.close();
	}
	
	public static void dfs(Node node) {
		Deque<Node> stack = new LinkedList<>();
		stack.add(node);
		
		while(!stack.isEmpty()) {
			Node now = stack.pop();
			if(now.isEnd) {
				strCnt++;
				continue;
			}
			
			for(char c : now.children.keySet()) {
				stack.add(now.children.get(c));
			}
		}
	}
}
