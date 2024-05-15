// 가장 가까운 공통 조상
import java.io.*;
import java.util.*;

public class BOJ3584 {
	private static class Node {
		int data;
		int level;
		Node parent;
		List<Node> childNode = new LinkedList<>();
		
		Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return "data : " + data + "\nlevel : " + level;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 0; t < test; t++) {
			int n = Integer.parseInt(br.readLine());
			Node[] tree = new Node[n + 1];
			for(int i = 0; i <= n; i++) {
				tree[i] = new Node(i);
			}
			
			for(int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				tree[child].parent = tree[parent];
				tree[parent].childNode.add(tree[child]);
			}
			
			for(Node node : tree) {
				if(node.parent == null) {
					initLevel(node);
				}
			}
			
			st = new StringTokenizer(br.readLine());
			Node a = tree[Integer.parseInt(st.nextToken())];
			Node b = tree[Integer.parseInt(st.nextToken())];
			
			sb.append(nca(a, b)).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	public static void initLevel(Node node) {
		node.level = (node.parent == null) ? 0 : node.parent.level + 1;
		for(Node child : node.childNode) {
			initLevel(child);
		}
	}
	
	public static int nca(Node a, Node b) {
		while(a.level != b.level) {
			if(a.level > b.level) {
				a = a.parent;
			} else {
				b = b.parent;
			}
		}
		
		while(a.data != b.data) {
			a = a.parent;
			b = b.parent;
		}
		
		return a.data;
	}
}
