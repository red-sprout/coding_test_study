package com.structures.sort;

import java.util.Arrays;

public class BubbleSort implements ISort{
	private int[] arr;
	private int cnt;
	
	public BubbleSort(int[] arr) {
		this.arr = arr;
		this.cnt = 0;
	}
	
	@Override
	public void run() {
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < arr.length - i; j++) {
				cnt++;
				if(arr[j] > arr[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}

	private void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
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
