package dataStructure;

/*
 * <선택 정렬>(비교정렬, 제자리 정렬)(불안정 정렬)
 * 처리되지 않은 데이터 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸는 것을 반복
 * 
 * 정렬과정
 * 1.주어진 리스트에서 최솟값을 찾는다
 * 2.최솟값을 맨 앞자리의 값과 교환한다.
 * 3.맨 앞자리를 제외한 나머지 값들 중 최솟값을 찾아 위와 같은 방법으로 반복한다.
 * 
 * O(n^2)
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {3,6,1,8,2,4};
		printArray(arr);
		selectionSort(arr);
		printArray(arr);
	}
	
	private static void selectionSort(int[] arr) {
		selectionSort(arr,0);
	}
	
	private static void selectionSort(int[] arr, int start) {
		if(start < arr.length - 1) {
			int min_index = start;
			for(int i = start; i < arr.length; i++) {
				if(arr[i] < arr[min_index]) min_index = i;
			}
			swap(arr, start,min_index);
			selectionSort(arr,start + 1);
		}
	}
	
	//데이터 교환할 수 있게 해주는 swap 함수 C++엔 있으나 Java엔 없음
	private static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
	
	//배열 출력
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data + ",");
		}
		System.out.println();
	}
}
