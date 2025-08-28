package Baekjoon;

import java.util.Scanner;

public class B_1012_유기농배추 {
	static int[][] ground;
	static boolean[][] visited;
	static int m,n,k;
	static int[] dx = {-1,1,0,0}; 
	static int[] dy = {0,0,-1,1}; 
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();
			
			ground = new int[m][n];
			visited = new boolean[m][n];
			
			for (int j = 0; j < k; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				ground[x][y] = 1; 
			}
			
			int count = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(!visited[i][j] && ground[i][j] == 1) {
						dfs(i, j);
						count++;							
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int h = 0; h < 4; h++) {
			int nx = x + dx[h];
			int ny = y + dy[h];
			
			if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
			if (visited[nx][ny]) continue;
			
			if (ground[nx][ny] == 1) dfs(nx, ny);
		}
	}
}
