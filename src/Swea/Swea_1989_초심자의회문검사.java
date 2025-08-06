package Swea;

import java.util.Scanner;

public class Swea_1989_초심자의회문검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			String targetStr = sc.next();
			int result = 0;
			for (int i = 0; i <= targetStr.length() % 2; i++) {
				if (targetStr.charAt(i) == targetStr.charAt(targetStr.length()-1-i)) {
					result = 1;
				} else {
					result = 0;
					break;
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}
