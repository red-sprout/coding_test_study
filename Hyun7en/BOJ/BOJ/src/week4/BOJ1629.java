package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * ****** 곱셈 ******
 * 
 * <문제>
 * 자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
 * 
 * <입력>
 * 첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.
 * 
 * <출력>
 * 첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
 * 
 * Math.pow() -> double반환 so X
 */

public class BOJ1629 {

	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        // 첫째 줄
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int A = Integer.parseInt(st.nextToken());
	        int B = Integer.parseInt(st.nextToken());
	        int C = Integer.parseInt(st.nextToken());

	        //A를 B번 곱한 수를 C로 나눈 나머지
	        br.close();
	        System.out.println(pow(A, B, C));
	    }
	    
	    private static long pow(int a, int b, int c) {
	        if (b == 0) {
	            return 1;
	        }
	        
	        long half = pow(a, b / 2, c);
	        long halfMod = (half * half) % c;
	        
	        if (b % 2 == 0) {
	            return halfMod;
	        } else {
	            return (halfMod * a) % c;
	        }
	    }


}
