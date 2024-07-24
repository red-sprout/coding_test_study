package com.structures.sort;

import java.util.Arrays;

public class SelectionSort implements ISort{
	private int[] arr;
	private int cnt;
	
	public SelectionSort(int[] arr) {
		this.arr = arr;
		this.cnt = 0;
	}

	@Override
	public void run() {
		for(int i = 0; i < arr.length - 1; i++) {
			int idx = i;
			for(int j = i + 1; j < arr.length; j++) {
				cnt++;
				if(arr[j] < arr[idx]) {
					idx = j;
				}
			}
			swap(i, idx);
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
