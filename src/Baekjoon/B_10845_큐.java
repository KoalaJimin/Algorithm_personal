package Baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B_10845_큐 {

	public static void main(String[] args) {
		Deque<Integer> q = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			String command = sc.next();
			
			if (command.equals("push")) {
				int j = sc.nextInt();
				q.offer(j);		
			} else if (command.equals("front")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peekFirst());
			} else if (command.equals("back")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peekLast());
			} else if (command.equals("size")) {
				 System.out.println(q.size());
			} else if (command.equals("empty")) {
				if(q.isEmpty()) System.out.println(1);
				else System.out.println(0);
			} else if (command.equals("pop")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.poll());
			}
		} 
		
	}
}
