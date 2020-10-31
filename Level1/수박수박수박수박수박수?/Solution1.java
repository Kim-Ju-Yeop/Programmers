package example17;

public class Solution1 {
    public String solution(int n) {
        String start = "수";
        String end = "박";

        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) answer.append(start);
            else answer.append(end);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(5);
    }
}
