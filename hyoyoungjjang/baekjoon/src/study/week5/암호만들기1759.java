package study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//02:20
public class 암호만들기1759 {
	
	static StringBuilder sb = new StringBuilder();
	
	static int L, C;
	
	static char[] alphabet; //암호가 될 알파벳을 받아줄 배열
	
	static char[] result; //완성된 암호를 담아줄 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		
		C = Integer.parseInt(st.nextToken());	 
		
		alphabet = new char[C];
		
		result = new char[L];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabet); // 작은순으로 출력을 위해 오름차순 정렬
		
		makePassword(0, 0); //암호 만들기 
		
		System.out.println(sb);
		
	}
	
	
	public static void makePassword(int alIndex, int passLength) { 
					        // 넣어줄 알파벳 인데스와  백트래킹 리턴 조건에 사용될 암호의 길이
		if(passLength == L) { //암호 한 개 완성이 되었을 때	
			if(checkPassword(result)) { // 모음 자음 조건 확인		
				for(char res : result) {
					sb.append(res);
				}	
				sb.append("\n");
			}	
			return;
		}
	
		for(int i = alIndex; i < C; i++) {
			result[passLength] = alphabet[i]; //현제암호의 길이에 i번째 알파벳을 넣어줌
			makePassword(i + 1, passLength + 1);
		}
		
	}
	
	//완성된 하나의 암호에 최소 한개의 모음과
	//두개의 자음이 있는지 확인하는 메서드
	public static boolean checkPassword(char[] result) {
		
		int vowel = 0; //모음
		int consonant = 0; //자음
		
		for(int i = 0; i < result.length; i++) {
			char c = result[i];
			
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				// 모음일 경우
				vowel++;
			} else {
				//자음일 경우
				consonant++;
			}
		}
		
		return vowel >= 1 && consonant >= 2;
	}
}
//04:00