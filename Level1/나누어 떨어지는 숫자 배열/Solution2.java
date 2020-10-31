package example9;

import java.util.Arrays;

public class Solution2 {

    public int[] solution(int[] arr, int divisor) {
        return Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        Solution2 solution2 = new Solution2();
        int[] result = solution2.solution(arr, divisor);
    }
}
