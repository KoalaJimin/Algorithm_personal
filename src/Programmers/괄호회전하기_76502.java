package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 괄호회전하기_76502 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.next();
		
		int count = 0;
		for (int i = 0; i < line.length(); i++) {
			if (check(line)) count++;
			line = line.substring(1,line.length()) + line.charAt(0);
		}
		
		System.out.println(count);
	}
	
	public static boolean check(String line) {
		Deque<Character> s = new ArrayDeque<>();
		for (int i = 0; i < line.length(); i++) {
			char b = line.charAt(i);
			
			if (b == '[' || b == '(' || b == '{') {
				s.push(b);
			} else if (!s.isEmpty()) {
				if (s.peek() == '[' && b == ']') {
					s.pop();
				} else if (s.peek() == '(' && b == ')') {
					s.pop();
				} else if (s.peek() == '{' && b == '}') {
					s.pop();
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		
		if (!s.isEmpty()) {
			return false;
		}
		
		return true;
	}

}
