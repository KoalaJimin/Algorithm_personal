package Baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//stack 은 pop/push/peek 기억 !!
public class B_4949_균형잡힌세상 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true){
			String text = sc.nextLine();

			if (text.equals(".")) break; //입력 종료 조건 
			
			Deque<Character> s = new ArrayDeque<>();
			String answer = "yes";
			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				
				if(c == '(' || c == '[') {
					s.push(c);
				} else if ( c == ')') {
					if (s.isEmpty() || s.peek() != '(') {
						answer = "no";
						break;
					} 
					s.pop();
				} else if (c == ']') {
					if (s.isEmpty() || s.peek() != '[') {
						answer = "no";
						break;
					} 
					s.pop();
				} 
			}
			
			if(!s.isEmpty()) answer = "no";
			
			System.out.println(answer);
		}
		
	}
}
