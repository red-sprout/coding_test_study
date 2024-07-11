import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//처음 주어진 n 
		int n = Integer.parseInt(br.readLine());
		//arr 시작시간, 끝나는시간으로 정보 받기
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		//배열을 끝나는 시간이 빠르면서 시작시간이 빠른 순으로 정렬
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
		});
		int endTime = 0;
		int count = 0;
		//끝나는시간이 시작시간보다 작은경우 갱신
		for (int i = 0; i < n; i++) {
			if (arr[i][0] >= endTime) {
				endTime = arr[i][1];
				count++;
			}
		}
		System.out.println(count);
		br.close();
	}
}
