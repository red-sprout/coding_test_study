package src.week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S13335 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		Queue<Integer> q = new LinkedList<>(); //다리에 대한 queue
		Queue<Integer> t = new LinkedList<Integer>(); //트럭에 대한 queue
		
		st = new StringTokenizer(bf.readLine()); //n, w, l 세팅
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine()); //트럭 세팅
		
		int result = 0; //최종 걸린 시간
		int bw =0; //다리 무게
		
		for(int i = 0; i < n ; i++) {
			t.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i =0; i < w ; i++) { //다리의 queue의 초기값을 0으로 세팅
			q.add(0);
		}
		
		while(!q.isEmpty()) {
			result++; //무조건 시간은 흐르니 ++
			bw-=q.remove(); //다리 무게에 트럭무게를 빼줌
			if(!t.isEmpty()) { //계산해야할 트럭이 남아있다면
				if(t.peek()+bw<=l) { //트럭의 Q에서 최근 무게 + 현재다리의 무게 <= 다리의 최대하중
					bw+=t.peek(); //현재 다리무게 += peek한 트럭의 무게
					q.add(t.remove()); //트럭Q에서 지우고 다리 Q로 이동
				}else {
					q.add(0); //무게 초과면 0으로 밀어버림
				}
			}			
		}
		System.out.println(result);
	}

}
