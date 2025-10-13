package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1987_알파벳 {
    static int r, c, maxCount;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Character> checkChar;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        r = sc.nextInt();
        c = sc.nextInt();
        arr = new char[r][c];
        visited = new boolean[r][c];
        
        for (int i = 0; i < r; i++) {
            String line = sc.next();
            for (int j = 0; j < c; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        checkChar = new ArrayList<>();
        dfs(0, 0, 1);
        System.out.println(maxCount);
    }

    private static void dfs(int x, int y, int count) {
        visited[x][y] = true;
        checkChar.add(arr[x][y]);
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 벗어나면 무시
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            // 이미 방문한 좌표는 무시
            if (visited[nx][ny]) continue;
            // 이미 지나온 알파벳이면 무시
            if (!check(nx, ny)) continue;

            dfs(nx, ny, count + 1);
        }

        // 백트래킹 (다른 경로 탐색 위해 상태 복원)
        visited[x][y] = false;
        checkChar.remove(checkChar.size() - 1);
    }

    // check() 이미 지나온 알파벳인지 확인
    private static boolean check(int nx, int ny) {
        for (char c : checkChar) {
            if (c == arr[nx][ny]) return false;
        }
        return true;
    }
}
