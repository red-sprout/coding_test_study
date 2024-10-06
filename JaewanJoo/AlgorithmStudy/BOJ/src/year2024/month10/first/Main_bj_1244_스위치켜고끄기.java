package year2024.month10.first;

import java.io.*;
import java.util.*;

public class Main_bj_1244_스위치켜고끄기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		boolean[] light = new boolean[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			light[i] = st.nextToken().equals("1");
		}
		int q = Integer.parseInt(br.readLine());
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int g = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			switch(g) {
			case 1:
				for(int j = num; j <= n; j += num) {
					light[j] = !light[j];
				}
				break;
			case 2:
				light[num] = !light[num];
				for(int j = 1; ; j++) {
					if(num - j < 1 || num + j > n || light[num + j] != light[num - j]) break;
					light[num + j] = !light[num + j];
					light[num - j] = !light[num - j];
				}
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(light[1] ? 1 : 0);
		for(int i = 2; i <= n; i++) {
			sb.append((i - 1) % 20 == 0 ? "\n" : " ");
			sb.append(light[i] ? 1 : 0);
		}
		System.out.println(sb.toString());
		br.close();
	}
}
