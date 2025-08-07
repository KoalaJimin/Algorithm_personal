package Swea;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Swea_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++) {
			int braketLength = sc.nextInt();		
			String text = sc.next();
			
			ArrayDeque<Character> stack = new ArrayDeque<>();
			
			boolean isValid = true; //괄호검사 성공 여부 
			
			// 1. 문자열에 대해 왼쪽에서 오른쪽으로 순서대로 검사 (순회)
			/*  이렇게 해도 아래 for문과 동일
				for(char ch: text.toCharArray()) {
				}
			*/
			for (int i = 0; i < braketLength; i++) {
				char ch = text.charAt(i);
				
				// 2. 왼쪽 괄호 `(` , `[` , `{` 를 만나면 스택에 삽입 (push)
				if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
					stack.push(ch);
				}
				// 3. 오른쪽 괄호 `)`, `]`, `}` 를 만나면 (pop)
				else if (ch == ')' || ch == ']' || ch == '}' || ch == '>') {
					// 3-1. 스택에 요소가 비어있으면??? **괄호 검사 실패!** (조건 1, 2 위배)
					if (stack.isEmpty()) {
						isValid = false; //실패
						break;
					}
					// 3-2. 스택에 요소가 있으면?? pop 하여 짝이 맞는가?? **→ 짝x 실패!** (조건 3 위배)
					char other = stack.pop();				
					if (other == '(' && ch == ')') {
						continue;
					} else if (other == '[' && ch == ']') {
						continue;
					} else if (other == '{' && ch == '}') {
						continue;
					} else if (other == '<' && ch == '>') {
						continue;
					} else {
						// 짝 실패
						isValid = false;
						break;
					}
				}
			}
			
			//end.  나머지 조건에 위배가 안되어 있었다면? **괄호 검사 성공!**
			if (stack.isEmpty() && isValid) {
				System.out.println("#" + test_case + " 1");
			} else {
			//괄호 검사가 완료된 후 스택에 괄호가 남아있다면 **실패!** (조건 1위배)
				System.out.println("#" + test_case + " 0");
			}
		}
	}
}
