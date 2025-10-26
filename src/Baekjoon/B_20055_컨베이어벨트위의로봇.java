package Baekjoon;

import java.util.Scanner;

public class B_20055_컨베이어벨트위의로봇 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 벨트 위 칸 수 (한쪽)
        int K = sc.nextInt();  // 내구도가 0인 칸이 K개 이상이면 종료

        int size = 2 * N;      // 벨트 전체 길이
        int[] belt = new int[size];
        for (int i = 0; i < size; i++) {
            belt[i] = sc.nextInt();
        }

        boolean[] robot = new boolean[N];  // 로봇 위치 관리 (0~N-1까지만)
        int zeroCnt = 0;
        int step = 0;

        while (true) {
            step++;

            // 1️ 벨트 회전
            int last = belt[size - 1];
            for (int i = size - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = last;

            // 로봇 회전
            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;   // 올라가는 위치에는 회전 시 로봇 없음
            robot[N - 1] = false; // 내리는 위치 로봇 내림

            // 2️ 로봇 이동
            for (int i = N - 2; i >= 0; i--) {
                if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    belt[i + 1]--;
                }
            }
            robot[N - 1] = false; // 내리는 위치 로봇 내림

            // 3️ 올라가는 위치에 로봇 올리기
            if (belt[0] > 0 && !robot[0]) {
                robot[0] = true;
                belt[0]--;
            }

            // 4️ 내구도 0 칸 개수 세기
            zeroCnt = 0;
            for (int durability : belt) {
                if (durability == 0) zeroCnt++;
            }

            // 5️ 종료 조건
            if (zeroCnt >= K) break;
        }

        System.out.println(step);
	}

}
