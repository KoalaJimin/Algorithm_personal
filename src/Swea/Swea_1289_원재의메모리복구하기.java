//package Swea;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Swea_1289_원재의메모리복구하기 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		for (int i = 1; i <= n; i++) {
//			String memory = sc.next();
//	        // 문자열을 한 글자씩 배열로 분리
//	        String[] arr = memory.split("");
//	        String[] initial = new String[memory.length()];
//			//초기메모리 세팅
//			for (int j = 0; j < arr.length; j++) {
//				initial[j] = 0;
//			}
//			
//			for (int j = 0; j < arr.length; j++) {
//				if(arr[j] != initial[j]) {
//					
//				}
//			}
//			
//			while(!initial.equals(memory)) {
//				for (int j = 0; j < memory.length(); j++) {
//					if (memory.charAt(j) != initial.charAt(j)) {
//						int k = j;
//						for(k = 0; k < memory.length(); k++) {
//							if (initial.charAt(k) == '0') {
//								initial.charAt(k);
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//
//}
