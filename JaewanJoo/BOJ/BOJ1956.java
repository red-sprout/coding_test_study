import java.io.*;
import java.util.*;

// [BOJ] 운동 / 골드 4 / 30분
// 알고리즘 분류 : 그래프 이론 / 최단 경로 / 플로이드–워셜
public class Main {
	private static int[][] city;
	private static int v, e;
	private static final int INF = 5000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		city = new int[v + 1][v + 1];
		
		for(int i = 0; i <= v; i++) {
			for(int j = 0; j <= v; j++) {
				city[i][j] = INF;
			}
		}
		
		int a, b, c;
		int cycle = INF;
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			city[a][b] = c;
		}
		
		for(int k = 0; k <= v; k++) {
			for(int i = 0; i <= v; i++) {
				for(int j = 0; j <= v; j++) {
					if(city[i][j] < city[i][k] + city[k][j]) continue;
					city[i][j] = city[i][k] + city[k][j];
				}
			}
		}
		
		for(int i = 0; i <= v; i++) {
			cycle = Math.min(cycle, city[i][i]);
		}
		
		if(cycle == INF) {
			System.out.println(-1);
		} else {
			System.out.println(cycle);
		}
		
		br.close();
	}
}
