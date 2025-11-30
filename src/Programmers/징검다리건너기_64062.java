package Programmers;


import java.util.*;

class 징검다리건너기_64062 {
    public int main(int[] stones, int k) {
        int left = 1;
        int right = Arrays.stream(stones).max().getAsInt();
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(stones, k, mid)) {
                answer = mid;     // mid명 가능 → 더 큰 값 탐색
                left = mid + 1;
            } else {
                right = mid - 1;  // mid명 불가능 → 줄여야 함
            }
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int mid) {
        int zeroCount = 0;

        for (int stone : stones) {
            if (stone - mid <= 0) {
                zeroCount += 1;
            } else {
                zeroCount = 0;
            }

            if (zeroCount >= k) return false;
        }

        return true;
    }
}
