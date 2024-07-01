package study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이2563 {
	static final int[][] iArr = new int[100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int sum = 0;
	
		for(int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			drawingPaper(x, y);
		}
		
		for(int i = 0; i < iArr.length; i++) {
			for(int j = 0; j < iArr[i].length; j++) {
				if(iArr[i][j] == 1) {					
					sum += 1;
				}
			}
		}
	
		System.out.println(sum);
		
	}
	
	
	
	public static void drawingPaper(int x, int y) {
		
		for(int i = x; i <= x+9; i++) {
			for(int j = y; j <= y+9; j++) {
				iArr[i][j] = 1;		
			}
		}
	}

}
