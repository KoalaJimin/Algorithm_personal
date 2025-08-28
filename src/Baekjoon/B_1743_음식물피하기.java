package Baekjoon;

import java.util.Scanner;

public class B_1743_음식물피하기 {
	static int[][] trash;
	static boolean[][] visited;
	static int n, m, k, count;	
	static int[] dx = {-1,1,0,0}; 
	static int[] dy = {0,0,-1,1}; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		trash = new int[n][m];
		visited = new boolean[n][m];
		
		
		for (int j = 0; j < k; j++) {
			int x = sc.nextInt()-1; 
			int y = sc.nextInt()-1; 
			trash[x][y] = 1;
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && trash[i][j] == 1) {
					count = 0;
					dfs(i, j);
					
					max = Math.max(max, count);
				}
			}
		}
		
		System.out.println(max);
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		count++;
		
		for (int h = 0; h < 4; h++) {
			int nx = x + dx[h];
			int ny = y + dy[h];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if (visited[nx][ny] == true) continue;

			if (trash[nx][ny] == 1) dfs(nx, ny);
		}

	}
}
