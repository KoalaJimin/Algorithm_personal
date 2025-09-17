package Swea;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Swea_1226_미로1 {
	static int[][] arr;
	static boolean[][] visited;
	static int startX, startY, endX, endY, result;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			// 입력
			int T = sc.nextInt();
			arr = new int[16][16];
			visited = new boolean[16][16];
			result = 0; // 도달 가능 1 / 불가능 0
			
			for (int i = 0; i < 16; i++) {
				String line = sc.next();
				for (int j = 0; j < 16; j++) {
					arr[i][j] = line.charAt(j) - '0';
					
					if (arr[i][j] == 2) {
						startX = i;
						startY = j;
					} else if (arr[i][j] == 3) {
						endX = i;
						endY = j;
					}
				}
			}
				
			// 로직
			// 0은 길 / 1은 벽 / 2는 출발 / 3은 도착			
			bfs();
			
			//출력
			System.out.println("#" + T + " " + result);
		}

	}
	static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();		
		q.add(new int[]{startX, startY});
		visited[startX][startY] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			//도착이라면
			if (x == endX && y == endY) {
				result = 1;
				return;
			}
			
			for (int h = 0; h < 4; h++) {
				int nx = x + dx[h]; 
				int ny = y + dy[h];
				
				if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16) continue;
				if (visited[nx][ny] || arr[nx][ny] == 1) continue;
				
				visited[nx][ny] = true;
				q.offerLast(new int[]{nx, ny});
			}
		}
		
	}

}
