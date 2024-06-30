package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] paper = new int[100][100];
		
		int num = Integer.parseInt(br.readLine()); //색종이 개수
		
		int area = 0; //넓이
		
		for(int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int n = x; n < x + 10; n++) {
				for(int m = y; m < y + 10; m++) {
					paper[n][m] = 1;
				}
			}
		}
		
		for(int i=0;i<100;i++) {
            for(int j=0;j<100;j++) {
                if(paper[i][j]==1) {
                    area++;
                }
            }
        }
		 System.out.println(area);
		 br.close();
		
	}
}
