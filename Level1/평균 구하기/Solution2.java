package example32;

import java.util.Arrays;

public class Solution2 {

    public double solution(int[] arr) {
        return (double) Arrays.stream(arr).average().orElse(0.0);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(arr));
    }
}
