package Swea;

import java.util.Scanner;

public class Swea_25587_타일배치하기 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			int[] dp = new int[N+1];

	        dp[1] = 1;
	        if (N >= 2) dp[2] = 2;

	        for (int i = 3; i <= N; i++) {
	            dp[i] = dp[i-1] + dp[i-2];
	        }

	        System.out.println("#" + t + " " + dp[N]);
		}
	}

}
