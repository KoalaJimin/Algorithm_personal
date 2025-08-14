package Swea;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Swea_1247_최적경로 {
 
	static int N;
    static int[] company, home;
    static int[][] customer;
    static boolean[] visited;
    static int minDistance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            company = new int[]{sc.nextInt(), sc.nextInt()};
            home = new int[]{sc.nextInt(), sc.nextInt()};
            customer = new int[N][2];
            for (int i = 0; i < N; i++) {
                customer[i][0] = sc.nextInt();
                customer[i][1] = sc.nextInt();
            }

            visited = new boolean[N];
            minDistance = Integer.MAX_VALUE;
            dfs(company[0], company[1], 0, 0);

            System.out.println("#" + test_case + " " + minDistance);
        }
    }

    public static void dfs(int x, int y, int count, int distance) {
        // 가지치기
        if (distance >= minDistance) return;
        
        if (count == N) {
            distance += calcDistance(x, y, home[0], home[1]);
            minDistance = Math.min(minDistance, distance);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(customer[i][0], customer[i][1], count + 1,
                    distance + calcDistance(x, y, customer[i][0], customer[i][1]));
                visited[i] = false;
            }
        }
    }
	
	public static int calcDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
