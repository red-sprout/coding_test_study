package year2024.month10.first;

import java.io.*;
import java.util.*;

public class Main_bj_1592_영식이와친구들 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] count = new int[N];
		count[0] = 1;
		int pos = 0;
		int answer = 0;
		outer : while(true) {
			for(int i = 0; i < N; i++) {
				if(count[i] == M) break outer;
			}
			answer++;
			if(count[pos] % 2 == 1) {
				pos = (pos + L) % N;
				count[pos]++;
			} else {
				pos = (pos + N - L) % N;
				count[pos]++;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
