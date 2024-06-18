package year2024.month06.day20;
// 작은 별점
import java.io.*;
import java.util.*;

public class BOJ16498 {
	private static int a, b, c;
	private static int[] cardA, cardB, cardC;
	
	public static void main(String[] args) throws IOException {
		input();
		
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		a = Integer.parseInt(info[0]);
		b = Integer.parseInt(info[1]);
		c = Integer.parseInt(info[2]);
		
		cardA = new int[a];
		cardB = new int[b];
		cardC = new int[c];
		
		info = br.readLine().split(" ");
		for(int i = 0; i < a; i++) {
			cardA[i] = Integer.parseInt(info[i]);
		}
		
		info = br.readLine().split(" ");
		for(int i = 0; i < b; i++) {
			cardB[i] = Integer.parseInt(info[i]);
		}
		
		info = br.readLine().split(" ");
		for(int i = 0; i < c; i++) {
			cardC[i] = Integer.parseInt(info[i]);
		}
		
		Arrays.sort(cardA);
		Arrays.sort(cardB);
		Arrays.sort(cardC);
		br.close();
	}
	
	public static int penalty(int x, int y, int z) {
		return Math.abs(Math.max(x, (Math.max(y, z))) - Math.min(x, (Math.min(y, z))));
	}

	public static int binarySearch() {
		
	}
}
