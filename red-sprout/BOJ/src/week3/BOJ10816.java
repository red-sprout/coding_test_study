package week3;
// 숫자 카드 2
import java.io.*;
import java.util.*;

public class BOJ10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int card = Integer.parseInt(st.nextToken());
			map.put(card, map.getOrDefault(card, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(card, 0)).append(" ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
