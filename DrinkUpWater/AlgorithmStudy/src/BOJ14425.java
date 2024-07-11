import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//처음 주어진 n m
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		//갯수
		int count = 0;
		
		//map에 첫 5개 가진것을 1로 초기화
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(br.readLine(), 1);
		}
		//map에 뒤에 11개 들어왓을때 null 아닌것을 센다
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (map.get(str) != null) {
				count++;
			}
		}
		System.out.println(count);
	}
}
