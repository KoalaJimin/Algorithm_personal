package Swea;

import java.util.Scanner;

public class Swea_1216_회문2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) { // 테스트 케이스 10개
            int testCase = sc.nextInt();
            char[][] arr = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String line = sc.next();
                arr[i] = line.toCharArray();
            }

            int maxLen = 0;

            // 100부터 길이 체크 -> 최대 길이 먼저 찾기 위해
            for (int len = 100; len > 0; len--) {
                boolean found = false;

                // 행 검사
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j <= 100 - len; j++) {
                        int left = j;
                        int right = j + len - 1;
                        boolean palindrome = true;
                        while (left < right) {
                            if (arr[i][left] != arr[i][right]) {
                                palindrome = false;
                                break;
                            }
                            left++;
                            right--;
                        }
                        if (palindrome) {
                            maxLen = len;
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }

                /*if (!found) {
                    // 열 검사
                    for (int j = 0; j < 100; j++) {
                        for (int i = 0; i <= 100 - len; i++) {
                            int top = i;
                            int bottom = i + len - 1;
                            boolean palindrome = true;
                            while (top < bottom) {
                                if (arr[top][j] != arr[bottom][j]) {
                                    palindrome = false;
                                    break;
                                }
                                top++;
                                bottom--;
                            }
                            if (palindrome) {
                                maxLen = len;
                                found = true;
                                break;
                            }
                        }
                        if (found) break;
                    }
                }

                if (found) break; // 가장 긴 길이 찾으면 종료*/
            }

            System.out.println("#" + testCase + " " + maxLen);
        }
    }

}
