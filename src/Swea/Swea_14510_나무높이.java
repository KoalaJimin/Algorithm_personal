package Swea;

import java.util.Scanner;

public class Swea_14510_나무높이 {

    static boolean feasible(long d, long ones, long twos) {
        long oddDays = (d + 1) / 2;   // ceil(d/2)
        long evenDays = d / 2;        // floor(d/2)

        if (oddDays < ones) return false; // 홀수 diff 처리 불가

        long extraOdd = oddDays - ones;           // 남는 홀수 날
        long reducedTwos = twos - (extraOdd / 2); // 홀수 2개로 짝수 1개 대체
        if (reducedTwos < 0) reducedTwos = 0;

        return reducedTwos <= evenDays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            int max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] > max) max = arr[i];
            }

            // 각 나무가 max까지 가려면 필요한 증가량
            long ones = 0; // 홀수 +1이 꼭 필요한 개수(초기 odd 차이 개수)
            long twos = 0; // +2가 필요한 총 횟수 합

            for (int i = 0; i < n; i++) {
                int diff = max - arr[i];
                if (diff <= 0) continue;
                twos += diff / 2;
                ones += diff % 2; // diff가 홀수면 +1 한 번은 반드시 필요
            }

            // 이분 탐색으로 최소 일수 d 찾기
            long lo = 0, hi = Math.max(0, 2 * (twos + ones)) + 5; // 안전 상한
            while (lo < hi) {
                long mid = (lo + hi) / 2;
                if (feasible(mid, ones, twos)) hi = mid;
                else lo = mid + 1;
            }

            System.out.println("#" + t + " " + lo);
        }
    }
}
