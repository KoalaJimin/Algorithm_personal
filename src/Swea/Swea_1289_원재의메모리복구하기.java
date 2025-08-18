package Swea;

import java.util.Scanner;

public class Swea_1289_원재의메모리복구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			String memory = sc.next();
	        // 문자열을 한 글자씩 배열로 분리
	        int[] arr = new int[memory.length()];
	        int[] initial = new int[memory.length()];
			//초기메모리 세팅
			for (int j = 0; j < arr.length; j++) {
				arr[j] = memory.charAt(j) - '0';
				initial[j] = 0;				
			}
			
			int count = 0;
			boolean isFinish = false;
			while (!isFinish) {
				for (int j = 0; j < arr.length; j++) {
					if(arr[j] != initial[j]) {
						for(int k = j; k < memory.length(); k++) {
							if(initial[k] == 0) {
								initial[k] = 1;
							} else if(initial[k] == 1) {
								initial[k] = 0;
							}
						}
						count++;
						break;
					}
				}
				
				int finishCount = 0;
				for (int j = 0; j < memory.length(); j++) {
					if(arr[j] != initial[j]) {
						break;
					} 
					finishCount++;
				}
				if(finishCount == memory.length()) isFinish = true;
			}
			
			System.out.println("#" + i + " " + count);
		}
	}
}
