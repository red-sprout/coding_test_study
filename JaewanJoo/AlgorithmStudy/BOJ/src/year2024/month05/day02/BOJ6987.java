package year2024.month05.day02;
//월드컵
import java.io.*;
import java.util.*;

public class BOJ6987 {
	private static int[][] ex = new int[6][3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					ex[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		br.close();
	}
}
