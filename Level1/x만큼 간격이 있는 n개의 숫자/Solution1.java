package example36;

public class Solution1 {

    public long[] solution(int x, int n) {
        long growingX = x;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = growingX;
            growingX += x;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(2, 5);
    }
}
