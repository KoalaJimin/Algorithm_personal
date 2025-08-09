package Swea;

import java.util.Scanner;

public class Swea_9386 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test_case = 1; test_case <= t; test_case++) {
			//입력
			int N = sc.nextInt();
			String input = sc.next();
			
			//로직
			//1다음에 또 1이면 셀 count 
			int count = 0;
			//1끝나면 현재 1로 만들어진 숫자 저장
			int currentCount = 0;
			
			for(int i = 0; i < N; i++){
				char ch = input.charAt(i);
				if (ch == '1') {
					//count업
					count++;
					//뒤가 0이면 1 끝남 
					if (i == N-1 || (input.charAt(i + 1) == '0' && i != N-1)) {
						if (currentCount < count) {	
							currentCount = count;
						}
						count = 0;						
					}
				} 
			}	
		
			//출력
			System.out.println("#" + test_case + " " + currentCount);
		}		
	}

}
