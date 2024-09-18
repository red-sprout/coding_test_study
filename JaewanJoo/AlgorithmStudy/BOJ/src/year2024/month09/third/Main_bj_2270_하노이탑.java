package year2024.month09.third;

import java.util.*;

public class Main_bj_2270_하노이탑 {
	static int n, pow[], pole[], answer;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		pole = new int[n + 1];
		
		int[] num = new int[3];
		for(int i = 0; i < 3; i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < num[i]; j++) {
				pole[sc.nextInt()] = i;
			}
		}
		
		System.out.println(pole[n] + 1);

		answer = 0;
		init();
		hanoi(n, pole[n]);
		System.out.println(answer);
		sc.close();
	}
	
	public static void hanoi(int disk, int to) {
		if(disk == 0) return;
		int now = pole[disk];
		int sub = 3 - now - to;
		if(now == to) {
			hanoi(disk - 1, to);
			return;
		}
		answer = (answer + pow[disk - 1]) % 1_000_000;
		hanoi(disk - 1, sub);
	}
	
	public static int init() {
		int result = 1;
		pow = new int[100_001];
		pow[0] = 1;
		for(int i = 1 ; i < 100_001; i++) {
			pow[i] = (pow[i - 1] * 2) % 1_000_000;
		}
		return result;
	}
}
