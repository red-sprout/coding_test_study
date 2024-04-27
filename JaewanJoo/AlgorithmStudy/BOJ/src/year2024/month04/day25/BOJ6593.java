package year2024.month04.day25;

import java.io.*;
import java.util.*;

public class BOJ6593 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<int[]> q = new LinkedList<>();
		
		int[] dl = {-1, 1, 0, 0, 0, 0};
		int[] dm = {0, 0, -1, 1, 0, 0};
		int[] dn = {0, 0, 0, 0, -1, 1};
		
		while(true) {
			q.clear();
			String[] cases = br.readLine().split(" ");
			
			int l = Integer.parseInt(cases[0]);
			int m = Integer.parseInt(cases[1]);
			int n = Integer.parseInt(cases[2]);
			
			if(l == 0 && m == 0 && n == 0) break;
			
			int[][][] time = new int[l][m][n];
			char[][][] map = new char[l][m][n];
			int[] end = null;
			
			for(int i = 0; i < l; i++) {
				for(int j = 0; j < m; j++) {
					String row = br.readLine();
					for(int k = 0; k < n; k++) {
						time[i][j][k] = -1;
						map[i][j][k] = row.charAt(k);
						
						if(map[i][j][k] == 'S') {
							q.add(new int[] {i, j, k});
							time[i][j][k] = 0;
						} else if(map[i][j][k] == 'E') {
							end = new int[] {i, j, k};
						}
					}
				}
				br.readLine();
			}
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				if(map[now[0]][now[1]][now[2]] == 'E') break;
				
				for(int i = 0; i < 6; i++) {
					int nextl = now[0] + dl[i];
					int nextm = now[1] + dm[i];
					int nextn = now[2] + dn[i];
					
					if(nextl < 0 || nextl >= l) continue;
					if(nextm < 0 || nextm >= m) continue;
					if(nextn < 0 || nextn >= n) continue;
					if(map[nextl][nextm][nextn] == '#') continue;
					if(time[nextl][nextm][nextn] != -1) continue;
					
					time[nextl][nextm][nextn] = time[now[0]][now[1]][now[2]] + 1;
					q.add(new int[] {nextl, nextm, nextn});
				}
			}
			
			int x = time[end[0]][end[1]][end[2]];
			if(x == -1) {
				sb.append("Trapped!").append("\n");
			} else {
				sb.append("Escaped in ").append(x).append(" minute(s).").append("\n");
			}
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
