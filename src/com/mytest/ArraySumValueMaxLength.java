package com.mytest;

import java.util.HashMap;
import java.util.Map;

public class ArraySumValueMaxLength {
	public int maxLength(int[] arr, int k) {
		//arr[j+1 ... i] = s(i)-s(j)=k, s(j)=sum(i)-k
		if (arr == null || arr.length == 0)
			return 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(0, -1);
		int maxLength = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i ++) {
			sum += arr[i];
			if (map.containsKey(sum-k)) {
				maxLength = Math.max(i - map.get(sum-k), maxLength);
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return maxLength;
	}
}
