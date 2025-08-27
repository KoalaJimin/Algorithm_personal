package Baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_16234_인구이동_보류 {
	static int[] dx = {0,1};
	static int[] dy = {1,0};

	public static void main(String[] args) {
		//오, 하 로만 알아보면 되지 않을까 ?
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		
		Map<String, boolean[]> open = new HashMap<>();
		
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//로직 
		//1. gap에 따라 국경선 개방 여부 판단 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int current = arr[i][j];
				boolean[] openVal = new boolean[2];
				
				for(int h = 0; h < 2; h++) {
					int x = i + dx[h];
					int y = j + dy[h];
					
					if (x < 0 || x >= n || y < 0 || y >= n ) continue;
					
					int gap = Math.abs(current - arr[x][y]);
					if (gap >= L && gap <= R) {
						openVal[h] = true; //h = 0 은 오른쪽 , h = 1은 아래쪽 
					}
				}
				open.put(i + ", " + j, openVal);
			}
		}
		
		//2. 국경선 개방 여부에 따라 인구 이동 판단 
		int sum = 0;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-1; j++) {
				if (open.get(i + ", " + j)[0] == true) {
					sum += arr[i][j+1];
				} else if (open.get(i + ", " + j)[1] == true) {
					sum += arr[i+1][j];
				}
			}
		}
		
	}

}
