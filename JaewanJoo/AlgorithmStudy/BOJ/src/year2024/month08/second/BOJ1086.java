package year2024.month08.second;

import java.io.*;
import java.util.*;

public class BOJ1086 {
	static int N, K;
	static int[] modTen;
	static int[] modNum;
	static String[] numbers;
	static long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		modTen = new int[1000];
		modNum = new int[N];
		numbers = new String[N];
		
		for(int i = 0 ; i < N; i++) numbers[i] = br.readLine();
		K = Integer.parseInt(br.readLine());
		dp = new long[K][1 << N];
		
		fillModTen();
		fillModNum();
		
		long p = 0, q = 1;
		for(int i = 1; i <= N; i++) q *= i;
		
		for(int i = 0; i < K; i++) Arrays.fill(dp[i], -1);		
		p = memo(0, 0, 0);

		if(p == 0) {
			System.out.println(0 + "/" + 1);
		} else {			
			long gcd = gcd(q, p);
			System.out.println(p / gcd + "/" + q / gcd);
		}
		
		br.close();
	}
	
	public static long gcd(long a, long b) {
		long m = a % b;
		while(m != 0) {
			a = b;
			b = m;
			m = a % b;
		}
		return b;
	}
	
	public static void fillModTen() {
		modTen[0] = 1;
		for(int i = 1; i < 1000; i++) {
			modTen[i] = modTen[i - 1] * 10 % K;
		}
	}
	
	public static void fillModNum() {
		for(int i = 0; i < N; i++) {
			String num = numbers[i];
			int size = num.length();
			int answer = 0;
			for(int j = 0; j < size; j++) {
				int idx = size - j - 1;
				answer = (answer + (num.charAt(j) - '0') * modTen[idx]) % K;
			}
			modNum[i] = answer;
		}
	}
	
	public static long memo(int visited, int mod, int cnt) {
		if(dp[mod][visited] != -1) return dp[mod][visited];
		if(cnt == N) return dp[mod][visited] = mod == 0 ? 1 : 0;
		long result = 0;
		for(int i = 0; i < N; i++) {
			if((visited & (1 << i)) == 0) {
				result += memo((visited | (1 << i)), getMod(mod, visited, i), cnt + 1);
			}
		}
		return dp[mod][visited] = result;
	}
	
	public static int getMod(int mod, int visited, int n) {
		int idx = 0;
		for(int i = 0; i < N; i++) {
			if((visited & (1 << i)) > 0) {
				idx += numbers[i].length();
			}
		}
		return ((modNum[n] * modTen[idx]) % K + mod) % K;
	}
}
