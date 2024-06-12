import java.io.*;

public class BOJ13241 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		long a = Long.parseLong(info[0]);
		long b = Long.parseLong(info[1]);
		long g = gcd(a, b);
		System.out.println(a * b / g);
		br.close();
	}
	
	public static long gcd(long a, long b) {
	    while (b != 0) {
	        long tmp = b;
	        b = a % b;
	        a = tmp;
	    }
	    return a;
	}
}
