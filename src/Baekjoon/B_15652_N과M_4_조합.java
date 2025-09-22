package Baekjoon;

import java.util.Scanner;

public class B_15652_N과M_4_조합 {
	static int n, r;
	static int[] arr;
	static int[] selected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		r = sc.nextInt();
		arr = new int[n];
		selected = new int[r];
		
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		
		comb(0,0);

	}

	private static void comb(int start, int depth) {
		//종료조건
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//start부터 n까지 돌면서 조합 뽑기 
		for (int i = start; i < n; i++) {
			selected[depth] = arr[i];
			comb(i, depth + 1);
		}
		
	}

}
