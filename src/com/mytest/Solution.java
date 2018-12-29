package com.mytest;

public class Solution {
	public int solution(int[] A) {
        if (A == null || A.length < 2) {
        	return 0;
        }
        int increase = 0;
        int decrease = 0;
        int equal = 0;
        int index = 0;
        while (index < A.length) {
        	int temp1 = index;
        	while (temp1 < A.length - 1 && A[temp1] < A[temp1 + 1]) {
        		increase ++;
        		temp1 ++;
        	}
        	int temp2 = index;
        	while (temp2 < A.length - 1 && A[temp2] > A[temp2 + 1]) {
        		decrease ++;
        		temp2 ++;
        	}
        	int temp3 = index;
        	while (temp3 < A.length - 1 && A[temp3] == A[temp3 + 1]) {
        		equal ++;
        		temp3 ++;
        	}
        	index ++;
        }
        return increase + decrease + equal; 
    }
	
	public static void main(String[] args) {
		int[] A = {1,2,4,7,6,6,6,2,0};
		Solution s = new Solution();
		int result = s.solution(A);
		System.out.print(result);
	}
}
