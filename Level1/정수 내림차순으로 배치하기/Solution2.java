package example25;

import java.util.Arrays;

public class Solution2 {
    public long solution(long n) {
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (String a : arr) sb.append(a);

        return Long.parseLong(sb.reverse().toString());
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(118372);
    }
}