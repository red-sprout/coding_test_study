import java.io.*;

// [BOJ] 별 찍기 11 / 골드 4 / 1시간
// 알고리즘 분류 : 재귀
public class Main {
	static char[][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        star = new char[n][2 * n];
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < 2 * n; j++) {
        		star[i][j] = ' ';
        	}
        }
        
        int middle = n - 1;
        draw(n, 0, middle);
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < 2 * n; j++) {
        		sb.append(star[i][j]);
        	}
        	sb.append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
    
    public static void draw(int n, int row, int col) {
    	if(n == 3) {
    		star[row][col] = '*';
    		
    		star[row + 1][col - 1] = '*';
    		star[row + 1][col + 1] = '*';
    		
    		for(int i = 0; i < 5; i++) {
    			star[row + 2][col - 2 + i] = '*';
    		}
    		
    		return;
    	}
    	
    	int next = n / 2;
    	draw(next, row, col);
    	draw(next, row + next, col - next);
    	draw(next, row + next, col + next);
    }
}
