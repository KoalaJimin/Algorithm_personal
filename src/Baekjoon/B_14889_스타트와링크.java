package Baekjoon;

import java.util.Scanner;

public class B_14889_스타트와링크 {
    static int[][] arr;
    static int[] member;
    static int[] selected;
    static int n, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        member = new int[n];
        selected = new int[n/2];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) member[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
        }

        divideTeam(0,0);
        System.out.println(result);
    }

    private static void divideTeam(int start, int depth) {
        if (depth == n/2) {
            calcAbility(selected);
            return;
        }

        for (int i = start; i < n; i++) {
            selected[depth] = member[i];
            divideTeam(i + 1, depth + 1);
        }
    }

    private static void calcAbility(int[] selected) {
        int team1 = 0, team2 = 0;
        boolean[] isSelected = new boolean[n];
        for (int i : selected) isSelected[i] = true;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isSelected[i] && isSelected[j]) team1 += arr[i][j] + arr[j][i];
                if (!isSelected[i] && !isSelected[j]) team2 += arr[i][j] + arr[j][i];
            }
        }

        int diff = Math.abs(team1 - team2);
        result = Math.min(result, diff);
    }
}
