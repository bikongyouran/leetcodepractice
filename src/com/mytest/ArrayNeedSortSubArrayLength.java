package com.mytest;

public class ArrayNeedSortSubArrayLength {
	//scan from left and right independently, get the min and max border.
	//initial sort is asc.
	public int getMinLength(int[] arr) {
		if (arr == null || arr.length < 2)
			return 0;
		int min = arr[arr.length - 1];
		int minIndex = -1;
		int max = arr[0];
		int maxIndex = -1;
		
		for (int i = arr.length - 2; i > -1; i --) {
			if (arr[i] > min) {
				minIndex = i;
			} else {
				min = arr[i];
			}
		}
		if (minIndex == -1)
			return 0;//sorted already.
		
		for (int i = 1; i < arr.length; i ++) {
			if (arr[i] < max) {
				maxIndex = i;
			} else {
				max = arr[i];
			}
		}
		
		return max - min + 1;
	}
}
