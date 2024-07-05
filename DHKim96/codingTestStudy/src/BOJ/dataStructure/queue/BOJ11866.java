package BOJ.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 사람의 수
		int n = Integer.parseInt(st.nextToken());
		// 제거하는 차례
		int k = Integer.parseInt(st.nextToken());
		
		// 사람을 넣는 큐 생성
		Queue<Integer> people = new LinkedList<>();
		
		// 큐에 사람 넣기
		for(int i = 1; i <= n; i++) {
			people.add(i);
		}
		
		//제거당한 사람들을 넣기 위한 리스트 생성
		List<Integer> deathNote = new ArrayList<>();
		
		deathNote = eliminatePeople(k, people, deathNote);
		
		printResult(deathNote);
		
		br.close();
				
	}
	
	public static List<Integer> eliminatePeople(int k, Queue<Integer> people, List<Integer> deathNote) {
		// 사람들을 순서대로 제거하고 데스노트 리스트에 넣기
		// k번째 사람을 제거하기 위해서는 큐의 제일 앞에 오도록 정렬해줘야 함
		while(!people.isEmpty()) {
			// k번째 사람을 큐 제일 앞에 올 수 있도록 정렬하는 반복문
			// 1번째 2번째 ... k-1번째 까지를 큐의 뒤로 보내야 함 
			for(int i = 1; i < k; i++) {
				people.add(people.poll());
			}
			// k번째 사람을 제거
			deathNote.add(people.poll());
		}
		return deathNote;
	}
	
	
   public static void printResult(List<Integer> deathNote) {
	   // StringBuilder 사용해서 성능 향상(약 50ms 단축)
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        for (int i = 0; i < deathNote.size(); i++) {
            sb.append(deathNote.get(i));
            if (i != deathNote.size() - 1) {
                sb.append(", ");
            }
        }
        
        sb.append(">");
        System.out.println(sb.toString());
    }
	
	
	
// ====================== queue 안쓰는 풀이법
//	// 문제의 포인트는 k가 배열의 크기보다 커졌을 경우의 처리라고 생각함.
//	// => 순환적인 인덱스 즉, 환형 큐를 이용해서 처리
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		// 사람의 수
//		int n = Integer.parseInt(st.nextToken());
//		// 제거하는 차례
//		int k = Integer.parseInt(st.nextToken());
//		// 사람을 넣기 위한 리스트 생성
//		List<Integer> people = new ArrayList<>();
//		// 배열에 사람 넣기
//		for(int i = 1; i <= n; i++) {
//			people.add(i);
//		}
//		//제거당한 사람들을 넣기 위한 리스트 생성
//		List<Integer> deathNote = new ArrayList<>();
//		
//		// 제거할 사람을 지목하기 위한 인덱스 생성
//		int index = 0;
//		
//		deathNote = eliminatePeople(index, k, people, deathNote);
//		
//		
//		printResult(deathNote);
//
//		
//		br.close();
//		
//	}
//	
//	public static List<Integer> eliminatePeople(int index, int k, List<Integer> people, List<Integer> deathNote) {
//		// 사람들을 순서대로 제거하고 데스노트 리스트에 넣기
//		while(!people.isEmpty()) {
//			// 배열의 크기가 k보다 작아졌을 경우에 기존의 선형 배열로는 처리할 수 없음 따라서 순환적인 인덱스를 구해야 함
//			// 순환적인 인덱스를 구현하기 위해서는 % people.size() 연산 활용해야 함
//			// 제거할 인덱스를 구하기 위해 k 을 더해줌(추가적으로 인덱스이기 때문에 - 1)
//			index = (index + k - 1) % people.size();
//			// List.remove(int) 메소드 활용하여 삭제와 동시에 반환
//			deathNote.add(people.remove(index));
//		}
//		return deathNote;
//	}
//	
//	public static void printResult(List<Integer> deathNote) {
//		System.out.print("<");
//		 
//        for (int i = 0; i < deathNote.size(); i++) {
//            System.out.print(deathNote.get(i));
//            // 마지막 숫자를 출력하기 전까지
//            if (i != deathNote.size() - 1) {
//                System.out.print(", ");
//            }
//        }
//        
//        System.out.print(">");
//	}
}
