package Swea;

import java.util.Scanner;

public class Swea_12712_파리퇴치3 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] dxL = {-1,-1,1,1}; //행
	static int[] dyR = {-1,1,-1,1}; //열
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        for (int test_case = 1; test_case <= T; test_case++) {
        	//입력
        	int n = sc.nextInt();
        	int m = sc.nextInt();
        	int[][] arr = new int[n][n];
        	for(int i = 0; i < n; i++) {
            	for(int j = 0; j < n; j++) {
            		arr[i][j] = sc.nextInt();
            	}
        	}
        	//로직
        	int answer = 0;
        	

        	for(int i = 0; i < n; i++) {
            	for(int j = 0; j < n; j++) {
            		int sum = arr[i][j];
            		
            		for(int h = 0; h < 4; h++) {
            			for(int q = 1; q < m; q++) {
            				int x = i + dx[h] * q;
                			int y = j + dy[h] * q;                			
                			if (x < 0 || x >= n || y < 0 || y >= n) continue;
                			
                			sum += arr[x][y];	
            			}
            		}
            		answer = Math.max(answer, sum);
            	}
        	}
        	
        	for(int i = 0; i < n; i++) {
            	for(int j = 0; j < n; j++) {
            		int sum = arr[i][j];
            		
            		for(int h = 0; h < 4; h++) {
            			for(int q = 1; q < m; q++) {
            				int x = i + dxL[h] * q;
                			int y = j + dyR[h] * q;
                			if (x < 0 || x >= n || y < 0 || y >= n) continue;
                			
                			sum += arr[x][y];	
            			}
            		}
            		answer = Math.max(answer, sum);
            	}
        	}
        	
        	//출력
            System.out.println("#" + test_case + " " + answer); 
        }
	}

}
