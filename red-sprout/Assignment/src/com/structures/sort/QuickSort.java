package com.structures.sort;

import java.util.Arrays;

public class QuickSort implements ISort {
	private int[] arr;
	private int cnt;
	
	public QuickSort(int[] arr) {
		this.arr = arr;
		this.cnt = 0;
	}
	
	@Override
	public void run() {
		quickSort(0, arr.length - 1);
	}
	
	private void quickSort(int start, int end) {
	    cnt++;
	    if(start >= end) return;
	    int pivot = start;
	    int lo = start + 1;
	    int hi = end;

	    while(lo <= hi) {
	        while(lo <= end && arr[pivot] >= arr[lo]) lo++;
	        while(hi > start && arr[pivot] <= arr[hi]) hi--;
	        if(lo > hi) {
	            swap(hi, pivot);
	        } else {
	            swap(lo, hi);
	        }
	    }

	    quickSort(start, hi - 1);
	    quickSort(hi + 1, end);
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
