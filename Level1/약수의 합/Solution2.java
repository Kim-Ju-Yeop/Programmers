package example20;

public class Solution2 {

    public int solution(int n) {
        int result = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) result += i;
        }

        result += n;
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(12);
    }
}
