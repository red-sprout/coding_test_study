package year2024.month06.day17;
// 가스관
import java.io.*;

/*
 * . : 빈칸
 * | - +
 * 1 4 
 * 2 3 : 블록
 * M : 출발 Z : 도착 
 */
public class BOJ2931 {
	private static int r, c;
	private static int[] start, end;
	private static char[][] map;
	private static boolean[][] visited;
	// 아래, 왼쪽, 위, 오른쪽
	private static int[] dr = {-1, 0, 1, 0}; 
	private static int[] dc = {0, -1, 0, 1};
	
	private static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		
		r = Integer.parseInt(info[0]);
		c = Integer.parseInt(info[1]);
		map = new char[r + 1][c + 1];
		visited = new boolean[r + 1][c + 1];
		
		start = new int[2];
		end = new int[2];
		for(int i = 1; i <= r; i++) {
			String row = br.readLine();
			for(int j = 1; j <= c; j++) {
				switch(row.charAt(j - 1)) {
				case 'M':
					start[0] = i;
					start[1] = j;
					break;
				case 'Z':
					end[0] = i;
					end[1] = j;
					break;
				}
			}
		}
		
		search(start);
	}
	
	public static void search(int[] now) throws IOException {
		visited[now[0]][now[1]] = true;
		System.out.println(now[0] + " " + now[1]);
		switch(map[now[0]][now[1]]) {
		case 'M':
			caseM(now);
			break;
		case '|':
			if(visited[now[0]][now[1] + 1]) search(new int[] {now[0], now[1] - 1});
			else search(new int[] {now[0], now[1] + 1});
			break;
		case '-':
			if(visited[now[0] + 1][now[1]]) search(new int[] {now[0] - 1, now[1]});
			else search(new int[] {now[0] + 1, now[1]});
			break;
		case '+':
			caseCross(now);
			break;
		case '1':
			if(visited[now[0] + 1][now[1]]) search(new int[] {now[0], now[1] + 1});
			else search(new int[] {now[0] + 1, now[1]});
			break;
		case '2':
			if(visited[now[0] - 1][now[1]]) search(new int[] {now[0], now[1] + 1});
			else search(new int[] {now[0] - 1, now[1]});
			break;
		case '3':
			if(visited[now[0] - 1][now[1]]) search(new int[] {now[0], now[1] - 1});
			else search(new int[] {now[0] - 1, now[1]});
			break;
		case '4':
			if(visited[now[0] + 1][now[1]]) search(new int[] {now[0], now[1] - 1});
			else search(new int[] {now[0] + 1, now[1]});
			break;
		case '.':
			caseBlank(now);
			br.close();
			System.exit(0);
			return;
		case 'Z':
			return;
		}
	}

	public static void caseCross(int[] now) throws IOException {
		boolean[][] origin = new boolean[r + 1][];
		for(int i = 0; i <= r; i++) {
			origin[i] = visited[i].clone();
		}
		if(!visited[now[0] + 1][now[1]]) {
			search(new int[] {now[0] + 1, now[1]});
			for(int i = 0; i <= r; i++) {
				visited[i] = origin[i].clone();
			}
		}
		if(!visited[now[0]][now[1] + 1]) {
			search(new int[] {now[0], now[1] + 1});
			for(int i = 0; i <= r; i++) {
				visited[i] = origin[i].clone();
			}
		}
		if(!visited[now[0] - 1][now[1]]) {
			search(new int[] {now[0] - 1, now[1]});
			for(int i = 0; i <= r; i++) {
				visited[i] = origin[i].clone();
			}
		}
		if(!visited[now[0]][now[1] - 1]) {
			search(new int[] {now[0], now[1] - 1});
			for(int i = 0; i <= r; i++) {
				visited[i] = origin[i].clone();
			}
		}
	}
	
	public static void caseBlank(int[] now) {
//		System.out.println(now[0] + " " + now[1] + " ");
		boolean[] check = new boolean[4];
		int zPos = -1;
		for(int i = 0; i < 4; i++) {
			int row = now[0] + dr[i];
			int col = now[1] + dc[i];
			if(row < 1 || row > r || col < 1 || col > c) continue;
			char next = map[row][col];
			if(next == 'Z') zPos = -1;
			switch(i) {
			case 0:
				if(next == '|' || next == '+' || next == '2' || next == '3') check[i] = true;
				break;
			case 1:
				if(next == '-' || next == '+' || next == '1' || next == '2') check[i] = true;
				break;
			case 2:
				if(next == '|' || next == '+' || next == '1' || next == '4') check[i] = true;
				break;
			case 3:
				if(next == '-' || next == '+' || next == '3' || next == '4') check[i] = true;
				break;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			
		}
	}

	public static void caseM(int[] now) throws IOException {
		for(int i = 0; i < 4; i++) {
			int row = now[0] + dr[i];
			int col = now[1] + dc[i];
			if(row < 1 || row > r || col < 1 || col > c) continue;
			boolean isOut = false;
			char next = map[row][col];
			switch(i) {
			case 0:
				if(next == '|' || next == '+' || next == '2' || next == '3') isOut = true;
				break;
			case 1:
				if(next == '-' || next == '+' || next == '1' || next == '2') isOut = true;
				break;
			case 2:
				if(next == '|' || next == '+' || next == '1' || next == '4') isOut = true;
				break;
			case 3:
				if(next == '-' || next == '+' || next == '3' || next == '4') isOut = true;
				break;
			}
			
			if(isOut) {
				search(new int[] {row, col});
				return;
			}
		}
	}
}
