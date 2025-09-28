package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_2583_영역구하기_다시풀어 {
	static int m,n,k;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		
		arr = new int[m][n];
		visited = new boolean[m][n];
		
		for (int i = 0; i < k; i++) {
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			  
			//이 문제에서 좌표는 왼쪽 아래 (0,0) 기준
			//Java 배열에서는 (0,0)이 왼쪽 위 기준이므로, y좌표를 뒤집어야 합니다
			for (int j = startX; j < endX; j++) {
			    for (int h = startY; h < endY; h++) {
			    	arr[m - 1 - h][j] = 1;
			    }                
			}
		}
		
		List<Integer> areaSizes = new ArrayList<>();
		
		for (int j = 0; j < m; j++) {
			for (int h = 0; h < n; h++) {
				if(!visited[j][h] && arr[j][h] == 0) {
					int size = dfs(j, h);
                    areaSizes.add(size);
				}
			}				
		}
		
        // 오름차순 정렬
        Collections.sort(areaSizes);
        // 결과 출력
        System.out.println(areaSizes.size());
        for (int size : areaSizes) {
            System.out.print(size + " ");
        }
	}

	private static int dfs(int x, int y) {
	    visited[x][y] = true;
	    int size = 1;
	    
	    for (int h = 0; h < 4; h++) {
	        int nx = x + dx[h];
	        int ny = y + dy[h];
	        
	        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
	        if (visited[nx][ny] || arr[nx][ny] == 1) continue;
	        
	        size += dfs(nx, ny);
	    }
	    return size;
	}

}
