// 랜덤 생성기
import java.io.*;

public class RandomGame {
	private static int n;
	private static String[] names;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("**********************");
		System.out.println("     Random  Game     ");
		System.out.println("**********************");
		
		System.out.print("총 문제 수 : ");
		int p = Integer.parseInt(br.readLine());
		System.out.print("참여자의 수 : ");
		n = Integer.parseInt(br.readLine());
		names = new String[n];
		
		for(int i = 0; i < n; i++) {
			System.out.printf("%d번째 성함 입력 : ", i + 1);
			names[i] = br.readLine();
		}
		
		shuffle();
		
		System.out.println("**********************");
		System.out.println("        Result        ");
		System.out.println("**********************");
		for(int i = 0; i < p; i++) {
			System.out.printf("문제 %c - %s님\n", i + 'A', names[i]);
		}
		
		br.close();
	}
	
	public static void shuffle() {
		for(int test = 0; test < 10000; test++) {
			int i = (int) (Math.random() * n);
			int j = (int) (Math.random() * n);
			if(i == j) continue;
			
			String tmp = names[i];
			names[i] = names[j];
			names[j] = tmp;
		}
	}
}
