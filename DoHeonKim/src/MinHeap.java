public class MinHeap {
	public static void main(String[] args) {
		
		int[] array = {0, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		
		int size = array.length;	
		//힙 구현
//		printHeapArray(build_min_heap(array));
		
		//힙 정렬
		printHeapArray(heapSort(array, build_min_heap(array), size));
	}
	
	//힙 구현
	public static int[] build_min_heap(int[] arr) {
		int size = arr.length;
		int[] heap = new int[size + 1];
		
		System.arraycopy(arr, 0, heap, 1, size);
		
		for(int i = size/2; i >=1 ; i--) {
				min_heapify(i,size, heap);
		}
		
		return heap;
	}
	
	//힙 구조로 재배열 하는 함수
	public static void min_heapify(int i,int size, int[] heap) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int smallest;
		
		//왼쪽 자식 노드와 비교
		if(left <= size && heap[left] < heap[i]) {
			smallest = left;
		} else {
			smallest = i;
		}
		
		//위에서 비교한 값과 오른쪽 자식 노드와 비교
		if (right <= size && heap[right] < heap[smallest]) {
			smallest = right;
		}
		
		//자식 노드가 더 작으면 위치를 바꾸고, min_heapify 재귀호출
		if(smallest != i) {
			swap(i, smallest, heap);
			min_heapify(smallest,size, heap	);
		}
		
	}
	//두 요소의 위치를 바꿈
	public static void swap(int i, int j, int[] heap) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	//힙 배열 출력
	public static void printHeapArray(int[] heap) {
		for(int i = 1 ; i <= heap.length-1; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
	
	//힙 정렬
	public static int[] heapSort(int[] array, int heap[],int size) {
		int j = 0;
		for(int i = size; i >= 2 ; i--) {
			array[j] = heap[1];	
			j++;		
			swap(1,i, heap);
			size--;
			min_heapify(1,size,heap);
		}
		
		array[j] = heap[1];	
		
		return array;
	}

}
