package Swea;

import java.util.Scanner;

public class Swea_4839 {
	public static int binarySearch(int allPage, int target) {
		int left = 1;
		int right = allPage;
		int count = 0;
		while (left <= right) { //값이 교차될 때 동안 진행 
			int middle = (left + right) / 2;
			if (middle < target) {
				left = middle;
				count++;
			}
			if (middle > target) {
				right = middle;
				count++;
			}
			if (middle == target) {
				count++;
				return count;
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int allPage = sc.nextInt(); //전체 페이지 수
			int A = sc.nextInt(); //A가 찾을 쪽 번호
			int B = sc.nextInt(); //B가 찾을 쪽 번호
			
			int countA = binarySearch(allPage, A); //A가 페이지를 탐색하게 된 횟수
			int countB = binarySearch(allPage, B); //B가 페이지를 탐색하게 된 횟수
			
			if (countA > countB) {
				System.out.println("#" + test_case + " B");
 			} else if (countB > countA) {
 				System.out.println("#" + test_case + " A");				
			} else {
				System.out.println("#" + test_case + " 0");								
			}
		}
	}
}
