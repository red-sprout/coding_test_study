package study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//12:40
public class N_Queen9663 {
	
	static int N, result = 0, chess[];
	// N은 체스판의 크기와 퀸 N개
	// result는 출력을 위한 변수
	//chess의 인덱스를 열, 인덱스값을 행 이라 생각한다. 
	//어차피 한 열에 퀸은 한개밖에 놓지 못하고 인덱스 값을 어느 위치에 해당 열의 몇행에 놓았는가를 표시
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		chess = new int[N];
		
		dfs(0); //깊이 우선 탐색
		
		System.out.println(result);
	}
	
	public static void dfs(int row) {
		// row는 몇번째 열에 놓으려고 하는가를 의미
		if(row == N) {//row번째 열로 재귀 호출이 되었는데 N과 같을 경우 유효한 체스판 하나 완성
			result++;
			return;
		}
		
		//현제 row에 퀸을 가능한 모든 행 위치에 배치해보는 반복문
		for(int i = 0; i < N; i++) {
			chess[row] = i; // 현제 row에 퀸을 i번째 행에 배치
			//현재 배치가 유요한지 검사하는 메소드 호출
			if(check(row)) {
				//유효하다면 다음 열로 이동하기 위해 재귀함수 호출
				dfs(row + 1);
			}
		}
	}
	
	public static boolean check(int row) {
		
		// 현제 열 이전에 모든 열 i에 대해 검사하는 반복문
		for(int i = 0; i < row; i++) {
			
			//같은 행에 배치된 경우 
			if(chess[row] == chess[i]) return false;
			
			//이 전 열들 퀸의 대각선에 배치된 경우
			if(row - i == Math.abs(chess[row] - chess[i])) return false;
		}
		return true;
	}
}
//14:10
