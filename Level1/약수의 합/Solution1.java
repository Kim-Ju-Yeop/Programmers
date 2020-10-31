package example20;

public class Solution1 {

    public int solution(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(12);
    }
}
