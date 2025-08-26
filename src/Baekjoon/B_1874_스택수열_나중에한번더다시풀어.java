package Baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B_1874_스택수열_나중에한번더다시풀어 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Deque<Integer> s = new ArrayDeque<>();
		
		//목표수가 나올 때까지 1부터 푸시
		//목표수가 나오면 팝 
		//목표수 다음으로 변경 
		//목표수가 peek 보다 크면 바로 no 
		//목표수랑 같으면 팝 
		//목표수보다 작으면 푸시 
		
		StringBuilder sb = new StringBuilder();
		int current = 1; // push할 다음 숫자		
		for (int i = 1; i <= n; i++) {
			int target = sc.nextInt();
			
			while ( current <= target ) {
				s.push(current);
				sb.append("+\n");
				current++;				
			}
			if (!s.isEmpty() && s.peek() == target) {
				s.pop();
				sb.append("-\n");
			} else if (s.peek() > target) {
				sb.delete(0, sb.length()).append("NO");
				break;
			}
		}
		System.out.println(sb);
	}		
}
