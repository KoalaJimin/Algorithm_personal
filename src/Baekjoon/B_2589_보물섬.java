package Baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B_2589_보물섬 {
	static int x, y;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0}; 
	static int[] dy = {0,0,-1,1}; 
	
	public static void main(String[] args) {
//		육지(L) / 바다(W)
//		보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다. 
//		육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.
		Scanner sc = new Scanner(System.in);
	
		x = sc.nextInt();
		y = sc.nextInt();
		arr = new char[x][y];
		visited = new boolean[x][y];
		
		for (int i = 0; i < x; i++) {
			String line = sc.next();
			for (int j = 0; j < y; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		int ans = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (arr[i][j] == 'L') ans = Math.max(ans, bfs(i, j));
			}
		}
		
	}

	// 전역: R(행), C(열), arr(지도), dx/dy 그대로 사용
	static int bfs(int sr, int sc) {
	    Deque<int[]> q = new ArrayDeque<>();
	    visited[sr][sc] = true;
	    q.add(new int[]{sr, sc});
		
	    boolean[][] visited = new boolean[x][y];   // x=R, y=C
	    int[][] dist = new int[x][y];

	    int farthest = 0; // 시작점에서 가장 먼 L까지의 최단거리

	    while (!q.isEmpty()) {
	        int[] cur = q.poll();
	        int r = cur[0], c = cur[1];

	        for (int d = 0; d < 4; d++) {
	            int nr = r + dx[d];
	            int nc = c + dy[d];

	            // 1) 경계 체크
	            if (nr < 0 || nr >= x || nc < 0 || nc >= y) continue;

	            // 2) 통과 가능한가? (보물섬은 'L'만 통과)
	            if (arr[nr][nc] != 'L') continue;

	            // 3) 방문 체크
	            if (visited[nr][nc]) continue;

	            visited[nr][nc] = true;
	            dist[nr][nc] = dist[r][c] + 1;   // 한 칸 이동 → +1
	            farthest = Math.max(farthest, dist[nr][nc]);
	            q.add(new int[]{nr, nc});
	        }
	    }

	    return farthest;  // 시작점(sr,sc)에서 도달 가능한 L들 중 최장 최단거리
	}



}
