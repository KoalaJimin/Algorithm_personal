package Baekjoon;

import java.util.Scanner;

public class B_2468_안전영역 {
	static int[][] ground;
	static int[][] check;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n, count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		visited = new boolean[n][n];
		ground = new int[n][n];
		check = new int[n][n];
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ground[i][j] = sc.nextInt();
				max = Math.max(max, ground[i][j]);
			}
		}
		
		int answer = 0;
		for (int k = 0; k <= max; k++) { //비가 안 올 때도 고려해야해서 0부터 시작해야 해요 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (k >= ground[i][j]) {
						check[i][j] = 1;
					}
				}
			}			
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && check[i][j] == 0) {
						count++;
						dfs(i, j);
					}
				}
			}
			check = new int[n][n];
			visited = new boolean[n][n];
			
			answer = Math.max(answer, count);
			count = 0;
		}
		
		System.out.println(answer);

	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int j = 0; j < 4; j++) {
			int nx = x + dx[j];
			int ny = y + dy[j];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			if (visited[nx][ny]) continue;
			
			if (check[nx][ny] == 0) dfs(nx, ny);
		}
		
	}
	
}
