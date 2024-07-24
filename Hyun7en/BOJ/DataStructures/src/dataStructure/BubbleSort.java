package dataStructure;

/*
 * <버블 정렬>
 * 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘
 * 인접한 2개의 레코드를 비교하여 크기가 순서대로 되어 있지 않으면 서로 교환한다.
 * 선택 정렬과 기본 개념이 유사하다.
 * 
 * (장점)
 * 구현이 매우 간단하다.
 * 
 * (단점)
 * 순서에 맞지 않은 요소를 인접한 요소와 교환한다.
 * 하나의 요소가 가장 왼쪽에서 가장 오른쪽으로 이동하기 위해서는 배열에서 모든 다른 요소들과 교환되어야 한다.
 * 특히 특정 요소가 최종 정렬 위치에 이미 있는 경우라도 교환되는 일이 일어난다.
 * 일반적으로 자료의 교환 작업(SWAP)이 자료의 이동 작업(MOVE)보다 더 복잡하기 때문에 버블 정렬은 단순성에도 불구하고 거의 쓰이지 않는다.
 * 
 * O(n^2)
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {3,5,4,2,1};
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}
	
	private static void bubbleSort(int[] arr) {
		bubbleSort(arr,arr.length - 1);
	}
	
	private static void bubbleSort(int[] arr, int last) {
		if(last > 0) {
			for(int i = 1; i <= last; i++) {
				if(arr[i - 1] > arr[i]) {
					swap(arr, i -1 , i);
				}
			}
			bubbleSort(arr, last - 1);
		}
	}
	
	private static void swap(int[] arr, int source, int target) {
		int tmp = arr[source];
		arr[source] = arr[target];
		arr[target] = tmp;
	}
	
	//배열 출력
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data + ",");
		}
		System.out.println();
	}
}
