package example9;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {

    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int value : arr) {
            if (value % divisor == 0) answer.add(value);
        }

        int[] result;
        if (answer.size() == 0) {
            result = new int[]{-1};
        } else {
            result = new int[answer.size()];

            for (int i = 0; i < answer.size(); i++) {
                result[i] = answer.get(i);
            }
            Arrays.sort(result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        Solution1 solution1 = new Solution1();
        int[] result = solution1.solution(arr, divisor);
    }
}
