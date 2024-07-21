package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10:22
public class 곱셈1629 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		
		int b = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(st.nextToken());
		
		
		System.out.println(square(a, b, c));
	}
	
	public static long square(int a, int b, int c) {
		
		if(b == 0) return 1;
		
		long r = square(a, b / 2, c);
		
		if(b % 2 == 0) {
			return r * r % c;
		} else {
			return (r * r % c) * a % c;
		}
	}	
}
	