package Baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B_10773_제로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		Deque<Integer> s = new ArrayDeque<>();
		int answer = 0;
		for (int i = 0; i < k; i++) {
			int target = sc.nextInt();
			if(target == 0 && !s.isEmpty()) {
				s.pop();
			} else {
				s.push(target);
			}
		}
		
		int sum = 0;
		for(int i : s) {
			sum += i;
		}
		
		System.out.println(sum);
	}
}
