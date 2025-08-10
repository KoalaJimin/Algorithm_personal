package Baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Baekjoon_1914_하노이의탑_재귀 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// Math 함수를 이용해 2의 n제곱 값을 구함
		System.out.println((int) Math.pow(2, n) - 1);
		int moves = (int)Math.pow(2, n) - 1; //하노이탑 총 이동 횟수
 		// BigInteger를 사용한 이동횟수 출력
//		System.out.println(new BigInteger("2").pow(n).subtract(BigInteger.ONE));
		// n이 20 이하에서만 수행 순서를 출력하도록 변경
		if (n <= 20) {
			hanoi(n, 1, 3, 2);
		}
	}

	public static void hanoi(int n, int start, int end, int aux) {
		if (n == 1) {
			System.out.println(start + " " + end);
			return;
		}
		hanoi(n-1, start, aux, end);
		System.out.println(start + " " + end);
		hanoi(n-1, aux, end, start);
	}
}
