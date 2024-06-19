package year2024.month06.day20;
// 미세먼지 안녕!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ17144 {
	private static int r, c, t;
	private static int[][] house, machine;
	private static int[] dr = {1, 0, -1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		input();
	}
	
	public static void input() {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {	
			String[] info = br.readLine().split(" ");
			r = Integer.parseInt(info[0]);
			c = Integer.parseInt(info[1]);
			t = Integer.parseInt(info[2]);
			house = new int[r][c];
			
			int idx = 0;
			machine = new int[2][2];
			for(int i = 0; i < r; i++) {
				String line = br.readLine();
				for(int j = 0; j < c; j++) {
					house[i][j] = line.charAt(j) - '0';
					if(house[i][j] == -1) machine[idx++] = new int[] {i, j};
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setCirculation() {
		int[] topStart = machine[0];
		int[] bottomStart = machine[1];
		
		int topNow = house[topStart[0]][topStart[1] + 1];
		int bottomNow = house[bottomStart[0]][bottomStart[1] + 1];
		for(int i = 2; i < r; i++) {
			
		}
	}
	
	public static void 
}
