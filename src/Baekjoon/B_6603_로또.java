package Baekjoon;

import java.util.Scanner;

public class B_6603_로또 {
	static int k;
	static int[] arr;
	static int[] selected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			k = sc.nextInt(); // 집합 크기 입력
	        if (k == 0) break; // 0이면 종료
			
	        arr = new int[k];
			selected = new int[6];
			
			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}
			
			comb(0,0);
			System.out.println();
		}
	}
	
	private static void comb(int start, int depth) {
		//종료조건
		if(depth == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//start부터 k(=n)까지 돌면서 조합 뽑기 
		for(int i = start; i < k; i++) {
			selected[depth] = arr[i];
			comb(i + 1, depth + 1);
		}
	}

}
