package Baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B_2178_미로탐색 {
	static int n, m, result;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dist;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		result = 0;
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		dist = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		//로직 
		//출발 1,1   도착 n, m
		bfs();
		System.out.println(result);
	}
	static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		
		q.add(new int[]{0,0});
		visited[0][0] = true;
		dist[0][0] = 1; // 시작 칸도 포함해야 하므로 1

		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			if (x == n-1 && y == m-1) {
			    result = dist[x][y];
			    return;
			}

			
			for (int h = 0; h < 4; h++) {
				int nx = x + dx[h];
				int ny = y + dy[h];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (visited[nx][ny] || map[nx][ny] == 0) continue;
				
				visited[nx][ny] = true; //방문처리
				dist[nx][ny] = dist[x][y] + 1;
				q.offerLast(new int[] {nx, ny}); //다음으로 확장 
			}
		}
	}

}
