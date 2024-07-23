import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		//처음 주어진 n m r
		//모듈러 곱셈 ...
		//10^11%12 = (10^5 x 10^6) %12 
		//(10^5 x 10^6) %12 = ((10^5%12) x (10^6%12)) %12 
		//위 식에서  (10^5%12)를 또 쪼갬
		//계속 쪼개다가 지수가 1이 될 때  (10^1%12) 나머지를 구하는 연산
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long result = cal(a, b, c);
		
		System.out.println(result);
		
		br.close();
	}
	
	private static long cal(int a, int b, int mod) {
        if (b == 0)
            return 1;

        long n = cal(a, b / 2, mod);
        if (b % 2 == 0)
            return n * n % mod;
        else
            return (n * n % mod) * a % mod;
    }
}
