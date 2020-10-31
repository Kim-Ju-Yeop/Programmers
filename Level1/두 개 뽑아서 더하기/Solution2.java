package example21;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};

        Solution2 solution2 = new Solution2();
        solution2.solution(numbers);
    }
}
