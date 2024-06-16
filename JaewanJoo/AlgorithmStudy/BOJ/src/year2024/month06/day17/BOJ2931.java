package year2024.month06.day17;
// 가스관
import java.io.*;

public class BOJ2931 {
	static class Block {
		int row;
		int col;
		int direction;
		
		Block() {}
		Block(int row, int col, int direction) {
			this.row = row;
			this.col = col;
			this.direction = direction;
		}
	}
	
	private static int r, c;
	private static char[][] map;
	private static boolean[][] visited;
	// 좌 우 상 하
	private static int[] dr = {0, 0, -1, 1};
	private static int[] dc = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		r = Integer.parseInt(info[0]);
		c = Integer.parseInt(info[1]);
		map = new char[r + 1][c + 1];
		visited = new boolean[r + 1][c + 1];
		
		int[] start = new int[2];
		int[] end = new int[2];
		
		for(int i = 1; i <= r; i++) {
			String line = br.readLine();
			for(int j = 1; j <= c; j++) {
				map[i][j] = line.charAt(j - 1);
				switch(map[i][j]) {
				case 'M':
					visited[i][j] = true;
					start[0] = i;
					start[1] = j;
					break;
				case 'Z':
					visited[i][j] = true;
					end[0] = i;
					end[1] = j;
					break;
				case '.':
					visited[i][j] = true;
					break;
				}
			}
		}
		
		Block mBlock = searchFirst(start);
		Block zBlock = searchFirst(end);
		Block mEndBlock = search(mBlock);
		Block zEndBlock = search(zBlock);
		
		char shape = getBlock(mEndBlock, reverseDirection(zEndBlock.direction));
		System.out.println(mEndBlock.row + " " + mEndBlock.col + " " + shape);
	}
	
	public static Block search(Block block) {
		int nextRow = block.row + dr[block.direction];
		int nextCol = block.col + dc[block.direction];
		if(map[nextRow][nextCol] == '.') 
			return new Block(nextRow, nextCol, block.direction);
		else {
			visited[nextRow][nextCol] = true;
			return search(new Block(nextRow, nextCol, getDirection(map[nextRow][nextCol], block.direction)));
		}
	}

	public static Block searchFirst(int[] start) {
		visited[start[0]][start[1]] = true;
		for(int i = 0; i < 4; i++) {
			int nextRow = start[0] + dr[i];
			int nextCol = start[1] + dc[i];
			if(nextRow < 1 || nextRow > r || nextCol < 1 || nextCol > c) continue;
			if(map[nextRow][nextCol] != '.' && (map[nextRow][nextCol] != 'M' && map[nextRow][nextCol] != 'Z')) {
				Block block = new Block(nextRow, nextCol, getDirection(map[nextRow][nextCol], i));
				visited[nextRow][nextCol] = true;
				return block;
			}
		}
		return null;
	}

	// 좌 우 상 하
	public static char getBlock(Block block, int next) {
		if(block.direction == next) {
			if(block.direction == 0 || block.direction == 1) {
				return '-';
			} else {
				return '|';
			}
		} else {
			for(int i = 0; i < 4; i++) {
				int nextRow = block.row + dr[i];
				int nextCol = block.col + dc[i];
				if(nextRow < 1 || nextRow > r || nextCol < 1 || nextCol > c) continue;
				if(!visited[nextRow][nextCol]) return '+';
			}
			
			if((block.direction == 2 && next == 1) || (block.direction == 0 && next == 3)) {
				return '1';
			}
			
			if((block.direction == 3 && next == 1) || (block.direction == 0 && next == 2)) {
				return '2';
			}
			
			if((block.direction == 1 && next == 2) || (block.direction == 3 && next == 0)) {
				return '3';
			}
			
			if((block.direction == 2 && next == 0) || (block.direction == 1 && next == 3)) {
				return '4';
			}
		}
		
		return 0;
	}
	
	public static int getDirection(char shape, int direction) {
		switch(shape) {
		case '1':
			if(direction == 2)
				return 1;
			if(direction == 0)
				return 3;
			break;
		case '2':
			if(direction == 3)
				return 1;
			if(direction == 0)
				return 2;
			break;
		case '3':
			if(direction == 1)
				return 2;
			if(direction == 3)
				return 0;
			break;
		case '4':
			if(direction == 1)
				return 3;
			if(direction == 2)
				return 0;
			break;
		}
		return direction;
	}

	public static int reverseDirection(int direction) {
		switch(direction) {
		case 0:
			return 1;
		case 1:
			return 0;
		case 2:
			return 3;
		case 3:
			return 2;
		default:
			return -1;
		}
	}

}
