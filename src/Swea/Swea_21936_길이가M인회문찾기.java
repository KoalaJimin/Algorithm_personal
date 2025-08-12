package Swea;

import java.util.Scanner;

public class Swea_21936_길이가M인회문찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String text = sc.next();
			
			String answer = "NONE";
            for (int i = 0; i <= N - M; i++) {
                boolean isPalindrom = true;

                for (int j = 0; j < M / 2; j++) {
                    if (text.charAt(i + j) != text.charAt(i + M - 1 - j)) {
                        isPalindrom = false;
                        break;
                    }
                }

                if (isPalindrom) {
                    answer = text.substring(i, i + M);
                    break; // 첫 번째 회문만 찾으면 종료
                }
            }
			System.out.println("#" + t + " " + answer);
		}
	}
}
