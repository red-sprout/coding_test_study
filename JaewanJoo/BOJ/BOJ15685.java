import java.io.*;
import java.util.*;

// [BOJ] 드래곤 커브 / 골드 3 / 1시간
// 알고리즘 분류 : 구현 / 시뮬레이션
public class Main {
	private static boolean[][] plane = new boolean[101][101];
	private static int cnt = 0;
	private static int gen;
	private static int[] center;
	private static List<int[]> points;
	
	private static final int[] dc = {1, 0, -1, 0};
	private static final int[] dr = {0, -1, 0, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int col, row, d, g;
        
        for(int i = 0; i < n; i++) {
        	points = new ArrayList<>();
        	st = new StringTokenizer(br.readLine());
        	col = Integer.parseInt(st.nextToken());
        	row = Integer.parseInt(st.nextToken());
        	d = Integer.parseInt(st.nextToken());
        	g = Integer.parseInt(st.nextToken());
        	
        	gen = g;
        	
        	points.add(new int[] {row, col});
        	row += dr[d];
        	col += dc[d];
        	
        	center = new int[] {row, col};
        	points.add(center);
        	
        	draw(0);
        }
        
        count();
        System.out.println(cnt);
        br.close();
    }
    
    public static void draw(int g) {
    	if(g == gen) {
    		for(int[] point : points) {
    			plane[point[0]][point[1]] = true;
    		}
    		return;
    	}
    	
    	int r0, c0, r, c;
    	int rnext, cnext;
    	
    	int size = points.size();
    	r0 = points.get(size - 1)[0];
    	c0 = points.get(size - 1)[1];
    	for(int i = size - 2; i >= 0; i--) {
    		r = points.get(i)[0];
    		c = points.get(i)[1];
    		
    		rnext = r0 - c0 + c;
    		cnext = r0 + c0 - r;
    		
    		points.add(new int[] {rnext, cnext});
    	}
    	
    	draw(g + 1);
    }
    
    public static void count() {
    	for(int i = 0; i < 100; i++) {
    		for(int j = 0; j < 100; j++) {
    			if(plane[i][j] && plane[i + 1][j] && plane[i][j + 1] && plane[i + 1][j + 1]) {
    				cnt++;
    			}
    		}
    	}
    }
}
