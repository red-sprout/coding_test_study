package dataStructure;

/*
 * <삽입 정렬>
 * 
 * (장점)
 * 1. 추가적인 메모리 소비가 작다.
 * 2. 거의 정렬 된 경우 매우 효율적이다. 즉, 최선의 경우 O(N)의 시간복잡도를 갖는다.
 * 3. 안장정렬이 가능하다.
 * 
 * (단점)
 * 1. 역순에 가까울 수록 매우 비효율적이다. 즉, 최악의 경우 O(N2)의 시간 복잡도를 갖는다.
 * 2. 데이터의 상태에 따라서 성능 편차가 매우 크다.
 * 
 * Bubble Sort나 Selection Sort 와 이론상 같은 시간복잡도를 갖음에도 
 * 평균 비교 횟수에 대한 기대값이 상대적으로 적기 때문에 
 * 평균 시간복잡도가 O(N2) 인 정렬 알고리즘 중에서는 빠른편에 속하는 알고리즘임.
 * 
 *  O(n^2)
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {1,4,3,2,8,6};
		printArray(arr);
		insertionSort(arr);
		printArray(arr);		
	}
	
	private static void insertionSort(int[] arr) {
		insertionSort(arr, arr.length);
	}
	
	private static void insertionSort(int[] arr, int n) {
		// 배열의 크기가 1이면 이미 정렬된 것으로 간주
		if (n <= 1) {
			return;
		}
		
		// 배열의 첫 n-1 요소를 재귀적으로 정렬.
		insertionSort(arr, n - 1);

		// 마지막 요소를 적절한 위치에 삽입.
		int last = arr[n - 1];
		int j = n - 2;

		// last 요소보다 큰 요소들을 오른쪽으로 이동.
		while (j >= 0 && arr[j] > last) {
			arr[j + 1] = arr[j];
			j--;
		}

		// last 요소를 적절한 위치에 삽입.
		arr[j + 1] = last;
	}
	
	//배열 출력
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data + ",");
		}
		System.out.println();
	}
}
