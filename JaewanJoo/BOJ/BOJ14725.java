import java.io.*;
import java.util.*;

// [BOJ] 개미굴 / 골드 3 / 40분
// 알고리즘 분류 : 자료 구조 / 문자열 / 트리 / 트라이
public class Main {
	private static StringBuilder sb = new StringBuilder();
	
	static class Node {
		Map<String, Node> child = new TreeMap<>();
		boolean end;
	}
	
	static class Trie {
		Node root = new Node();
		void insert(String[] arr) {
			Node node = this.root;
			for(int i = 0; i < arr.length; i++) {
				if(!node.child.containsKey(arr[i])) {
					node.child.put(arr[i], new Node());
				}
				node = node.child.get(arr[i]);
			}
			node.end = true;
		}
		void search(int depth) {
			search(depth, root);
		}
		void search(int depth, Node node) {
			if(node.end == true) {
				return;
			}
			
			for(String key : node.child.keySet()) {
				for(int i = 0; i < depth; i++) {
					sb.append("--");
				}
				sb.append(key).append("\n");
				search(depth + 1, node.child.get(key));
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();
        StringTokenizer st;
        
        int n;
        int k;
        String[] arr;
        
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	k = Integer.parseInt(st.nextToken());
        	arr = new String[k];
        	for(int j = 0; j < k; j++) {
        		arr[j] = st.nextToken();
        	}
        	trie.insert(arr);
        }

        trie.search(0);
        System.out.print(sb);
        br.close();
    }
}
