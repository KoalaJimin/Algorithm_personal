package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B_1759_암호만들기_조합_다시풀어 {
	static int l, c;
	static String[] arr;
	static String[] selected;
	public static void main(String[] args) {
		// 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
		// 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열
		// 암호로 사용했을 법한 문자의 종류는 C가지
		// 가능성 있는 암호들을 모두 구하는 프로그램을 작성
		
		Scanner sc = new Scanner(System.in);
		
		l = sc.nextInt();
		c = sc.nextInt();
		arr = new String[c];
		selected = new String[l];
		
        for (int i = 0; i < c; i++) {
            arr[i] = sc.next();
        }
        
        Arrays.sort(arr);
		comb(0,0);		
	}
	
	private static void comb(int start, int depth) {
		if (depth == l) {
			if (checkSelected()) {
			    for (String s : selected) {
			        System.out.print(s);
			    }
			    System.out.println();
			}
			return;
		}
		
		for (int i = start; i < c; i++) {
			selected[depth] = arr[i];
			comb(i+1, depth+1);
		}
		
	}

	private static boolean checkSelected() {
	    int vowel = 0, consonant = 0;
	    for (String s : selected) {
	        if (isVowel(s)) vowel++;
	        else consonant++;
	    }
	    return vowel >= 1 && consonant >= 2;
	}
	
	private static boolean isVowel(String s) {
	    return "aeiou".contains(s);
	}

}
