import java.io.*;
import java.util.*;

// [BOJ] 전력난 / 골드 4 / 40분
// 알고리즘 분류 : 그래프 이론 / 최소 스패닝 트리
public class Main {
	private static int m, n;
	private static int[] parent;
	
	static class Road implements Comparable<Road>{
		int x, y, cost;
		
		public Road(int x, int y, int cost) {
			this.x = Math.min(x, y);
			this.y = Math.max(x, y);
			this.cost = cost;
		}

		@Override
		public int compareTo(Road n) {
			return this.cost - n.cost;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        while(true) {
        	st = new StringTokenizer(br.readLine());
        	m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            
            if(m == 0 && n == 0) break;
            
            parent = new int[m];
            Road[] roads = new Road[n];
            
            int x, y, z;
            int ans = 0;
            int distance = 0;
            for(int i = 0; i < m; i++) {
            	parent[i] = i;
            }
            
            for(int i = 0; i < n; i++) {
            	st = new StringTokenizer(br.readLine());
            	x = Integer.parseInt(st.nextToken());
            	y = Integer.parseInt(st.nextToken());
            	z = Integer.parseInt(st.nextToken());
            	
            	roads[i] = new Road(x, y, z);
            	ans += z;
            }

            Arrays.sort(roads);
            
            for(Road r : roads) {
            	if(isUnion(r.x, r.y)) continue;
            	unionParent(r.x, r.y);
            	distance += r.cost;
            }
            
            sb.append(ans - distance).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
    
    public static int getParent(int a) {
    	if(a == parent[a]) return a;
    	return parent[a] = getParent(parent[a]);
    }
    
    public static void unionParent(int a, int b) {
    	a = getParent(a);
    	b = getParent(b);
    	if(a > b) parent[a] = b;
    	else parent[b] = a;
    }
    
    public static boolean isUnion(int a, int b) {
    	return getParent(a) == getParent(b);
    }
}
