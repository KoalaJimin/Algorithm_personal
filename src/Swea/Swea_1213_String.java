package Swea;

import java.util.Scanner;

public class Swea_1213_String {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int h = 0; h < 10; h++) {
	        int test_case = sc.nextInt();
	        String searchWord = sc.next();
	        String allWord = sc.next();
	
	        // split 으로 나누기
	        // -1을 넣어 마지막 빈 문자열도 유지
	        String[] splitArr = allWord.split(searchWord, -1); 
	
	        int count = splitArr.length - 1;
	
	        // 예외 1: 전체 문자열과 searchWord가 완전히 일치하는 경우
	        if (allWord.equals(searchWord)) {
	            count = 1;
	        }
	        // 예외 2: 아예 searchWord가 없는 경우
	        else if (splitArr.length == 1) {
	            count = 0;
	        }
	
	        System.out.println("#" + test_case + " " + count);
		}
	}
}
