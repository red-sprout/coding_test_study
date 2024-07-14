package year2024.month07.day01;
// 곰곰이와 테트리스
import java.io.*;

public class BOJ26074 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int n = Integer.parseInt(info[0]);
		int m = Integer.parseInt(info[1]);
		System.out.println(n * m == 2 ? "ChongChong" : "GomGom");
		br.close();
	}
}
