package BOJ.recursionFunction;

import java.util.Scanner;

public class BOJ1629 {
	public static void main(String[] args) {

		/*
		 * 백준 NO.1629 : 곱셈
		 * 자연수 A^B % C 값 구하기(A,B,C < 2^32)
		 * 분할과 정복 알고리즘을 활용한 거듭제곱 알고리즘
		 * 
		 * 1. 기본 아이디어
		 * 	B mod 2 = 0, B = 2k : A^B = A^2k = (A^k)(A^k)
		 * 	B mod 2 = 1, B = 2k+1 : A^B = A*(A^2k)
		 * 
		 * 2. 모듈러 산술Modular Arithmetic
		 * 	정수의 합과 곱을 어떤 주어진 수의 나머지를 이용하여 정의하는 방법
		 * 	(a*b) mod c = [(a mod c) * (b mod c)] mod c
		 * 	(a+b) mod c = [(a mod c) + (b mod c)] mod c
		 * 
		 * 3. 분할과 정복 알고리즘 적용
		 * 	B mod 2 = 0(짝수일 때): A^B mod C = [(A^k mod C) * (A^k mod C)] mod C
		 *  B mod 2 = 1(홀수일 때): A^B mod C = [(A mod C) * (A^2k mod C)] mod C
		 */
		
        Scanner scanner = new Scanner(System.in);
        
        // 사용자로부터 입력을 받음
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        
        scanner.close();
        
        System.out.println(modExp(A, B, C));
    }
	
    // 분할 정복을 이용한 거듭제곱 함수
    public static long modExp(int A, int B, int C) {
        // 기본 경우: B가 0인 경우 1 반환
        if (B == 0) return 1;
        
        // B를 반으로 나누어 재귀적으로 계산
        // 거듭제곱을 실시하기 때문에 long 형식으로 선언
        long half = modExp(A, B / 2, C);
        long result = (half * half) % C;  // 계산된 값을 제곱하고 모듈로 연산
        
        // B가 홀수인 경우 추가적으로 A%C를 곱함
        if (B % 2 != 0) {
        	result = (result * (A % C)) % C;
        }
        return result;
    }
}
