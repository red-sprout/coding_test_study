package year2024.month06.day10;
// 친구 네트워크
import java.io.*;
import java.util.*;

public class BOJ4195 {
	private static int[] parent;
	private static int[] level;
	private static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		for(int t = 0; t < test; t++) {
			int f = Integer.parseInt(br.readLine());
			
			parent = new int[f * 2];
			level = new int[f * 2];
			map.clear();
			
			for(int i = 0; i < f * 2; i++) {
				parent[i] = i;
				level[i] = 1;
			}
			
			int idx = 0;
			for(int i = 0; i < f; i++) {
				String[] nameArr = br.readLine().split(" ");
				if (!map.keySet().contains(nameArr[0])) {
					map.put(nameArr[0], idx++);
				}
				
				if (!map.keySet().contains(nameArr[1])) {
					map.put(nameArr[1], idx++);
				} 
				
				sb.append(findParent(map.get(nameArr[0]), map.get(nameArr[1]))).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	public static int getParent(int x) {
		if (x == parent[x]) return x;
		return parent[x] = getParent(parent[x]);
	}
	
	public static int findParent(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		
		if(x != y) {
			parent[y] = x;
			level[x] += level[y];
		}
		
		return level[x];
	}
}
