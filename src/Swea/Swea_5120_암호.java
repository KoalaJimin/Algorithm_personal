package Swea;

import java.util.LinkedList;
import java.util.Scanner;

//어려움 ㅠㅜ 제미나이랑 같이 풀었으니 꼭 다시 한 번 풀어보기.
//LinkedList 학습 제대로.
public class Swea_5120_암호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // N: 초기 숫자의 개수
            int M = sc.nextInt(); // M: 이동할 칸 수
            int K = sc.nextInt(); // K: 반복 횟수

            LinkedList<Integer> numbers = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                numbers.add(sc.nextInt());
            }

            int currentIdx = 0;
            for (int i = 0; i < K; i++) {
                int listLen = numbers.size(); // 매번 리스트의 길이가 변하므로, 현재 길이를 가져옵니다.
                
                // 새로운 숫자를 삽입할 위치 -> (현재 위치 + 이동할 칸)
                int insertIdx = currentIdx + M;

                // insertIdx가 리스트의 전체 길이를 넘어서면 나머지 연산을 통해 실제 위치를 찾습니다.
                if (insertIdx > listLen) {
                    insertIdx %= listLen;
                }
                
                int newValue;  
                // [경우 1] 삽입 위치가 리스트의 맨 끝인 경우
                if (insertIdx == listLen) { //밀려날 칸이 없음 
                    // 리스트의 마지막 숫자와 첫 번째 숫자를 더해 새 값을 만들기
                    newValue = numbers.get(listLen - 1) + numbers.get(0);
                    // 리스트의 맨 끝에 새 값 추가
                    numbers.add(newValue);
                } 
                // [경우 2] 리스트의 중간 또는 시작 부분에 삽입되는 경우
                else {
                    // 삽입 위치의 이전 숫자 찾기
                    // 만약 삽입 위치가 0이라면 이전 숫자는 리스트의 맨 마지막 숫자
                    int prevNum = (insertIdx == 0) ? numbers.get(listLen - 1) : numbers.get(insertIdx - 1);
                    // 삽입 위치에 '원래 있던 숫자' (뒤로 밀려날 숫자)를 찾습니다.
                    int nextNum = numbers.get(insertIdx);
                    // 두 숫자를 더해 새 값을 만듭니다.
                    newValue = prevNum + nextNum;
                    // 계산된 위치에 새 값을 삽입합니다. (원래 있던 값들은 뒤로 밀려납니다.)
                    numbers.add(insertIdx, newValue);
                }
                
                // 다음 반복을 위해 지정 위치를 방금 삽입한 숫자의 인덱스로 업데이트합니다.
                currentIdx = insertIdx;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");

            int count = 0; 
            // 반복문을 리스트의 마지막 인덱스부터 시작해서 0까지 역순으로 실행합니다.
            for (int i = numbers.size() - 1; i >= 0; i--) {
                // 이미 10개의 숫자를 출력했다면 반복을 중단합니다.
                if (count >= 10) {
                    break;
                }
                sb.append(numbers.get(i)).append(" ");
                count++;
            }
            
            System.out.println(sb);
        }
    }

}
