package Baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B_10828_스택 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
	
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < n; i++) {
			String command = sc.next();
			if (command.equals("push")) {
				int num = sc.nextInt();
				//.add 는 큐 / .push 는 스택 
				stack.push(num);
			} else if (command.equals("top")) {
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.peek());
			} else if (command.equals("empty")) {
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			} else if (command.equals("pop")) {
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.pop());
			} else if (command.equals("size")) {
				System.out.println(stack.size());
			}
			
		}
	}

}
