package Baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B_9012_괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			Deque<Character> s = new ArrayDeque<>(); //스택을 초기화 해줘야 해요 
			String answer = "YES";
			String text = sc.next();
			
			for(int j = 0; j < text.length(); j++) {
				char target = text.charAt(j);
				
				if (target == '(') {
					s.push(target); 
				} else if (target == ')') {
					if (!s.isEmpty()) {
						s.pop();
					} else if (s.isEmpty()) {
						answer = "NO";
						break;
					}
				} 				
			}	
			
			if (!s.isEmpty()) answer = "NO";
			System.out.println(answer);			
		}
		
	}

}
