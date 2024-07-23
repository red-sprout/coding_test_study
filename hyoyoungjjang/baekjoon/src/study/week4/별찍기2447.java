package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//18:40
public class 별찍기2447 {
	
	static char[][] starArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		starArr = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0;  j < n; j++) {
				starArr[i][j] = '*';
			}
		}
		
		function(0, 0, n); 
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(starArr[i][j]);
			}
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
	
	public static void function(int x, int y, int n) {
		
		if(n == 1) return;
		
		int newN = n / 3;
		
		//주어진 크기 newN의 가운데 작은 정사각형 영역의 시작 위치 즉 공백부분
		for(int i = x + newN; i < x + 2 * newN; i++) { 
			for(int j = y + newN; j < y + 2 * newN; j++) {
				starArr[i][j] = ' ';
			}
		}
		
		for(int i = 0;  i < 3; i++) { 
			for(int j = 0; j < 3; j++) {
				function(x + i * newN, y + j * newN, newN); 
			}
		}	
	}	
}
