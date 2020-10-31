package example21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

    public int[] solution(int[] numbers) {
        List<Integer> allData = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                allData.add(numbers[i] + numbers[j]);
            }
        }
        for (Integer data : allData) {
            if (!result.contains(data)) result.add(data);
        }

        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};

        Solution1 solution1 = new Solution1();
        solution1.solution(numbers);
    }
}
