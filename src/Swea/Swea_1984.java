package Swea;

import java.util.Scanner;

//중간 평균값 구하기 
public class Swea_1984 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
		
            int[] arr = new int[10];


            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }
            
            //버블정렬
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

            // 최소값: arr[0], 최대값: arr[9] (정렬된 상태)
            int sum = 0;
            for (int i = 1; i < 9; i++) {  // 1부터 8까지 중간값
                sum += arr[i];
            }
            
            long avg = Math.round((double) sum / 8);
            
            System.out.println("#" + test_case + " " + avg);
		}
	}

}
