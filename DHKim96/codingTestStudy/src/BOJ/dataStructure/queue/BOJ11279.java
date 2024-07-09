package BOJ.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11279 {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        // 연산의 갯수
	        int N = Integer.parseInt(br.readLine());
	        
	        int[] heap = new int[N + 1]; // 1-based index
	        int heapSize = 0;
	        
	        // 연산
	        // 반복문의 조건과 감소 연산을 하나의 표현식으로 처리 가능
	        while (N-- > 0) {
	            // 연산에 대한 정보
	            int x = Integer.parseInt(br.readLine());
	            
	            if (x > 0) {
	                insert(heap, ++heapSize, x);
	            } else {
	                if (heapSize == 0) {
	                    System.out.println(0);
	                } else {
	                    System.out.println(deleteMax(heap, heapSize--));
	                }
	            }
	        }
	        
	        br.close();
	    }
	    
	    public static void insert(int[] heap, int heapSize, int value) {
	        int i = heapSize;
	        heap[i] = value;
	        
	        while (i > 1 && heap[i / 2] < heap[i]) {
	            swap(heap, i / 2, i);
	            i /= 2;
	        }
	    }
	    // 힙의 삭제
	    // 1. 루트 노드에 마지막 노드 대입
	    // 2. 새로운 루트 노드 값을 자식 노드들과 비교하며 정렬
	    public static int deleteMax(int[] heap, int heapSize) {
	        int maxValue = heap[1];
	        heap[1] = heap[heapSize];
	        heap[heapSize] = 0;
	        
	        int i = 1;
	        while (i * 2 <= heapSize) {
	            int left = i * 2;
	            int right = i * 2 + 1;
	            // 부모 노드
	            int largest = i;
	            
	            if (left < heapSize && heap[left] > heap[largest]) {
	                largest = left;
	            }
	            if (right < heapSize && heap[right] > heap[largest]) {
	                largest = right;
	            }
	            
	            
	            if (largest != i) {
	                swap(heap, i, largest);
	                // 자식 노드를 중점으로 다시 체크하기 위한 연산
	                i = largest;
	            } else {
	                break;
	            }
	        }
	        
	        return maxValue;
	    }
	    
	    public static void swap(int[] heap, int i, int j) {
	        int temp = heap[i];
	        heap[i] = heap[j];
	        heap[j] = temp;
	    }
}
