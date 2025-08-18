package Swea;

import java.util.Scanner;

public class Swea_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();		
		for(int test_case = 1; test_case <= T; test_case++) {
			//입력
			int N = sc.nextInt();
			String[][] arr = new String[N][N];
			
			for(int i = 0; i < N; i++) {
				String num = sc.next();
				for(int j = 0; j < N; j++) {
					arr[i][j] = num.substring(j, j + 1);
				}	
			}	
			
			//로직
			/* 가운데 줄 다 더하고
			 * 가운데 기준 위 / 아래 나눠서 더하기 			  
			 */
			int sum = 0;
			//가운데 인덱스
			int mid = N / 2;
			for(int j = 0; j < N; j++) {
				sum += Integer.parseInt(arr[mid][j]);
			}	
			
			//위
			int start = 1;
			int end = N-1;
			for(int i = mid - 1; i >= 0; i--) {
				for(int j = start; j < end; j++) {
					sum += Integer.parseInt(arr[i][j]);
				}	
				start++;
				end--;
			}
			
			//아래 
			start = 1;
			end = N-1;
			for(int i = mid + 1; i < N; i++) {
				for(int j = start; j < end; j++) {
					sum += Integer.parseInt(arr[i][j]);
				}	
				start++;
				end--;
			}
			
			//출력
			System.out.println("#" + test_case + " " + sum);
		}
	}

}
