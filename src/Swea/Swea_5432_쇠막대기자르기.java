package Swea;

import java.util.Scanner;

public class Swea_5432_쇠막대기자르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String line = sc.next();
			int open = 0; // 열린 괄호 '(' 수
			int result = 0;

			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '(') {
					open++;
				} else { // ')'
					open--; // 일단 열린 괄호 하나 닫음
					if (line.charAt(i - 1) == '(') {
						// 레이저인 경우
						result += open;
					} else {
						// 막대기의 끝
						result += 1;
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

}
