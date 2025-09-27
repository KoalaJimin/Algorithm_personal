package Swea;

import java.util.Scanner;

public class Swea_25588_홍수예측 {
	static int n;
	static char[][] arr;
	static boolean[][] origin;
	static boolean[][] big;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		//일반 홍수와 대홍수 상황에서 침수되는 구역의 수가 각각 몇 개인지 구하는 문제
		//일반 홍수: 낮은 지대(L)만 침수됩니다.
//		대홍수: 낮은 지대(L)와 중간 지대(M)가 모두 침수됩니다. (높은 지대 H는 안전)
//		같은 침수 상태가 상하좌우로 인접해 있으면 같은 구역에 속한 것으로 봅니다.
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			arr = new char[n][n];
			origin = new boolean[n][n];
			big = new boolean[n][n];
			visited = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				String line = sc.next();
				for (int j = 0; j < n; j++) {
					arr[i][j] = line.charAt(j);
					
					//일반
					if(arr[i][j] == 'L') {
						origin[i][j] = true;
						big[i][j] = true;
					} else if(arr[i][j] == 'M') {
						big[i][j] = true;
					}
				}
			}
			
			//일반홍수
			int originCount = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && origin[i][j] == true) {
						dfs(i,j,origin);
						originCount++;
					}
				}
			}
			
			//visited 초기화 
			visited = new boolean[n][n];
			
			//대홍수
			int bigCount = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && big[i][j] == true) {
						dfs(i,j,big);
						bigCount++;
					}
				}
			}
			
			System.out.println("#" + t + " " + originCount + " " + bigCount);
		}
	}

	private static void dfs(int x, int y, boolean[][] ground) {
		visited[x][y] = true;
		for (int h = 0; h < 4; h++) {
			int nx = x + dx[h];
			int ny = y + dy[h];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue; //범위 벗어나면 제외
			if(visited[nx][ny]) continue; //이미 방문 했으면 제외 
			
			if (ground[nx][ny] == true) {
				dfs(nx, ny, ground);
			}
		}
	}

}
