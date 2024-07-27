package com.structures.sort;

import java.util.Arrays;

public class MergeSort implements ISort {
	private int[] arr;
	private int cnt;
	
	public MergeSort(int[] arr) {
		this.arr = arr;
		this.cnt = 0;
	}
	
	@Override
	public void run() {
		mergeSort(0, arr.length - 1);
	}
	
	private void mergeSort(int start, int end) {
		cnt++;
		if(start >= end) return;
		int mid = (start + end) / 2;
		mergeSort(start, mid);
		mergeSort(mid + 1, end);
		merge(start, mid, end);
	}
	
	private void merge(int start, int mid, int end) {
		int[] result = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		
		int idx = 0;	
		while(i <= mid && j <= end) {
			if(arr[i] < arr[j]) {
				result[idx++] = arr[i++];
			} else {
				result[idx++] = arr[j++];
			}
		}
		
		while(i <= mid) result[idx++] = arr[i++];
		while(j <= end) result[idx++] = arr[j++];
		
		idx = 0;
		for(int k = start; k <= end; k++) {
			arr[k] = result[idx++];
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
