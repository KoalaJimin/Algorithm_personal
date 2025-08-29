package Swea;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Swea_4128_요리사 {
	static int n;
	static int[][] food;
	static int N = 4; //전체 원소 개수 
	static int R = 2; //뽑을 개수
	static int[] arr = {0,1,2,3};
	static boolean[] selected; //선택 여부 체크 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					food[i][j] = sc.nextInt();
				}
			}
			
			//로직
			/*
			 * 
			 * 
			 * 
			 * */
			
			
			
			
			
			
			
			
		}
	}
	//조합 함수
	//start -> 다음 반복에서 어디서부터 원소를 뽑을지 결정하는 인덱스
	//depth -> 현재 몇 개를 뽑았는지 (0부터 시작)
	static void comb(int start, int depth) {
		//start부터 N까지 돌면서 조합 뽑기 
		for (int i = start; i < N; i++) {
			selected[i] = true; //i번째 원소 선택 
			comb(i + 1, depth + 1); //재귀 호출 
			selected[i] = false; //선택 해제 (백트래킹) 
		}
		
		if (depth == R) { //R개 뽑았을 때 
			//선택된 조합 출력 
			for(int i = 0; i < N; i++) {
				if (selected[i]) System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
	}
	
//	public static void pickAB() {
//		used = new boolean[n];
//		int[] ab = new int[n];
//		for (int i = 0; i < n; i++) {
//			ab[i] = i+1;
//		}
//		
//		int[] line = new int[4];
//		for (int i = 0; i < n; i++) {
//			if (!used[i]) {
//				line[i] = ab[i];
//			}
//		}		
//	}

}
