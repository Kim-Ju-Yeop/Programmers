package example25;

import java.util.Arrays;

public class Solution1 {
    public long solution(long n) {
        String stringN = String.valueOf(n);
        long[] data = new long[stringN.length()];

        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(String.valueOf(stringN.charAt(i)));
        }

        Arrays.sort(data);
        StringBuilder answer = new StringBuilder();

        for (int i = data.length-1; i >= 0; i--) {
            answer.append(data[i]);
        }
        return Long.parseLong(answer.toString());
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(118372);
    }
}
