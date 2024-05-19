package year2024.month05.day20;
// 피아의 아틀리에 ~신비한 대회의 연금술사~
import java.io.*;
import java.util.*;

public class BOJ15898 {
	private static int ans = 0;
	private static int[] nowCase;
	private static int[][] cases;
	private static Material[][] gama;
	private static Material[][][][] candMat;
	
	private static class Material {
		int value;
		char color;
		
		Material() {
			this.value = 0;
			this.color = 'W';
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		cases = caseCnt(n);
		gama = init(5);
		candMat = new Material[n][4][4][4];
		
		for(int t = 0; t < n; t++) {
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 4; j++) {
					candMat[t][0][i][j] = new Material();
					candMat[t][0][i][j].value = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 4; j++) {
					candMat[t][0][i][j].color = st.nextToken().charAt(0);
				}
			}
			
			for(int i = 1; i < 4; i++) {
				candMat[t][i] = rotation(candMat[t][i - 1]);
			}
		}
		
		for(int i = 0; i < cases.length; i++ ) {
			nowCase = cases[i];
			dfs(0);
		}
		
		System.out.println(ans);
		br.close();
	}
	
	public static int[][] caseCnt(int n) {
		int[][] result = new int[n * (n - 1) * (n - 2)][3];
		int idx = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(i != j && j != k && i != k) {						
						result[idx][0] = i;
						result[idx][1] = j;
						result[idx][2] = k;
						idx++;
					}
				}
			}
		}
		return result;
	}
	
	public static Material[][] init(int size) {
		Material[][] result = new Material[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				result[i][j] = new Material();
			}
		}
		return result;
	}
	
	public static Material[][] rotation(Material[][] before) {
		Material[][] after = init(before.length);
		for(int i = 0; i < after.length; i++) {
			for(int j = 0; j < after[i].length; j++) {
				after[after.length - j - 1][i].color = before[i][j].color;
				after[after.length - j - 1][i].value = before[i][j].value;
			}
		}
		return after;
	}
	
	public static int quality(Material[][] mat) {
		int r = 0, b = 0, g = 0, y = 0;
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				switch(mat[i][j].color) {
				case 'R': r += mat[i][j].value; break;
				case 'B': b += mat[i][j].value; break;
				case 'G': g += mat[i][j].value; break;
				case 'Y': y += mat[i][j].value; break;
				}
			}
		}
		return 7 * r + 5 * b + 3 * g + 2 * y;
	}
	
	public static void dfs(int cnt) {
		if(cnt == 3) {
			ans = Math.max(ans, quality(gama));
			return;
		}
		
		Material[][] now = init(5);
		
		for(int i = 0; i < now.length; i++) {
			for(int j = 0; j < now[i].length; j++) {
				now[i][j].color = gama[i][j].color;
				now[i][j].value = gama[i][j].value;
			}
		}
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				for(int rot = 0; rot < 4; rot++) {
					update(cnt, rot, i, j);
					dfs(cnt + 1);

					for(int a = 0; a < now.length; a++) {
						for(int b = 0; b < now[a].length; b++) {
							gama[a][b].color = now[a][b].color;
							gama[a][b].value = now[a][b].value;
						}
					}
				}
			}
		}
	}

	private static void update(int cnt, int rot, int i, int j) {
		int idx = nowCase[cnt];
		Material[][] mat = candMat[idx][rot];
		for(int row = 0; row < mat.length; row++) {
			for(int col = 0; col < mat[i].length; col++) {
				int value = gama[i + row][j + col].value + mat[row][col].value;
				char color = mat[row][col].color;
				
				if(value > 9) value = 9;
				else if(value < 0) value = 0;
				
				if(color == 'W') color = gama[i + row][j + col].color;
				
				gama[i + row][j + col].value = value;
				gama[i + row][j + col].color = color;
			}
		}
	}
	
	public static void print(Material[][] test) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < test.length; i++) {
			for(int j = 0; j < test[i].length; j++) {
				sb.append(test[i][j].value + "" + test[i][j].color).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
