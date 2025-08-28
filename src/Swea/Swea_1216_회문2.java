package Swea;

import java.util.Scanner;

public class Swea_1216_회문2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			char[][] arr = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String text = sc.next();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = text.charAt(j);
				}
			}
			
			find(arr);
			
		}
		
	}
	
	public static void find(char[][] arr) {
		for (int i = 0; i < 50; i++) {
			
		}
	}

}
