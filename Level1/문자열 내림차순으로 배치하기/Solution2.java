package example13;

import java.util.Arrays;

public class Solution2 {

    public String solution(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);

        return new StringBuilder(new String(charArr)).reverse().toString();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution("ZbcdWRWWefag");
    }
}
