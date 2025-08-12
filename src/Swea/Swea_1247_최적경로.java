package Swea;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Swea_1247_최적경로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int customerNum = sc.nextInt();
			Map<Integer, Integer> company = new HashMap<>();
			Map<Integer, Integer> home = new HashMap<>();
			Map<Integer, Integer> customer = new HashMap<>();
			
			company.put(sc.nextInt(), sc.nextInt());
			home.put(sc.nextInt(), sc.nextInt());
			for(int i = 0; i<customerNum; i++) {
				customer.put(sc.nextInt(), sc.nextInt());
			}
		}
	}
}
