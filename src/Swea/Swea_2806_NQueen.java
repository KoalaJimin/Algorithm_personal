package Swea;

import java.util.Scanner;

public class Swea_2806_NQueen {
    static int N;
    static int count;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            count = 0;
            col = new boolean[N];
            diag1 = new boolean[2 * N - 1]; // 행+열
            diag2 = new boolean[2 * N - 1]; // 행-열+N-1

            solve(0);
            System.out.println("#" + t + " " + count);
        }
    }

    static void solve(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (!col[c] && !diag1[row + c] && !diag2[row - c + N - 1]) {
                col[c] = diag1[row + c] = diag2[row - c + N - 1] = true;
                solve(row + 1);
                col[c] = diag1[row + c] = diag2[row - c + N - 1] = false; // 되돌리기
            }
        }
    }
}
