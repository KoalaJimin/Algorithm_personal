package Swea;

import java.util.Scanner;

public class Swea_21557_스프링쿨러설치하기 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int startNum = 0;
			int total = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					startNum = arr[i][j];
					total += startNum;
					for (int h = 0; h < 4; h++) {
						int nx = i + dx[h];
						int ny = j + dy[h];
						if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						
						total += arr[nx][ny];
					}
					if (i == 0 && j == 0) max = total; //마이너스일 때 처리하기 위해서 
					if (total > max) max = total;
					total = 0;
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}
