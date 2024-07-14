package src.week1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int n = Integer.parseInt(bf.readLine());
		
		int result = 0;
		
		boolean[][] arr = new boolean[100][100];
		//여기서 질문 Boolean 타입과 boolean 타입의 차이점을 뭘까요 ~~???
		
		
		
		for(int i = 0 ; i < n; i++) {		
			String str =bf.readLine();
			
			st = new StringTokenizer(str) ;
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j = x ; j < x+10 ; j ++) {
				for(int p = y; p < y+10; p ++) {
					arr[p][j]=true;
				}
			}
		}
		
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0; j < 100; j++) {
				if(arr[i][j]==true) {
					result += 1;
				}
			}
		}
		System.out.println(result);
	}
}
