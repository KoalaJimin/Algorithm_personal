package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1987_알파벳 {
	static int r, c, finishCount;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Character> checkChar;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
	
		arr = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			String line = sc.next();
			for(int j = 0; j < c; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		//로직 
		checkChar = new ArrayList<>();
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
				}
			}
		}
		
		System.out.println(checkChar.size());
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		checkChar.add(arr[x][y]);
	
		for (int h = 0; h < 4; h++) {
			int nx = x + dx[h];
			int ny = y + dy[h];
			
			if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
			if (visited[nx][ny]) continue;
			
			if (check(nx, ny)) dfs(nx, ny);
		}
		
	}

	private static boolean check(int nx, int ny) {
		for(char c : checkChar) {
			if (c == arr[nx][ny]) return false;
		}
		
		return true;
	}

}
