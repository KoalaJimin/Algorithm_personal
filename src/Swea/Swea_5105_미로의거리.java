package Swea;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Swea_5105_미로의거리 {
	static int n = 0, startX = 0, startY = 0, finishX = 0, finishY = 0;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dist; // 시작에서 각 칸까지의 이동 칸 수
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			result = 0;
			n = sc.nextInt();
			arr = new int[n][n];
			visited = new boolean[n][n];
			dist = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String line = sc.next();
				for (int j = 0; j < n; j++) {
					arr[i][j] = line.charAt(j) - '0';
					
					if (arr[i][j] == 2) {
						startX = i;
						startY = j;
					}
					else if (arr[i][j] == 3) {
						finishX = i;
						finishY = j;
					}
				}
			}
			
			//로직 			
			bfs();
			//출력
			System.out.println("#" + tc + " " + result);
		}
	}

	static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		
		dq.add(new int[] {startX, startY}); //시작 좌표 삽입 
		visited[startX][startY] = true; // 큐에 넣는 순간 방문 표시 → 중복 삽입 방지
		dist[startX][startY] = 0; //시작 칸 거리 0
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int x = cur[0], y = cur[1];
			
            // 도착에 처음 닿는 순간이 곧 최단
            if (x == finishX && y == finishY) { //현재 꺼낸 좌표가 목표(도착)인지 검사
                // 문제 요구: 시작·도착을 제외한 칸 수 → dist - 1
                // 시작=도착이면 -1이 되므로 0으로 보정
                int steps = dist[x][y] - 1;
                result = steps < 0 ? 0 : steps; //steps가 음수면 0으로 보정 
                return; // 더 볼 필요 없음
            }

            // 4방 확장
            for (int d = 0 ; d < 4 ; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 가지치기: 범위 밖, 이미 방문, 벽(1)은 스킵
                if ( (nx < 0 || ny < 0  ||nx >= n || ny >= n) || visited[nx][ny] || arr[nx][ny] == 1) continue;

                visited[nx][ny] = true;              // 큐 삽입 시점에 방문 처리
                dist[nx][ny] = dist[x][y] + 1;       // 한 칸 이동했으니 +1
                dq.offerLast(new int[] {nx, ny});    // 다음 레벨로 확장
            }
		}
	}

}
