package BOJ.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13335 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력값을 쪼개주기 위한 토크나이저 생성
		StringTokenizer stz = new StringTokenizer(br.readLine());
		// .nextToken() 통해 쪼갤 수 있으나 반환형이 String 이기에 형변환해줘야함
		
		// 트럭 배열 생성(통행해야 할 트럭의 무게를 담은 배열)
		int[] trucks = new int[Integer.parseInt(stz.nextToken())];
		
		int bridgeLength = Integer.parseInt(stz.nextToken());
		
		// 다리의 최대 하중
		int maxWeight = Integer.parseInt(stz.nextToken());
		
		stz = new StringTokenizer(br.readLine());
		// 트럭의 무게들을 트럭 배열에 삽입
		for(int i = 0; i < trucks.length; i++) {
			trucks[i] = Integer.parseInt(stz.nextToken());
		}
		// 다리는 queue 사용
		Queue<Integer> bridge = new LinkedList<>();
		
		// 초기 다리 상태는 모두 0으로 초기화
        for (int i = 0; i < bridgeLength; i++) {
            bridge.add(0);
        }
	
		// 통행 소요 시간
		int time = 0;
		// 다리의 하중
		int weightOnBridge = 0;
		// 현재 통행하는 트럭의 인덱스
		int truckIndex = 0;
		
		time = calcTime(time, weightOnBridge, truckIndex, trucks, bridge, maxWeight);
		
		System.out.println(time);
		
		br.close();
		
	}
	
	public static int calcTime(int time, int weightOnBridge, int truckIndex, int[] trucks, Queue<Integer> bridge, int maxWeight) {
		int tLength = trucks.length;

		while(truckIndex < tLength || weightOnBridge > 0) {
			
			time++;
			
			weightOnBridge -= bridge.poll();

			if(truckIndex < tLength && weightOnBridge + trucks[truckIndex] <=  maxWeight) {
				int truck = trucks[truckIndex];
				// 다리 배열에 해당 트럭을 삽입
				bridge.add(truck);
				// 동시에 다리 하중에 해당 트럭의 무게를 추가
				weightOnBridge += truck;
				truckIndex++;
			} else { // 트럭이 지나가지 않을 경우 0을 넣어줘야 함 아니면 미처 지나가지 않은 트럭들을 빼버릴 수 있음
				bridge.add(0);
			}
		}
	return time;
}
	
//		Queue 를 사용하지 않는 풀이법
//		// 문제의 포인트는 트럭이 다리를 동시에 통행할 수 있는지의 여부를 가리는 것
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		// 입력값을 쪼개주기 위한 토크나이저 생성
//		StringTokenizer stz = new StringTokenizer(br.readLine());
//		// .nextToken() 통해 쪼갤 수 있으나 반환형이 String 이기에 형변환해줘야함
//		
//		// 트럭 배열 생성(통행해야 할 트럭의 무게를 담은 배열)
//		int[] trucks = new int[Integer.parseInt(stz.nextToken())];
//		// 다리 배열 생성 (다리를 지나가고 있는 트럭의 무게를 담은 배열)
//		int[] bridge = new int[Integer.parseInt(stz.nextToken())];
//		// 다리의 최대 하중
//		int maxWeight = Integer.parseInt(stz.nextToken());
//		
//		stz = new StringTokenizer(br.readLine());
//		// 트럭의 무게들을 트럭 배열에 삽입
//		for(int i = 0; i < trucks.length; i++) {
//			trucks[i] = Integer.parseInt(stz.nextToken());
//		}
//		
//		// 통행 소요 시간
//		int time = 0;
//		// 다리의 하중
//		int weightOnBridge = 0;
//		// 현재 통행하는 트럭의 인덱스
//		int truckIndex = 0;
//		
//		time = calcTime(time, weightOnBridge, truckIndex, trucks, bridge, maxWeight);
//
//		System.out.println(time);
//		
//		br.close();
//	}
//	
//	public static int calcTime(int time, int weightOnBridge, int truckIndex, int[] trucks, int[] bridge, int maxWeight) {
//		int bLength = bridge.length;
//		int tLength = trucks.length;
//		// 더 이상 통행할 트럭이 없을 때 다리 위에 통행하고 있는 트럭이 있다면 해당 트럭이 통행하는 시간도 계산해줘야 하기에
//		// weightOnBridge > 0 조건 추가
//		while(truckIndex < tLength || weightOnBridge > 0) {
//			// 통행 시작하면 시간 1초 소요
//			time++;
//			// 만약 다리 위에 빠져나가는 트럭이 있다면 다리의 하중에서 해당 트럭의 무게만큼을 빼줌(없어도 어차피 0이라 영향 없음)
//			weightOnBridge -= bridge[0];
//			// 트럭이 다리를 지나가는 것은 곧 다리 배열을 한 칸씩 앞으로 땡기는 것
//			for(int j = 0; j < bLength - 1; j++) {
//				bridge[j] = bridge[j+1];
//			}
//			//앞으로 한 칸씩 땡기면 다리 배열의 마지막 칸은 아무 트럭이 없는 상태이기 때문에 0으로 초기화
//			bridge[bLength - 1] = 0;
//			// 이상의 과정으로 트럭들이 다리를 1씩 이동
//			// 이제 트럭이 동시에 다리를 통행할 수 있는지 여부 체크해야 함
//			// 트럭이 다리를 통행할 수 있으려면 다리의 하중 + 통행할 트럭의 무게의 합이 최대 하중 이하여야 함
//			// 추가적으로 통행할 트럭이 남아있는지 여부도 체크해줘야함
//			if(truckIndex < tLength && weightOnBridge + trucks[truckIndex] <=  maxWeight) {
//				int truck = trucks[truckIndex];
//				// 다리 배열에 해당 트럭을 삽입
//				bridge[bridge.length - 1] = truck;
//				// 동시에 다리 하중에 해당 트럭의 무게를 추가
//				weightOnBridge += truck;
//				truckIndex++;
//			}
//		}
//		return time;
//	}
}
