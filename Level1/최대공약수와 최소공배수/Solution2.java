package example30;

public class Solution2 {

    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n, m);
        answer[1] = (n * m) / answer[0];
        return answer;
    }

    public int gcd(int n, int m) {
        if (m == 0) return n;
        return gcd(m, n%m);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(3, 12);
    }
}
