package year2024.month05.day16;
// 전화번호 등록
import java.io.*;
import java.util.*;

class Node {
	Map<Character, Node> childNode = new HashMap<>();
	boolean isEnd = false;
}

class Trie {
	Node root = new Node();
	
	public void add(String str) {
		Node node = this.root;
		for(int i = 0; i < str.length(); i++) {
			node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
		}
		node.isEnd = true;
	}
	
	public boolean search(String str) {
		Node node = this.root;
		for(int i = 0; i < str.length(); i++) {
			if(node.isEnd) break;
			if(!node.childNode.containsKey(str.charAt(i))) return false;
			node = node.childNode.get(str.charAt(i));
		}
		return true;
	}
}

public class BOJ5052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 0; t < test; t++) {
			int n = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			
			boolean isPossible = true;
			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				if(trie.search(str)) {
					isPossible = false;
				} else {
					trie.add(str);
				}
			}
			
			if(isPossible) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
