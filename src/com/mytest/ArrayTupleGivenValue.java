package com.mytest;

public class ArrayTupleGivenValue {
	//array is sorted.
	public void printUniquePair(int[] arr, int k) {
		if (arr == null || arr.length < 2)
			return;
		int i = 0;
		int j = arr.length - 1;
		while (i < j && i < arr.length && j > -1) {
			if (arr[i] + arr[j] == k) {
				if (i == 0 || (arr[i - 1] != arr[i])) {
					System.out.println(arr[i] + "," + arr[j]);
				}
				i ++;
				j --;
			} else if (arr[i] + arr[j] < k) {
				i ++;
			} else {
				j --;
			}
			
		}
			
	}
}
