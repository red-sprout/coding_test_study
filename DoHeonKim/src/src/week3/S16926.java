package src.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S16926 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		
		
		//배열세팅
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = Math.min(n, m);
		
		//돌리기
		for(int i = 0 ; i < r ; i ++) {
			arr = rotation(arr, min, n , m);
		}
		
		printArr(arr, n, m);
	}
	
	static void printArr(int[][] arr, int n, int m) {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0; j < m ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
    static int[][] rotation(int[][] arr, int min, int n, int m) {
    	
    	for(int t=0; t<min/2; t++) { // 회전 시킬 그룹의 갯수 구하기
    		int x = t;
    		int y = t;
    		
    		int temp = arr[x][y]; // 마지막에 넣을 값 미리 빼놓음
    		
    		int idx = 0; // 우, 하, 좌, 상 방향으로 이동하며 반시계 방향으로 값 넣을 인덱스
    		while(idx < 4) { // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는 연산을 차례로 수행
    			int nx = x + dx[idx];
    			int ny = y + dy[idx];
    			
    			// 범위 안이라면
    			if(nx < n-t && ny < m-t && nx >= t && ny >= t) {
    				arr[x][y] = arr[nx][ny];
    				x = nx;
    				y = ny;
    			} 
    			// 범위를 벗어났다면 다음 방향으로 넘어감
    			else {
    				idx++;
    			}
    			
    		}
    		
    		arr[t+1][t] = temp; // 빼 놓은 값 넣어 줌
    	}
    	return arr;
    }

}
