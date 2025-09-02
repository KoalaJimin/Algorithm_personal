package Swea;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Swea_5521_상원이의생일파티_다시풀어 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			/*
			 * 인접 리스트 
			 * list = {
				   0: [], 
				   1: [], 
				   2: [3, 5], 
				   3: [2, 4], 
				   4: [3, 5], 
				   5: [4, 6, 2], 
				   6: [5]
				}
			 * */
			List<Integer>[] list = new ArrayList[n+1];
			for (int i = 0; i <= n; i++) {
				list[i] = new ArrayList<>();
			}
			
            // 친구 관계 입력
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                list[a].add(b);
                list[b].add(a);
            }
            
            for (int i = 0; i <= n; i++) {
            	System.out.println(i + "번: " + list[i]);
            }
            
            Queue<int[]> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            
            q.add(new int[] {1,0}); //{노드, 깊이}
            visited[1] = true;
            
            int count = 0;
            while(!q.isEmpty()) {
            	int[] cur = q.poll();
            	int node = cur[0];
            	int depth = cur[1];
            	
            	if (depth >= 2) continue;
            	
            	for (int next : list[node]) {
            		if (!visited[next]) {
            			visited[next] = true;
            			count++;
            			q.add(new int[]{next, depth+1})
;            		}
            	}
            }
            
            System.out.println("#" + t + " " + count);
		}

	}

}
