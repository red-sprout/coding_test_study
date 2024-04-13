import java.io.*;
import java.util.*;

public class Main {
	private static final long MAX = 1000_000_001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		long z = y * 100 / x;
		
		long left = 0;
		long right = MAX;
		
		while(left < right) {
			long mid = left + (right - left) / 2;
			if((y + mid) * 100 / (x + mid) != z) right = mid;
			else left = mid + 1;
		}
		
		System.out.println(left == MAX ? -1 : left);
		br.close();
	}
}
