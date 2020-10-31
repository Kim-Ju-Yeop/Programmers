package example38;

import java.util.Arrays;

public class Solution2 {

    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            budget -= d[i];

            if (budget < 0) break;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 5, 4 };

        Solution2 solution2 = new Solution2();
        solution2.solution(arr, 9);
    }
}
