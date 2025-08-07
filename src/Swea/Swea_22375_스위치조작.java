package Swea;

import java.util.Scanner;

public class Swea_22375_스위치조작 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int switchNum = sc.nextInt();
            int[] before = new int[switchNum];
            int[] after = new int[switchNum];
            
            for(int i = 0; i < switchNum; i++) {
                before[i] = sc.nextInt();
            }
            
            for(int i = 0; i < switchNum; i++) {
                after[i] = sc.nextInt();
            }
            
            // 로직 시작
            int count = 0;
            
            for (int i = 0; i < switchNum; i++) {
                if (before[i] != after[i]) {
                    for (int j = i; j < switchNum; j++) {
                        before[j] = 1 - before[j]; // 0이면 1로, 1이면 0으로
                    }
                    count++;
                }
            }
            
            System.out.println("#" + test_case + " " + count); 
        }
	}
}
