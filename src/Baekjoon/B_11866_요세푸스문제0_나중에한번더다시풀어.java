package Baekjoon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class B_11866_요세푸스문제0_나중에한번더다시풀어 {

	public static void main(String[] args) {
		//1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 
		//양의 정수 K(≤ N)가 주어진다. 
		//이제 순서대로 K번째 사람을 제거한다. 
		//한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
		//이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 
		//예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new ArrayDeque<>();
		
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		List<Integer> list = new ArrayList<>(q); //인덱스로 접근하기 위해 ArrayList로 변환해서 접근
	
		int index = 0;
		sb.append("<");
		while(!list.isEmpty()) {
			index = (index + k - 1) % list.size(); //k번째 사람 위치 .. 이거 외우자 이해하자 
			sb.append(list.get(index) + ", ");
			list.remove(index);
		}
		
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);		
	}

}
