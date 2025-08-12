package Swea;

import java.util.LinkedList;
import java.util.Scanner;

public class Swea_5108_숫자추가 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); //수열의 길이 
            int M = sc.nextInt(); //추가 횟수 
            int L = sc.nextInt(); //출력할 인덱스 번호 
            LinkedList<Integer> arr = new LinkedList<>();
            for (int i = 0; i < N; i++) {
            	arr.add(sc.nextInt());
            }
            
            for (int i = 0; i < M; i++) {
            	int idx = sc.nextInt();
            	int value = sc.nextInt();
            	
            	arr.add(idx, value);
            }
            
            System.out.println("#" + t + " " + arr.get(L));
        }
	}
}