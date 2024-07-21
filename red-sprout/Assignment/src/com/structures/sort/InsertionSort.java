package com.structures.sort;

import java.util.Arrays;

public class InsertionSort implements ISort{
	private int[] arr;
	private int cnt;
	
	public InsertionSort(int[] arr) {
		this.arr = arr;
		this.cnt = 0;
	}

	@Override
	public void run() {
		for(int i = 1; i < arr.length; i++) {
			int target = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > target) {
				arr[j + 1] = arr[j];
				j--;
				cnt++;
			}
			arr[j + 1] = target;
		}
	}

	@Override
	public int count() {
		return cnt;
	}

	@Override
	public void print() {
		System.out.println(Arrays.toString(arr));
	}

}
