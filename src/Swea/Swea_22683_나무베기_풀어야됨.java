package Swea;

import java.util.Scanner;

public class Swea_22683_나무베기_풀어야됨 {
	static char[][] arr;
	static boolean[][] visited;
	static int startX, startY, endX, endY, commandLen, direction, n, result, treeSliceCount; 
	static int[] dx = {-1,0,1,0}; // 상 우 하 좌
	static int[] dy = {0,1,0,-1}; // 상 우 하 좌
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        
        for (int test_case = 1; test_case <= T; test_case++) {
            /* 
				'G' : RC카가 이동 가능한 땅        (길)
				'T' : RC카가 이동이 불가능한 나무    (벽)				
				'X' : 현재 RC카의 위치           (시작)
				'Y' : RC카를 이동 시키고자 하는 위치 (도착)
				
				RC카의 조종기로는 아래의 동작들을 할 수 있다.
				'A' : 앞으로 이동 - 나무가 있는 곳이나 필드를 벗어나는 경우에는 아무 일도 일어나지 않는다.
				      (RC카가 망가지는것을 방지하고자 장애물 판단 시스템이 탑재되었다.)
				'L' : 현재 바라보고 있는 방향에서 왼쪽으로 90도 회전
				'R' : 현재 바라보고 있는 방향에서 오른쪽으로 90도 회전
				
				항상 위를 바라보는 방향으로 부터 조종을 시작
             */
        	//입력
        	//direction 방향 -> 시작은 위 
        	//상 우 하 좌
        	//0 1 2 3 

        	n = sc.nextInt();
        	arr = new char[n][n];
        	treeSliceCount = sc.nextInt();
        	
        	for (int i = 0; i < n; i++) {
				String line = sc.next();
				for (int j = 0; j < n; j++) {
					arr[i][j] = line.charAt(j);
					if (arr[i][j] == 'X') {
						startX = i;
						startY = j;
					} else if (arr[i][j] == 'Y') {
						endX = i;
						endY = j;
					}
				}
			}
            
            //로직
            
            
            System.out.println("#" + test_case + " " ); 
        }

	}

	//조종
	private static int pilot(String command) {
//		int currentX = startX;
//		int currentY = startY;
//		
//	    for (int i = 0; i < commandLen; i++) {
//	        char action = command.charAt(i);
//	        
//	        if (action == 'L') { // 왼쪽 회전
//	            direction = (direction + 3) % 4;
//	        } else if (action == 'R') { // 오른쪽 회전
//	            direction = (direction + 1) % 4;
//	        } else if (action == 'A') { // 앞으로 이동
//	            int nx = currentX + dx[direction];
//	            int ny = currentY + dy[direction];
//
//	            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 'T') continue;
//	            
//	            currentX = nx;
//            	currentY = ny;
//	        }
//	    }
//	    
//	    if (currentX == endX && currentY == endY) result = 1;
//	    
	    return result;
	}

}
