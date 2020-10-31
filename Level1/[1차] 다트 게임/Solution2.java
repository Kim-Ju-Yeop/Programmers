package example41;

import java.util.Stack;

public class Solution2 {

    public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                sum = (c - '0');
                if (sum == 1 && i < dartResult.length() - 1 && dartResult.charAt(i + 1) == 0) {
                    sum = 10;
                    i++;
                }
                stack.push(sum);
            } else {
                int prev = stack.pop();
                if (c == 'D') prev *= prev;
                else if (c == 'T') prev = prev * prev * prev;
                else if (c == '*') {
                    if (!stack.isEmpty()) {
                        int val = stack.pop() * 2;
                        stack.push(val);
                    }
                    prev *= 2;
                } else if (c == '#') {
                    prev *= (-1);
                }
                stack.push(prev);
            }
        }
        int totalScore = 0;
        while(!stack.isEmpty()) {
            totalScore += stack.pop();
        }
        return totalScore;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution("1D2S3T*");
    }
}
