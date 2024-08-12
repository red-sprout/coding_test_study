package com.example.bs;

public class LowerBound {
	public static void main(String[] args) {
		int[] arr = {1,1,3,3,3,3,3,3,3,4,5};
		int left = 0;
		int right = arr.length - 1;
		int answer = 0;
		int target = 2;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] < target) {
				left = mid + 1;
			} else {
				answer = mid;
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
