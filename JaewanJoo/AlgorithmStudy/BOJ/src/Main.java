import java.io.*;
import java.util.*;

public class Main {
	private static int n, k;
	private static int[] arr;
	private static boolean[] visited;
	private static Set<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		arr = new int[n];
		set = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		visited = new boolean[n];
		StringBuilder sb = new StringBuilder();
		dfs("", 0);
		
		System.out.println(set.size());
		br.close();
	}
	
	public static void dfs(String str, int cnt) {
		if(cnt == k) {
			set.add(str);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(str + arr[i], cnt + 1);
			visited[i] = false;
		}
	}
}