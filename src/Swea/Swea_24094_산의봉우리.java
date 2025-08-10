package Swea;

import java.util.Scanner;

public class Swea_24094_산의봉우리 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        for (int test_case = 1; test_case <= T; test_case++) {
        	//입력
        	int N = sc.nextInt();
        	int[][] arr = new int[N][N];
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
            		arr[i][j] = sc.nextInt();
            	}
        	}
        	
        	//로직
        	int startNum = 0;
        	int targetNum = 0;
        	boolean isRidge = true;
        	int ridgeCount = 0;
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			startNum = arr[i][j];
            		
            		for (int h = 0; h < 4; h++) {
                		int nx = i + dx[h];
                		int ny = j + dy[h];
                		
                		if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                		
                		targetNum = arr[nx][ny];
                		if (startNum <= targetNum) {
                			isRidge = false;
                			break;
                		} 
                	}
            		if (isRidge) ridgeCount++;
            		isRidge = true;
            	}
        	}
        	
        	//출력
            System.out.println("#" + test_case + " " + ridgeCount); 
        }
	}
}
