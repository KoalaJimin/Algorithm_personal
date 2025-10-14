package Baekjoon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class B_19238_스타트택시 {
	static int n, m, gas, startX, startY;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static List<int[]> person;
	static List<int[]> arrive;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//입력 
		// 0 길 / 1 벽
		n = sc.nextInt();
		m = sc.nextInt();
		gas = sc.nextInt();
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//처음 출발지점
		startX = sc.nextInt();
		startY = sc.nextInt();
		
		person = new ArrayList<>();
		arrive = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			person.add(new int[] {sc.nextInt() - 1, sc.nextInt() - 1});
			arrive.add(new int[] {sc.nextInt() - 1, sc.nextInt() - 1});
		}
		
		//출발지점부터 가까운 사람 먼저 찾기 - 최단거리 
		List<Integer> li = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			li.add(bfs(startX, startY, arrive.get(i)[0], arrive.get(i)[1]));
		}		
		int closePerson = Collections.min(li);
		int closePersonIndex = li.indexOf(closePerson);		
		
		//그 사람에게 (출발지로) 이동 
		startX = person.get(closePersonIndex)[0];
		startY = person.get(closePersonIndex)[1];
		gas -= closePerson;
		gas += closePerson * 2;
		
		//그 사람의 (목적지로) 이동 -> 거리 계산 후 연료 차감 & 이동한 거리의 두 배 연료 충전
		int nowGas = bfs(startX, startY, arrive.get(closePersonIndex)[0], arrive.get(closePersonIndex)[1]);
		//조건) 이동 중에 연료 부족 시 -> 이동 중단 후 -1 출력  
		if (nowGas >= gas) System.out.println(-1);
		else {
			gas -= nowGas;
			gas += nowGas * 2;
		}	
		//출발지점 바꾸기
		startX = arrive.get(closePersonIndex)[0];
		startY = arrive.get(closePersonIndex)[1];

		
	}
	
//	private static void findClosePerson() {
//		List<Integer> li = new ArrayList<>();
//		for (int i = 0; i < m; i++) {
//			li.add(bfs(startX, startY, arrive.get(i)[0], arrive.get(i)[1]));
//		}		
//		int closePerson = Collections.min(li);
//		int closePersonIndex = li.indexOf(closePerson);		
//	}

	private static int bfs(int x, int y, int arriveX, int arriveY) {
		visited = new boolean[n][m];
		dist = new int[n][m];
		
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			if (r == arriveX && c == arriveY) {
				return dist[r][c];
			}
			
			for (int h = 0; h < 4; h++) {
				int nx = r + dx[h];
				int ny = r + dx[h];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (visited[nx][ny] || map[nx][ny] == 1) continue;
				
				visited[nx][ny] = true;
				dist[nx][ny] = dist[r][c] + 1;
				q.offerLast(new int[] {nx, ny}); //다음으로 확장 
			}
		}
		
		return dist[x][y];
	}

}

