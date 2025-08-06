package Swea;

import java.util.Scanner;

public class Swea_1954 {
	static int[] dr = {0, 1, 0, -1}; //행의 변화량 dx
	static int[] dc = {1, 0, -1, 0}; //열의 변화량 dy
	
	/*       행	열
	 	우 -> 0  +1
	 	하 -> +1  0 
	 	좌 -> 0  -1
	 	상 -> -1  0
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int arrLength = sc.nextInt();
			
			int[][] snailArr = new int[arrLength][arrLength];
			
			int startNum = 1;
			int r = 0;
			int c = -1; // 첫 이동을 위해 한 칸 왼쪽에서 시작
			int pointer = 0;
			while(startNum <= arrLength * arrLength) {
				int x = r + dr[pointer];
				int y = c + dc[pointer];
				
				//x, y가 범위 밖으로 나가면? => 회전                             //이미 채워져 있으면? => 회전
				if (x < 0 || x >= arrLength || y < 0 || y >= arrLength || snailArr[x][y] != 0) {
				    pointer = (pointer + 1) % 4;  // 시계방향으로 회전
				    continue;
				}
				
				snailArr[x][y] = startNum;
				startNum++;
				r = x;
				c = y;	
			}
			
			//배열 출력 
			System.out.println("#" + test_case);
			for (int d = 0; d < arrLength; d++) { 
				for (int b = 0; b < arrLength; b++) {
					System.out.print(snailArr[d][b] + " ");
				}
				System.out.println();
			}			
		}
	}

}
