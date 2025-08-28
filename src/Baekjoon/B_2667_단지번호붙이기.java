package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_2667_단지번호붙이기 {
	static int n;
	static boolean[][] visited;
	static int[][] houses;
	static List<int[]> union; //단지인 좌표 저장 
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		houses = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) {
				houses[i][j] = s.charAt(j) - '0';
			}
		}
		
		/*
		 * 1은 집 있음 0은 집 없음 
		 * 단지 -> 연결된 집의 모임 / 번호 붙일 것임 
		 * 상하좌우 연결만 
		 */
		List<Integer> unionCount = new ArrayList<>();
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				union = new ArrayList<>();

				if (!visited[i][j] && houses[i][j] == 1) {			
					dfs(i, j);
					if (union.size() >= 1) {
						count++;
						unionCount.add(union.size());		
					}					
				}
			}
		}
		
		System.out.println(count);
		Collections.sort(unionCount); // 오름차순 정렬
		for (int i : unionCount) {
			System.out.println(i);			
		}
		
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true; //방문 처리 
		union.add(new int[]{x, y});
		
		for (int h = 0; h < 4; h++) {			
			int nx = x + dx[h];
			int ny = y + dy[h];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; //범위 벗어나면 
			if (visited[nx][ny]) continue; //이미 방문했으면
			
			if (houses[nx][ny] == 1 ) {
				dfs(nx, ny);				
			}
		}
	}
	

}
