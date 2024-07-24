package BOJ.searchAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	/*
	 * 백준 no.1759 : 암호 만들기
	 *  가능한 모든 조합을 탐색하여 조건에 맞는 암호 생성 => 백트래킹 알고리즘
	 */
	
	// 알바벳의 갯수
	static int l;
	// 암호의 자릿수
	static int c;
	// 입력받은 알파벳 배열
	static char[] alphabets;
	// 암호 배열
	static char[] password;
	// 방문 배열
	static boolean[] visited;
	// StringBuilder
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		alphabets = new char[c];
		password = new char[l];
		visited = new boolean[c];
		
		st = new StringTokenizer(br.readLine());
		
		// 알파벳 배열에 입력
		for(int i = 0; i < alphabets.length; i++) {
			alphabets[i] = (st.nextToken()).charAt(0);
		}
		// 사전순 정렬
		Arrays.sort(alphabets);
		
		sb = new StringBuilder();
		
		//암호 생성
		generatePassword(0, 0, 0, 0);
		
		// StringBuilder 출력
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}
	
	/**
	 * 암호 생성하는 재귀함수
	 * @param start : 알파벳 배열의 위치
	 * @param depth : 재귀함수의 깊이
	 * @param vowelCount : 모음의 갯수
	 * @param consonantCount : 자음의 갯수
	 */
	public static void generatePassword(int start, int depth, int vowelCount, int consonantCount) {
		// 종료 조건 : depth 가 l 에 이르렀을 때
		if(depth == l) {
			// 조건 검사 실시
			if(vowelCount >= 1 && consonantCount >= 2) {
				// 통과 시 StringBuilder 에 추가
				sb.append(password).append("\n");
			}
			return;
		}
		// 재귀 단계
		for(int i = start; i < c; i++) {
			// 방문 여부 확인
			if(!visited[i]) {
				// 미방문 시
				// 방문 처리
				visited[i] = true;
				char currAlphabet = alphabets[i];
				// 암호 배열에 현재 알파벳 추가
				password[depth] = currAlphabet;
				// 대상 알파벳이 모음인 경우
				if(isVowel(currAlphabet)) {
					generatePassword(i + 1, depth + 1 , vowelCount + 1, consonantCount);
				} else {// 자음일 경우
					generatePassword(i + 1, depth + 1 , vowelCount, consonantCount + 1);
				}
				// 재귀함수 이행 후에는 방문 여부 초기화
				visited[i] = false;
			}
		}
	}
	
	/**
	 * 모음 조건 체크하는 메소드
	 * @param 알파벳
	 * @return 해당 알파벳이 모음인지 여부
	 */
	public static boolean isVowel(char alphabet) {
		return alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u';
	}
}
