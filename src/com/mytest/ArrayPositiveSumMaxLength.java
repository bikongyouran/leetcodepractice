package com.mytest;

public class ArrayPositiveSumMaxLength {
	//array elements are all positive, not sorted.
	public int getMaxLength(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k < 1)
			return 0;
		int left = 0;
		int right = 0;
		int sum = arr[0];
		int maxLength = 0;
		while (right < arr.length) {
			if (sum == k) {
				maxLength = Math.max(maxLength, right - left + 1);
				sum -= arr[left];
				left ++;
			} else if (sum < k) {
				right ++;
				if (right == arr.length)
					break;
				sum += arr[right];
			} else {
				sum -= arr[left];
				left ++;
			}
		}
		return maxLength;
	}
}
