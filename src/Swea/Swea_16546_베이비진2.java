package Swea;

import java.util.Scanner;

public class Swea_16546_베이비진2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int tc = 1; tc <= t; tc++) { 
            String input = sc.next();
            
            int[] count = new int[10]; // 카드 숫자 개수 저장
            
            // 카드 입력받아 카운트
            for (int i = 0; i < 6; i++) {
                count[input.charAt(i) - '0']++;
            }
            
            int triplet = 0, run = 0;
            
            // 트리플 체크
            for (int i = 0; i < 10; i++) {
                while (count[i] >= 3) {
                    count[i] -= 3;
                    triplet++;
                }
            }
            
            // 런 체크
            for (int i = 0; i < 8; i++) { // 0~7까지만 확인
                while (count[i] > 0 && count[i+1] > 0 && count[i+2] > 0) {
                    count[i]--; count[i+1]--; count[i+2]--;
                    run++;
                }
            }
            
            if (triplet + run == 2) {
            	System.out.println("#" + tc + " true");
            } else {
            	System.out.println("#" + tc + " false");
            }        	
        }

    }
}
