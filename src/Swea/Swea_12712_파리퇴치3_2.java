package Swea;

import java.util.Scanner;

public class Swea_12712_파리퇴치3_2 {
	static int[] dx = new int[] {-1,1,0,0}; 
	static int[] dy = new int[] {0,0,-1,1}; 
	static int[] dxL = new int[] {-1,-1,1,1}; 
	static int[] dyR = new int[] {-1,1,-1,1}; 
	
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
        	int answer;
        	int max = 0;
        	for(int i = 0; i < n; i++) {
            	for(int j = 0; j < n; j++) {
            		answer = arr[i][j];
            		for(int h = 0; h < 4; h++) {
            			for(int q = 1; q < m; q++) {
	                		int nx = i + dx[h] * q;
	                		int ny = j + dy[h] * q;
	                		
	                		if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
	                		answer += arr[nx][ny];
            			}
                	}
            		
            		if(max <= answer) {
            			max = answer;
            		} 
            	}
        	}
        	
        	for(int i = 0; i < n; i++) {
            	for(int j = 0; j < n; j++) {
            		answer = arr[i][j];
            		for(int h = 0; h < 4; h++) {
            			for(int q = 1; q < m; q++) {
	                		int nx = i + dxL[h] * q;
	                		int ny = j + dyR[h] * q;
	                		
	                		if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
	                		answer += arr[nx][ny];
            			}
                	}
            		
            		if(max <= answer) {
            			max = answer;
            		} 
            	}
        	}
        	
        	//출력
            System.out.println("#" + test_case + " " + max); 
        }
	}

}
