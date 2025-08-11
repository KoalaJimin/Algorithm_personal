package Swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea_3499_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test_case = 1; test_case <= t; test_case++) {
			//입력
			int len = sc.nextInt();
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			//로직
			for(int i = 0; i < len; i++) {
				if ( i < (len + 1) / 2) { //앞 쪽 개수 = (len + 1) / 2 --> 홀수면 앞이 하나 더 많음
					q1.add(sc.next());					
				} else {
					q2.add(sc.next());					
				}
			}
			
			StringBuilder answer = new StringBuilder();
			while(!(q1.isEmpty()) || !(q2.isEmpty())) {
				if (!q1.isEmpty()) answer.append(q1.poll()).append(" ");
			    if (!q2.isEmpty()) answer.append(q2.poll()).append(" ");
			}
			//출력
			System.out.println("#" + test_case + " " + answer);	
		}
	}

}
