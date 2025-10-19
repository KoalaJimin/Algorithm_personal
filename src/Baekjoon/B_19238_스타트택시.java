package Baekjoon;

import java.util.*;

public class B_19238_스타트택시 {
    static int n, m, gas, startX, startY;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> person;
    static List<int[]> arrive;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        gas = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        startX = sc.nextInt() - 1;
        startY = sc.nextInt() - 1;

        person = new ArrayList<>();
        arrive = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            person.add(new int[]{sc.nextInt() - 1, sc.nextInt() - 1});
            arrive.add(new int[]{sc.nextInt() - 1, sc.nextInt() - 1});
        }

        boolean[] served = new boolean[m];

        for (int servedCnt = 0; servedCnt < m; servedCnt++) {
            // ✅ 1️⃣ 현재 택시 위치에서 BFS 1회만 돌려 모든 승객 거리 구함
            int[][] distFromTaxi = bfsAll(startX, startY);
            
            int closePersonIndex = -1;
            int minDist = Integer.MAX_VALUE;
            int bestR = Integer.MAX_VALUE;
            int bestC = Integer.MAX_VALUE;

            for (int i = 0; i < m; i++) {
                if (served[i]) continue;
                int pr = person.get(i)[0];
                int pc = person.get(i)[1];
                int d = distFromTaxi[pr][pc];
                if (d == -1) continue;
                if (d < minDist || (d == minDist && (pr < bestR || (pr == bestR && pc < bestC)))) {
                    minDist = d;
                    bestR = pr;
                    bestC = pc;
                    closePersonIndex = i;
                }
            }

            if (closePersonIndex == -1 || minDist > gas) {
                System.out.println(-1);
                return;
            }

            // 승객 위치로 이동
            gas -= minDist;
            startX = person.get(closePersonIndex)[0];
            startY = person.get(closePersonIndex)[1];

            // ✅ 2️⃣ 승객 → 목적지 BFS 1회
            int[][] distToDest = bfsAll(startX, startY);
            int need = distToDest[arrive.get(closePersonIndex)[0]][arrive.get(closePersonIndex)[1]];
            if (need == -1 || need > gas) {
                System.out.println(-1);
                return;
            }

            gas -= need;
            gas += need * 2;

            startX = arrive.get(closePersonIndex)[0];
            startY = arrive.get(closePersonIndex)[1];
            served[closePersonIndex] = true;
        }

        System.out.println(gas);
    }

    // ✅ BFS 한 번으로 모든 칸까지 거리 계산 (최단거리 테이블 반환)
    private static int[][] bfsAll(int x, int y) {
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        dist[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int h = 0; h < 4; h++) {
                int nx = r + dx[h];
                int ny = c + dy[h];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (map[nx][ny] == 1 || dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[r][c] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        return dist;
    }
}


//package Baekjoon;
//
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Deque;
//import java.util.List;
//import java.util.Scanner;
//
//public class B_19238_스타트택시 {
//	static int n, m, gas, startX, startY;
//	static int[][] map;
//	static int[][] dist;
//	static boolean[][] visited;
//	static List<int[]> person;
//	static List<int[]> arrive;
//	static int[] dx = {-1, 1, 0, 0};
//	static int[] dy = {0, 0, -1, 1};
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		//입력 
//		// 0 길 / 1 벽
//		n = sc.nextInt();
//		m = sc.nextInt();
//		gas = sc.nextInt();
//		
//		map = new int[n][n];
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				map[i][j] = sc.nextInt();
//			}
//		}
//		
//		//처음 출발지점
//		startX = sc.nextInt() - 1;
//		startY = sc.nextInt() - 1;
//		
//		person = new ArrayList<>();
//		arrive = new ArrayList<>();
//		for (int i = 0; i < m; i++) {
//			person.add(new int[] {sc.nextInt() - 1, sc.nextInt() - 1});
//			arrive.add(new int[] {sc.nextInt() - 1, sc.nextInt() - 1});
//		}
//		
//		boolean[] served = new boolean[m];		
//        // 모든 승객 처리
//        for (int servedCnt = 0; servedCnt < m; servedCnt++) {
//        	// 출발지점부터 가까운 사람 먼저 찾기 - 최단거리 (리스트 방식 유지)
//        	List<Integer> li = new ArrayList<>();
//        	for (int i = 0; i < m; i++) {
//        		// 이미 태운 승객이면 후보에서 제외
//        	    if (served[i]) {               
//        	        li.add(Integer.MAX_VALUE);
//        	        continue;
//        	    }
//        	    
//        	    // 여기서는 모든 승객이 아직 안 태워졌다는 전제 하에 작성
//        	    int pr = person.get(i)[0];
//        	    int pc = person.get(i)[1];
//        	    int d = bfs(startX, startY, pr, pc); // 출발 -> 사람 위치 거리
//        	    if (d == -1) li.add(Integer.MAX_VALUE); // 도달 불가 표시
//        	    else li.add(d);
//        	}
//
//        	// 가장 가까운 거리 값
//        	int minDist = Collections.min(li);
//        	if (minDist == Integer.MAX_VALUE) {
//        	    System.out.println(-1); // 갈 수 있는 승객이 없음
//        	    return;
//        	}
//
//        	// 같은 거리 여러명일 때 행,열 작은 순으로 선택
//        	int closePersonIndex = -1;
//        	int bestR = Integer.MAX_VALUE, bestC = Integer.MAX_VALUE;
//        	for (int i = 0; i < m; i++) {
//        	    if (li.get(i) != minDist) continue;
//        	    int pr = person.get(i)[0];
//        	    int pc = person.get(i)[1];
//        	    if (pr < bestR || (pr == bestR && pc < bestC)) {
//        	        bestR = pr;
//        	        bestC = pc;
//        	        closePersonIndex = i;
//        	    }
//        	}
//
//        	// 연료 체크: 승객까지 가는 데 연료 부족하면 실패
//        	if (minDist > gas) {
//        	    System.out.println(-1);
//        	    return;
//        	}
//
//        	// 승객까지 이동
//        	gas -= minDist;
//        	startX = person.get(closePersonIndex)[0];
//        	startY = person.get(closePersonIndex)[1];
//
//        	// 목적지까지 거리 계산
//        	int need = bfs(startX, startY, arrive.get(closePersonIndex)[0], arrive.get(closePersonIndex)[1]);
//        	if (need == -1 || need > gas) {
//        	    System.out.println(-1);
//        	    return;
//        	}
//
//        	// 목적지 이동: 연료 차감 후 보상
//        	gas -= need;
//        	gas += need * 2;
//
//        	// 택시 위치 갱신
//        	startX = arrive.get(closePersonIndex)[0];
//        	startY = arrive.get(closePersonIndex)[1];
//
//        	// 한 명 처리했으니 served[closePersonIndex] = true; 로 표시해서 다음 반복에서 같은 사람을 다시 뽑지 않도록
//        	served[closePersonIndex] = true;
//        }
//
//        // 모두 처리 성공
//        System.out.println(gas);		
//	}
//
//	private static int bfs(int x, int y, int arriveX, int arriveY) {
//		visited = new boolean[n][n];
//		dist = new int[n][n];
//		
//		Deque<int[]> q = new ArrayDeque<>();
//		q.add(new int[] {x,y});
//		visited[x][y] = true;
//		dist[x][y] = 0;
//		
//		while(!q.isEmpty()) {
//			int[] cur = q.poll();
//			int r = cur[0];
//			int c = cur[1];
//			
//			// 도달
//			if (r == arriveX && c == arriveY) {
//				return dist[r][c];
//			}
//			
//			for (int h = 0; h < 4; h++) {
//				int nx = r + dx[h];
//				int ny = c + dy[h];
//				
//				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
//				if (visited[nx][ny] || map[nx][ny] == 1) continue;
//				
//				visited[nx][ny] = true;
//				dist[nx][ny] = dist[r][c] + 1;
//				q.offerLast(new int[] {nx, ny}); //다음으로 확장 
//			}
//		}
//		
//		return -1; //도달 불가
//	}
//
//}