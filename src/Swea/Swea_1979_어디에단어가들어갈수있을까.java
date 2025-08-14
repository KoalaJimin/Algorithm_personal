package Swea;

import java.util.Scanner;

public class Swea_1979_어디에단어가들어갈수있을까 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();		
		for(int test_case = 1; test_case <= T; test_case++) {
			//입력
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] arr = new int[N][N];			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}	
			}	
			
			//로직
			//흰이 1, 검정이 0이고 흰 부분에 글자 채우는 거임 
			//글자가 끝나면 뒤가 검정이거나 (뒤가 0이거나), N-1과 끝난 인덱스가 같아야 함(끝이거나)
			//가로, 세로 따로 봐야 돼 -> 가로 세로 따질 때 겹치는 건 신경 ㄴ
			
			//일단 가로 할게~
			int count = 1; //1갯수 세기
			int sum = 0; //총 몇 개 인지
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N - K + 1; j++) {
					if(arr[i][j] == 1) {
						int k;
						for (k = 0; k < K-1; k++) {
							if (arr[i][j+k+1] == 1) count++;
							else break;
						}
						if(count == K) {
							if (j+k == N-1) {
								sum++;								
							} else if (j+k != N-1 && j != 0 && arr[i][j+k+1] == 0 && arr[i][j-1] == 0) {
								sum++;
							}
						}
					}
					//초기화
					count = 1;
				}	
			}	
			
			//세로~ 
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N - K + 1; j++) {
					if(arr[j][i] == 1) {
						int k;
						for (k = 0; k < K-1; k++) {
							if (arr[j+k+1][i] == 1) count++;
							else break;
						}
						if(count == K) {
							if (j+k == N-1) {
								sum++;								
							} else if (j+k != N-1 && j != 0 && arr[j+k+1][i] == 0 && arr[j-1][i] == 0) {
								sum++;
							}
						}
					}
					count = 1;
				}	
			}	
			
			//출력
			System.out.println("#" + test_case + " " + sum);
		}

	}

}
