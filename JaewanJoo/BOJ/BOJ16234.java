import java.io.*;
import java.util.*;

// [BOJ] 인구 이동 / 골드 4
// 알고리즘 분류 : 구현 / 그래프 이론 / 그래프 탐색 / 시뮬레이션 / 너비 우선 탐색
public class Main {
	static int n, l, r;
	static boolean[][] visited;
	static int[][] map;
	static List<List<int[]>> unionList = new LinkedList<>();
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int day = 0;
        boolean isMovable = true;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n][n];
        map = new int[n][n];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        while(true) {
        	isMovable = false;
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			if(visited[i][j]) {
        				continue;
        			}
        			if(findMovablePlace(i, j)) {
        				isMovable = true;
        			}
        		}
        	}
        	
        	if(!isMovable) {
        		break;
        	}
        	
        	for(List<int[]> union : unionList) {
        		setAvg(union);
        	}
        	
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			visited[i][j] = false;
        		}
        	}
        	
        	unionList.clear();
        	day++;
        }
        
        System.out.println(day);
        br.close();
    }
    
    public static boolean findMovablePlace(int row, int col) {
    	boolean result = false;
    	int difference = 0;
    	
    	for(int i = 0; i < 4; i++) {
    		int nextRow = row + dr[i];
    		int nextCol = col + dc[i];
    		if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
    			continue;
    		}
    		if(visited[nextRow][nextCol]) {
    			continue;
    		}
    		visited[row][col] = true;
    		difference = Math.abs(map[row][col] - map[nextRow][nextCol]);
    		if(difference >= l && difference <= r) {
    			result = true;
    			bfs(row, col);
    		}
    	}
    	
    	return result;
    }
    
    public static void bfs(int row, int col) {
    	List<int[]> union = new ArrayList<>();
    	Queue<int[]> q = new LinkedList<>();
    	int difference = 0;
    	
    	int[] first = {row, col};
    	union.add(first);
    	q.add(first);
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int nowRow = now[0];
    		int nowCol = now[1];
    		for(int i = 0; i < 4; i++) {
    			int nextRow = nowRow + dr[i];
    			int nextCol = nowCol + dc[i];
    			
    			if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
        			continue;
        		}
    			
        		if(visited[nextRow][nextCol]) {
        			continue;
        		}
        		
        		difference = Math.abs(map[nowRow][nowCol] - map[nextRow][nextCol]);
        		if(difference >= l && difference <= r) {
        			visited[nextRow][nextCol] = true;
        			int[] next = {nextRow, nextCol};
        			union.add(next);
        			q.add(next);
        		}
    		}
    	}
    	
    	unionList.add(union);
    }
    
    public static int getAvg(List<int[]> union) {
    	int result = 0;
    	for(int[] p : union) {
    		result += map[p[0]][p[1]];
    	}
    	return result / union.size();
    }
    
    public static void setAvg(List<int[]> union) {
    	int avg = getAvg(union);
    	for(int[] p : union) {
    		map[p[0]][p[1]] = avg;
    	}
    }
}
