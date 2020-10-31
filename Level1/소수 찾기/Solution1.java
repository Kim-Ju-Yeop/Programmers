package example16;

public class Solution1 {

    public int solution(int n) {
        int minority = 0;

        for (int i = 2; i <= n; i++) {
            int count = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) count++;
                if (count > 3) break;
            }

            if (count == 2) minority++;
        }

        return minority;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(1000000);
    }
}
