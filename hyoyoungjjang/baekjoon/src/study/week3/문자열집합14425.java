package study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//1:53
public class 문자열집합14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//해쉬맵은 중복키값을 허용하지 않는 점을 이용하여 풀면된다.
		HashMap<String, Integer> hm = new HashMap<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			
			hm.put(s, null);
		}
		
		int result = 0;
		
		for(int i = 0; i < m; i++) {
			
			String s = br.readLine();	
			
			if(hm.containsKey(s)) {
				result++;
			}
		}
		System.out.println(result);
	}
}
//2:00