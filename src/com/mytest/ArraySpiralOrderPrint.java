package com.mytest;

public class ArraySpiralOrderPrint {
	public void spiralOrderPrint (int[][] matrix) {
		int tr = 0;
		int tc = 0;
		int dr = matrix.length - 1;
		int dc = matrix[0].length - 1;
		while (tr <= dr && tc <= dc) {
			helper(matrix,tr++,tc++,dr--,dc--);
		}
	}
	
	private void helper(int[][] matrix, int tr, int tc, int dr, int dc) {
		if (tr == dr) {// only 1 row
			for (int i = tc; i <= dc; i++) {
				System.out.print(matrix[tr][i] + " ");
			}
		} else if (dc == tc) {// only 1 column
			for (int i = tr; i <= dr; i++) {
				System.out.print(matrix[i][dc] + " ");
			}
		} else {
			int r = tr;
			int c = tc;
			while (c < dc) {
				System.out.print(matrix[tr][c] + "");
				c++;
			}
			while (r < dr) {
				System.out.print(matrix[r][dc] + "");
				r++;
			}
			while (c > tc) {
				System.out.print(matrix[dr][c] + "");
				c--;
			}
			while (r > tr) {
				System.out.print(matrix[r][tc] + "");
				r--;
			}
		}
	}
}
