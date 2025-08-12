package Swea;

import java.util.Scanner;

public class Swea_1926_간단한369게임 {
	private static int have369(String target) {
		int count = 0;
		for(int i = 0; i < target.length(); i++) {
			int targetChar = target.charAt(i);
			if (targetChar == '3') {
				count++;
			} else if (targetChar == '6') {
				count++;
			} else if (targetChar == '9') {
				count++;			
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String result = "";
		for (int i = 1; i <= n; i++) {
			String target = Integer.toString(i);
			int printCount = have369(target);
			if (printCount > 0) {
				for (int j = 0; j<printCount;j++) {
					result += "-";
				}
			} else {
				result += i;
			}
			System.out.print(result);
			System.out.print(" ");
			result = "";
		}
	}
}
