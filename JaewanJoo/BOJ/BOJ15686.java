import java.io.*;
import java.util.*;

// [BOJ] 치킨 배달 / 골드 5 / 30분
// 알고리즘 분류 : 구현 / 브루트포스 알고리즘 / 백트래킹
public class Main {
	private static int n, m;
	private static int distance = Integer.MAX_VALUE;
	
	private static List<int[]> houselist;
	private static List<int[]> chickenlist;
	private static LinkedList<int[]> save;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        houselist = new ArrayList<>();
        chickenlist = new ArrayList<>();
        save = new LinkedList<>(); 
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		int info = Integer.parseInt(st.nextToken());
        		switch(info) {
        		case 1:
        			houselist.add(new int[] {i, j});
        			break;
        		case 2:
        			chickenlist.add(new int[] {i, j});
        			break;
        		}
        	}
        }
        
        dfs(0, 0);
        System.out.println(distance);
        br.close();
    }
    
    public static void dfs(int cnt, int idx) {
    	if(cnt == m) {
    		int tmp = 0;
    		for(int[] i : houselist) {
    			tmp += distance(i);
    		}
    		distance = Math.min(tmp, distance);
    		return;
    	}
    	
    	for(int i = idx; i < chickenlist.size(); i++) {
    		save.add(chickenlist.get(i));
    		dfs(cnt + 1, i + 1);
    		save.pollLast();
    	}
    }
	
	public static int distance(int[] house) {
		int ans = Integer.MAX_VALUE;
		for(int[] i : save) {
			ans = Math.min(ans, Math.abs(i[0] - house[0]) + Math.abs(i[1] - house[1]));
		}
		return ans;
	}
}
