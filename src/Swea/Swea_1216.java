package Swea;

import java.util.Scanner;

//다시 풀어야됨 이거 gpt 코드 
public class Swea_1216 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt(); // 테스트 케이스 번호 (무시해도 됨)
			char[][] arr = new char[100][100];

			// 입력 받기
			for (int i = 0; i < 100; i++) {
				String line = sc.next();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = line.charAt(j);
				}
			}

			int maxLen = 1; // 회문의 최소 길이는 1

			// 가로 방향 회문 찾기
			for (int i = 0; i < 100; i++) {
				for (int start = 0; start < 100; start++) {
					for (int end = 99; end >= start; end--) {
						int len = end - start + 1;

						// 이미 찾은 최대 길이보다 짧으면 건너뜀
						if (len <= maxLen) break;

						boolean isPalindrome = true;
						for (int k = 0; k < len / 2; k++) {
							if (arr[i][start + k] != arr[i][end - k]) {
								isPalindrome = false;
								break;
							}
						}
						if (isPalindrome) maxLen = len;
					}
				}
			}

			// 세로 방향 회문 찾기
			for (int j = 0; j < 100; j++) {
				for (int start = 0; start < 100; start++) {
					for (int end = 99; end >= start; end--) {
						int len = end - start + 1;

						if (len <= maxLen) break;

						boolean isPalindrome = true;
						for (int k = 0; k < len / 2; k++) {
							if (arr[start + k][j] != arr[end - k][j]) {
								isPalindrome = false;
								break;
							}
						}
						if (isPalindrome) maxLen = len;
					}
				}
			}

			System.out.println("#" + T + " " + maxLen);
		}
	}
}
