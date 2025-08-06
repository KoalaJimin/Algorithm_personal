package Swea;

import java.util.Scanner;

public class Swea_1210 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = sc.nextInt(); 
            int[][] arr = new int[100][100];
            int startX = 0;
            int startY = 0;

            // 배열 입력 받기 + 도착지점 찾기
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                    if (arr[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            int x = startX;
            int y = startY;

            // 도착점부터 위로 올라가기
            while (x > 0) {
                // 왼쪽으로 계속
                if (y > 0 && arr[x][y - 1] == 1) {
                    while (y > 0 && arr[x][y - 1] == 1) {
                        y--;
                    }
                }
                // 오른쪽으로 계속
                else if (y < 99 && arr[x][y + 1] == 1) {
                    while (y < 99 && arr[x][y + 1] == 1) {
                        y++;
                    }
                }

                // 위로 한 칸 이동
                x--;
            }

            System.out.println("#" + T + " " + y);  // 시작 위치 y좌표 출력
        }
    }
}
