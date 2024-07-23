package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * ****** N과 M (1) ******
 * 
 * <문제>
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 
 * <입력>
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 * 
 * <출력>
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다
 */

public class BOJ15649 {

	private static int N, M;
	private static int[] result;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//첫째 줄 N,M
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		
		 result = new int[M];
		 visited = new boolean[N + 1];
		
		br.close();
		back(0);
	}
	
	private static void back(int depth) {
		 // 길이가 M인 수열을 찾은 경우 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                back(depth + 1);
                visited[i] = false;
            }
        }	
	}
}
