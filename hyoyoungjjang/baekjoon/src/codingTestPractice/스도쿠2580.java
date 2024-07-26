package codingTestPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//15:00
public class 스도쿠2580 {
	
	//9x9스도쿠 판
	static int[][] arr = new int[9][9]; 
	//모든 칸이 채워진지 확인하는 변수
	static boolean finish = false;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//스도쿠판 채우기
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Sudoku(0, 0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0;  j < 9; j++) {
				sb.append(arr[i][j] + " "); 
			}
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
		
	}
	
	//row, col 각 좌표 하나하나씩 검사
	public static void Sudoku(int row, int col) {
		
		//해당 열을 모두 채웠을 경우 다음 열 이동
		if(col == 9) {
			Sudoku(row + 1, 0);
			return;
		}
		
		//모든 열과 행이 채워진경우 리턴
		if(row == 9) {
			finish = true;
			return;
		}
		
		//해당 위치 값이 0이라면 1부터  9까지 중 가능한 수 탐색
		if(arr[row][col] == 0) {
			
			for(int i = 1; i <= 9; i++) {
				
				if(check(row, col, i)) { //가로 줄에 중복값 있나 확인
					arr[row][col] = i; //모든 확인이 끝나면 해당 빈칸에 i값을 삽입
					Sudoku(row, col + 1); //해당열의 다음 칸으로 재귀 호출
					
					if(finish) { //만약 모든 수가 삽입이 완료된경우 finish는 true이기때문에 
								// 호출한 메서드로 돌아오면서 여기에서 전부 리턴당하여 메서드가 끝난다.
						return;
					}
					
					arr[row][col] = 0; //되돌리기
				}
			}	
			return; // 모든 숫자를 시도하였으나 유효하지 않은 경우 리턴
		}
		
		Sudoku(row, col + 1); //빈칸이 아닐 경우 다음 칸으로 이동
			
	}
	
	public static boolean check(int row, int col, int value) {
		//같은 열에 있는 숫자중 겹치는 숫자가 있는지 확인
		for(int i = 0; i < 9; i++) {
			if(arr[row][i] == value) {
				return false; //있다면 false반환
			}
		}
		
		//같은 행에있는 숫자중 중복값있나 확인
		for(int i = 0; i < 9; i++) {
			if(arr[i][col] == value) {
				return false; //있다면  false반환
			}
		}
		
		//9x9의 스도쿠판을 정사각형9개로 나눴을때 3x3 크기의 정사각형 9개가 생긴다
		// 해당 row, col 좌표가 있는 구역의 시작 좌표 구하기
		int blockR = (row / 3) * 3;
		int blockC = (col / 3) * 3;
		
		//해당 구역에서 중복값있나확인
		for(int i = blockR; i < blockR + 3; i++) {
			for(int j = blockC; j < blockC + 3; j++) {
				if(arr[i][j] == value) {
					return false;
				}
			}
		}
		
		//모든 확인이 유효하다면 true 반환
		return true;
	}
}
