package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//14:30
public class N과M15649 {
	
	static int n, m;
	
	static StringBuilder sb = new StringBuilder();
	
	//출력을 위한 배열 int
	static int[] intArr;
	
	//현제 방문한 노드 추적을 위한 배열 boolean
	static boolean[] boolArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 n = Integer.parseInt(st.nextToken());
		
		 m = Integer.parseInt(st.nextToken());
		
		intArr = new int[m];
		
		boolArr = new boolean[n];
		
		dfs(0);
		
		br.close();
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		
		if(depth == m) {
			for(int i = 0; i < intArr.length; i++) {
				sb.append(intArr[i]+ " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++){
			//i에 해당하는 노드 방문여부확인 false 일대 진입
			if(!boolArr[i]) {
				boolArr[i] = true; // 현제 있는 노드 true로 변경
				intArr[depth] = i + 1; // i는 인덱스값이기에 + 1해서 숫자 저장
				dfs(depth + 1); //다음 깊이 노드 재귀호출
				boolArr[i] = false; // 재귀호출 리턴되서 돌아오면서 i인덱스에있는 노드 false로 되돌림 
			}
		}	
	}
}
//16:00