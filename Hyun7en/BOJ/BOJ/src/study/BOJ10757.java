package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/* 
 * ****** 큰 수 A + B ******
 * 
 * <문제>
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * 
 * <입력>
 * 첫째 줄에 A와 B가 주어진다. (0 < A,B < 10^10000)
 * 
 * <출력>
 * 첫째 줄에 A+B를 출력한다.
 * 
 */
public class BOJ10757 {
	
	// 1안
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		BigInteger A = new BigInteger(st.nextToken());
//		BigInteger B = new BigInteger(st.nextToken());
//		
//		A = A.add(B);
//		
//		System.out.println(A);
//		
//	}
	
	// 2안
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a1 = st.nextToken();
		String b1 = st.nextToken();
		
		int maxLength = Math.max(a1.length(), b1.length());
		int[] A = new int[maxLength + 1];
		int[] B = new int[maxLength + 1];
		
		//초기화
		for(int i = a1.length() -1, idx = 0; i >= 0; i--,idx++) {
			A[idx] = a1.charAt(i) - '0';
		}
		
		for(int i = b1.length() -1, idx = 0; i >= 0; i--,idx++) {
			B[idx] = b1.charAt(i) - '0';
		}
		
		for(int i = 0; i < maxLength; i++) {
			int value = A[i] + B[i];
			A[i] = value % 10;	// 더한 값의 10으로 나눈 나머지가 자리값이 됨
			A[i + 1] += (value / 10);	// 더한 값의 10으로 나눈 몫이 올림값이 됨
		}
		
		StringBuilder sb = new StringBuilder();
		if(A[maxLength] != 0) {
			sb.append(A[maxLength]);
		}
		
		for(int i = maxLength - 1; i >= 0; i--) {
			sb.append(A[i]);
		}
		System.out.println(sb);
	}
}
