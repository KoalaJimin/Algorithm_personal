package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B_1260_DFS와BFS_다시 {

	public static void main(String[] args) {
		//방문할 수 있는 정점이 여러 개인 경우에는 
		//정점 번호가 작은 것을 먼저 방문하고, 
		//더 이상 방문할 수 있는 점이 없는 경우 종료
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //정점의 개수 
		int m = sc.nextInt(); //간선의 개수 
		int v = sc.nextInt(); //탐색시작 정점 번호
		
		ArrayList[] list = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			list[x].add(x);
			list[y].add(y);
			
			
			
			
//			for (int j = 0; j < n; j++) {
//				
//			}
		}
		
		
	}

}
