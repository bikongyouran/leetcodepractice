package com.mytest;

public class Test {
	
	public long convertIP(String ipAddress) {
		if (ipAddress == null) {
			return 0;
		}
		char[] charArr = ipAddress.toCharArray();
		int i = 0;
		int num = 0;
		boolean isNum = false;
		long result = 0;
		boolean isInvalid = false;
		while (i < charArr.length && num <= 4) {
			isNum = false;
			num++;
			//remove prefix spaces for each part.
			while(i < charArr.length && charArr[i] == ' ') i++;
			
			if (i >= charArr.length) {
				isInvalid = true;
				break;
			}
			int cur = charArr[i] - '0';
			long sum = 0;
			while(i < charArr.length  && cur >= 0 && cur <=9) {
				isNum = true;
				sum = sum * 10 + cur;
				i++;
				if (i < charArr.length)
					cur = charArr[i] - '0';
			}
			if (!isNum) {
				isInvalid = true;
				break;
			}
			//remove suffix spaces for each part.
			while(i < charArr.length && charArr[i] == ' ') i++;
			
			if (i >= charArr.length && num == 4) {
				if(sum > 255) {
					isInvalid = true;
					break;
				} else {
					result |= sum << (4 - num) * 8;
				}
			} else if (i < charArr.length && num < 4) {
				if (charArr[i] == '.') {
					if(sum > 255) {
						isInvalid = true;
						break;
					} else {
						result |= sum << (4 - num) * 8;
					}
				} else {
					isInvalid = true;
					break;
				}
			} else {
				isInvalid = true;
				break;
			}
			i++;
		}
		
		if (isInvalid) {
			return -1;
		} else {
			return result;
		}
		
    }
	
//	public static void main (String[] args) {
//		Test test = new Test();
//		long re = test.solution("...");
//		System.out.println(re);
//		
////		long a = 0;
////		a |= 172L << 24;
////		a |= 168L << 16;
////		a |= 5L << 8;
////		a |= 1L <<0;
////		System.out.print(a);
//		
////		a += 172 * Math.pow(256, 3);
////		a += 168 * Math.pow(256, 2);
////		a += 5 * Math.pow(256, 1);
////		a += 1 * Math.pow(256, 0);
////		System.out.print(a);
//		
//	}
}
