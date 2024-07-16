package src.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1074 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		if(n<1) {
			int[][] arr = new int[2][2];
			int count = 0 ;
			for(int i = 0 ; i < 2; i++) {
				for(int j = 0 ; j < 2; j++) {
					arr[i][j]=count++;
				}
			}
		}
		
	}

}
