package src.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		HashMap<String, String> map = new HashMap<>();
		
		st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		//value까지 넣게되면 시간초과남
		for(int i = 0; i < n; i++) {
			String str = bf.readLine();
			map.put(str, null);
		}
		
		int result = 0;
		
		for(int i = 0; i < m; i++) {
			if(map.containsKey(bf.readLine())) {
				result++;
			}
		}
		System.out.println(result);
	}

}
