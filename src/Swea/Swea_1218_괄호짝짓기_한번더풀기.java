package Swea;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Swea_1218_괄호짝짓기_한번더풀기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			String line = sc.next();

			Deque<Character> s = new ArrayDeque<>();
			
			int answer = 1;
			for(int i = 0; i < n; i++) {
				char b = line.charAt(i);
				
				if (b == '(' || b == '[' || b == '{' || b == '<') {
					s.push(b);
				} else if (!s.isEmpty()) {
					if (s.peek() == '(' && b == ')') {
						s.pop();
					} else if (s.peek() == '[' && b == ']') {
						s.pop();
					} else if (s.peek() == '{' && b == '}') {
						s.pop();
					} else if (s.peek() == '<' && b == '>') {
						s.pop();
					} else {
						answer = 0;
						break;
					}
				} else { // 스택이 비어 있는데 닫는 괄호가 나온 경우
                    answer = 0;
                    break;
                }
            }
            
            // 스택에 괄호가 남아 있으면 올바르지 않음
            if (!s.isEmpty()) {
                answer = 0;
            }
			
			System.out.println("#" + t + " " + answer );			
		}

	}

}
