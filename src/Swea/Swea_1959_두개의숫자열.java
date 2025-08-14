package Swea;

import java.util.Scanner;

public class Swea_1959_두개의숫자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();		
		for(int test_case = 1; test_case <= T; test_case++) {
			//입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] a = new int[N];
			int[] b = new int[M];			
			for(int i = 0; i < N; i++) {
				a[i] = sc.nextInt();
			}			
			for(int i = 0; i < M; i++) {
				b[i] = sc.nextInt();
			}
			
			//로직
			//N과 M 중에 더 큰 걸 찾아서, 
			int big = 0, small = 0;
			if (N >= M) {
				big = N;
				small = M;
			} else if (N < M) {
				big = M;
				small = N;
			}			
			
			int total = 0;
			//작은 것의 인덱스 만큼 조정하며 -> pointer 변수 사용  
			int pointer = 0;
			int maxNum = 0;
			while(pointer <= big - small) {
				for(int j = pointer; j < pointer + small; j++) {
					//마주보는 숫자들을 곱하고 더한 다음
					if (N >= M) {
						total += b[j - pointer] * a[j]; 
					} else {
						total += a[j - pointer] * b[j]; 								
					}
				}
				//젤 큰 거 구하기 
				if (maxNum < total) maxNum = total; 
				//초기화 
				total = 0;
				//다음 인덱스로 포인터 변경 
				pointer++;				
			}
			
			System.out.println("#" + test_case + " " + maxNum);
		}
	}
}
