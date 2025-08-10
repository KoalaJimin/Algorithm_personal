package Swea;

import java.util.Scanner;

public class Swea_1217_거듭제곱 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++){
			int T = sc.nextInt();
			int target = sc.nextInt();
			int num = sc.nextInt();
			int result = 1;
			for (int i = 1; i <= num; i++) {
				result *= target;
			}
			System.out.println("#"+T+" "+result);
		}
	}

}
