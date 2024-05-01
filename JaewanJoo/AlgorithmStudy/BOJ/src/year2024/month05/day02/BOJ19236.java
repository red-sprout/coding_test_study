package year2024.month05.day02;
// 청소년 상어
import java.io.*;
import java.util.*;

public class BOJ19236 {
	private static Fish[][] fish = new Fish[4][4];
	private static int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dc = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	
	private static class Fish {
		int no;
		int rot;
		
		Fish(int no, int rot) {
			this.no = no;
			this.rot = rot;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				int no = Integer.parseInt(st.nextToken());
				int rot = Integer.parseInt(st.nextToken());
				fish[i][j] = new Fish(no, rot);
			}
		}
		
		br.close();
	}
}
