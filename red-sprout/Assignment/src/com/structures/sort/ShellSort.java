package com.structures.sort;

import java.util.Arrays;

public class ShellSort implements ISort {
	private int[] arr;
	private int cnt;
	
	public ShellSort(int[] arr) {
		this.arr = arr;
		this.cnt = 0;
	}
	
	@Override
	public void run() {
		int size = arr.length;
		for(int gap = size / 2; gap > 0; gap /= 2) {
			for(int i = gap; i < size; i++) {
				int tmp = arr[i];
				int j = i;
				while (j >= gap && arr[j - gap] > tmp) {
					cnt++;
	                arr[j] = arr[j - gap];
	                j -= gap;
	            }
	            arr[j] = tmp;
			}
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
