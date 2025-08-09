package Swea;

import java.util.Scanner;

public class Swea_24100_계곡찾기 {
	static int[] dr = {-1,1,0,0}; //행의 변화량 
	static int[] dc = {0,0,-1,1}; //열의 변화량 
    /*       행  열
	    상 -> -1  0
	    하 -> +1  0 
	    좌 -> 0  -1
	    우 -> 0  +1
	*/
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test_case = 1; test_case <= t; test_case++) {
			//입력
			int len = sc.nextInt();
			int[][] arr = new int[len][len];
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//로직
			int valleyCount = 0;
			int result = 0;
			for (int i = 1; i < len - 1; i++) {
				for (int j = 1; j < len - 1; j++) {
					int startNum = arr[i][j];
					System.out.println(startNum);
					for(int d = 0; d < 4; d++) {
						//d방향으로 이동했을 경우의 좌표값 (nr, nc)
						int nr = i + dr[d];
						int nc = j + dc[d];			
										
						if (nr < 0 && nr >= len && nc < 0 && nc >= len) {
							continue;
						}
						
						int targetNum = arr[nr][nc];
						if (targetNum <= startNum) {
							break;
						} else {
							valleyCount++;
						}
					}
					if (valleyCount == 4) result++;
					valleyCount = 0;
				}		
			}
			//출력
			System.out.println("#" + test_case + " " + result);	
		}
	}
}
