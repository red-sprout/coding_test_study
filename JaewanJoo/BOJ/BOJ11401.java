import java.io.*;
import java.util.*;

// [BOJ] 이항 계수 3 / 골드 1 / 1시간
// 알고리즘 분류 : 수학 / 정수론 / 조합론 / 분할 정복을 이용한 거듭제곱 / 모듈로 곱셈 역원 / 페르마의 소정리
public class Main {
	private static final int MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Integer.parseInt(st.nextToken());
		long k = Integer.parseInt(st.nextToken());
		
		long nf = factorial(n);
		long kf = factorial(k);
		long nkf = factorial(n - k);
		System.out.println(nf * pow((kf % MOD * nkf % MOD) % MOD, MOD - 2) % MOD);
		
		br.close();
	}
	
	public static long pow(long a, long p) {
		if(p == 0) return 1;
		if(p == 1) return a;
		
		if(p % 2 == 0) {
			long tmp = pow(a, p / 2) % MOD;
			return (tmp * tmp) % MOD;
		}
		else return (a * pow(a, p - 1)) % MOD;
	}
	
	public static long factorial(long n) {
		long ans = 1;
		for(int i = 1; i <= n; i++) {
			ans = (ans * i) % MOD;
		}
		return ans;
	}
}
