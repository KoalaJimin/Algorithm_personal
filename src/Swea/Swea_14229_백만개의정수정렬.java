package Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Swea_14229_백만개의정수정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1000000];
        int idx = 0;

        // 100만 개 입력 받기 (여러 줄 고려)
        while (idx < 1000000) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        // 퀵정렬 실행
        quickSort(arr, 0, arr.length - 1);

        // 500000번째 값 출력
        System.out.println(arr[500000]);
    }

    // 퀵정렬 구현
    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = arr[(left + right) / 2]; // 중간 값 피벗
        int l = left, r = right;

        while (l <= r) {
            while (arr[l] < pivot) l++;
            while (arr[r] > pivot) r--;
            if (l <= r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }

        quickSort(arr, left, r);
        quickSort(arr, l, right);
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}


//package Swea;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Swea_14229_백만개의정수정렬 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int[] arr = new int[1000000];
//        int idx = 0;
//
//        // 입력이 여러 줄로 들어올 수 있으므로 while 사용
//        while (idx < 1000000) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            while (st.hasMoreTokens()) {
//                arr[idx++] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        Arrays.sort(arr);
//        System.out.println(arr[500000]);
//    }
//}


//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Swea_14229_백만개의정수정렬 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] arr = new int[1000000]; // 100만개 저장할 배열
//
//        for (int i = 0; i < 1000000; i++) {
//            arr[i] = sc.nextInt();   // 입력 받기
//        }
//
//        Arrays.sort(arr);             // 정렬
//        System.out.println(arr[500000]); // 가운데 값 출력
//    }
//}


//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class Swea_14229_백만개의정수정렬 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		List<Integer> l = new ArrayList<>();
//		
//		for (int i = 0; i < 1000000; i++) {
//			l.add(sc.nextInt());
//		}
//		
//		Collections.sort(l);
//		
//		System.out.println(l.get(500000));
//	}
//}
