package Swea;

import java.util.Scanner;

public class Swea_11315_오목판정 {
    static int[] dx = {0, 1, 1, 1}; 
    static int[] dy = {1, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            char[][] omok = new char[n][n];
            for (int i = 0; i < n; i++) {
                String line = sc.next();
                for (int j = 0; j < n; j++) {
                    omok[i][j] = line.charAt(j); 
                }
            }

            String answer = "NO";
            boolean found = false; // 오목 찾았는지 여부

            for (int i = 0; i < n && !found; i++) {
                for (int j = 0; j < n && !found; j++) {
                    if (omok[i][j] == 'o') {
                        for (int dir = 0; dir < 4 && !found; dir++) {
                            int count = 1; // 자기 자신 포함
                            int nx = i;
                            int ny = j;
                            for (int k = 1; k < 5; k++) {
                                nx += dx[dir];
                                ny += dy[dir];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
                                if (omok[nx][ny] == 'o') count++;
                                else break;
                            }
                            if (count >= 5) {
                                answer = "YES";
                                found = true; // 플래그 세우고 탈출
                            }
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
