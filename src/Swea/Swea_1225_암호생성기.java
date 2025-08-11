package Swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea_1225_암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++) {
			int tc = sc.nextInt();
			int[] arr = new int[8];
			for(int i = 0; i < 8; i++) {
				arr[i] = sc.nextInt();
			}
			
			Queue<Integer> q = new LinkedList<>();
			for(int i = 0; i < 8; i++) {
				q.add(arr[i]);
			}
			
			int minus = 1;
			while(true) {
				int n = q.poll() - minus; //맨 앞 꺼내고 감소 
				if (n <= 0) { //0 이하면 0으로 
					q.add(0);
					break;
				} else {
					q.add(n);
				}
				minus++;
				if(minus > 5) minus = 1;
			}
			
			System.out.print("#" + tc + " ");
			for(int n : q) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

}
