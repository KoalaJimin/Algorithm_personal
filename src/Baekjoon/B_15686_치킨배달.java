package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_15686_치킨배달 {
	static int N, M, pickChickenCount, n, r;
	static int[][] arr;
	static List<int[]> house;
	static List<int[]> chicken;
	static List<int[]> selected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();		
		arr = new int[N][N];
		pickChickenCount = M;
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		selected = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				
				// 좌표 저장 [ 0 빈칸 / 1 집 / 2 치킨집 ]
				if (arr[i][j] == 1) {
					house.add(new int[]{i,j});
				} else if (arr[i][j] == 2) {
					chicken.add(new int[]{i,j});
				}
			}
		}
		
		//로직 
		//임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.
		//치킨 거리는 집과 가장 가까운 치킨집 사이의 거리
		//즉, 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있다. 
		//도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.
		
		//살릴 치킨 집 개수가 지금 지도 상에 있는 치킨 집 개수보다 많을 때 
		//일단 어떤 치킨 집을 살릴지 골라야돼서 
		//조합으로 치킨 집 뽑아서 저장 하려고 
		//치킨 집 뽑는 함수 => pickChickenComb()
		if (chicken.size() > M) {
			int n = chicken.size();
			int r = M;
			pickChickenComb(0 , 0); 
		}
	}
	
	// 조합 뽑기
	static void pickChickenComb(int start, int depth) {
	    if (depth == M) { 
	        // 선택된 치킨집 출력
	        System.out.print("선택된 치킨집: ");
	        for (int[] c : selected) {   // selected 안에는 int[]가 들어있음
	            System.out.print("(" + c[0] + "," + c[1] + ") ");
	        }
	        System.out.println();

	        // M개 선택 완료 → 도시 치킨 거리 계산
	        // calcChickenDist();
	        return;
	    }

	    for (int i = start; i < chicken.size(); i++) {
	        selected.add(chicken.get(i));       // i번째 치킨집 선택
	        pickChickenComb(i + 1, depth + 1);  // 다음 조합 뽑기
	        selected.remove(selected.size() - 1);  // 백트래킹
	    }
	}

	
	static void calcChickenDist() {
		
	}

}
