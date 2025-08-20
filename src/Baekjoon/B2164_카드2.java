package Baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B2164_카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Deque<Integer> q = new ArrayDeque<>();
		
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		while (q.size() > 1) {
			q.pollFirst();
			q.offer(q.pollFirst());
		}
		
		System.out.println(q.poll());
		
		
	}

}
