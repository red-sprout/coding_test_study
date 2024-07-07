package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * ****** 트럭 ******
 * <문제>
 * 하나의 차선 n개의 트록 건넘
 * 트럭 순서 못 바꿈(트럭 무게 같지 않을 수 있음)
 * 다리 위에는 단지 w 대의 트럭
 * 다리의 길이는 w 단위길이(unit distance)
 * 각 트럭들은 하나의 단위시간(unit time)에 하나의 단위길이만큼만 이동할 수 있다
 * 다리 위에 올라가 있는 트럭들의 무게의 합은 다리의 최대하중인 L보다 작거나 같아야 한다.
 * 다리 위에 완전히 올라가지 못한 트럭의 무게는 다리 위의 트럭들의 무게의 합을 계산할 때 포함 x.
 * 
 * <입력>
 * 입력 데이터는 표준입력을 사용한다. 입력은 두 줄로 이루어진다. 
 * 입력의 첫 번째 줄에는 세 개의 정수 n (1 ≤ n ≤ 1,000) , w (1 ≤ w ≤ 100) and L (10 ≤ L ≤ 1,000)이 주어지는데, 
 * n은 다리를 건너는 트럭의 수, w는 다리의 길이, 그리고 L은 다리의 최대하중을 나타낸다. 
 * 입력의 두 번째 줄에는 n개의 정수 a1, a2, ⋯ , an (1 ≤ ai ≤ 10)가 주어지는데, ai는 i번째 트럭의 무게를 나타낸다.
 * 
 * <출력>
 * 출력은 표준출력을 사용한다. 
 * 모든 트럭들이 다리를 건너는 최단시간을 출력하라.
 */
public class BOJ13335 {
	
	public static void main(String[] args) throws IOException {
		
		//첫 줄
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 트럭의 수
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 최대 하중
        
        // 두 번째 줄
        int[] truckWeight = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	truckWeight[i] = Integer.parseInt(st.nextToken());
        }
        
        // 트럭 관리
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int weightOnBridge = 0; //다리위 트럭 무게
        int index = 0; //대기 중인 트럭
        
        // 초기 다리 상태를 빈 공간으로 채움
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        
        while (index < n || weightOnBridge > 0) {
            // 다리 위에서 트럭을 한 칸 이동시키고, 다리에서 내린 트럭의 무게를 뺌
        	weightOnBridge -= bridge.poll();
            
            // 다음 트럭을 다리 위에 올릴 수 있는지 확인
            if (index < n && weightOnBridge + truckWeight[index] <= L) {
                bridge.add(truckWeight[index]);
                weightOnBridge += truckWeight[index];
                index++;
            } else {
                // 트럭을 올릴 수 없으면 빈 공간을 추가
                bridge.add(0);
            }
            
            time++;
        }
        
        System.out.println(time);
        br.close();
	}
}
