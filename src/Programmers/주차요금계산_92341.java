package Programmers;

import java.util.*;

public class 주차요금계산_92341 {

	public static void main(String[] args) {

		주차요금계산_92341 s = new 주차요금계산_92341();

		// 테스트 입력
		int[] fees = {180, 5000, 10, 600};
		String[] records = {
				"05:34 5961 IN",
				"06:00 0000 IN",
				"06:34 0000 OUT",
				"07:59 5961 OUT",
				"07:59 0148 IN",
				"18:59 0000 IN",
				"19:09 0148 OUT",
				"22:59 5961 IN",
				"23:00 5961 OUT"
		};

		int[] result = s.solution(fees, records);

		System.out.println(Arrays.toString(result));
	}

	public int[] solution(int[] fees, String[] records) {
		int baseTime = fees[0];
		int baseFee = fees[1];
		int unitTime = fees[2];
		int unitFee  = fees[3];

		Map<String, Integer> totalTime = new HashMap<>();
		Map<String, Integer> inTime = new HashMap<>();

		for (String record : records) {
			String[] arr = record.split(" ");
			String time = arr[0];
			String car  = arr[1];
			String type = arr[2];

			int minutes = convertToMin(time);

			if (type.equals("IN")) {
				inTime.put(car, minutes);
			} else {
				int diff = minutes - inTime.get(car);
				totalTime.put(car, totalTime.getOrDefault(car, 0) + diff);
				inTime.remove(car);
			}
		}

		int lastTime = convertToMin("23:59");
		for (String car : inTime.keySet()) {
			int diff = lastTime - inTime.get(car);
			totalTime.put(car, totalTime.getOrDefault(car, 0) + diff);
		}

		List<String> carList = new ArrayList<>(totalTime.keySet());
		Collections.sort(carList);

		int[] answer = new int[carList.size()];

		for (int i = 0; i < carList.size(); i++) {
			int time = totalTime.get(carList.get(i));
			answer[i] = calculateFee(time, baseTime, baseFee, unitTime, unitFee);
		}

		return answer;
	}

	private int convertToMin(String time) {
		String[] t = time.split(":");
		return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
	}

	private int calculateFee(int time, int baseTime, int baseFee, int unitTime, int unitFee) {
		if (time <= baseTime) return baseFee;
		return baseFee + (int) Math.ceil((time - baseTime) / (double) unitTime) * unitFee;
	}
}
