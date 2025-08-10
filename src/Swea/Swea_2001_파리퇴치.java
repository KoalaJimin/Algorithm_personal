package Swea;

import java.util.Scanner;

public class Swea_2001_파리퇴치 {	
 	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        
        for (int test_case = 1; test_case <= T; test_case++) {
            //입력
        	int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                	arr[i][j] = sc.nextInt();
                }
            }
            
            //로직
            //시작 좌표 정하고, M만큼 포문 돌려 타겟 지정 후 더하기 
            int sum = 0;
            int max = 0;
    		for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {                	
                	if (i + M - 1 >= N || j + M - 1 >= N) {
                		continue;
                	}
                	
                	for (int h = i; h <= i + M - 1; h++) {
                        for (int l = j; l <= j + M - 1; l++) {
                        	 sum += arr[h][l];
                        }
                    }
                	
                	//Max 구하기 
                	if (max < sum) {
                		max = sum;
                	}
                	sum = 0;
                }
            }
            
            //출력
            System.out.println("#" + test_case + " " + max); 
        }
	}

}
