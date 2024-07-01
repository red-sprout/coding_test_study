package codingTestPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 수찾기1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> nMap = new HashMap<Integer, Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nMap.put(Integer.parseInt(st.nextToken()), 0);
		}
		
		int m = Integer.parseInt(br.readLine());
	
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(nMap.containsKey(num)) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}
		
		
		
		bw.flush();
		bw.close();
	}
}
