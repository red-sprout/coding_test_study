package study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//14:30
public class 치킨배달15686 {

	// 도시크기를 구할 N, 폐업시킬 치킨 집 개수 M
	static int N, M, result;
	
	static int[][] city; //도시
	
	//집 좌표들
	static ArrayList<int[]> house = new ArrayList<>();
	
	//치킨집 좌표들
	static ArrayList<int[]> chicken = new ArrayList<>(); 
	
	//폐업 안한 치킨집 표시
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		city = new int[N][N]; 
		
		//0 = 빈칸 1 = 집 2 = 치킨집
		for(int i = 0; i < N; i++) { //도시에 정보 채우기
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				
				if(city[i][j] == 1) { // 만약 1이라면 좌표를 집리스트에 저장
					house.add(new int[] {i, j});
				} else if(city[i][j] == 2){ // 만약 2라면 좌표를 치킨집리스트에 저장
					chicken.add(new int[] {i, j});
				}
			}
		}
		
		visited = new boolean[chicken.size()]; 
		
		result = Integer.MAX_VALUE; // 최솟값을 찾아야하기에 초기값을 크게 !
		
		distance(0, 0); //처음 방문할 치킨집인덱스와 리턴 조건에 넣어줄 depth
		
		System.out.println(result);
		br.close();
	}
	
	public static void distance(int chIndex, int depth) {
		
		if(depth == M) { //M개의 치킨집 선정
			int sum = 0; // 도시의 치킨거리가 담길 sum
			
			for(int i = 0; i < house.size(); i++) { //집 하나당 선정된 모든 치킨집과의 거리르 계산
				int temp = Integer.MAX_VALUE; //치킨커리가 담길 temp
				for(int j = 0; j < chicken.size(); j++) {
					if(visited[j]) { //visited를 활용해서 선정된 치킨집만 
						int dist = Math.abs(house.get(i)[0] - chicken.get(j)[0])
								  + Math.abs(house.get(i)[1] - chicken.get(j)[1]);
						
						temp = Math.min(temp, dist); 
					}
				}
				sum += temp;
			}
			result = Math.min(result, sum);
			return;
		}
		
		for(int i = chIndex; i < chicken.size(); i++) {
			visited[i] = true; //선정된 치킨집 true
			distance(i + 1, depth + 1);
			visited[i] = false; //계산이 다 된 치킨집 false
		}
	}
}
//16:00