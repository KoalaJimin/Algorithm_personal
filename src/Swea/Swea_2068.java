package Swea;

import java.util.Scanner;

// 최대수 구하기
public class Swea_2068 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
            int[] arr = new int[10];


            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }

            int temp = 0;
            for (int i = 0; i < 9; i++) {
                if (arr[i] > arr[i+1]) {
                    temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }

            System.out.println("#" + test_case + " " + arr[arr.length-1]);

		}
	}

}
