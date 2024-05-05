import java.io.*;
import java.util.*;

public class Main {
	private static int n, m;
	private static int[] arr;
	private static Set<int[]> set;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		set = new TreeSet<>((o1, o2) -> {
			int idx = 0;
			while(true) {
				if(idx == m) return 0;
				if(o1[idx] != o2[idx]) return o1[idx] - o2[idx];
				idx++;
			}
		});
		
		for(int[] i : set) {
			System.out.println(Arrays.toString(i));
		}
		
		int[] tmp = new int[m];
		dfs(0, tmp);
		
		for(int[] ele : set) {
			for(int i : ele) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
    
    public static void dfs(int ansIdx, int[] tmp) {
    	if(ansIdx == m) {
    		int[] result = tmp.clone();
    		set.add(result);
    		return;
    	}
    	
    	for(int i = 0; i < n; i++) {
    		tmp[ansIdx] = arr[i];
    		dfs(ansIdx + 1, tmp);
    	}
    }
}