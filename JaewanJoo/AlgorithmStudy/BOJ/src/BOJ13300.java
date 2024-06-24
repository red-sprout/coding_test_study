// 방 배정
import java.io.*;

public class BOJ13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int n = Integer.parseInt(info[0]);
		int k = Integer.parseInt(info[1]);
		int[][] arr = new int[2][7];
		
		for(int i = 0; i < n; i++) {
			info = br.readLine().split(" ");
			int s = Integer.parseInt(info[0]);
			int y = Integer.parseInt(info[1]);
			arr[s][y]++;
		}
		
		int result = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 1; j <= 6; j++) {
				if(arr[i][j] % k == 0) {
					result += arr[i][j] / k;
				} else {
					result += arr[i][j] / k + 1;
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
