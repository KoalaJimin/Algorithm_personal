package Swea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Swea_16546_베이비진 {
	static int isTriple, isRun;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			String s = sc.next();
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i<s.length();i++) {
				list.add(s.charAt(i) - '0');				
			}
			
			Collections.sort(list);
			
			System.out.println("#" + tc + " " + tripleCheck(list));			
			isTriple = 0;
			isRun = 0;
		}
	}
	
	public static boolean tripleCheck(List<Integer> list) {
		for (int i = 0; i <= 3; i += 3) {
			if (list.get(i) == list.get(i+1) && list.get(i) == list.get(i+2)) {
				isTriple++;
			} else if (list.get(i)+1 == list.get(i+1) && list.get(i+1)+1 == list.get(i+2)) {
				isRun++;
			} 
		}
		
		
		if (isTriple + isRun == 2) {
			return true;
		}
		//예외) 112233 -> 트리플 두 개임		
		else if (list.get(0)+1 == list.get(2) && list.get(2)+1 == list.get(4) && list.get(0) == list.get(1) && list.get(2) == list.get(3) && list.get(4) == list.get(5)) { 
			return true;
		} else {
			return false;
		}
	}
}

/*
 * 
import java.util.Scanner;

public class BabyGin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        int[] count = new int[10]; // 카드 숫자 개수 저장
        
        // 카드 입력받아 카운트
        for (int i = 0; i < 6; i++) {
            count[input.charAt(i) - '0']++;
        }
        
        int triplet = 0, run = 0;
        
        // 트리플 체크
        for (int i = 0; i < 10; i++) {
            while (count[i] >= 3) {
                count[i] -= 3;
                triplet++;
            }
        }
        
        // 런 체크
        for (int i = 0; i < 8; i++) { // 0~7까지만 확인
            while (count[i] > 0 && count[i+1] > 0 && count[i+2] > 0) {
                count[i]--; count[i+1]--; count[i+2]--;
                run++;
            }
        }
        
        if (triplet + run == 2) {
            System.out.println("Baby Gin");
        } else {
            System.out.println("Lose");
        }
    }
}
 * 
 * 
 * 
 * */





